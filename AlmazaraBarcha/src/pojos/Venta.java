package pojos;
// Generated 22-nov-2016 13:00:57 by Hibernate Tools 4.3.1

import almazarabarcha.Modelo.Inventario.TipoAceite;
import almazarabarcha.Modelo.Inventario.TipoEnvase;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Venta generated by hbm2java
 */
@Entity
@Table(name = "venta", catalog = "almazaradb"
)
public class Venta implements java.io.Serializable {

    private Integer idVenta;
    private Cliente cliente;
    private Usuario usuario;
    private Date fecha;
    private boolean factura;
    private boolean regalo;
    private boolean otro;
    private float totalVenta;
    private String observaciones;
    private float litrosDeclarables;
    public Set productos = new HashSet(0);
    private ArrayList<TipoAceite> tiposaceites;
    private ArrayList<TipoEnvase> tiposenvases;
    private boolean regalar_envases;
    private boolean factura_realizada;

    public Venta() {
        tiposaceites = new ArrayList<>();
        tiposenvases = new ArrayList<>();

        tiposaceites.add(new TipoAceite("Lampante", (float) 1.25, false));
        tiposaceites.add(new TipoAceite("Extra", (float) 5.0, false));
        tiposaceites.add(new TipoAceite("Arberquina", (float) 6.0, false));
        tiposaceites.add(new TipoAceite("Bote Flor", (float) 7.0, true));
        tiposaceites.add(new TipoAceite("Bote Extra", (float) 5.0, true));

        tiposenvases.add(new TipoEnvase((float) 5.0, (float) 1.0));
        tiposenvases.add(new TipoEnvase((float) 10.0, (float) 2.0));
        tiposenvases.add(new TipoEnvase((float) 25.0, (float) 3.0));
    }

    public Venta(Cliente cliente, Usuario usuario, Date fecha, boolean factura, boolean regalo, boolean otro, float totalVenta, float litrosDeclarables) {
        this.cliente = cliente;
        this.usuario = usuario;
        this.fecha = fecha;
        this.factura = factura;
        this.regalo = regalo;
        this.otro = otro;
        this.totalVenta = totalVenta;
        this.litrosDeclarables = litrosDeclarables;
    }

    public Venta(Cliente cliente, Usuario usuario, Date fecha, boolean factura, boolean regalo, boolean otro, float totalVenta, String observaciones, float litrosDeclarables, Set productos) {
        this.cliente = cliente;
        this.usuario = usuario;
        this.fecha = fecha;
        this.factura = factura;
        this.regalo = regalo;
        this.otro = otro;
        this.totalVenta = totalVenta;
        this.observaciones = observaciones;
        this.litrosDeclarables = litrosDeclarables;
        this.productos = productos;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)

    @Column(name = "idVenta", unique = true, nullable = false)
    public Integer getIdVenta() {
        return this.idVenta;
    }

