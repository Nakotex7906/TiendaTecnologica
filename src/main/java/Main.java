import Data.GestorArchivo;
import Modelo.*;

import java.util.*;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Cliente> clientes = new ArrayList<>();
    private static final List<CompuEscritorio> computadores = new ArrayList<>();
    private static final List<Notebook> notebooks = new ArrayList<>();
    private static final List<Tablet> tablets = new ArrayList<>();
    private static final Tienda tienda = new Tienda();

    public static void main(String[] args) {
        cargarProductosEjemplo();

        boolean salir = false;
        while (!salir) {
            System.out.println("\n MENU PRINCIPAL:");
            System.out.println("1. Registrar cliente");
            System.out.println("2. Ver productos disponibles");
            System.out.println("3. Realizar compra");
            System.out.println("4. Buscar producto por criterio");
            System.out.println("5. Crear nuevo producto");
            System.out.println("6. Cambiar direccion de tienda");
            System.out.println("7. Salir");
            System.out.print("Selecciona una opcion: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1 -> registrarCliente();
                case 2 -> mostrarProductos();
                case 3 -> realizarCompra();
                case 4 -> buscarProducto();
                case 5 -> crearProducto();
                case 6 -> cambiarDireccionTienda();
                case 7 -> salir = true;
                default -> System.out.println("Opcion no valida.");
            }
        }
    }

    private static void cargarProductosEjemplo() {
        CompuEscritorio pc1 = new CompuEscritorio("HP", "16GB", "1TB", "Intel i7", "Pavilion", 2022, 800000, 2, "NVIDIA GTX 1660", "600W", "ATX", new Pantalla("HP", "24m", 2022));
        CompuEscritorio pc2 = new CompuEscritorio("Dell", "32GB", "2TB", "AMD Ryzen 7", "G5", 2023, 950000, 3, "RTX 3060", "700W", "Mid Tower", new Pantalla("Dell", "S2721", 2023));
        computadores.add(pc1);
        computadores.add(pc2);
        tienda.agregarDispositivo(pc1);
        tienda.agregarDispositivo(pc2);

        Notebook nb1 = new Notebook("Lenovo", "16GB", "512GB SSD", "Intel i5", "ThinkPad X1", 2021, 750000, 4, "1920x1080", "Retroiluminado", 6000);
        Notebook nb2 = new Notebook("ASUS", "8GB", "256GB SSD", "Intel i3", "VivoBook", 2020, 500000, 6, "1366x768", "Normal", 5000);
        notebooks.add(nb1);
        notebooks.add(nb2);
        tienda.agregarDispositivo(nb1);
        tienda.agregarDispositivo(nb2);

        Tablet t1 = new Tablet("Samsung", "4GB", "64GB", "Exynos", "Galaxy Tab A7", 2021, 300000, 10, "2000x1200", new String[]{"Cargador", "Funda"});
        Tablet t2 = new Tablet("Apple", "6GB", "128GB", "A14 Bionic", "iPad Air", 2022, 700000, 7, "2360x1640", new String[]{"Cable USB-C"});
        tablets.add(t1);
        tablets.add(t2);
        tienda.agregarDispositivo(t1);
        tienda.agregarDispositivo(t2);
    }

    private static void cambiarDireccionTienda() {
        System.out.print("Ingrese la nueva direccion de la tienda: ");
        String nuevaDireccion = scanner.nextLine();
        tienda.setDireccion(nuevaDireccion);
        System.out.println("Direccion de la tienda actualizada a: " + tienda.getDireccion());
    }

    private static void registrarCliente() {
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Apellido: ");
        String apellido = scanner.nextLine();
        System.out.print("Correo: ");
        String correo = scanner.nextLine();
        System.out.print("Telefono: ");
        String telefono = scanner.nextLine();
        System.out.print("Estado Civil: ");
        String estadoCivil = scanner.nextLine();
        System.out.print("Ciudad: ");
        String ciudad = scanner.nextLine();

        Cliente cliente = new Cliente(nombre, apellido, correo, telefono, estadoCivil, ciudad);
        clientes.add(cliente);
        tienda.agregarCliente(cliente);
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
                case "pc" -> encontrado = computadores.stream().filter(d -> d.getModelo().equalsIgnoreCase(modelo) && d.getStock() > 0).findFirst().orElse(null);
                case "notebook" -> encontrado = notebooks.stream().filter(d -> d.getModelo().equalsIgnoreCase(modelo) && d.getStock() > 0).findFirst().orElse(null);
                case "tablet" -> encontrado = tablets.stream().filter(d -> d.getModelo().equalsIgnoreCase(modelo) && d.getStock() > 0).findFirst().orElse(null);
            }

            if (encontrado != null) {
                encontrado.reducirStock();
                carrito.add(encontrado);
                System.out.println(" Agregado al carrito, stock restante: " + encontrado.getStock());
            } else {
                System.out.println(" Producto no encontrado o sin stock.");
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

    private static void buscarProducto() {
        System.out.print("Buscar por (marca/modelo/tipo): ");
        String criterio = scanner.nextLine();

        System.out.print("Ingrese valor de búsqueda: ");
        String valor = scanner.nextLine();

        List<DispositivoTecnologico> resultado = new ArrayList<>();

        switch (criterio.toLowerCase()) {
            case "marca":
                resultado = tienda.buscarPorMarca(valor);
                break;
            case "modelo":
                resultado = tienda.buscarPorModelo(valor);
                break;
            case "tipo":
                resultado = tienda.buscarPorTipo(valor);
                break;
            default:
                System.out.println("Criterio no válido.");
                return;
        }

        if (resultado.isEmpty()) {
            System.out.println("No se encontraron productos con ese criterio.");
        } else {
            System.out.println("Productos encontrados:");
            for (DispositivoTecnologico d : resultado) {
                System.out.println(d.getTipo() + " - " + d.getMarca() + " - " + d.getModelo() + " - $" + d.getPrecio());
            }
        }
    }

    private static void crearProducto() {
        System.out.print("¿Qué tipo de producto deseas agregar? (pc/notebook/tablet): ");
        String tipo = scanner.nextLine().toLowerCase();

        System.out.print("Marca: ");
        String marca = scanner.nextLine();
        System.out.print("Memoria RAM: ");
        String ram = scanner.nextLine();
        System.out.print("Procesador: ");
        String procesador = scanner.nextLine();
        System.out.print("Modelo: ");
        String modelo = scanner.nextLine();
        System.out.print("Anio: ");
        int anio = Integer.parseInt(scanner.nextLine());
        System.out.print("Precio: ");
        int precio = Integer.parseInt(scanner.nextLine());
        System.out.print("Stock: ");
        int stock = Integer.parseInt(scanner.nextLine());

        switch (tipo) {
            case "pc" -> {
                System.out.print("Memoria de almacenamiento: ");
                String almacenamiento = scanner.nextLine();
                System.out.print("Tarjeta de video: ");
                String video = scanner.nextLine();
                System.out.print("Fuente de poder: ");
                String fuente = scanner.nextLine();
                System.out.print("Gabinete: ");
                String gabinete = scanner.nextLine();
                System.out.print("Marca pantalla: ");
                String marcaPantalla = scanner.nextLine();
                System.out.print("Modelo pantalla: ");
                String modeloPantalla = scanner.nextLine();
                System.out.print("Anio pantalla: ");
                int anioPantalla = Integer.parseInt(scanner.nextLine());

                Pantalla pantalla = new Pantalla(marcaPantalla, modeloPantalla, anioPantalla);
                CompuEscritorio pc = new CompuEscritorio(marca, ram, almacenamiento, procesador, modelo, anio, precio, stock, video, fuente, gabinete, pantalla);
                computadores.add(pc);
                tienda.agregarDispositivo(pc);
                GestorArchivo.guardarComputador(pc);
            }

            case "notebook" -> {
                System.out.print("Almacenamiento: ");
                String almacenamiento = scanner.nextLine();
                System.out.print("Resolucion pantalla: ");
                String resolucion = scanner.nextLine();
                System.out.print("Tipo teclado: ");
                String teclado = scanner.nextLine();
                System.out.print("Bateria (mAh): ");
                int bateria = Integer.parseInt(scanner.nextLine());

                Notebook nb = new Notebook(marca, ram, almacenamiento, procesador, modelo, anio, precio, stock, resolucion, teclado, bateria);
                notebooks.add(nb);
                tienda.agregarDispositivo(nb);
                GestorArchivo.guardarNotebook(nb);
            }

            case "tablet" -> {
                System.out.print("Almacenamiento: ");
                String almacenamiento = scanner.nextLine();
                System.out.print("Resolucion pantalla: ");
                String resolucion = scanner.nextLine();
                System.out.print("Accesorios (separados por coma): ");
                String[] accesorios = scanner.nextLine().split(",");

                Tablet t = new Tablet(marca, ram, almacenamiento, procesador, modelo, anio, precio, stock, resolucion, accesorios);
                tablets.add(t);
                tienda.agregarDispositivo(t);
                GestorArchivo.guardarTablet(t);
            }

            default -> System.out.println("Tipo no valido.");
        }

        System.out.println("Producto creado y guardado correctamente.");
    }
}
