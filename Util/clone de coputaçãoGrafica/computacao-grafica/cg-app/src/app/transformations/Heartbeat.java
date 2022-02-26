package app.transformations;

import app.extra.CartesianPlane;
import app.lines.Pixel;
import app.lines.Rasterization;
import java.awt.Color;
import java.awt.Graphics2D;
import static java.lang.Thread.sleep;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/** 
 * Class of heartbeat animation.
 *
 * @author Luis Thiago <lthiago.github.io>
 */
public class Heartbeat {
    
    public static Thread threadAnimation;
    
    private final CartesianPlane cartesianPlane;
    private final Graphics2D g;
    private final Rasterization rasterization;
    
    private final List<Pixel> pixelsLine;
    private final Pixel beg;
    private final Pixel end;
    
    public Heartbeat(){
        cartesianPlane = CartesianPlane.getInstance();
        g = (Graphics2D) cartesianPlane.getGraphics();
        rasterization = Rasterization.getInstance();
        
        pixelsLine = new LinkedList<>();
        beg = new Pixel((-1)*(cartesianPlane.getWidth()/2),0);
        end = new Pixel((cartesianPlane.getWidth()/2), 0);
    }
    
    /**
     * Method that generates the points of a line starting with pStart.
     * 
     * @param pStart 
     */
    private void generatesPixelsLine(Pixel pStart) {
        Pixel aux = new Pixel(pStart.getX()+100, 0);
        rasterization.midpointMethod(pStart, aux, Color.red, null);
        pixelsLine.addAll(rasterization.getPixels());
        removePixels();
    }
    
    /**
     * Method that generates the heartbeat points starting from pStart.
     * 
     * @param pStart 
     */
    private void generatesBeatPixels(Pixel pStart){
        int incX = 15;
        int incY = 2;
        Pixel aux = new Pixel(pStart.getX()+incX, 70);
        
        rasterization.midpointMethod(pStart, aux, Color.red, null);
        pixelsLine.addAll(rasterization.getPixels());
        
        rasterization.midpointMethod(aux, new Pixel(aux.getX()+incX,-aux.getY()), Color.red, null);
        pixelsLine.addAll(rasterization.getPixels());
        
        rasterization.midpointMethod(new Pixel(aux.getX()+incX,-aux.getY()), new Pixel(aux.getX()+(incX*2), aux.getY()*incY), Color.red, null);
        pixelsLine.addAll(rasterization.getPixels());
        
        rasterization.midpointMethod(new Pixel(aux.getX()+(incX*2), aux.getY()*incY), new Pixel(aux.getX()+(incX*3), -aux.getY()*incY), Color.red, null);
        pixelsLine.addAll(rasterization.getPixels());
        
        rasterization.midpointMethod(new Pixel(aux.getX()+(incX*3), -aux.getY()*incY), new Pixel(aux.getX()+(incX*4), aux.getY()), Color.red, null);
        pixelsLine.addAll(rasterization.getPixels());
        
        rasterization.midpointMethod(new Pixel(aux.getX()+(incX*4), aux.getY()), new Pixel(aux.getX()+(incX*5), 0), Color.red, null);
        pixelsLine.addAll(rasterization.getPixels());
        
        removePixels();
    }
    
    /**
     * Method that removes the points that have exceeded the size of the plane.
     */
    private void removePixels() {
        int t = pixelsLine.size() - 1;
        boolean c = true;
        while(c){
            if(pixelsLine.get(t).getX() > end.getX()){
                pixelsLine.remove(t);
                t--;
            }else{
                c = false;
            }
        }
    }
            
    /**
     * Method that starts the animation
     */
    public void startAnimation(){
        int x = (int) beg.getX();
        int y = (int) beg.getY();
        while(x < end.getX()){
            generatesPixelsLine(new Pixel(x, y));
            x += 100;
            generatesBeatPixels(new Pixel(x, y));
            x += 90;
        }
        for(int i=0; i<2; i++){
            cartesianPlane.redraw();
            pixelsLine.forEach(p -> {
                rasterization.midpointMethod(p, p, Color.red, null);

                try {
                    sleep(1);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Heartbeat.class.getName()).log(Level.SEVERE, null, ex);
                } 
            });
        }
        
    }
}
