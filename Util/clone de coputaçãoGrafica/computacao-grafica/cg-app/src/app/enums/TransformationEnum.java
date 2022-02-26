package app.enums;

/**
 * It maps the types of 2D/3D transformations on objects.
 *
 * @author Luis Thiago <lthiago.github.io>
 */
public enum TransformationEnum {
    TRANSLATION("Translation"), SCALE("Scale"), ROTATION("Rotation"), REFLECTION("Reflection"), SHEAR("Shear"), COMPOSITE_TRANSFORMATION("Composite Transformation");

    private final String title;

    TransformationEnum(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}