package almazarabarcha.vista;

import almazarabarcha.Modelo.GestorAlmazara;
import almazarabarcha.estilos.Estilos;
import capaDAO.DaoMolturacion;
import excepciones.BusinessException;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import pojos.Molturacion;
import pojos.Proveedor;
import pojos.Usuario;

public class AñadirMolturacion extends JFrame {
    private Estilos estilos = new Estilos();
    private Proveedor p;
    private Usuario u;
    private Molturacion m;
    private JPanel panelPrincipal;

    public AñadirMolturacion(Proveedor p, Usuario u,JPanel panelPrincipal){
        initComponents();
        label_kg_oliva.setFont(estilos.getFuenteEtiquetas());
        label_observaciones.setFont(estilos.getFuenteEtiquetas());
        label_total_ingresos.setFont(estilos.getFuenteEtiquetas());
        btn_molturacion.setFont(estilos.getFuenteBotones());
        this.p = p;
        this.u = u;
        this.panelPrincipal = panelPrincipal;
        m = new Molturacion();
        btn_molturacion.setVisible(false);
        lb_nombre_cliente.setText(p.getNombre());
        text_maquila.setEnabled(false);
    }

    private AñadirMolturacion() {
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
        btn_molturacion = new javax.swing.JButton();
        text_observaciones = new javax.swing.JTextField();
        label_observaciones = new javax.swing.JLabel();
        label_total_ingresos = new javax.swing.JLabel();
        lb_total = new javax.swing.JLabel();
        btn_calcular = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lb_nombre_cliente = new javax.swing.JLabel();
        checkDeclara = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        text_maquila = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        label_kg_oliva.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        label_kg_oliva.setText("Kg Oliva");

        text_kg_oliva.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        btn_molturacion.setText("Añadir molturacion");
        btn_molturacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_molturacionActionPerformed(evt);
            }
        });

        label_observaciones.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        label_observaciones.setText("Observaciones");

        label_total_ingresos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        label_total_ingresos.setText("Total ingresos molturacion:");

        lb_total.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lb_total.setText("0");

        btn_calcular.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btn_calcular.setText("Calcular ingresos molturacion");
        btn_calcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_calcularActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Cliente: ");

        lb_nombre_cliente.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lb_nombre_cliente.setText("jLabel2");

        checkDeclara.setText("Declara");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Maquila a reflejar");

        text_maquila.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        text_maquila.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(text_observaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 907, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label_observaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lb_nombre_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 498, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(label_kg_oliva, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label_total_ingresos, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(text_kg_oliva, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(67, 67, 67)
                                        .addComponent(jLabel2)
                                        .addGap(18, 18, 18)
                                        .addComponent(text_maquila, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lb_total, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btn_calcular)
                                            .addComponent(checkDeclara))
                                        .addGap(3, 3, 3))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(470, 470, 470)
                        .addComponent(btn_molturacion, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 209, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lb_nombre_cliente))
                .addGap(67, 67, 67)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_kg_oliva)
                    .addComponent(text_kg_oliva, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_calcular, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(text_maquila, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_total_ingresos)
                    .addComponent(lb_total)
                    .addComponent(checkDeclara))
                .addGap(60, 60, 60)
                .addComponent(label_observaciones)
                .addGap(18, 18, 18)
                .addComponent(text_observaciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(btn_molturacion, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_molturacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_molturacionActionPerformed
        try {
            if (text_observaciones.getText().equals("")) {
                text_observaciones.setText("");
                m.setObservaciones("");
            } else {
                m.setObservaciones(text_observaciones.getText());
            }

            /*if (check_declara.isSelected()) {
             m.setDeclara(true);
             m.setKgReflejadosDeclaracion(kilos);
             } else {
             m.setDeclara(false);
             m.setKgReflejadosDeclaracion(0);
             }*/
            

            m.setKgOrujo(m.CalcularOrujo());
            m.setLitrosAceiteProd(0);
            m.setFecha(new java.util.Date());
            m.setProveedor(p);
            m.setUsuario(u);

            DaoMolturacion.insertar(m);

            JOptionPane.showMessageDialog(null, "Se ha añadido la molturacion correctamente al cliente: " + p.getNombre());
            GestorAlmazara.RetrocederASeleccionarCliente(panelPrincipal, estilos, u);
        } catch (BusinessException ex) {
            Logger.getLogger(AñadirMolturacion.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_btn_molturacionActionPerformed

    private void btn_calcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_calcularActionPerformed
        if (text_kg_oliva.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Faltan campos por completar");

        } else {
            float kilos = Float.parseFloat(text_kg_oliva.getText().replaceAll(",", "."));
            m.setKgOliva(kilos);
            m.setIngresoMolturacion(m.CalcularPrecioMulturacion());
            DecimalFormat df = new DecimalFormat("0.00");
            lb_total.setText(String.valueOf(df.format(m.getIngresoMolturacion()) + " €"));
            if (checkDeclara.isSelected()) {
                m.CalcularMaquila();
                m.setKgReflejadosDeclaracion(m.getKgOliva());
                m.setDeclara(true);
                text_maquila.setText(String.format("%.2f", m.getMaquila()));
            } else {
                m.setMaquila(0);
                m.setKgReflejadosDeclaracion(0);
                m.setDeclara(false);
                text_maquila.setText(String.format("%.2f", m.getMaquila()));
            }
            btn_molturacion.setVisible(true);
        }

    }//GEN-LAST:event_btn_calcularActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_calcular;
    private javax.swing.JButton btn_molturacion;
    private javax.swing.JCheckBox checkDeclara;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel label_kg_oliva;
    private javax.swing.JLabel label_observaciones;
    private javax.swing.JLabel label_total_ingresos;
    private javax.swing.JLabel lb_nombre_cliente;
    private javax.swing.JLabel lb_total;
    private javax.swing.JTextField text_kg_oliva;
    private javax.swing.JTextField text_maquila;
    private javax.swing.JTextField text_observaciones;
    // End of variables declaration//GEN-END:variables
}
