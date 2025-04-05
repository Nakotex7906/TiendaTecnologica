package Modelo;

import Data.GestorArchivo;

import java.io.*;
import java.util.List;

public class Tienda {

    private String direccion;
    private List<DispositivoTecnologico> catalogo;

    public Tienda(String direccion, List<DispositivoTecnologico> catalogo) {
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

}
