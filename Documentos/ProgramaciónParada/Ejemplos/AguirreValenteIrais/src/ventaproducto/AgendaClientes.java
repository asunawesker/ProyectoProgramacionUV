/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventaproducto;

import static ventaproducto.Empresa.entrada;

/**
 *
 * @author asunawesker
 */
public class AgendaClientes {
    private Cliente clientes[];
    private int place = 0;
    
    public AgendaClientes(){
        clientes = new Cliente[100];
    }

    /*
    Getters & setters
    */
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
    
    public boolean fullClientList(){
        return getPlace() == clientes.length;
    }

    
    public void addCustomer(String option){

        String nombre;
        String apellido;
        String id;
        String telefono;
        
        System.out.println("Customer name: ");
        nombre = entrada.next();
        System.out.println("Custumer last name: ");
        apellido = entrada.next();
        System.out.println("Customer ID: ");
        id = entrada.next();
        System.out.println("Telephone: ");
        telefono = entrada.next();
        
        Cliente cliente = new Cliente(id, nombre, apellido, telefono);
        this.clientes[getPlace()] = cliente;
        setPlace(getPlace()+1);
        
        do{
 
            System.out.println("Do you want to add another customer? (S/N)");
            option = entrada.next();
            
            switch(option){
                case "S":
                    System.out.println("Customer name: ");
                    nombre = entrada.next();
                    System.out.println("Custumer last name: ");
                    apellido = entrada.next();
                    System.out.println("Customer ID: ");
                    id = entrada.next();
                    System.out.println("Telephone: ");
                    telefono = entrada.next();

                    Cliente clienteOther = new Cliente(id, nombre, apellido, telefono);

                    this.clientes[getPlace()] = clienteOther;
                    setPlace(getPlace()+1);
                    break;
                    
                case "N":
                    System.out.println("Clients successfully added");
                    break;
            }
            
        } while(!option.equals("N"));
        
    } 
    
    public void printCustomers(){
        for (int i=0;i<getPlace();i++) {
            System.out.println("ID: " + clientes[i].getId() + 
                        "\nNombre: " + clientes[i].getNombre() + 
                        "\nPrecio: " + clientes[i].getTelefono());
            System.out.println("");
        } 
    }
    
    public void searchCustomers(String id){
        for (int i=0;i<getPlace();i++) {
            if (id.equals(clientes[i].getId())) {
                System.out.println("ID: " + clientes[i].getId() + 
                        "\nName: " + clientes[i].getNombre() + 
                        "\nPrice: " + clientes[i].getTelefono());
            } else if (!id.equals(clientes[i].getId())) {
                System.out.println("The coustumer does not exist");
            }
        }
    }
    
    public float customerDiscount(Venta venta, String id){
        float discount = 0;
        for (int i=0;i<getPlace();i++) {
            if (id.equals(clientes[i].getId())) {
                discount = (float) (venta.totalToPay() * .95);
            } 
        }
        return discount;
    }
}
