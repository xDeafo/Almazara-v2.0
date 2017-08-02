package almazarabarcha.vista;

import almazarabarcha.estilos.Estilos;
import capaDAO.DaoCambio;
import capaDAO.DaoCompra;
import capaDAO.DaoMolturacion;
import capaDAO.DaoVenta;

import excepciones.BusinessException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import pojos.Cambio;
import pojos.Compra;
import pojos.Molturacion;
import pojos.Venta;

public class MostrarTotales extends JFrame {

    private final Estilos estilos = new Estilos();
    private List<Molturacion> molturaciones = new ArrayList<>();
    private List<Molturacion> molturaciones_almazara = new ArrayList<>();
    private List<Cambio> cambios = new ArrayList<>();
    private List<Compra> compras = new ArrayList<>();
    private List<Venta> ventas = new ArrayList<>();

    public MostrarTotales() {
        initComponents();
        label_total_cambio.setFont(estilos.getFuenteEtiquetas());
        label_total_compra.setFont(estilos.getFuenteEtiquetas());
        label_total_molturacion.setFont(estilos.getFuenteEtiquetas());
        label_total_ventas.setFont(estilos.getFuenteEtiquetas());
        RellenaTablaMolturacion();
        RellenaTablaDeudaMolturacion();
        RellenaTablaCambio();
        RellenaTablaCompra();
        RellenaTablaVenta();
        RellenaTablaDeclararMolturacion();
    }

    public void setTotalCambios() {

    }

    private void RellenaTablaMolturacion() {
        float total_kg_total = 0;
        float total_kg_almazara = 0;
        float total_kg_clientes = 0;
        float total_litros_total = 0;
        float total_litros_almazara = 0;
        float total_litros_clientes = 0;
        float rendimiento_medio = 0;
        int contador = 0;

        try {
            molturaciones = DaoMolturacion.getMolturacionesTotales();
            molturaciones_almazara = DaoMolturacion.getMolturacionesAlmazara();
        } catch (BusinessException ex) {
            Logger.getLogger(MostrarTotales.class.getName()).log(Level.SEVERE, null, ex);
        }

        Object[] fila = new Object[4];
        DefaultTableModel modelo = (DefaultTableModel) tabla_molturacion.getModel();
        DefaultTableModel modelo1 = (DefaultTableModel) tabla_rendimiento.getModel();
        int num_filas = modelo.getRowCount();
        for (int i = 0; i < num_filas; i++) {
            modelo.removeRow(0);
        }

        for (Molturacion molturacione : molturaciones) {
            total_kg_total += molturacione.getKgOliva();
            total_litros_total += molturacione.getLitrosAceiteProd();

        }
        for (Molturacion molturacione : molturaciones_almazara) {
            total_kg_almazara += molturacione.getKgOliva();
            total_litros_almazara += molturacione.getLitrosAceiteProd();
        }

        for (Molturacion molturacione : molturaciones) {
            rendimiento_medio += molturacione.getRendimiento();
            contador += 1;
        }

        fila[0] = String.format("%.2f", rendimiento_medio / contador);
        modelo1.addRow(fila);

        total_kg_clientes = total_kg_total - total_kg_almazara;
        total_litros_clientes = total_litros_total - total_litros_almazara;

        fila[0] = "Kg Oliva Molturados";
        fila[1] = total_kg_clientes;
        fila[2] = total_kg_almazara;
        fila[3] = total_kg_total;

        modelo.addRow(fila);

        fila[0] = "Plantones Molturados";
        fila[1] = String.format("%.2f", total_kg_clientes / 750);
        fila[2] = String.format("%.2f", total_kg_almazara / 750);
        fila[3] = String.format("%.2f", total_kg_total / 750);

        modelo.addRow(fila);

        fila[0] = "Aceite Producido(Litros)";
        fila[1] = total_litros_clientes;
        fila[2] = total_litros_almazara;
        fila[3] = total_litros_total;

        modelo.addRow(fila);

        tabla_molturacion.setModel(modelo);
        tabla_rendimiento.setModel(modelo1);
    }

