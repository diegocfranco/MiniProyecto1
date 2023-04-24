package Vista;

import modelo.Palabra;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import modelo.Jugador;


public final class VentanaCategoria extends JFrame {
    
    
    private PanelConImagen jpnCategoria;
    private JButton btnAnimales; 
    private JButton btnComidas;
    private JButton btnProfesiones; 
    private JButton btnTodas;
    private Jugador jugador;
    
    public VentanaCategoria(Jugador jugador){
        this.jugador=jugador;
        iniciarComponentes();
    }
    
    public void iniciarComponentes(){
        //Configuración de la ventana
        setTitle("Adivinador");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,600);
        setLocationRelativeTo(null);
        setVisible(true); 
        setResizable(false);
 
        Toolkit miPantalla = Toolkit.getDefaultToolkit();
        
        
        //Configuración del Encabezado
        jpnCategoria = new PanelConImagen("/imagenes/categoria.png"); 
        jpnCategoria.setSize(600,600);     
        jpnCategoria.setLayout(null);
        add(jpnCategoria);
        
        Image miIcono = miPantalla.getImage("src/imagenes/buscaVocales.png");
	setIconImage(miIcono);
                
        btnAnimales = new JButton("Animales");
        btnAnimales.setBounds(230,230, 150,40);
        
        btnComidas = new JButton("Comidas");
        btnComidas.setBounds(230,280, 150,40);
        
        btnProfesiones = new JButton("Profesiones");
        btnProfesiones.setBounds(230,330, 150,40);
        
        btnTodas = new JButton("Todas");
        btnTodas.setBounds(230,380, 150,40);
        
                              
        jpnCategoria.add(btnAnimales);
        jpnCategoria.add(btnComidas);
        jpnCategoria.add(btnProfesiones);
        jpnCategoria.add(btnTodas);
       VentanaCategoria.ManejadorDeEventos manejadorEventos = new VentanaCategoria.ManejadorDeEventos();
        
        btnAnimales.addActionListener(manejadorEventos);
        btnComidas.addActionListener(manejadorEventos);
        btnProfesiones.addActionListener(manejadorEventos);
        btnTodas.addActionListener(manejadorEventos);
    }      

        class ManejadorDeEventos implements ActionListener, KeyListener{
            
        @Override
        public void actionPerformed(ActionEvent evento){
            if(evento.getSource() == btnAnimales){ 
                dispose();
                Palabra nuevaPalabra = new Palabra();
                nuevaPalabra.setListaPalabrasAnimles();
                VentanaJuego nuevoJuego = new VentanaJuego(nuevaPalabra,jugador);
            }
            else if(evento.getSource() == btnComidas){
                dispose();                
                Palabra nuevaPalabra = new Palabra();
                nuevaPalabra.setListaPalabrasComidas();
                VentanaJuego nuevoJuego = new VentanaJuego(nuevaPalabra,jugador);
            }
            else if(evento.getSource() == btnProfesiones){       
                dispose();
                Palabra nuevaPalabra = new Palabra();
                nuevaPalabra.setListaPalabrasProfesiones();
                VentanaJuego nuevoJuego = new VentanaJuego(nuevaPalabra,jugador);                
            }
                else if(evento.getSource() == btnTodas){       
                dispose();
                Palabra nuevaPalabra = new Palabra();
                nuevaPalabra.setListaPalabrasTodas();
                VentanaJuego nuevoJuego = new VentanaJuego(nuevaPalabra,jugador);  
        }
        }
        @Override
        public void keyReleased(KeyEvent e) {
           /* System.out.println("Se liberó la tecla " + e.getKeyChar() +
                    " Con codigo " + e.getKeyCode());*/

        }
        
        @Override
        public void keyPressed(KeyEvent e) {
            /*System.out.println("Se presionó la tecla " + e.getKeyChar()+
                    " Con codigo " + e.getKeyCode());*/
            
        }
        
        @Override
        public void keyTyped(KeyEvent e) {
            /*System.out.println("Se digitó la tecla " + e.getKeyChar()+
                    " Con codigo " + e.getKeyCode());*/
        }
               
    }
}   

       


