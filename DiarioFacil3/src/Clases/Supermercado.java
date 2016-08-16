/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

/**
 *
 * @author Daniel
 */
public class Supermercado {

    private String nombre;
    private String telefono;
    private String direccion;
    private ArrayList<Usuario> listaUsuarios = new ArrayList<>();
    private ArrayList<Compra> listaCompras = new ArrayList<>();
    private ArrayList<Item> listaItems = new ArrayList<>();
    private ArrayList<Categoria> listaCategorias = new ArrayList<>();

    public Supermercado() {
    }

    public Supermercado(String nombre, String telefono, String direccion, ArrayList listaUsuarios,
            ArrayList listaCompras, ArrayList listaItems, ArrayList listaCategorias) {

        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.listaUsuarios = listaUsuarios;
        this.listaCompras = listaCompras;
        this.listaItems = listaItems;
        this.listaCategorias = listaCategorias;

    }

    public Supermercado(ArrayList listaUsuarios,
            ArrayList listaCompras, ArrayList listaItems, ArrayList listaCategorias) {

        this.listaUsuarios = listaUsuarios;
        this.listaCompras = listaCompras;
        this.listaItems = listaItems;
        this.listaCategorias = listaCategorias;

    }

    public void setListaItems(ArrayList<Item> listaItems) {
        this.listaItems = listaItems;
    }

    public void setListaCategorias(ArrayList<Categoria> listaCategorias) {
        this.listaCategorias = listaCategorias;
    }

    public ArrayList<Item> getListaItems() {
        return listaItems;
    }

