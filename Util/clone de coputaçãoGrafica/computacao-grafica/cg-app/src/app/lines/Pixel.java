package app.lines;

/**
 * It represents a point in the plane/space.
 *
 * @author Luis Thiago <lthiago.github.io>
 */
public class Pixel {

    private double x;
    private double y;
    private double z;

    public Pixel(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Pixel(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
    
    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public void swap() {
        double temp = x;
        setX(y);
        setY(temp);
    }

    @Override
    public String toString() {
        return String.format("P(%.2f, %.2f, %.2f)", getX(), getY(), getZ());
    }
}