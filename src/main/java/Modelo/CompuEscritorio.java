package Modelo;

public class CompuEscritorio extends DispositivoTecnologico{

    private String tarjetaDeVideo;
    private String fuenteDePoder;
    private String gabinete;
    private Pantalla pantalla;

    public CompuEscritorio(String marca, String memoriaRAM, String memoriaAlmacenamiento, String procesador, String modelo, String tipo,
                           int anioP, double precio, int stock, String tarjetaDeVideo,
                           String fuenteDePoder, String gabinete, Pantalla pantallla) {
        super(marca, memoriaRAM, memoriaAlmacenamiento, procesador, modelo, tipo, anioP, precio, stock);
        this.tarjetaDeVideo = tarjetaDeVideo;
        this.fuenteDePoder = fuenteDePoder;
        this.gabinete = gabinete;
        this.pantalla = pantallla;
    }


}
