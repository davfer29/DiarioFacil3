/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.ArrayList;

/**
 *
 * @author davfer29
 */
public class Carrito {
    
    private ArrayList <Item> listaItems = new ArrayList <>();
    private ArrayList <Integer> cantidadPorArticulo = new ArrayList<>();
    private double precioTotal;

    public Carrito() {
    }

    public Carrito(double precioTotal, ArrayList listaItems, ArrayList cantidadPorArticulo) {
        this.precioTotal = precioTotal;
        this.listaItems = listaItems;
        this.cantidadPorArticulo = cantidadPorArticulo;
    }

    public ArrayList<Integer> getCantidadPorArticulo() {
        return cantidadPorArticulo;
    }

    public void setCantidadPorArticulo(ArrayList<Integer> cantidadPorArticulo) {
        this.cantidadPorArticulo = cantidadPorArticulo;
    }

    public ArrayList<Item> getListaItems() {
        return listaItems;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setListaItems(ArrayList<Item> listaItems) {
        this.listaItems = listaItems;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }
    
    public void annadirItemCarrito(Item item, int cantidad){
        this.listaItems.add(item);
        this.cantidadPorArticulo.add(cantidad);
    }
    
    public void vaicarItemCarrito() {
        this.listaItems.clear();
        this.cantidadPorArticulo.clear();
    }
    
    public void eliminarDeCarrito(Item item, int cantidad) {
        this.listaItems.remove(item);
        this.cantidadPorArticulo.remove(cantidad);
    }
    
}
