package Modelo;

import Data.GestorArchivo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Tienda {

    private String direccion;
    private ArrayList<DispositivoTecnologico> catalogo = new ArrayList<>();
    private ArrayList<Cliente> clientes = new ArrayList<>();
    private List<Venta> ventas = new ArrayList<>();

    public Tienda(String direccion, ArrayList<DispositivoTecnologico> catalogo) {
        this.direccion = direccion;
        this.catalogo = catalogo;
    }

    public Tienda() {}

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String Nuevadireccion) {
        this.direccion = Nuevadireccion;
        GestorArchivo.guardarDireccion(Nuevadireccion); // Guarda la direccion en el archivo
    }

    public void agregarDispositivo(DispositivoTecnologico d) {
        this.catalogo.add(d);
    }

    public void agregarCliente(Cliente c) {
        this.clientes.add(c);
    }

    public List<DispositivoTecnologico> buscarPorMarca(String marca) {
        return catalogo.stream().filter(d -> d.getMarca().equalsIgnoreCase(marca)).toList();
    }

    public List<DispositivoTecnologico> buscarPorModelo(String modelo) {
        return catalogo.stream().filter(t -> t.getModelo().equalsIgnoreCase(modelo)).toList();
    }

    public List<DispositivoTecnologico> buscarPorTipo(String tipo) {
        return catalogo.stream().filter(m -> m.getTipo().equalsIgnoreCase(tipo)).toList();
    }

    public void realizarVenta(Cliente cliente, List<DispositivoTecnologico> dispositivos) {
        for (DispositivoTecnologico d : dispositivos) {
            if (d.getStock() > 0){
                d.reducirStock();
            } else {
                System.out.println("Sin stock");
            }
        }

        Venta venta = new Venta(cliente,dispositivos);
        ventas.add(venta);
        System.out.println("Venta realizada a " + cliente.getNombre());
        GestorArchivo.guardarVenta(venta);
    }

}
