package almazarabarcha.Modelo.Inventario;

public class TipoEnvase {
    float capacidad;
    float precio;
    int cantidad;

    public TipoEnvase(float capacidad, float precio) {
        this.capacidad = capacidad;
        this.precio = precio;
        this.cantidad = 0;
    }
    
    public float getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(float capacidad) {
        this.capacidad = capacidad;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }
    
    public void add(int cantidad){
        this.cantidad = cantidad;
    }
    
    public float CalcularValor(){
        return getCantidad()*getPrecio();
    }
    
    
    
}