    public ArrayList<Categoria> getListaCategorias() {
        return listaCategorias;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public ArrayList<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public ArrayList<Compra> getListaCompras() {
        return listaCompras;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setListaUsuarios(ArrayList<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public void setListaCompras(ArrayList<Compra> listaCompras) {
        this.listaCompras = listaCompras;
    }

    //Metodos funcionales
    // Metodos para añadir usuarios
    /*
    Las variable boolean usadas en estos metodos son para que una vez que el for empiece a recorrer
    la lista de usuarios no despliegue el mensaje de error cada vez que pase por un objeto que no sea 
    el deseado y una vez que lo logre ejecuta el break para interrumpir la lectura de la lista.
     */
    public void addAministrador(String nombre, String correo, int telefono, String nombreUsuario, String contrasenna) {

        boolean adminSucces = true;

        for (Usuario u : this.listaUsuarios) {
            if (u instanceof Administrador) {
                Administrador a = ((Administrador) u);
                if (!(nombreUsuario.equalsIgnoreCase(a.getNombreUsuario()) || contrasenna.equalsIgnoreCase(a.getContrasenna()))) {
                    try {
                        Carrito x = new Carrito();
                        this.listaUsuarios.add(new Administrador(nombre, correo, telefono, nombreUsuario, contrasenna, x));
                        break;
                    } catch (Exception nullException) {
                        adminSucces = false;
                    }

                } else {
                    adminSucces = false;
                }
            }
        }

        if (!adminSucces) {
            System.out.println("Este usuario ya existe");
        }
    }

    public boolean addCliente(String cedula, String nombre, String correo, long telefono, String nombreUsuario, String contrasenna) {

        boolean clienteSucces = true;

        for (Usuario u : this.listaUsuarios) {
            if (u instanceof Cliente) {
                Cliente c = ((Cliente) u);
                if (!(cedula.equalsIgnoreCase(c.getCedula()) || nombreUsuario.equalsIgnoreCase(c.getNombreUsuario())
                        || contrasenna.equalsIgnoreCase(c.getContrasenna()))) {

                    try {
                        Carrito x = new Carrito();
                        this.listaUsuarios.add(new Cliente(cedula, nombre, correo, telefono, nombreUsuario, contrasenna, x));

                    } catch (Exception nullException) {
                        clienteSucces = false;
                    }

                } else {
                    clienteSucces = false;
                }

            }
        }

        if (!clienteSucces) {
            return false;
        } else {
            return true;
        }
    }

    public boolean addProveedor(String cedulaJuridica, String nombre, String correo, long telefono, String nombreUsuario, String contrasenna) {

        boolean proveeSucces = true;

        for (Usuario u : this.listaUsuarios) {
            if (u instanceof Proveedor) {
                Proveedor p = ((Proveedor) u);

                if (!(cedulaJuridica.equalsIgnoreCase(p.getCedulaJuridica()) || nombreUsuario.equalsIgnoreCase(p.getNombreUsuario())
                        || contrasenna.equalsIgnoreCase(p.getContrasenna()))) {
                    try {
                        Carrito x = new Carrito();
                        this.listaUsuarios.add(new Proveedor(cedulaJuridica, nombre, correo, telefono, nombreUsuario, contrasenna, null, x));
                        break;
                    } catch (Exception nulException) {
                        proveeSucces = false;
                    }

                } else {
                    proveeSucces = false;
                }
            }
        }

        if (!proveeSucces) {
            return false;
        } else {
            return true;
        }
    }
    // Metodos para eliminar usuarios

    /*
    Estos metodos siguen la misma logica que los anteriores
     */
    public void eliminarAdministrador(String userName) {

        boolean adminSucces = true;

        for (Usuario u : this.listaUsuarios) {

            if (u instanceof Administrador) {
                Administrador na = ((Administrador) u);

                if (userName.equalsIgnoreCase(na.getNombreUsuario())) {
                    try {
                        this.listaUsuarios.remove(na);
                        break;
                    } catch (Exception e) {
                        adminSucces = false;
                    }

                } else {
                    adminSucces = false;
                }
            }
        }

        if (!adminSucces) {
            System.out.println("El administrador que desea eliminar no existe");
        }
    }

    public void eliminarCliente(String userName) {

        boolean clienteSucces = true;

        for (Usuario u : this.listaUsuarios) {
            if (u instanceof Cliente) {
                Cliente c = ((Cliente) u);

                if (userName.equalsIgnoreCase(c.getNombreUsuario())) {
                    try {
                        this.listaUsuarios.remove(c);
                        System.out.println("El cliente se ha eliminado con exito.");
                        break;
                    } catch (Exception e) {
                        clienteSucces = false;
                    }

                } else {
                    clienteSucces = false;
                }

            }
        }

        if (!clienteSucces) {
            System.out.println("El cliente que desea eliminar no existe");
        }

    }

    public void eliminarProveedor(String userName) {

        boolean proveSucces = true;

        for (Usuario u : this.listaUsuarios) {
            if (u instanceof Proveedor) {
                Proveedor p = ((Proveedor) u);

                if (userName.equalsIgnoreCase(p.getNombreUsuario())) {
                    try {
                        this.listaUsuarios.remove(p);
                        System.out.println("El provedor se ha eliminado con exito.");
                        break;
                    } catch (Exception e) {
                        proveSucces = false;
                    }

                } else {
                    proveSucces = false;
                }

            }
        }

        if (!proveSucces) {
            System.out.println("El proveedor que desea eliminar no existe");
        }
    }

    // Metodos de modificacion
    public boolean modificarAdministrador(Administrador administrador, String nombre, String correo,
            long telefono, String nombreUsuario, String contrasenna) {

        if (listaUsuarios.contains(administrador)) {

            try {
                administrador.setNombre(nombre);
                administrador.setCorreo(correo);
                administrador.setTelefono(telefono);
                administrador.setNombreUsuario(nombreUsuario);
                administrador.getContrasenna();
                return true;
            } catch (Exception e) {
                return false;
            }

        } else {
            return false;
        }

    }

    public boolean modificarCliente(Cliente cliente, String cedula, String nombre, String correo,
            long telefono, String nombreUsuario, String contrasenna) {
        if (listaUsuarios.contains(cliente)) {

            try {
                cliente.setCedula(cedula);
                cliente.setNombre(nombre);
                cliente.setCorreo(correo);
                cliente.setTelefono(telefono);
                cliente.setNombreUsuario(nombreUsuario);
                cliente.setContrasenna(contrasenna);
                return true;
            } catch (Exception e) {
                return false;
            }

        } else {
            return false;
        }

    }

    public boolean modificarProveedor(Proveedor proveedor, String cedulaJuridica, String nombre, String correo,
            long telefono, String nombreUsuario, String contrasenna) {
        if (listaUsuarios.contains(proveedor)) {

            try {
                proveedor.setCedulaJuridica(cedulaJuridica);
                proveedor.setNombre(nombre);
                proveedor.setCorreo(correo);
                proveedor.setTelefono(telefono);
                proveedor.setNombreUsuario(nombreUsuario);
                proveedor.setContrasenna(contrasenna);
                return true;
            } catch (Exception e) {
                return false;
            }

        } else {
            return false;
        }

    }

    public void imprimirOrdenes() {
        for (Compra c : this.listaCompras) {

            System.out.println(c);

        }

    }

    public ArrayList verCatalogo(Usuario u) {

        ArrayList<Item> temp = new ArrayList<>();
        if (u instanceof Usuario) {

            for (Item i : this.listaItems) {

                if (i instanceof Item) {
                    Item p = ((Item) i);

                    temp.add(p);

                }

            }

        } else {
            return null;
        }

        return listaItems;
    }

    /*
    El logIn funciona de manera optima a la hora de ser probado
    en el tester pero se debe reconciderar su estructura para web
    debido que Struts2 no recorre el for principal que permite la validacion 
    de cada usuario y su tipo respectivo.
     */
    public String logIn(Usuario usuarioL) {

        String rol = "cliente";

        try {
            for (Usuario u : this.listaUsuarios) {
                if (u instanceof Cliente) {
                    Cliente c = ((Cliente) u);
                    if (usuarioL.getNombreUsuario().equals(c.getNombreUsuario())) {

                        if (usuarioL.getContrasenna().equals(c.getContrasenna())) {
                            rol = "cliente";

                        } else {
                            rol = "error";
                        }
                    } else {
                        rol = "error";
                    }
                } else if (u instanceof Proveedor) {
                    Proveedor p = ((Proveedor) u);
                    if (usuarioL.getNombreUsuario().equals(p.getNombreUsuario())) {

                        if (usuarioL.getContrasenna().equals(p.getContrasenna())) {
                            rol = "proveedor";

                        } else {
                            rol = "error";
                        }
                    } else {
                        rol = "error";
                    }
                } else if (u instanceof Administrador) {
                    Administrador a = ((Administrador) u);
                    if (usuarioL.getNombreUsuario().equals(a.getNombreUsuario())) {

                        if (usuarioL.getContrasenna().equals(a.getContrasenna())) {
                            rol = "administrador";

                        } else {
                            rol = "error";
                        }
                    } else {
                        rol = "error";
                    }
                }
            }
        } catch (Exception e) {
            rol = "error";
        }

        return rol;
    }

    /*
    Para crear un cliente frecuente se llamara el metodo cada vez
    que se realice una compra en web para poder mantener actualizado el 
    sistema.
     */
    public void crearClienteFrecuente() {
        Calendar q = Calendar.getInstance();
        int comprasMes = 0;
        for (Usuario c : this.listaUsuarios) {
            if (c instanceof Cliente) {
                Cliente e = ((Cliente) c);

                for (Compra w : this.listaCompras) {
                    if (w.getUsuario() == e) {
                        if (w.getFecha().getTime().getMonth() == q.getTime().getMonth()) {

                            comprasMes++;

                        }

                    }
                }

                if (comprasMes >= 5) {
                    ((Cliente) c).setFrecuente(true);
                }

            }

        }
    }

    /*
    Este metodo se encarga de reconocer cuando un articulo ocupa mas existencias
    la idea principal es sustituir los System.out.println(""); por metodos de
    envio de correo para notificar al proveedor.
     */
    public boolean refillInventario() {

        boolean refill = false;

        for (Usuario u : this.listaUsuarios) {
            if (u instanceof Proveedor) {
                Proveedor p = ((Proveedor) u);

                for (Item i: p.getListaItems()) {
                    if (i instanceof Articulo) {
                        Articulo a = ((Articulo) i);

                        if (a.getExistencia() < 5) {
                            refill = false;
                            if (refill = false) {

                                EnviarCorreo c = new EnviarCorreo();

                                c.enviarCorreo(p, a);

                                System.out.println("El producto necesita más unidades");

                            } else {
                                System.out.println("La cantidad de producto es suficiente");
                            }

                        }
                    }

                }

            }
        }

        return refill;
    }

    public Promocion mostrarPromo(Cliente c) {

        Random ran = new Random();
        ArrayList<Promocion> temp = new ArrayList<>();

        if (c.esFrecuente()) {

            for (Item i : this.listaItems) {

                if (i instanceof Promocion) {
                    Promocion p = ((Promocion) i);

                    temp.add(p);
                }
            }

            int n = ran.nextInt(temp.size());

            return temp.get(n);

        } else {
            return null;
        }
    }

}
