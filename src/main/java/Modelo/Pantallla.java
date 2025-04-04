package Modelo;

public class Pantallla {
    private String marca;
    private String modelo;
    private int anioP;

    public Pantallla(String marca, String modelo, int anioP) {
        this.marca = marca;
        this.modelo = modelo;
        this.anioP = anioP;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAnioP() {
        return anioP;
    }
}
