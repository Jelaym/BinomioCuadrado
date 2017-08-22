package binomiocuadrado;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


/**
 *
 * @author Touchier
 */
public class binoCua implements ActionListener{
    //Inicializamos variables globales
    private JFrame _Windows;
    private Container _Cont;
    private JTextField _Num1, _Num2;
    private JLabel _Instruccion, _Instruccion2, _Resultado, _PareIzq, _PareDer, _Suma, _Cuadrado, _Igual;
    private JButton _Calcula;
    //Clase "Creador.java
    creador crea;
    
    public binoCua(){
        //Cuando sea declarado en otra clase se inicializaran por orden estos metodos.
        crea= new creador();
        crearVentana();
        crearComponentes();
        mostrar();
    }
    //Metodo que crea la ventana de java swing
    public void crearVentana(){
        //Creamos la ventana
        _Windows= new JFrame("Binomio Cuadrado");
        _Windows.setBounds(200, 200, 700, 500);
        _Windows.setLocationRelativeTo(null);
        _Windows.setResizable(false);
        _Windows.setLayout(null);
        _Cont= _Windows.getContentPane();
        _Cont.setBackground(Color.WHITE);
        _Windows.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    //Metodo que crea los componentes dentro del container
    public void crearComponentes(){
        //Declaramos JLABELS
        //Usamos un metodo para crear labels (Ya que son muchos). Es de "creador.java"
        _Instruccion= crea.creaLabels("Calcular Binomio Cuadrado Perfecto (Solo Números)", 50, 50, 550, 50, 20);
        _Instruccion2= crea.creaLabels("Digito menor o Igual a 100", 50, 80, 550, 50, 20);
        _Resultado= crea.creaLabels("", 100, 250, 500, 50, 25);
        _PareIzq= crea.creaLabels("(", 120, 150, 50, 50, 30);
        _Suma= crea.creaLabels("+", 310, 150, 50, 50, 30);
        _PareDer= crea.creaLabels(")", 520, 150, 50, 50, 30);
        _Cuadrado= crea.creaLabels("2", 530, 125, 50, 50, 18);
        _Igual= crea.creaLabels("=", 70, 250, 350, 50, 25);
        //Los agregamos a la ventana/Container
        _Cont.add(_Instruccion);
        _Cont.add(_Instruccion2);
        _Cont.add(_Resultado);
        _Cont.add(_PareIzq);
        _Cont.add(_Suma);
        _Cont.add(_PareDer);
        _Cont.add(_Cuadrado);
        _Cont.add(_Igual);
        
        //Declaramos JTEXTFIELDS
        _Num1= new JTextField();
        _Num2= new JTextField();
        
        _Num1.setBounds(150, 150, 150, 50);
        _Num2.setBounds(350, 150, 150, 50);
        _Num1.setFont(new Font("Arial",Font.BOLD,20));
        _Num2.setFont(new Font("Arial",Font.BOLD,20));
        _Cont.add(_Num1);
        _Cont.add(_Num2);
        
        //Declaramos JBUTTONS
        _Calcula= new JButton("Calcular");
        _Calcula.setBounds(250, 325, 200, 50);
        _Calcula.addActionListener(this);
        _Calcula.setBackground(Color.BLACK);
        _Calcula.setForeground(Color.WHITE);
        _Calcula.setFont(new Font("Arial",Font.BOLD,20));
                
        _Cont.add(_Calcula);
    }
    //Mostramos la ventana creada en java swing
    public void mostrar(){
        _Windows.setVisible(true);
    }
    
    public void calcular(){
        //Traemos los datos en String
        String nume1= _Num1.getText();
        String nume2= _Num2.getText();
        //Comenzamos la validación de números
        if((nume1.length() != 0) && (nume2.length() != 0)){
            if((esNumero(nume1)) && (esNumero(nume2))){
                int numA= Integer.parseInt(nume1);
                int numB= Integer.parseInt(nume2);
                double result= 0;
                //(a+b)2= a2 + 2ab + b2
                result= Math.pow(numA, 2) + (2*numA*numB) + Math.pow(numB, 2);
                //Printeamos las operaciones efectuadas
                _Resultado.setText("("+ numA + ")^2 + 2(" + numA + ")(" + numB + ") + (" + numB + ")^2" + " = " + result);    
            }else{
                //Enviamos un mensaje si los datos no son númericos
                JOptionPane.showMessageDialog(null, "Los datos no son números.");
            }
        }else{
            //Enviamos un mensaje si los cuadros de texto estan vacíos
            JOptionPane.showMessageDialog(null, "Escribe los numeros que desees calcular \nsu binomio cuadrado en sus respectivas casillas.");
        }
    }
    //Metodo para comprobar que sea número
    public boolean esNumero(String num){
        boolean numero= false;
        int largo= num.length();
        //String de los números
        String numeros= "1234567890";
        int conta= 0;
        for(int o= 0; o < largo; o++){
            for(int i= 0; i < numeros.length(); i++){
                //Evaluamos digito por digito si es número o no
                if(num.charAt(o) == numeros.charAt(i)){
                    conta++;
                    i= numeros.length();
                }
            }
        }
        //El contador aumentara cada vez que sea número, si no coinciden un digito no es número
        if(conta == largo){
            numero= true;
        }
        //Devuelve verdadero si es número o falso si no es número
        return numero;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Si apreta el boton de "Calcular" se ejecutara un metodo
        if(e.getSource() == _Calcula){
            calcular();
        }
    }
}
