package app.lines;

import app.exceptions.ClipException;
import app.extra.CartesianPlane;
import java.util.ArrayList;
import java.util.List;

/**
 * Class implementing the line clipping algorithm: Cohen-Suterland.
 * 
 * @author Luis Thiago <lthiago.github.io>
 */
public class LineClipping {

    static LineClipping instance;
    private final CartesianPlane cartesianPlane;
    private List<Pixel> pixelList;

    private LineClipping() {
        pixelList = new ArrayList<>();
        cartesianPlane = CartesianPlane.getInstance();
    }

    public static synchronized LineClipping getInstance() {
        if (instance == null) {
            instance = new LineClipping();
        }
        return instance;
    }

    /**
     * Signal function.
     */
    public static String signalFunction(double a, double b) {
        if ((a - b) > 0) {
            return "1";
        }
        return "0";
    }

    /**
     * Create a 4-bit code to represent each region.
     */
    public String createBit(double Xmin, double Xmax, double Ymin, double Ymax, Pixel pixel) {
        String bit1, bit2, bit3, bit4;

        bit1 = signalFunction((int) pixel.getY(), Ymax);
        bit2 = signalFunction(Ymin, (int) pixel.getY());
        bit3 = signalFunction((int) pixel.getX(), Xmax);
        bit4 = signalFunction(Xmin, (int) pixel.getX());

        return bit1 + bit2 + bit3 + bit4;
    }

    /**
     * It applies the logic of the AND operator on two bit strings.
     */
    public String andOperator(String code1, String code2) {
        String finalCode = "";
        int finalBit;

        for (int bit = 0; bit < code1.length(); bit++) {
            finalBit = Integer.parseInt(String.valueOf(code1.charAt(bit))) & Integer.parseInt(String.valueOf(code2.charAt(bit)));
            finalCode += finalBit;
        }
        return finalCode;
    }

    /**
     * It checks whether the straight line is inside or outside the window.
     */
    public boolean isLineInside(double Xmin, double Xmax, double Ymin, double Ymax, Pixel pStart, Pixel pFinal) throws ClipException {
        String code1, code2, result;
        code1 = createBit(Xmin, Xmax, Ymin, Ymax, pStart);
        code2 = createBit(Xmin, Xmax, Ymin, Ymax, pFinal);
        if ("0000".equals(code1) && "0000".equals(code2)) {
            throw new ClipException("TRIVIAL CASE\nThe line is inside the window!");
        } else {
            result = andOperator(code1, code2);
            if (!"0000".equals(result)) {
                throw new ClipException("REJECTS\nThe line is out the window!");
            }
        }
        return true;
    }

    /**
     *  Apply the clipping algorithm to the first point.
     */
    public Pixel pixel1Clip(String code, double Xmin, double Xmax, double Ymin, double Ymax, Pixel pStart, Pixel pFinal) {
        int position = 0;

        double m = (pFinal.getY() - pStart.getY()) / (pFinal.getX() - pStart.getX());

        position = code.indexOf("1"); 
       
        switch (position) {
            case 0:
                double xNew1 = pStart.getX() + (Ymax - pStart.getY()) / m;
                pStart.setX(xNew1);
                pStart.setY(Ymax);
                break;
            case 1:
                double xNew2 = pStart.getX() + (Ymin - pStart.getY()) / m;
                pStart.setX(xNew2);
                pStart.setY(Ymin);
                break;
            case 2:
                double yNew1 = pStart.getY() + m * (Xmax - pStart.getX());
                pStart.setX(Xmax);
                pStart.setY(yNew1);
                break;

            case 3:
                double yNew2 = pStart.getY() + m * (Xmin - pStart.getX());
                pStart.setX(Xmin);
                pStart.setY(yNew2);
                break;
        }
        return pStart;
    }

    /**
     * Apply the clipping algorithm to the second point.
     */
    public Pixel pixel2Clip(String code, double xMin, double xMax, double yMin, double yMax, Pixel pStart, Pixel pFinal) {
        int position = 0;

        double m = (pFinal.getY() - pStart.getY()) / (pFinal.getX() - pStart.getX());

        position = code.indexOf("1");

        switch (position) {
            case 0:
                double xNew1 = pStart.getX() + (yMax - pStart.getY()) / m;
                pFinal.setX(xNew1);
                pFinal.setY(yMax);
                break;
            case 1:
                double xNew2 = pStart.getX() + (yMin - pStart.getY()) / m;
                pFinal.setX(xNew2);
                pFinal.setY(yMin);
                break;
            case 2:
                double yNew1 = pStart.getY() + m * (xMax - pStart.getX());
                pFinal.setX(xMax);
                pFinal.setY(yNew1);
                break;

            case 3:
                double yNew2 = pStart.getY() + m * (xMin - pStart.getX());
                pFinal.setX(xMin);
                pFinal.setY(yNew2);
                break;
        }
        return pFinal;
    }

    /**
     * Coordinating medium of the clipping algorithm.
     */
    public List<Pixel> applyCliping(double xMin, double xMax, double yMin, double yMax, List<Pixel> originalPixelList) {
        List<Pixel> newPixelList = new ArrayList<>();
        String code1, code2;

        Pixel pixelA;
        Pixel pixelB;

        code1 = createBit(xMin, xMax, yMin, yMax, originalPixelList.get(0));
        code2 = createBit(xMin, xMax, yMin, yMax, originalPixelList.get(1));

        while (!code1.equals("0000") || !code2.equals("0000")) {
            if (!code1.equals("0000") && code2.equals("0000")) {
                pixelA = pixel1Clip(code1, xMin, xMax, yMin, yMax, originalPixelList.get(0), originalPixelList.get(1));

                code1 = createBit(xMin, xMax, yMin, yMax, pixelA);
                code2 = createBit(xMin, xMax, yMin, yMax, originalPixelList.get(1));
                newPixelList.add(pixelA);
                newPixelList.add(originalPixelList.get(1));
            } else if (code1.equals("0000") && !code2.equals("0000")) {
                pixelB = pixel2Clip(code2, xMin, xMax, yMin, yMax, originalPixelList.get(0), originalPixelList.get(1));
                
                code2 = createBit(xMin, xMax, yMin, yMax, pixelB);
                newPixelList.add(originalPixelList.get(0));
                newPixelList.add(pixelB);
            } else {
                pixelA = pixel1Clip(code1, xMin, xMax, yMin, yMax, originalPixelList.get(0), originalPixelList.get(1));
                pixelB = pixel2Clip(code2, xMin, xMax, yMin, yMax, originalPixelList.get(0), originalPixelList.get(1));
                
                code1 = createBit(xMin, xMax, yMin, yMax, pixelA);
                code2 = createBit(xMin, xMax, yMin, yMax, pixelB);
                newPixelList.add(pixelA);
                newPixelList.add(pixelB);
            }
        }
        return newPixelList;
    }
}