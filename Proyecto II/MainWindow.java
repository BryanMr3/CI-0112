


import java.awt.event.*;
import javax.swing.*;

/**
 * Esta clase contiene los metodos necesarios para la creación de la interfaz gráfica
 */
public class MainWindow extends JFrame {
    private Deque deque;
    private JPanel panelDeque;
    private JTextArea showDequeArea;
    private JTextField valueField;
    private JTextField searchField;
    
    /**
     * Método constructor, contiene instrucciones sobre la ventana de la interfaz.
     * Hace llamados a métodos que crean componentes de la interfaz
     */
    public MainWindow(){
        deque = new Deque();
        setTitle("Cola doble");//Titulo de la ventana
        setSize(700, 600); //Tamaño de ventana
        setLocationRelativeTo(null); //Centrar la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Cerrar programa al dar "X"
        
        panelDeque = new JPanel();//inicializar un panel.
        panelDeque.setLayout(new BoxLayout(panelDeque, BoxLayout.Y_AXIS)); //Definir como se colocaran los componentes visualmente

        //llamado de métodos
        addComponents();
        createButtons(); 
    }
    
    /**
     * Este método contiene la estructura de componentes para solicitar, agregar elementos de la cola doble
     */
    private void addComponents(){
        
        //Componentes para mostrar la Deque
        JLabel dequeLabel = new JLabel("Estado actual de la cola doble:"); //Etiqueta para la cola doble
        showDequeArea = new JTextArea(10, 20); //Area de texto que permite mostrar las acciones referente a los nodos(añadir,eliminar)
        showDequeArea.setEditable(false); //No permite editar el cuadro por el usuario
        JScrollPane scrollPane = new JScrollPane(showDequeArea); //Si la Deque es muy extensa, permite scrolear la cola para ver todos los nodos

        //Componentes para solicitar número
        JLabel addLabel = new JLabel("Ingrese el valor que desea agregar:"); //Etiqueta para solicitar un número para agregar 
        valueField = new JTextField(20); //Cuadro de texto para agregar el número


        //Componentes para buscar número
        JLabel searchLabel = new JLabel("Ingrese el valor que desea buscar"); //Etiqueta para solicitar un número para buscar
        searchField = new JTextField(20); //Cuadro de texto para agregar el número
    
        
        //añadir componentes al panel
        panelDeque.add(dequeLabel); 
        panelDeque.add(scrollPane);
        panelDeque.add(addLabel);
        panelDeque.add(valueField);
        panelDeque.add(searchLabel);
        panelDeque.add(searchField);
        add(panelDeque);//agregar panel al JFrame
    }

    //Método para darle función a los botones y maneja errores
    private void createButtons(){
       
        //agregar botones
        JButton searchbButton = new JButton("Buscar");
         
        JButton pushFrontButton = new JButton("Encolar al frente"); //botón para encolar al frente un valor.
                pushFrontButton.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        String text = valueField.getText();//obtener el texto del cuadro de texto   
                        
                        try {
                            int value = Integer.parseInt(text);
                            deque.pushFront(value);
                            showDequeArea.setText(deque.printDeque());
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(pushFrontButton, "Esto no es un número entero, ingrese un número entero", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                });
                pushFrontButton.setBounds(158,109,97,25);
        


        
        //AUN NO FUNCIONA BIEN, AL AGREGAR EL NUMERO SE MUEVE TODO(CUADROS DE TEXTO, BOTONES, VERIFICAR ESTE ERROR)
        //VERIFICAR SI EL MANEJO DE EXCEPCIONES ESTA COMPLETO PARA ESTE BOTON
        //EL E DE ACTION LISTENER MUESTRA MENSAJE QUE NO SE ESTÁ USANDO, VERIFICAR EL POR QUÉ
        //VERIFICAR SI NO HACE FALTA ALGO EN EL LA COLA DEQUE QUE SEA NECESARIO PARA AQUI
        //MEJORAR DISEÑO DE PANEL
        

        JButton pushBackButton = new JButton("Encolar al final"); //botón para encolar al final un valor.
        JButton popFrontButton = new JButton("Desencolar al frente"); //botón para desencolar al inicio
        JButton popBackButton = new JButton("Desencolar al final"); //botón para desencolar al final.
        
        panelDeque.add(searchbButton);
        panelDeque.add(pushFrontButton);
        panelDeque.add(pushBackButton);
        panelDeque.add(popFrontButton);
        panelDeque.add(popBackButton);
        
    }

 
   
}
