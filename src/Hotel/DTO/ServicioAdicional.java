package Hotel.DTO;

import java.io.Serializable;

public class ServicioAdicional implements Serializable {

    private String codigoServicio;
    private String nombre;
    private String categoria;
    private double precio;
    private String descripcion;

    public ServicioAdicional() {
    }

    public ServicioAdicional(String codigoServicio, String nombre, String categoria, double precio, String descripcion) {
        this.codigoServicio = codigoServicio;
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
        this.descripcion = descripcion;
    }

    public String getCodigoServicio() {
        return codigoServicio;
    }

    public void setCodigoServicio(String codigoServicio) {
        this.codigoServicio = codigoServicio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return nombre + " (" + categoria + ") - $" + precio;
    }
}
