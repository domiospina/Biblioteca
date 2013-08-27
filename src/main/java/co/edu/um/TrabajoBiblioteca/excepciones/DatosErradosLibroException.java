package co.edu.um.TrabajoBiblioteca.excepciones;

/**
 ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
 */
public class DatosErradosLibroException extends Exception {

    //cosntructor
    public DatosErradosLibroException(String s) {
        super("Los datos del libro tiene problemas");
    }
}
