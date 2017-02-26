package pe.com.gmd.appeasyshopping.Entidades;

/**
 * Created by ASUS on 19/02/2017.
 */

public class Categoria {
    private String nombreCat;
    private String cantSubCat;
    private String cantProductos;
    private int drawableImageID;

    public Categoria(String nombreCat, String cantSubCat, String cantProductos, int drawableImageID) {
        this.nombreCat = nombreCat;
        this.cantSubCat = cantSubCat;
        this.cantProductos = cantProductos;
        this.drawableImageID = drawableImageID;
    }

    public String getNombreCat() {
        return nombreCat;
    }

    public void setNombreCat(String nombreCat) {
        this.nombreCat = nombreCat;
    }

    public String getCantSubCat() {
        return cantSubCat;
    }

    public void setCantSubCat(String cantSubCat) {
        this.cantSubCat = cantSubCat;
    }

    public String getCantProductos() {
        return cantProductos;
    }

    public void setCantProductos(String cantProductos) {
        this.cantProductos = cantProductos;
    }

    public int getDrawableImageID() {
        return drawableImageID;
    }

    public void setDrawableImageID(int drawableImageID) {
        this.drawableImageID = drawableImageID;
    }

}
