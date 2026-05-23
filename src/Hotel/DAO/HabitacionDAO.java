package Hotel.DAO;

import Hotel.DTO.Habitacion;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class HabitacionDAO {

    private static final String rutaarchivo = "src/archivos/habitacion.txt";

    public boolean guardarHabitacion(Habitacion h) {

        List<Habitacion> lista = leerHabitaciones();

        // VALIDAR NÚMERO ÚNICO
        for (Habitacion hab : lista) {
            if (hab.getNumeroHabitacion() == h.getNumeroHabitacion()) {
                System.out.println("Numero de habitación ya existe");
                return false;
            }
        }

        lista.add(h);
        escribirHabitaciones(lista);
        return true;
    }

    public List<Habitacion> leerHabitaciones() {

        List<Habitacion> lista = new ArrayList<>();

        File archivo = new File(rutaarchivo);

        if (!archivo.exists()) {
            return lista;
        }

        try (ObjectInputStream ois =
                 new ObjectInputStream(new FileInputStream(archivo))) {

            lista = (List<Habitacion>) ois.readObject();

        } catch (Exception e) {
            
        }

        return lista;
    }

    public void escribirHabitaciones(List<Habitacion> lista) {

        try (ObjectOutputStream oos =
                 new ObjectOutputStream(new FileOutputStream(rutaarchivo))) {

            oos.writeObject(lista);

        } catch (Exception e) {
            System.out.println("Ocurrio un error");
        }
    }
}