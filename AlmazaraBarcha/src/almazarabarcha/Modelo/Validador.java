package almazarabarcha.Modelo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Valida NIF, teléfono, números enteros y decimales
 */
public class Validador {
    private static final String LETRAS_NIF = "TRWAGMYFPDXBNJZSQVHLCKE";
    private static final String NIF_EXPRESION_REGULAR = "(\\d{8})([A-Z])";
    private static final String TELEFONO_EXPRESION_REGULAR = "([1-9])(\\d{8})";
    public static final String NUMERO_ENTERO_EXPRESION_REGULAR = "0|([1-9][0-9]*)";
    public static final String NUMERO_DECIMAL_EXPRESION_REGULAR = "(0|[1-9][0-9]*)|((0|[1-9][0-9]*)\\.[0-9]+)";
            
    
    /**
     * Comprueba la vericidad del NIF, el NIF está constituido de 8 dígitos númericos
     * denominado DNI y de 1 letra. La letra depende del número del DNI.
     * @param nif El nif que se desea verificar
     * @return devuelve verdadero si es válido, falso si no lo es
     */
    public boolean validarNIF(String nif){
        Pattern dniPatron = Pattern.compile(NIF_EXPRESION_REGULAR);
        Matcher m = dniPatron.matcher(nif); 
        
        //comprueba si coincide con el patrón
        if(m.matches()){
            int dni = Integer.parseInt(m.group(1)); //coje el número del NIF
            char letra = m.group(2).charAt(0);      //coje la letra del NIF
            
            return LETRAS_NIF.charAt(dni%23) == letra; //comprueba si la letra es correcta
        }
        
        return false;
    }
    
    /**
     * Validar número de teléfono que está constituido por 9 dígitos númericos
     * @param telefono Un número de teléfono
     * @return Devuelve verdadero si es el número de teléfono es correcto
     */
    public boolean validarTelefono(String telefono){
        Pattern telefonoPatron = Pattern.compile(TELEFONO_EXPRESION_REGULAR);
        Matcher m = telefonoPatron.matcher(telefono);
        
        return m.matches();
    }
    
    /**
     * Validar si es un número entero positivo
     * @param numero Un número entero
     * @return Devuelve verdadero si es un número entero positivo
     */
    public boolean validarNumeroEntero(String numero){
        Pattern numeroPatron = Pattern.compile(NUMERO_ENTERO_EXPRESION_REGULAR);
        Matcher m = numeroPatron.matcher(numero);
        
        return m.matches();
    }
    
     /**
     * Validar si es un número decimal positvo
     * @param numero Un número decimal
     * @return Devuelve verdadero si es un número decimal positivo
     */
    public boolean validarNumeroDecimal(String numero){
        Pattern numeroPatron = Pattern.compile(NUMERO_DECIMAL_EXPRESION_REGULAR);
        Matcher m = numeroPatron.matcher(numero);
        
        return m.matches();
    }
    
    /**
     * Corrige las entradas de un número decimal, entero y NIF
     * @param numero
     * @return Número corregido
     */
    public String corregirNumeros(String numero){
        String aux = numero.replace(" ", "");
        aux = aux.replace(",", ".");
        aux = aux.toUpperCase();
        
        return aux.replace("'", ".");
    }
}
