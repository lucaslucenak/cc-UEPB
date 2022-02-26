package app.transformations;

import app.enums.AxisEnum;
import app.panels.Menu2D;
import java.util.Stack;
import javax.swing.JOptionPane;

/**
 * Implements the methods for performing transformations on a 2D object.
 *
 * @author Luis Thiago <lthiago.github.io>
 */
public class Transformations2D {

    private static Transformations2D instance;

    private double[][] matrixM;

    private Transformations2D() {
    }

    public static synchronized Transformations2D getInstance() {
        if (instance == null) {
            instance = new Transformations2D();
        }
        return instance;
    }

    /**
     * Applies the translation transformation to the 2D object.
     */
    public double[][] translation(double[][] matrixObject, double tx, double ty) {
        double[][] matrixResult = new double[matrixObject.length][matrixObject[0].length];

        try {
            matrixResult = Matrix.multipliesMatrices(generateTranslationMatrix(tx, ty), matrixObject);
            Menu2D.matrixObject = matrixResult; // updates the global object matrix.
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "An error has occurred in the transformation: translation.", "WARNING!", JOptionPane.WARNING_MESSAGE);
        }
        return matrixResult;
    }
    
    /**
     * Applies the scale transformation to the 2D object.
     */
    public double[][] scale(double[][] matrixObject, double sx, double sy) {
        double[][] matrixResult = new double[matrixObject.length][matrixObject[0].length];

        double tx = matrixObject[0][0], ty = matrixObject[1][0]; // translation factors.

        try {
            //matrix translation (Tx,Ty) * matrix scale (Sx, Sy)
            matrixM = Matrix.multipliesMatrices(generateTranslationMatrix(tx, ty), generateScaleMatrix(sx, sy));
            //matrixM * matriz translation (-Tx,-Ty)
            matrixM = Matrix.multipliesMatrices(matrixM, generateTranslationMatrix(-tx, -ty));
            //matrixM * object
            matrixResult = Matrix.multipliesMatrices(matrixM, matrixObject);
            Menu2D.matrixObject = matrixResult; // updates the global object matrix.
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "An error has occurred in the transformation: scale.", "WARNING!", JOptionPane.WARNING_MESSAGE);
        }
        return matrixResult;
    }

    /**
     * Applies the rotation transformation to the 2D object.
     */
    public double[][] rotation(double[][] matrixObject, double angle) {
        double[][] matrixResult = new double[matrixObject.length][matrixObject[0].length];
        double tx = matrixObject[0][0], ty = matrixObject[1][0]; // translation factors.

        try {
            //matrix translation (Tx,Ty) * matrix rotation
            matrixM = Matrix.multipliesMatrices(generateTranslationMatrix(tx, ty), generateRotationMatrix(angle));
            //matrixM * matrix translation (-Tx,-Ty)
            matrixM = Matrix.multipliesMatrices(matrixM, generateTranslationMatrix(-tx, -ty));
            //matrixM * object
            matrixResult = Matrix.multipliesMatrices(matrixM, matrixObject);
            Menu2D.matrixObject = matrixResult; // updates the global object matrix.
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "An error has occurred in the transformation: rotation.", "WARNING!", JOptionPane.WARNING_MESSAGE);
        }
        return matrixResult;
    }

    /**
     * Applies the reflection transformation to the 2D object.
     */
    public double[][] reflection(double[][] matrixObject, String axis) {
        double[][] matrixResult = new double[matrixObject.length][matrixObject[0].length];
        axis = axis.toUpperCase();
        try {
            //matrixM * object
            matrixResult = Matrix.multipliesMatrices(generateReflectionMatrix(axis), matrixObject);
            Menu2D.matrixObject = matrixResult; // updates the global object matrix.
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "An error has occurred in the transformation: reflection.", "WARNING!", JOptionPane.WARNING_MESSAGE);
        }
        return matrixResult;
    }

    /**
     * Applies the shear transformation to the 2D object.
     */
    public double[][] shear(double[][] matrixObject, double cx, double cy) {
        double[][] matrixResult = new double[matrixObject.length][matrixObject[0].length];

        double tx = matrixObject[0][0], ty = matrixObject[1][0]; // translation factors

        try {
            //matrix translation (Tx,Ty) * matrix shear (Cx, Cy)
            matrixM = Matrix.multipliesMatrices(generateTranslationMatrix(tx, ty), generateShearMatrix(cx, cy));
            //matrixM * matrix translation (-Tx,-Ty)
            matrixM = Matrix.multipliesMatrices(matrixM, generateTranslationMatrix(-tx, -ty));
            //matrixM * object
            matrixResult = Matrix.multipliesMatrices(matrixM, matrixObject);
            Menu2D.matrixObject = matrixResult; // updates the global object matrix.
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "An error has occurred in the transformation: shear.", "WARNING!", JOptionPane.WARNING_MESSAGE);
        }
        return matrixResult;
    }

    /**
     * Applies a composite transformation to the object.
     */
    public double[][] composite(Stack<double[][]> transformationList, double[][] matrixObject) {
        Stack<double[][]> transformationListCopy = (Stack<double[][]>) transformationList.clone();

        double[][] matrixResult = new double[matrixObject.length][matrixObject[0].length];
        matrixM = transformationListCopy.pop();

        try {
            while (!transformationListCopy.isEmpty()) {
                matrixM = Matrix.multipliesMatrices(matrixM, transformationListCopy.pop());
            }
            //matrixM * object
            matrixResult = Matrix.multipliesMatrices(matrixM, matrixObject);
            Menu2D.matrixObject = matrixResult; // updates the global object matrix.
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "An error has occurred in the composite transformation.", "WARNING!", JOptionPane.WARNING_MESSAGE);
        }

        return matrixResult;
    }

    /**
     * Generate translation matrix.
     */
    public double[][] generateTranslationMatrix(double tx, double ty) {
        double[][] matrix = new double[3][3];

        matrix[0][0] = 1;
        matrix[1][0] = 0;
        matrix[2][0] = 0;

        matrix[0][1] = 0;
        matrix[1][1] = 1;
        matrix[2][1] = 0;

        matrix[0][2] = tx;
        matrix[1][2] = ty;
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

        matrix[0][0] = cos;
        matrix[1][0] = sin;
        matrix[2][0] = 0;

        matrix[0][1] = -sin;
        matrix[1][1] = cos;
        matrix[2][1] = 0;

        matrix[0][2] = 0;
        matrix[1][2] = 0;
        matrix[2][2] = 1;

        return matrix;
    }

    /**
     * Generates a reflection matrix around the axis passed as parameter.
     */
    public double[][] generateReflectionMatrix(String axis) {
        double[][] matrix = new double[3][3];

        axis = axis.toUpperCase();

        // XY rotation
        matrix[0][0] = -1;
        matrix[1][0] = 0;
        matrix[2][0] = 0;

        matrix[0][1] = 0;
        matrix[1][1] = -1;
        matrix[2][1] = 0;

        matrix[0][2] = 0;
        matrix[1][2] = 0;
        matrix[2][2] = 1;

        // X rotation
        if (axis.equals(AxisEnum.X.getValue())) {
            matrix[0][0] = 1;
        } else if (axis.equals(AxisEnum.Y.getValue())) { // Y rotation
            matrix[1][1] = 1;
        }
        return matrix;
    }

    /**
     * Generate shear matrix.
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
}