import javax.swing.*; //importar toda la biblioteca de java swing
import java.io.FileWriter;
import java.io.IOException;
<<<<<<< HEAD
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

=======
import java.awt.event.*;
>>>>>>> b5c11975b9f388107e38c59b072e2938f375498e
public class VentanaPrincipal extends JFrame{
    //constructor de la clase
    public VentanaPrincipal(){
        //Parte 1,Configuracion Inicial de la ventana
        setTitle("Formulario de Usuario");//Establece el titulo de la ventana.
        setSize(400, 300);//Establece el tamaño de la ventana.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Operacion a realizar cuando cierre la ventana
        setLocationRelativeTo(null);//centrar la ventana

        //Parte 2,Creación barra de menú desplegable
        JMenuBar menuBar = new JMenuBar();//crear una barra de menú vacía
        JMenu menuArchivo = new JMenu("Archivo");// crear un menu con la etiqueta especificada
        JMenuItem nuevoItem = new JMenuItem("Nuevo");//crear elemento de menú con etiqueta especificada
        JMenuItem guardarItem = new JMenuItem("Guardar");
        JMenuItem salirItem = new JMenuItem("Salir");
        //Hasta aquí parte 1

        //Añadir elementos al menú.("Archivo")
        menuArchivo.add(nuevoItem);
        menuArchivo.add(guardarItem);
        menuArchivo.addSeparator(); //Separador visual, linea separadora
        menuArchivo.add(salirItem);
        menuBar.add(menuArchivo); //Agrega el menú "archivo" a la barra de menús
        setJMenuBar(menuBar);
        //hasta aquí parte 2

        //Parte 3, agregar funcionalidad al elemento "Salir"
        salirItem.addActionListener(e-> System.exit(0));//seleccion de boton "Salir", la app se cierra con el metodo listener

        //Parte 4, crear formulario de entrada de datos
        JPanel panelFormulario = new JPanel();
<<<<<<< HEAD
        panelFormulario.setLayout(new BoxLayout(panelFormulario, BoxLayout.Y_AXIS));//vertical
        
=======
        panelFormulario.setLayout(new BoxLayout(panelFormulario, BoxLayout.Y_AXIS));

>>>>>>> b5c11975b9f388107e38c59b072e2938f375498e
        JLabel etiquetaNombre = new JLabel("Nombre:");
        JTextField campoNombre = new JTextField(20);//Ingresar texto de una sola línea y agregar 20 columnas de ancho                         

        JLabel etiquetaEmail = new JLabel("Email:");
        JTextField campoEmail = new JTextField(20);

        JLabel etiquetaTelefono = new JLabel("Telefono");
        JTextField campoTelefono = new JTextField(20);

        //añadir elementos al panel
        panelFormulario.add(etiquetaNombre);
        panelFormulario.add(campoNombre);
        panelFormulario.add(etiquetaEmail);
        panelFormulario.add(campoEmail);
        panelFormulario.add(etiquetaTelefono);
        panelFormulario.add(campoTelefono);
        
        add(panelFormulario);

        //inicio parte 5, añadir botones y funcionalidad "guardar" a guardar datos
        JButton botonGuardar = new JButton("Guardar");
        JButton botonLimpiar = new JButton("Limpiar");

        botonGuardar.addActionListener(e-> {
            String nombre = campoNombre.getText();
            String email = campoEmail.getText();
            String telefono = campoTelefono.getText();
            
            //manejo excepciones
            try{
                FileWriter writer = new FileWriter("datos_usuario.txt", true);
                writer.write("Nombre: " + nombre + ", Email: "+ email +",Télefono: " + telefono);
                writer.close();
                JOptionPane.showMessageDialog(null, "Datos guardados exitosamente.");
            }catch(IOException ex){
                JOptionPane.showMessageDialog(null, "Error al guardar los datos.");

            }
        });

        botonLimpiar.addActionListener(e->{
            String nombre = "";
            String email = "";
            String telefono = "";
            
        });

        panelFormulario.add(botonGuardar);//añade el boton al panel
<<<<<<< HEAD
        
        
        //crear JComboBox y añadir los elementos
        String[] tiposDeUsuario = {"Cliente","Empleado","Administrador"};
        JComboBox<String> tiposUsuario = new JComboBox<>(tiposDeUsuario);
        
        panelFormulario.add(tiposUsuario);
        
=======
        panelFormulario.add(botonLimpiar);
        //parte 6, añadir JCombobox para tipo de usuario
        String[] usuarios ={"Cliente","Empleado","Administrador"};
        JComboBox<String> tipoUsuario = new JComboBox<>(usuarios);//inicializar combobox

        tipoUsuario.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                    //texto para la selección
                String mensaje = "Usuario seleccionado: " + tipoUsuario.getItemAt(tipoUsuario.getSelectedIndex());

                JOptionPane.showMessageDialog(null, mensaje);                 
            }
        });
        panelFormulario.add(tipoUsuario);//añadir combobox al panel

        //parte 7,incluir JCheckBox, aceptar términos y condiciones

>>>>>>> b5c11975b9f388107e38c59b072e2938f375498e
    }

    public static void main(String[] args){
        VentanaPrincipal ventana = new VentanaPrincipal();
        ventana.setVisible(true); //Mostrar la ventana
    }
}

