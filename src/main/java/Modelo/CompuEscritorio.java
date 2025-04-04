package Modelo;

public class CompuEscritorio extends DispositivoTecnologico{

    private String tarjetaDeVideo;
    private String fuenteDePoder;
    private String gabinete;
    private Pantallla pantallla;

    public CompuEscritorio(String marca, String memoriaRAM, String memoriaAlmacenamiento, String procesador, String modelo, int anioP, double precio, int stock) {
        super(marca, memoriaRAM, memoriaAlmacenamiento, procesador, modelo, anioP, precio, stock);
    }

    public CompuEscritorio(String marca, String memoriaRAM, String memoriaAlmacenamiento, String procesador, String modelo, int anioP, double precio, int stock, String tarjetaDeVideo, String fuenteDePoder, String gabinete, Pantallla pantallla) {
        super(marca, memoriaRAM, memoriaAlmacenamiento, procesador, modelo, anioP, precio, stock);
        this.tarjetaDeVideo = tarjetaDeVideo;
        this.fuenteDePoder = fuenteDePoder;
        this.gabinete = gabinete;
        this.pantallla = pantallla;
    }

    public String getTarjetaDeVideo() {
        return tarjetaDeVideo;
    }

    public String getFuenteDePoder() {
        return fuenteDePoder;
    }

    public String getGabinete() {
        return gabinete;
    }

    public Pantallla getPantallla() {
        return pantallla;
    }
}
