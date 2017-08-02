package almazarabarcha.vista;

import almazarabarcha.estilos.Estilos;
import excepciones.BusinessException;
import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;
import pojos.Proveedor;
import pojos.Usuario;

public class GestorOperaciones extends JFrame {

    private final Estilos estilos = new Estilos();
    private Proveedor p;
    private Usuario u;
    private JPanel panelPrincipal;

    public GestorOperaciones(Proveedor p, Usuario u, JPanel panelPrincipal) {
        initComponents();
        this.setLocation(250, 150);
        this.setBackground(estilos.getColorInterior());
        jPanel1.setBackground(estilos.getColorInterior());
        btn_camb.setFont(estilos.getFuenteBotones());
        btn_comp.setFont(estilos.getFuenteBotones());
        btn_molt.setFont(estilos.getFuenteBotones());
        this.panelPrincipal = panelPrincipal;
        this.p = p;
        this.u = u;
    }

    private GestorOperaciones() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_molt = new javax.swing.JButton();
        btn_comp = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        btn_camb = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setUndecorated(true);

        btn_molt.setText("Molturacion");
        btn_molt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_moltActionPerformed(evt);
            }
        });

        btn_comp.setText("Compra");
        btn_comp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_compActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 450, Short.MAX_VALUE)
        );

        btn_camb.setText("Cambio");
        btn_camb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cambActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(139, 139, 139)
                .addComponent(btn_molt, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(126, 126, 126)
                .addComponent(btn_comp, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(126, 126, 126)
                .addComponent(btn_camb, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(138, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                    .addComponent(btn_camb, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_comp, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_molt, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_moltActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_moltActionPerformed
        AñadirMolturacion m;
        m = new AñadirMolturacion(p, u,panelPrincipal);
        jPanel1.removeAll();
        m.getContentPane().setBackground(estilos.getColorInterior());
        jPanel1.add(m.getContentPane());
        jPanel1.repaint();
        btn_molt.setBackground(Color.YELLOW);
        btn_camb.setBackground(Color.LIGHT_GRAY);
        btn_comp.setBackground(Color.LIGHT_GRAY);


    }//GEN-LAST:event_btn_moltActionPerformed

    private void btn_compActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_compActionPerformed
        AñadirCompra c = new AñadirCompra(p, u,panelPrincipal);
        jPanel1.removeAll();
        c.getContentPane().setBackground(estilos.getColorInterior());
        jPanel1.add(c.getContentPane());
        jPanel1.repaint();
        btn_comp.setBackground(Color.YELLOW);
        btn_molt.setBackground(Color.LIGHT_GRAY);
        btn_camb.setBackground(Color.LIGHT_GRAY);

    }//GEN-LAST:event_btn_compActionPerformed

    private void btn_cambActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cambActionPerformed
        AñadirCambio c = new AñadirCambio(p, u,panelPrincipal);
        jPanel1.removeAll();
        c.getContentPane().setBackground(estilos.getColorInterior());
        jPanel1.add(c.getContentPane());
        jPanel1.repaint();
        btn_camb.setBackground(Color.YELLOW);
        btn_molt.setBackground(Color.LIGHT_GRAY);
        btn_comp.setBackground(Color.LIGHT_GRAY);

    }//GEN-LAST:event_btn_cambActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_camb;
    private javax.swing.JButton btn_comp;
    private javax.swing.JButton btn_molt;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
