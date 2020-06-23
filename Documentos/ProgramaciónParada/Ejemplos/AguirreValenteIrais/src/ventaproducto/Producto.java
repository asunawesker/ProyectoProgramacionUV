package ventaproducto;

/**
 *
 * @author asunawesker
 */
public class Producto {
    private String nombre, id;
    private float precio;
    
    //Empty constructor
    public Producto() {   
    }
    
    //Constructor with all atributes 
    public Producto(String id, String nombre, float precio) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }
       
}
