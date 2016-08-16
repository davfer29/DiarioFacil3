/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;


/**
 *
 * @author David
 */
public class Articulo extends Item implements IDescuento {

    public Articulo() {
        super();
    }

    public Articulo(String descripcion, double precio, String nombre, int existencia) {
        super(descripcion, precio, nombre, existencia);
    }

    @Override
    public double getDescuento() {
        return 0;
    }

    @Override
    public void calcularDescuento(double precio, double descuento) {
        
    }
}
