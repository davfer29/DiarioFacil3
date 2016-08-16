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
public class Promocion extends Item {
    
    public Promocion(){
    }

    public Promocion(int descuento, String nombre, int precio,
            String descripcion, int existencia) {
        super(descripcion, precio, nombre, existencia);
    }   
}
