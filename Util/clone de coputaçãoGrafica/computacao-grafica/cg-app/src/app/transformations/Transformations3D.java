package app.transformations;

import app.enums.AxisEnum;
import app.panels.Menu3D;
import java.util.Stack;
import javax.swing.JOptionPane;

/**
 * Methods for performing transformations on 3D objects.
 *
 * @author Luis Thiago <lthiago.github.io>
 */
public class Transformations3D {

    private static Transformations3D instance;
    private double[][] matrixM;

    public Transformations3D() {
    }

    public static synchronized Transformations3D getInstance() {
        if (instance == null) {
            instance = new Transformations3D();
        }
        return instance;
    }

    /**
     * Applies the translation transformation to the 3D object.
     */
    public double[][] translation(double[][] matrixObject, double tx, double ty, double tz) {
        double[][] matrixResult = new double[matrixObject.length][matrixObject[0].length];

        try {
            matrixResult = Matrix.multipliesMatrices(generateTranslationMatrix(tx, ty, tz), matrixObject);

            Menu3D.matrixObject3D = matrixResult; // updates the global object matrix.
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "An error has occurred in the transformation: translation.", "WARNING!", JOptionPane.WARNING_MESSAGE);
        }
        return matrixResult;
    }

    /**
     * Applies the scale transformation to the 3D object.
     */
    public double[][] scale(double[][] matrixObject, double sx, double sy, double sz) {
        double[][] matrixResult = new double[matrixObject.length][matrixObject[0].length];
        double tx = matrixObject[0][0], ty = matrixObject[1][0], tz = matrixObject[2][0]; // translation factors.

        try {
            // translation matrix (Tx,Ty,Tz) * scale matrix (Sx,Sy,Sz)
            matrixM = Matrix.multipliesMatrices(generateTranslationMatrix(tx, ty, tz), generateScaleMatrix(sx, sy, sz));
            // matrixM * translation matrix (-Tx,-Ty,-Tz)
            matrixM = Matrix.multipliesMatrices(matrixM, generateTranslationMatrix(-tx, -ty, -tz));
            //matrizM * objeto
            matrixResult = Matrix.multipliesMatrices(matrixM, matrixObject);

            Menu3D.matrixObject3D = matrixResult; //atualiza a matriz objeto global.
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "An error has occurred in the transformation: scale.", "WARNING!", JOptionPane.WARNING_MESSAGE);
        }
        return matrixResult;
    }

    /**
     * Applies the rotation transformation to the 3D object.
     */
    public double[][] rotation(double[][] matrixObject, double angle, String axis) {
        double[][] matrixResult = new double[matrixObject.length][matrixObject[0].length];

        double tx = matrixObject[0][0], ty = matrixObject[1][0], tz = matrixObject[2][0]; // translation factors.

        try {
            // translation matrix (Tx,Ty,Tz) * rotation matrix
            matrixM = Matrix.multipliesMatrices(generateTranslationMatrix(tx, ty, tz), generateRotationMatrix(angle, axis));
            // matrixM * translation matrix (-Tx,-Ty,-Tz)
            matrixM = Matrix.multipliesMatrices(matrixM, generateTranslationMatrix(-tx, -ty, -tz));
            // matrixM * object
            matrixResult = Matrix.multipliesMatrices(matrixM, matrixObject);
            Menu3D.matrixObject3D = matrixResult; // updates the global object matrix.
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "An error has occurred in the transformation: rotation.", "WARNING!", JOptionPane.WARNING_MESSAGE);
        }

        return matrixResult;
    }

    /**
     * Applies the reflection transformation to the 3D object.
     */
    public double[][] reflection(double[][] matrixObject, String axis) {
        double[][] matrixResult = new double[matrixObject.length][matrixObject[0].length];
        axis = axis.toLowerCase();

        double tx = matrixObject[0][0], ty = matrixObject[1][0], tz = matrixObject[2][0]; // translation factors.
        
        try {
            // translation matrix (Tx,Ty,Tz) * reflection matrix
            matrixM = Matrix.multipliesMatrices(generateTranslationMatrix(tx, ty, tz), generateReflectionMatrix(axis));
            // matrixM * translation matrix (-Tx,-Ty,-Tz)
            matrixM = Matrix.multipliesMatrices(matrixM, generateTranslationMatrix(-tx, -ty, -tz));
            // matrixM * object
            matrixResult = Matrix.multipliesMatrices(generateReflectionMatrix(axis), matrixObject);

            Menu3D.matrixObject3D = matrixResult; // updates the global object matrix.
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "An error has occurred in the transformation: reflection.", "WARNING!", JOptionPane.WARNING_MESSAGE);
        }
        return matrixResult;
    }

    /**
     * Applies the shear transformation to the 3D object.
     */
    public double[][] shear(double[][] matrixObject, double a, double b, String axis) {
        double[][] matrixResult = new double[matrixObject.length][matrixObject[0].length];

        double tx = matrixObject[0][0], ty = matrixObject[1][0], tz = matrixObject[2][0]; //fatores de translação.

        try {
            // translation matrix (Tx,Ty,Tz) * shear matrix(a,b,axis)
            matrixM = Matrix.multipliesMatrices(generateTranslationMatrix(tx, ty, tz), generateShearMatrix(a, b, axis));
            // matrixM * translation matrix (-Tx,-Ty,-Tz)
            matrixM = Matrix.multipliesMatrices(matrixM, generateTranslationMatrix(-tx, -ty, -tz));
            // matrixM * object
            matrixResult = Matrix.multipliesMatrices(matrixM, matrixObject);

            Menu3D.matrixObject3D = matrixResult; // updates the global object matrix.
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "An error has occurred in the transformation: shear.", "WARNING!", JOptionPane.WARNING_MESSAGE);
        }
        return matrixResult;
    }

    /**
     * Applies a composite transformation to the 3D object.
     */
    public double[][] composite(Stack<double[][]> transformationList, double[][] matrixObject) {
        Stack<double[][]> transformationListCopy = (Stack<double[][]>) transformationList.clone();

        double[][] matrixResult = new double[matrixObject.length][matrixObject[0].length];
        matrixM = transformationListCopy.pop();

        try {
            while (!transformationListCopy.isEmpty()) {
                matrixM = Matrix.multipliesMatrices(matrixM, transformationListCopy.pop());
            }
            // matrixM * object
            matrixResult = Matrix.multipliesMatrices(matrixM, matrixObject);
            Menu3D.matrixObject3D = matrixResult; // updates the global object matrix.
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "An error has occurred in the composite transformation.", "WARNING!", JOptionPane.WARNING_MESSAGE);
        }
        return matrixResult;
    }

    /**
     * Generate translation matrix.
     */
    public double[][] generateTranslationMatrix(double tx, double ty, double tz) {
        double[][] matrix = new double[4][4];

        matrix[0][0] = 1; 
        matrix[1][0] = 0;
        matrix[2][0] = 0;
        matrix[3][0] = 0;
        
        matrix[0][1] = 0; 
        matrix[1][1] = 1;
        matrix[2][1] = 0;
        matrix[3][1] = 0;
        
        matrix[0][2] = 0; 
        matrix[1][2] = 0;
        matrix[2][2] = 1;
        matrix[3][2] = 0;
        
        matrix[0][3] = tx; 
        matrix[1][3] = ty;
        matrix[2][3] = tz;
        matrix[3][3] = 1;
        
        return matrix;
    }

    /**
     * Generate scale matrix.
     */
    public double[][] generateScaleMatrix(double sx, double sy, double sz) {
        double[][] matrix = new double[4][4];
        sx = (sx == 0) ? 1 : sx;
        sy = (sy == 0) ? 1 : sy;
        sz = (sz == 0) ? 1 : sy;

        matrix[0][0] = sx;
        matrix[1][0] = 0;
        matrix[2][0] = 0;
        matrix[3][0] = 0;

        matrix[0][1] = 0;
        matrix[1][1] = sy;
        matrix[2][1] = 0;
        matrix[3][1] = 0;

        matrix[0][2] = 0;
        matrix[1][2] = 0;
        matrix[2][2] = sz;
        matrix[3][2] = 0;

        matrix[0][3] = 0;
        matrix[1][3] = 0;
        matrix[2][3] = 0;
        matrix[3][3] = 1;

        return matrix;
    }

    /**
     * Generates rotation matrix according to the axis passed as parameter.
     */
    public double[][] generateRotationMatrix(double angle, String axis) {
        double[][] matrix = new double[4][4];
        double sin = Math.sin(Math.toRadians(angle));
        double cos = Math.cos(Math.toRadians(angle));
        axis = axis.toUpperCase();

        if (axis.equals(AxisEnum.X.getValue())) { // rotation in X
            matrix[0][0] = 1;
            matrix[1][0] = 0;
            matrix[2][0] = 0;
            matrix[3][0] = 0;

            matrix[0][1] = 0;
            matrix[1][1] = cos;
            matrix[2][1] = -sin;
            matrix[3][1] = 0;

            matrix[0][2] = 0;
            matrix[1][2] = sin;
            matrix[2][2] = cos;
            matrix[3][2] = 0;
        }else if (axis.equals(AxisEnum.Y.getValue())) { // Y-rotation
            matrix[0][0] = cos;
            matrix[1][0] = 0;
            matrix[2][0] = sin;
            matrix[3][0] = 0;

            matrix[0][1] = 0;
            matrix[1][1] = 1;
            matrix[2][1] = 0;
            matrix[3][1] = 0;

            matrix[0][2] = -sin;
            matrix[1][2] = 0;
            matrix[2][2] = cos;
            matrix[3][2] = 0;
        } else { // Z-rotation
            matrix[0][0] = cos;
            matrix[1][0] = -sin;
            matrix[2][0] = 0;
            matrix[3][0] = 0;

            matrix[0][1] = sin;
            matrix[1][1] = cos;
            matrix[2][1] = 0;
            matrix[3][1] = 0;

            matrix[0][2] = 0;
            matrix[1][2] = 0;
            matrix[2][2] = 1;
            matrix[3][2] = 0;
        }
        matrix[0][3] = 0;
        matrix[1][3] = 0;
        matrix[2][3] = 0;
        matrix[3][3] = 1;

        return matrix;
    }

    /**
     * Generates a reflection matrix according to the axis passed as a parameter.
     */
    public double[][] generateReflectionMatrix(String axis) {
        double[][] matrix = new double[4][4];
        axis = axis.toUpperCase();

        // reflection in XZ
        matrix[0][0] = 1;
        matrix[1][0] = 0;
        matrix[2][0] = 0;
        matrix[3][0] = 0;

        matrix[0][1] = 0;
        matrix[1][1] = -1;
        matrix[2][1] = 0;
        matrix[3][1] = 0;

        matrix[0][2] = 0;
        matrix[1][2] = 0;
        matrix[2][2] = 1;
        matrix[3][2] = 0;

        matrix[0][3] = 0;
        matrix[1][3] = 0;
        matrix[2][3] = 0;
        matrix[3][3] = 1;

        if (axis.equals(AxisEnum.XY.getValue())) { // XY reflection
            matrix[1][1] = 1;
            matrix[2][2] = -1;
        }else if (axis.equals(AxisEnum.YZ.getValue())) { // rotation in YZ
            matrix[0][0] = -1;
            matrix[1][1] = 1;
        }

        return matrix;
    }

    /**
     * Generates shear matrix according to the axis passed as a parameter.
     */
    public double[][] generateShearMatrix(double a, double b, String axis) {
        double[][] matrix = new double[4][5];
        axis = axis.toUpperCase();

        // shear at X
        matrix[0][0] = 1;
        matrix[1][0] = a;
        matrix[2][0] = b;
        matrix[3][0] = 0;

        matrix[0][1] = 0;
        matrix[1][1] = 1;
        matrix[2][1] = 0;
        matrix[3][1] = 0;

        matrix[0][2] = 0;
        matrix[1][2] = 0;
        matrix[2][2] = 1;
        matrix[3][2] = 0;

        matrix[0][3] = 0;
        matrix[1][3] = 0;
        matrix[2][3] = 0;
        matrix[3][3] = 1;

        if (axis.equals(AxisEnum.Y.getValue())) { // shear at Y 
            matrix[1][0] = 0;
            matrix[2][0] = 0;
            matrix[0][1] = a;
            matrix[2][1] = b;
        }else if (axis.equals(AxisEnum.Z.getValue())) { // shear at Z
            matrix[1][0] = 0;
            matrix[2][0] = 0;
            matrix[0][2] = a;
            matrix[1][2] = b;
        }

        return matrix;
    }
}