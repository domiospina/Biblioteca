package co.edu.um.TrabajoBiblioteca.vista;

import co.edu.um.TrabajoBiblioteca.control.ControlBiblioteca;
import co.edu.um.TrabajoBiblioteca.excepciones.DatosErradosLibroException;
import co.edu.um.TrabajoBiblioteca.modelo.LEG;
import co.edu.um.TrabajoBiblioteca.modelo.Libro;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
 */


    public class VentanaPrincipal extends JFrame implements ActionListener{

        //atributos
        //creamos la instancia del control
        private ControlBiblioteca control = new ControlBiblioteca();

        //componentes de la interfaz grafica
        private  JList nodosLibrosEnLista = new JList(); //la lista para mostrar los libros (isbn y titulo)
        private  JScrollPane panelDesplazamientoLista = new JScrollPane(nodosLibrosEnLista); //permite hacer scroll a la lista
        private JButton adicionarLibro = new JButton("Adicionar Libro");
        private JButton eliminarLibro = new JButton("Eliminar Libro");
        private JButton BuscarLibro = new JButton("Buscar Libro");



        //administradores de diseño y sus restrictores
        private GridBagLayout gb = new GridBagLayout();
        private GridBagConstraints gc = new GridBagConstraints();

        //panel para los botones
        JPanel panelBotones = new JPanel();
        //administradores de diseño para el panel
        private GridBagLayout gbPanel = new GridBagLayout();
        private GridBagConstraints gcPanel = new GridBagConstraints();

        //constructores
        public VentanaPrincipal()
        {
            //le indico que el boton de adicionarLibro acepte eventos de clic y la
            //ventana se hara cargo de ellos
            adicionarLibro.addActionListener(this);

            //lo mismo que al anterior pero con el boton eliminarLibro
            eliminarLibro.addActionListener(this);

           BuscarLibro.addActionListener(this);


            //para que se cierre la aplicacion al darle clic en el boton de cerrar de la ventana
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            //le doy nombre al titulo de la ventana
            this.setTitle("Libreria de listas");
            //dejo que el metodo ubicaComponentesVentana se encargue de colocar los componentes
            ubicaComponentesVentana();
        }

        //metodos

        @Override
        //maneja los eventos de los botones
        public void actionPerformed(ActionEvent actionEvent) {

            //verifico que el boton adicionarLibro fue al que le dio clic
            if(adicionarLibro == actionEvent.getSource())
            {
                //se atrapa algun problema con los datos del libro
                try {
                    //se llama al control para adicionar el libro
                    control.adicionarLibro();

                    //actualizar la lista con la lista de los nodos
                    actualizarListaConNodos();

                } catch (DatosErradosLibroException e) {
                    //ToDo: mostrar la ventana que ha sucedido un error
                }
            }

            //se atrapa algun problema con los datos del libro
            try {
                //se llama al control para adicionar el libro
                control.eliminarLibro();


                //actualizar la lista con la lista de los nodos
                actualizarListaConNodos();

            } catch (DatosErradosLibroException e) {
                //ToDo: mostrar la ventana que ha sucedido un error
            }

            try {
                //se llama al control para adicionar el libro
                control.Bucarlibro();

                //actualizar la lista con la lista de los nodos
                actualizarListaConNodos();

            } catch (DatosErradosLibroException e) {
                //ToDo: mostrar la ventana que ha sucedido un error
            }

        }


        //ubica los componentes en la ventana
        private void ubicaComponentesVentana()
        {

            //le indico a la ventana que va a utilizar el gridbaglayout
            this.getContentPane().setLayout(gb);
            panelBotones.setLayout(gbPanel);

            //para colocar el boton adicionarLibro me ubico en la coordenada x=0 y=0  del panelBotones
            gcPanel.gridx = 0;
            gcPanel.gridy = 0;
            //le indico al boton que utilice las coordenada 0,0
            gb.setConstraints(adicionarLibro, gcPanel);
            //adiciono el boton al panel
            panelBotones.add(adicionarLibro);

            //para colocar el boton eliminarLibro me ubico en la coordenada x=0 y=1
            gcPanel.gridx = 0;
            gcPanel.gridy = 1;
            //le indico al boton que utilice las coordenada 0,1 del panelBotones
            gbPanel.setConstraints(eliminarLibro, gcPanel);
            //adiciono el boton al panel
            panelBotones.add(eliminarLibro);

            //para colocar el boton eliminarLibro me ubico en la coordenada x=0 y=2
            gcPanel.gridx = 0;
            gcPanel.gridy = 2;
            //le indico al boton que utilice las coordenada 0,1 del panelBotones
            gbPanel.setConstraints(BuscarLibro, gcPanel);
            //adiciono el boton al panel
            panelBotones.add(BuscarLibro);


            //ubico el scrollpanel desde la coordena x=0 y=0 y con ancho 6 y alto 4 en la ventana
            //con el gridbaglayout y gridbagconstraint
            //me ubico en la coordenada 0,0 y le indico el ancho y alto
            gc.gridx = 0;
            gc.gridy = 0;
            gc.gridwidth = 6;
            gc.gridheight = 4;
            gb.setConstraints(panelDesplazamientoLista, gc);
            //adiciono el componente a la ventana
            this.add(panelDesplazamientoLista);


            //adiciono el panelBotones a la ventana
            gc.gridx = 7;
            gc.gridy = 0;
            gb.setConstraints(panelBotones, gc);
            this.add(panelBotones);

            //dar tamano a la ventana para que acomode los componentes
            this.pack();
            //mostrar la ventana
            this.setVisible(true);

        }

        private void actualizarListaConNodos()
        {
            //ToDo: actualizar la lista con la lista de los nodos

            //1. obtengo la lista de libros del control
            LEG<Libro> listaDeLibros = control.getListaLibro();

            //2. borro todos los items que haya en la lista
            nodosLibrosEnLista.setModel(new DefaultListModel());

            //3. recorro la lista y voy adicionando los item a la lista
            //ToDo: falta
        }





    }
