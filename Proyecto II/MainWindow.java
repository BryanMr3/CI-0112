import javax.swing.*;

/**
 * Esta clase contiene los metodos necesarios para la creación de la interfaz gráfica
 */
public class MainWindow extends JFrame {
    private JPanel panelDeque;
    /**
     * Método constructor, contiene instrucciones sobre la ventana de la interfaz.
     * Hace llamados a métodos que crean componentes de la interfaz
     */
    public MainWindow(){
        
        setTitle("Cola doble");//titulo de la ventana
        setSize(600, 600); //Establece el tamaño de ventana
        setLocationRelativeTo(null); //Centra la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Cerrar programa al dar "X"
        
        panelDeque = new JPanel();//inicializar un panel, está afuera para poder separar métodos.
        panelDeque.setLayout(new BoxLayout(panelDeque,BoxLayout.Y_AXIS));
        addComponents(); //llamar método que crea componentes
    }
    
    /**
     * Este método contiene
     */
    private void addComponents(){
        //agregar etiquetas
        JLabel addLabel = new JLabel("Ingrese el valor que desea agregar:"); 
        JLabel searchLabel = new JLabel("Ingrese el valor que desea buscar");
        
        //agregar cuadro de texto
        JTextField valueField = new JTextField(20); 
        JTextField searchField = new JTextField(20);
        
        //agregar botones
        JButton pushFrontButton = new JButton("Encolar al frente"); //botón para encolar al frente un valor.
        JButton pushBackButton = new JButton("Encolar al final"); //botón para encolar al final un valor.
        JButton popFrontButton = new JButton("Desencolar al frente"); //botón para desencolar al inicio
        JButton popBackButton = new JButton("Desencolar al final"); //botón para desencolar al final.

    
        //añadir componentes al panel
        panelDeque.add(addLabel);
        panelDeque.add(valueField);
        panelDeque.add(searchLabel);
        panelDeque.add(searchField);
        
        panelDeque.add(pushFrontButton);
        panelDeque.add(pushBackButton);
        panelDeque.add(popFrontButton);
        panelDeque.add(popBackButton);

        add(panelDeque);//agregar panel al JFrame
        

        
        



    }



    
}
