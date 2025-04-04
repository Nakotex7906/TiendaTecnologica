package Modelo;

import java.util.List;

public class Tienda {

    private String direccion;
    private List<DispositivoTecnologico> catalogo;

    public Tienda(String direccion, List<DispositivoTecnologico> catalogo) {
        this.direccion = direccion;
        this.catalogo = catalogo;
    }
}
