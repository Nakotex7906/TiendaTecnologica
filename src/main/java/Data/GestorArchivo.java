package Data;

import Modelo.*;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class GestorArchivo {

    public static void guardarCliente(Cliente cliente) {
        try(FileWriter fw = new FileWriter("clientes.csv",true)) {
            fw.write(cliente.getNombre() + "," + cliente.getApellido() + "," + cliente.getCorreo() + "," +
                    cliente.getTelefono() + "," + cliente.getEstadoCivil() + "," + cliente.getCiudad() + "\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void guardarComputador(CompuEscritorio pc){
        try (FileWriter fw = new FileWriter("computadores.csv",true)) {
            fw.write( pc.getMarca() + "," + pc.getMemoriaRAM() + "," + pc.getProcesador() + "," +
                    pc.getMemoriaAlmacenamiento() + "," + pc.getModelo() + "," + pc.getAnioP() + "," + pc.getPrecio()
                    + "," + pc.getStock() + "," + pc.getTarjetaDeVideo() + "," + pc.getFuenteDePoder() + ","
                    + pc.getGabinete() + "," + pc.getPantalla() + "\n");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void guardarNotebook(Notebook notebook) {
        try (FileWriter fw = new FileWriter("notebooks.csv",true)) {
            fw.write( notebook.getMarca() + "," + notebook.getMemoriaRAM() + "," +
                    notebook.getProcesador() + "," + notebook.getModelo() + "," + notebook.getAnioP() + "," +
                    notebook.getPrecio() + "," + notebook.getStock() + "," + notebook.getResolucionPantalla() + "," +
                    notebook.getTipoTeclado() + "," + notebook.getBateriaMah()  + "\n");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void guardarTablet(Tablet tablet) {
        try (FileWriter fw = new FileWriter("tablets.csv",true)) {
            fw.write( tablet.getMarca() + "," + tablet.getMemoriaRAM() + "," +
                    tablet.getProcesador() + "," + tablet.getModelo() + "," + tablet.getAnioP() + "," +
                    tablet.getPrecio() + "," + tablet.getStock() + "," + tablet.getResolucionPantalla() + "," +
                    Arrays.toString(tablet.getAccesorios()) + "\n");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // Cambia la direccion de la tienda
    public static void guardarDireccion(String direccion) {
        try (FileWriter fileWriter = new FileWriter("tienda.csv")) {
            fileWriter.write(direccion);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

}