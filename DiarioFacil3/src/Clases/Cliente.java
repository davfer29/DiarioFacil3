/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;


/**
 *
 * @author Daniel
 */
public class Cliente extends Usuario {

    private String cedula;
    private boolean frecuente;

    public Cliente() {

    }

    public Cliente(String cedula, String nombre, String correo, long telefono, String nombreUsuario, String contrasenna, Carrito carrito) {
        super(nombre, correo, telefono, nombreUsuario, contrasenna, carrito);
        this.cedula = cedula;

    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public boolean esFrecuente() {
        return frecuente;
    }

    public void setFrecuente(boolean frecuente) {
        this.frecuente = frecuente;
    }
    
}
