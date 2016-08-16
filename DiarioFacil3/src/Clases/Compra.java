/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author Daniel
 */
public class Compra {

    private boolean estado;
    private Calendar fecha;
    private ArrayList<Item> items = new ArrayList<>();
    private ArrayList<Integer> cantidadPorItem = new ArrayList<>();
    private Usuario usuario;

    public Compra() {

    }

    public Compra(boolean estado, Calendar fecha, Carrito carrito, Usuario usuario,
            ArrayList items, ArrayList cantidadPorItem) {

        this.estado = estado;
        this.fecha = fecha;
        this.items = items;
        this.cantidadPorItem = cantidadPorItem;
        this.usuario = usuario;

    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public ArrayList<Integer> getCantidadPorItem() {
        return cantidadPorItem;
    }

    public void setCantidadPorItem(ArrayList<Integer> cantidadPorItem) {
        this.cantidadPorItem = cantidadPorItem;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Calendar getFecha() {
        return fecha;
    }

    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void crearOrden() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM dd HH:mm:ss");
        Calendar calendar = new GregorianCalendar();
        System.out.println(sdf.format(calendar.getTime()));
        double precio = 0;

        System.out.println("\t\t Diario fácil \n" + usuario.getNombre() + sdf.format(calendar.getTime()));

        for (Item i : this.items) {
            int temp = this.items.indexOf(i);
            int cantidad = cantidadPorItem.get(temp);
            precio = +i.getPrecio() * cantidad;
            System.out.println(i.getNombre() + "\t" + cantidad + "\t" + i.getPrecio() * cantidad);

        }

        System.out.println("\t \t" + "El precio total: " + precio);

        try {

            conseguirComentario(precio);
            
        } catch (Exception e) {

            System.out.println(e.getMessage());

        }

    }

    public void conseguirComentario(double precio) throws DiarioFacilException {

        if (precio >= 1000) {

            throw new DiarioFacilException("Gracias");

        } else {

            throw new DiarioFacilException("Lo esperamos");

        }
    }

    public void annadirACompra(Item i, Integer cantidad) {
        this.items.add(i);
        this.cantidadPorItem.add(cantidad);
    }

}
