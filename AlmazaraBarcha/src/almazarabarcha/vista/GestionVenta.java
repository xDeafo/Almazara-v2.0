/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package almazarabarcha.vista;

import capaDAO.DaoVenta;
import excepciones.BusinessException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import pojos.Cliente;
import pojos.Venta;

public class GestionVenta extends JFrame {

    private Cliente c;

    private List<Venta> todasVentas;

    public GestionVenta(Cliente c) {
        this.c = c;
        initComponents();
        lbl_cliente.setText(c.getNombre());
        //estilos = new Estilos();
        //this.jpanel = jpanel;
        //this.p = p;

        try {
            todasVentas = DaoVenta.getVentasCliente(c);

        } catch (BusinessException ex) {
            Logger.getLogger(GestionMolturaciones.class.getName()).log(Level.SEVERE, null, ex);
        }

        DefaultTableModel modelo = (DefaultTableModel) tabla_pagados.getModel();
        Object[] filaVentas = new Object[3];
        for (Venta vnp : todasVentas) {
            filaVentas[0] = vnp.getIdVenta();
            filaVentas[1] = vnp.getFecha();
            filaVentas[2] = vnp.getTotalVenta();

            modelo.addRow(filaVentas);
        }
        //tabla_pagados.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        //tabla_pagados.getColumnModel().getColumn(0).setPreferredWidth(30);
        tabla_pagados.setModel(modelo);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label_titulo = new javax.swing.JLabel();
        label_pagados = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla_pagados = new javax.swing.JTable();
        lbl_cliente = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        label_titulo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        label_titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_titulo.setText("Gestión Venta");

        label_pagados.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        label_pagados.setText("Ventas realizadas por el cliente:");

        tabla_pagados.setBackground(new java.awt.Color(102, 255, 102));
        tabla_pagados.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tabla_pagados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Fecha", "Total Venta"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla_pagados.setToolTipText("");
        tabla_pagados.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tabla_pagados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla_pagadosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabla_pagados);

        lbl_cliente.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_cliente.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label_titulo, javax.swing.GroupLayout.DEFAULT_SIZE, 1080, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1080, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(label_pagados)
                        .addGap(18, 18, 18)
                        .addComponent(lbl_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(label_titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_pagados)
                    .addComponent(lbl_cliente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(102, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tabla_pagadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_pagadosMouseClicked
        System.out.println("No pagados fila -->" + tabla_pagados.getSelectedRow());
    }//GEN-LAST:event_tabla_pagadosMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel label_pagados;
    private javax.swing.JLabel label_titulo;
    private javax.swing.JLabel lbl_cliente;
    private javax.swing.JTable tabla_pagados;
    // End of variables declaration//GEN-END:variables
}