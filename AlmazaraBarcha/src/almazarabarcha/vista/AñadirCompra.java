package almazarabarcha.vista;

import almazarabarcha.Modelo.GestorAlmazara;
import almazarabarcha.Modelo.Validador;
import almazarabarcha.estilos.Estilos;
import capaDAO.DaoCompra;
import excepciones.BusinessException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import pojos.Compra;
import pojos.Proveedor;
import pojos.Usuario;

//Tener en cuenta: Las compras no tienen subencionado
public class AñadirCompra extends JFrame {

    private final Estilos estilos = new Estilos();
    Proveedor p;
    Usuario u;
    Compra compra;
    JPanel panelPrincipal;

    public AñadirCompra(Proveedor p, Usuario u,JPanel panelPrincipal) {
        initComponents();
        label_kg_oliva.setFont(estilos.getFuenteEtiquetas());
        label_observaciones.setFont(estilos.getFuenteEtiquetas());
        label_precio_kg_oliva.setFont(estilos.getFuenteEtiquetas());
        label_total.setFont(estilos.getFuenteEtiquetas());
        btn_añadir.setFont(estilos.getFuenteBotones());
        this.p = p;
        this.u = u;
        this.panelPrincipal = panelPrincipal;
        compra = new Compra();
        btn_añadir.setVisible(false);
        lb_nombre_cliente.setText(p.getNombre());
        text_total.setEnabled(false);
        text_kg_reflejar.setEnabled(false);
        text_maquila.setEnabled(false);
    }

    private AñadirCompra() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label_kg_oliva = new javax.swing.JLabel();
        text_kg_oliva = new javax.swing.JTextField();
        label_precio_kg_oliva = new javax.swing.JLabel();
        text_precio_kg = new javax.swing.JTextField();
        text_observaciones = new javax.swing.JTextField();
        label_observaciones = new javax.swing.JLabel();
        btn_añadir = new javax.swing.JButton();
        label_total = new javax.swing.JLabel();
        text_total = new javax.swing.JTextField();
        btn_calcular = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lb_nombre_cliente = new javax.swing.JLabel();
        checkFactura = new javax.swing.JCheckBox();
        checkDeclara = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        text_maquila = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        text_kg_reflejar = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        label_kg_oliva.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        label_kg_oliva.setText("Kg Oliva");

