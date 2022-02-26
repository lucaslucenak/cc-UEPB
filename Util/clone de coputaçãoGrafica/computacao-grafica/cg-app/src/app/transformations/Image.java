package app.transformations;

import app.lines.Pixel;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 * Represents an image of the .PGM type
 * 
 * @author Luis Thiago <lthiago.github.io>
 */
public class Image {

    private int[][] pixelMatrix;
    private BufferedImage bufferedImage;
    private int width;
    private int height;
    private Pixel pixel;

    public Image() {
    }
    
    public Image(int[][] pixelMatrix, BufferedImage bufferedImage, int width, int height) {
        this.pixelMatrix = pixelMatrix;
        this.bufferedImage = bufferedImage;
        this.width = width;
        this.height = height;
        this.pixel = new Pixel(0, 0);
    }

    /**
     * Arrows the pixel value at a specified position in the image.
     */
    public boolean setPixel(int row, int col, int value) throws ArrayIndexOutOfBoundsException {
        if (this.width <= 0 || this.height <= 0) {
            return false;
        }

        if (this.pixelMatrix == null) {
            this.pixelMatrix = new int[this.width][this.height];
        }

        try {
            this.pixelMatrix[row][col] = value;
        } catch (Exception e) {
            throw new ArrayIndexOutOfBoundsException(e.getMessage());
        }

        return true;
    }

    /**
     * Load the image from a .PGM file
     */
    public static Image loadImage(File path) {
        Image img = new Image();
        BufferedImage bufferedImg;

        try {
            FileInputStream fileInput = new FileInputStream(path);
            Scanner scan = new Scanner(fileInput);

            scan.nextLine();

            img.setWidth(scan.nextInt());
            img.setHeight(scan.nextInt());
            scan.nextInt();
            bufferedImg = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_RGB);

            for (int row = 0; row < img.getWidth(); row++) {
                for (int col = 0; col < img.getHeight(); col++) {
                    int valuePixel = scan.nextInt();
                    img.setPixel(col, row, valuePixel);
                    bufferedImg.setRGB(row, col, new Color(valuePixel, valuePixel, valuePixel).getRGB());
                }
            }
            img.setBufferedImage(bufferedImg);

            fileInput.close();
            scan.close();
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Specified path not found.", "Failure!", JOptionPane.WARNING_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "An error occurred while opening the image.", "Failure!", JOptionPane.WARNING_MESSAGE);
        }
        return img;
    }

    public int[][] getPixelMatrix() {
        return pixelMatrix;
    }

    public void setPixelMatrix(int[][] pixelMatrix) {
        this.pixelMatrix = pixelMatrix;
    }

    public BufferedImage getBufferedImage() {
        return bufferedImage;
    }

    public void setBufferedImage(BufferedImage bufferedImage) {
        this.bufferedImage = bufferedImage;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Pixel getPixel() {
        return pixel;
    }

    public void setPixel(Pixel pixel) {
        this.pixel = pixel;
    }

    public void set2DPixel(double x, double y) {
        this.pixel = new Pixel(x, y);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Arrays.deepHashCode(this.pixelMatrix);
        hash = 59 * hash + this.width;
        hash = 59 * hash + this.height;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Image)) {
            return false;
        }

        final Image other = (Image) obj;

        if (this.width != other.width || this.height != other.height) {
            return false;
        }

        return Arrays.deepEquals(this.pixelMatrix, other.pixelMatrix);
    }

    @Override
    public String toString() {
        return "Image{" + "pixelMatrix=" + Arrays.toString(pixelMatrix) + ", width=" + width + ", height=" + height + '}';
    }
}