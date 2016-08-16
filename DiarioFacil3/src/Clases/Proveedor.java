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
 * @author David
 */
public class Proveedor extends Usuario {

    private String cedulaJuridica;
    private ArrayList<Item> listaItems = new ArrayList<>();
    private ArrayList<Categoria> listaCategorias = new ArrayList<>();
    private final Supermercado s = new Supermercado();

    public Proveedor() {

    }

    public Proveedor(String cedulaJuridica, String nombre, String correo, long telefono,
            String nombreUsuario, String contrasenna, ArrayList listaArticulos, Carrito carrito) {
        super(nombre, correo, telefono, nombreUsuario, contrasenna, carrito);
        this.cedulaJuridica = cedulaJuridica;
        this.listaItems = listaArticulos;
        this.listaCategorias = listaArticulos;

    }

    public Proveedor(String nombre, String correo, long telefono, String nombreUsuario, String contrasenna, Carrito carrito) {
        super(nombre, correo, telefono, nombreUsuario, contrasenna, carrito);
    }

    public ArrayList<Categoria> getListaCategorias() {
        return listaCategorias;
    }

    public String getCedulaJuridica() {
        return cedulaJuridica;
    }

    public ArrayList<Item> getListaItems() {
        return listaItems;
    }

    public void setCedulaJuridica(String cedulaJuridica) {
        this.cedulaJuridica = cedulaJuridica;
    }

    public void setListaArticulos(ArrayList listaArticulos) {
        this.listaItems = listaArticulos;
    }

    public void setListaCategorias(ArrayList<Categoria> listaCategorias) {
        this.listaCategorias = listaCategorias;
    }

    @Override
    public String toString() {
        String articulos = "";
        String promociones = "";
        String combos = "";

        for (Item i : this.listaItems) {

            if (i instanceof Articulo) {

                Articulo a = ((Articulo) i);
                articulos += a.getNombre() + ", ";

            } else if (i instanceof Promocion) {

                Promocion p = ((Promocion) i);
                promociones += p.getNombre() + ", ";

            } else if (i instanceof Combo) {

                Combo c = ((Combo) i);
                combos += c.getNombre() + ", ";

            }

        }

        return "Nombre: " + getNombre() + ", correo: " + getCorreo() + ", cedula juridica: " + getCedulaJuridica()
                + ", articulos: " + articulos + ", promociones: " + promociones + ", combos" + combos + ".";
    }

    //Metodos add
    public void addArticulo(String descripcion, double precio, String nombre, int existencia) {

        boolean itemSucces = true;

        for (Item ite : this.listaItems) {

            if (ite instanceof Articulo) {
                Articulo a = ((Articulo) ite);

                if (!(descripcion.equalsIgnoreCase(a.getDescripcion()) || nombre.equalsIgnoreCase(a.getNombre()))) {

                    try {
                        Articulo nu = new Articulo(descripcion, precio, nombre, existencia);
                        this.listaItems.add(nu);
                        s.getListaItems().add(nu);
                        System.out.println("El articulo se ha ingresado con exito");
                        break;
                    } catch (Exception e) {
                        itemSucces = false;
                    }

                } else {
                    itemSucces = false;
                }

            }

        }
        if (!itemSucces) {
            System.out.println("Este articulo ya existe");

        }
    }

    public void addCombo(Calendar fechaLimite, String descripcion, int precio, String nombre, ArrayList listaArticulos, int existencia) {

        boolean comboSucces = true;

        for (Item i : this.listaItems) {
            if (i instanceof Combo) {
                Combo c = ((Combo) i);

                if (!(fechaLimite.equals(c.getFechaLimite()) || nombre.equalsIgnoreCase(c.getNombre()))) {

                    try {
                        Combo co = new Combo(fechaLimite, descripcion, precio, nombre, listaArticulos, existencia);
                        this.listaItems.add(co);
                        s.getListaItems().add(co);
                        System.out.println("El combo se ha ingresado con exito");
                        break;
                    } catch (Exception e) {
                        comboSucces = false;
                    }

                } else {
                    comboSucces = false;
                }

            }

        }
        if (!comboSucces) {
            System.out.println("El combo ya existe");

        }

    }

    public void addCategoria(String nombreCategoria, double precioTotal, ArrayList articulos) {
        boolean categoriaSucces = true;

        for (Categoria c : this.listaCategorias) {
            if (c instanceof Categoria) {
                Categoria ca = ((Categoria) c);

                if (nombreCategoria.equalsIgnoreCase(ca.getNombreCategoria())) {

                    try {
                        Categoria cat = new Categoria(nombreCategoria, precioTotal, articulos);
                        this.listaCategorias.add(cat);
                        s.getListaCategorias().add(cat);
                        System.out.println("La categoria se ha ingresado con exito");
                        break;
                    } catch (Exception e) {
                        categoriaSucces = false;
                    }

                } else {
                    categoriaSucces = false;

                }

            }
        }
        if (!categoriaSucces) {
            System.out.println("La cateogria ya existe");
        }
    }

    public void addPromocion(int descuento, String nombre, int precio, String descripcion, int existencia) {
        boolean promocionSucces = true;

        for (Item i : this.listaItems) {
            if (i instanceof Promocion) {
                Promocion po = ((Promocion) i);

                if (!(nombre.equalsIgnoreCase(po.getNombre()) || descripcion.equalsIgnoreCase(po.getDescripcion()))) {
                    try {
                        Promocion pro = new Promocion(descuento, nombre, precio, descripcion, existencia);
                        this.listaItems.add(pro);
                        s.getListaItems().add(pro);
                        System.out.println("La promocion se ha ingresado con exito");
                        break;
                    } catch (Exception e) {
                        promocionSucces = false;
                    }

                } else {
                    promocionSucces = false;
                }

            }
        }
        if (!promocionSucces) {
            System.out.println("La promocion ya existe");
        }
    }

