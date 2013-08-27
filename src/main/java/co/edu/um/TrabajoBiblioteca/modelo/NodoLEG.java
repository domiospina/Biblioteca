package co.edu.um.TrabajoBiblioteca.modelo;

/**
 ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
 */
public class NodoLEG<W> {
    W dato;
    NodoLEG <W> siguiente;
    NodoLEG (W dato){
        this (dato, null);
    }
    NodoLEG(W dato, NodoLEG<W> siguiente){
        this.dato = dato;
        this.siguiente = siguiente;
    }
}
