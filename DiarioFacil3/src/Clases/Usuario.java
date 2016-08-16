/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.Calendar;

/**
 *
 * @author Daniel
 */
public class Usuario {

    protected String nombre;
    protected String correo;
    protected long telefono;
    protected String nombreUsuario;
    protected String contrasenna;
    protected Carrito carrito = new Carrito();
    protected final Supermercado s = new Supermercado();

    public Usuario() {

    }

    public Usuario(String nombre, String correo, long telefono,
            String nombreUsuario, String contrasenna, Carrito carrito) {

        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.nombreUsuario = nombreUsuario;
        this.contrasenna = contrasenna;
        this.carrito = carrito;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public long getTelefono() {
        return telefono;
    }

    public Carrito getCarrito() {
        return carrito;
    }

    public void setCarrito(Carrito carrito) {
        this.carrito = carrito;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasenna() {
        return contrasenna;
    }

    public void setContrasenna(String contrasenna) {
        this.contrasenna = contrasenna;
    }

    public void comprarDeCarrito() {

        int counter = 0;
        Calendar c = Calendar.getInstance();
        Compra compra = new Compra();

        for (Item i : carrito.getListaItems()) {

            if (i.getExistencia() <= getCarrito().getCantidadPorArticulo().get(counter)) {

                System.out.println("Los articulos solicitados no estan disponibles");

            } else {

                compra.setUsuario(this);
                compra.setFecha(c);
                compra.annadirACompra(i, carrito.getCantidadPorArticulo().get(counter));
                i.setExistencia(i.getExistencia() - carrito.getCantidadPorArticulo().get(counter));
                s.getListaCompras().add(compra);
                carrito.eliminarDeCarrito(i, carrito.getCantidadPorArticulo().get(counter));
                compra.crearOrden();
                s.refillInventario();

            }
            counter++;
        }
    }

    public boolean annadirItemaCarrito(Item item, int cantidad) {
        if (item.getExistencia() <= cantidad) {
            carrito.annadirItemCarrito(item, cantidad);
            carrito.setPrecioTotal(carrito.getPrecioTotal()+item.getPrecio() * cantidad);
            System.out.println("El item se ingreso con exito");
            return true;
        } else {
            System.out.println("no hay existencias disponibles");
            return false;
        }
    }
}
