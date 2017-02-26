package pe.com.gmd.appeasyshopping.Entidades;

/**
 * Created by Cecilia on  20/02/2017.
 */

public class Producto {

    private String nombre;

    private String precio;
    private int drawableImageID;
    private String cantidad;

    public Producto(String nombre, String precio, String cantidad,  int drawableImageID) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        this.drawableImageID = drawableImageID;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public int getDrawableImageID() {
        return drawableImageID;
    }

    public void setDrawableImageID(int drawableImageID) {
        this.drawableImageID = drawableImageID;
    }

}
