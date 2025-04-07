package Modelo;

public abstract class DispositivoTecnologico {

    private String marca;
    private String memoriaRAM;
    private String memoriaAlmacenamiento;
    private String procesador;
    private String modelo;
    private int anioP;
    private double precio;
    private int stock;

    public DispositivoTecnologico(String marca, String memoriaRAM, String memoriaAlmacenamiento,
                                  String procesador, String modelo, int anioP, double precio, int stock) {
        this.marca = marca;
        this.memoriaRAM = memoriaRAM;
        this.memoriaAlmacenamiento = memoriaAlmacenamiento;
        this.procesador = procesador;
        this.modelo = modelo;
        this.anioP = anioP;
        this.precio = precio;
        this.stock = stock;
    }

    public String getTipo() { return this.getClass().getSimpleName(); }

    public void reducirStock() {
        if (stock > 0) {
            stock--;
        }
    }

    public String getMarca() {
        return marca;
    }

    public String getMemoriaRAM() {
        return memoriaRAM;
    }

    public String getMemoriaAlmacenamiento() {
        return memoriaAlmacenamiento;
    }

    public String getProcesador() {return procesador;}

    public String getModelo() {return modelo;}

    public void setModelo(String modelo) {this.modelo = modelo;}

    public int getAnioP() {
        return anioP;
    }

    public double getPrecio() {
        return precio;
    }

    public int getStock() {return stock;}

}

