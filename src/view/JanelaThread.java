/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author rihor
 */
public class JanelaThread extends javax.swing.JInternalFrame {

    /**
     * Creates new form JanelaThread
     */
    public JanelaThread() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupo = new javax.swing.ButtonGroup();
        scroll = new javax.swing.JScrollPane();
        txtArea = new javax.swing.JTextArea();
        lblTitulo = new javax.swing.JLabel();
        btnStart = new javax.swing.JButton();
        btnStop = new javax.swing.JButton();
        comboThread = new javax.swing.JComboBox<>();
        rMaxima = new javax.swing.JRadioButton();
        rNormal = new javax.swing.JRadioButton();
        rMinima = new javax.swing.JRadioButton();

        setVisible(true);

        scroll.setBorder(javax.swing.BorderFactory.createTitledBorder("Visualização das threads"));
        scroll.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setDoubleBuffered(true);
        scroll.setFocusCycleRoot(true);

        txtArea.setEditable(false);
        txtArea.setColumns(20);
        txtArea.setRows(5);
        txtArea.setText("- Threads -\n");
        txtArea.setMargin(new java.awt.Insets(1, 1, 1, 1));
        scroll.setViewportView(txtArea);

        lblTitulo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(153, 0, 51));
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Thread");

        btnStart.setText("START");

        btnStop.setText("STOP");

        comboThread.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        comboThread.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Escolha uma Thread" }));

        rMaxima.setText("Prioridade Maxima");

        rNormal.setText("Prioridade Normal");

        rMinima.setText("Prioridade Minima");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnStart, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnStop, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboThread, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rMaxima)
                            .addComponent(rNormal)
                            .addComponent(rMinima))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTitulo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnStart)
                            .addComponent(btnStop))
                        .addGap(18, 18, 18)
                        .addComponent(comboThread, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(rMaxima)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rNormal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rMinima)
                        .addGap(0, 65, Short.MAX_VALUE))
                    .addComponent(scroll)))
        );

        grupo.add(rMaxima);
        grupo.add(rNormal);
        grupo.add(rMinima);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnStart;
    public javax.swing.JButton btnStop;
    public javax.swing.JComboBox<String> comboThread;
    public javax.swing.ButtonGroup grupo;
    private javax.swing.JLabel lblTitulo;
    public javax.swing.JRadioButton rMaxima;
    public javax.swing.JRadioButton rMinima;
    public javax.swing.JRadioButton rNormal;
    public javax.swing.JScrollPane scroll;
    public static javax.swing.JTextArea txtArea;
    // End of variables declaration//GEN-END:variables
}
