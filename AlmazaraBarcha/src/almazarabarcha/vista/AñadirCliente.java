package almazarabarcha.vista;

import almazarabarcha.Modelo.Validador;
import almazarabarcha.estilos.Estilos;
import capaDAO.DaoCliente;
import capaDAO.DaoProveedor;
import excepciones.BusinessException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import pojos.Cliente;
import pojos.Proveedor;

public class AñadirCliente extends JFrame {

    private final Estilos estilos;

    public AñadirCliente() {
        estilos = new Estilos();
        initComponents();
        //this.setBackground(estilos.getColorInterior());
        label_direccion.setFont(estilos.getFuenteEtiquetas());
        label_dni.setFont(estilos.getFuenteEtiquetas());
        label_nombre.setFont(estilos.getFuenteEtiquetas());
        label_poblacion.setFont(estilos.getFuenteEtiquetas());
        label_telefono.setFont(estilos.getFuenteEtiquetas());
        label_titulo.setFont(estilos.getFuenteTitulo2());
        btn_añadirCliente.setFont(estilos.getFuenteBotones());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        label_titulo = new javax.swing.JLabel();
        label_nombre = new javax.swing.JLabel();
        label_dni = new javax.swing.JLabel();
        label_direccion = new javax.swing.JLabel();
        label_poblacion = new javax.swing.JLabel();
        label_telefono = new javax.swing.JLabel();
        txtfDni = new javax.swing.JTextField();
        text_nombre = new javax.swing.JTextField();
        text_direccion = new javax.swing.JTextField();
        text_poblacion = new javax.swing.JTextField();
        text_telefono = new javax.swing.JTextField();
        btn_añadirCliente = new javax.swing.JButton();
        check_subencionado = new javax.swing.JCheckBox();
        radio_cliente = new javax.swing.JRadioButton();
        radio_proveedor = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        label_titulo.setText("Añadir Cliente");

        label_nombre.setText("Nombre");

        label_dni.setText("DNI");

        label_direccion.setText("Direccion");

        label_poblacion.setText("Poblacion");

        label_telefono.setText("Telefono");

        txtfDni.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        text_nombre.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        text_direccion.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        text_poblacion.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        text_telefono.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        text_telefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_telefonoActionPerformed(evt);
            }
        });

        btn_añadirCliente.setText("Añadir Cliente");
        btn_añadirCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_añadirClienteActionPerformed(evt);
            }
        });

        check_subencionado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        check_subencionado.setText("Subencionado");

        buttonGroup1.add(radio_cliente);
        radio_cliente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        radio_cliente.setText("Cliente");
        radio_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radio_clienteActionPerformed(evt);
            }
        });

        buttonGroup1.add(radio_proveedor);
        radio_proveedor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        radio_proveedor.setSelected(true);
        radio_proveedor.setText("Proveedor");
        radio_proveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radio_proveedorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 407, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(label_titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(330, 330, 330))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btn_añadirCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(505, 505, 505))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(label_nombre, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                                    .addComponent(label_dni, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtfDni))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(label_direccion, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(label_poblacion, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(108, 108, 108)
                            .addComponent(radio_cliente)
                            .addGap(18, 18, 18)
                            .addComponent(radio_proveedor)
                            .addGap(102, 102, 102)
                            .addComponent(check_subencionado))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(62, 62, 62)
                            .addComponent(label_telefono, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(text_telefono, javax.swing.GroupLayout.PREFERRED_SIZE, 890, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGap(102, 102, 102)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(text_poblacion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 890, Short.MAX_VALUE)
                                .addComponent(text_direccion, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(text_nombre, javax.swing.GroupLayout.Alignment.TRAILING)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label_titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtfDni, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_dni))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(label_poblacion)
                        .addGap(33, 33, 33))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(text_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label_nombre))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(text_direccion, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label_direccion))
                        .addGap(18, 18, 18)
                        .addComponent(text_poblacion, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(text_telefono, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_telefono))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(check_subencionado)
                    .addComponent(radio_cliente)
                    .addComponent(radio_proveedor))
                .addGap(16, 16, 16)
                .addComponent(btn_añadirCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void text_telefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_telefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_text_telefonoActionPerformed

    private void btn_añadirClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_añadirClienteActionPerformed
        Validador validador = new Validador();
        boolean ok_insercion = false;
        boolean ok_dni;
        boolean ok_telefono;

        Cliente c = new Cliente();
        Proveedor p = new Proveedor();

        p.setDni(validador.corregirNumeros(this.txtfDni.getText()));
        p.setNombre(this.text_nombre.getText());
        p.setDireccion(this.text_direccion.getText());
        p.setPoblacion(this.text_poblacion.getText());
        p.setTelefono(validador.corregirNumeros(this.text_telefono.getText()));
        p.setSubvencionado(check_subencionado.isSelected());

        c.setDni(validador.corregirNumeros(this.txtfDni.getText()));
        c.setNombre(this.text_nombre.getText());
        c.setDireccion(this.text_direccion.getText());
        c.setPoblacion(this.text_poblacion.getText());
        c.setTelefono(validador.corregirNumeros(this.text_telefono.getText()));

        if (txtfDni.getText().equals("")) {

            if (!p.getNombre().isEmpty()) {
                if (radio_proveedor.isSelected()) {

                    try {
                        ok_insercion = DaoProveedor.insertar(p);
                    } catch (BusinessException ex) {
                        Logger.getLogger(AñadirCliente.class.getName()).log(Level.SEVERE, null, ex);
                    }

                } else {
                    try {
                        ok_insercion = DaoCliente.insertar(c);
                    } catch (BusinessException ex) {
                        Logger.getLogger(AñadirCliente.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                /*else
                 {
                 try {
                 ok_insercion = DaoProveedor.insertar(c);
                 } catch (BusinessException ex) {
                 Logger.getLogger(AñadirCliente.class.getName()).log(Level.SEVERE, null, ex);
                 }
                 }
                 */

                if (!ok_insercion) {
                    JOptionPane.showMessageDialog(null, "Ya existe un cliente con ese nombre", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "El cliente/proveedor se ha añadido correctamente");
                }
            } else {
                JOptionPane.showMessageDialog(null, "El campo nombre es obligatorio", "Campo nombre vacío", JOptionPane.ERROR_MESSAGE);
            }

            txtfDni.setText(null);
            text_nombre.setText(null);
            text_direccion.setText(null);
            text_poblacion.setText(null);
            text_telefono.setText(null);

        } else {

            if (text_telefono.getText().isEmpty()||!text_telefono.getText().isEmpty()) {
                ok_dni = validador.validarNIF(this.txtfDni.getText().toUpperCase());

                if (ok_dni) {
                    if (!p.getNombre().isEmpty()) {
                        if (radio_proveedor.isSelected()) {

                            try {
                                ok_insercion = DaoProveedor.insertar(p);
                            } catch (BusinessException ex) {
                                Logger.getLogger(AñadirCliente.class.getName()).log(Level.SEVERE, null, ex);
                            }

                        } else {
                            try {
                                ok_insercion = DaoCliente.insertar(c);
                            } catch (BusinessException ex) {
                                Logger.getLogger(AñadirCliente.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        /*else
                         {
                         try {
                         ok_insercion = DaoProveedor.insertar(c);
                         } catch (BusinessException ex) {
                         Logger.getLogger(AñadirCliente.class.getName()).log(Level.SEVERE, null, ex);
                         }
                         }
                         */
                        if (!ok_insercion) {
                            JOptionPane.showMessageDialog(null, "Ya existe un cliente con ese nombre", "Error", JOptionPane.ERROR_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "El cliente/proveedor se ha añadido correctamente");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "El campo nombre es obligatorio", "Campo nombre vacío", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    String mal_insertado = "Hay errores en: \n";

                    if (!ok_dni) {
                        mal_insertado += "DNI: 8 dígitos y 1 letra\n Asegurese que el DNI sea correcto\n";
                    }

                    JOptionPane.showMessageDialog(null, mal_insertado, "Error en inserción", JOptionPane.ERROR_MESSAGE);
                }

                txtfDni.setText(null);
                text_nombre.setText(null);
                text_direccion.setText(null);
                text_poblacion.setText(null);
                text_telefono.setText(null);

            } else {

                if (!p.getNombre().isEmpty()) {
                    if (radio_proveedor.isSelected()) {

                        try {
                            ok_insercion = DaoProveedor.insertar(p);
                        } catch (BusinessException ex) {
                            Logger.getLogger(AñadirCliente.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    } else {
                        try {
                            ok_insercion = DaoCliente.insertar(c);
                        } catch (BusinessException ex) {
                            Logger.getLogger(AñadirCliente.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    /*else
                     {
                     try {
                     ok_insercion = DaoProveedor.insertar(c);
                     } catch (BusinessException ex) {
                     Logger.getLogger(AñadirCliente.class.getName()).log(Level.SEVERE, null, ex);
                     }
                     }
                     */

                    if (!ok_insercion) {
                        JOptionPane.showMessageDialog(null, "Ya existe un cliente con ese nombre", "Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "El cliente/proveedor se ha añadido correctamente");
                    }
                }
            }

        }


    }//GEN-LAST:event_btn_añadirClienteActionPerformed

    private void radio_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radio_clienteActionPerformed
        check_subencionado.setEnabled(false);
    }//GEN-LAST:event_radio_clienteActionPerformed

    private void radio_proveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radio_proveedorActionPerformed
        check_subencionado.setEnabled(true);
    }//GEN-LAST:event_radio_proveedorActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_añadirCliente;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox check_subencionado;
    private javax.swing.JLabel label_direccion;
    private javax.swing.JLabel label_dni;
    private javax.swing.JLabel label_nombre;
    private javax.swing.JLabel label_poblacion;
    private javax.swing.JLabel label_telefono;
    private javax.swing.JLabel label_titulo;
    private javax.swing.JRadioButton radio_cliente;
    private javax.swing.JRadioButton radio_proveedor;
    private javax.swing.JTextField text_direccion;
    private javax.swing.JTextField text_nombre;
    private javax.swing.JTextField text_poblacion;
    private javax.swing.JTextField text_telefono;
    private javax.swing.JTextField txtfDni;
    // End of variables declaration//GEN-END:variables
}
