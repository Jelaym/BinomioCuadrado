package binomiocuadrado;

import java.awt.Font;
import javax.swing.JLabel;

/**
 *
 * @author Touchier
 */
public class creador {
    //Inicializamos un JLabel 
    public JLabel _Creador;
    public creador(){
        
    }
    //Metodo que sirve para crea JLabels
    public JLabel creaLabels(String texto, int xPos, int yPos, int xSize, int ySize, int FontSize){
        //Declaramos un JLabel
        _Creador= new JLabel(texto);
        _Creador.setBounds(xPos, yPos, xSize, ySize);
        _Creador.setFont(new Font("Arial",Font.BOLD,FontSize));
        //Devuelve un JLabel
        return _Creador;
    }
}
