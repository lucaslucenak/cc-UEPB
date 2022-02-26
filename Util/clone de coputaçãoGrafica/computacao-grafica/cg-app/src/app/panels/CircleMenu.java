package app.panels;

import app.core.App;
import app.enums.CircleEnum;
import java.awt.Color;

/**
 * Painel com as configurações necessárias para desenhar uma circunferência.
 *
 * @author Luis Thiago <lthiago.github.io>
 */
public class CircleMenu extends javax.swing.JPanel {

    private static CircleMenu instance;

    private float raioX;
    private float raioY;
    private Color color;
    private CircleEnum tipoAlgoritimo;

    /**
     * Construtor padrão.
     */
    private CircleMenu() {
        initComponents();
        yRadiusValue.setVisible(false);
        bLabel.setVisible(false);
        aLabel.setText("Raio: ");
    }
    
    public static synchronized CircleMenu getInstance() {
        if (instance == null) {
            instance = new CircleMenu();
        }
        return instance;
    }

    public float getRaioX() {
        return raioX;
    }

    public void setRaioX(float raioX) {
        this.raioX = raioX;
    }

    public float getRaioY() {
        return raioY;
    }

    public void setRaioY(float raioY) {
        this.raioY = raioY;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public CircleEnum getTipoAlgoritimo() {
        return tipoAlgoritimo;
    }

    public void setTipoAlgoritimo(CircleEnum tipoAlgoritimo) {
        this.tipoAlgoritimo = tipoAlgoritimo;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupAlgoritmos = new javax.swing.ButtonGroup();
        circumferenceAlgorithmLabel = new javax.swing.JLabel();
        circumferenceAlgorithmPanel = new javax.swing.JPanel();
        midpointCircumferenceRB = new javax.swing.JRadioButton();
        explicitEquationRB = new javax.swing.JRadioButton();
        trigonometricRB = new javax.swing.JRadioButton();
        ellipseAlgorithmLabel = new javax.swing.JLabel();
        ellipseAlgorithmPanel = new javax.swing.JPanel();
        midpointEllipseRB = new javax.swing.JRadioButton();
        dataLabel = new javax.swing.JLabel();
        dataPanel = new javax.swing.JPanel();
        aLabel = new javax.swing.JLabel();
        xRadiusValue = new javax.swing.JSpinner();
        bLabel = new javax.swing.JLabel();
        yRadiusValue = new javax.swing.JSpinner();
        drawButton = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(240, 32767));
        setMinimumSize(new java.awt.Dimension(240, 0));
        setPreferredSize(new java.awt.Dimension(240, 779));

        circumferenceAlgorithmLabel.setText("Select the algorithm (Circumference):");

        circumferenceAlgorithmPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        buttonGroupAlgoritmos.add(midpointCircumferenceRB);
        midpointCircumferenceRB.setSelected(true);
        midpointCircumferenceRB.setText("Midpoint");
        midpointCircumferenceRB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selecetedAlgoritmo(evt);
            }
        });

        buttonGroupAlgoritmos.add(explicitEquationRB);
        explicitEquationRB.setText("Explicit Equation");
        explicitEquationRB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selecetedAlgoritmo(evt);
            }
        });

        buttonGroupAlgoritmos.add(trigonometricRB);
        trigonometricRB.setText("Trigonometric");
        trigonometricRB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selecetedAlgoritmo(evt);
            }
        });

        javax.swing.GroupLayout circumferenceAlgorithmPanelLayout = new javax.swing.GroupLayout(circumferenceAlgorithmPanel);
        circumferenceAlgorithmPanel.setLayout(circumferenceAlgorithmPanelLayout);
        circumferenceAlgorithmPanelLayout.setHorizontalGroup(
            circumferenceAlgorithmPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(circumferenceAlgorithmPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(circumferenceAlgorithmPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(trigonometricRB)
                    .addComponent(midpointCircumferenceRB)
                    .addComponent(explicitEquationRB))
                .addContainerGap(109, Short.MAX_VALUE))
        );
        circumferenceAlgorithmPanelLayout.setVerticalGroup(
            circumferenceAlgorithmPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(circumferenceAlgorithmPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(midpointCircumferenceRB)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(explicitEquationRB)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(trigonometricRB)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        ellipseAlgorithmLabel.setText("Select the algorithm (Ellipse):");

        ellipseAlgorithmPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        buttonGroupAlgoritmos.add(midpointEllipseRB);
        midpointEllipseRB.setText("Midpoint");
        midpointEllipseRB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selecetedAlgoritmo(evt);
            }
        });

        javax.swing.GroupLayout ellipseAlgorithmPanelLayout = new javax.swing.GroupLayout(ellipseAlgorithmPanel);
        ellipseAlgorithmPanel.setLayout(ellipseAlgorithmPanelLayout);
        ellipseAlgorithmPanelLayout.setHorizontalGroup(
            ellipseAlgorithmPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ellipseAlgorithmPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(midpointEllipseRB)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ellipseAlgorithmPanelLayout.setVerticalGroup(
            ellipseAlgorithmPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ellipseAlgorithmPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(midpointEllipseRB)
                .addContainerGap())
        );

        dataLabel.setText("Informe os dados:");

        dataPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        aLabel.setText("a:");

        xRadiusValue.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        xRadiusValue.setModel(new javax.swing.SpinnerNumberModel(0.0f, null, null, 0.1f));
        xRadiusValue.setMaximumSize(new java.awt.Dimension(30, 25));
        xRadiusValue.setMinimumSize(new java.awt.Dimension(30, 25));
        xRadiusValue.setPreferredSize(new java.awt.Dimension(30, 25));

        bLabel.setText("b:");

        yRadiusValue.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        yRadiusValue.setModel(new javax.swing.SpinnerNumberModel(0.0f, null, null, 0.1f));
        yRadiusValue.setMaximumSize(new java.awt.Dimension(30, 25));
        yRadiusValue.setMinimumSize(new java.awt.Dimension(30, 25));
        yRadiusValue.setPreferredSize(new java.awt.Dimension(30, 25));

        javax.swing.GroupLayout dataPanelLayout = new javax.swing.GroupLayout(dataPanel);
        dataPanel.setLayout(dataPanelLayout);
        dataPanelLayout.setHorizontalGroup(
            dataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dataPanelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(aLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(xRadiusValue, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(yRadiusValue, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        dataPanelLayout.setVerticalGroup(
            dataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dataPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(xRadiusValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(aLabel)
                    .addComponent(yRadiusValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bLabel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        drawButton.setText("Draw Circle");
        drawButton.setPreferredSize(new java.awt.Dimension(61, 30));
        drawButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                desenhaCirc(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dataPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ellipseAlgorithmPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(circumferenceAlgorithmPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(circumferenceAlgorithmLabel)
                            .addComponent(ellipseAlgorithmLabel)
                            .addComponent(dataLabel))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(drawButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(circumferenceAlgorithmLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(circumferenceAlgorithmPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ellipseAlgorithmLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ellipseAlgorithmPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(dataLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dataPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(drawButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(489, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Desenha a circuferência utilizando o algoritmo selecionado.
     */
    private void desenhaCirc(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_desenhaCirc
        setColor(Color.RED);

        // Seta o raio
        setRaioX((float) xRadiusValue.getValue());

        // Seta o tipo de algoritmo selecionado
        if (midpointCircumferenceRB.isSelected()) {
            setTipoAlgoritimo(CircleEnum.MIDPOINT);
        } else if (explicitEquationRB.isSelected()) {
            setTipoAlgoritimo(CircleEnum.EXPLICIT_EQUATION);
        } else if (trigonometricRB.isSelected()) {
            setTipoAlgoritimo(CircleEnum.TRIGONOMETRIC);
        } else if (midpointEllipseRB.isSelected()) {
            setRaioY((float) yRadiusValue.getValue());
            setTipoAlgoritimo(CircleEnum.ELLIPSE);
        }
        App.runResult(this); //Tela principal processa os dados enviados desse painel.
    }//GEN-LAST:event_desenhaCirc

    /**
     * Habilita/desabilita componentes de acordo como algoritmo selecionado.
     */
    private void selecetedAlgoritmo(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selecetedAlgoritmo
        if (trigonometricRB.isSelected() || explicitEquationRB.isSelected() || midpointCircumferenceRB.isSelected()) {
            yRadiusValue.setVisible(false);
            bLabel.setVisible(false);
            aLabel.setText("Raio:");
            drawButton.setText("Desenhar Circunferência");
        } else {
            yRadiusValue.setVisible(true);
            bLabel.setVisible(true);
            aLabel.setText("a:");
            drawButton.setText("Desenhar Elipse");
        }
    }//GEN-LAST:event_selecetedAlgoritmo


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel aLabel;
    private javax.swing.JLabel bLabel;
    private javax.swing.ButtonGroup buttonGroupAlgoritmos;
    private javax.swing.JLabel circumferenceAlgorithmLabel;
    private javax.swing.JPanel circumferenceAlgorithmPanel;
    private javax.swing.JLabel dataLabel;
    private javax.swing.JPanel dataPanel;
    private javax.swing.JButton drawButton;
    private javax.swing.JLabel ellipseAlgorithmLabel;
    private javax.swing.JPanel ellipseAlgorithmPanel;
    private javax.swing.JRadioButton explicitEquationRB;
    private javax.swing.JRadioButton midpointCircumferenceRB;
    private javax.swing.JRadioButton midpointEllipseRB;
    private javax.swing.JRadioButton trigonometricRB;
    private javax.swing.JSpinner xRadiusValue;
    private javax.swing.JSpinner yRadiusValue;
    // End of variables declaration//GEN-END:variables
}