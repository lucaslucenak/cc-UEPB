package app.panels;

import app.core.App;
import app.enums.RasterizationEnum;
import app.lines.Pixel;
import java.awt.Color;
import javax.swing.JTextArea;

/**
 * Panel with the settings required to plot a line.
 *
 * @author Luis Thiago <lthiago.github.io>
 */
public class LineMenu extends javax.swing.JPanel {

    private static LineMenu instance;

    private Pixel pStart;
    private Pixel pFinal;
    private Color color;
    private RasterizationEnum algorithmType;

    private LineMenu() {
        initComponents();
        resultArea.setEditable(false);
    }
    
    public static synchronized LineMenu getInstance() {
        if (instance == null) {
            instance = new LineMenu();
        }
        return instance;
    }

    public Pixel getpStart() {
        return pStart;
    }

    public void setpStart(Pixel pStart) {
        this.pStart = pStart;
    }

    public Pixel getpFinal() {
        return pFinal;
    }

    public void setpFinal(Pixel pFinal) {
        this.pFinal = pFinal;
    }

    public RasterizationEnum getAlgorithmType() {
        return algorithmType;
    }

    public void setAlgorithmType(RasterizationEnum algorithmType) {
        this.algorithmType = algorithmType;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public JTextArea getTextAreaResult() {
        return resultArea;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupAlgoritmos = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        algorithmLabel = new javax.swing.JLabel();
        algorithmPanel = new javax.swing.JPanel();
        ddaRB = new javax.swing.JRadioButton();
        midpointR = new javax.swing.JRadioButton();
        dataLabel = new javax.swing.JLabel();
        dataPanel = new javax.swing.JPanel();
        xLabel = new javax.swing.JLabel();
        yLabel = new javax.swing.JLabel();
        startLabel = new javax.swing.JLabel();
        startXValue = new javax.swing.JSpinner();
        startYValue = new javax.swing.JSpinner();
        endLabel = new javax.swing.JLabel();
        endXValue = new javax.swing.JSpinner();
        endYValue = new javax.swing.JSpinner();
        drawButton = new javax.swing.JButton();
        scroll = new javax.swing.JScrollPane();
        resultArea = new javax.swing.JTextArea();

        jLabel1.setText("jLabel1");

        setMaximumSize(new java.awt.Dimension(240, 32767));
        setMinimumSize(new java.awt.Dimension(240, 0));
        setPreferredSize(new java.awt.Dimension(240, 779));

        algorithmLabel.setText("Select the algorithm:");

        algorithmPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        buttonGroupAlgoritmos.add(ddaRB);
        ddaRB.setSelected(true);
        ddaRB.setText("DDA (Digital Differential Analyser)");

        buttonGroupAlgoritmos.add(midpointR);
        midpointR.setText("Bresenham (Midpoint)");
        midpointR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                midpointRActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout algorithmPanelLayout = new javax.swing.GroupLayout(algorithmPanel);
        algorithmPanel.setLayout(algorithmPanelLayout);
        algorithmPanelLayout.setHorizontalGroup(
            algorithmPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(algorithmPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(algorithmPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(midpointR)
                    .addComponent(ddaRB))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        algorithmPanelLayout.setVerticalGroup(
            algorithmPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(algorithmPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ddaRB)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(midpointR)
                .addContainerGap())
        );

        dataLabel.setText("Inform the data:");

        dataPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        xLabel.setText("X");

        yLabel.setText("Y");

        startLabel.setText("Start:");

        startXValue.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        startXValue.setModel(new javax.swing.SpinnerNumberModel(0.0d, null, null, 1.0d));
        startXValue.setMaximumSize(new java.awt.Dimension(30, 25));
        startXValue.setMinimumSize(new java.awt.Dimension(30, 25));
        startXValue.setPreferredSize(new java.awt.Dimension(30, 25));

        startYValue.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        startYValue.setModel(new javax.swing.SpinnerNumberModel(0.0d, null, null, 1.0d));
        startYValue.setMaximumSize(new java.awt.Dimension(30, 25));
        startYValue.setMinimumSize(new java.awt.Dimension(30, 25));
        startYValue.setPreferredSize(new java.awt.Dimension(30, 25));

        endLabel.setText("End:");

        endXValue.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        endXValue.setModel(new javax.swing.SpinnerNumberModel(0.0d, null, null, 1.0d));
        endXValue.setMaximumSize(new java.awt.Dimension(30, 25));
        endXValue.setMinimumSize(new java.awt.Dimension(30, 25));
        endXValue.setPreferredSize(new java.awt.Dimension(30, 25));

        endYValue.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        endYValue.setModel(new javax.swing.SpinnerNumberModel(0.0d, null, null, 1.0d));
        endYValue.setMaximumSize(new java.awt.Dimension(30, 25));
        endYValue.setMinimumSize(new java.awt.Dimension(30, 25));
        endYValue.setPreferredSize(new java.awt.Dimension(30, 25));

        javax.swing.GroupLayout dataPanelLayout = new javax.swing.GroupLayout(dataPanel);
        dataPanel.setLayout(dataPanelLayout);
        dataPanelLayout.setHorizontalGroup(
            dataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dataPanelLayout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(xLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(yLabel)
                .addGap(51, 51, 51))
            .addGroup(dataPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(startLabel)
                    .addComponent(endLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(dataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(startXValue, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                    .addComponent(endXValue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(dataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(startYValue, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(endYValue, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        dataPanelLayout.setVerticalGroup(
            dataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dataPanelLayout.createSequentialGroup()
                .addGroup(dataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(xLabel)
                    .addComponent(yLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(startXValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(startYValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(startLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(endXValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(endLabel)
                    .addComponent(endYValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        drawButton.setText("Draw Line");
        drawButton.setPreferredSize(new java.awt.Dimension(61, 30));
        drawButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                drawLine(evt);
            }
        });

        scroll.setBorder(javax.swing.BorderFactory.createTitledBorder("Iterations"));

        resultArea.setColumns(20);
        resultArea.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        resultArea.setRows(5);
        resultArea.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        scroll.setViewportView(resultArea);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dataPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(drawButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(scroll, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(algorithmPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dataLabel)
                            .addComponent(algorithmLabel))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(algorithmLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(algorithmPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dataLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dataPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(drawButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 526, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Draw the line using the selected algorithm.
     */
    private void drawLine(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_drawLine
        resultArea.setText(""); // Clears the textResult area
        setColor(Color.RED);

        // Arrow the coordinates of the points and arrow on the Pixel object
        setpStart(new Pixel((double) startXValue.getValue(), (double) startYValue.getValue()));
        setpFinal(new Pixel((double) endXValue.getValue(), (double) endYValue.getValue()));

        // Mushroom or type of algorithm selected
        if (ddaRB.isSelected()) {
            setAlgorithmType(RasterizationEnum.DDA);
        } else if (midpointR.isSelected()) {
            setAlgorithmType(RasterizationEnum.MIDPOINT);
        }
        App.runResult(this); // The main screen processes the data sent from this panel.
    }//GEN-LAST:event_drawLine

    private void midpointRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_midpointRActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_midpointRActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel algorithmLabel;
    private javax.swing.JPanel algorithmPanel;
    private javax.swing.ButtonGroup buttonGroupAlgoritmos;
    private javax.swing.JLabel dataLabel;
    private javax.swing.JPanel dataPanel;
    private javax.swing.JRadioButton ddaRB;
    private javax.swing.JButton drawButton;
    private javax.swing.JLabel endLabel;
    private javax.swing.JSpinner endXValue;
    private javax.swing.JSpinner endYValue;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JRadioButton midpointR;
    private javax.swing.JTextArea resultArea;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JLabel startLabel;
    private javax.swing.JSpinner startXValue;
    private javax.swing.JSpinner startYValue;
    private javax.swing.JLabel xLabel;
    private javax.swing.JLabel yLabel;
    // End of variables declaration//GEN-END:variables
}