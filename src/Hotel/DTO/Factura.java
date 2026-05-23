package Hotel.DTO;

import java.io.Serializable;
import java.util.ArrayList;

public class Factura implements Serializable {

    private String numFactura;
    private String fecha;
    private double totalP;
    private Cliente clienteAsociado;
    private Habitacion habitacionAsociada;
    private ArrayList<ServicioAdicional> listaServicios;
    private Empleado empleadoA;

    public Factura() {
        this.listaServicios = new ArrayList<>();
    }

    public Factura(String numFactura, String fecha, Cliente cliente, Habitacion habitacion, Empleado empleadoA) {
        this.numFactura = numFactura;
        this.fecha = fecha;
        this.clienteAsociado = cliente;
        this.habitacionAsociada = habitacion;
        this.listaServicios = new ArrayList<>();
        this.totalP = 0.0;
        this.empleadoA = empleadoA;
    }

    public String getNumeroFacturas() {
        return numFactura;
    }

    public String getFecha() {
        return fecha;
    }

    public double getPrecioTotal() {
        return totalP;
    }

    public Cliente getClienteAsociado() {
        return clienteAsociado;
    }

    public Habitacion getHabitacionesAsociadas() {
        return habitacionAsociada;
    }

    public ArrayList<ServicioAdicional> getServiceAdicional() {
        return listaServicios;
    }
    
    public Empleado getEmpleadoAsociado(){
        return empleadoA;
    }

    public void setNumeroFacturas(String nf) {
        this.numFactura = nf;
    }

    public void setFecha(String fc) {
        this.fecha = fc;
    }

    public void setPrecioTotal(double pt) {
        this.totalP = pt;
    }

    public void setClienteAsociado(Cliente ca) {
        this.clienteAsociado = ca;
    }

    public void setHabitacionesAsocionadas(Habitacion ha) {
        this.habitacionAsociada = ha;
    }

    public void setServiceAdicional(ArrayList<ServicioAdicional> sa) {
        this.listaServicios = sa;
    }
    
    public void setEmpleadoAsociado(Empleado empA){
        this.empleadoA = empA;
    }

    public void agregarServicio(ServicioAdicional servicio) {
        if (this.listaServicios == null) {
            this.listaServicios = new ArrayList<>();
        }
        this.listaServicios.add(servicio);
    }
    
    public void calcularTotal() {
        double suma = 0;
    
        if (habitacionAsociada != null) {
            suma += habitacionAsociada.getPrecioxNoche(); 
        }
            if (listaServicios != null) {
            for (ServicioAdicional serv : listaServicios) {
                suma += serv.getPrecio(); 
            }
        }
        this.totalP = suma;
    }
    
    @Override
    public String toString() {
        return numFactura + " - " + (clienteAsociado != null ? clienteAsociado.getNombre() : "S/C");
    }
}
