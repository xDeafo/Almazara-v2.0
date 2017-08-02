package pojos;
// Generated 06-oct-2016 10:48:58 by Hibernate Tools 4.3.1

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Compra generated by hbm2java
 */
@Entity
@Table(name = "compra", catalog = "almazaradb"
)
public class Compra implements java.io.Serializable {

    private Integer idCompra;
    private Proveedor proveedor;
    private Usuario usuario;
    private float kgOliva;
    private float precioKg;
    private float totalCompra;
    private boolean pagado;
    private boolean declara;
    private boolean factura;
    private float maquilaReflejada;
    private String observaciones;
    private Date fecha;

    public Compra() {
    }

    public Compra(Proveedor proveedor, Usuario usuario, float kgOliva, float precioKg, float totalCompra, boolean pagado, boolean declara, boolean factura, float maquilaReflejada, Date fecha) {
        this.proveedor = proveedor;
        this.usuario = usuario;
        this.kgOliva = kgOliva;
        this.precioKg = precioKg;
        this.totalCompra = totalCompra;
        this.pagado = pagado;
        this.declara = declara;
        this.factura = factura;
        this.maquilaReflejada = maquilaReflejada;
        this.fecha = fecha;
    }

    public Compra(Proveedor proveedor, Usuario usuario, float kgOliva, float precioKg, float totalCompra, boolean pagado, boolean declara, boolean factura, float maquilaReflejada, String observaciones, Date fecha) {
        this.proveedor = proveedor;
        this.usuario = usuario;
        this.kgOliva = kgOliva;
        this.precioKg = precioKg;
        this.totalCompra = totalCompra;
        this.pagado = pagado;
        this.declara = declara;
        this.factura = factura;
        this.maquilaReflejada = maquilaReflejada;
        this.observaciones = observaciones;
        this.fecha = fecha;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)

    @Column(name = "idCompra", unique = true, nullable = false)
    public Integer getIdCompra() {
        return this.idCompra;
    }

    public void setIdCompra(Integer idCompra) {
        this.idCompra = idCompra;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Proveedor_idProveedor", nullable = false)
    public Proveedor getProveedor() {
        return this.proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Usuario_idUsuario", nullable = false)
    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Column(name = "kgOliva", nullable = false, precision = 12, scale = 0)
    public float getKgOliva() {
        return this.kgOliva;
    }

    public void setKgOliva(float kgOliva) {
        this.kgOliva = kgOliva;
    }

    @Column(name = "precioKg", nullable = false, precision = 12, scale = 0)
    public float getPrecioKg() {
        return this.precioKg;
    }

    public void setPrecioKg(float precioKg) {
        this.precioKg = precioKg;
    }

    @Column(name = "totalCompra", nullable = false, precision = 12, scale = 0)
    public float getTotalCompra() {
        return this.totalCompra;
    }

    public void setTotalCompra(float totalCompra) {
        this.totalCompra = totalCompra;
    }

    @Column(name = "pagado", nullable = false)
    public boolean isPagado() {
        return this.pagado;
    }

    public void setPagado(boolean pagado) {
        this.pagado = pagado;
    }

    @Column(name = "declara", nullable = false)
    public boolean isDeclara() {
        return this.declara;
    }

    public void setDeclara(boolean declara) {
        this.declara = declara;
    }

    @Column(name = "factura", nullable = false)
    public boolean isFactura() {
        return this.factura;
    }

    public void setFactura(boolean factura) {
        this.factura = factura;
    }

    @Column(name = "maquilaReflejada", nullable = false, precision = 12, scale = 0)
    public float getMaquilaReflejada() {
        return this.maquilaReflejada;
    }

    public void setMaquilaReflejada(float maquilaReflejada) {
        this.maquilaReflejada = maquilaReflejada;
    }

    @Column(name = "observaciones", length = 100)
    public String getObservaciones() {
        return this.observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha", nullable = false, length = 19)
    public Date getFecha() {
        return this.fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void calcularTotalCompra() {
        this.totalCompra = this.kgOliva * this.precioKg;
    }

    public void CalcularMaquilaReflejar() {

        if (factura) {
            maquilaReflejada = (float) (kgOliva * 0.15);
        } else if (declara) {
            maquilaReflejada = (float) (kgOliva * 0.04);
        } else {
            maquilaReflejada = 0;
        }

        this.setMaquilaReflejada(maquilaReflejada);
    }

}