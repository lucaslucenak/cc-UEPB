package app.lines;

import app.extra.CartesianPlane;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * Algorithms for drawing circles.
 *
 * @author Luis Thiago <lthiago.github.io>
 */
public class Circle {

    private static Circle instance;
    private final CartesianPlane cartesianPlane;
    public static int x, y, d_old, x_dif, y_dif;
    private List<Pixel> pixelList;

    private Circle() {
        pixelList = new ArrayList<>();
        cartesianPlane = CartesianPlane.getInstance();
    }

    public static synchronized Circle getInstance() {
        if (instance == null) {
            instance = new Circle();
        }
        return instance;
    }

    /**
     * Algorithm of the explicit function.
     */
    public void explicitFunction(int radius, Color color) {
        cartesianPlane.redraw();
        
        for (int i = -radius; i < radius; i++) {
            cartesianPlane.drawPixel(i + cartesianPlane.getCenterXValue(), cartesianPlane.getCenterYValue() - ((int) Math.sqrt(radius * radius - i * i)), color);
            cartesianPlane.drawPixel(i + cartesianPlane.getCenterXValue(), cartesianPlane.getCenterYValue() - (-1 * (int) Math.sqrt(radius * radius - i * i)), color);
        }
    }

    /**
     * Trigonometric function algorithm.
     */
    public void trigonometricFunction(int radius, Color color) {
        cartesianPlane.redraw();
        for (int i = -radius; i <= radius; i++) {
            drawPixels(((int) (radius * (double) Math.cos(Math.toRadians(i)))), -((int) (radius * (double) Math.sin(Math.toRadians(i)))), color);
        }
    }

    /**
     * Midpoint algorithm.
     */
    public void midpointFunction(int radius, Color color) {
        cartesianPlane.redraw();
        
        x = 0;
        y = radius;
        d_old = 1 - radius;
        
        drawPixels(x, y, color);
        while (y > x) {
            if (d_old < 0) {
                d_old += 2 * x + 3;
            } else {
                d_old += 2 * x - 2 * y + 5;
                y--;
            }
            x++;
            drawPixels(x, y, color);
        }
    }

    /**
     * Algorithm to draw an ellipse by scanning using the midpoint algorithm.
     */
    public List<Pixel> ellipseFunction(int a, int b, Color color) {
        cartesianPlane.redraw();
        pixelList.clear();

        x = 0;
        y = 0;
        double d1;
        double d2;
       
        x = 0;
        y = b;
        d1 = b * b - a * a * b + a * a / 4.0;

        drawEllipse(x, y, color);

        while (a * a * (y - 0.5) > b * b * (x + 1)) {

            if (d1 < 0) {
                d1 = d1 + b * b * (2 * x + 3);
                x++;
            } else {
                d1 = d1 + b * b * (2 * x + 3) + a * a * (-2 * y + 2);
                x++;
                y--;
            }
            drawEllipse(x, y, color);
        }

        d2 = b * b * (x + 0.5) * (x + 0.5) + a * a * (y - 1) * (y - 1) - a * a * b * b;
        while (y > 0) {

            if (d2 < 0) {
                d2 = d2 + b * b * (2 * x + 2) + a * a * (-2 * y + 3);
                x++;
                y--;
            } else {
                d2 = d2 + a * a * (-2 * y + 3);
                y--;
            }
            drawEllipse(x, y, color);
        }

        return pixelList;
    }

    /**
     * Draw in each octant.
     */
    private void drawPixels(int x, int y, Color color) {
        
        cartesianPlane.drawPixel(x + cartesianPlane.getCenterXValue(), cartesianPlane.getCenterYValue() - y, color);
        cartesianPlane.drawPixel(x + cartesianPlane.getCenterXValue(), cartesianPlane.getCenterYValue() + y, color);
        cartesianPlane.drawPixel(-x + cartesianPlane.getCenterXValue(), cartesianPlane.getCenterYValue() - y, color);
        cartesianPlane.drawPixel(-x + cartesianPlane.getCenterXValue(), cartesianPlane.getCenterYValue() + y, color);
        
        cartesianPlane.drawPixel(y + cartesianPlane.getCenterXValue(), cartesianPlane.getCenterYValue() - x, color);
        cartesianPlane.drawPixel(y + cartesianPlane.getCenterXValue(), cartesianPlane.getCenterYValue() + x, color);
        cartesianPlane.drawPixel(-y + cartesianPlane.getCenterXValue(), cartesianPlane.getCenterYValue() - x, color);
        cartesianPlane.drawPixel(-y + cartesianPlane.getCenterXValue(), cartesianPlane.getCenterYValue() + x, color);
    }

    /**
     * Draw the points of the ellipse
     */
    private void drawEllipse(int x, int y, Color color) { 
        cartesianPlane.drawPixel(x + cartesianPlane.getCenterXValue(), cartesianPlane.getCenterYValue() - y, color);
        cartesianPlane.drawPixel(x + cartesianPlane.getCenterXValue(), cartesianPlane.getCenterYValue() + y, color);
        cartesianPlane.drawPixel(-x + cartesianPlane.getCenterXValue(), cartesianPlane.getCenterYValue() - y, color);
        cartesianPlane.drawPixel(-x + cartesianPlane.getCenterXValue(), cartesianPlane.getCenterYValue() + y, color);
        
        if (pixelList == null) {
            pixelList = new ArrayList<>();
        }
        pixelList.add(new Pixel((double) (x + cartesianPlane.getCenterXValue()), (double) (cartesianPlane.getCenterYValue() - y)));
        pixelList.add(new Pixel((double) (x + cartesianPlane.getCenterXValue()), (double) (cartesianPlane.getCenterYValue() + y)));
        pixelList.add(new Pixel((double) (-x + cartesianPlane.getCenterXValue()), (double) (cartesianPlane.getCenterYValue() - y)));
        pixelList.add(new Pixel((double) (-x + cartesianPlane.getCenterXValue()), (double) (cartesianPlane.getCenterYValue() + y)));
    }
}