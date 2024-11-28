

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        setTitle("Cola doble");//titulo de la ventana
        setSize(700, 600); //Establece el tamaño de ventana
        setLocationRelativeTo(null); //Centra la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Cerrar programa al dar "X"
        
        panelDeque = new JPanel();//inicializar un panel.
        panelDeque.setLayout(new BoxLayout(panelDeque, BoxLayout.Y_AXIS));

        
        addComponents(); //llamar método que crea componentes
        createButtons();
    }
    
    /**
     * Este método contiene elementos agregados
     */
    private void addComponents(){
        //agregar etiquetas
        JLabel dequeLabel = new JLabel("Estado actual de la cola doble:");
        
        showDequeArea = new JTextArea();
        showDequeArea.setEditable(false); //detener que se pueda agregar algo en el dequeShow, ya que se usará para mostrar la cola
        JScrollPane scrollPane = new JScrollPane(showDequeArea);

        JLabel addLabel = new JLabel("Ingrese el valor que desea agregar:"); 
        JLabel searchLabel = new JLabel("Ingrese el valor que desea buscar");
                
        //agregar cuadro de texto
        valueField = new JTextField(20);
        searchField = new JTextField(20);
    
        //añadir componentes al panel
        panelDeque.add(dequeLabel);
        panelDeque.add(showDequeArea);
        panelDeque.add(scrollPane);
        panelDeque.add(addLabel);
        panelDeque.add(valueField);
        panelDeque.add(searchLabel);
        panelDeque.add(searchField);
        add(panelDeque);//agregar panel al JFrame
    }

    private void createButtons(){
       
        //agregar botones
        JButton searchbButton = new JButton("Buscar");
         
        JButton pushFrontButton = new JButton("Encolar al frente"); //botón para encolar al frente un valor.
        pushFrontButton.addActionListener(e->{
            String text = valueField.getText();//obtener el texto del cuadro de texto   
            
            //manejo de excepcion, si al colocar un dato diferente de un entero muestra un mensaje de que no es un numero, que ingrese un numero
            try {
                int value = Integer.parseInt(text); //convertir este texto a entero
                deque.pushFront(value);
                showDequeArea.setText(deque.printDeque()); //agregar al area de texto el número, pero lo convierte a String
                
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(pushFrontButton, "Esto no es un número, Ingrese un número", "pene", JOptionPane.ERROR_MESSAGE);
            }
        });
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
