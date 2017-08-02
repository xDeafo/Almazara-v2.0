package almazarabarcha.estilos;

import java.awt.Font;
import java.io.InputStream;

public class CustomFont {

    private Font font = null;

    public CustomFont() {
        String fontName = "Roboto-Regular.ttf" ;
        try {
            //Se carga la fuente
            InputStream is =  getClass().getResourceAsStream(fontName);
            font = Font.createFont(Font.TRUETYPE_FONT, is);
        } catch (Exception ex) {
            //Si existe un error se carga fuente por defecto ARIAL
            System.err.println(fontName + " No se cargo la fuente");
            font = new Font("Arial", Font.PLAIN, 14);            
        }
  }

    /* Font.PLAIN = 0 , Font.BOLD = 1 , Font.ITALIC = 2
 * tamaño = float
 */
    public Font MyFont(int estilo, float tamaño)
    {
        Font tfont = font.deriveFont(estilo, tamaño);
        return tfont;
    }

}