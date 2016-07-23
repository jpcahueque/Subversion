/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subversion;
import java.util.*;

/**
 * @author Juan Pablo Cahueque 15396
 * @author Enma Lopez 15122
 */
public class Stack implements iPila{
    private int posicion;
    private Vector vector;

    public Stack() {
        posicion = 0;
        vector = new Vector(10,5);
    }

    public Stack(Vector vector) {
        posicion = 10;
        this.vector = vector;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public void setVector(Vector vector) {
        this.vector = vector;
    }

    public int getPosicion() {
        return posicion;
    }

    public Vector getVector() {
        return vector;
    }
    
    public void push(String operando){
        vector.addElement(operando); 
        posicion = posicion + 1;
    }
    
    public String pop(){
        String elemento = (String) vector.elementAt(posicion-1);
        vector.removeElementAt(posicion-1);
        posicion =posicion - 1;
        return elemento;
    }
}
