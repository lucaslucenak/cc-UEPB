package app.lines;

import app.extra.CartesianPlane;
import java.awt.Color;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JTextArea;

/**
 * Class that implements the algorithms for rasterizing the line.
 *
 * @author Luis Thiago <lthiago.github.io>
 */
public class Rasterization {

    private static Rasterization instance;

    private final CartesianPlane cartesianPlane;
    
    private final List<Pixel> pixels;

    private Rasterization() {
        cartesianPlane = CartesianPlane.getInstance();
        pixels = new LinkedList<>();
    }

    public static synchronized Rasterization getInstance() {
        if (instance == null) {
            instance = new Rasterization();
        }
        return instance;
    }

    /**
     * DDA Algorithm (Digital Differential Analyser).
     */
    public void ddaMethod(Pixel pStart, Pixel pFinal, Color color, JTextArea textAreaSolution) {
        double x1 = pStart.getX();
        double x2 = pFinal.getX();
        double y1 = pStart.getY();
        double y2 = pFinal.getY();
        double dx = (x2 - x1);
        double dy = (y2 - y1);
        int count = 0;

        if (Math.abs(y2 - y1) <= Math.abs(x2 - x1)) {
            if ((x1 == x2) && (y1 == y2)) {
                cartesianPlane.drawPixel(x1, y1, color);
                setSolution(textAreaSolution, x1, y1, ++count);
            } else {
                if (x2 < x1) {
                    double tmp = x2;
                    x2 = x1;
                    x1 = tmp;

                    tmp = y2;
                    y2 = y1;
                    y1 = tmp;
                }
                double k = dy / dx;
                int cele_y;
                double y = y1;
            }
        } else if (y2 < y1) {
            double tmp = x2;
            x2 = x1;
            x1 = tmp;

            tmp = y2;
            y2 = y1;
            y1 = tmp;
        }

        double k = dx / dy;
        double x = x1;
        for (int y = (int) y1; y <= y2; y++) {
            cartesianPlane.drawPixel(x, y, color);
            setSolution(textAreaSolution, x, y, ++count);
            x += k;
        }
    }

    /**
     * Midpoint Algorithm (Bresenham).
     */
    public void midpointMethod(Pixel pStart, Pixel pFinal, Color color, JTextArea textAreaSolution) {
        int x1 = (int) (pStart.getX() + pStart.getZ());
        int x2 = (int) (pFinal.getX() + pStart.getZ());
        int y1 = (int) (pStart.getY() + pFinal.getZ());
        int y2 = (int) (pFinal.getY() + pFinal.getZ());

        if ((x1 == x2) && (y1 == y2)) {
            cartesianPlane.drawPixel((double)x1, (double)y1, color);
        } else {
            double dx = Math.abs(x2 - x1);
            double dy = Math.abs(y2 - y1);
            double rozdil = dx - dy;
            int posun_x, posun_y;

            if (x1 < x2) {
                posun_x = 1;
            } else {
                posun_x = -1;
            }
            if (y1 < y2) {
                posun_y = 1;
            } else {
                posun_y = -1;
            }

            int count = 0;
            cartesianPlane.drawPixel((double) x1, (double) y1, color);
            setSolution(textAreaSolution, x1, y1, ++count);
            pixels.clear();
            pixels.add(new Pixel(x1, y1));

            while ((x1 != x2) || (y1 != y2)) {
                double p = 2 * rozdil;

                if (p > -dy) {
                    rozdil = rozdil - dy;
                    x1 = x1 + posun_x;
                }
                if (p < dx) {
                    rozdil = rozdil + dx;
                    y1 = y1 + posun_y;
                }

                cartesianPlane.drawPixel((double) x1, (double) y1, color);
                setSolution(textAreaSolution, x1, y1, ++count);
                pixels.add(new Pixel(x1, y1));
            }
        }
    }

    /**
     * Populates the jTextArea with the solution to the problem.
     */
    private static void setSolution(JTextArea textAreaSolution, double x, double y, int count) {
        if (textAreaSolution != null) {
            StringBuilder solution = new StringBuilder();

            solution.append(textAreaSolution.getText());
            solution.append(String.format("%03d", count));
            solution.append(" -> ");
            solution.append("P(").append(Math.round(x)).append(", ").append(Math.round(y));
            solution.append(")\n");
            textAreaSolution.setText(solution.toString());
        }
    }
    
    /**
     * Returns the list of points plotted by the midpoint algorithm.
     */
    public List getPixels(){
        return pixels;  
    }
}