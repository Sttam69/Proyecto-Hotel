package Hotel.DAO;

import Hotel.DTO.ServicioAdicional;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ServicioAdicionalDAO {

    String ruta = "src/archivos/servicios.txt";

    public String escribir(ArrayList<ServicioAdicional> lista) {
        String mensaje;
        try (FileOutputStream fos = new FileOutputStream(ruta); ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            oos.writeObject(lista);
            mensaje = "Servicio guardado exitosamente";
        } catch (IOException ioe) {
            System.out.println("Error al escribir el servicio " + ioe.getMessage());
            mensaje = "No se guardo correctamente";
        }
        return mensaje;
    }

    public ArrayList<ServicioAdicional> leer() {
        ArrayList<ServicioAdicional> lista = new ArrayList<>();
        File file = new File(ruta);
        if (!file.exists()) {
            return lista;
        }
        try (FileInputStream fis = new FileInputStream(ruta); ObjectInputStream ois = new ObjectInputStream(fis)) {
            lista = (ArrayList<ServicioAdicional>) ois.readObject();
        } catch (IOException ioe) {
            System.out.println("Error en leer servicio " + ioe.getMessage());
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Error en leer servicio " + cnfe.getMessage());
        }
        return lista;
    }

    public String guardar(ServicioAdicional servicio) {
        ArrayList<ServicioAdicional> lista = leer();

        for (ServicioAdicional s : lista) {
            if (s.getCodigoServicio().equals(servicio.getCodigoServicio())) {
                System.out.println("El servicio ya existe");
                return "Error: Ya existe un servicio con el código " + servicio.getCodigoServicio();
            }
        }

        lista.add(servicio);
        String mensaje = escribir(lista);
        return mensaje;
    }

    public String eliminar(String codigo) {
        ArrayList<ServicioAdicional> lista = leer();
        boolean encontrado = false;
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getCodigoServicio().equals(codigo)) {
                lista.remove(i);
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            return "No existe el servicio a eliminar";
        } else {
            escribir(lista);
            return "El servicio ya ha sido eliminado exitosamente";
        }
    }

    public ArrayList<ServicioAdicional> buscar(String dato) {
        ArrayList<ServicioAdicional> listaEncontrados = new ArrayList<>();
        ArrayList<ServicioAdicional> listaExistentes = leer();

        if (dato.isEmpty()) {
            return listaExistentes;
        }

        for (ServicioAdicional s : listaExistentes) {
            if (s.getNombre().toLowerCase().contains(dato.toLowerCase())) {
                listaEncontrados.add(s);
            }
        }
        return listaEncontrados;
    }
}
