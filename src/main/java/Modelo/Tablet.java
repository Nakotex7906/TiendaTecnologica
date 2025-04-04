package Modelo;

import java.util.List;

public class Tablet extends DispositivoTecnologico{

    private String resolucionPantalla;
    private List<String> accesorios;

    public Tablet(String marca, String memoriaRAM, String memoriaAlmacenamiento, String procesador, String modelo,String tipo, int anioP, double precio, int stock, String resolucionPantalla, List<String> accesorios) {
        super(marca, memoriaRAM, memoriaAlmacenamiento, procesador, modelo,tipo, anioP, precio, stock);
        this.resolucionPantalla = resolucionPantalla;
        this.accesorios = accesorios;
    }
}
