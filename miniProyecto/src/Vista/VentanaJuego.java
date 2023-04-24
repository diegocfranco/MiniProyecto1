package Vista;

import modelo.Palabra;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import modelo.Jugador;

/**
 *
 * @author juandiego
 */
public class VentanaJuego  extends JFrame{
    
    
    private String palabra;
    private JLabel lblPalabraAdivinar;
    private JLabel lblPalabra;
    private JLabel lblNombre;
    private JLabel lblRonda;
    private JLabel lblFallos;
    private JLabel lblNumRonda;
    private JLabel lblNumFallos;
    private JLabel lblNombreJugador;
    private JLabel lblImagen;
    private JButton btnTerminar;
    private JButton btnA;
    private JButton btnE;
    private JButton btnI;
    private JButton btnO;
    private JButton btnU;
    private JPanel jpFondoJuego;
    private Palabra nuevaPalabra;
    private Jugador jugador;
    
    

    
    public VentanaJuego(Palabra palabra,Jugador elJugador){
        nuevaPalabra =palabra;
        jugador=elJugador; 
        initComponents();
  
    }
    public void initComponents(){
        
        setTitle("Fuga de vocales ");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(776,640);
        setLocationRelativeTo(null);
        setVisible(true); 
        setResizable(false);
        palabra = nuevaPalabra.getPalabra();
        
        lblImagen = new JLabel();
        lblImagen.setIcon(new ImageIcon("src/imagenes/"+palabra+".png"));
        lblImagen.setBounds(50, 130, 200, 200);
       
        
        //Configuración del Encabezado
        jpFondoJuego = new PanelConImagen("/imagenes/principal.png"); 
        jpFondoJuego.setSize(776,640);     
        jpFondoJuego.setLayout(null);
        add(jpFondoJuego);

        Toolkit miPantalla = Toolkit.getDefaultToolkit();
        palabra = nuevaPalabra.getPalabraSinVocal();


        lblPalabra =new JLabel();
        lblPalabraAdivinar =new JLabel(palabra);
        lblPalabraAdivinar.setHorizontalAlignment(SwingConstants.CENTER);
        lblPalabraAdivinar.setVerticalAlignment(SwingConstants.CENTER);

        lblPalabraAdivinar.setFont(new Font("arial", 3, 70)); 
        lblPalabraAdivinar.setForeground(new Color(0,0,0));
        lblPalabraAdivinar.setBounds(280,185, 450,80);

        lblNombre = new JLabel("Nombre del jugador:");
        lblNombre.setFont(new Font("arial", 3, 20)); 
        lblNombre.setForeground(Color.GRAY);
        lblNombre.setBounds(85,5, 200,40);

        lblRonda = new JLabel("Ronda :");
        lblRonda.setFont(new Font("arial", 3, 20)); 
        lblRonda.setForeground(Color.GRAY);
        lblRonda.setBounds(400,5, 200,40);

        lblFallos = new JLabel("Fallos:");
        lblFallos.setFont(new Font("arial", 3, 20)); 
        lblFallos.setForeground(Color.GRAY);
        lblFallos.setBounds(600,5, 200,40);

        lblNombreJugador = new JLabel(jugador.getNombre());
        lblNombreJugador.setFont(new Font("arial", 1, 50)); 
        lblNombreJugador.setForeground(new Color(0,0,0));
        lblNombreJugador.setBounds(35,20, 270,80);
        lblNombreJugador.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNombreJugador.setVerticalAlignment(SwingConstants.CENTER);

        lblNumFallos = new JLabel(jugador.getFallos()+"");
        lblNumFallos.setFont(new Font("arial", 3, 50)); 
        lblNumFallos.setForeground(new Color(0,0,0));
        lblNumFallos.setBounds(600,20, 80,80);

        lblNumRonda = new JLabel((jugador.getRonda())+"");
        lblNumRonda.setFont(new Font("arial", 3, 50)); 
        lblNumRonda.setForeground(new Color(0,0,0));
        lblNumRonda.setBounds(400,20, 80,80);


        btnTerminar = new JButton("Terminar juego");
        btnTerminar.setBounds(310,550, 150,35);
        btnA = new JButton("a");
        btnE = new JButton("e");
        btnI = new JButton("i");
        btnO = new JButton("o");
        btnU = new JButton("u");

        Image miIcono = miPantalla.getImage("/imagenes/icono.png");
        setIconImage(miIcono);

        lblPalabra.setIcon(new ImageIcon("/imagenes/Leon.jpg"));



        btnA.setFont(new Font("Verdana", 3, 80)); 
        btnA.setForeground(new Color(255, 0, 51));
        btnA.setBounds(35,350,110, 150);

        btnE.setFont(new Font("Verdana", 3, 80)); 
        btnE.setForeground(new Color(51, 153, 0));
        btnE.setBounds(185,400,110, 150);

        btnI.setFont(new Font("Verdana", 3, 80)); 
        btnI.setForeground(new Color(153, 153, 255));
        btnI.setBounds(325,350,110, 150);

        btnO.setFont(new Font("Verdana", 3, 80)); 
        btnO.setForeground(new Color(255, 153, 102));
        btnO.setBounds(475,400,110, 150);

        btnU.setFont(new Font("Verdana", 3, 80)); 
        btnU.setForeground(new Color(255, 204, 0));
        btnU.setBounds(625,350,110, 150);

        jpFondoJuego.add(btnA);
        jpFondoJuego.add(btnE);
        jpFondoJuego.add(btnI);
        jpFondoJuego.add(btnO);
        jpFondoJuego.add(btnU);
        jpFondoJuego.add(lblNombre);
        jpFondoJuego.add(lblRonda);
        jpFondoJuego.add(lblFallos);
        jpFondoJuego.add(lblNumRonda);
        jpFondoJuego.add(lblNumFallos);
        jpFondoJuego.add(lblNombreJugador);
        jpFondoJuego.add(btnTerminar);
        jpFondoJuego.add(lblPalabraAdivinar);
        jpFondoJuego.add(lblImagen);
       
        VentanaJuego.ManejadorDeEventos manejadorEventos = new VentanaJuego.ManejadorDeEventos();
        
        btnA.addActionListener(manejadorEventos);
        btnE.addActionListener(manejadorEventos);
        btnI.addActionListener(manejadorEventos);
        btnO.addActionListener(manejadorEventos);
        btnU.addActionListener(manejadorEventos);
        btnTerminar.addActionListener(manejadorEventos);
    }      

