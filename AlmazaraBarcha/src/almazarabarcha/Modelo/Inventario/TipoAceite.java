package almazarabarcha.Modelo.Inventario;

public class TipoAceite {
    private static final float BOTE_TAM = (float) 0.75;
    String nombre;
    private float precio;
    private float cantidad_litros;
    private int cantidad_unidades;
    private final boolean bote;

    /**
     * Constructor para el aceite líquido
     * @param nombre
     * @param precio en euros
     * @param bote indica si es un bote
     */
    public TipoAceite(String nombre, float precio, boolean bote) {
        this.nombre = nombre;
        this.precio = precio;
        this.bote = bote;
        cantidad_unidades = 0;
        cantidad_litros = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    
    /**
     * Devuelve los litros obtenidos
     * @return 
     */
    public float getLitros() {
        if(bote)
            return cantidad_unidades * BOTE_TAM;
        else
            return cantidad_litros;
    }
    
    /**
     * Setter para cantidad de aceite
     * @param cantidad puede ser en cantidad de aceite o en unidades de botes
     */
    public void addCantidad(float cantidad) {
        if(bote)
            this.cantidad_unidades = (int)cantidad;
        else
            this.cantidad_litros = cantidad;
    }
    
    /**
     * Calcula el valor en euros segun sean botes o líquido
     * @return devueve el precio en euros
     */
     public float CalcularValor(){
        if(bote)
            return cantidad_unidades*precio;
        else
            return cantidad_litros*precio;
    }
}
