package almazarabarcha.vista;

import almazarabarcha.Modelo.GestorAlmazara;
import almazarabarcha.Modelo.Validador;
import almazarabarcha.estilos.Estilos;
import capaDAO.DaoCambio;
import excepciones.BusinessException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import pojos.Cambio;
import pojos.Proveedor;
import pojos.Usuario;

public class AñadirCambio extends JFrame {

    private final Estilos estilos = new Estilos();
    Proveedor p;
    Usuario u;
    Cambio cambio;
    JPanel panelPrincipal;

    public AñadirCambio(Proveedor p, Usuario u, JPanel panelPrincipal) {
        initComponents();
        label_kg_oliva.setFont(estilos.getFuenteEtiquetas());
        label_rendimiento.setFont(estilos.getFuenteEtiquetas());
        label_maquila.setFont(estilos.getFuenteEtiquetas());
        label_litros_cambio.setFont(estilos.getFuenteEtiquetas());
        label_aceite_retirado.setFont(estilos.getFuenteEtiquetas());
        label_observaciones.setFont(estilos.getFuenteEtiquetas());
        btn_añadir_cambio.setFont(estilos.getFuenteBotones());
        text_ref_maquila.setText("");
        this.p = p;
        this.u = u;
        this.panelPrincipal = panelPrincipal;
        cambio = new Cambio();
        text_litros_cambio.setEnabled(false);
        text_litros_retirado.setEnabled(false);
        text_precio_molturacion.setEnabled(false);
        text_maquila_reflejada.setEnabled(false);
        text_maquila.setEnabled(false);
        btn_añadir_cambio.setVisible(false);

    }

    private AñadirCambio() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        buttonGroup1 = new javax.swing.ButtonGroup();
        text_observaciones = new javax.swing.JTextField();
        label_observaciones = new javax.swing.JLabel();
        btn_añadir_cambio = new javax.swing.JButton();
        label_kg_oliva = new javax.swing.JLabel();
        label_rendimiento = new javax.swing.JLabel();
        text_rendimiento = new javax.swing.JTextField();
        text_kg_oliva = new javax.swing.JTextField();
        check_retira = new javax.swing.JCheckBox();
        check_paga = new javax.swing.JCheckBox();
        label_litros_cambio = new javax.swing.JLabel();
        text_litros_cambio = new javax.swing.JTextField();
        label_aceite_retirado = new javax.swing.JLabel();
        text_litros_retirado = new javax.swing.JTextField();
        label_maquila = new javax.swing.JLabel();
        text_ref_maquila = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        text_precio_molturacion = new javax.swing.JTextField();
        btn_calcular_total = new javax.swing.JButton();
        check_declara = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        text_maquila_reflejada = new javax.swing.JTextField();
        text_maquila = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_poblacion_oliva = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        label_observaciones.setText("Observaciones");

