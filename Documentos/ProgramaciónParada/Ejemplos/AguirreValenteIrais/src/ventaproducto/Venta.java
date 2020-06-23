package ventaproducto;

import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 *
 * @author asunawesker 
*/
public class Venta {
    private String descripcion, fechaVenta, id;
    private int place=0;
    private Producto productos[];
    
    //Constructor with all atributes
    public Venta(String id, String descripcion, String fechaVenta) {
        this.id = id;
        this.descripcion = descripcion;
        this.fechaVenta = fechaVenta;
        productos = new Producto[10];
    }

    /*
    Getters and setters
    */
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(String fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        this.place = place;
    }

    public Producto[] getProductos() {
        return productos;
    }

    public void setProductos(Producto[] productos) {
        this.productos = productos;
    }
    
    public boolean fullProductList(){
        return getPlace() == productos.length;
    }
    
    //Union between Producto class and Venta class
    //Composition 
    public void addProduct(String id, String nombre, float precio){
        if (fullProductList()) {
            productos = Arrays.copyOf(productos, productos.length + 10);
        } 
        Producto producto = new Producto(id, nombre, precio);
        this.productos[getPlace()] = producto;
        setPlace(getPlace()+1);
    }

    //Add product method 
    public void printProductsSale(){
        System.out.println("Sale ID: "+getId()+
                "Description: "+getDescripcion()+
                "Date: "+getFechaVenta());
        for (int i=0;i<getPlace();i++) {
            System.out.println("ID: " + productos[i].getId() + 
                        "\nName: " + productos[i].getNombre() + 
                        "\nPrice: " + productos[i].getPrecio());
        } 
    }
    
    //The method add all the products price and create the total price of the sale
    public float totalToPay(){
        float precio = 0;
        for (int i=0;i<getPlace();i++) {
            precio += productos[i].getPrecio();
        }
        return precio;
    }
    
}
