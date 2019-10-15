/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domiciliarydron;

/**
 *
 * @author GAMER 104
 */
public class Dron {
    private int posicionY = 0;
    private int posicionX = 0;
    private char direccion = 'N';


    public Dron(int posicionY, int posicionX,char direccion) {
        this.posicionY = posicionY;
        this.posicionX = posicionX;
        this.direccion = direccion;
    }

    public Dron() {
    }

    public int getPosicionY() {
        return posicionY;
    }

    public void setPosicionY(int posicionY) {
        this.posicionY = posicionY;
    }

    public int getPosicionX() {
        return posicionX;
    }

    public void setPosicionX(int posicionX) {
        this.posicionX = posicionX;
    }

    public char getDireccion() {
        return direccion;
    }

    public void setDireccion(char direccion) {
        this.direccion = direccion;
    }
}
