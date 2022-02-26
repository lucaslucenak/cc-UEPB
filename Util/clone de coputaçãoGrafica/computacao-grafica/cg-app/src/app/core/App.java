// TODO
package app.core;

import app.dialog.AboutDialog;
import app.enums.RasterizationEnum;
import app.extra.FrameHeartBeating;
import app.panels.Menu2D;
import app.panels.Menu3D;
import app.panels.CircleMenu;
import app.panels.ImageMenu;
import app.panels.LineMenu;
import app.panels.LineClippingMenu;
import app.extra.CartesianPlane;
import app.lines.Circle;
import app.lines.Pixel;
import app.lines.Rasterization;
import app.coordinateSystems.NormalizationFunctions;
import app.transformations.Heartbeat;
import app.transformations.Image;
import app.transformations.Transformations2D;
import app.transformations.Transformations3D;
import app.transformations.TransformationsImage;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.List;
import javax.swing.JPanel;

/**
 * The main JFrame of the application.
 *
 * @author Luis Thiago <lthiago.github.io>
 */
public class App extends javax.swing.JFrame {

    private final LineMenu lineMenu;
    private final CircleMenu circleMenu;
    private final Menu2D menu2D;
    private final Menu3D menu3D;
    private final LineClippingMenu lineClippingMenu;
    private final ImageMenu imageMenu;

