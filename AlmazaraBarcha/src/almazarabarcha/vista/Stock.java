package almazarabarcha.vista;

import capaDAO.DaoCambio;
import capaDAO.DaoCompra;
import capaDAO.DaoMolturacion;
import capaDAO.DaoProducto;
import excepciones.BusinessException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import pojos.Cambio;
import pojos.Compra;
import pojos.Molturacion;
import pojos.Producto;

public class Stock extends JFrame {

    private List<Molturacion> molturaciones = new ArrayList<>();
    private List<Cambio> cambios = new ArrayList<>();
    private List<Compra> compras = new ArrayList<>();
    private ArrayList<Producto> bonbonas = new ArrayList<>();
    private ArrayList<Producto> aceites = new ArrayList<>();

    public Stock() {
        initComponents();

        txt_alberquina.setEnabled(false);
        txt_bote_extra.setEnabled(false);
        txt_bote_flor.setEnabled(false);
        txt_extra.setEnabled(false);
        txt_lampante.setEnabled(false);

        txt_b5.setEnabled(false);
        txt_b10.setEnabled(false);
        txt_b25.setEnabled(false);

        txt_alberquina.setText("10");
        txt_bote_extra.setText(null);
        txt_bote_flor.setText(null);
        txt_extra.setText(null);
        txt_lampante.setText(null);

        txt_aceite_declarar.setText(String.format("%.2f", getLitrosDeclarar()));
        txt_aceite_declarar_litros.setText(String.format("%.2f", getLitrosDeclarar() * 0.92)); //0.92 es la conversion de litros a kg
        txt_aceituna_molt_declarar.setText(String.format("%.2f", getKgMolturadosReflejar()));
        txt_orujo.setText(String.format("%.2f", getKgMolturadosReflejar() * 0.3)); //Calculo del orujo aproximado

        bonbonas = getBonbonas();

        txt_b5.setText(String.format("%.0f", bonbonas.get(0).getUnidades()));
        txt_b10.setText(String.format("%.0f", bonbonas.get(1).getUnidades()));
        txt_b25.setText(String.format("%.0f", bonbonas.get(2).getUnidades()));

        aceites = getAceites();

        txt_lampante.setText(String.format("%.2f", aceites.get(0).getPrecio()));
        txt_alberquina.setText(String.format("%.2f", aceites.get(1).getPrecio()));
        txt_extra.setText(String.format("%.2f", aceites.get(2).getPrecio()));
        txt_bote_flor.setText(String.format("%.2f", aceites.get(3).getPrecio()));
        txt_bote_extra.setText(String.format("%.2f", aceites.get(4).getPrecio()));

    }

