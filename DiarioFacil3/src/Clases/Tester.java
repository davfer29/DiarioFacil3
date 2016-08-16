/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author davfer29
 */
public class Tester {
    
      public static void main(String[] args) {
          
          
          
          
          Supermercado su = new Supermercado();
          
          su.setNombre("Ladrillitos SA");
          su.setDireccion("500 metros este del palo de mango");
          su.setTelefono("22589999");
          su.setListaUsuarios(su.getListaUsuarios());
          su.setListaCategorias(su.getListaCategorias());
          su.setListaCompras(su.getListaCompras());
          su.setListaItems(su.getListaItems());
        
          
          
          Cliente cliente = new Cliente();
          Administrador administrador = new Administrador("Daniel","danialvagon@gmail.com", 12354123, "Daniel2016", "Ñañi2017", null);
          Proveedor proveedor = new Proveedor("David","davfer092998@gmail.com", 232342432, "David2016", "David2010", null);
          
          
          Item articulo1 = new Articulo("Pequeño", 32948, "Pepa", 234);
          
          Compra comp = new Compra();
          
          comp.setUsuario(cliente);
          comp.setEstado(true);
          comp.setFecha(Calendar.getInstance());
          comp.annadirACompra(articulo1, 5);
          comp.setItems(comp.getItems());
          comp.crearOrden();
          
                    
          
          su.addCliente("117210893", "David","davfer092998@gmail.com", 232342432, "David2016", "David2010");        
          su.addProveedor("D212423","DavidSA","davfer092998@gmail.com", 232342432, "David2016", "David2010");
          su.addAministrador("Admin", "admin@gmail.com", 0, "admin", "Admin");
          proveedor.addArticulo("leche dos pinos solo bueno IIIIIII COSTA YICAAA",40000 , "Leche", 10);
          cliente.annadirItemaCarrito(articulo1, 4);
          cliente.comprarDeCarrito();
          
          
      }
    
    
}
