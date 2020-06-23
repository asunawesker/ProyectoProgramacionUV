package ventaproducto;

import javax.swing.JOptionPane;

/**
 *
 * @author asunawesker
 */
public class Empresa {
    private String nombre;
    private int place = 0;
    private Venta ventas[];
    
    //Constructor with all the atributes except for place
    public Empresa(String nombre){
        this.nombre = nombre;
        ventas = new Venta[3];
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
    public void addSale(Venta venta){
        this.ventas[getPlace()] = venta;
        setPlace(getPlace()+1);
    }
    
    //The method print all the sales
    public void printSales(){
        for (int i=0;i<getPlace();i++) {
            JOptionPane.showMessageDialog(null, 
                    "ID: "+ventas[i].getId()+
                    "\nDescripción: "+ventas[i].getDescripcion()+
                    "\nFecha de venta: "+ventas[i].getFechaVenta()+
                    "\nPrecio total: "+ventas[i].totalToPay()+"\n",
                    "Sales",JOptionPane.INFORMATION_MESSAGE);
            
        }
    }
    
    //The method search a specific sale and print it 
    public void searchSales(String id){
        for (Venta venta : ventas) {
            if (id.equals(venta.getId())) {
                JOptionPane.showMessageDialog(null, "ID: " + venta.getId() + 
                        "\nDescripción: " + venta.getDescripcion() + 
                        "\nFecha de venta: " + venta.getFechaVenta() + 
                        "\nPrecio total: " + venta.totalToPay(), 
                        "Sale", JOptionPane.INFORMATION_MESSAGE);
            } 
        }
    }
    
    //The method print a specific total to pay on a sale and print it
    public float individualTotalPay(String id){
        float precio = 0;
        for (int i=0;i<getPlace();i++){
            if (id.equals(ventas[i].getId())) {
                precio = ventas[i].totalToPay();
            }
        }
        return precio;
    }
}
