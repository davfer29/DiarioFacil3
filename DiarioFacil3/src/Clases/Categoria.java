/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.ArrayList;

/**
 *
 * @author Daniel
 */
public class Categoria {

    ArrayList<Articulo> articulos = new ArrayList<>();
    String nombreCategoria;
    double precioTotal;

    public Categoria() {

    }

    public Categoria(String nombreCategoria, double precioTotal, ArrayList articulos) {
        this.nombreCategoria = nombreCategoria;
        this.precioTotal = precioTotal;
        this.articulos = articulos;
    }

    public ArrayList<Articulo> getArticulos() {
        return articulos;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setArticulos(ArrayList<Articulo> articulos) {
        this.articulos = articulos;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }
    
    
}
