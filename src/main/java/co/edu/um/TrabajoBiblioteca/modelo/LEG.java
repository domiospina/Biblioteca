package co.edu.um.TrabajoBiblioteca.modelo;

/**
 ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
 */
public class LEG <W>{

    protected NodoLEG<W> primero;
    protected int talla;
    private NodoLEG<W> ant;

    public LEG (){
        primero = null;
        talla = 0;

    }
    public void talla(){

    }
    public void insertar (W x){
        NodoLEG<W> nuevo= new NodoLEG<W>(x);
        nuevo.siguiente=primero;
        primero=nuevo;
        this.talla ++;

    }
    public void insertarEnFin (W x){
        NodoLEG<W> nl= new NodoLEG<W>(x);
        this.talla ++;
        NodoLEG<W> aux = primero;
        if  (aux == null) {
            primero = nl;
        }
        else {
            while (aux.siguiente != null) {
                aux = aux.siguiente;
                aux.siguiente = nl;
            }
        }


    }
    public boolean eliminar(W x) {
        NodoLEG<W> aux = primero;

        boolean res = false;
        while (aux != null){
            ant=aux;
            aux=aux.siguiente;
        }
        if (aux != null){
            res = true;
            this.talla -- ;
            if (ant == null) {
                primero =aux.siguiente;


                ant.siguiente = aux.siguiente;

            }

        }


        return res;
    }
    public String toString(){
        String res ="";
        for (NodoLEG<W> aux = primero;
             aux != null;
             aux=aux.siguiente) {
            res += aux.dato.toString()+"\n";
            //return res;
        }


        return res;
    }
}
