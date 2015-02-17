package Main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.SplashScreen;

public class ScreenSplash {
  
    final SplashScreen splash ;
    //texto que se muestra a medida que se va cargando el screensplah
    final String[] texto = {"", "Base de datos", "Interfaz de usuario", "Imagenes",
                          "Modulos", "Clases", "Entidades", "Librerias",
                          "Archivos", "Propiedades", "Menus", "Metodos" , "Interfaz", "Clase Principal"};

    public ScreenSplash(){
        splash = SplashScreen.getSplashScreen();
    }//END CONSTRUCTOR

    public void animar(){
        if(splash != null){
            Graphics2D g = splash.createGraphics();
            for(int i=0; i<texto.length; i++){                     
                //se pinta texto del array
                g.setColor(new Color(76,77,79));//color de fondo
                g.fillRect(180,70,251,20);//para tapar texto anterior
                g.setColor(Color.WHITE);//color de texto 
                g.drawString("Cargando "+texto[i]+"...", 182, 85);                
                g.setColor(Color.WHITE);//color de barra de progeso
                g.fillRect(190, 168,(i*250/texto.length), 12);//la barra de progreso
                splash.update();
                try {
                    Thread.sleep(500);
                }catch(InterruptedException e) { }
            }//END FOR
            splash.close();
        }//END IF
        MainWindow mw = new MainWindow();
        mw.setSize(new Dimension(1024,642));
        mw.setTitle("Laboratorio Pasteur - LabSystem 1.0");
        mw.setLocationRelativeTo(null);
        mw.setResizable(false);
        mw.setVisible(true);
        mw.toFront();
    }//END ANIMAR

}//END CLASS
