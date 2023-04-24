package modelo;
/**
 *
 * @author juandiego
 */
public class Jugador {
    
    //declaracion de atributos 
    private String nombre;
    private int ronda;
    private int fallos;

    //metodos constructores
    
        public Jugador(){
        nombre = "Jugador";
        ronda=1;
        fallos=0;
    }
    
    public Jugador(String nombre){
        this.nombre = nombre;
        ronda=1;
        fallos=0;
    }
    
    //netidis getter
    public int getRonda() {
        return ronda;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public int getFallos() {
        return fallos;
    }
    
    //metodos setter
    public void setRonda() {
        ronda ++;
    }
    
    public void setFallos() {
        fallos ++;
    }
  
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}