    private void RellenaTablaDeudaMolturacion() {
        float ficticio = 0;
        float real = 0;
        float diferencia = 0;

        try {
            molturaciones = DaoMolturacion.getMolturacionesTotales();

        } catch (BusinessException ex) {
            Logger.getLogger(MostrarTotales.class.getName()).log(Level.SEVERE, null, ex);
        }

        Object[] fila = new Object[4];
        DefaultTableModel modelo = (DefaultTableModel) tabla_molt_deuda.getModel();

        int num_filas = modelo.getRowCount();
        for (int i = 0; i < num_filas; i++) {
            modelo.removeRow(0);
        }

        for (Molturacion molturacione : molturaciones) {
            if (molturacione.isPagada()) {
                real += molturacione.getIngresoMolturacion();
                ficticio += molturacione.getIngresoMolturacion();
            } else {
                ficticio += molturacione.getIngresoMolturacion();
            }
        }

        diferencia = real - ficticio;

        fila[0] = "Ingresos Molturacion";
        fila[1] = String.format("%.2f", ficticio);
        fila[2] = String.format("%.2f", real);
        fila[3] = String.format("%.2f", diferencia);

        modelo.addRow(fila);
        tabla_molt_deuda.setModel(modelo);
    }

    private void RellenaTablaDeclararMolturacion() {
        float maquila = 0;
        float kgMolturacion = 0;
        float orujo = 0;

        try {
            molturaciones = DaoMolturacion.getMolturacionesTotales();

        } catch (BusinessException ex) {
            Logger.getLogger(MostrarTotales.class.getName()).log(Level.SEVERE, null, ex);
        }

        Object[] fila = new Object[2];
        DefaultTableModel modelo = (DefaultTableModel) tabla_molt_declarar.getModel();

        int num_filas = modelo.getRowCount();
        for (int i = 0; i < num_filas; i++) {
            modelo.removeRow(0);
        }

        for (Molturacion molturacione : molturaciones) {
            if (molturacione.isDeclara()) {
                maquila += molturacione.getMaquila();
                kgMolturacion += molturacione.getKgReflejadosDeclaracion();
                orujo += molturacione.getKgOrujo();
            }
        }
        fila[0] = "Maquila";
        fila[1] = String.format("%.2f", maquila);

        modelo.addRow(fila);

        fila[0] = "Kg Molturacion";
        fila[1] = String.format("%.2f", kgMolturacion);

        modelo.addRow(fila);

        fila[0] = "Orujo";
        fila[1] = String.format("%.2f", orujo);

        modelo.addRow(fila);

        tabla_molt_declarar.setModel(modelo);

    }

    private void RellenaTablaCambio() {
        float total_pagar = 0;
        float aceite_retirado = 0;
        float aceite_real_retirado = 0;
        float kg_olivas = 0;
        float maquila_reflejar = 0;
        float litros_deuda = 0;

        try {
            cambios = DaoCambio.getTodosCambios();

        } catch (BusinessException ex) {
            Logger.getLogger(MostrarTotales.class.getName()).log(Level.SEVERE, null, ex);
        }

        Object[] fila = new Object[2];
        DefaultTableModel modelo = (DefaultTableModel) tabla_cambio.getModel();
        int num_filas = modelo.getRowCount();
        for (int i = 0; i < num_filas; i++) {
            modelo.removeRow(0);
        }

        for (Cambio camb : cambios) {
            if(camb.isPaga())
                total_pagar += camb.getPrecioMolturacion();
            
            aceite_retirado += camb.getLitrosAceiteRetirados();
            kg_olivas += camb.getKgOliva();
            maquila_reflejar += camb.getMaquilaReflejada();
            aceite_real_retirado += camb.CalcularAceiteRealRetirado();
        }
        
        litros_deuda = aceite_retirado - aceite_real_retirado;

        fila[0] = "Total € Real";
        fila[1] = total_pagar;

        modelo.addRow(fila);

        fila[0] = "Aceite real retirado";
        fila[1] = aceite_retirado;

        modelo.addRow(fila);

        fila[0] = "Ingreso de olivas";
        fila[1] = kg_olivas;

        modelo.addRow(fila);

        fila[0] = "Maquila reflejada";
        fila[1] = maquila_reflejar;

        modelo.addRow(fila);

        fila[0] = "Litros Deuda clientes";
        fila[1] = litros_deuda;

        modelo.addRow(fila);
        tabla_cambio.setModel(modelo);
    }

