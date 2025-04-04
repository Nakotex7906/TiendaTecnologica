package Data;

import Modelo.DispositivoTecnologico;

import java.io.FileWriter;
import java.io.PrintWriter;

public class GestionDispositivos {

    public void agregarDispositivos(DispositivoTecnologico dispositivo) {
        try {
            FileWriter fw = new FileWriter("dispositivos.csv",true);
            PrintWriter pw = new PrintWriter(fw);

            pw.println(dispositivo.getMarca() + "," + dispositivo.getModelo() + "," + dispositivo.getProcesador() +
                    "," + dispositivo.getMemoriaRAM() + "," + dispositivo.getMemoriaAlmacenamiento() + ","
                    + dispositivo.getPrecio() + "," + dispositivo.getStock() + "," + dispositivo.getAnioP());
            System.out.println("Dispositivo agregado correctamente.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