    // Metodos modificar
    public boolean modificarArticulo(Articulo articulo, String nombre, String descripcion, double precio) {
        if (this.listaItems.contains(articulo)) {

            try {
                articulo.setNombre(nombre);
                articulo.setDescripcion(descripcion);
                articulo.setPrecio(precio);
                return true;

            } catch (Exception e) {
                return false;
            }

        } else {
            System.out.println("El articulo no existe");
            return false;
        }

    }

    public boolean modificarCombo(Combo combo, Calendar fechaLimite, ArrayList listaArticulos) {
        if (this.listaItems.contains(combo)) {

            try {
                combo.setFechaLimite(fechaLimite);
                combo.setListaArticulos(listaArticulos);
                return true;

            } catch (Exception e) {
                return false;
            }

        } else {
            System.out.println("Este combo no existe! ");
            return false;
        }

    }

    public boolean modificarPromocion(Promocion promo, int descuento, double precio, String descripcion) {
        if (this.listaItems.contains(promo)) {

            try {
                promo.setPrecio(precio);
                promo.setDescripcion(descripcion);
                return true;
            } catch (Exception e) {
                return false;
            }

        } else {
            return false;
        }
    }

    // Metodos eliminar
    public void eliminarArticulo(String nombre) {

        boolean itemSucces = true;

        for (Item ite : this.listaItems) {

            if (ite instanceof Item) {
                Item i = ((Item) ite);

                if (nombre.equalsIgnoreCase(i.getNombre())) {

                    try {
                        this.listaItems.remove(i);
                        s.getListaItems().remove(i);
                        System.out.println("El articulo se ha eliminado con exito");
                        break;
                    } catch (Exception e) {
                        itemSucces = false;
                    }

                } else {
                    itemSucces = false;
                }
            }
        }
        if (!itemSucces) {
            System.out.println("Este articulo no existe");

        }
    }

    public void eliminarCategoria(String nombreCategoria) {

        boolean categoriaSucces = true;

        for (Categoria c : this.listaCategorias) {

            if (c instanceof Categoria) {
                Categoria ca = ((Categoria) c);

                if (nombreCategoria.equalsIgnoreCase(ca.getNombreCategoria())) {

                    try {
                        this.listaCategorias.remove(ca);
                        s.getListaCategorias().remove(ca);
                        System.out.println("La categoria se ha eliminado con exito");
                        break;
                    } catch (Exception e) {
                        categoriaSucces = false;
                    }

                } else {
                    categoriaSucces = false;
                }
            }
        }
        if (!categoriaSucces) {
            System.out.println("La cateogria no existe");
        }
    }

    public void eliminarPromocion(String nombre) {

        boolean promocionSucces = true;

        for (Item i : this.listaItems) {

            if (i instanceof Promocion) {
                Promocion po = ((Promocion) i);

                if (nombre.equalsIgnoreCase(po.getNombre())) {

                    try {
                        this.listaItems.remove(po);
                        s.getListaItems().remove(po);
                        System.out.println("La promocion se ha eliminado con exito");
                        break;

                    } catch (Exception e) {
                        promocionSucces = false;
                    }

                } else {
                    promocionSucces = false;
                }

            }
        }
        if (!promocionSucces) {
            System.out.println("La promocion no existe");
        }
    }

    public void eliminarCombo(Calendar fechaLimite, String nombre) {
        boolean comboSucces = true;

        for (Item i : this.listaItems) {
            if (i instanceof Combo) {
                Combo c = ((Combo) i);

                if (fechaLimite.equals(c.getFechaLimite()) || nombre.equalsIgnoreCase(c.getNombre())) {

                    try {
                        this.listaItems.remove(c);
                        s.getListaItems().remove(c);
                        System.out.println("El combo se ha elimiado con exito");
                        break;

                    } catch (Exception e) {
                        comboSucces = false;
                    }

                } else {
                    comboSucces = false;
                }

            }

        }
        if (!comboSucces) {
            System.out.println("El combo no existe");

        }

    }

    public void imprimirCombos() {

        for (Item c : this.listaItems) {

            if (c instanceof Combo) {
                Combo e = ((Combo) c);

                System.out.println(e);

            }

        }
    }

    public void imprimirArticulos() {

        for (Item c : this.listaItems) {

            if (c instanceof Articulo) {
                Articulo a = ((Articulo) c);

                System.out.println(a);
            }
        }
    }

    public void imprimirPromociones() {

        for (Item c : this.listaItems) {

            if (c instanceof Promocion) {
                Promocion p = ((Promocion) c);

                System.out.println(p);
            }
        }
    }

    public void reabastecerInventario(String nombreArticulo, int cantidad) {

        for (Item i : this.listaItems) {

            if (i instanceof Articulo) {
                Articulo a = ((Articulo) i);

                if (nombreArticulo.equalsIgnoreCase(a.getNombre())) {

                    a.setExistencia(a.getExistencia() + cantidad);

                    for (Item x : s.getListaItems()) {

                        if (x instanceof Articulo) {
                            Articulo l = ((Articulo) x);

                            if (nombreArticulo.equalsIgnoreCase(l.getNombre())) {

                                l.setExistencia(l.getExistencia() + cantidad);
                            }
                        }
                    }

                }

            }
        }

    }

}
