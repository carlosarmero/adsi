
package Modelo;

public class Producto {
   //inventario
   private int sku;
   private String nombre;
   private int precio;
   private int cantidad;
   private String fecha;   
  //proveedores
   private int ID;
   private String nombrepro;
   private String productos;
   private String telefono;
   private String NIT;
   //pedidos
   private int Idpe;
   private String nombreped;
   private int precioped;
   private int cantidadped;
   private String fechaen;   
   private int IDpro;
    
   private String usu;
   private String pass;

    public String getUsu() {
        return usu;
    }

    public void setUsu(String usu) {
        this.usu = usu;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
   
    public int getSku() {
        return sku;
    }

    public void setSku(int sku) {
        this.sku = sku;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNombrepro() {
        return nombrepro;
    }

    public void setNombrepro(String nombrepro) {
        this.nombrepro = nombrepro;
    }

    public String getProductos() {
        return productos;
    }

    public void setProductos(String productos) {
        this.productos = productos;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNIT() {
        return NIT;
    }

    public void setNIT(String NIT) {
        this.NIT = NIT;
    }

    public int getIdpe() {
        return Idpe;
    }

    public void setIdpe(int Idpe) {
        this.Idpe = Idpe;
    }

    public String getNombreped() {
        return nombreped;
    }

    public void setNombreped(String nombreped) {
        this.nombreped = nombreped;
    }

    public int getPrecioped() {
        return precioped;
    }

    public void setPrecioped(int precioped) {
        this.precioped = precioped;
    }

    public int getCantidadped() {
        return cantidadped;
    }

    public void setCantidadped(int cantidadped) {
        this.cantidadped = cantidadped;
    }

    public String getFechaen() {
        return fechaen;
    }

    public void setFechaen(String fechaen) {
        this.fechaen = fechaen;
    }

    public int getIDpro() {
        return IDpro;
    }

    public void setIDpro(int IDpro) {
        this.IDpro = IDpro;
    }
    
    
    
    
    
}
