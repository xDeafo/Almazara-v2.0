package almazarabarcha.Modelo;

import almazarabarcha.Modelo.Inventario.TipoAceite;
import almazarabarcha.Modelo.Inventario.TipoEnvase;

import java.util.ArrayList;

public class Venta {
    private boolean factura_realizada;
    private String observaciones;
    private ArrayList<TipoAceite> tiposaceites;
    private ArrayList<TipoEnvase> tiposenvases;
    private boolean regalar_envases;
    public static int cont_id;  //variable compartida por todas las ventas
    int id;
    


    public Venta() {
        id = 0;
        
        tiposaceites = new ArrayList<>();
        tiposenvases = new ArrayList<>();
        
        tiposaceites.add(new TipoAceite("Lampante",(float) 1.25, false));
        tiposaceites.add(new TipoAceite("Extra",(float) 5.0, false));
        tiposaceites.add(new TipoAceite("Arberquina",(float) 6.0, false));
        tiposaceites.add(new TipoAceite("Bote Flor",(float) 7.0, true));
        tiposaceites.add(new TipoAceite("Bote Extra",(float) 5.0, true));
        
        tiposenvases.add(new TipoEnvase((float)5.0,(float)1.0));
        tiposenvases.add(new TipoEnvase((float)10.0,(float)2.0));
        tiposenvases.add(new TipoEnvase((float)25.0,(float)3.0));
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
     * Devuelve el precio total de los litros y de los envases
     * @return 
     */
    public float getTotalPrecio(){
        return getPrecioTotal_envases()+getPrecioTotal_tipos_aceite();
    }
    
    public boolean isRegalar_envases() {
        return regalar_envases;
    }

    

    public boolean isFactura_realizada() {
        return factura_realizada;
    }

    
    
    public String getObservaciones() {
        return observaciones;
    }

    public int getId() {
        return id;
    }
    
    
/************************Setters***********************/
    public void setRegalar_envases(boolean regalar_envases) {
        this.regalar_envases = regalar_envases;
    }
    
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
    
    public void setFactura_realizada(boolean factura_realizada) {
        this.factura_realizada = factura_realizada;
    }
    
    
    
/**********************Operaciones*********************/
    /**
     * Realiza una venta de envases de un cierto tamaño
     * 
     * @param tipo_envase Es el tipo del envase  5L, 10L, 25L   
     * @param cantidad  Es la cantidad de envases a vender
     * 
     * @return devuelve si se puede realizar la venta
     */
    public boolean venderEnvase(Float tipo_envase, int cantidad){
        boolean ok = false;
        int tipo = -1;
               
        if(cantidad > 0){
            for(int i = 0; i < tiposenvases.size(); i++)
                if(tipo_envase == tiposenvases.get(i).getCapacidad())
                    tipo = i;
            
            if(tipo>=0 && tipo<tiposenvases.size()){
                 tiposenvases.get(tipo).add(cantidad);
                 ok = true;
            }
        }
        
        return ok;
    }
    
    /**
     * Vende una cierta cantidad de litros de un tipo de aceite
     * 
     * @param tipo_aceite 0 - Lampante, 1 - Extra, 2 - Arberquina, 3 - Bote Flor, 4 - Bote Extra
     * @param cantidad En litros, excepto en los botes
     * 
     * @return devuelve si se puede realizar la venta
     */
    public boolean venderAceite(String tipo_aceite, float cantidad){
        boolean ok = false;
        int tipo = -1;
               
        if(cantidad > 0){
            for(int i = 0; i < tiposaceites.size(); i++)
                if(tipo_aceite.equals(tiposaceites.get(i).getNombre()))
                    tipo = i;
            
            if(tipo>=0 && tipo<tiposaceites.size()){
                 tiposaceites.get(tipo).addCantidad(cantidad);
                 ok = true;
            }
        }
        
        return ok;
    }


    /**
     * Incrementa el Id a partir del último id insertado
     */
    public void increaseId() {
        cont_id++;
        id = cont_id;
    }

    @Override
    @SuppressWarnings("empty-statement")
    public String toString(){
        int i;
      
        String saco = new String();
        
        saco += "Tipos Aceite\n...................\n";
        for(i = 0; i < tiposaceites.size(); i++){
            saco += "\t" + tiposaceites.get(i).getNombre() + "->" + tiposaceites.get(i).getLitros() + "\n";
        }
        
        saco += "Tipos Envases\n..................\n";
        for(i = 0; i < tiposenvases.size(); i++){
            saco += "\t" + tiposenvases.get(i).getCapacidad() + "->" + tiposenvases.get(i).getCantidad() + "\n";
        }
        
        return "Venta{" + "factura_realizada=" + factura_realizada + ", observaciones=" + observaciones  + ", regalar_envases=" + regalar_envases + ", id=" + id + '}' + "\n" + saco;
    }
    
    
}
