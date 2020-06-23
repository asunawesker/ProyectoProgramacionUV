package ventaproducto;

import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author asunawesker
 */
public class Main {
    static Empresa empresa = new Empresa("Abarrotes Unidos");
    static Catalogo catalogo = new Catalogo();
    static String option;
    static Scanner entrada = new Scanner(System.in);
    
    public static void main(String[] args) {
        
        globalMenu();
                        
    }
    
    public static void globalMenu() {
        
        
        do {
            
            Object [] menu = {" ",
                    "Sale",
                    "Catalogue",
                    "Products",
                    "Clients",
                    "Exit"};    
            
            option = (String) JOptionPane.showInputDialog(null, 
            "Select the option you want to use","Menu",JOptionPane.INFORMATION_MESSAGE, 
            null, menu, menu[0]);  
   
            switch (option) {

                case "Sale": 
                    menuSale();
                    break;

                case "Catalogue": 
                    menuCatalogue();
                    break;

                case "Products": 
                    menuProducts();
                    break;
                    
                case "Clients":
                    break;
                    
                case "Exit": 
                    break;
            }
            
        } while(!"Exit".equals(option)); 
    }
    
    public static void menuSale(){
        
        Object [] menuSale = {" ",
                    "Sell products",
                    "Search sale",
                    "Exit"};
        
        option = (String) JOptionPane.showInputDialog(null, 
            "Select the option you want to use","Menu",JOptionPane.INFORMATION_MESSAGE, 
            null, menuSale, menuSale[0]); 
        
        
        switch(option) {
            
            case "Sell products": 
                empresa.addSale();
                break;
                
            case "Search sale":
                empresa.searchSale();
                break;
                
            case "Exit":
                break;
        } 
    }
    
    public static void menuProducts(){
        Object [] menuProducts = {" ",
                    "Add product",
                    "Search product",
                    "Exit"};
        
        option = (String) JOptionPane.showInputDialog(null, 
            "Select the option you want to use","Menu",JOptionPane.INFORMATION_MESSAGE, 
            null, menuProducts, menuProducts[0]);
        
        switch(option) {
            case "Add product":
                break;
            case "Search product":
                break;
            case "Exit":
                break;
        } 
    }
    
    public static void menuCatalogue(){
         Object [] menuProducts = {" ",
                "Add product",
                "Show products",
                "Exit"};
        
        option = (String) JOptionPane.showInputDialog(null, 
            "Select the option you want to use","Menu",JOptionPane.INFORMATION_MESSAGE, 
            null, menuProducts, menuProducts[0]);
        
        switch(option) {
            case "Add product":
                
                do {
                    
                    empresa.addProductsToCatalog();
                    
                    System.out.println("Do you want to add another product? (S/N)");
                    option = entrada.next();
                    
                    switch(option){
                        case "S":
                            empresa.addProductsToCatalog();
                    
                        System.out.println("Do you want to add another product? (S/N)");
                        option = entrada.next();
                            break;
                        
                        case "N":
                            break;
                    }
                    
                } while(!option.equals("N"));
                
                break;
            case "Show products":
                
                break;
            case "Exit":
                break;
        } 
    }
    
    public static void menuClients(){
        Object [] menuClient = {" ",
                    "Add client",
                    "Search client",
                    "Exit"};
        
        option = (String) JOptionPane.showInputDialog(null, 
            "Select the option you want to use","Menu",JOptionPane.INFORMATION_MESSAGE, 
            null, menuClient, menuClient[0]);
        
        switch(option) {
            case "Add client":
                
                break;
            case "Search client":
                
                break;
            case "Exit":
                break;
        } 
    }

}
