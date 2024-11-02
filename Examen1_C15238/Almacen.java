


/*Esta clase inicializa la tabla estandar y almacena las tablas por su tamaño
 */
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
        tablas[indTabla] = new Tabla(4.0,6.0,24000.0);
        indTabla++;
    }
    
    //metodo para ordenar tablas
    public void ordenarTablas(){
        
    }
    
    
    //metodo para agregar tablas en el array tablas
    public void agregarTablas(double ancho, double largo,double precio){
        if(indTabla < tablas.length) {
            for(int i = 0;i < indTabla;i++){
                tablas[indTabla++] = new Tabla(ancho,largo, precio);
                
            }
            
        }
    }
    
    //mostrar info de las tablas
    public void mostrarTablas(int ancho, int largo){
        for(int i = 0; i<indTabla;i++){
            tablas[i].mostrarInfo();
        }
    }   
}
