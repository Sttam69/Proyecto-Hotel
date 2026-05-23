package Hotel.DAO;

import Hotel.DTO.Empleado;
import java.io.*;
import java.util.ArrayList;

public class EmpleadoDAO {
    private final String rutaArchivo = "src/archivos/empleados.txt";


    public void guardarLista(ArrayList<Empleado> lista) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(rutaArchivo))) {
            oos.writeObject(lista);
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo binario: " + e.getMessage());
        }
    }

    public ArrayList<Empleado> leerTodos() {
        ArrayList<Empleado> lista = new ArrayList<>();
        File file = new File(rutaArchivo);
        
        if (!file.exists()) {
            return lista;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(rutaArchivo))) {
            lista = (ArrayList<Empleado>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error al leer el archivo binario: " + e.getMessage());
        }
        return lista;
    }

    public boolean existeEmpleado(String cedula) {
        ArrayList<Empleado> lista = leerTodos();
        for (Empleado e : lista) {
            if (e.getCedula().equals(cedula)) {
                return true; 
            }
        }
        return false;
    }
}
