package app.enums;

/**
 * Maps out the types of axes.
 * 
 * @author Luis Thiago <lthiago.github.io>
 */
public enum AxisEnum {
    X("X"), Y("Y"), Z("Z"), XY("XY"), XZ("XZ"), YZ("YZ");
    
    private final String value;

    AxisEnum(String value) {
        this.value = value;
    }
    
    public String getValue() {
        return value;
    }
}