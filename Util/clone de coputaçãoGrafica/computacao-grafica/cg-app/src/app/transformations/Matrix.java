package app.transformations;

/**
 * Implements operations between matrices.
 *
 * @author Luis Thiago <lthiago.github.io>
 */
public class Matrix {

    public static double[][] multipliesMatrices(double[][] matrixA, double[][] matrixB){
        double[][] matrixResult = new double[matrixA.length][matrixB[0].length];

        for (int i = 0; i < matrixA.length; i++) {
            for (int j = 0; j < matrixB[0].length; j++) {
                for (int k = 0; k < matrixA[0].length; k++) {
                    matrixResult[i][j] += matrixA[i][k] * matrixB[k][j];
                }
            }
        }
        return matrixResult;
    }
}