import javax.swing.*;

public class VentanaPrincipal extends JFrame{
    //constructor de la clase
    public VentanaPrincipal(){
        setTitle("Formulario de Usuario");//Establece el titulo de la ventana.
        setSize(400, 300);//Establece el tamaño de la ventana.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Operacion a realizar cuando cierre la ventana
        setLocationRelativeTo(null);//centrar la ventana
        
        //Creación barra de menú
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
        
        
    }
    
    public void main(String[]args){
        VentanaPrincipal ventana = new VentanaPrincipal();
        ventana.setVisible(true); //Mostrar la ventana
    }
}

