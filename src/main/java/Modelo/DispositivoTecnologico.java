package Modelo;

public class DispositivoTecnologico {

    private String marca;
    private String memoriaRAM;
    private String memoriaAlmacenamiento;
    private String procesador;
    private String modelo;
    private String tipo;
    private int anioP;
    private double precio;
    private int stock;

    public DispositivoTecnologico(String marca, String memoriaRAM, String memoriaAlmacenamiento,
                                  String procesador, String modelo, String tipo, int anioP,
                                  double precio, int stock) {
        this.marca = marca;
        this.memoriaRAM = memoriaRAM;
        this.memoriaAlmacenamiento = memoriaAlmacenamiento;
        this.procesador = procesador;
        this.modelo = modelo;
        this.tipo = tipo;
        this.anioP = anioP;
        this.precio = precio;
        this.stock = stock;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }


    public String getMemoriaRAM() {
        return memoriaRAM;
    }

    public void setMemoriaRAM(String memoriaRAM) {
        this.memoriaRAM = memoriaRAM;
    }


    public String getMemoriaAlmacenamiento() {
        return memoriaAlmacenamiento;
    }

    public void setMemoriaAlmacenamiento(String memoriaAlmacenamiento) {
        this.memoriaAlmacenamiento = memoriaAlmacenamiento;
    }

    public String getProcesador() {
        return procesador;
    }

    public void setProcesador(String procesador) {
        this.procesador = procesador;
    }


    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }


    public String getTipo() { return tipo;}

    public void setTipo(String tipo) { this.tipo = tipo; }


    public int getAnioP() {
        return anioP;
    }

    public void setAnioP(int anioP) {
        this.anioP = anioP;
    }


    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }


    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }


}

