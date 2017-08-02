package almazarabarcha.Modelo;

import capaDAO.DaoMolturacion;
import excepciones.BusinessException;

import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pojos.Molturacion;

public class Informes {

    private int kgOliva;
    private Date fecha;
    private int aceiteProducido;
    private int orujoProducido;
    private List<Molturacion> molturaciones;

    public Informes() {
        try {
            molturaciones = DaoMolturacion.getMolturacionesTotales();
        } catch (BusinessException ex) {
            Logger.getLogger(Informes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void olivaEntradaTotal(){
        int i,d;
        String[] dias = {"01","02","03","04","05","06","07","08","09","10","11","12",
            "13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
        
        for(i = 0; i<31; i++){
            d = i+1;
            System.out.println("Dia "+ d +" "+ olivaEntrada1D(dias[i]) + " " + aceiteObtenido1D(dias[i]) + " " + orujoObtenido1D(dias[i]));
        }
    }
    public int olivaEntrada1D(String dia) {
        int entrada = 0;
        String f, f1;

        for (Molturacion m : molturaciones) {  //Convertimos la fecha a String y luego extraemos los digitos de los dias
            f = m.getFecha().toString();
            f1 = f.substring(8, 10);
            if (f1.equals(dia)) {
                entrada += m.getKgOliva();
            }
        }
        return entrada;
    }

    public int aceiteObtenido1D(String dia) {
        int entrada = 0;
        String f, f1;

        for (Molturacion m : molturaciones) {  //Convertimos la fecha a String y luego extraemos los digitos de los dias
            f = m.getFecha().toString();
            f1 = f.substring(8, 10);
            if (f1.equals(dia)) {
                entrada += m.getLitrosAceiteProd();
            }
        }
        return entrada;
    }
    
    public int orujoObtenido1D(String dia) {
        int entrada = 0;
        String f, f1;

        for (Molturacion m : molturaciones) {  //Convertimos la fecha a String y luego extraemos los digitos de los dias
            f = m.getFecha().toString();
            f1 = f.substring(8, 10);
            if (f1.equals(dia)) {
                entrada += m.getKgOrujo();
            }
        }
        return entrada;
    }
    public Date getFecha() {
        return fecha;
    }

    public int getAceiteProducido() {
        return aceiteProducido;
    }

    public int getOrujoProducido() {
        return orujoProducido;
    }

}
