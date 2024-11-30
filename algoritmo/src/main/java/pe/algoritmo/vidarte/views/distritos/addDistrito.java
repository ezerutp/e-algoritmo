/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package pe.algoritmo.vidarte.views.distritos;

import pe.algoritmo.vidarte.controllers.DistritoController;
import pe.algoritmo.vidarte.models.Distrito;
import pe.algoritmo.vidarte.utils.ValidadorCampos;

/**
 *
 * @author VIDARTE
 */
public class addDistrito extends javax.swing.JDialog {

    private DistritoController control;

    public addDistrito(java.awt.Frame parent, boolean modal, DistritoController control) {
        super(parent, modal);
        initComponents();
        this.control = control;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtDistrito = new javax.swing.JTextField();
        btnRegistrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel19.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("AGREGAR");
        jLabel19.setToolTipText("");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 250, 30));

        jLabel16.setText("DISTRITO");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 120, 30));
        jPanel1.add(txtDistrito, new org.netbeans.lib.awtextra.AbsoluteConstraints(91, 50, 190, 30));

        btnRegistrar.setBackground(new java.awt.Color(102, 255, 102));
        btnRegistrar.setText("REGISTRAR");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, 120, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        boolean validar = ValidadorCampos.validarCampos(txtDistrito);
        if (validar) {
            Distrito cdistrito = new Distrito();
            cdistrito.setNombre(txtDistrito.getText());
            
            control.registrar(cdistrito);

            javax.swing.JOptionPane.showMessageDialog(this, "Registro exitoso.", "Registro", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Debe completar todos los campos.", "Campos incompletos", javax.swing.JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtDistrito;
    // End of variables declaration//GEN-END:variables
}