        text_kg_oliva.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        text_kg_oliva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_kg_olivaActionPerformed(evt);
            }
        });

        label_precio_kg_oliva.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        label_precio_kg_oliva.setText("Precio kg oliva");

        text_precio_kg.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        label_observaciones.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        label_observaciones.setText("Observaciones");

        btn_añadir.setText("Añadir Compra");
        btn_añadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_añadirActionPerformed(evt);
            }
        });

        label_total.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        label_total.setText("Total");

        text_total.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        text_total.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        btn_calcular.setText("Calcular importe de la compra");
        btn_calcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_calcularActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Cliente:");

        lb_nombre_cliente.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lb_nombre_cliente.setText("jLabel2");

        checkFactura.setText("Factura");

        checkDeclara.setText("Declara");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Maquila a Reflejar");

        text_maquila.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        text_maquila.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Kg a Reflejar");

        text_kg_reflejar.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        text_kg_reflejar.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_añadir, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(429, 429, 429))
            .addGroup(layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lb_nombre_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 483, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label_observaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(text_observaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 902, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(85, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(label_kg_oliva, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(label_precio_kg_oliva, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(label_total, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(text_kg_oliva, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(text_total, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(text_precio_kg, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(text_kg_reflejar, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(text_maquila, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btn_calcular)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(checkFactura)
                                .addGap(18, 18, 18)
                                .addComponent(checkDeclara)
                                .addGap(33, 33, 33)))
                        .addGap(172, 172, 172))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lb_nombre_cliente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(text_kg_oliva, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label_kg_oliva, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(text_precio_kg, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                            .addComponent(label_precio_kg_oliva, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(text_total, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                            .addComponent(label_total, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_calcular, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(text_maquila))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(text_kg_reflejar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(checkFactura)
                                    .addComponent(checkDeclara))))))
                .addGap(25, 25, 25)
                .addComponent(label_observaciones)
                .addGap(18, 18, 18)
                .addComponent(text_observaciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(btn_añadir, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_añadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_añadirActionPerformed
        Validador validador = new Validador();
        String kg_oliva;
        String precio_kg;
        String error = "Campos con valores no válidos:\n";
        boolean ok = true;

        kg_oliva = validador.corregirNumeros(text_kg_oliva.getText());
        precio_kg = validador.corregirNumeros(text_precio_kg.getText());

        /*if (!validador.validarNumeroDecimal(kg_oliva) || !validador.validarNumeroEntero(kg_oliva)) {
            error += "Kg Oliva\n";
            ok = false;
        }

        if (!validador.validarNumeroDecimal(precio_kg) || !validador.validarNumeroEntero(precio_kg)) {
            error += "Precio Kg Oliva\n";
            ok = false;
        }*/

        if (!ok) {
            JOptionPane.showMessageDialog(null, error, "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            compra.setProveedor(p);
            compra.setUsuario(u);
            compra.setObservaciones(text_observaciones.getText());

            /*if (check_pagado.isSelected()) {
                compra.setPagado(true);
            } else {
                compra.setPagado(false);
            }*/

            if(checkFactura.isSelected()){
                compra.setFactura(true);
            }else{
                compra.setFactura(false);
            }
            
            if(checkDeclara.isSelected()){
                compra.setDeclara(true);
            }else{
                compra.setDeclara(false);
            }
            
            compra.setFecha(new java.util.Date());

            try {
                DaoCompra.insertar(compra);
                JOptionPane.showMessageDialog(null, "Se ha añadido la compra correctamente al cliente: " + p.getNombre());
                GestorAlmazara.RetrocederASeleccionarCliente(panelPrincipal, estilos, u);
            } catch (BusinessException ex) {
                Logger.getLogger(AñadirCompra.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btn_añadirActionPerformed

    private void text_kg_olivaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_kg_olivaActionPerformed

    }//GEN-LAST:event_text_kg_olivaActionPerformed

    private void btn_calcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_calcularActionPerformed
        float kilos;
        float precio_kg_oliva;

        if (text_kg_oliva.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Faltan campos por completar");
        } else {

            kilos = Float.parseFloat(text_kg_oliva.getText().replaceAll(",", "."));
            precio_kg_oliva = Float.parseFloat(text_precio_kg.getText().replaceAll(",", "."));
            compra.setKgOliva(kilos);
            compra.setPrecioKg(precio_kg_oliva);
            btn_añadir.setVisible(true);
            compra.calcularTotalCompra();
            text_total.setText(String.format("%.2f",(compra.getTotalCompra())));
            if (checkFactura.isSelected()) {
                compra.setMaquilaReflejada((float) (kilos * 0.15));
                text_maquila.setText(String.format("%.2f", (kilos * 0.15)));
            } else {
                if (checkDeclara.isSelected()) {
                    compra.setMaquilaReflejada((float) (kilos * 0.04));
                    text_maquila.setText(String.format("%.2f", (kilos * 0.04)));
                } else {
                    compra.setMaquilaReflejada(0);
                    text_maquila.setText(String.format("%.2f", 0.0));
                }
            }

            if (checkDeclara.isSelected()) {
                text_kg_reflejar.setText(String.format("%.2f", compra.getKgOliva()));
            } else {
                text_kg_reflejar.setText(String.format("%.2f", 0.0));
            }
        }
    }//GEN-LAST:event_btn_calcularActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_añadir;
    private javax.swing.JButton btn_calcular;
    private javax.swing.JCheckBox checkDeclara;
    private javax.swing.JCheckBox checkFactura;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel label_kg_oliva;
    private javax.swing.JLabel label_observaciones;
    private javax.swing.JLabel label_precio_kg_oliva;
    private javax.swing.JLabel label_total;
    private javax.swing.JLabel lb_nombre_cliente;
    private javax.swing.JTextField text_kg_oliva;
    private javax.swing.JTextField text_kg_reflejar;
    private javax.swing.JTextField text_maquila;
    private javax.swing.JTextField text_observaciones;
    private javax.swing.JTextField text_precio_kg;
    private javax.swing.JTextField text_total;
    // End of variables declaration//GEN-END:variables
}
