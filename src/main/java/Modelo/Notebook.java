package Modelo;

public class Notebook extends DispositivoTecnologico {

    private String resolucionPantalla;
    private String tipoTeclado;
    private int bateriaMah;

    public Notebook(String marca, String memoriaRAM, String memoriaAlmacenamiento, String procesador, String modelo, int anioP, double precio, int stock, String resolucionPantalla, String tipoTeclado, int bateriaMah) {
        super(marca, memoriaRAM, memoriaAlmacenamiento, procesador, modelo, anioP, precio, stock);
        this.resolucionPantalla = resolucionPantalla;
        this.tipoTeclado = tipoTeclado;
        this.bateriaMah = bateriaMah;
    }
}
