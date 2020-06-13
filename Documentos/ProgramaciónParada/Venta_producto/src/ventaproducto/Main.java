package ventaproducto;

import javax.swing.JOptionPane;

/**
 *
 * @author asunawesker
 */
public class Main {
    static Empresa empresa = new Empresa ("Abarrotes Unidos");

    public static void main(String[] args) {
        
        insertData();
        menu();
                        
    }
    
    public static void menu() {
        String idSale, idProduct;
        String option;
        
        do {
            
            Object [] menu = {" ",
                    "Sales information",
                    "Individual sales information",
                    "Products information",
                    "Individual products information",
                    "Total price per sale",
                    "Individual total price per sale",
                    "Exit"};    
            
            option = (String) JOptionPane.showInputDialog(null, 
            "Select the option you want to use","Menu",JOptionPane.INFORMATION_MESSAGE, 
            null, menu, menu[0]);  
   
            switch (option) {

                case "Sales information": 
                    showDataSales();
                    break;

                case "Individual sales information": 
                    idSale = JOptionPane.showInputDialog("Write sale id: ");                            
                    individualSale(idSale);
                    break;

                case "Products information": 
                    idSale = JOptionPane.showInputDialog("Write sale id: ");
                    showDataProducts(idSale);
                    break;
                
                case "Individual products information": 
                    idSale = JOptionPane.showInputDialog("Write sale id: ");
                    idProduct = JOptionPane.showInputDialog("Write product id: ");
                    individualProduct(idSale,idProduct);
                    break;

                case "Total price per sale": 
                    showTotalPrice();
                    break;

                case "Individual total price per sale":
                    idSale = JOptionPane.showInputDialog("Write sale id: ");
                    individualPriceSale(idSale);
                    break;
                    
                case "Exit": 
                    break;
            }
            
        } while(!"Exit".equals(option)); 
    }
    
    public static void insertData(){
        Venta venta1 = new Venta("1","Abarrotes Maricela","01/06/2020");
        venta1.addProduct("1","Sabritas",15);
        venta1.addProduct("2","Chetos",10);
        venta1.addProduct("2","Coca cola",10);
        venta1.addProduct("4","Pepsi",26);
        venta1.addProduct("5", "Sabritas", 15);
        
        Venta venta2 = new Venta("2", "24x","31/05/2020");
        venta2.addProduct("34","Coca cola",26);
        venta2.addProduct("1","Sabritas",15);
        venta2.addProduct("2","Chetos",10);
        
        Venta venta3 = new Venta("3","Fasti","15/02/2020");
        venta3.addProduct("42","Agua bonafont",20);
        venta3.addProduct("78","Nescafé",80);
        venta3.addProduct("332","Coca cola",26);
        venta3.addProduct("321","Four Loko",30);
        venta3.addProduct("789","Paketaxo",35); 
        venta3.addProduct("24","Nesquik",15);
        
        empresa.addSale(venta1);
        empresa.addSale(venta2);
        empresa.addSale(venta3);
    }
    
    //The method print all the sales and their information
    public static void showDataSales() {
        //System.out.println("\tCompany sales");
        empresa.printSales();
    }
    
    //The method print all the total sales price and their information
    public static void showTotalPrice(){
        for (int i=0;i<empresa.getPlace();i++){
            JOptionPane.showMessageDialog(null, 
                    "ID venta: "+empresa.getVentas()[i].getId()+
                    "\nPrecio total: "+empresa.getVentas()[i].totalToPay(), 
                    "Price per sale", JOptionPane.UNDEFINED_CONDITION);
        }
    }
    
    //The method print all the products in all the sales and show all the information 
    public static void showDataProducts(String id){
        for (int i=0;i<empresa.getPlace();i++){
            if (id.equals(empresa.getVentas()[i].getId())){
                empresa.getVentas()[i].printProducts();
            } 
        }
    }
    
    //The method shows a specific sale
    public static void individualSale(String id){
        empresa.searchSales(id);
    }
            
    //The method shows a specific product 
    public static void individualProduct(String idS, String idP){
        
        for (int i=0;i<empresa.getPlace();i++){
            if (idS.equals(empresa.getVentas()[i].getId())){
                empresa.getVentas()[i].searchProduct(idP);
            } 
        }
    }
    
    //The method shows a specific total sale price
    public static void individualPriceSale(String id){
        JOptionPane.showMessageDialog(null, "Individual total price from sale "+id
                +"\nTotal price sale: "+empresa.individualTotalPay(id));
    }
    
}
