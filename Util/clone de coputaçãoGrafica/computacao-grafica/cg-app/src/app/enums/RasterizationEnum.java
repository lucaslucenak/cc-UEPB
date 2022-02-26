package app.enums;

/**
 * Mapeia os tipos de algoritmos para rasterização da reta.
 * 
 * @author Luis Thiago <lthiago.github.io>
 */
public enum RasterizationEnum {
    DDA("DDA (Digital Differential Analyser)"), MIDPOINT("Bresenham (Midpoint)");
    
    private final String title;

    RasterizationEnum(String title) {
        this.title = title;
    }
    
    public String getTitle() {
        return title;
    }
}
