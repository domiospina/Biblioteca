package co.edu.um.TrabajoBiblioteca.control;

import co.edu.um.TrabajoBiblioteca.excepciones.DatosErradosLibroException;
import co.edu.um.TrabajoBiblioteca.modelo.LEG;
import co.edu.um.TrabajoBiblioteca.modelo.Libro;

/**
 ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
 */
public class ControlBiblioteca {

    //creo la lista que se va a utilizar para contener los nodos
    private LEG<Libro> listaLibro = new LEG<Libro>();

    //get y set
    public LEG<Libro> getListaLibro() {
        return listaLibro;
    }

    public void setListaLibro(LEG<Libro> listaLibro) {
        this.listaLibro = listaLibro;
    }

    /**
     * Realiza el control del caso de uso numero 1
     */
    public void adicionarLibro() throws DatosErradosLibroException
    {
        Libro nuevoLibro = new Libro();

        //1. muestro la ventana para ingresar nuevos libros
        //ToDo: falta crear la vista para ingresar nuevos datos

        //2. recupero los datos del libro

        //3. si los datos no son completos o estan incorrectos lanzo la excepcion

        //4. Creo un nodo y le asigno el libro

        //5. adiciono el nodo a la lista

        //6. la vista debe actualizar la lista de nodos

    }

    public void eliminarLibro()  throws DatosErradosLibroException {
        Libro nuevoLibro = new Libro();
    }

    public void Bucarlibro() throws DatosErradosLibroException{
        Libro nuevoLibro = new Libro();
    }
}
