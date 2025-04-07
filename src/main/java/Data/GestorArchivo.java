package Data;

import Modelo.*;
import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GestorArchivo {

    private List<Cliente> clientes;
    private final String archivoClientes = "csvs/clientes.csv";

// ------------------------------Clientes----------------------------------

    public static void guardarCliente(Cliente cliente) {
        try (FileWriter fw = new FileWriter("csvs/clientes.csv", true)) {
            fw.write(cliente.getNombre() + "," + cliente.getApellido() + "," + cliente.getCorreo() + ","
                    + cliente.getTelefono() + "," + cliente.getEstadoCivil() + "," + cliente.getCiudad() + "\n");
        } catch (IOException e) {
            System.out.println("Error al guardar cliente: " + e.getMessage());
        }
    }

//----------------------Dispostivos------------------------------

    public static void guardarComputador(CompuEscritorio pc){
        try (FileWriter fw = new FileWriter("csvs/computadores.csv",true)) {
            fw.write( pc.getMarca() + "," + pc.getMemoriaRAM() + "," + pc.getProcesador() + "," +
                    pc.getMemoriaAlmacenamiento() + "," + pc.getModelo() + "," + pc.getAnioP() + "," + pc.getPrecio()
                    + "," + pc.getStock() + "," + pc.getTarjetaDeVideo() + "," + pc.getFuenteDePoder() + ","
                    + pc.getGabinete() + "," + pc.getPantalla() + "\n");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void guardarNotebook(Notebook notebook) {
        try (FileWriter fw = new FileWriter("csvs/notebooks.csv",true)) {
            fw.write( notebook.getMarca() + "," + notebook.getMemoriaRAM() + "," +
                    notebook.getProcesador() + "," + notebook.getModelo() + "," + notebook.getAnioP() + "," +
                    notebook.getPrecio() + "," + notebook.getStock() + "," + notebook.getResolucionPantalla() + "," +
                    notebook.getTipoTeclado() + "," + notebook.getBateriaMah()  + "\n");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void guardarTablet(Tablet tablet) {
        try (FileWriter fw = new FileWriter("csvs/tablets.csv",true)) {
            fw.write( tablet.getMarca() + "," + tablet.getMemoriaRAM() + "," +
                    tablet.getProcesador() + "," + tablet.getModelo() + "," + tablet.getAnioP() + "," +
                    tablet.getPrecio() + "," + tablet.getStock() + "," + tablet.getResolucionPantalla() + "," +
                    Arrays.toString(tablet.getAccesorios()) + "\n");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //---------------------------Otros-------------------------------------

    // Cambia la direccion de la tienda
    public static void guardarDireccion(String direccion) {
        try (FileWriter fileWriter = new FileWriter("csvs/tienda.csv")) {
            fileWriter.write(direccion);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void guardarVenta(Venta venta) {
        try (FileWriter fileWriter = new FileWriter("csvs/ventas.csv",true)) {
            String correoCliente = venta.getCliente().getCorreo();
            String fecha = venta.getFecha().toString();

            // convertir la venta a un string
            String dispositivos = venta.getDispositivosComprados().stream().map(
                            d -> d.getTipo() + "-" + d.getMarca() + "-" + d.getModelo())
                    .collect(Collectors.joining(","));

            fileWriter.write(correoCliente + "," + fecha + "," + dispositivos + "\n");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}