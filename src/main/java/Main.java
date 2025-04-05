
import Data.GestorArchivo;
import Modelo.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Tienda tienda = new Tienda();
        //tienda.setDireccion("Av alemania 3450");
        String[] accesorios = {"Lapiz,funda"};
        Pantalla pantalla = new Pantalla("Lg","lg27",2020);

        Cliente cliente = new Cliente("Prueba4", "Gallardo2", "2ashdj@gmail.com",223456,
                "soltero","Temuco");

        Notebook notebook = new Notebook("Lenovo","16GB","1tb",
                "Amd ryzen 5 3600","Lev1", 2020,55555,1,"1920x1080",
                "Mecanico",234);

        Tablet tablet = new Tablet("Samsung","8Gb","500GB",
                "Snapdragon 850","Galaxy 1",2019,500123,45,
                "1920x1080",accesorios);

        CompuEscritorio pc = new CompuEscritorio("Corsair","32Gb","2tb",
                "Intel i7 11700kf","Xd",2020,100000,3,"Rtx 3060",
                "Corsair 800w 80plus gold","Deepcool ghs",pantalla);

        //GestorArchivo.guardarComputador(pc);
        //GestorArchivo.guardarTablet(tablet);
        //GestorArchivo.guardarNotebook(notebook);

        //tienda.agregarDispositivo(pc);
        //List<DispositivoTecnologico> resultados = tienda.buscarPorMarca("Lenovo");
        //List<DispositivoTecnologico> resultados2 = tienda.buscarPorTipo("CompuEscritorio");

        //for (DispositivoTecnologico d : resultados2) {
            //System.out.println(d.getModelo() + " - $" + d.getPrecio());
        //}

        tienda.agregarDispositivo(notebook);
        tienda.agregarDispositivo(tablet);
        GestorArchivo.guardarNotebook(notebook);
        GestorArchivo.guardarTablet(tablet);

        List<DispositivoTecnologico> carrito = new ArrayList<>();
        carrito.add(notebook);
        carrito.add(tablet);

        tienda.realizarVenta(cliente, carrito);


    }

}
