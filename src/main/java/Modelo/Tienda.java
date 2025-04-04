package Modelo;

import java.io.*;
import java.util.List;

public class Tienda {

    private String direccion;
    private List<DispositivoTecnologico> catalogo;

    public Tienda(String direccion, List<DispositivoTecnologico> catalogo) {
        this.direccion = direccion;
        this.catalogo = catalogo;
    }

    private void actualizarDireccionEnArchivo() {
        try (BufferedReader br = new BufferedReader(new FileReader("tienda.txt"));
             FileWriter fw = new FileWriter("tienda_temp.txt");
             PrintWriter pw = new PrintWriter(fw)) {

            String line;
            boolean direccionModificada = false;

            while ((line = br.readLine()) != null) {

                if (!direccionModificada) {
                    pw.println(this.direccion);
                    direccionModificada = true;
                } else {
                    pw.println(line);
                }
            }

            File originalFile = new File("tienda.txt");
            File tempFile = new File("tienda_temp.txt");

            if (originalFile.delete()) {
                tempFile.renameTo(originalFile);  // Reemplazar el archivo original con el archivo modificado
            }

            System.out.println("Dirección de la tienda actualizada correctamente");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