        btn_añadir_cambio.setText("Añadir Cambio");
        btn_añadir_cambio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_añadir_cambioActionPerformed(evt);
            }
        });

        label_kg_oliva.setText("Kg oliva");

        label_rendimiento.setText("Rendimiento");

        text_rendimiento.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        text_kg_oliva.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        check_retira.setText("Retira");

        check_paga.setText("Paga");
        check_paga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                check_pagaActionPerformed(evt);
            }
        });

        label_litros_cambio.setText("Litros para cambio ");

        text_litros_cambio.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        text_litros_cambio.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        text_litros_cambio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_litros_cambioActionPerformed(evt);
            }
        });

        label_aceite_retirado.setText("Litros aceite retirado");

        text_litros_retirado.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        text_litros_retirado.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        label_maquila.setText("Ref % Maquila");

        text_ref_maquila.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        text_ref_maquila.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_ref_maquilaActionPerformed(evt);
            }
        });

        jLabel1.setText("Precio molturación");

        text_precio_molturacion.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        text_precio_molturacion.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        text_precio_molturacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_precio_molturacionActionPerformed(evt);
            }
        });

        btn_calcular_total.setText("Calcular");
        btn_calcular_total.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_calcular_totalActionPerformed(evt);
            }
        });

        check_declara.setText("Declara");
        check_declara.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                check_declaraActionPerformed(evt);
            }
        });

        jLabel2.setText("Maquila Reflejada");

        text_maquila_reflejada.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        text_maquila_reflejada.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        text_maquila.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        text_maquila.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        jLabel3.setText("Maquila");

        jLabel4.setText("Población oliva");

        txt_poblacion_oliva.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_poblacion_oliva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_poblacion_olivaActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("%");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("%");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(470, 470, 470)
                .addComponent(btn_añadir_cambio, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(check_declara, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(check_retira))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(check_paga, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(171, 171, 171)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(label_observaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1010, 1010, 1010))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(label_rendimiento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(label_kg_oliva, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(label_maquila, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(8, 8, 8)
                                                .addComponent(text_kg_oliva, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(text_rendimiento, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(text_ref_maquila, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel6))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addGap(66, 66, 66)
                                                .addComponent(text_precio_molturacion, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(label_aceite_retirado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(label_litros_cambio, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(text_litros_cambio, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                                                    .addComponent(text_litros_retirado, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                                                    .addComponent(txt_poblacion_oliva))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(jLabel2)
                                                    .addComponent(jLabel3))))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(text_maquila_reflejada, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                                            .addComponent(btn_calcular_total, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(text_maquila))
                                        .addGap(91, 91, 91))
                                    .addComponent(text_observaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 946, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(181, 181, 181))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(check_paga)
                    .addComponent(check_declara)
                    .addComponent(check_retira)
                    .addComponent(jLabel4)
                    .addComponent(txt_poblacion_oliva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(text_litros_cambio, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label_litros_cambio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(text_kg_oliva, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label_kg_oliva))
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(text_litros_retirado, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label_aceite_retirado)
                            .addComponent(label_rendimiento)
                            .addComponent(text_rendimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5))
                        .addGap(24, 24, 24))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(text_maquila_reflejada, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addComponent(text_maquila, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(text_ref_maquila, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_maquila)
                    .addComponent(jLabel1)
                    .addComponent(text_precio_molturacion, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_calcular_total, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(62, 62, 62)
                .addComponent(label_observaciones)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(text_observaciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(btn_añadir_cambio, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_añadir_cambioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_añadir_cambioActionPerformed
        /*
         if (text_kg_oliva.getText().equals("") || text_rendimiento.getText().equals("")) {
         JOptionPane.showMessageDialog(null, "Faltan campos por completar");
         } else {
         float kilos = Float.parseFloat(text_kg_oliva.getText());
         cambio.setKgOliva(kilos);

         float rend = Float.parseFloat(text_rendimiento.getText());
         cambio.setRendimiento(rend);
         }

         if (text_observaciones.getText().equals("")) {
         text_observaciones.setText("");
         }

         if (text_maquila.getText().equals("0")) {
         cambio.setMaquila(0);

         } else {
         float maquila = Float.parseFloat(text_maquila.getText());
         cambio.setPorcentajeMaquila(maquila);
         }
        
         float precio_molt = cambio.CalcularPrecioMulturacion();
         cambio.setPrecioMolturacion(precio_molt);
         text_precio_molturacion.setText(String.valueOf(precio_molt));
            
         float litros_cambio = cambio.CalcularLitrosAceiteParaCambio();
         text_litros_cambio.setText(String.valueOf(litros_cambio));
         cambio.setLitrosCambio(litros_cambio);

         if (Float.parseFloat(text_maquila.getText()) > 0) {
         float litros_retira = cambio.CalcularLitrosParaRetirar();
         text_litros_retirado.setText(String.valueOf(litros_retira));
         cambio.setLitrosRetirados(litros_retira);
            
         }
         else{
         text_litros_retirado.setText(String.valueOf(litros_cambio));
         cambio.setLitrosRetirados(litros_cambio);
         cambio.CalcularPrecioMulturacion();
         }
        
        
         //cambio.setFactura(check_factura.isSelected());
         cambio.setPaga(check_paga.isSelected());
         cambio.setObservaciones(text_observaciones.getText());

         cambio.setCliente(c);
         cambio.setUsuario(u);

         try {
         DaoCambio.insertar(cambio);
         } catch (BusinessException ex) {
         Logger.getLogger(AñadirCambio.class.getName()).log(Level.SEVERE, null, ex);
         }

         JOptionPane.showMessageDialog(null, "Se ha añadido el cambio correctamente al cliente: " + c.getNombre());
         */
        try {
            DaoCambio.insertar(cambio);
            JOptionPane.showMessageDialog(null, "Se ha añadido el cambio correctamente al cliente: " + p.getNombre());
            GestorAlmazara.RetrocederASeleccionarCliente(panelPrincipal, estilos, u);
        } catch (BusinessException ex) {
            Logger.getLogger(AñadirCambio.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_btn_añadir_cambioActionPerformed

    private void text_litros_cambioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_litros_cambioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_text_litros_cambioActionPerformed

    private void text_ref_maquilaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_ref_maquilaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_text_ref_maquilaActionPerformed

    private void text_precio_molturacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_precio_molturacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_text_precio_molturacionActionPerformed

    private void btn_calcular_totalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_calcular_totalActionPerformed
        float precio_molt, litros_cambio = 0, litros_retira;
        String kg_oliva, rendimiento, maquila;
        Validador validador = new Validador();
        String error = "Campos con valores no válidos:\n";
        boolean ok = true;

        kg_oliva = validador.corregirNumeros(text_kg_oliva.getText());
        rendimiento = validador.corregirNumeros(text_rendimiento.getText());
        maquila = validador.corregirNumeros(text_ref_maquila.getText());

        if (!validador.validarNumeroDecimal(kg_oliva)) {
            error += "Kg Oliva\n";
            ok = false;
        }

        if (!validador.validarNumeroDecimal(rendimiento)) {
            error += "Rendimiento\n";
            ok = false;
        }

        /*if (validador.validarNumeroDecimal(maquila)) {
         error += "Maquila\n";
         ok = false;
         }*/
        if (!ok) {
            JOptionPane.showMessageDialog(null, error, "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            cambio.setKgOliva(Float.parseFloat(kg_oliva));
            cambio.setRendimiento(Float.parseFloat(rendimiento));

            litros_cambio = cambio.CalcularLitrosAceiteParaCambio();
            cambio.setLitrosAceiteCambio(litros_cambio);
            cambio.setKgAceiteCambio(litros_cambio);
            text_litros_cambio.setText(String.format("%.2f", cambio.getLitrosAceiteCambio()));

            if (check_declara.isSelected()) {

                cambio.setMaquilaReflejada(cambio.CalcularMaquilaReflejar());
                text_maquila_reflejada.setText(String.format("%.2f", cambio.getMaquilaReflejada()));
                cambio.setDeclara(true);
            } else {
                cambio.setMaquilaReflejada(0);
                text_maquila_reflejada.setText(String.format("%.2f", 0.0));
                cambio.setDeclara(false);
            }

            if (check_paga.isSelected()) {

                precio_molt = cambio.CalcularPrecioMulturacion();
                cambio.setPrecioMolturacion(precio_molt);
                text_precio_molturacion.setText(String.format("%.2f", precio_molt));

            } else {
                cambio.setPrecioMolturacion(0);
                text_precio_molturacion.setText(String.format("%.2f", 0.0));

            }

            if (check_retira.isSelected()) {
                if (text_ref_maquila.getText().equals("")) {
                    cambio.setPorcentajeMaquila(0);
                    cambio.setMaquila(0);
                    text_maquila.setText(String.format("%.2f", cambio.getMaquila()));
                    litros_retira = cambio.CalcularLitrosAceiteParaCambio();
                    text_litros_retirado.setText(String.format("%.2f", litros_retira));
                    cambio.setLitrosAceiteRetirados(litros_retira);
                    cambio.setKgAceiteRetirados(litros_retira);
                    cambio.setRetira(true);
                    precio_molt = cambio.CalcularPrecioMulturacion();
                    cambio.setPrecioMolturacion(precio_molt);
                    text_precio_molturacion.setText(String.format("%.2f", precio_molt));
                } else {
                    cambio.setPorcentajeMaquila(Float.parseFloat(text_ref_maquila.getText().replaceAll(",", ".")));
                    cambio.setMaquila(cambio.CalcularMaquila());
                    text_maquila.setText(String.format("%.2f", cambio.getMaquila()));
                    litros_retira = cambio.CalcularLitrosParaRetirar();
                    text_litros_retirado.setText(String.format("%.2f", litros_retira));
                    cambio.setLitrosAceiteRetirados(litros_retira);
                    cambio.setKgAceiteRetirados(litros_retira);
                    cambio.setRetira(true);
                }

            } else {
                cambio.setKgAceiteRetirados((float) 0);
                text_litros_retirado.setText(String.format("%.2f", 0.0));
                cambio.setLitrosAceiteRetirados(0);
                cambio.setRetira(false);
            }

            cambio.setPaga(false);
            cambio.setFecha(new java.util.Date());
            cambio.setPoblacionOliva(txt_poblacion_oliva.getText());
            cambio.setObservaciones(text_observaciones.getText());
            cambio.setProveedor(p);
            cambio.setUsuario(u);
            btn_añadir_cambio.setVisible(true);
        }

    }//GEN-LAST:event_btn_calcular_totalActionPerformed

    private void check_pagaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_check_pagaActionPerformed

    }//GEN-LAST:event_check_pagaActionPerformed

    private void check_declaraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_check_declaraActionPerformed

    }//GEN-LAST:event_check_declaraActionPerformed

    private void txt_poblacion_olivaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_poblacion_olivaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_poblacion_olivaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_añadir_cambio;
    private javax.swing.JButton btn_calcular_total;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox check_declara;
    private javax.swing.JCheckBox check_paga;
    private javax.swing.JCheckBox check_retira;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel label_aceite_retirado;
    private javax.swing.JLabel label_kg_oliva;
    private javax.swing.JLabel label_litros_cambio;
    private javax.swing.JLabel label_maquila;
    private javax.swing.JLabel label_observaciones;
    private javax.swing.JLabel label_rendimiento;
    private javax.swing.JTextField text_kg_oliva;
    private javax.swing.JTextField text_litros_cambio;
    private javax.swing.JTextField text_litros_retirado;
    private javax.swing.JTextField text_maquila;
    private javax.swing.JTextField text_maquila_reflejada;
    private javax.swing.JTextField text_observaciones;
    private javax.swing.JTextField text_precio_molturacion;
    private javax.swing.JTextField text_ref_maquila;
    private javax.swing.JTextField text_rendimiento;
    private javax.swing.JTextField txt_poblacion_oliva;
    // End of variables declaration//GEN-END:variables
}
