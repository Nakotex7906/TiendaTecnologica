package Modelo;

import java.time.LocalDate;
import java.util.List;

public class Venta {
    private Cliente cliente;
    private List<DispositivoTecnologico> dispositivosComprados;
    private LocalDate fecha;

    public Venta(Cliente cliente, List<DispositivoTecnologico> dispositivosComprados) {
        this.cliente = cliente;
        this.dispositivosComprados = dispositivosComprados;
        this.fecha = LocalDate.now();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<DispositivoTecnologico> getDispositivosComprados() {
        return dispositivosComprados;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    @Override
    public String toString() {
        return "Venta a " +  cliente.getNombre() + " a fecha " + fecha + " de " + dispositivosComprados;
    }

}
