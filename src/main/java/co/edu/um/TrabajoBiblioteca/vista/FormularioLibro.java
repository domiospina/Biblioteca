package co.edu.um.TrabajoBiblioteca.vista;

import co.edu.um.TrabajoBiblioteca.modelo.Libro;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Usuario
 * Date: 21/08/13
 * Time: 04:55 PM
 * To change this template use File | Settings | File Templates.
 */
public class FormularioLibro extends JFrame implements ActionListener, ChangeListener {


    //constantes para las opciones del tipo de adicion.
    public static final int OPCION_ADICION_INICIO  = 1;
    public static final int OPCION_ADICION_FINAL   = 2;
    public static final int OPCION_ADICION_ANTES   = 3;
    public static final int OPCION_ADICION_DESPUES = 4;
    public static final int BUSCAR = 1;


    //la ventana consta de tres paneles, uno para el formulario,
    //otro para los botones radiobutton para escoger el tipo de adición
    //y el ultimo para los botones de aceptar y cancelar
    private JPanel panelFormulario = new JPanel();
    private JPanel panelSeleccionTipoAdicion = new JPanel();
    private JPanel panelBotones = new JPanel();

    //el administrador de diseño para la ventana
    private GridBagLayout gbVentana = new GridBagLayout();
    private GridBagConstraints gbcVentana = new GridBagConstraints();

    //componentes para el formulario
    private JLabel etqIsbn = new JLabel("ISBN:");
    private JLabel etqTitulo = new JLabel("Título:");
    private JLabel etqAutor = new JLabel("Autor:");
    private JLabel etqFechaEdicion = new JLabel("Fecha Edición:");
    private JLabel etqNumeroEjemplares = new JLabel("Número Ejemplares:");
    private JTextField txtIsbn = new JTextField(20);
    private JTextField txtTitulo = new JTextField(20);
    private JTextField txtAutor = new JTextField(20);
    private JTextField txtFechaEdicion = new JTextField(20);
    private JTextField txtNumeroEjemplares = new JTextField(20);
    //los layout para el formulario
    private GridBagLayout gbFormulario = new GridBagLayout();
    private GridBagConstraints gbcFormulario = new GridBagConstraints();


    //componentes para los botones radiobutton
    private JRadioButton radioInsertarInicio = new JRadioButton("Adicionar al inicio");
    private JRadioButton radioInsertarFinal = new JRadioButton("Adicionar al final");
    private JRadioButton radioInsertarAntesNodo = new JRadioButton("Adicionar antes de un nodo");
    private JRadioButton radioInsertarDespuesNodo = new JRadioButton("Adicionar después de un nodo");
    private ButtonGroup radioAgrupar = new ButtonGroup();
    //los administradores de diseño  para el panel
    private GridBagLayout gbRadios = new GridBagLayout();
    private GridBagConstraints gbcRadios = new GridBagConstraints();


    //componentes para los botones de cancelar y aceptar
    private JButton botonCancelar = new JButton("Cancelar");
    private JButton botonAceptar = new JButton("Aceptar");
    //los administradores de diseño para los el panel de los botones
    private GridBagLayout gbBotones = new GridBagLayout();
    private GridBagConstraints gbcBotones = new GridBagConstraints();


    //atributos para recuperar el libro, el tipo de adicion y el isbn si las
    //opciones de adicion lo requiere
    private Libro libro;
    private int tipoAdicion;
    private String isbnABuscar;


    /**
     * Crea una instancia de la ventana del formulario
     *
     * @param nuevoLibro El libro a adicionar a la lista, se recibe desde el control
     * @param opcionTipoAdicion indica el tipo de adicion que debe hacer el control
     * @param isbn El isbn para adicionar antes o despues de un nodo, si es necesario
     */
    public FormularioLibro(Libro nuevoLibro, int opcionTipoAdicion, String isbn)
    {
        libro = nuevoLibro;
        tipoAdicion = opcionTipoAdicion;
        isbnABuscar = isbn;


        //le digo a los componentes quien gestiona los eventos
        botonAceptar.addActionListener(this);
        botonCancelar.addActionListener(this);
        radioInsertarInicio.addChangeListener(this);
        radioInsertarAntesNodo.addActionListener(this);
        radioInsertarDespuesNodo.addActionListener(this);
        radioInsertarFinal.addActionListener(this);


        //habilito el boton de cerrar la ventana
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //coloco los paneles a la ventana
        colocarPaneles();

        //le digo a la ventana que acomode los componentes
        this.pack();

        //muestro la ventana
        this.setVisible(true);

    }

