package almazarabarcha.vista;

import almazarabarcha.Modelo.GestorAlmazara;
import almazarabarcha.Modelo.Informes;
import almazarabarcha.estilos.Estilos;
import java.awt.Color;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import pojos.Usuario;

public class MenuPrincipal extends JFrame {

    private Usuario u;
    private Estilos estilos;
    private Informes infor;
    private GestorAlmazara ga; 

    public MenuPrincipal(Usuario u) throws IOException {
        jPanel1 = new JPanel();
        estilos = new Estilos();
        infor = new Informes();
        initComponents();
        //gestor = new GestorAlmazara();
        //this.setSize(1000, 700);
        //this.getGraphics().drawImage(ImageIO.read(new File("src/recursos/fondo.jpg")), 0, 0, this);

        label_titulo.setOpaque(true);
        label_titulo.setForeground(estilos.getColorFuenteTítulo());
        //label_titulo.setBackground(estilos.getColorTítulo());

        boton_addClientes.setFont(estilos.getFuenteBotones());
        boton_seleccionar_cliente.setFont(estilos.getFuenteBotones());
        boton_mostrar_totales.setFont(estilos.getFuenteBotones());
        boton_addClientes.setBackground(estilos.getColorBotones());
        btnGastos.setFont(estilos.getFuenteBotones());
        btnGastos.setBackground(estilos.getColorBotones());
        btnInformes.setFont(estilos.getFuenteBotones());
        btnInformes.setBackground(estilos.getColorBotones());
        btnStock.setFont(estilos.getFuenteBotones());
        btnStock.setBackground(estilos.getColorBotones());
        boton_seleccionar_cliente.setBackground(estilos.getColorBotones());
        boton_mostrar_totales.setBackground(estilos.getColorBotones());
        btn_salir.setBackground(estilos.getColorDanger());
        btn_salir.setForeground(Color.white);
        btn_salir.setFont(estilos.getFuenteBotones());
        jPanel1.setBackground(estilos.getColorInterior());

        this.setIconImage(estilos.getImagenIcono());
        this.setTitle("Almazara Barcha");
        this.setExtendedState(MAXIMIZED_BOTH);
        this.u = u;
        lb_nombreUser.setText(u.getNombre());
        ga = new GestorAlmazara();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        label_titulo = new javax.swing.JLabel();
        boton_addClientes = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        btn_salir = new javax.swing.JButton();
        boton_seleccionar_cliente = new javax.swing.JButton();
        boton_mostrar_totales = new javax.swing.JButton();
        lb_usuario = new javax.swing.JLabel();
        lb_nombreUser = new javax.swing.JLabel();
        btnStock = new javax.swing.JButton();
        btnGastos = new javax.swing.JButton();
        btnInformes = new javax.swing.JButton();

        jMenu1.setText("jMenu1");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);
        addWindowStateListener(new java.awt.event.WindowStateListener() {
            public void windowStateChanged(java.awt.event.WindowEvent evt) {
                formWindowStateChanged(evt);
            }
        });

        label_titulo.setBackground(new java.awt.Color(255, 255, 51));
        label_titulo.setFont(new java.awt.Font("Felix Titling", 1, 72)); // NOI18N
        label_titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_titulo.setText("ALMAZARA BARCHA");
        label_titulo.setName(""); // NOI18N