    public App() {
        lineMenu = LineMenu.getInstance();
        circleMenu = CircleMenu.getInstance();
        menu2D = Menu2D.getInstance();
        menu3D = Menu3D.getInstance();
        lineClippingMenu = LineClippingMenu.getInstance();
        imageMenu = ImageMenu.getInstance();
        
        initComponents();
        coordinateSystem();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        leftPane = new javax.swing.JPanel();
        rightPanel = new javax.swing.JPanel();
        carstesianPlanePanel = app.extra.CartesianPlane.getInstance();
        statsPanel = new javax.swing.JPanel();
        screenSizeLabel = new javax.swing.JLabel();
        inputCoordLabel = new javax.swing.JLabel();
        dcxLabel = new javax.swing.JLabel();
        dcxValue = new javax.swing.JLabel();
        dcyLabel = new javax.swing.JLabel();
        dcyValue = new javax.swing.JLabel();
        normCoordLabel = new javax.swing.JLabel();
        ndcxLabel = new javax.swing.JLabel();
        ndcxValue = new javax.swing.JLabel();
        ndcyLabel = new javax.swing.JLabel();
        ndcyValue = new javax.swing.JLabel();
        outputCoordLabel = new javax.swing.JLabel();
        xLabel = new javax.swing.JLabel();
        xValue = new javax.swing.JLabel();
        yLabel = new javax.swing.JLabel();
        yValue = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        drawMenu = new javax.swing.JMenu();
        lineMenuItem = new javax.swing.JMenuItem();
        circleMenuItem = new javax.swing.JMenuItem();
        heartbeatMenu = new javax.swing.JMenu();
        printLineMenuItem = new javax.swing.JMenuItem();
        pulseMenuItem = new javax.swing.JMenuItem();
        hearbeatPlaneMenuItem = new javax.swing.JMenuItem();
        transformationsMenu = new javax.swing.JMenu();
        lineClippingMenuItem = new javax.swing.JMenuItem();
        transform2dMenuItem = new javax.swing.JMenuItem();
        transform3dMenuItem = new javax.swing.JMenuItem();
        imageOpMenu = new javax.swing.JMenu();
        aboutMenu = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Final Project - Computer Graphics - 2020.2 - UEPB");
        setExtendedState(6);
        setMinimumSize(new java.awt.Dimension(1080, 720));
        setName("framePrincipal"); // NOI18N
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                actionResized(evt);
            }
        });

        leftPane.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        leftPane.setMinimumSize(new java.awt.Dimension(240, 0));
        leftPane.setPreferredSize(new java.awt.Dimension(240, 2));

        javax.swing.GroupLayout leftPaneLayout = new javax.swing.GroupLayout(leftPane);
        leftPane.setLayout(leftPaneLayout);
        leftPaneLayout.setHorizontalGroup(
            leftPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 242, Short.MAX_VALUE)
        );
        leftPaneLayout.setVerticalGroup(
            leftPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 681, Short.MAX_VALUE)
        );

        carstesianPlanePanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        carstesianPlanePanel.setPreferredSize(new java.awt.Dimension(550, 550));

        javax.swing.GroupLayout carstesianPlanePanelLayout = new javax.swing.GroupLayout(carstesianPlanePanel);
        carstesianPlanePanel.setLayout(carstesianPlanePanelLayout);
        carstesianPlanePanelLayout.setHorizontalGroup(
            carstesianPlanePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 642, Short.MAX_VALUE)
        );
        carstesianPlanePanelLayout.setVerticalGroup(
            carstesianPlanePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        screenSizeLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        screenSizeLabel.setText("Screen size:");

        inputCoordLabel.setText("Input coordinates:");

        dcxLabel.setText("DCX:");

        dcxValue.setText("0");

        dcyLabel.setText("DCY:");

        dcyValue.setText("0");

        normCoordLabel.setText("Normalized coordinates:");

        ndcxLabel.setText("NDCX:");

        ndcxValue.setText("0");

        ndcyLabel.setText("NDCY:");

        ndcyValue.setText("0");

        outputCoordLabel.setText("Output coordinates:");

        xLabel.setText("X:");

        xValue.setText("0");

        yLabel.setText("Y:");

        yValue.setText("0");

        javax.swing.GroupLayout statsPanelLayout = new javax.swing.GroupLayout(statsPanel);
        statsPanel.setLayout(statsPanelLayout);
        statsPanelLayout.setHorizontalGroup(
            statsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(statsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, statsPanelLayout.createSequentialGroup()
                        .addGroup(statsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(normCoordLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                            .addComponent(inputCoordLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(screenSizeLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(outputCoordLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(statsPanelLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(statsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(statsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(statsPanelLayout.createSequentialGroup()
                                    .addComponent(ndcxLabel)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(ndcxValue, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(statsPanelLayout.createSequentialGroup()
                                    .addComponent(ndcyLabel)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(ndcyValue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(statsPanelLayout.createSequentialGroup()
                                    .addGroup(statsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(dcxLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(dcyLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(statsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(dcxValue, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(dcyValue, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(statsPanelLayout.createSequentialGroup()
                                .addGroup(statsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(yLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(xLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(statsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(xValue, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                                    .addComponent(yValue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        statsPanelLayout.setVerticalGroup(
            statsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(screenSizeLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputCoordLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(statsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dcxLabel)
                    .addComponent(dcxValue))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(statsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dcyLabel)
                    .addComponent(dcyValue))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(normCoordLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(statsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ndcxLabel)
                    .addComponent(ndcxValue))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(statsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ndcyLabel)
                    .addComponent(ndcyValue))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(outputCoordLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(statsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(xLabel)
                    .addComponent(xValue))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(statsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(yLabel)
                    .addComponent(yValue))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout rightPanelLayout = new javax.swing.GroupLayout(rightPanel);
        rightPanel.setLayout(rightPanelLayout);
        rightPanelLayout.setHorizontalGroup(
            rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rightPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(carstesianPlanePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 644, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(statsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        rightPanelLayout.setVerticalGroup(
            rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rightPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(carstesianPlanePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 671, Short.MAX_VALUE)
                    .addComponent(statsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        menuBar.setPreferredSize(new java.awt.Dimension(104, 25));

        drawMenu.setText("Draw");

        lineMenuItem.setText("Line");
        lineMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openLineMenu(evt);
            }
        });
        drawMenu.add(lineMenuItem);

        circleMenuItem.setText("Circle");
        circleMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openCircleMenu(evt);
            }
        });
        drawMenu.add(circleMenuItem);

        menuBar.add(drawMenu);

        heartbeatMenu.setText("Heartbeat");

        printLineMenuItem.setText("Print Line");
        printLineMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printLineMenuItemActionPerformed(evt);
            }
        });
        heartbeatMenu.add(printLineMenuItem);

        pulseMenuItem.setText("Pulse");
        pulseMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pulseMenuItemActionPerformed(evt);
            }
        });
        heartbeatMenu.add(pulseMenuItem);

        hearbeatPlaneMenuItem.setText("On Cartesian Plane");
        hearbeatPlaneMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hearbeatPlaneMenuItemActionPerformed(evt);
            }
        });
        heartbeatMenu.add(hearbeatPlaneMenuItem);

        menuBar.add(heartbeatMenu);

        transformationsMenu.setText("Transformations");

        lineClippingMenuItem.setText("Line Clipping");
        lineClippingMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openLineClippingMenu(evt);
            }
        });
        transformationsMenu.add(lineClippingMenuItem);

        transform2dMenuItem.setText("2D Transformation");
        transform2dMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openMenu2D(evt);
            }
        });
        transformationsMenu.add(transform2dMenuItem);

        transform3dMenuItem.setText("3D Transformation");
        transform3dMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openMenu3D(evt);
            }
        });
        transformationsMenu.add(transform3dMenuItem);

        menuBar.add(transformationsMenu);

        imageOpMenu.setText("Image");
        imageOpMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imageOpMenuMouseClicked(evt);
            }
        });
        menuBar.add(imageOpMenu);

        aboutMenu.setText("About");
        aboutMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                aboutMenuMouseClicked(evt);
            }
        });
        menuBar.add(aboutMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(leftPane, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rightPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(rightPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(leftPane, javax.swing.GroupLayout.DEFAULT_SIZE, 683, Short.MAX_VALUE))
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(1096, 759));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Opens menu for drawing lines.
     */
    private void openLineMenu(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openLineMenu
        leftPane.setVisible(true);
        CartesianPlane.getInstance().redraw();
        changeMenuLeft(lineMenu);
    }//GEN-LAST:event_openLineMenu

     /**
     * Opens menu for drawing circles and ellipses.
     */
    private void openCircleMenu(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openCircleMenu
        leftPane.setVisible(true);
        CartesianPlane.getInstance().redraw();
        changeMenuLeft(circleMenu);
    }//GEN-LAST:event_openCircleMenu

     /**
     * Opens menu for using 2D transformations.
     */
    private void openMenu2D(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openMenu2D
        leftPane.setVisible(true);
        CartesianPlane.getInstance().redraw();
        changeMenuLeft(menu2D);
    }//GEN-LAST:event_openMenu2D

     /**
     * Opens menu for using 3D transformations.
     */
    private void openMenu3D(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openMenu3D
        leftPane.setVisible(true);
        CartesianPlane.getInstance().redraw3D();
        changeMenuLeft(menu3D);
    }//GEN-LAST:event_openMenu3D

    /**
     * Event fired every time the screen is resized. Sets the current screen resolution.
     */
    private void actionResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_actionResized
        CartesianPlane p = CartesianPlane.getInstance();
        screenSizeLabel.setText("Screen size: " + p.getWidth() + "x" + p.getHeight());
    }//GEN-LAST:event_actionResized

     /**
     * Opens menu for using the line clipping algorithm.
     */
    private void openLineClippingMenu(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openLineClippingMenu
        leftPane.setVisible(true);
        CartesianPlane.getInstance().redraw();
        changeMenuLeft(lineClippingMenu);
    }//GEN-LAST:event_openLineClippingMenu

    /**
     * Opens the panel that displays project information.
     */
    private void aboutMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aboutMenuMouseClicked
         new AboutDialog(this, true).setVisible(true);
    }//GEN-LAST:event_aboutMenuMouseClicked

    private void imageOpMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imageOpMenuMouseClicked
        leftPane.setVisible(true);
        CartesianPlane.getInstance().redraw();
        changeMenuLeft(imageMenu);
    }//GEN-LAST:event_imageOpMenuMouseClicked

    /**
     * It does not display the offset line and displays the "pulsing" object.
     */
    private void pulseMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pulseMenuItemActionPerformed
        boolean printLine = false;
        runAnimation(printLine);
    }//GEN-LAST:event_pulseMenuItemActionPerformed

    /**
     * Displays the line of the object's displacement.
     */
    private void printLineMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printLineMenuItemActionPerformed
        boolean printLine = true;
        runAnimation(printLine);
    }//GEN-LAST:event_printLineMenuItemActionPerformed
    
    /**
     * Starts Heart Beating in the Cartesian plane.
     */
    private void hearbeatPlaneMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hearbeatPlaneMenuItemActionPerformed
        openBeatingHeart();
    }//GEN-LAST:event_hearbeatPlaneMenuItemActionPerformed

    /**
     * Perform the beating heart.
     */
    private void openBeatingHeart(){      
       Heartbeat heart = new Heartbeat();
       heart.startAnimation();
    }
    
    /**
     * Executes the JFrame that has the animation.
     */
    private void runAnimation(boolean printLine){
        int width = 550;
        int height = 300;
        FrameHeartBeating f = new FrameHeartBeating(width, height, printLine);

        f.setTitle("Heartbeat");
        f.setSize(width, height);
        f.setType(Type.POPUP);
        f.setVisible(true);
        f.setResizable(false);
        f.setLocationRelativeTo(null);
    }
    
    /**
     * Changes the jPanel of the left menu according to the jPanel passed as parameter.
     */
    private void changeMenuLeft(JPanel panel) {
        leftPane.removeAll();
        leftPane.repaint();

        leftPane.setLayout(new GridLayout());
        leftPane.add(panel);

        leftPane.validate();
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new App().setVisible(true);
            }
        });
    }

    /**
     * Executes the selected algorithm.
     */
    public static void runResult(Object instance) {
        if (instance instanceof LineMenu) {
            processLineRasterization(LineMenu.getInstance());
        } else if (instance instanceof CircleMenu) {
            processCircleRasterization(CircleMenu.getInstance());
        } else if (instance instanceof Menu2D) {
            process2DTransformations(Menu2D.getInstance());
        } else if (instance instanceof Menu3D) {
            process3DTransformations(Menu3D.getInstance());
        } else if (instance instanceof ImageMenu) {
            processImageTransformations(ImageMenu.getInstance());
        }
    }

    /**
     * Processes the request coming from the Straight Raster Panel.
     */
    private static void processLineRasterization(LineMenu menu) {
        Rasterization rast = Rasterization.getInstance();
        CartesianPlane.getInstance().redraw();

        if (menu.getAlgorithmType().equals(RasterizationEnum.DDA)) {
            rast.ddaMethod(menu.getpStart(), menu.getpFinal(), menu.getColor(), menu.getTextAreaResult());
        } else if (menu.getAlgorithmType().equals(RasterizationEnum.MIDPOINT)) {
            rast.midpointMethod(menu.getpStart(), menu.getpFinal(), menu.getColor(), menu.getTextAreaResult());
        }
    }

    /**
     * Processes the request coming from the Circumference Rasterization Panel.
     */
    private static void processCircleRasterization(CircleMenu menu) {
        Circle circ = Circle.getInstance();

        switch (menu.getTipoAlgoritimo()) {
            case MIDPOINT:
                circ.midpointFunction((int) menu.getRaioX(), menu.getColor());
                break;
            case EXPLICIT_EQUATION:
                circ.explicitFunction((int) menu.getRaioX(), menu.getColor());
                break;
            case TRIGONOMETRIC:
                circ.trigonometricFunction((int) menu.getRaioX(), menu.getColor());
                break;
            case ELLIPSE:
                List<Pixel> list = circ.ellipseFunction((int) menu.getRaioX(), (int) menu.getRaioY(), menu.getColor());
            default:
                break;
        }
    }

    /**
     * Processes the request coming from the 2D transformations screen.
     */
    private static void process2DTransformations(Menu2D menu) {
        if (Menu2D.matrixObject != null) {
            Transformations2D trans2D = Transformations2D.getInstance();

            //original object matrix. Updated at each transformation
            double[][] matrizObjeto = Menu2D.matrixObject;

            switch (menu.getTipoAlgoritimo()) {
                case TRANSLATION:
                    // Aplica translação
                    matrizObjeto = trans2D.translation(matrizObjeto, menu.getValorX(), menu.getValorY());
                    break;
                case SCALE:
                    // Aplica scale de acordo com Sx e Sy
                    matrizObjeto = trans2D.scale(matrizObjeto, menu.getValorX(), menu.getValorY());
                    break;
                case ROTATION:
                    // Aplica rotação de acordo com o ângulo
                    matrizObjeto = trans2D.rotation(matrizObjeto, menu.getAngulo());
                    break;
                case REFLECTION:
                    // Aplica reflexão de acordo com o eixo selecionado
                    matrizObjeto = trans2D.reflection(matrizObjeto, menu.getEixo());
                    break;
                case SHEAR:
                    // Aplica shear de acordo com o valor de a e b
                    matrizObjeto = trans2D.shear(matrizObjeto, menu.getValorX(), menu.getValorY());
                    break;
                case COMPOSITE_TRANSFORMATION:
                    matrizObjeto = trans2D.composite(menu.listaDeTransformacoes, matrizObjeto);
                    break;
                default:
                    break;
            }
            // Desenha o objeto no plano.
            CartesianPlane.getInstance().drawObjeto2D(matrizObjeto, menu.getColor());
        }
    }

    /**
     * Processes the request coming from the 3D transformations screen.
     */
    private static void process3DTransformations(Menu3D menu) {
        if (Menu3D.matrixObject3D != null) {
            Transformations3D trans3D = Transformations3D.getInstance();

            // original object matrix. Updated at each transformation
            double[][] matrixObject3D = Menu3D.matrixObject3D;

            switch (menu.getTipoAlgoritimo()) {
                case TRANSLATION:
                    // Aplica translação
                    matrixObject3D = trans3D.translation(matrixObject3D, menu.getValorX(), menu.getValorY(), menu.getValorZ());
                    break;
                case SCALE:
                    // Apply scale according to Sx and Sy
                    matrixObject3D = trans3D.scale(matrixObject3D, menu.getValorX(), menu.getValorY(), menu.getValorZ());
                    break;
                case ROTATION:
                    // Aplica rotação de acordo com o ângulo
                    matrixObject3D = trans3D.rotation(matrixObject3D, menu.getAngulo(), menu.getEixo());
                    break;
                case REFLECTION:
                    // Applies reflection according to the selected axis
                    matrixObject3D = trans3D.reflection(matrixObject3D, menu.getEixo());
                    break;
                case SHEAR:
                    // Applies shear according to the value of a and b
                    matrixObject3D = trans3D.shear(matrixObject3D, menu.getValorX(), menu.getAlignmentY(), menu.getEixo());
                    break;
                case COMPOSITE_TRANSFORMATION:
                    matrixObject3D = trans3D.composite(menu.listaDeTransformacoes, matrixObject3D);
                    break;
                default:
                    break;
            }

            // Draw the object in space.
            CartesianPlane.getInstance().drawObjeto3D(matrixObject3D, menu.getColor());
        }
    }
    
    /**
     * Calculates and displays the coordinate system according to the points in the Cartesian plane.
     * The mouseMoved event is used to get the coordinates in the Cartesian plane.
     */
    private void coordinateSystem() {
        carstesianPlanePanel.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                super.mouseMoved(e);

                // Take the instance of the Cartesian plane
                CartesianPlane cartesianPlane = CartesianPlane.getInstance();

                // Calculates the dc - Device Input | Will be the same as the output
                int dcx = e.getX() - cartesianPlane.getCenterXValue();
                int dcy = (e.getY() - cartesianPlane.getCenterYValue()) * -1;

                // Calculates ndc - Device Normalization
                double ndcx = NormalizationFunctions.calculateNDCX(cartesianPlane.getWidth(), dcx);
                double ndcy = NormalizationFunctions.calculateNDCX(cartesianPlane.getHeight(), dcy);

                ndcxValue.setText(String.format("%.6f", ndcx));
                ndcyValue.setText(String.format("%.6f", ndcy));

                dcxValue.setText(String.valueOf(NormalizationFunctions.calculateDCX(cartesianPlane.getWidth(), (float) ndcx)));
                dcyValue.setText(String.valueOf(NormalizationFunctions.calculateDCY(cartesianPlane.getHeight(), (float) ndcy)));

                xValue.setText(String.valueOf(Math.round(dcx)));
                yValue.setText(String.valueOf(Math.round(dcy)));
            }
        });
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     * Processes the request coming from the transformations screen in Image.
     */
    private static void processImageTransformations(ImageMenu menu) {
        if (ImageMenu.imagem != null) {
            TransformationsImage transImg = TransformationsImage.getInstance();
            Image image = ImageMenu.imagem;

            switch (menu.getTipoAlgoritimo()) {
                case TRANSLATION:
                    transImg.translation(image, menu.getValorX(), menu.getValorY());
                    break;
                case SCALE:
                    transImg.scale(image, menu.getValorX(), menu.getValorY());
                    break;
                case ROTATION:
                    transImg.rotation(image, menu.getAngulo());
                    break;
                case REFLECTION:
                    transImg.reflection(image, menu.getEixo());
                    break;
                case SHEAR:
                    transImg.shear(image, menu.getValorX(), menu.getValorY());
                    break;
                default:
                    break;
            }
        }
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu aboutMenu;
    private static javax.swing.JPanel carstesianPlanePanel;
    private javax.swing.JMenuItem circleMenuItem;
    private javax.swing.JLabel dcxLabel;
    private javax.swing.JLabel dcxValue;
    private javax.swing.JLabel dcyLabel;
    private javax.swing.JLabel dcyValue;
    private javax.swing.JMenu drawMenu;
    private javax.swing.JMenuItem hearbeatPlaneMenuItem;
    private javax.swing.JMenu heartbeatMenu;
    private javax.swing.JMenu imageOpMenu;
    private javax.swing.JLabel inputCoordLabel;
    private javax.swing.JPanel leftPane;
    private javax.swing.JMenuItem lineClippingMenuItem;
    private javax.swing.JMenuItem lineMenuItem;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JLabel ndcxLabel;
    private javax.swing.JLabel ndcxValue;
    private javax.swing.JLabel ndcyLabel;
    private javax.swing.JLabel ndcyValue;
    private javax.swing.JLabel normCoordLabel;
    private javax.swing.JLabel outputCoordLabel;
    private javax.swing.JMenuItem printLineMenuItem;
    private javax.swing.JMenuItem pulseMenuItem;
    private javax.swing.JPanel rightPanel;
    private javax.swing.JLabel screenSizeLabel;
    private javax.swing.JPanel statsPanel;
    private javax.swing.JMenuItem transform2dMenuItem;
    private javax.swing.JMenuItem transform3dMenuItem;
    private javax.swing.JMenu transformationsMenu;
    private javax.swing.JLabel xLabel;
    private javax.swing.JLabel xValue;
    private javax.swing.JLabel yLabel;
    private javax.swing.JLabel yValue;
    // End of variables declaration//GEN-END:variables
}