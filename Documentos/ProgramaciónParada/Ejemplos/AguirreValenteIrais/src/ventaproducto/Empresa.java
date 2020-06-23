package ventaproducto;

import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author asunawesker
 */
public class Empresa {
    private String nombre;
    private int place = 0;
    private Venta ventas[];
    private String option;
    private Catalogo catalogo;
    static Scanner entrada = new Scanner(System.in);
    
    //Constructor with all the atributes except for place
    public Empresa(String nombre){
        this.nombre = nombre;
        ventas = new Venta[3];
        catalogo = new Catalogo();
    }

    /*
    Getters and setters
    */
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        this.place = place;
    }

    public Venta[] getVentas() {
        return ventas;
    }

    public void setVentas(Venta[] ventas) {
        this.ventas = ventas;
    }
    
    //Union between Empresa class and Venta class
    //Aggregation 
    public void addSale(){
        
        String idSale, descripcion, fechaVenta;
        
        System.out.println("Sale ID:");
        idSale = entrada.next();
        System.out.println("Description: ");
        descripcion = entrada.next();
        System.out.println("Date: ");
        fechaVenta = entrada.next();

        Venta venta = new Venta(idSale, descripcion, fechaVenta);

        this.ventas[getPlace()] = venta;
        setPlace(getPlace()+1);
        
        String idProduct;
        
        System.out.println("Product ID: ");
        idProduct = entrada.next();

        catalogo.addToSale(venta, idProduct);
        
        do{
 
            System.out.println("Do you want to add another product? (S/N)");
            option = entrada.next();
            
            switch(option){
                case "S":
                    System.out.println("Product ID: ");
                    idProduct = entrada.next();

                    catalogo.addToSale(venta, idProduct);
                    break;
                case "N":
                    break;
            }
            
        } while(!option.equals("N"));
        
    }
    
    public void addProductsToCatalog(){
        String idProduct;
        String nombre;
        float precio;

        System.out.println("Product ID: ");
        idProduct = entrada.next();
        System.out.println("Product name: ");
        nombre = entrada.next();
        System.out.println("Price: ");
        precio = entrada.nextFloat();

        Producto producto = new Producto(idProduct,nombre,precio);
        catalogo.addProduct(producto); 

    }
    
    //The method search a specific sale and print it 
    public void searchSale(){
        String idSale;
        System.out.println("Sale ID: ");
        idSale = entrada.next();
        
        for (int i=0;i<getPlace();i++) {
            if (idSale.equals(ventas[i].getId())) {
                System.out.println("ID: " + ventas[i].getId() + 
                        "\nDescripción: " + ventas[i].getDescripcion() + 
                        "\nFecha de venta: " + ventas[i].getFechaVenta() + 
                        "\nPrecio total: " + ventas[i].totalToPay());
            } 
        }
    }
    
    public void showSale(){
        for (int i=0;i<getPlace();i++){
            ventas[i].printProductsSale();
        }
    }
}
