package Data;

import Modelo.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GestorArchivo {

    private List<Cliente> clientes;
    private final String archivoClientes = "csvs/clientes.csv";

    public GestorArchivo() {
        this.clientes = new ArrayList<>();
        cargarClientes();
    }

// ------------------------------Clientes----------------------------------

    public void registrarCliente(Cliente cliente) {
        if (!emailExiste(cliente.getCorreo())) {
            clientes.add(cliente);
            guardarCliente(cliente);
            System.out.println("Cliente registrado exitosamente.");
        } else {
            System.out.println("El email ya esta registrado.");
        }
    }

    public Cliente login(String correo) {
        for (Cliente c : clientes) {
            if (c.getCorreo().equalsIgnoreCase(correo)) {
                System.out.println("Login exitoso. Bienvenido/a " + c.getNombre());
                return c;
            }
        }
        System.out.println("Email no encontrado. Por favor registrese.");
        return null;
    }

    private boolean emailExiste(String email) {
        return clientes.stream().anyMatch(c -> c.getCorreo().equalsIgnoreCase(email));
    }

    public static void guardarCliente(Cliente cliente) {
        try (FileWriter fw = new FileWriter("csvs/clientes.csv", true)) {
            fw.write(cliente.getNombre() + "," + cliente.getApellido() + "," + cliente.getCorreo() + ","
                    + cliente.getTelefono() + "," + cliente.getEstadoCivil() + "," + cliente.getCiudad() + "\n");
        } catch (IOException e) {
            System.out.println("Error al guardar cliente: " + e.getMessage());
        }
    }
private void cargarClientes() {
    File archivo = new File(archivoClientes);
    if (!archivo.exists()) return;

    try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
        String linea;
        while ((linea = br.readLine()) != null) {
            String[] datos = linea.split(",");
            if (datos.length == 6) {
                Cliente c = new Cliente(datos[0], datos[1], datos[2], datos[3], datos[4], datos[5]);
                clientes.add(c);
            }
        }
    } catch (IOException e) {
        System.out.println("Error al cargar clientes: " + e.getMessage());
    }
}

    public List<Cliente> obtenerClientes() {
        return clientes;
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