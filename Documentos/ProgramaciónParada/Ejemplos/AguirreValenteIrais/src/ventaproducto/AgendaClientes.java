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
    private int placeC = 0;
    
    public void AgendaClientes(){
        clientes = new Cliente[10];
    }
    
    public int getPlaceC() {
        return placeC;
    }

    public void setPlaceC(int placeC) {
        this.placeC = placeC;
    }
    
    public void addCustomer(){
        String nombre;
        String id;
        String telefono;
        
        System.out.println("Customer name: ");
        nombre = entrada.next();
        System.out.println("Customer ID: ");
        id = entrada.next();
        System.out.println("Telephone: ");
        telefono = entrada.next();
        
        Cliente cliente = new Cliente(id, nombre, telefono);
        
        this.clientes[getPlaceC()] = cliente;
        setPlaceC(getPlaceC()+1);
    } 
    
    public void printCustomers(){
        for (int i=0;i<getPlaceC();i++) {
            System.out.println("ID: " + clientes[i].getId() + 
                        "\nNombre: " + clientes[i].getNombre() + 
                        "\nPrecio: " + clientes[i].getTelefono());
        } 
    }
    
    public void searchCustomers(String id){
        for (int i=0;i<getPlaceC();i++) {
            if (id.equals(clientes[i].getId())) {
                System.out.println("ID: " + clientes[i].getId() + 
                        "\nName: " + clientes[i].getNombre() + 
                        "\nPrice: " + clientes[i].getTelefono());
            } 
        }
    }
}
