/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package pe.algoritmo.vidarte.views.mesas;

import pe.algoritmo.vidarte.controllers.DistritoController;
import pe.algoritmo.vidarte.controllers.MesaController;
import pe.algoritmo.vidarte.models.Distrito;
import pe.algoritmo.vidarte.models.Mesa;
import pe.algoritmo.vidarte.utils.Utilidades;
import pe.algoritmo.vidarte.utils.ValidadorCampos;

/**
 *
 * @author VIDARTE
 */
public class addMesas extends javax.swing.JDialog {

    private MesaController control;

    public addMesas(java.awt.Frame parent, boolean modal, MesaController control) {
        super(parent, modal);
        initComponents();
        this.control = control;
        Utilidades.validarNumero(txtSeccion);
        
        DistritoController controldis = new DistritoController();
        for (String distrito : controldis.getNombresDistritos()) {
            jComboBox1.addItem(distrito);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        btnRegistrar4 = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();
        txtSeccion = new javax.swing.JTextField();
        txtTipo = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel24.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("AGREGAR");
        jLabel24.setToolTipText("");
        jPanel5.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 300, 30));

        jLabel25.setText("DISTRITO");
        jPanel5.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 120, 30));

        btnRegistrar4.setBackground(new java.awt.Color(102, 255, 102));
        btnRegistrar4.setText("REGISTRAR");
        btnRegistrar4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrar4ActionPerformed(evt);
            }
        });
        jPanel5.add(btnRegistrar4, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 140, 120, 40));

        jLabel26.setText("SECCION");
        jPanel5.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 70, 30));
        jPanel5.add(txtSeccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, 70, 30));
        jPanel5.add(txtTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 90, 100, 30));

        jLabel27.setText("TIPO");
        jPanel5.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, 80, 30));

        jPanel5.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, 230, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrar4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrar4ActionPerformed
        boolean validador = ValidadorCampos.validarCampos(txtSeccion, txtTipo);
        if (validador) {
            Mesa mesa = new Mesa();
            DistritoController controler = new DistritoController();
            Distrito distrito = controler.getDistritoById(jComboBox1.getSelectedIndex() + 1);
            mesa.setDistrito(distrito);
            mesa.setSeccion(Integer.parseInt(txtSeccion.getText()));
            mesa.setTipoMesa(txtTipo.getText());
            control.registrar(mesa);

            javax.swing.JOptionPane.showMessageDialog(this, "Registro exitoso.", "Registro", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Debe completar todos los campos.", "Campos incompletos", javax.swing.JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnRegistrar4ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistrar4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JTextField txtSeccion;
    private javax.swing.JTextField txtTipo;
    // End of variables declaration//GEN-END:variables
}
