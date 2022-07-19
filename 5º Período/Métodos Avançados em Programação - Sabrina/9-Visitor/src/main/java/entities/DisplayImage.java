package entities;

import ij.IJ;
import ij.ImagePlus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DisplayImage {
    private ImagePlus imagePlus;

    public DisplayImage(String path) {
        imagePlus = IJ.openImage(path);
    }

    public void show() {
        imagePlus.show();
    }
}
