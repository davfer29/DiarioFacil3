/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import javax.swing.JOptionPane;

/**
 *
 * @author davfer29
 */
public class EnviarCorreo {
    
   
         Correo c = new Correo();
    
    public void enviarCorreo(Proveedor p, Articulo a){
        
         String asunto = "Reabastecimiento del inventario";
         String mensaje = "Se necesita reabastecimiento del articulo " +a.getNombre();

        c.setContrasenna("gcsxtccwonmopsag");
        c.setUsuarioCorreo("davfer092998@gmail.com");
        c.setAsunto(asunto);
        c.setMensaje(mensaje);
        c.setDestino(p.getCorreo().trim());
   
        Controlador con = new Controlador();
        if(con.enviarCorreo(c)){
        
            
            JOptionPane.showMessageDialog(null, "Envio exitoso");
    }else{
             JOptionPane.showMessageDialog(null, "Error");
        }
    
    }

    
    
}
