package Modelo;

public class Pantalla {
    private String marca;
    private String modelo;
    private int anioP;

    public Pantalla(String marca, String modelo, int anioP) {
        this.marca = marca;
        this.modelo = modelo;
        this.anioP = anioP;
    }

    public String getModelo() {
        return modelo;
    }

    @Override
    public String toString() {
        return "Pantalla{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", anioP=" + anioP +
                '}';
    }
}