    public void setIdVenta(Integer idVenta) {
        this.idVenta = idVenta;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Cliente_idCliente", nullable = false)
    public Cliente getCliente() {
        return this.cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Usuario_idUsuario", nullable = false)
    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha", nullable = false, length = 19)
    public Date getFecha() {
        return this.fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Column(name = "factura", nullable = false)
    public boolean isFactura() {
        return this.factura;
    }

    public void setFactura(boolean factura) {
        this.factura = factura;
    }

    @Column(name = "regalo", nullable = false)
    public boolean isRegalo() {
        return this.regalo;
    }

    public void setRegalo(boolean regalo) {
        this.regalo = regalo;
    }

    @Column(name = "otro", nullable = false)
    public boolean isOtro() {
        return this.otro;
    }

    public void setOtro(boolean otro) {
        this.otro = otro;
    }

    @Column(name = "totalVenta", nullable = false, precision = 12, scale = 0)
    public float getTotalVenta() {
        return this.totalVenta;
    }

    public void setTotalVenta(float totalVenta) {
        this.totalVenta = totalVenta;
    }

    @Column(name = "Observaciones", length = 100)
    public String getObservaciones() {
        return this.observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    @Column(name = "litrosDeclarables", nullable = false, precision = 12, scale = 0)
    public float getLitrosDeclarables() {
        return this.litrosDeclarables;
    }

    public void setLitrosDeclarables(float litrosDeclarables) {
        this.litrosDeclarables = litrosDeclarables;
    }

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "producto_has_venta", catalog = "almazaradb", joinColumns = {
        @JoinColumn(name = "Venta_idVenta", nullable = false, updatable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "Producto_idProducto", nullable = false, updatable = false)})
    public Set getProductos() {
        return this.productos;
    }

    public void setProductos(Set productos) {
        this.productos = productos;
    }
    
    public void setRegalar_envases(boolean regalar_envases) {
        this.regalo = regalar_envases;
    }
    
    public void setFactura_realizada(boolean factura_realizada) {
        this.factura_realizada = factura_realizada;
    }

    /****************************Gettters**********************/
    /**
     * Total de litros de un tipo de aceite
     * @param tipo 0 - Lampante, 1 - Extra, 2 - Arberquina, 3 - Bote Flor, 4 - Bote Extra
     * @return devuelve el total de un tipo de aceite
     */
    public float getTotalLitrosTipoAceite(int tipo){
        return tiposaceites.get(tipo).getLitros();
    }
    
    public float getTotalPrecio(){
        return getPrecioTotal_envases()+ getPrecioTotal_tipos_aceite();
    }
    public void setTotalPrecio(float TotalPrecio){
        this.totalVenta = TotalPrecio; 
    }
    /**
     * Total de litros
     * @return devuelve el total de litros vendidos
     */
    public float getTotalLitros(){
        int i;
        float total = 0;
        
        for(i = 0; i < tiposaceites.size(); i++)
            total += getTotalLitrosTipoAceite(i);
        
        return total;
    }
    

    public float getPrecioTotal_envases() {
        float precioTotal = 0;
        int i;
        
        if(!regalar_envases)
            for(i = 0; i < tiposenvases.size();i++)
                precioTotal += tiposenvases.get(i).CalcularValor();
        
        return precioTotal;
    }

    public float getPrecioTotal_tipos_aceite() {
        float precio_total_litros = 0;
        int i;
        
        for(i = 0; i < tiposaceites.size(); i++)
            precio_total_litros += tiposaceites.get(i).CalcularValor();
        
        return precio_total_litros;
    }
    /**
     * ********************Operaciones********************
     */
    /**
     * Realiza una venta de envases de un cierto tamaño
     *
     * @param tipo_envase Es el tipo del envase 5L, 10L, 25L
     * @param cantidad Es la cantidad de envases a vender
     *
     * @return devuelve si se puede realizar la venta
     */
    public boolean venderEnvase(Float tipo_envase, int cantidad) {
        boolean ok = false;
        int tipo = -1;

        if (cantidad > 0) {
            for (int i = 0; i < tiposenvases.size(); i++) {
                if (tipo_envase == tiposenvases.get(i).getCapacidad()) {
                    tipo = i;
                }
            }

            if (tipo >= 0 && tipo < tiposenvases.size()) {
                tiposenvases.get(tipo).add(cantidad);
                ok = true;
            }
        }

        return ok;
    }

    /**
     * Vende una cierta cantidad de litros de un tipo de aceite
     *
     * @param tipo_aceite 0 - Lampante, 1 - Extra, 2 - Arberquina, 3 - Bote
     * Flor, 4 - Bote Extra
     * @param cantidad En litros, excepto en los botes
     *
     * @return devuelve si se puede realizar la venta
     */
    public boolean venderAceite(String tipo_aceite, float cantidad) {
        boolean ok = false;
        int tipo = -1;

        if (cantidad > 0) {
            for (int i = 0; i < tiposaceites.size(); i++) {
                if (tipo_aceite.equals(tiposaceites.get(i).getNombre())) {
                    tipo = i;
                }
            }

            if (tipo >= 0 && tipo < tiposaceites.size()) {
                tiposaceites.get(tipo).addCantidad(cantidad);
                ok = true;
            }
        }

        return ok;
    }


}
