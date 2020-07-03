/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventaproducto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/**
 *
 * @author asunawesker
 */
public class Catalogo {
    private ArrayList <Producto> productos;
    //private Producto productos[];
    //private int place = 0;
    
    public Catalogo(){
        //productos = new Producto[100];
        productos = new ArrayList();
    }

    /*
    Getters & setters
    */
    /*
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
    */
    public void addProduct(Producto producto){
        productos.add(producto); 
       /*if (fullProductList()){
            productos = Arrays.copyOf(productos, productos.length+100);
        }
        this.productos[getPlace()] = producto;
        setPlace(getPlace()+1);*/
    }

    //Add product method 
    public void printProducts(){
        System.out.println("\n\tProducts");
        
        Iterator it = productos.iterator();
        Producto producto;
        while(it.hasNext()){
            producto = (Producto) it.next();
            System.out.println("\nID: " + producto.getId() + 
                        "\nNombre: " + producto.getNombre() + 
                        "\nPrecio: " + producto.getPrecio())
;       }
        /*
        for (int i=0;i<getPlace();i++) {
            System.out.println("\nID: " + productos[i].getId() + 
                        "\nNombre: " + productos[i].getNombre() + 
                        "\nPrecio: " + productos[i].getPrecio());
        } 
        */
    }

    //Search product method, the method print and specific product 
    public void searchProduct(String id){
        System.out.println("\n\tProduct");
        
        Iterator it = productos.iterator();
        Producto producto;
        while(it.hasNext()){
            producto = (Producto) it.next();
            if(id.equalsIgnoreCase(producto.getId())){
                System.out.println("\nID: " + producto.getId() + 
                        "\nNombre: " + producto.getNombre() + 
                        "\nPrecio: " + producto.getPrecio());
            }
        }
        /*
        for (int i=0;i<getPlace();i++) {
            if (id.equals(productos[i].getId())) {
                System.out.println("\nID: " + productos[i].getId() + 
                        "\nName: " + productos[i].getNombre() + 
                        "\nPrice: " + productos[i].getPrecio());
                System.out.println("");
            } 
        }
        */
    }
    
    public void addToSale(Venta venta, String id){
        Iterator it = productos.iterator();
        Producto producto;
        while(it.hasNext()){
            producto = (Producto) it.next();
            if(id.equalsIgnoreCase(producto.getId())){
                venta.addProduct(producto.getId(), producto.getNombre(), producto.getPrecio());
            }
        }
        /*
        for (int i=0;i<getPlace();i++){
            if (id.equals(productos[i].getId())){
                venta.addProduct(productos[i].getId(), productos[i].getNombre(), productos[i].getPrecio());
            } 
        }
        */
    }
}
