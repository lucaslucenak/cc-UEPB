package app.extra;

import app.lines.Pixel;
import app.lines.Rasterization;
import app.transformations.Image;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.List;

/**
 * It represents a Cartesian plane and implements all the functionalities it is responsible for.
 *
 * @author Luis Thiago <lthiago.github.io>
 */
public class CartesianPlane extends JPanel {

    private static CartesianPlane instance;
    
    private CartesianPlane() {
    }

    /**
     * Provides single instance of the Cartesian Plane
     */
    public static synchronized CartesianPlane getInstance() {
        if (instance == null) {
            instance = new CartesianPlane();
        }
        return instance;
    }

    /**
     * Returns the width/length of the Cartesian plane.
     */
    public int getWidth() {
        return super.getWidth();
    }

    /**
     * Returns the height of the Cartesian plane.
     */
    public int getHeight() {
        return super.getHeight();
    }

    /**
     * Returns the central value X (width/2)
     */
    public int getCenterXValue() {
        return getWidth() / 2;
    }

    /**
     * Returns the center value Y (height/2)
     */
    public int getCenterYValue() {
        return getHeight() / 2;
    }
    
    /**
     * Returns the RGB value according to the pixel value
     */
    public int getPixelColor(int corRGB) {
        return new Color(corRGB, corRGB, corRGB).getRGB();
    }

    /**
     * Draw the Cartesian plane.
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        this.setBackground(Color.WHITE);
       
        // x-axis
        Rasterization.getInstance().midpointMethod(new Pixel(-getWidth()/2,0), new Pixel(getWidth()/2,0), Color.LIGHT_GRAY, null);
        // y-axis
        Rasterization.getInstance().midpointMethod(new Pixel(0, -getHeight()/2), new Pixel(0, getHeight()/2), Color.LIGHT_GRAY, null);
    }

    /**
     * Redraws the Cartesian plane. Useful when you want to delete objects drawn on it.
     */
    public void redraw() {
        if (instance != null) {
            instance.getGraphics().clearRect(0, 0, this.getWidth(), this.getHeight());
            this.paint(this.getGraphics()); // Draw the Cartesian plane again
        }
    }

    /**
     * Draw the Z axis on the Cartesian plane.
     */
    public void drawZAxis() {
        Rasterization.getInstance().midpointMethod(new Pixel(0, 0), new Pixel(-getHeight(), -getHeight()), Color.LIGHT_GRAY, null);
        Rasterization.getInstance().midpointMethod(new Pixel(0, 0), new Pixel(getHeight(), getHeight()), Color.LIGHT_GRAY, null);
    }

    /**
     * Redraws 3D space. Useful when you want to delete the objects drawn on it.
     */
    public void redraw3D() {
        redraw();
        drawZAxis();
    }

    /**
     * Draws the pixel on the Cartesian plane according to the parameters. NOTE: The points are not normalized.
     */
    public void drawPixel(int x, int y, Color color) {
        Graphics g = super.getGraphics();
        g.setColor(color);
        g.fillRect(x, y, 1, 1); // lights up one pixel (x,y) in the plane.
    }

    /**
     * Draw a pixel in the Cartesian plane according to the parameters. NOTE: The points are normalized!
     */
    public void drawPixel(double x, double y, Color color) {
        x = (x + CartesianPlane.getInstance().getCenterXValue());
        y = (CartesianPlane.getInstance().getCenterYValue() - y);
        drawPixel(Math.round((float) x), Math.round((float) y), color);
    }

    /**
     * Draw a 2D object in the Cartesian plane.
     */
    public void drawObjeto2D(double[][] matrixObject, Color color) {
        redraw();
        Rasterization rast = Rasterization.getInstance();
        
        rast.midpointMethod(new Pixel(matrixObject[0][0], matrixObject[1][0]), new Pixel(matrixObject[0][1], matrixObject[1][1]), color, null);
        rast.midpointMethod(new Pixel(matrixObject[0][1], matrixObject[1][1]), new Pixel(matrixObject[0][2], matrixObject[1][2]), color, null);
        rast.midpointMethod(new Pixel(matrixObject[0][2], matrixObject[1][2]), new Pixel(matrixObject[0][3], matrixObject[1][3]), color, null);
        rast.midpointMethod(new Pixel(matrixObject[0][3], matrixObject[1][3]), new Pixel(matrixObject[0][0], matrixObject[1][0]), color, null);  
    }

