/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author Daniel
 */
public class Combo extends Item {

    private Calendar fechalimite;
    private ArrayList<Articulo> listaArticulos = new ArrayList<Articulo>();

    public Combo() {

    }

    public Combo(Calendar fechalimite, String descripcion, int precio, String nombre, ArrayList listaArticulos, int existencia) {
        super(descripcion, precio, nombre, existencia);
        this.fechalimite = fechalimite;
        this.listaArticulos = listaArticulos;
    }

    public Calendar getFechaLimite() {
        return fechalimite;
    }

    public void setFechaLimite(Calendar fechaLimite) {
        this.fechalimite = fechaLimite;
    }

    public ArrayList<Articulo> getListaArticulos() {
        return listaArticulos;
    }

    public void setListaArticulos(ArrayList<Articulo> listaArticulos) {
        this.listaArticulos = listaArticulos;
    }
}
