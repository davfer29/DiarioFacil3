/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author davfer29
 */
public abstract class Item {

    private String descripcion;
    private double precio;
    private String nombre;
    private int existencia;

    public Item() {
    }

    public Item(String descripcion, double precio, String nombre, int existencia) {
        this.descripcion = descripcion;
        this.precio = precio;
        this.nombre = nombre;
        this.existencia = existencia;
    }

    public int getExistencia() {
        return existencia;
    }

    public void setExistencia(int existencia) {
        this.existencia = existencia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
