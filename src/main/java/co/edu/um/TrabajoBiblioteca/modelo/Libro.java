package co.edu.um.TrabajoBiblioteca.modelo;

import java.util.Date;

/**

 */
public class Libro {
    //atributos
    private String isbn;
    private String titulo;
    private String autor;
    private Date fechaPublicacion;
    private int numeroEjemplares;

    //constructores
    public Libro(String isbn, String titulo, String autor, Date fechaPublicacion, int numeroEjemplares) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.fechaPublicacion = fechaPublicacion;
        this.numeroEjemplares = numeroEjemplares;
    }

    public Libro() {                             //costructor vasio
    }

    //set y get
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public int getNumeroEjemplares() {
        return numeroEjemplares;
    }

    public void setNumeroEjemplares(int numeroEjemplares) {
        this.numeroEjemplares = numeroEjemplares;
    }

    @Override
    public String toString() {
        return "[" + isbn  + "]: " + titulo ;
    }
}