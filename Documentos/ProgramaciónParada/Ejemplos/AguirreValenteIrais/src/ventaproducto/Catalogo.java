/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventaproducto;

import java.util.Arrays;

/**
 *
 * @author asunawesker
 */
public class Catalogo {
    private Producto productos[];
    private int place = 0;
    
    public Catalogo(){
        productos = new Producto[10];
    }

    /*
    Getters & setters
    */
    public Producto[] getProductos() {
        return productos;
    }

    public void setProducto(Producto[] productos) {
        this.productos = productos;
    }

    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        this.place = place;
    }
    
    public boolean fullProductList(){
        return getPlace() == productos.length;
    }
    
    //Union between Producto class and Venta class
    //Composition 
    public void addProduct(String id, String nombre, int precio){
        if (fullProductList()) {
            productos = Arrays.copyOf(productos, productos.length + 10);
        } 
        Producto producto = new Producto(id, nombre, precio);
        this.productos[getPlace()] = producto;
        setPlace(getPlace()+1);
    }

    //Add product method 
    public void printProducts(){
        for (int i=0;i<getPlace();i++) {
            System.out.println("ID: " + productos[i].getId() + 
                        "\nNombre: " + productos[i].getNombre() + 
                        "\nPrecio: " + productos[i].getPrecio());
        } 
    }
    
}
