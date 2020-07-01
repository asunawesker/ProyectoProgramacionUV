/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventaproducto;

import java.util.ArrayList;
import java.util.Iterator;
import static ventaproducto.Empresa.entrada;

/**
 *
 * @author asunawesker
 */
public class AgendaClientes {
    private final ArrayList <Cliente> clientes;
    //private Cliente clientes[];
    //private int place = 0;
    
    public AgendaClientes(){
        //clientes = new Cliente[100];
        clientes = new ArrayList();
    }

    /*
    Getters & setters
    */
    /*
    public Cliente[] getClientes() {
        return clientes;
    }

    public void setCliente(Cliente[] clientes) {
        this.clientes = clientes;
    }
    
    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        this.place = place;
    }
    
    /*
    public boolean fullClientList(){
        return getPlace() == clientes.length;
    }
    */
    
    public void addCustomer(String option){
        String nombre;
        String apellido;
        String id;
        String telefono;
        boolean condicion = true;
        
        System.out.println("\nCustomer name: ");
        nombre = entrada.next();
        System.out.println("Custumer last name: ");
        apellido = entrada.next();
        System.out.println("Customer ID: ");
        id = entrada.next();
        System.out.println("Telephone: ");
        telefono = entrada.next();
        
        Cliente cliente = new Cliente(id, nombre, apellido, telefono);
        clientes.add(cliente);
        //this.clientes[getPlace()] = cliente;
        //setPlace(getPlace()+1);
        
        
 
        System.out.println("\nDo you want to add another customer? (S/N)");
        option = entrada.next();

        while(condicion == true){
            if (option.equalsIgnoreCase("S")){
                System.out.println("\nCustomer name: ");
                nombre = entrada.next();
                System.out.println("Custumer last name: ");
                apellido = entrada.next();
                System.out.println("Customer ID: ");
                id = entrada.next();
                System.out.println("Telephone: ");
                telefono = entrada.next();

                Cliente clienteOther = new Cliente(id, nombre, apellido, telefono);
                clientes.add(clienteOther);
                //this.clientes[getPlace()] = clienteOther;
                //setPlace(getPlace()+1);
                
                System.out.println("\nDo you want to add another customer? (S/N)");
                option = entrada.next();
            }else if (option.equalsIgnoreCase("N")){
                condicion = false;
                System.out.println("Clients successfully added");
            }
        }
            
        
    } 
    
    public void printCustomers(){
        System.out.println("\n\tCustomers");
        
        Iterator it = clientes.iterator();
        Cliente cliente;
        
        while(it.hasNext()){
            cliente = (Cliente) it.next();
            
            System.out.println("\nID: " + cliente.getId() + 
                    "\nName: " + cliente.getNombre() + 
                    "\nLast name: " + cliente.getApellido() +
                    "\nTelephone: "+ cliente.getTelefono());
        }
        /*
        for (int i=0;i<getPlace();i++) {
            System.out.println("\nID: " + clientes[i].getId() + 
                        "\nNombre: " + clientes[i].getNombre() + 
                        "\nPrecio: " + clientes[i].getTelefono());
            System.out.println("");
        } 
        */
    }
    
    public void searchCustomers(String id){
        System.out.println("\n\tCustomer");
        
        Iterator it = clientes.iterator();
        Cliente cliente;
        
        while(it.hasNext()){
            cliente = (Cliente) it.next();
            if (id.equalsIgnoreCase(cliente.getId())) {
                System.out.println("\nID: " + cliente.getId() + 
                    "\nName: " + cliente.getNombre() + 
                    "\nLast name: " + cliente.getApellido() +
                    "\nTelephone: "+ cliente.getTelefono());
            }
        }
        /*
        System.out.println("\n\tSearching customer");
        for (int i=0;i<getPlace();i++) {
            if (id.equals(clientes[i].getId())) {
                System.out.println("ID: " + clientes[i].getId() + 
                        "\nName: " + clientes[i].getNombre() + 
                        "\nPrice: " + clientes[i].getTelefono());
            } 
        }
    */
    }
    
    public float customerDiscount(Venta venta, String id){
        float discount = 0;
        Iterator it = clientes.iterator();
        Cliente cliente;
        
        while(it.hasNext()){
            cliente = (Cliente) it.next();
            if (id.equalsIgnoreCase(cliente.getId())) {
                discount = (float) (venta.totalToPay()*0.95);
            }
        }
        /*
        for (int i=0;i<getPlace();i++) {
            if (id.equals(clientes[i].getId())) {
                discount = (float) (venta.totalToPay() * .95);
            } 
        }*/
        return discount;
    }
}