        boton_addClientes.setText("Añadir Clientes/Proveedores");
        boton_addClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_addClientesActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        jPanel1.setAutoscrolls(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 617, Short.MAX_VALUE)
        );

        btn_salir.setText("Salir");
        btn_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salirActionPerformed(evt);
            }
        });

        boton_seleccionar_cliente.setText("Seleccionar Cliente/Proveedor");
        boton_seleccionar_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_seleccionar_clienteActionPerformed(evt);
            }
        });

        boton_mostrar_totales.setText("Mostrar totales");
        boton_mostrar_totales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_mostrar_totalesActionPerformed(evt);
            }
        });

        lb_usuario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lb_usuario.setText("Usuario:");

        lb_nombreUser.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lb_nombreUser.setText("jLabel2");

        btnStock.setText("Stock");
        btnStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStockActionPerformed(evt);
            }
        });

        btnGastos.setText("Gastos");
        btnGastos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGastosActionPerformed(evt);
            }
        });

        btnInformes.setText("Informes");
        btnInformes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInformesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lb_usuario)
                        .addGap(5, 5, 5)
                        .addComponent(lb_nombreUser))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(boton_addClientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(boton_seleccionar_cliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(boton_mostrar_totales, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_salir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnStock, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnGastos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnInformes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(label_titulo, javax.swing.GroupLayout.DEFAULT_SIZE, 1136, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lb_usuario)
                            .addComponent(lb_nombreUser))
                        .addGap(32, 32, 32))
                    .addComponent(label_titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(boton_addClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(boton_seleccionar_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(boton_mostrar_totales, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnStock, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnGastos, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnInformes, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_salir, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boton_addClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_addClientesActionPerformed
        jPanel1.removeAll();
        AñadirCliente c = new AñadirCliente();
        c.getContentPane().setBackground(estilos.getColorInterior());
        jPanel1.add(c.getContentPane());
        jPanel1.repaint();

        boton_addClientes.setBackground(Color.yellow);
        btnGastos.setBackground(estilos.getColorBotones());
        btnInformes.setBackground(estilos.getColorBotones());
        btnStock.setBackground(estilos.getColorBotones());
        boton_seleccionar_cliente.setBackground(estilos.getColorBotones());
        boton_mostrar_totales.setBackground(estilos.getColorBotones());
    }//GEN-LAST:event_boton_addClientesActionPerformed

    private void btn_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btn_salirActionPerformed

    private void boton_seleccionar_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_seleccionar_clienteActionPerformed
        jPanel1.removeAll();
        SeleccionarCliente sc = new SeleccionarCliente(jPanel1, u);
        sc.getContentPane().setBackground(estilos.getColorInterior());
        jPanel1.add(sc.getContentPane());
        jPanel1.repaint();

        boton_addClientes.setBackground(estilos.getColorBotones());
        btnGastos.setBackground(estilos.getColorBotones());
        btnInformes.setBackground(estilos.getColorBotones());
        btnStock.setBackground(estilos.getColorBotones());
        boton_seleccionar_cliente.setBackground(Color.yellow);
        boton_mostrar_totales.setBackground(estilos.getColorBotones());
    }//GEN-LAST:event_boton_seleccionar_clienteActionPerformed

    private void boton_mostrar_totalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_mostrar_totalesActionPerformed
        MostrarTotales mt = new MostrarTotales();
        //mt.setVisible(true);
        jPanel1.removeAll();
        mt.getContentPane().setBackground(estilos.getColorInterior());
        jPanel1.add(mt.getContentPane());
        jPanel1.repaint();

        boton_addClientes.setBackground(estilos.getColorBotones());
        btnGastos.setBackground(estilos.getColorBotones());
        btnInformes.setBackground(estilos.getColorBotones());
        btnStock.setBackground(estilos.getColorBotones());
        boton_seleccionar_cliente.setBackground(estilos.getColorBotones());
        boton_mostrar_totales.setBackground(Color.yellow);
    }//GEN-LAST:event_boton_mostrar_totalesActionPerformed

    private void formWindowStateChanged(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowStateChanged

    private void btnGastosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGastosActionPerformed
        GestionGastos gg = new GestionGastos();
        jPanel1.removeAll();
        gg.getContentPane().setBackground(estilos.getColorInterior());
        jPanel1.add(gg.getContentPane());
        jPanel1.repaint();

        boton_addClientes.setBackground(estilos.getColorBotones());
        btnGastos.setBackground(Color.yellow);
        btnInformes.setBackground(estilos.getColorBotones());
        btnStock.setBackground(estilos.getColorBotones());
        boton_seleccionar_cliente.setBackground(estilos.getColorBotones());
        boton_mostrar_totales.setBackground(estilos.getColorBotones());
    }//GEN-LAST:event_btnGastosActionPerformed

    private void btnStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStockActionPerformed
        Stock s = new Stock();
        jPanel1.removeAll();
        s.getContentPane().setBackground(estilos.getColorInterior());
        jPanel1.add(s.getContentPane());
        jPanel1.repaint();

        boton_addClientes.setBackground(estilos.getColorBotones());
        btnGastos.setBackground(estilos.getColorBotones());
        btnInformes.setBackground(estilos.getColorBotones());
        btnStock.setBackground(Color.yellow);
        boton_seleccionar_cliente.setBackground(estilos.getColorBotones());
        boton_mostrar_totales.setBackground(estilos.getColorBotones());
    }//GEN-LAST:event_btnStockActionPerformed

    private void btnInformesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInformesActionPerformed
        ga.GenerarInformeMensual();
        infor.olivaEntradaTotal();
    }//GEN-LAST:event_btnInformesActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boton_addClientes;
    private javax.swing.JButton boton_mostrar_totales;
    private javax.swing.JButton boton_seleccionar_cliente;
    private javax.swing.JButton btnGastos;
    private javax.swing.JButton btnInformes;
    private javax.swing.JButton btnStock;
    private javax.swing.JButton btn_salir;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel label_titulo;
    private javax.swing.JLabel lb_nombreUser;
    private javax.swing.JLabel lb_usuario;
    // End of variables declaration//GEN-END:variables

}
