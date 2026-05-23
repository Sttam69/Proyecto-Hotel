package Hotel.DTO;

import java.io.Serializable;

public class Cliente extends Persona implements Serializable {

 
    private String codigoCliente;
    private String nacionalidad;
    private boolean esVip;
    private String metodoPago;
    private int puntosFidelidad;

  
    public Cliente() {
        super(); 
    }

   
    public Cliente(String cedula, String nombre, String apellido, String telefono, String correo,
                   String codigoCliente, String nacionalidad, boolean esVip, String metodoPago) {
        
        
        super(cedula, nombre, apellido, telefono, correo);
        
        
        this.codigoCliente = codigoCliente;
        this.nacionalidad = nacionalidad;
        this.esVip = esVip;
        this.metodoPago = metodoPago;
        this.puntosFidelidad = 0; 
    }

   
    public String getCodigoCliente() { return codigoCliente; }
    public void setCodigoCliente(String codigoCliente) { this.codigoCliente = codigoCliente; }

    public String getNacionalidad() { return nacionalidad; }
    public void setNacionalidad(String nacionalidad) { this.nacionalidad = nacionalidad; }

    public boolean isEsVip() { return esVip; }
    public void setEsVip(boolean esVip) { this.esVip = esVip; }

    public String getMetodoPago() { return metodoPago; }
    public void setMetodoPago(String metodoPago) { this.metodoPago = metodoPago; }

    public int getPuntosFidelidad() { return puntosFidelidad; }
    public void setPuntosFidelidad(int puntosFidelidad) { this.puntosFidelidad = puntosFidelidad; }
    
  
    @Override
    public String toString() {
        return getNombre() + " " + getApellido() + " (" + cedula + ")";
    }
}