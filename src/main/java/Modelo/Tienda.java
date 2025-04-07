package Modelo;

import Data.GestorArchivo;
import java.util.ArrayList;
import java.util.List;

public class Tienda {

    private String direccion;
    private ArrayList<DispositivoTecnologico> catalogo = new ArrayList<>();
    private ArrayList<Cliente> clientes = new ArrayList<>();

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
        GestorArchivo.guardarCliente(c);
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


}
