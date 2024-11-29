


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
        
        panelDeque = new JPanel();// Inicializar un panel.
        panelDeque.setLayout(new BoxLayout(panelDeque, BoxLayout.Y_AXIS)); // Definir como se colocaran los componentes visualmente

        // Llamado de métodos
        addComponents();
    }
    
    /**
     * Este método contiene la estructura de componentes para solicitar, agregar elementos de la cola doble
     */
    private void addComponents(){
        
        // Componentes para mostrar la Deque
        JLabel dequeLabel = new JLabel("Estado actual de la cola doble:"); // Etiqueta para la cola doble
        showDequeArea = new JTextArea(10, 20); // Area de texto que permite mostrar las acciones referente a los nodos(añadir,eliminar)
        showDequeArea.setEditable(false); // No permite editar el texto por el usuario
        JScrollPane scrollPane = new JScrollPane(showDequeArea); // Si la Deque es muy extensa, permite scrolear la cola para ver todos los nodos
 
        // Componentes para solicitar número
        JLabel addLabel = new JLabel("Ingrese el número entero que desea agregar:"); // Etiqueta para solicitar un número para agregar 
        valueField = new JTextField(20); // Cuadro de texto para agregar el número


        // Componentes para buscar número
        JLabel searchLabel = new JLabel("Ingrese el número entero que desea buscar"); // Etiqueta para solicitar un número para buscar
        searchField = new JTextField(20); // Cuadro de texto para agregar el número
    
        
        // Añadir componentes al panel
        panelDeque.add(dequeLabel); 
        panelDeque.add(scrollPane);
        panelDeque.add(addLabel);
        panelDeque.add(valueField);
        panelDeque.add(searchLabel);
        panelDeque.add(searchField);
        add(panelDeque);// Agregar panel al JFrame
    

    // Método para darle función a los botones y manejar errores
    
       
        // Agregar botones
        JButton searchButton = new JButton("Buscar");
        searchButton.addActionListener(e -> {
            String textSearch = searchField.getText();
            
            try {
                int searchValue = Integer.parseInt(textSearch); // Convertir el texto númerico a int
                if(deque.searchDeque(searchValue)){ // El método evalua si el número se encuentra en la cola
                    JOptionPane.showMessageDialog(null, "El número " +  searchValue + " se encuentra en la cola"); // El número está en la cola
                }else{
                    JOptionPane.showMessageDialog(null, "El número " +  searchValue + " no se encuentra en la cola"); // El número no está en la cola
                }
                searchField.setText("");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(panelDeque, "Ingrese el número que desea buscar", "No se puede buscar", JOptionPane.ERROR_MESSAGE ); // La cola está vacía o hay valores ingresados inválidos
            }

        });

        panelDeque.add(searchButton); // Añadir el botón al panel
        
        // botón para encolar un frente al nodo
        JButton pushFrontButton = new JButton("Encolar al frente"); 
        pushFrontButton.addActionListener(e -> {
            String text = valueField.getText();//obtener el texto del cuadro de texto   
            
            // Manejo excepcion, si se ingresa un valor que no es un numero entero           
            try {
                int valueFront = Integer.parseInt(text); //convertir texto a entero, si es posible
                deque.pushFront(valueFront); //Encolar al frente, llama al método de Deque
                showDequeArea.setText(deque.printDeque()); //Muestra el valor encolado en el textArea
                valueField.setText(""); //Borrar el contenido después de realizar la acción
            } catch (Exception ex) { 
                JOptionPane.showMessageDialog(panelDeque, "Debe ingresar un número entero", "Error al encolar", JOptionPane.ERROR_MESSAGE);
            }
        });
        panelDeque.add(pushFrontButton); // Agregar el botón al panel

        // Botón para encolar un nodo al final de la cola
        JButton pushBackButton = new JButton("Encolar al final"); //botón para encolar al final un valor.
        pushBackButton.addActionListener(e ->{ 
            String text = valueField.getText();// Obtener el texto

            // Manejo de excepción, si el texto puede ser convertido a int continúa el bloque, si no salta a la excepción
            try {
                int valueBack = Integer.parseInt(text); // Convertir text a 

                deque.pushBack(valueBack); //Encolar atrás, llamado del método pushBack
                showDequeArea.setText(deque.printDeque()); //Mostrar la cola actualizada con el nodo encolado
                valueField.setText("");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(panelDeque, "Debe ingresar un número entero", "Error al encolar", JOptionPane.ERROR_MESSAGE );
            } 
        });
        panelDeque.add(pushBackButton); // Agregar botón al panel


        // Botón para desencolar al inicio de la cola y acción
        JButton popFrontButton = new JButton("Desencolar al frente"); 
        popFrontButton.addActionListener(e ->{ 
            try {
                deque.popFront(); // llamar al método para eliminar el último nodo de la cola
                showDequeArea.setText(deque.printDeque()); // mostrar los cambios de la cola
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(panelDeque, "Ingrese valores en la cola para completar esta acción", "Error al desencolar", JOptionPane.ERROR_MESSAGE );
            }     
        });
        panelDeque.add(popFrontButton); // Agregar botón al panel

        // Botón para desencolar al final y acción.
        JButton popBackButton = new JButton("Desencolar al final"); //botón para desencolar al final.
        popBackButton.addActionListener(e -> {
            try {
                deque.popBack(); // llama al método para eliminar el primer nodo de la cola
                showDequeArea.setText(deque.printDeque()); // muestra la cola actual
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(panelDeque, "Ingrese valores en la cola para completar esta acción", "Error al desencolar", JOptionPane.ERROR_MESSAGE );
            }
        }); 
        panelDeque.add(popBackButton); // Agregar botón al panel

       

        // COSAS POR CORREGIR...
        // EL CODIGO FUNCIONA DE MANERA BASICA, HAY ERRORES QUE AUN NO SE MANEJAN, A PESAR QUE EL PROGRAMA NO SE CAE, NO SON MANEJADOS DE MANERA ESPECIFICA ESOS ERRORES
        // AUN FALTA QUE EL BOTON DE BUSQUEDA FUNCIONE
        // DEBERIA AGREGAR UN BOTON PARA BORRAR LA COLA COMPLETA DE UNA VEZ? O MAS BIEN IMPLEMENTARLO COMO: VACIAR TODA LA COLA?
        // DEBERIA AÑADIR PESTAÑAS PARA CERRAR EL PROGRAMA
        // DEBERIA ALMACENAR LA COLA EN UN ARCHIVO?
        // ERRORES QUE AUN SE MANTIENEN: NO MOSTRAR UN MENSAJE SI SE INTENTA BORRAR UN NODO SI LA COLA ESTA VACIA, CUANDO SE AGREGA NODOS CON ESPACIOS Y SÍ HAY UN NUMERO NO SE LOGRA AGREGAR
        // EL DISEÑO NO ES TAN BUENO, DEBO MEJORARLO. NO SE SI MANEJAR POSICIONES PERSONALIZADAS O COMO, BUSCAR SOBRE FORMAS DE ORDENAR EL DISEÑO DE PANEL
        // AUN SE MANTIENE LOS MENSAJES DE QUE NO SE USA EL EVENTE E, COMO PUEDO CORREGIR ESO, AFECTA EL PROGRAMA?
                
    }

}
