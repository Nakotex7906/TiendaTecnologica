package Modelo;

public class Tablet extends DispositivoTecnologico{

    private String resolucionPantalla;
    private String[] accesorios;

    public Tablet(String marca, String memoriaRAM, String memoriaAlmacenamiento, String procesador, String modelo,
                  int anioP, double precio, int stock, String resolucionPantalla, String[] accesorios) {
        super(marca, memoriaRAM, memoriaAlmacenamiento, procesador, modelo, anioP, precio, stock);
        this.resolucionPantalla = resolucionPantalla;
        this.accesorios = accesorios;
    }

    public String getResolucionPantalla() {
        return resolucionPantalla;
    }

    public String[] getAccesorios() {
        return accesorios;
    }


}
