package almazarabarcha.vista;

import almazarabarcha.Modelo.GestorAlmazara;
import almazarabarcha.estilos.Estilos;
import capaDAO.DaoProducto;
import capaDAO.DaoVenta;
import excepciones.BusinessException;
import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import pojos.Cliente;
import pojos.Producto;
import pojos.Usuario;
import pojos.Venta;

public class AñadirVenta extends JFrame {

    private final Estilos estilos = new Estilos();
    private ArrayList<Producto> aceites = new ArrayList<Producto>();
    private ArrayList<Producto> bonbonas = new ArrayList<Producto>();
    float precioTotalEnvases = 0;
    float precioTotalAceite = 0;
    private Producto lampante;
    private Producto arberquina;
    private Producto extra;
    private Producto boteFlor;
    private Producto boteExtra;
    private Producto b_5;
    private Producto b_10;
    private Producto b_25;

    public AñadirVenta() throws HeadlessException {
    }
    Cliente c;
    Usuario u;
    Venta venta;
    JPanel panelPrincipal;

    public AñadirVenta(Cliente c, Usuario u, JPanel panelPrincipal) {
        initComponents();
        label_10l.setFont(estilos.getFuenteEtiquetas());
        label_25l.setFont(estilos.getFuenteEtiquetas());
        label_5l.setFont(estilos.getFuenteEtiquetas());
        label_alberquina.setFont(estilos.getFuenteEtiquetas());
        label_bote_extra.setFont(estilos.getFuenteEtiquetas());
        label_bote_flor.setFont(estilos.getFuenteEtiquetas());
        label_extra.setFont(estilos.getFuenteEtiquetas());
        label_lampante.setFont(estilos.getFuenteEtiquetas());
        label_observaciones.setFont(estilos.getFuenteEtiquetas());
        label_total.setFont(estilos.getFuenteEtiquetas());
        label_total_aceite.setFont(estilos.getFuenteEtiquetas());
        label_total_envases.setFont(estilos.getFuenteEtiquetas());
        label_litros1.setFont(estilos.getFuenteEtiquetas());
        label_litros2.setFont(estilos.getFuenteEtiquetas());
        label_litros3.setFont(estilos.getFuenteEtiquetas());
        btn_venta.setFont(estilos.getFuenteBotones());
        txt_total.setEnabled(true);
        txt_total_aceite.setEnabled(false);
        txt_total_envases.setEnabled(false);
        btn_venta.setVisible(false);

        this.c = c;
        this.u = u;
        this.panelPrincipal = panelPrincipal;
        this.venta = new Venta();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label_alberquina = new javax.swing.JLabel();
        check_factura = new javax.swing.JCheckBox();
        text_observaciones = new javax.swing.JTextField();
        label_observaciones = new javax.swing.JLabel();
        btn_venta = new javax.swing.JButton();
        label_lampante = new javax.swing.JLabel();
        txt_10 = new javax.swing.JTextField();
        label_extra = new javax.swing.JLabel();
        text_alberquina = new javax.swing.JTextField();
        label_litros3 = new javax.swing.JLabel();
        label_litros1 = new javax.swing.JLabel();
        label_litros2 = new javax.swing.JLabel();
        label_10l = new javax.swing.JLabel();
        label_5l = new javax.swing.JLabel();
        label_25l = new javax.swing.JLabel();
        text_lampante = new javax.swing.JTextField();
        txt_25 = new javax.swing.JTextField();
        txt_5 = new javax.swing.JTextField();
        txt_total_aceite = new javax.swing.JTextField();
        label_total_aceite = new javax.swing.JLabel();
        text_extra = new javax.swing.JTextField();
        check_regalar = new javax.swing.JCheckBox();
        label_bote_flor = new javax.swing.JLabel();
        label_bote_extra = new javax.swing.JLabel();
        text_bote_flor = new javax.swing.JTextField();
        text_bote_extra = new javax.swing.JTextField();
        txt_total = new javax.swing.JTextField();
        txt_total_envases = new javax.swing.JTextField();
        label_total_envases = new javax.swing.JLabel();
        label_total = new javax.swing.JLabel();
        btn_calcular_total = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        label_alberquina.setText("Arberquina");

        check_factura.setText("Factura");

        text_observaciones.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        label_observaciones.setText("Observaciones");

        btn_venta.setText("Añadir Venta");
        btn_venta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ventaActionPerformed(evt);
            }
        });

        label_lampante.setText("Lampante");

        txt_10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        label_extra.setText("Extra");

        text_alberquina.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        label_litros3.setText("Litros");

        label_litros1.setText("Litros");

        label_litros2.setText("Litros");

        label_10l.setText("Envase 10 L");

        label_5l.setText("Envase 5 L");

        label_25l.setText("Envase 25 L");

        text_lampante.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        txt_25.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        txt_5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        txt_total_aceite.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txt_total_aceite.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        label_total_aceite.setText("Total Aceite");

        text_extra.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        check_regalar.setText("Regalar Envases");
        check_regalar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                check_regalarActionPerformed(evt);
            }
        });

        label_bote_flor.setText("Bote Flor");

        label_bote_extra.setText("Bote Extra");

        text_bote_flor.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        text_bote_extra.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        txt_total.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txt_total.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_total.setDoubleBuffered(true);

        txt_total_envases.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txt_total_envases.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_total_envases.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_total_envasesActionPerformed(evt);
            }
        });

        label_total_envases.setText("Total Envases");

        label_total.setText("Total");

        btn_calcular_total.setText("Calcular ");
        btn_calcular_total.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_calcular_totalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(82, 82, 82)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(label_lampante, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(label_bote_extra, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(label_alberquina, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(5, 5, 5))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label_bote_flor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label_extra, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(text_bote_extra, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(text_bote_flor, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(4, 4, 4))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(text_extra, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(label_litros1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(64, 64, 64)
                                .addComponent(label_5l, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(label_litros3, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(text_alberquina, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(text_lampante, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(label_litros2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(label_25l, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(label_10l, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_10, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                    .addComponent(txt_5, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                    .addComponent(txt_25)
                    .addComponent(btn_calcular_total, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label_total_envases, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label_total, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_total, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_total_aceite, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_total_envases, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(43, 43, 43))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(label_total_aceite, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(159, 159, 159)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(check_factura)
                    .addComponent(check_regalar))
                .addGap(220, 220, 220))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(text_observaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 801, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label_observaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(470, 470, 470)
                        .addComponent(btn_venta, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(text_lampante, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_lampante)
                    .addComponent(label_litros1)
                    .addComponent(txt_5, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_5l)
                    .addComponent(txt_total_aceite, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_total_aceite)
                    .addComponent(check_regalar))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(text_alberquina, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label_alberquina)
                            .addComponent(label_litros2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(text_extra, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label_litros3)
                            .addComponent(label_extra)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_10, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label_10l)
                            .addComponent(txt_total_envases, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label_total_envases)
                            .addComponent(check_factura))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_25, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label_25l))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(text_bote_flor, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_bote_flor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(text_bote_extra, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(label_bote_extra))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_total, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(label_total))
                    .addComponent(btn_calcular_total, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
                .addComponent(label_observaciones)
                .addGap(18, 18, 18)
                .addComponent(text_observaciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(btn_venta, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_ventaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ventaActionPerformed
        boolean ok = false;
        float bonbonasEnStock_5L = 0;
        float bonbonasEnStock_10L = 0;
        float bonbonasEnStock_25L = 0;

        venta.setObservaciones(text_observaciones.getText());
        venta.setFactura_realizada(check_factura.isSelected());
        venta.setTotalVenta(Float.parseFloat(txt_total.getText().replaceAll(",", ".")));

        venta.setCliente(c);
        venta.setUsuario(u);
        venta.setFecha(new java.util.Date());

        bonbonasEnStock_5L = b_5.getUnidades();
        bonbonasEnStock_10L = b_10.getUnidades();
        bonbonasEnStock_25L = b_25.getUnidades();

        if (txt_5.getText().isEmpty()) {
            b_5.setUnidades(bonbonasEnStock_5L);
        } else {
            b_5.setUnidades(bonbonasEnStock_5L - (Float.parseFloat(txt_5.getText().replaceAll(",", "."))));
        }

        if (txt_10.getText().isEmpty()) {
            b_10.setUnidades(bonbonasEnStock_10L);
        } else {
            b_10.setUnidades(bonbonasEnStock_10L - (Float.parseFloat(txt_10.getText().replaceAll(",", "."))));
        }

        if (txt_25.getText().isEmpty()) {
            b_25.setUnidades(bonbonasEnStock_25L);
        } else {
            b_25.setUnidades(bonbonasEnStock_25L - (Float.parseFloat(txt_25.getText().replaceAll(",", "."))));
        }

        if (check_regalar.isSelected()) {

            venta.setRegalar_envases(true);
            venta.setTotalVenta(precioTotalAceite);

            /*txt_total_envases.setText(String.valueOf(0.0));
             venta.setTotalPrecio(venta.getPrecioTotal_tipos_aceite());*/
        } else {

            /*txt_total_envases.setText(String.valueOf(venta.getPrecioTotal_envases()));
             venta.setTotalPrecio(venta.getTotalPrecio());*/
            //Envases
            venta.setTotalVenta(precioTotalAceite + precioTotalEnvases);
        }
        try {

            ok = DaoVenta.insertar(venta);
            DaoProducto.update(b_5);
            DaoProducto.update(b_10);
            DaoProducto.update(b_25);

            //gestor.getClientes().get(pos).addVenta(venta);
            //System.out.println(gestor.getClientes().get(pos).getVentas().get(0).toString());
        } catch (BusinessException ex) {
            Logger.getLogger(AñadirVenta.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (ok) {
            JOptionPane.showMessageDialog(null, "Se ha añadido la venta correctamente");
            GestorAlmazara.RetrocederASeleccionarCliente(panelPrincipal, estilos, u);
        }

    }//GEN-LAST:event_btn_ventaActionPerformed

    private void check_regalarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_check_regalarActionPerformed

    }//GEN-LAST:event_check_regalarActionPerformed

    private void btn_calcular_totalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_calcular_totalActionPerformed

        float unidadesL = 0;
        float unidadesE = 0;
        float unidadesA = 0;
        float unidadesBF = 0;
        float unidadesBE = 0;

        float totalEnvases_5 = 0;
        float totalEnvases_10 = 0;
        float totalEnvases_25 = 0;

        float totalUnidades = 0;
        float bonbonasEnStock_5L = 0;
        float bonbonasEnStock_10L = 0;
        float bonbonasEnStock_25L = 0;

        aceites = getAceites();
        bonbonas = getBonbonas();

        lampante = aceites.get(0);
        arberquina = aceites.get(1);
        extra = aceites.get(2);
        boteFlor = aceites.get(3);
        boteExtra = aceites.get(4);

        b_5 = bonbonas.get(0);
        b_10 = bonbonas.get(1);
        b_25 = bonbonas.get(2);

        bonbonasEnStock_5L = b_5.getUnidades();
        bonbonasEnStock_10L = b_10.getUnidades();
        bonbonasEnStock_25L = b_25.getUnidades();

        //Aceites
        if (!text_lampante.getText().isEmpty()) {
            unidadesL = Float.parseFloat(text_lampante.getText().replaceAll(",", "."));
            lampante.setUnidades(unidadesL);
            venta.productos.add(lampante);
            precioTotalAceite += unidadesL * lampante.getPrecio();
        }

        if (!text_extra.getText().isEmpty()) {
            unidadesE = Float.parseFloat(text_extra.getText().replaceAll(",", "."));
            extra.setUnidades(unidadesE);
            venta.productos.add(extra);
            precioTotalAceite += unidadesE * extra.getPrecio();
        }
        if (!text_alberquina.getText().isEmpty()) {
            unidadesA = Float.parseFloat(text_alberquina.getText().replaceAll(",", "."));
            arberquina.setUnidades(unidadesA);
            venta.productos.add(arberquina);
            precioTotalAceite += unidadesA * arberquina.getPrecio();
        }
        if (!text_bote_flor.getText().isEmpty()) {
            unidadesBF = Float.parseFloat(text_bote_flor.getText().replaceAll(",", "."));
            boteFlor.setUnidades(unidadesBF);
            venta.productos.add(boteFlor);
            precioTotalAceite += unidadesBF * boteFlor.getPrecio();
        }
        if (!text_bote_extra.getText().isEmpty()) {
            unidadesBE = Float.parseFloat(text_bote_extra.getText().replaceAll(",", "."));
            boteExtra.setUnidades(unidadesBE);
            venta.productos.add(boteExtra);
            precioTotalAceite += unidadesBE * boteExtra.getPrecio();
        }

        //venta.setTotalVenta(venta.getTotalVenta());
        totalUnidades = unidadesL + unidadesBE + unidadesBF + unidadesE + unidadesL;
        txt_total_aceite.setText(String.format("%.2f", precioTotalAceite));

        if (txt_5.getText().equals("") && txt_10.getText().equals("") && txt_25.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "No se ha introducido ningun envase", "Atención", JOptionPane.ERROR_MESSAGE);
        } else {
            if (txt_5.getText().isEmpty()) {
                totalEnvases_5 = 0;
            } else {
                if (bonbonasEnStock_5L - Float.parseFloat(txt_5.getText()) < 0) {
                    JOptionPane.showMessageDialog(null, "No hay envases de 5L suficientes en Stock", "Atención", JOptionPane.ERROR_MESSAGE);
                } else {
                    totalEnvases_5 = Float.parseFloat(txt_5.getText());
                    //b_5.setUnidades(totalEnvases_5);
                    precioTotalEnvases += totalEnvases_5 * 1.0; //precio del envase de 5L = 1€
                    venta.productos.add(b_5);
                    btn_venta.setVisible(true);
                }
            }

            if (txt_10.getText().isEmpty()) {
                totalEnvases_10 = 0;
            } else {
                if (bonbonasEnStock_10L - Float.parseFloat(txt_10.getText()) < 0) {
                    JOptionPane.showMessageDialog(null, "No hay envases de 10L suficientes en Stock", "Atención", JOptionPane.ERROR_MESSAGE);
                } else {
                    totalEnvases_10 = Float.parseFloat(txt_10.getText());
                    //b_10.setUnidades(totalEnvases_10);
                    precioTotalEnvases += totalEnvases_10 * 2.0; //precio del envase de 10L = 2€
                    venta.productos.add(b_10);
                    btn_venta.setVisible(true);
                }
            }
            if (txt_25.getText().isEmpty()) {
                totalEnvases_25 = 0;
            } else {
                if (bonbonasEnStock_25L - Float.parseFloat(txt_25.getText()) < 0) {
                    JOptionPane.showMessageDialog(null, "No hay envases de 25L suficientes en Stock", "Atención", JOptionPane.ERROR_MESSAGE);
                } else {
                    totalEnvases_25 = Float.parseFloat(txt_25.getText());
                    //b_25.setUnidades(totalEnvases_25);
                    precioTotalEnvases += totalEnvases_25 * 3.0; //precio del envase de 25L = 3€
                    venta.productos.add(b_25);
                    btn_venta.setVisible(true);
                }
            }

            if (check_regalar.isSelected()) {
                txt_total_envases.setText("0.0");

                txt_total.setText(String.format("%.2f", precioTotalAceite));
                /*txt_total_envases.setText(String.valueOf(0.0));
                 venta.setTotalPrecio(venta.getPrecioTotal_tipos_aceite());*/
            } else {

                /*txt_total_envases.setText(String.valueOf(venta.getPrecioTotal_envases()));
                 venta.setTotalPrecio(venta.getTotalPrecio());*/
                //Envases
                txt_total_envases.setText(String.format("%.2f", precioTotalEnvases));
                txt_total.setText(String.format("%.2f", precioTotalAceite + precioTotalEnvases));

            }

        }
    }//GEN-LAST:event_btn_calcular_totalActionPerformed

    public ArrayList getBonbonas() {

        ArrayList<Producto> bonbonas = new ArrayList<>();

        try {
            bonbonas.add(DaoProducto.getProducto("Bonbona_5"));
            bonbonas.add(DaoProducto.getProducto("Bonbona_10"));
            bonbonas.add(DaoProducto.getProducto("Bonbona_25"));

        } catch (BusinessException ex) {
            Logger.getLogger(Stock.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return bonbonas;
    }

    public ArrayList getAceites() {

        ArrayList<Producto> aceites = new ArrayList<>();

        try {
            aceites.add(DaoProducto.getProducto("Lampante"));
            aceites.add(DaoProducto.getProducto("Arberquina"));
            aceites.add(DaoProducto.getProducto("Extra"));
            aceites.add(DaoProducto.getProducto("Bote Flor"));
            aceites.add(DaoProducto.getProducto("Bote Extra"));

        } catch (BusinessException ex) {
            Logger.getLogger(Stock.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return aceites;
    }

    private void txt_total_envasesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_total_envasesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_total_envasesActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_calcular_total;
    private javax.swing.JButton btn_venta;
    private javax.swing.JCheckBox check_factura;
    private javax.swing.JCheckBox check_regalar;
    private javax.swing.JLabel label_10l;
    private javax.swing.JLabel label_25l;
    private javax.swing.JLabel label_5l;
    private javax.swing.JLabel label_alberquina;
    private javax.swing.JLabel label_bote_extra;
    private javax.swing.JLabel label_bote_flor;
    private javax.swing.JLabel label_extra;
    private javax.swing.JLabel label_lampante;
    private javax.swing.JLabel label_litros1;
    private javax.swing.JLabel label_litros2;
    private javax.swing.JLabel label_litros3;
    private javax.swing.JLabel label_observaciones;
    private javax.swing.JLabel label_total;
    private javax.swing.JLabel label_total_aceite;
    private javax.swing.JLabel label_total_envases;
    private javax.swing.JTextField text_alberquina;
    private javax.swing.JTextField text_bote_extra;
    private javax.swing.JTextField text_bote_flor;
    private javax.swing.JTextField text_extra;
    private javax.swing.JTextField text_lampante;
    private javax.swing.JTextField text_observaciones;
    private javax.swing.JTextField txt_10;
    private javax.swing.JTextField txt_25;
    private javax.swing.JTextField txt_5;
    private javax.swing.JTextField txt_total;
    private javax.swing.JTextField txt_total_aceite;
    private javax.swing.JTextField txt_total_envases;
    // End of variables declaration//GEN-END:variables
}
