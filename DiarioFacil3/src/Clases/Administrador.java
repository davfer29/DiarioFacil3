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
public class Administrador extends Usuario {

    public Administrador() {

    }

    public Administrador(String nombre, String correo, long telefono, String nombreUsuario, String contrasenna, Carrito carrito) {
        super(nombre, correo, telefono, nombreUsuario, contrasenna, carrito);
    }

    public boolean borrarCliente(String nombreUsuario, String pass) {

        if (pass == this.contrasenna) {

            try {
                s.eliminarCliente(nombreUsuario);
                return true;
            } catch (Exception e) {
                return false;
            }

        } else {
            System.out.println("Contraseña de adinistrador no valida.");
            return false;
        }
    }

    public boolean borrarProveedor(String userName, String pass) {

        if (pass == this.contrasenna) {

            try {
                s.eliminarProveedor(userName);
                return true;
            } catch (Exception e) {
                return false;
            }
        } else {
            System.out.println("Contraseña de adinistrador no valida.");
            return false;
        }
    }

}