    /**
     * Draws 3D object in space.
     */
    public void drawObjeto3D(double[][] matrixObject3D, Color color) {
        redraw3D();
        Rasterization rast = Rasterization.getInstance();

        double centerCubeFactor = 0; // matrixObject3D[0][4]/2; // (depth / 2)/2
        Pixel A = new Pixel(matrixObject3D[0][0] - centerCubeFactor, matrixObject3D[1][0] - centerCubeFactor, matrixObject3D[2][0] - centerCubeFactor);
        Pixel B = new Pixel(matrixObject3D[0][1] - centerCubeFactor, matrixObject3D[1][1] - centerCubeFactor, matrixObject3D[2][1] - centerCubeFactor);
        Pixel C = new Pixel(matrixObject3D[0][2] - centerCubeFactor, matrixObject3D[1][2] - centerCubeFactor, matrixObject3D[2][2] - centerCubeFactor);
        Pixel D = new Pixel(matrixObject3D[0][3] - centerCubeFactor, matrixObject3D[1][3] - centerCubeFactor, matrixObject3D[2][3] - centerCubeFactor);
        Pixel E = new Pixel(matrixObject3D[0][4] - centerCubeFactor, matrixObject3D[1][4] - centerCubeFactor, matrixObject3D[2][4] - centerCubeFactor);
        Pixel F = new Pixel(matrixObject3D[0][5] - centerCubeFactor, matrixObject3D[1][5] - centerCubeFactor, matrixObject3D[2][5] - centerCubeFactor);
        Pixel G = new Pixel(matrixObject3D[0][6] - centerCubeFactor, matrixObject3D[1][6] - centerCubeFactor, matrixObject3D[2][6] - centerCubeFactor);
        Pixel H = new Pixel(matrixObject3D[0][7] - centerCubeFactor, matrixObject3D[1][7] - centerCubeFactor, matrixObject3D[2][7] - centerCubeFactor);

        // Draws using the Medium Pixel rasterization algorithm
        rast.midpointMethod(A, B, color, null);
        rast.midpointMethod(B, C, color, null);
        rast.midpointMethod(C, D, color, null);
        rast.midpointMethod(D, A, color, null);
        rast.midpointMethod(E, F, color, null);
        rast.midpointMethod(F, G, color, null);
        rast.midpointMethod(G, H, color, null);
        rast.midpointMethod(H, E, color, null);
        rast.midpointMethod(A, E, color, null);
        rast.midpointMethod(B, F, color, null);
        rast.midpointMethod(C, G, color, null);
        rast.midpointMethod(D, H, color, null);
    }
    
    /**
     * Draw the ViewPort on the Cartesian plane.
     */
    public void drawViewport(List<Pixel> pixelList) {
        this.redraw();
        Rasterization rast = Rasterization.getInstance();
       
        rast.midpointMethod(pixelList.get(0), pixelList.get(1), Color.BLACK, null);
        rast.midpointMethod(pixelList.get(1), pixelList.get(2), Color.BLACK, null);
        rast.midpointMethod(pixelList.get(2), pixelList.get(3), Color.BLACK, null);
        rast.midpointMethod(pixelList.get(3), pixelList.get(0), Color.BLACK, null);
    }
    
    /**
     * Draw image on the Cartesian plane.
     */
    public void drawImage(Image img) {
        BufferedImage bufferedImg = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_RGB);
        for (int row = 0; row < img.getWidth(); row++) {
            for (int col = 0; col < img.getHeight(); col++) {
                // Prepares the image to be drawn in the jpanel
                bufferedImg.setRGB(row, col, getPixelColor(img.getPixelMatrix()[row][col]));
            }
        }
        this.drawImage(bufferedImg);
    }

    /**
     * Draw the image on the Cartesian plane
     */
    public void drawImage(int[][] imageMatrix, double[][] matrixPosition) {
        redraw();
        
        BufferedImage bufferedImg = new BufferedImage(imageMatrix.length, imageMatrix.length, BufferedImage.TYPE_INT_RGB);
        for (int row = 0; row < bufferedImg.getWidth(); row++) {
            for (int col = 0; col < bufferedImg.getHeight(); col++) {
                // Prepares the image to be drawn in the jpanel
                bufferedImg.setRGB(col, row, getPixelColor((int) imageMatrix[row][col]));
            }
        }
        this.drawImage(bufferedImg);
    }

    /**
     * Draw image on the Cartesian plane.
     */
    public void drawImage(BufferedImage bufferedImg) {
        redraw();
        this.getGraphics().drawImage(bufferedImg, getCenterXValue(), getCenterYValue() - bufferedImg.getHeight(), null);
    }

    /**
     * Takes the image to be processed and the AffineTransform containing the
     * transformations on the image and draws it in the Cartesian plane.
     */
    public void drawImage(Image img, AffineTransform affineTransform) {
        BufferedImage bufferedImg = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_RGB);

        for (int row = 0; row < img.getBufferedImage().getWidth(); row++) {
            for (int col = 0; col < img.getBufferedImage().getHeight(); col++) {
                // Prepares the image to be drawn in the jpanel
                if (row < 256 && col < 256) {
                    bufferedImg.setRGB(row, col, getPixelColor(img.getPixelMatrix()[row][col]));
                }
            }
        }
        img.setBufferedImage(bufferedImg);

        redraw(); // redraw cartesian plane

        /**
         * Paint the image on the Cartesian plane
         */
        Graphics2D g2d = (Graphics2D) this.getGraphics();
        g2d.setTransform(affineTransform);
        g2d.drawImage(img.getBufferedImage(), getCenterXValue(), getCenterYValue() - img.getBufferedImage().getHeight(), null);
    }
}