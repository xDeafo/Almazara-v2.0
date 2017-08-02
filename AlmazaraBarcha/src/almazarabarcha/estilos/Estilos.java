package almazarabarcha.estilos;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;

public class Estilos{

    public Estilos() {
    }
    
/**********************Fuentes***************************/
    
    public Font getFuenteEtiquetas(){
        CustomFont cf = new CustomFont();
        return cf.MyFont(0, (float)14);
    }
    
    public Font getFuenteTitulo(){
        CustomFont cf = new CustomFont();
        return cf.MyFont(1, (float)50);
    }
    
    public Font getFuenteTitulo2(){
        CustomFont cf = new CustomFont();
        return cf.MyFont(1, (float)30);
    }
    
    public Font getFuenteBotones(){
        CustomFont cf = new CustomFont();
        return cf.MyFont(0, (float)16);
    }
/********************Colores Fuente**********************/
    

    public Color getColorFuenteTítulo(){
        return Color.black;
    }
    

/********************Colores Fondo***********************/
    
    public Color getColorTítulo(){
        return new Color(245, 127, 23);
    }
    
    public Color getColorExterior(){
        //return new Color(236, 254, 44);
       // return new Color(255, 235, 59);
        return new Color(255, 255, 0);
    }
    
    public Color getColorInterior(){
        return new Color(255,255,255);
        //return new Color(255,255,255);
    }
    
    public Color getColorBotones(){
        return new Color(251, 249, 196);
    }
    
    public Color getColorDanger(){
        return Color.red;
    }
    
    
    
/*********************Otros*********************************/
    public Image getImagenIcono(){
        URL url = getClass().getResource("icon_barcha.png");
        ImageIcon icon = new ImageIcon(url);
        return icon.getImage();
    }
    
}
