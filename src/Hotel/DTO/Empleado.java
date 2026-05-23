package Hotel.DTO;

import java.io.Serializable;


public class Empleado extends Persona implements Serializable {
    
    
    private String cargo;
    private String turno;
    private double sueldo;


    public Empleado() {
        super();
    }


    public Empleado(String cedula, String nombre, String apellido, String telefono, String correo, 
                    String cargo, String turno, double sueldo) {

        super(cedula, nombre, apellido, telefono, correo);
        this.cargo = cargo;
        this.turno = turno;
        this.sueldo = sueldo;
    }

    public String getCargo() { return cargo; }
    public void setCargo(String cargo) { this.cargo = cargo; }

    public String getTurno() { return turno; }
    public void setTurno(String turno) { this.turno = turno; }

    public double getSueldo() { return sueldo; }
    public void setSueldo(double sueldo) { this.sueldo = sueldo; }
    
    @Override
    public String toString() {
        return super.getNombre() + " " + super.getApellido() + " (" + cargo + ")";
    }
}