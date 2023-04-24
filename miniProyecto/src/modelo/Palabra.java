/*
 * Here comes the text of your license
 * Each line should be prefixed with  * 
 */
package modelo;


import javax.swing.ImageIcon;

/**
 *
 * @author juandiego
 */
public class Palabra {
    private char vocal;
    private int indicePalabra;
    private String [] listaPalabras;
    private ImageIcon ImagenPalabra;

    public ImageIcon getImagenPalabra() {
        return ImagenPalabra;
    }

 
    
    private final String  comidas[] = { "aguacate","arroz","batata","berenjena",
                                        "brocoli","calabaza","champiñon","col rizada",
                                        "esparragos","limon","maiz","mango",
                                        "manzana","naranja","pimenton","rabano",
                                        "sandia","te verde","tomate","zanahoria"};
    
    private final String  animales[]= { "abeja","cangrejo","cerdo","conejo",
                                        "elefante","escarabajo","gato","hipopotamo",
                                        "leon","llama","loro","oveja",
                                        "paloma","panda","perro","pez payaso",
                                        "pollo","rana","raton","vaca"};
    
    private final String profesiones[]={"artista","barista","beisbolista","bioquimico",
                                        "botanico","boxeador","cantante","contador",
                                        "dentista","florista","fontanero","fotografo",
                                        "granjero","ingeniero","jugador","cirujano",
				        "panadero","call center","tenista","zapatero",};
    
    private final String todoEnUno[]={ "aguacate","arroz","batata","berenjena",
                                        "brocoli","calabaza","champiñon","col rizada",
                                        "esparragos","limon","maiz","mango",
                                        "manzana","naranja","pimenton","rabano",
                                        "sandia","te verde","tomate","zanahoria",
                                        "abeja","cangrejo","cerdo","conejo",
                                        "elefante","escarabajo","gato","hipopotamo",
                                        "leon","llama","loro","oveja",
                                        "paloma","panda","perro","pez payaso",
                                        "pollo","rana","raton","vaca","artista",
                                        "barista","beisbolista","bioquimico",
                                        "botanico","boxeador","cantante","contador",
                                        "dentista","florista","fontanero","fotografo",
                                        "granjero","ingeniero","jugador","neurocirujano",
				        "panadero","servicio al cliente","tenis","zapatero"};
    
    public Palabra(){
        
  
    }
    public String getPalabraSinVocal(){
        String nueva;
        
        nueva =quitaVocal(listaPalabras[indicePalabra]);
        ImagenPalabra= new ImageIcon("src/imagenes/"+listaPalabras[indicePalabra]+".png");
            if (indicePalabra < listaPalabras.length - 1 ){
                indicePalabra++;    
            }
            else{
                indicePalabra=(int) ((Math.random() * 19));
            }
        return nueva;
    }
    
    public String getPalabra(){
        String palabra;
        palabra =listaPalabras[indicePalabra];
        
        return palabra;
    }
    
    private int cuentaVocales(String palabra){
       
        int vocales = 0;
        for (int i = 0; i < palabra.length(); i++){
            
            char letraActual = palabra.charAt(i);
            if (esVocal(letraActual)) vocales++;
        }
        return vocales;
    }
    
   private  String quitaVocal(String palabra){
       
        String nuevaPalabra="";
        int vocales=cuentaVocales(palabra);
        int vocalEliminar =(int) ((Math.random() * vocales)+1);
        int contadorVocales=0;
   
        
        for (int i = 0;i<palabra.length();i++){
            
            if(esVocal(palabra.charAt(i))){ contadorVocales++;}      
            
            if((contadorVocales==vocalEliminar)&&(esVocal(palabra.charAt(i)))){
                vocal=palabra.charAt(i);
                nuevaPalabra+="_";
            }
            else{
                
                nuevaPalabra+=palabra.charAt(i);
            }
        }
       
        return nuevaPalabra;
    }
   
   
   
   
    private static boolean esVocal(char letra) {
        
        return "aeiou".contains(String.valueOf(letra).toLowerCase());
    }


    public char getVocal(){
        
        return vocal;
        
    }

    public void setListaPalabrasComidas() {
        
        listaPalabras = comidas; 
    
    }
    
    public void setListaPalabrasAnimles() {
        
        listaPalabras = animales; 
    
    }
    
        public void setListaPalabrasProfesiones() {
        
        listaPalabras = profesiones; 
    
    }

        public void setListaPalabrasTodas(){
        listaPalabras = todoEnUno; 
    
    }

    
    
    
    
    
    
}
                                        