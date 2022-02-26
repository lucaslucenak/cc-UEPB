package app.extra;

import java.awt.*;
import java.awt.geom.*;
import java.util.Date;
import javax.swing.JFrame;

/**
 * Animation based on combined stepwise transformations.
 *
 * @author Luis Thiago <lthiago.github.io>
 */
public class FrameHeartBeating extends JFrame {

    private int windowWidth;
    private int windowHeight;
    private boolean printLine = false;

    public FrameHeartBeating(int windowWidth, int windowHeight, boolean printLine) {
        this.windowWidth = windowWidth;
        this.windowHeight = windowHeight;
        this.printLine = printLine;
    }

    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        // Lines with a thickness of 2.0
        g2d.setStroke(new BasicStroke(2.0f));
        // Use of antialiasing to have nicer lines.
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        /* 
        * yUp defines a conversion that allows the specification of objects in "real" coordinates,
	* where the y-axis points upward and the origin of the coordinate system is located in the
	* bottom left corner of the window.
         */
        AffineTransform yUp = new AffineTransform();
        yUp.setToScale(1, -1);
        AffineTransform translate = new AffineTransform();
        translate.setToTranslation(0, windowHeight);
        yUp.preConcatenate(translate);

        // Applies the transformation to the Graphics2D object to draw everything in "real" coordinates.
        g2d.transform(yUp);

        // This rectangle serves as a background, framing the whole screen.
        Rectangle2D.Double windowFrame = new Rectangle2D.Double(2, 2, windowWidth, windowHeight);

        // Drawing of the object to be moved.
        Rectangle2D.Double heart = new Rectangle2D.Double(2, 2, 2, 2);

        // It specifies how much to move in each step.
        AffineTransform singleTranslation = new AffineTransform();
        
        // How much will each move have
        singleTranslation.setToTranslation(1, 0);

        // This transformation is to accumulate the single-step translations.
        AffineTransform accumulatedTranslation = new AffineTransform();

        // Starting position
        accumulatedTranslation.setToTranslation(0, 100);
        clearWindow(g2d);
        
        // In this loop, the position of the object is updated and the updated image is drawn.
        for (int i = 0; i < windowWidth + 390; i++) {
            // Clean the window.
            if (!printLine) {
                clearWindow(g2d);
            }

            // Draw the background rectangle.
            g2d.draw(windowFrame);

            // Draw the object's frame.
            g2d.draw(accumulatedTranslation.createTransformedShape(heart));

            // Arrow as it will travel through the point
            if (i > 80 & i <= 130 || i > 200 & i <= 220 || i > 290 & i <= 320 || i > 360 & i <= 370
                    || i > 440 & i <= 500 || i > 580 & i <= 600 || i > 660 & i <= 690 || i > 760 & i <= 800) {
                singleTranslation.setToTranslation(0.3, 1);
            } else if (i > 130 & i <= 200 || i > 320 & i <= 360 || i > 500 & i <= 580 || i > 690 & i <= 760) {
                singleTranslation.setToTranslation(0.3, -1);
            } else {
                singleTranslation.setToTranslation(1, 0);
            }
            accumulatedTranslation.preConcatenate(singleTranslation);

            // Controls the time to redraw the object and the window.
            sustain(10);
        }
        dispose();
    }

    /**
     * Method for cleaning the window.
     */
    public void clearWindow(Graphics2D g2d) {
        g2d.setPaint(Color.BLACK);
        g2d.fill(new Rectangle(0, 0, windowWidth, windowHeight));
        g2d.setPaint(Color.RED);
    }

    /**
     * A method for a delay of t milliseconds. This method is used here
     * just to keep the program simple. This method involves active waiting,
     * consuming unnecessary processor power. For real
     * applications, chaining should be used.
     */
    public void sustain(long t) {
        long finish = (new Date()).getTime() + t;
        while ((new Date()).getTime() < finish) {
        }
    }
}