package ventaproducto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author asunawesker
 */
public class Empresa {
    static Scanner entrada = new Scanner(System.in);
    
    private String nombre;
    private String option;
    private Catalogo catalogo;
    private AgendaClientes agenda;
    private ArrayList <Venta> ventas;
    //private int placeV = 0;
    //private Venta ventas[];
    
    //Constructor with all the atributes except for place
    public Empresa(String nombre){
        this.nombre = nombre;
        catalogo = new Catalogo();
        agenda = new AgendaClientes();
        ventas = new ArrayList();
        //ventas = new Venta[3];
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
    
    public Catalogo getCatalogo() {
        return catalogo;
    }

    public void setCatalogo(Catalogo catalogo) {
        this.catalogo = catalogo;
    }
    
    /*
    public int getPlaceV() {
        return placeV;
    }

    public void setPlaceV(int placeV) {
        this.placeV = placeV;
    }

    public Venta[] getVentas() {
        return ventas;
    }

    public void setVentas(Venta[] ventas) {
        this.ventas = ventas;
    }
    
    private boolean fullSaleList(){
        return getPlaceV() == ventas.length;
    }
    */
    
    //Union between Empresa class and Venta class
    //Aggregation 
    public void addSale(){
        String idProduct;
        String idCustomer;
        
        /*
        if (fullSaleList()) {
            ventas = Arrays.copyOf(ventas, ventas.length + 10);
        }
        */

        String idSale, descripcion, fechaVenta;
        
        System.out.println("\n.: S A L E :.");
        
        System.out.println("\nSale ID:");
        idSale = entrada.next();
        System.out.println("Description: ");
        descripcion = entrada.next();
        System.out.println("Date: ");
        fechaVenta = entrada.next();

        Venta venta = new Venta(idSale, descripcion, fechaVenta);
        
        ventas.add(venta);
        //this.ventas[getPlaceV()] = venta;
        //setPlaceV(getPlaceV()+1);
        
        System.out.println("\nProduct ID: ");
        idProduct = entrada.next();

        catalogo.addToSale(venta, idProduct);
        
        do{
 
            System.out.println("\nDo you want to add another product? (S/N)");
            option = entrada.next();
            
            switch(option){
                case "S":
                    System.out.println("\nProduct ID: ");
                    idProduct = entrada.next();

                    catalogo.addToSale(venta, idProduct);
                    System.out.println("");
                    break;
                case "N":
                    break;
            }
            
        } while(!option.equals("N"));
        
        System.out.println("\nDoes the customer have an account in the store?(S/N)");
        option = entrada.next();

        switch(option){
            case "S":
                
                System.out.println("\n\tCustomer Account");
                
                System.out.println("Customer ID: ");
                idCustomer = entrada.next();
                
                System.out.println("\n\tSale");
                System.out.println("\nID: " + venta.getId() + 
                        "\nDescription: " + venta.getDescripcion() + 
                        "\nSale date: " + venta.getFechaVenta() + 
                        "\nTotal price: " + agenda.customerDiscount(venta, idCustomer));
                break;
            case "N":
                System.out.println("\n\tSale");
                System.out.println("ID: " + venta.getId() + 
                        "\nDescription: " + venta.getDescripcion() + 
                        "\nSale date: " + venta.getFechaVenta() + 
                        "\nTotal price: " + venta.totalToPay());
                break;
        }

    }
    
    public void addProductsToCatalog(){
        String idProduct;
        String nombre;
        float precio;

        System.out.println("\n\tAdding to the catalog");
        
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
        
        System.out.println("\n\tSearching sale");
        
        System.out.println("\nSale ID: ");
        idSale = entrada.next();
        
        Iterator it = ventas.iterator();
        Venta venta;
        while(it.hasNext()){
            venta = (Venta) it.next();
            if (idSale.equalsIgnoreCase(venta.getId())){
                System.out.println("ID: " + venta.getId() + 
                        "\nDescription: " + venta.getDescripcion() + 
                        "\nSale data: " + venta.getFechaVenta() + 
                        "\nTotal price: " + venta.totalToPay());
            }
        }
        /*
        for (int i=0;i<getPlaceV();i++) {
            if (idSale.equals(ventas[i].getId())) {
                System.out.println("ID: " + ventas[i].getId() + 
                        "\nDescription: " + ventas[i].getDescripcion() + 
                        "\nSale data: " + ventas[i].getFechaVenta() + 
                        "\nTotal price: " + ventas[i].totalToPay());
            } 
        }
        */
    }
    
    public void showSale(){ 
        Iterator it = ventas.iterator();
        Venta venta;
        while(it.hasNext()){
            venta = (Venta) it.next();
            venta.printProductsSale();
        }
        /*
        for (int i=0;i<getPlaceV();i++){
            ventas[i].printProductsSale();
        }
        */
    }
    
    public void allCustomers(){
        agenda.printCustomers();
    }
    
    public void searchCustomers(){
        String id;
        
        System.out.println("\nCustomer ID: ");
        id = entrada.next();
        
        agenda.searchCustomers(id);
    }
    
    public void addCustomers(){
        agenda.addCustomer(option);
    }
}
