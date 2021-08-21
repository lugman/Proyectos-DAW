package es.esy.reofertas.re_ofertas;

public class Usuario {
    String Nobre;
    String Apellidos;
    String Email;
    String Telefono1;
    String Telefono2;
    String Ciudad;
    String Poblacion;

    public boolean isVerificado() {
        return Verificado;
    }

    public void setVerificado(boolean verificado) {
        Verificado = verificado;
    }

    boolean Verificado;

    public String getNobre() {
        return Nobre;
    }

    public void setNobre(String nobre) {
        Nobre = nobre;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String apellidos) {
        Apellidos = apellidos;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getTelefono1() {
        return Telefono1;
    }

    public void setTelefono1(String telefono1) {
        Telefono1 = telefono1;
    }

    public String getTelefono2() {
        return Telefono2;
    }

    public void setTelefono2(String telefono2) {
        Telefono2 = telefono2;
    }

    public String getCiudad() {
        return Ciudad;
    }

    public void setCiudad(String ciudad) {
        Ciudad = ciudad;
    }

    public String getPoblacion() {
        return Poblacion;
    }

    public void setPoblacion(String poblacion) {
        Poblacion = poblacion;
    }

    public String getFoto() {
        return Foto;
    }

    public void setFoto(String foto) {
        Foto = foto;
    }

    String Foto;

    public Usuario(){

    }
}
