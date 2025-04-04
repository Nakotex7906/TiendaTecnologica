package Data;

import Modelo.Cliente;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.regex.Pattern;

public class GestionClientes {

    public boolean validarCorreo(String email) {
        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
        return Pattern.matches(regex, email);
    }

    public void agregarCliente(Cliente cliente) {
        if (validarCorreo(cliente.getCorreo())) {
            try {
                FileWriter fw = new FileWriter("clientes.csv",true);
                PrintWriter pw = new PrintWriter(fw);

                pw.println(cliente.getNombre() + "," + cliente.getApellido() + "," + cliente.getCorreo() +
                        "," + cliente.getTelefono() + "," + cliente.getEstadoCivil() + "," + cliente.getCiudad());
                System.out.println("Cliente agregado correctamente.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else {
            System.out.println("El email es invalido.");
        }
    }

}