    public FormularioLibro() {
        //To change body of created methods use File | Settings | File Templates.
    }

    //coloca los paneles a la ventana
    private void colocarPaneles()
    {

        //llamo a los metodos que ubican los componentes
        ubicarComponentesFormulario();
        ubicarComponentesRadioButton();
        ubicarComponenteBotones();

        //defino el administrador de diseño para la ventana
        this.setLayout(gbVentana);

        //coloco los paneles a la ventana
        gbcVentana.gridx = 0;
        gbcVentana.gridy = 0;
        gbcVentana.fill = GridBagConstraints.HORIZONTAL;
        this.add(panelFormulario, gbcVentana);


        //coloco los paneles a la ventana
        gbcVentana.gridx = 1;
        gbcVentana.gridy = 0;
        gbcVentana.fill = GridBagConstraints.NORTH;
        gbVentana.setConstraints(panelSeleccionTipoAdicion, gbcVentana);
        this.add(panelSeleccionTipoAdicion);


        //coloco los paneles a la ventana
        gbcVentana.gridx = 0;
        gbcVentana.gridy = 1;
        gbcVentana.gridwidth = 2;
        gbVentana.setConstraints(panelBotones, gbcVentana);
        this.add(panelBotones);


    }

    //ubica los componentes del formulario en el panel
    private void ubicarComponentesFormulario()
    {

        //adicionar los componentes para el panel de formulario
        //le indico al panel que utilice el gridbaglayoud
        panelFormulario.setLayout(gbFormulario);

        //adiciono la etiqueta Isbn
        gbcFormulario.gridx = 0;
        gbcFormulario.gridy = 0;
        gbcFormulario.fill = GridBagConstraints.BOTH;
        gbcFormulario.weightx = 0.0;
        gbcFormulario.weighty = 0.0;
        panelFormulario.add(etqIsbn, gbcFormulario);

        //adiciono la caja de texto Isbn
        gbcFormulario.gridx = 1;
        gbcFormulario.gridy = 0;
        gbcFormulario.weightx = 1.0;
        panelFormulario.add(txtIsbn, gbcFormulario);

        //adiciono la etiqueta titulo
        gbcFormulario.gridx = 0;
        gbcFormulario.gridy = 1;
        gbFormulario.setConstraints(etqTitulo, gbcFormulario);
        panelFormulario.add(etqTitulo);

        //adiciono la etiqueta autor
        gbcFormulario.gridx = 0;
        gbcFormulario.gridy = 2;
        gbFormulario.setConstraints(etqAutor, gbcFormulario);
        panelFormulario.add(etqAutor);

        //adiciono la etiqueta fecha edicion
        gbcFormulario.gridx = 0;
        gbcFormulario.gridy = 3;
        gbFormulario.setConstraints(etqFechaEdicion, gbcFormulario);
        panelFormulario.add(etqFechaEdicion);

        //adiciono la etiqueta numero ejemplares
        gbcFormulario.gridx = 0;
        gbcFormulario.gridy = 4;
        gbFormulario.setConstraints(etqNumeroEjemplares, gbcFormulario);
        panelFormulario.add(etqNumeroEjemplares);


        //adiciono la caja de texto Isbn
        gbcFormulario.gridx = 1;
        gbcFormulario.gridy = 0;
        gbcFormulario.gridwidth = 4;
        panelFormulario.add(txtIsbn, gbcFormulario);

        //adiciono la caja de texto titulo
        gbcFormulario.gridx = 1;
        gbcFormulario.gridy = 1;
        gbcFormulario.gridwidth = 4;
        gbcFormulario.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(txtTitulo, gbcFormulario);

        //adiciono la caja de texto autor
        gbcFormulario.gridx = 1;
        gbcFormulario.gridy = 2;
        gbcFormulario.gridwidth = 4;
        gbcFormulario.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(txtAutor, gbcFormulario);

        //adiciono la etiqueta fecha edicion
        gbcFormulario.gridx = 1;
        gbcFormulario.gridy = 3;
        gbcFormulario.gridwidth = 4;
        gbcFormulario.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(txtFechaEdicion, gbcFormulario);

        //adiciono la etiqueta numero ejemplares
        gbcFormulario.gridx = 1;
        gbcFormulario.gridy = 4;
        gbcFormulario.gridwidth = 4;
        gbcFormulario.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(txtNumeroEjemplares, gbcFormulario);

    }


