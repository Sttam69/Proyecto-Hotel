package Hotel.DTO;

import java.io.Serializable;
import java.util.Scanner;

public class Habitacion implements Serializable {

    private int numHabitacion;
    private double precioxnoche;
    private String estado;
    private int piso;
    private String tipoHabitacion;
    

    public Habitacion() {
    }

    public Habitacion(int numH, double pxc, int pi, String est, String th) {
        this.numHabitacion = numH;
        this.precioxnoche = pxc;
        this.piso = pi;
        this.estado = est;
        this.tipoHabitacion = th;
    }

    public int getNumeroHabitacion() {
        return numHabitacion;
    }

    public void setNumeroHabitacion(int nh) {
        this.numHabitacion = nh;
    }

    public double getPrecioxNoche() {
        return precioxnoche;
    }

    public void setPrecioxNoche(double pxn) {
        this.precioxnoche = pxn;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String est) {
        this.estado = est;
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int p) {
        this.piso = p;
    }

    public String getTiposHabitacion() {
        return tipoHabitacion;
    }

    public void setTiposHabitaciones(String th) {
        this.tipoHabitacion = th;
    }

    public void ingresarDatos() {
        Scanner sc = new Scanner(System.in);
        System.out.print("El numero de habitacion es: ");
        this.numHabitacion = sc.nextInt();
        System.out.print("El precio de habitacion por noche es: ");
        this.precioxnoche = sc.nextDouble();
        sc.nextLine();
        System.out.print("El estado de la habitacion es (Disponible/Ocupada): ");
        this.estado = sc.nextLine();
        System.out.print("El numero de piso es: ");
        this.piso = sc.nextInt();
        sc.nextLine();
        System.out.print("El tipo de la habitacion es: ");
        this.tipoHabitacion = sc.nextLine();
    }

    public void mostrarDatos() {
        System.out.println("Habitacion No: " + this.numHabitacion);
        System.out.println("Precio Noche: $" + this.precioxnoche);
        System.out.println("Estado: " + this.estado);
        System.out.println("Piso: " + this.piso);
        System.out.println("Tipo: " + this.tipoHabitacion);
    }

    public void aplicarDescuento() {
        double descuento = 0.10;
        double montoDescuento = precioxnoche * descuento;
        precioxnoche -= montoDescuento;
        System.out.println("Se aplico un descuento del 10%.");
        System.out.println("El precio con descuento es: " + precioxnoche);
    }
    
    @Override
    public String toString() {
        return "Hab " + numHabitacion + " (" + tipoHabitacion + ") - $" + precioxnoche;
    }
}