    public float getLitrosDeclarar() {

        float totalMolt = 0;
        float totalCamb = 0;
        float totalComp = 0;
        float totalLitros = 0;

        try {
            molturaciones = DaoMolturacion.getMolturacionesTotales();
        } catch (BusinessException ex) {
            Logger.getLogger(Stock.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            cambios = DaoCambio.getTodosCambios();
        } catch (BusinessException ex) {
            Logger.getLogger(Stock.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            compras = DaoCompra.getTodasCompras();
        } catch (BusinessException ex) {
            Logger.getLogger(Stock.class.getName()).log(Level.SEVERE, null, ex);
        }

        for (Molturacion m : molturaciones) {
            totalMolt += m.getMaquila();
        }
        for (Cambio c : cambios) {
            totalCamb += c.getMaquilaReflejada();
        }
        for (Compra comp : compras) {
            totalComp += comp.getMaquilaReflejada();
        }
        totalLitros = totalCamb + totalComp + totalMolt;

        return totalLitros;

    }

    public float getKgMolturadosReflejar() {
        float totalMolt = 0;
        float totalCamb = 0;
        float totalComp = 0;
        float totalKg = 0;

        try {
            molturaciones = DaoMolturacion.getMolturacionesTotales();
        } catch (BusinessException ex) {
            Logger.getLogger(Stock.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            cambios = DaoCambio.getTodosCambios();
        } catch (BusinessException ex) {
            Logger.getLogger(Stock.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            compras = DaoCompra.getTodasCompras();
        } catch (BusinessException ex) {
            Logger.getLogger(Stock.class.getName()).log(Level.SEVERE, null, ex);
        }

        for (Molturacion m : molturaciones) {
            totalMolt += m.getKgReflejadosDeclaracion();
        }
        for (Cambio c : cambios) {
            totalCamb += c.getKgOlivaReflejados();
        }
        for (Compra comp : compras) {
            if (comp.getProveedor().isSubvencionado()) {
                totalComp += comp.getKgOliva();
            }
        }

        totalKg = totalCamb + totalComp + totalMolt;

        return totalKg;

    }

    public ArrayList getBonbonas() {

        ArrayList<Producto> bonbonas = new ArrayList<>();

        try {
            bonbonas.add(DaoProducto.getProducto("Bonbona_5"));
            bonbonas.add(DaoProducto.getProducto("Bonbona_10"));
            bonbonas.add(DaoProducto.getProducto("Bonbona_25"));
        } catch (BusinessException ex) {
            Logger.getLogger(Stock.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Stock.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aceites;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_lampante = new javax.swing.JTextField();
        txt_extra = new javax.swing.JTextField();
        txt_alberquina = new javax.swing.JTextField();
        txt_bote_flor = new javax.swing.JTextField();
        txt_bote_extra = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        btn_guardar_aceites = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txt_b5 = new javax.swing.JTextField();
        txt_b10 = new javax.swing.JTextField();
        txt_b25 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txt_orujo = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txt_aceite_declarar = new javax.swing.JTextField();
        txt_aceituna_molt_declarar = new javax.swing.JTextField();
        txt_aceite_declarar_litros = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        btn_modificar_envases = new javax.swing.JButton();
        btn_guardar_envases = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Lampante:");

        jLabel2.setText("Extra:");

        jLabel3.setText("Alberquina:");

        jLabel4.setText("Bote flor:");

        jLabel5.setText("Bote extra:");

        txt_lampante.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        txt_extra.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        txt_alberquina.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        txt_bote_flor.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        txt_bote_extra.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        jLabel6.setText("Precio Actual");

        jLabel7.setText("Tipos de aceite");

        jButton1.setText("Modificar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btn_guardar_aceites.setText("Guardar");
        btn_guardar_aceites.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardar_aceitesActionPerformed(evt);
            }
        });

        jLabel8.setText("Envases");

        jLabel9.setText("Envase 5 L");

        jLabel10.setText("Envase 10 L");

        jLabel11.setText("Envase 25 L");

        txt_b5.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        txt_b10.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        txt_b25.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        jLabel12.setText("Cantidad Actual");

        txt_orujo.setEditable(false);
        txt_orujo.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_orujo.setEnabled(false);

        jLabel13.setText("Aceite para declara:");

        jLabel14.setText("Aceitunas molturadas para declarar:");

        jLabel15.setText("Orujo para declarar:");

        txt_aceite_declarar.setEditable(false);
        txt_aceite_declarar.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_aceite_declarar.setEnabled(false);

        txt_aceituna_molt_declarar.setEditable(false);
        txt_aceituna_molt_declarar.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_aceituna_molt_declarar.setEnabled(false);

        txt_aceite_declarar_litros.setEditable(false);
        txt_aceite_declarar_litros.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_aceite_declarar_litros.setEnabled(false);

        jLabel16.setText("Litros");

        jLabel17.setText("Kilos");

        btn_modificar_envases.setText("Modificar");
        btn_modificar_envases.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modificar_envasesActionPerformed(evt);
            }
        });

        btn_guardar_envases.setText("Guardar");
        btn_guardar_envases.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardar_envasesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt_orujo, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addGap(18, 18, 18)
                                .addComponent(txt_aceituna_molt_declarar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt_aceite_declarar_litros, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(txt_aceite_declarar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(128, 128, 128)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(btn_guardar_aceites, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGap(9, 9, 9)
                                                        .addComponent(jLabel17)
                                                        .addGap(71, 71, 71)
                                                        .addComponent(jLabel16))))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(26, 26, 26)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txt_bote_flor, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txt_alberquina, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txt_bote_extra, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txt_extra, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txt_lampante, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel10)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_b5)
                                    .addComponent(txt_b10)
                                    .addComponent(txt_b25, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btn_modificar_envases, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btn_guardar_envases, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jLabel12))))
                .addGap(152, 152, 152))
            .addGroup(layout.createSequentialGroup()
                .addGap(118, 118, 118)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(272, 272, 272))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel12))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txt_lampante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txt_extra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_guardar_aceites))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txt_alberquina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txt_bote_flor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txt_bote_extra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txt_b5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_modificar_envases))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txt_b10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_guardar_envases))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txt_b25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(31, 31, 31)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txt_aceite_declarar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_aceite_declarar_litros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txt_aceituna_molt_declarar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_orujo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addContainerGap(150, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        txt_alberquina.setEnabled(true);
        txt_bote_extra.setEnabled(true);
        txt_bote_flor.setEnabled(true);
        txt_extra.setEnabled(true);
        txt_lampante.setEnabled(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btn_modificar_envasesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modificar_envasesActionPerformed
        txt_b5.setEnabled(true);
        txt_b10.setEnabled(true);
        txt_b25.setEnabled(true);
    }//GEN-LAST:event_btn_modificar_envasesActionPerformed

    private void btn_guardar_aceitesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardar_aceitesActionPerformed
        Producto lampante;
        Producto arberquina;
        Producto extra;
        Producto boteFlor;
        Producto boteExtra;

        aceites = getAceites();

        lampante = aceites.get(0);
        arberquina = aceites.get(1);
        extra = aceites.get(2);
        boteFlor = aceites.get(3);
        boteExtra = aceites.get(4);

        try {
            lampante.setPrecio(Float.parseFloat(txt_lampante.getText().replaceAll(",", ".")));
            arberquina.setPrecio(Float.parseFloat(txt_alberquina.getText().replaceAll(",", ".")));
            extra.setPrecio(Float.parseFloat(txt_extra.getText().replaceAll(",", ".")));
            boteFlor.setPrecio(Float.parseFloat(txt_bote_flor.getText().replaceAll(",", ".")));
            boteExtra.setPrecio(Float.parseFloat(txt_bote_extra.getText().replaceAll(",", ".")));

            if (JOptionPane.showConfirmDialog(new JFrame(), "¿Está seguro que desea modificar los precios?", "", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

                DaoProducto.update(lampante);
                DaoProducto.update(arberquina);
                DaoProducto.update(extra);
                DaoProducto.update(boteFlor);
                DaoProducto.update(boteExtra);

            }

            txt_alberquina.setEnabled(false);
            txt_bote_extra.setEnabled(false);
            txt_bote_flor.setEnabled(false);
            txt_extra.setEnabled(false);
            txt_lampante.setEnabled(false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "El valor introducido no es valido");
        }


    }//GEN-LAST:event_btn_guardar_aceitesActionPerformed

    private void btn_guardar_envasesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardar_envasesActionPerformed
        Producto b_5;
        Producto b_10;
        Producto b_25;

        bonbonas = getBonbonas();

        b_5 = bonbonas.get(0);
        b_10 = bonbonas.get(1);
        b_25 = bonbonas.get(2);

        try {
            b_5.setUnidades(Float.parseFloat(txt_b5.getText().replaceAll(",", ".")));
            b_10.setUnidades(Float.parseFloat(txt_b10.getText().replaceAll(",", ".")));
            b_25.setUnidades(Float.parseFloat(txt_b25.getText().replaceAll(",", ".")));

            if (JOptionPane.showConfirmDialog(new JFrame(), "¿Está seguro que desea modificar las unidades?", "", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                try {
                    DaoProducto.update(b_5);
                    DaoProducto.update(b_10);
                    DaoProducto.update(b_25);

                } catch (BusinessException ex) {
                    Logger.getLogger(Stock.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            txt_b5.setEnabled(false);
            txt_b10.setEnabled(false);
            txt_b25.setEnabled(false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "El valor introducido no es valido");
        }
    }//GEN-LAST:event_btn_guardar_envasesActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_guardar_aceites;
    private javax.swing.JButton btn_guardar_envases;
    private javax.swing.JButton btn_modificar_envases;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField txt_aceite_declarar;
    private javax.swing.JTextField txt_aceite_declarar_litros;
    private javax.swing.JTextField txt_aceituna_molt_declarar;
    private javax.swing.JTextField txt_alberquina;
    private javax.swing.JTextField txt_b10;
    private javax.swing.JTextField txt_b25;
    private javax.swing.JTextField txt_b5;
    private javax.swing.JTextField txt_bote_extra;
    private javax.swing.JTextField txt_bote_flor;
    private javax.swing.JTextField txt_extra;
    private javax.swing.JTextField txt_lampante;
    private javax.swing.JTextField txt_orujo;
    // End of variables declaration//GEN-END:variables
}
