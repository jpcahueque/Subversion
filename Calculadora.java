/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subversion;
import java.io.IOException;
import java.util.*;
/**
 *
 * @author Juan Pablo Cahueque 15396
 * @author Enma Lopez 15122
 */
public class Calculadora {
    private String linea;
    private String archivo;
    private Stack pilaCalc;
    public Calculadora() {
        linea = "22+";
        archivo = "C:\\Users\\JuanPablo\\Documents\\NetBeansProjects\\Subversion\\src\\subversion\\datos.txt"; /*Esta direccion varia segun la direccion donde se enceuntre el archivo****/
        pilaCalc = new Stack();
    }

    public Calculadora(String archivo) {
        linea = " ";
        this.archivo = archivo;
    }
    
    public void calcular() throws IOException {
        String linea, elementoActual;
        int numero1, numero2;
        Vector parrafo = LecturaArchivo.mostrarContenido(archivo);
        for (int i = 0; i<parrafo.size();i++){
            linea = (String) parrafo.elementAt(i);
            for (int j=0;j<linea.length();j++){
                elementoActual = linea.substring(j, j+1);
                try{
                   Integer.parseInt(elementoActual);
                   pilaCalc.push(elementoActual);
                }
                catch(NumberFormatException e){
                    if (!elementoActual.equalsIgnoreCase(" ") && (pilaCalc.getVector()).size()>=2){
                        numero2 = Integer.parseInt(pilaCalc.pop());
                        numero1 = Integer.parseInt(pilaCalc.pop());
                        switch (elementoActual){
                            case "+":
                                numero1 =numero1+ numero2;
                                break;
                            case "-":
                                numero1 =numero1 - numero2;
                                break;
                            case "*":
                                numero1 = numero1 *numero2;
                                break;
                            case "/":
                                numero1 = numero1/numero2;
                                break;
                            default:
                                System.out.println("La linea " + (i+1)+" del archivo tiene errores!");
                                j = linea.length();
                                break;
                        }
                        pilaCalc.push(Integer.toString(numero1));
                    }
                    else{
                        j=linea.length();
                        pilaCalc.push("error");
                    }
                }
            }
            if (pilaCalc.getVector().size()>1){
                System.out.println("La linea "+ (i+1)+ " tiene errores de operacion");
            }
            else{
                System.out.println("El resultado de la linea "+(i+1)+" es: " +(pilaCalc.getVector()).elementAt(0));
            }
            pilaCalc.getVector().removeAllElements();
            pilaCalc.setPosicion(0);
        }
        System.out.println("No hay mas lineas que calcular");
        
    }
    
    
    
    
    
}
