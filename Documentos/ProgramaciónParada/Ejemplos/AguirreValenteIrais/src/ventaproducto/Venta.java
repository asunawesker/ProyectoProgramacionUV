package ventaproducto;

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
    
    //Union between Producto class and Venta class
    //Composition 
    public void addProduct(String id, String nombre, int precio){
        Producto producto = new Producto(id, nombre, precio);
        this.productos[getPlace()] = producto;
        setPlace(getPlace()+1);
    }

    //Add product method 
    public void printProducts(){
        for (int i=0;i<getPlace();i++) {
            JOptionPane.showMessageDialog(null, 
                        "ID: " + productos[i].getId() + 
                        "\nNombre: " + productos[i].getNombre() + 
                        "\nPrecio: " + productos[i].getPrecio(), 
                        "Product", JOptionPane.DEFAULT_OPTION);
        } 
    }
    
    //Search product method, the method print and specific product 
    public void searchProduct(String id){
        for (int i=0;i<getPlace();i++) {
            if (id.equals(productos[i].getId())) {
                JOptionPane.showMessageDialog(null, 
                        "ID: " + productos[i].getId() + 
                        "\nNombre: " + productos[i].getNombre() + 
                        "\nPrecio: " + productos[i].getPrecio(), 
                        "Product", JOptionPane.DEFAULT_OPTION);
            } 
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