    private void RellenaTablaCompra() {
        float total_kg_oliva = 0;
        float subtotal_pagar = 0;
        float total_pagados = 0;

        try {
            compras = DaoCompra.getTodasCompras();

        } catch (BusinessException ex) {
            Logger.getLogger(MostrarTotales.class.getName()).log(Level.SEVERE, null, ex);
        }

        Object[] fila = new Object[2];
        DefaultTableModel modelo = (DefaultTableModel) tabla_compras.getModel();
        int num_filas = modelo.getRowCount();
        for (int i = 0; i < num_filas; i++) {
            modelo.removeRow(0);
        }

        for (Compra comp : compras) {
            total_kg_oliva += comp.getKgOliva();
            subtotal_pagar += comp.getTotalCompra();
            if(comp.isPagado())
                total_pagados += comp.getTotalCompra();
        }

        fila[0] = "Total Kg oliva limpia";
        fila[1] = total_kg_oliva;

        modelo.addRow(fila);

        fila[0] = "Subtotal a pagar";
        fila[1] = subtotal_pagar;

        modelo.addRow(fila);

        fila[0] = "Total pagados";
        fila[1] = total_pagados;

        modelo.addRow(fila);

        tabla_compras.setModel(modelo);
    }

    private void RellenaTablaVenta() {
        float total_ventas = 0;
        float litros_flor = 0;
        float litros_extra = 0;
        float litros_arbequina = 0;
        float litros_lampante = 0;

        try {
            ventas = DaoVenta.getTodasVentas();

        } catch (BusinessException ex) {
            Logger.getLogger(MostrarTotales.class.getName()).log(Level.SEVERE, null, ex);
        }

        Object[] fila = new Object[2];
        DefaultTableModel modelo = (DefaultTableModel) tabla_venta.getModel();
        int num_filas = modelo.getRowCount();
        for (int i = 0; i < num_filas; i++) {
            modelo.removeRow(0);
        }

        for (Venta vent : ventas) {
            total_ventas += vent.getTotalVenta();
            litros_flor += vent.getTotalLitrosTipoAceite(3);
            litros_extra += vent.getTotalLitrosTipoAceite(1) + vent.getTotalLitrosTipoAceite(4);
            litros_arbequina += vent.getTotalLitrosTipoAceite(2);
            litros_lampante += vent.getTotalLitrosTipoAceite(0);
        }

        fila[0] = "Total € Ventas aceite y envases";
        fila[1] = total_ventas;

        modelo.addRow(fila);

        fila[0] = "Total € Ventas sin IVA";
        fila[1] = 0;

        modelo.addRow(fila);

        fila[0] = "Total Litros Flor";
        fila[1] = litros_flor;

        modelo.addRow(fila);

        fila[0] = "Total Litros Extra";
        fila[1] = litros_extra;

        modelo.addRow(fila);

        fila[0] = "Total Litros Arbequina";
        fila[1] = litros_arbequina;

        modelo.addRow(fila);

        fila[0] = "Total Litros Lampante";
        fila[1] = litros_lampante;

        modelo.addRow(fila);

        tabla_venta.setModel(modelo);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_molturacion = new javax.swing.JTable();
        label_total_molturacion = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla_molt_declarar = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabla_molt_deuda = new javax.swing.JTable();
        label_total_cambio = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tabla_cambio = new javax.swing.JTable();
        label_total_compra = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tabla_compras = new javax.swing.JTable();
        label_total_ventas = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tabla_venta = new javax.swing.JTable();
        jScrollPane8 = new javax.swing.JScrollPane();
        tabla_rendimiento = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tabla_molturacion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Kg Oliva Moturados", null, null, null},
                {"Plantones Molturados", null, null, null},
                {"Aceite Prucido(Litros)", null, null, null}
            },
            new String [] {
                "", "Clientes", "Almazara ", "Total"
            }
        ));
        jScrollPane1.setViewportView(tabla_molturacion);

        label_total_molturacion.setText("Total Molturacion");

        tabla_molt_declarar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Maquila", null},
                {"KG Molturacion", null},
                {"Orujo", null}
            },
            new String [] {
                "", "Para declarar"
            }
        ));
        jScrollPane2.setViewportView(tabla_molt_declarar);

        tabla_molt_deuda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Ingresos Molturacion", null, null, null}
            },
            new String [] {
                "", "Ficticio", "Real", "Diferencia"
            }
        ));
        jScrollPane3.setViewportView(tabla_molt_deuda);
        if (tabla_molt_deuda.getColumnModel().getColumnCount() > 0) {
            tabla_molt_deuda.getColumnModel().getColumn(1).setHeaderValue("Ficticio");
            tabla_molt_deuda.getColumnModel().getColumn(2).setHeaderValue("Real");
            tabla_molt_deuda.getColumnModel().getColumn(3).setHeaderValue("Diferencia");
        }

        label_total_cambio.setText("Total Cambio");

        tabla_cambio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Total € Real", null},
                {"Aceite real retirado", null},
                {"Ingreso de olivas", null},
                {"Maquila reflejada", null},
                {"Deuda clientes", null}
            },
            new String [] {
                "", ""
            }
        ));
        jScrollPane5.setViewportView(tabla_cambio);

        label_total_compra.setText("Total Compra ");

        tabla_compras.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"TOTAL KG OLIVAS LIMPIA", null},
                {"SUBTOTAL € A PAGAR", null},
                {"TOTAL € PAGADOS", null}
            },
            new String [] {
                "", ""
            }
        ));
        jScrollPane6.setViewportView(tabla_compras);

        label_total_ventas.setText("Total Ventas");

        tabla_venta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"TOTAL € VENTAS DE ACEITE Y ENVASES", null},
                {"TOTAL € VENTAS SIN IVA", null},
                {"VENTA TOTAL LITROS FLOR", null},
                {"VENTA TOTAL LITROS EXTRA", null},
                {"VENTA TOTAL LITROS ARBEQUINA", null},
                {"VENTA TOTAL DE LAMPANTE KG", null}
            },
            new String [] {
                "", ""
            }
        ));
        jScrollPane7.setViewportView(tabla_venta);

        tabla_rendimiento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Rendimiento medio", null}
            },
            new String [] {
                "", ""
            }
        ));
        jScrollPane8.setViewportView(tabla_rendimiento);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 527, Short.MAX_VALUE)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.LEADING))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 525, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 527, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label_total_cambio, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 527, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_total_molturacion, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_total_compra, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_total_ventas, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label_total_molturacion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(label_total_cambio)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(label_total_compra)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(label_total_ventas)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JLabel label_total_cambio;
    private javax.swing.JLabel label_total_compra;
    private javax.swing.JLabel label_total_molturacion;
    private javax.swing.JLabel label_total_ventas;
    private javax.swing.JTable tabla_cambio;
    private javax.swing.JTable tabla_compras;
    private javax.swing.JTable tabla_molt_declarar;
    private javax.swing.JTable tabla_molt_deuda;
    private javax.swing.JTable tabla_molturacion;
    private javax.swing.JTable tabla_rendimiento;
    private javax.swing.JTable tabla_venta;
    // End of variables declaration//GEN-END:variables
}
