package Hotel.DAO;

import Hotel.DTO.Cliente;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    private static final String RUTA_ARCHIVO = "src/archivos/clientes.txt";

    public boolean registrar(Cliente nuevoCliente) {
        List<Cliente> lista = listar();

        for (Cliente c : lista) {
            if (c.getCedula().equals(nuevoCliente.getCedula())) {
                System.out.println("Error: Ya existe un cliente con esa cédula.");
                return false;
            }
        }

        lista.add(nuevoCliente);
        return guardarLista(lista);
    }

    public List<Cliente> listar() {
        List<Cliente> lista = new ArrayList<>();
        File archivo = new File(RUTA_ARCHIVO);

        if (!archivo.exists()) {
            return lista;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {

            lista = (ArrayList<Cliente>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return lista;
    }

    public boolean eliminar(String cedula) {
        List<Cliente> lista = listar();
        boolean encontrado = false;

        encontrado = lista.removeIf(c -> c.getCedula().equals(cedula));

        if (encontrado) {
            return guardarLista(lista);
        }
        return false;
    }

    private boolean guardarLista(List<Cliente> lista) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(RUTA_ARCHIVO))) {
            oos.writeObject(lista);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Cliente buscarPorCedula(String cedula) {
        List<Cliente> lista = listar();
        for (Cliente c : lista) {
            if (c.getCedula().equals(cedula)) {
                return c;
            }
        }
        return null;
    }

    public boolean actualizar(Cliente clienteEditado) {
        List<Cliente> lista = listar();
        boolean encontrado = false;

        for (int i = 0; i < lista.size(); i++) {

            if (lista.get(i).getCedula().equals(clienteEditado.getCedula())) {
                lista.set(i, clienteEditado);
                encontrado = true;
                break;
            }
        }

        if (encontrado) {
            return guardarLista(lista);
        }
        return false;
    }
}
