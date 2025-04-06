import Data.GestorArchivo;
import Modelo.*;

import java.util.*;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Cliente> clientes = new ArrayList<>();
    private static final List<CompuEscritorio> computadores = new ArrayList<>();
    private static final List<Notebook> notebooks = new ArrayList<>();
    private static final List<Tablet> tablets = new ArrayList<>();

    public static void main(String[] args) {
        cargarProductosEjemplo();

        boolean salir = false;
        while (!salir) {
            System.out.println("\n MENÚ PRINCIPAL:");
            System.out.println("1. Registrar cliente");
            System.out.println("2. Ver productos disponibles");
            System.out.println("3. Realizar compra");
            System.out.println("4. Salir");
            System.out.print("Selecciona una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1 -> registrarCliente();
                case 2 -> mostrarProductos();
                case 3 -> realizarCompra();
                case 4 -> salir = true;
                default -> System.out.println("Opción no válida.");
            }
        }
    }

    private static void cargarProductosEjemplo() {
        computadores.add(new CompuEscritorio("HP", "16GB", "1TB", "Intel i7", "Pavilion", 2022, 800000, 5, "NVIDIA GTX 1660", "600W", "ATX", new Pantalla("HP", "24m", 2022)));
        computadores.add(new CompuEscritorio("Dell", "32GB", "2TB", "AMD Ryzen 7", "G5", 2023, 950000, 3, "RTX 3060", "700W", "Mid Tower", new Pantalla("Dell", "S2721", 2023)));

        notebooks.add(new Notebook("Lenovo", "16GB", "512GB SSD", "Intel i5", "ThinkPad X1", 2021, 750000, 4, "1920x1080", "Retroiluminado", 6000));
        notebooks.add(new Notebook("ASUS", "8GB", "256GB SSD", "Intel i3", "VivoBook", 2020, 500000, 6, "1366x768", "Normal", 5000));

        tablets.add(new Tablet("Samsung", "4GB", "64GB", "Exynos", "Galaxy Tab A7", 2021, 300000, 10, "2000x1200", new String[]{"Cargador", "Funda"}));
        tablets.add(new Tablet("Apple", "6GB", "128GB", "A14 Bionic", "iPad Air", 2022, 700000, 7, "2360x1640", new String[]{"Cable USB-C"}));
    }
    private static void registrarCliente() {
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Apellido: ");
        String apellido = scanner.nextLine();
        System.out.print("Correo: ");
        String correo = scanner.nextLine();
        System.out.print("Teléfono: ");
        String telefono = scanner.nextLine();
        System.out.print("Estado Civil: ");
        String estadoCivil = scanner.nextLine();
        System.out.print("Ciudad: ");
        String ciudad = scanner.nextLine();

        Cliente cliente = new Cliente(nombre, apellido, correo, telefono, estadoCivil, ciudad);
        clientes.add(cliente);
        GestorArchivo.guardarCliente(cliente);
        System.out.println("Cliente registrado correctamente.");
    }

    private static void mostrarProductos() {
        System.out.println("\n Computadores de escritorio:");
        for (CompuEscritorio pc : computadores) {
            System.out.println(pc.getMarca() + " - " + pc.getModelo() + " - $" + pc.getPrecio());
        }

        System.out.println("\n Notebooks:");
        for (Notebook nb : notebooks) {
            System.out.println(nb.getMarca() + " - " + nb.getModelo() + " - $" + nb.getPrecio());
        }

        System.out.println("\n Tablets:");
        for (Tablet t : tablets) {
            System.out.println(t.getMarca() + " - " + t.getModelo() + " - $" + t.getPrecio());
        }
    }

    private static void realizarCompra() {
        System.out.print("Correo del cliente: ");
        String correo = scanner.nextLine();
        Cliente cliente = clientes.stream().filter(c -> c.getCorreo().equalsIgnoreCase(correo)).findFirst().orElse(null);

        if (cliente == null) {
            System.out.println("Cliente no encontrado. Debe registrarse primero.");
            return;
        }

        List<DispositivoTecnologico> carrito = new ArrayList<>();
        mostrarProductos();

        System.out.println("\nIngrese tipo (pc/notebook/tablet) y modelo a comprar (o 'fin' para terminar):");
        while (true) {
            System.out.print("Tipo: ");
            String tipo = scanner.nextLine();
            if (tipo.equalsIgnoreCase("fin")) break;

            System.out.print("Modelo: ");
            String modelo = scanner.nextLine();

            DispositivoTecnologico encontrado = null;

            switch (tipo.toLowerCase()) {
                case "pc" -> encontrado = computadores.stream().filter(d -> d.getModelo().equalsIgnoreCase(modelo)).findFirst().orElse(null);
                case "notebook" -> encontrado = notebooks.stream().filter(d -> d.getModelo().equalsIgnoreCase(modelo)).findFirst().orElse(null);
                case "tablet" -> encontrado = tablets.stream().filter(d -> d.getModelo().equalsIgnoreCase(modelo)).findFirst().orElse(null);
            }

            if (encontrado != null) {
                carrito.add(encontrado);
                System.out.println(" Agregado al carrito.");
            } else {
                System.out.println(" Producto no encontrado.");
            }
        }

        if (!carrito.isEmpty()) {
            Venta venta = new Venta(cliente, carrito);
            GestorArchivo.guardarVenta(venta);
            System.out.println("Compra realizada con exito.");
        } else {
            System.out.println("Carrito vacio. No se realizo la compra.");
        }
    }
}
