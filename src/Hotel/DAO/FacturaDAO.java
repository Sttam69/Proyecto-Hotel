
package Hotel.DAO;

import Hotel.DTO.Factura;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class FacturaDAO {
    
    private final String rutaArc = "src/archivos/factura.txt";
    
    public boolean registrar(Factura nuevaFactura) {
        List<Factura> lista = listar();

        for (Factura f : lista) {
            if (f.getNumeroFacturas().equals(nuevaFactura.getNumeroFacturas())) {
                System.out.println("Error: Ya existe una factura con ese número.");
                return false;
            }
        }

        lista.add(nuevaFactura);
        return guardarLista(lista);
    }
    
    public List<Factura> listar() {
        List<Factura> lista = new ArrayList<>();
        File archivo = new File(rutaArc);

        if (!archivo.exists()) {
            return lista;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
            lista = (List<Factura>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error al leer facturas: " + e.getMessage());
        }
        return lista;
    }
    
    private boolean guardarLista(List<Factura> lista) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(rutaArc))) {
            oos.writeObject(lista);
            return true;
        } catch (IOException e) {
            System.err.println("Error al guardar factura: " + e.getMessage());
            return false;
        }
    }
    
    public boolean eliminar(String numFactura) {
        List<Factura> lista = listar();
        boolean encontrado = lista.removeIf(f -> f.getNumeroFacturas().equals(numFactura));

        if (encontrado) {
            return guardarLista(lista);
        }
        return false;
    }
}
