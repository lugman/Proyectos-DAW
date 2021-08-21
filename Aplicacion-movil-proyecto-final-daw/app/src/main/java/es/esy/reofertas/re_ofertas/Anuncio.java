package es.esy.reofertas.re_ofertas;

import org.json.JSONArray;

public class Anuncio {
    String Id;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    String titulo;
    String descripcion;
    String extra;
    String precio;
    String imagen;
    String estado;

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getValoracion() {
        return valoracion;
    }

    public void setValoracion(String valoracion) {
        this.valoracion = valoracion;
    }

    String valoracion;
    JSONArray imagens;

    public JSONArray getComentarios() {
        return comentarios;
    }

    public void setComentarios(JSONArray comentarios) {
        this.comentarios = comentarios;
    }

    JSONArray comentarios;

    public JSONArray getImagens() {
        return imagens;
    }

    public void setImagens(JSONArray imagens) {
        this.imagens = imagens;
    }

    String fecha;
    String Ciudad;
    String poblacion;
    Usuario usuario;


    public Anuncio(String titulo, String descripcion, String extra, String precio, String imagen, String fecha, String ciudad, String poblacion) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.extra = extra;
        this.precio = precio;
        this.imagen = imagen;
        this.fecha = fecha;
        Ciudad = ciudad;
        this.poblacion = poblacion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Anuncio(){

    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getCiudad() {
        return Ciudad;
    }

    public void setCiudad(String ciudad) {
        Ciudad = ciudad;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }
}
