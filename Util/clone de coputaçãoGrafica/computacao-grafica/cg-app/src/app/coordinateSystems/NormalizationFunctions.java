package app.coordinateSystems;

/**
 * Perform transformations between different types of coordinate systems.
 * 
 * @author Luis Thiago <lthiago.github.io>
 */
public class NormalizationFunctions {

    private static double ndcx;
    private static double ndcy;
    private static double dcx;
    private static double dcy;

    public static double calculateNDCX(float ndh, float dcx) {
        ndcx = dcx / (ndh - 1);
        return ndcx;
    }
    
    public static double calculateNDCY(float ndv, float dcy) {
        ndcy = (dcy / (ndv - 1));
        return ndcy;
    }
    
    public static int calculateDCX(float ndh, float ndcx) {
        dcx = ((ndh - 1) * ndcx);
        return (int) Math.round(dcx);
    }

    public static int calculateDCY(float ndv, float ndcy) {
        dcy = ((ndv - 1) * ndcy);
        return (int) Math.round(dcy);
    }
}