    //coloca los radiobutton en el panel
    private void ubicarComponentesRadioButton()
    {
        //asociar los radioButton
        radioAgrupar.add(radioInsertarAntesNodo);
        radioAgrupar.add(radioInsertarDespuesNodo);
        radioAgrupar.add(radioInsertarInicio);
        radioAgrupar.add(radioInsertarFinal);

        //defino el diseño del panel
        panelSeleccionTipoAdicion.setLayout(gbRadios);

        //adiciono los radioButton
        gbcRadios.gridx = 0;
        gbcRadios.gridy = 0;
        gbcRadios.fill = GridBagConstraints.BOTH;
        gbRadios.setConstraints(radioInsertarInicio, gbcRadios);
        panelSeleccionTipoAdicion.add(radioInsertarInicio);

        //adiciono los radioButton
        gbcRadios.gridx = 0;
        gbcRadios.gridy = 1;
        gbRadios.setConstraints(radioInsertarAntesNodo, gbcRadios);
        panelSeleccionTipoAdicion.add(radioInsertarAntesNodo);

        //adiciono los radioButton
        gbcRadios.gridx = 0;
        gbcRadios.gridy = 2;
        gbRadios.setConstraints(radioInsertarDespuesNodo, gbcRadios);
        panelSeleccionTipoAdicion.add(radioInsertarDespuesNodo);

        //adiciono los radioButton
        gbcRadios.gridx = 0;
        gbcRadios.gridy = 3;
        gbRadios.setConstraints(radioInsertarFinal, gbcRadios);
        panelSeleccionTipoAdicion.add(radioInsertarFinal);

    }


    //colocar los botones en el panel
    private void ubicarComponenteBotones()
    {
        //defino el diseño del panel
        panelBotones.setLayout(gbBotones);

        //adiciono los botones
        gbcBotones.gridx = 0;
        gbcBotones.gridy = 0;
        gbBotones.setConstraints(botonCancelar, gbcBotones);
        panelBotones.add(botonCancelar);

        //adiciono los botones
        gbcBotones.gridx = 1;
        gbcBotones.gridy = 0;
        gbBotones.setConstraints(botonAceptar, gbcBotones);
        panelBotones.add(botonAceptar);
    }




    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        //gestiono los eventos
        if(actionEvent.getSource() == botonCancelar)
        {
            //cierro la ventana
            this.setVisible(false);
        }
        if(actionEvent.getSource() == botonAceptar)
        {
            //recupero los datos del formulario y
            //los almaceno en libro
            libro.setIsbn(txtIsbn.getText());
            libro.setTitulo(txtTitulo.getText());
            libro.setAutor(txtTitulo.getText());
            libro.setFechaPublicacion(new Date(txtFechaEdicion.getText()));
            libro.setNumeroEjemplares(Integer.getInteger(txtNumeroEjemplares.getText()));

            //recupero el tipo de adicion que se desea
            if(radioInsertarInicio.isSelected())
            {
                tipoAdicion = FormularioLibro.OPCION_ADICION_INICIO;
            }
            if(radioInsertarAntesNodo.isSelected())
            {
                tipoAdicion = FormularioLibro.OPCION_ADICION_ANTES;
            }
            if(radioInsertarDespuesNodo.isSelected())
            {
                tipoAdicion = FormularioLibro.OPCION_ADICION_DESPUES;
            }
            if(radioInsertarFinal.isSelected())
            {
                tipoAdicion = FormularioLibro.OPCION_ADICION_FINAL;
            }


        }


    }

    @Override
    public void stateChanged(ChangeEvent changeEvent) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
