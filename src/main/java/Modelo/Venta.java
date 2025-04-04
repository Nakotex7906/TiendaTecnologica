package Modelo;

import java.util.Date;
import java.util.List;

public class Venta {
    private Cliente cliente;
    private List<DispositivoTecnologico> dispositivosComprados;
    private Date fecha;

    public Venta(Cliente cliente, List<DispositivoTecnologico> dispositivosComprados, Date fecha) {
        this.cliente = cliente;
        this.dispositivosComprados = dispositivosComprados;
        this.fecha = fecha;
    }
}
