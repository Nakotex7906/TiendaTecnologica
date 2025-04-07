package Modelo;

public class Cliente {

    private String nombre;
    private String apellido;
    private String correo;
    private String telefono;
    private String estadoCivil;
    private String ciudad;

    public Cliente(String nombre, String apellido, String correo, String telefono, String estadoCivil, String ciudad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.telefono = telefono;
        this.estadoCivil = estadoCivil;
        this.ciudad = ciudad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public String getCiudad() {
        return ciudad;
    }
}


