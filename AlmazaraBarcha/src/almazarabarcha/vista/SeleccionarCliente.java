package almazarabarcha.vista;

import almazarabarcha.estilos.Estilos;
import capaDAO.DaoCliente;
import capaDAO.DaoProveedor;

import excepciones.BusinessException;
import java.awt.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import pojos.Cliente;
import pojos.Proveedor;
import pojos.Usuario;

public class SeleccionarCliente extends JFrame {

    private final Estilos estilos = new Estilos();
    JPanel jpanel1;
    private List<Proveedor> proveedores = new ArrayList<>();
    private List<Cliente> clientes = new ArrayList<>();
    private Usuario u;
    Proveedor p = new Proveedor();
    Cliente c = new Cliente();

    public SeleccionarCliente(JPanel jpanel1, Usuario u) {
        this.jpanel1 = jpanel1;
        initComponents();
        this.filtro("", p);
        this.u = u;
    }

    private SeleccionarCliente() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void filtro(String nombre_buscar, Object tipo) {
        try {
            if (tipo instanceof Cliente) {
                clientes = DaoCliente.getClientes();
            } else {
                proveedores = DaoProveedor.getProveedores();
            }
        } catch (BusinessException ex) {
            Logger.getLogger(SeleccionarCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        int i;
        Object[] fila = new Object[4];
        DefaultTableModel modelo = (DefaultTableModel) tabla_filtro.getModel();
        ArrayList<Proveedor> provedores_seleccionados;
        ArrayList<Cliente> clientes_seleccionados;

        int num_filas = modelo.getRowCount();
        for (i = 0; i < num_filas; i++) {
            modelo.removeRow(0);
        }

        if (nombre_buscar.isEmpty()) {
            if (tipo instanceof Cliente) {
                for (i = 0; i < clientes.size(); i++) {
                    fila[0] = clientes.get(i).getNombre();
                    fila[1] = clientes.get(i).getDni();
                    fila[2] = clientes.get(i).getDireccion();
                    fila[3] = clientes.get(i).getTelefono();
                    modelo.addRow(fila);
                }
            } else {
                for (i = 0; i < proveedores.size(); i++) {
                    fila[0] = proveedores.get(i).getNombre();
                    fila[1] = proveedores.get(i).getDni();
                    fila[2] = proveedores.get(i).getDireccion();
                    fila[3] = proveedores.get(i).getTelefono();
                    modelo.addRow(fila);
                }
            }
        } else {
            if (tipo instanceof Cliente) {
                clientes_seleccionados = contenidoEn(nombre_buscar, "cliente");

                for (i = 0; i < clientes_seleccionados.size(); i++) {
                    fila[0] = clientes_seleccionados.get(i).getNombre();
                    fila[1] = clientes_seleccionados.get(i).getDni();
                    fila[2] = clientes_seleccionados.get(i).getDireccion();
                    fila[3] = clientes_seleccionados.get(i).getTelefono();
                    modelo.addRow(fila);
                }
            } else {
                provedores_seleccionados = contenidoEn(nombre_buscar, "proveedor");

                for (i = 0; i < provedores_seleccionados.size(); i++) {
                    fila[0] = provedores_seleccionados.get(i).getNombre();
                    fila[1] = provedores_seleccionados.get(i).getDni();
                    fila[2] = provedores_seleccionados.get(i).getDireccion();
                    fila[3] = provedores_seleccionados.get(i).getTelefono();
                    modelo.addRow(fila);
                }
            }

        }

        tabla_filtro.setModel(modelo);
    }

    public ArrayList contenidoEn(String nombre_buscar, String tipo) {
        int i, j;
        String nombre;
        ArrayList seleccionados = new ArrayList<>();

        if (tipo.equals("cliente")) {
            for (i = 0; i < clientes.size(); i++) {
                nombre = clientes.get(i).getNombre();

                if (nombre.length() >= nombre_buscar.length()) {
                    if (nombre.toLowerCase().contains(nombre_buscar.toLowerCase())) {
                        seleccionados.add(clientes.get(i));
                    }
                }
            }
        } else {
            for (i = 0; i < proveedores.size(); i++) {
                nombre = proveedores.get(i).getNombre();
                if (nombre.length() >= nombre_buscar.length()) {
                    if (nombre.toLowerCase().contains(nombre_buscar.toLowerCase())) {
                        seleccionados.add(proveedores.get(i));
                    }
                }
            }
        }

        return seleccionados;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoClienteProveedor = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        textfield_buscar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_filtro = new javax.swing.JTable();
        button_buscar = new javax.swing.JButton();
        javax.swing.JButton button_seleccionar = new javax.swing.JButton();
        btn_eliminar = new javax.swing.JButton();
        btn_modificar = new javax.swing.JButton();
        javax.swing.JButton button_mostrar_operaciones = new javax.swing.JButton();
        rbtnClientes = new javax.swing.JRadioButton();
        rbtnProveedor = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Buscar Cliente");

        tabla_filtro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "DNI", "Direccion", "Telefono"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabla_filtro);

        button_buscar.setText("Buscar");
        button_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_buscarActionPerformed(evt);
            }
        });

        button_seleccionar.setText("Seleccionar Operacion");
        button_seleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_seleccionarActionPerformed(evt);
            }
        });

        btn_eliminar.setText("Eliminar");
        btn_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminarActionPerformed(evt);
            }
        });

        btn_modificar.setText("Modificar");
        btn_modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modificarActionPerformed(evt);
            }
        });

        button_mostrar_operaciones.setText("Mostrar Operaciones");
        button_mostrar_operaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_mostrar_operacionesActionPerformed(evt);
            }
        });

        grupoClienteProveedor.add(rbtnClientes);
        rbtnClientes.setText("Clientes");
        rbtnClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnClientesActionPerformed(evt);
            }
        });

        grupoClienteProveedor.add(rbtnProveedor);
        rbtnProveedor.setSelected(true);
        rbtnProveedor.setText("Proveedores");
        rbtnProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnProveedorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(textfield_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button_buscar)
                        .addGap(63, 63, 63)
                        .addComponent(rbtnClientes)
                        .addGap(18, 18, 18)
                        .addComponent(rbtnProveedor)
                        .addGap(270, 270, 270))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn_eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(btn_modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(button_mostrar_operaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(button_seleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(32, 32, 32))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(textfield_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button_buscar)
                    .addComponent(rbtnClientes)
                    .addComponent(rbtnProveedor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 352, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(button_seleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(button_mostrar_operaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void button_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_buscarActionPerformed
        if (rbtnClientes.isSelected()) {
            filtro(textfield_buscar.getText(), c);
        } else {
            filtro(textfield_buscar.getText(), p);
        }

    }//GEN-LAST:event_button_buscarActionPerformed

    private void button_seleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_seleccionarActionPerformed
        int fila = tabla_filtro.getSelectedRow();
        if (fila > -1) {
            try {
                JOptionPane.showMessageDialog(null, "Se ha seleccionado el cliente correctamente");

                if (rbtnClientes.isSelected()) {
                    c = DaoCliente.getCliente((String) tabla_filtro.getValueAt(fila, 0));
                    AñadirVenta v = new AñadirVenta(c, u,jpanel1);
                    jpanel1.removeAll();
                    v.getContentPane().setBackground(estilos.getColorInterior());
                    jpanel1.add(v.getContentPane());
                    jpanel1.repaint();
                    /*jpanel1.setBackground(Color.YELLOW);
                    jpanel1.setBackground(Color.LIGHT_GRAY);
                    jpanel1.setBackground(Color.LIGHT_GRAY);
                    jpanel1.setBackground(Color.LIGHT_GRAY);*/
                } else {
                    p = DaoProveedor.getProveedor((String) tabla_filtro.getValueAt(fila, 0));

                    GestorOperaciones g = new GestorOperaciones(p, u,jpanel1);
                    jpanel1.removeAll();

                    g.getContentPane().setBackground(estilos.getColorInterior());
                    jpanel1.add(g.getContentPane());
                    jpanel1.repaint();
                }
            } catch (BusinessException ex) {
                Logger.getLogger(SeleccionarCliente.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            JOptionPane.showMessageDialog(null, "No se ha seleccionado ningún elemento");
        }


    }//GEN-LAST:event_button_seleccionarActionPerformed

    private void btn_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modificarActionPerformed
        int fila = tabla_filtro.getSelectedRow();
        if (fila > -1) {
            try {
                JOptionPane.showMessageDialog(null, "Se ha seleccionado el cliente correctamente");

                if (rbtnClientes.isSelected()) {
                    c = DaoCliente.getCliente((String) tabla_filtro.getValueAt(fila, 0));
                    ModificarCliente mc = new ModificarCliente(c,this);
                    mc.setVisible(true);
                } else {
                    p = DaoProveedor.getProveedor((String) tabla_filtro.getValueAt(fila, 0));
                    ModificarCliente mc = new ModificarCliente(p,this);
                    mc.setVisible(true);
                }
            } catch (BusinessException ex) {
                Logger.getLogger(SeleccionarCliente.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            JOptionPane.showMessageDialog(null, "No se ha seleccionado ningún elemento");
        }
    }//GEN-LAST:event_btn_modificarActionPerformed

    private void btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarActionPerformed

        if (JOptionPane.showConfirmDialog(new JFrame(), "¿Está seguro que desea eliminar el cliente seleccionado?", "", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            int fila = tabla_filtro.getSelectedRow();
            boolean eliminado = false;
            try {
                if (rbtnProveedor.isSelected()) {
                    eliminado = DaoProveedor.borrarProveedor((String) tabla_filtro.getValueAt(fila, 0));
                } else {
                    eliminado = DaoCliente.borrarCliente((String) tabla_filtro.getValueAt(fila, 0));
                }
            } catch (BusinessException ex) {
                Logger.getLogger(SeleccionarCliente.class.getName()).log(Level.SEVERE, null, ex);
            }

            if (eliminado) {
                JOptionPane.showMessageDialog(null, "Se ha eliminado correctamente");

            }
        }

        if (rbtnClientes.isSelected()) {
            filtro(textfield_buscar.getText(), c);
        } else {
            filtro(textfield_buscar.getText(), p);
        }

    }//GEN-LAST:event_btn_eliminarActionPerformed

    private void button_mostrar_operacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_mostrar_operacionesActionPerformed
        int fila = tabla_filtro.getSelectedRow();

        if (fila != -1) {
            try {
                if (rbtnClientes.isSelected()) {
                    c = DaoCliente.getCliente((String) tabla_filtro.getValueAt(fila, 0));
                    GestionVenta gv = new GestionVenta(c);
                    jpanel1.removeAll();
                    gv.getContentPane().setBackground(estilos.getColorInterior());
                    jpanel1.add(gv.getContentPane());
                    jpanel1.repaint();
                    jpanel1.setBackground(Color.YELLOW);
                    jpanel1.setBackground(Color.LIGHT_GRAY);
                    jpanel1.setBackground(Color.LIGHT_GRAY);
                    jpanel1.setBackground(Color.LIGHT_GRAY);
                } else {
                    p = DaoProveedor.getProveedor((String) tabla_filtro.getValueAt(fila, 0));
                    MostrarOperaciones go = new MostrarOperaciones(p, u, jpanel1);

                    jpanel1.removeAll();
                    go.getContentPane().setBackground(estilos.getColorInterior());
                    jpanel1.add(go.getContentPane());
                    jpanel1.repaint();
                }
            } catch (BusinessException ex) {
                Logger.getLogger(SeleccionarCliente.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            JOptionPane.showMessageDialog(null, "No se ha seleccionado ningún elemento");
        }

    }//GEN-LAST:event_button_mostrar_operacionesActionPerformed

    
    private void rbtnClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnClientesActionPerformed
        filtro(textfield_buscar.getText(), c);
    }//GEN-LAST:event_rbtnClientesActionPerformed

    private void rbtnProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnProveedorActionPerformed
        filtro(textfield_buscar.getText(), p);
    }//GEN-LAST:event_rbtnProveedorActionPerformed


    public void setFiltrosCliente(){
        filtro("", c);
    }
    
    public void setFiltrosProveedor(){
        filtro("", p);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JButton btn_modificar;
    private javax.swing.JButton button_buscar;
    private javax.swing.ButtonGroup grupoClienteProveedor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rbtnClientes;
    private javax.swing.JRadioButton rbtnProveedor;
    private javax.swing.JTable tabla_filtro;
    private javax.swing.JTextField textfield_buscar;
    // End of variables declaration//GEN-END:variables
}
