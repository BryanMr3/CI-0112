

public class Almacen
{
    private Tabla[] tablas;
    private int indTabla; //indice que indique la pos de cada tabla
    
    //constructor, se inicializa con el espacio disponible para guardar tablas
    public Almacen(){
        this.tablas = new Tabla[500];
        this.indTabla = 0;
    }
    
    //setters
    public void setTablas(Tabla[] tablas){
        this.tablas = tablas;
    }
    
    public void setIndTabla(int indTabla){
        this.indTabla = indTabla;
    }
    
    //getters
    public Tabla[] getTabla(){
        return tablas;
    }
    
    public int getIndTabla(){
        return indTabla;
    }
    
    //metodo para crear la tabla estandar y asignarle la posicion
    private void tablaEstandar(){
        tablas[indTabla] = new Tabla(4,6,24000);
        indTabla++;
    }
    
    //metodo para agregar tablas en el array tablas
    public void agregarTablas(){
        
    }
    
    //mostrar info de las tablas
    public void mostrarTablas(){
        for(int i = 0; i<indTabla;i++){
            tablas[i].mostrarInfo();
        }
    }   
}
