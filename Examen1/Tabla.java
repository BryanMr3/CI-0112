
//
public class Tabla
{
    private double ancho;
    private double largo;
    private double precio;
    
    //constructor
    public Tabla(double ancho, double largo, double precio){
        this.ancho = ancho;
        this.largo = largo;
        this.precio = precio;
    }
    
    //setters
    public void setAncho(double ancho){
        this.ancho = ancho;
    }
    
    public void setLargo(double largo){
        this.largo = ancho;
    }
    
    public void setPrecio(double precio){
        this.precio = precio;
    }
    
    //getters
    public double getAncho(){
        return ancho;
    }
    
    public double getLargo(){
        return largo;
    }
    
    public double getPrecio(){
        return precio;
    }
    
    //metodo para calcular la dimensión de la tabla
    public double calcDimension(){
        return ancho * largo;
    }

    //metodo para calcular el precio de la tabla
    public double calcPrecio(){
        double preciom2 = 1000.0;
        double precio = calcDimension() * preciom2;
        return precio;
    }
    
    //metodo para mostrar la informacion de una tabla
    public void mostrarInfo(){
        System.out.println("ancho: " + this.ancho + "largo: "+ this.largo
        + "precio: " + precio );
    }
    
    
}
 