        class ManejadorDeEventos implements ActionListener, KeyListener{
            
        @Override
        public void actionPerformed(ActionEvent evento){
            if(evento.getSource() == btnA){ 
                if(nuevaPalabra.getVocal()=='a'){
                    lblPalabraAdivinar.setText(nuevaPalabra.getPalabraSinVocal());
                    lblImagen.setIcon(nuevaPalabra.getImagenPalabra());
                    jugador.setRonda();
                    lblNumRonda.setText(jugador.getRonda()+"");   
                }
                
                else{
                    jugador.setFallos();
                    lblNumFallos.setText((jugador.getFallos())+"");   
                }   
             }
            
            if(evento.getSource() == btnE){
                if(nuevaPalabra.getVocal()=='e'){
                    lblPalabraAdivinar.setText(nuevaPalabra.getPalabraSinVocal());
                    lblImagen.setIcon(nuevaPalabra.getImagenPalabra());
                    jugador.setRonda();
                    lblNumRonda.setText(jugador.getRonda()+"");      
                }
                
                else{
                    jugador.setFallos();
                    lblNumFallos.setText((jugador.getFallos())+"");   
                }
            }
            if(evento.getSource() == btnI){       
                if(nuevaPalabra.getVocal()=='i'){

                    lblPalabraAdivinar.setText(nuevaPalabra.getPalabraSinVocal());
                    lblImagen.setIcon(nuevaPalabra.getImagenPalabra());
                    jugador.setRonda();
                    lblNumRonda.setText(jugador.getRonda()+"");     
                }
                 else{
                    jugador.setFallos();
                    lblNumFallos.setText((jugador.getFallos())+"");   
                }
            }
            if(evento.getSource() == btnO){       
                if(nuevaPalabra.getVocal()=='o'){
                    lblPalabraAdivinar.setText(nuevaPalabra.getPalabraSinVocal());
                    lblImagen.setIcon(nuevaPalabra.getImagenPalabra());
                    jugador.setRonda();
                    lblNumRonda.setText(jugador.getRonda()+""); 
                }
                else{
                    jugador.setFallos();
                    lblNumFallos.setText((jugador.getFallos())+"");    
                }      
            }
            
            if(evento.getSource() == btnU){       
                if(nuevaPalabra.getVocal()=='u'){
                    lblPalabraAdivinar.setText(nuevaPalabra.getPalabraSinVocal());
                    lblImagen.setIcon(nuevaPalabra.getImagenPalabra());
                    jugador.setRonda();
                    lblNumRonda.setText(jugador.getRonda()+""); 
                }
                 else{
                    jugador.setFallos();
                    lblNumFallos.setText((jugador.getFallos())+"");   
                }
            }
            if(evento.getSource() == btnTerminar){       
                dispose();
                JOptionPane.showMessageDialog(rootPane,
                        """
                        Estadisticas:
                        Rondas Jugadas :"""+jugador.getRonda()+
                       "\nNumero de Fallos:"+jugador.getFallos()+
                       "\nporcentaje de fallos:"+(jugador.getFallos()*100)/(jugador.getRonda()+jugador.getFallos())+" %"+
                       "\nporcentaje de aciertos:"+(jugador.getRonda()*100)/(jugador.getRonda()+jugador.getFallos())+" % " );
                
                System.exit(0);
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