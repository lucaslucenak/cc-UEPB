package app.enums;

/**
 * Maps out the types of algorithms for drawing circumference and ellipse.
 * 
 * @author Luis Thiago <lthiago.github.io>
 */
public enum CircleEnum {
    EXPLICIT_EQUATION("Explicit Equation"), MIDPOINT("Midpoint"), TRIGONOMETRIC("Trigonometric"), ELLIPSE("Ellipse");
    
    private final String title;

    CircleEnum(String title) {
        this.title = title;
    }
    
    public String getTitle() {
        return title;
    }
}