package app.transformations;

import app.enums.AxisEnum;
import app.extra.CartesianPlane;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Transparency;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Methods for image transformations.
 * 
 * @author Luis Thiago <lthiago.github.io>
 */
public class TransformationsImage {

    private static TransformationsImage instance;
    private double[] centerPixelOrigin = new double[]{0, 0};
    private double[][] matrixM;

    private TransformationsImage() {
    }

    public static synchronized TransformationsImage getInstance() {
        if (instance == null) {
            instance = new TransformationsImage();
        }
        return instance;
    }

    /**
     * It applies translation to the object passed as parameter and according to the translation factors.
     */
    public void translation(Image img, double tx, double ty) {
        double[][] matrixM = new double[img.getWidth()][img.getHeight()];
        try {
            double[][] pixels;
            for (int i = 0; i < img.getWidth(); i++) {
                for (int j = 0; j < img.getHeight(); j++) {
                    pixels = new double[1][3];
                    pixels[0][0] = i;
                    pixels[0][1] = j;
                    pixels[0][2] = 1;

                    int width = img.getWidth() / 2;
                    int height = img.getHeight() / 2;

                    int xt = i - width;
                    int yt = j - height;

                    double[][] transformed = new double[1][3];

                    // transfer
                    matrixM = Matrix.multipliesMatrices(pixels, generateTranslationMatrix(tx, ty));

                    int pixelX = (int) transformed[0][0];
                    int pixelY = (int) transformed[0][1];

                    // Transform the pixel.
                    if (pixelX < img.getWidth() && pixelX > 0 && pixelY < img.getHeight() && pixelY > 0) {
                        matrixM[pixelX][pixelY] = img.getPixelMatrix()[i][j];
                    }

                    // Keep the origin.
                    if ((int) (img.getWidth() / 2) == i && (int) (img.getHeight() / 2) == j) {
                        centerPixelOrigin = new double[]{i - pixelX, j - pixelY};
                    }
                }
            }
            CartesianPlane.getInstance().drawImage(img.getPixelMatrix(), matrixM);
        } catch (Exception ex) {
            Logger.getLogger(TransformationsImage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Applies a rotation to the object passed as parameter, according to the angle.
     */
    public void rotation(Image image, double angle) {
        int width = image.getBufferedImage().getWidth();
        int height = image.getBufferedImage().getHeight();

        image.setBufferedImage(treatImage(image));

        /**
         * Apply translation using AffineTransform
         */
        CartesianPlane panel = CartesianPlane.getInstance();
        Graphics2D g2d = (Graphics2D) panel.getGraphics();
        panel.redraw();

        BufferedImage img = rotate(image.getBufferedImage(), angle);
        g2d.drawImage(img, panel.getCenterXValue(), panel.getCenterYValue() - height, null);
    }

    public BufferedImage rotate(BufferedImage image, double angle) {
        double sin = Math.abs(Math.sin(angle)), cos = Math.abs(Math.cos(angle));
        int w = image.getWidth(), h = image.getHeight();
        int newW = (int) Math.floor(w * cos + h * sin), newh = (int) Math.floor(h * cos + w * sin);
        GraphicsConfiguration gc = getDefaultConfiguration();
        BufferedImage result = gc.createCompatibleImage(newW, newh, Transparency.TRANSLUCENT);
        Graphics2D g = result.createGraphics();
        g.translate((newW - w) / 2, (newh - h) / 2);
        g.rotate(angle, w / 2, h / 2);
        g.drawRenderedImage(image, null);
        g.dispose();
        return result;
    }

    private GraphicsConfiguration getDefaultConfiguration() {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice gd = ge.getDefaultScreenDevice();
        return gd.getDefaultConfiguration();
    }

    /**
     * Applies scale to the object passed as parameter, according to the scale factors.
     */
    public void scale(Image image, double sx, double sy) {
        double xFactor = image.getWidth() * sx;
        double yFactor = image.getHeight() * sy;

        int width = (int) xFactor;
        int height = (int) yFactor;

        /**
         * Apply translation using AffineTransform
         */
        CartesianPlane panel = CartesianPlane.getInstance();
        Graphics2D g2d = (Graphics2D) panel.getGraphics();
        panel.redraw();

        image.setBufferedImage(treatImage(image));

        BufferedImage after = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        AffineTransform at = new AffineTransform();
        at.scale(sx, sy);
        AffineTransformOp scaleOp = new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
        after = scaleOp.filter(image.getBufferedImage(), after);

        g2d.drawImage(after, panel.getCenterXValue(), panel.getCenterYValue() - height, null);
    }

    /**
     * Applies reflection to the object passed as parameter, according to the chosen axis.
     */
    public void reflection(Image image, String axis) {
        BufferedImage bufferedImage = treatImage(image);
        AffineTransform tx = AffineTransform.getScaleInstance(1, -1);
        tx.translate(0, -image.getBufferedImage().getHeight(null));
        AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
        bufferedImage = op.filter(bufferedImage, null);

        tx = AffineTransform.getScaleInstance(-1, 1);
        tx.translate(-bufferedImage.getWidth(null), 0);
        op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
        bufferedImage = op.filter(bufferedImage, null);
        CartesianPlane panel = CartesianPlane.getInstance();
        Graphics2D g2d = (Graphics2D) panel.getGraphics();
        panel.redraw();
        g2d.drawImage(bufferedImage, panel.getCenterXValue(), panel.getCenterYValue() - bufferedImage.getHeight(), null);
    }

    /**
     * Applies shear to the object passed as parameter, according to the factors a and b.
     */
    public void shear(Image image, double cx, double cy) {
        double xFactor = image.getWidth() * cx;
        double yFactor = image.getHeight() * cy;

        /**
         * Apply translation using AffineTransform
         */
        CartesianPlane panel = CartesianPlane.getInstance();
        Graphics2D g2d = (Graphics2D) panel.getGraphics();
        panel.redraw();

        image.setBufferedImage(treatImage(image));

        AffineTransform at = new AffineTransform();
        at.translate(panel.getCenterXValue() + image.getWidth() * cx, panel.getCenterYValue() - image.getHeight());
        at.shear(-cx, -cy);

        g2d.drawImage(image.getBufferedImage(), at, null);
    }
    
    /**
     * Generate translation matrix.
     */
    public double[][] generateTranslationMatrix(double tx, double ty) {
        double[][] matrix = new double[3][3];

        matrix[0][0] = 1;
        matrix[0][1] = 0;
        matrix[0][2] = tx;

        matrix[1][0] = 0;
        matrix[1][1] = 1;
        matrix[1][2] = ty;

        matrix[2][0] = 0;
        matrix[2][1] = 0;
        matrix[2][2] = 1;

        return matrix;
    }

    /**
     * Generate scale matrix.
     */
    public double[][] generateScaleMatrix(double sx, double sy) {
        double[][] matrix = new double[3][3];
        sx = (sx == 0) ? 1 : sx;
        sy = (sy == 0) ? 1 : sy;

        matrix[0][0] = sx;
        matrix[1][0] = 0;
        matrix[2][0] = 0;

        matrix[0][1] = 0;
        matrix[1][1] = sy;
        matrix[2][1] = 0;

        matrix[0][2] = 0;
        matrix[1][2] = 0;
        matrix[2][2] = 1;

        return matrix;
    }

    /**
     * Generates rotation matrix.
     */
    public double[][] generateRotationMatrix(double angle) {
        double[][] matrix = new double[3][3];

        double sin = Math.sin(Math.toRadians(angle));
        double cos = Math.cos(Math.toRadians(angle));

        // Column 0
        matrix[0][0] = cos;
        matrix[1][0] = sin;
        matrix[2][0] = 0;

        // Column 1
        matrix[0][1] = -sin;
        matrix[1][1] = cos;
        matrix[2][1] = 0;

        // Column 2
        matrix[0][2] = 0;
        matrix[1][2] = 0;
        matrix[2][2] = 1;

        return matrix;
    }

    /**
     * Generate reflection matrix around the axis passed as parameter X, Y or X and Y.
     */
    public double[][] generateReflectionMatrix(String axis) {
        double[][] matrix = new double[3][3];

        axis = axis.toUpperCase();

        // Rotation in XY
        matrix[0][0] = -1;
        matrix[1][0] = 0;
        matrix[2][0] = 0;

        matrix[0][1] = 0;
        matrix[1][1] = -1;
        matrix[2][1] = 0;

        matrix[0][2] = 0;
        matrix[1][2] = 0;
        matrix[2][2] = 1;

        // X-rotation
        if (axis.equals(AxisEnum.X.getValue())) {
            matrix[0][0] = 1;
        } else if (axis.equals(AxisEnum.Y.getValue())) {
            matrix[1][1] = 1;
        }

        return matrix;
    }

    /**
     * Generates shear matrix.
     */
    public double[][] generateShearMatrix(double cx, double cy) {
        double[][] matrix = new double[3][3];

        matrix[0][0] = 1;
        matrix[1][0] = cy;
        matrix[2][0] = 0;

        matrix[0][1] = cx;
        matrix[1][1] = 1;
        matrix[2][1] = 0;

        matrix[0][2] = 0;
        matrix[1][2] = 0;
        matrix[2][2] = 1;

        return matrix;
    }

    private BufferedImage treatImage(Image image) {
        BufferedImage bufferedImg = new BufferedImage(image.getBufferedImage().getWidth(), image.getBufferedImage().getHeight(), BufferedImage.TYPE_INT_RGB);
        for (int row = 0; row < image.getBufferedImage().getWidth(); row++) {
            for (int col = 0; col < image.getBufferedImage().getHeight(); col++) {
                // Prepara a imagem para ser desenhada no jpanel
                if (row < 256 && col < 256) {
                    bufferedImg.setRGB(row, col, CartesianPlane.getInstance().getPixelColor(image.getPixelMatrix()[row][col]));
                }
            }
        }
        return bufferedImg;
    }
}