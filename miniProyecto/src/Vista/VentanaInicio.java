package Vista;

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
import modelo.Palabra;


public final class VentanaInicio extends JFrame {
    
    
    private PanelConImagen jpFondoInicio;
    private JLabel jlNombre;
    private JTextField txtNombre;
    private JButton btnIngresar; 
    private JButton btnAyuda;
    
    public VentanaInicio(){
        iniciarComponentes();
    }
    
    private void iniciarComponentes(){
        //Configuración de la ventana
        setTitle("Fuga de vocales ");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,600);
        setLocationRelativeTo(null);
        setVisible(true); 
        setResizable(false);
 
        Toolkit miPantalla = Toolkit.getDefaultToolkit();
        
        
        //Configuración del Encabezado
        jpFondoInicio = new PanelConImagen("/imagenes/FugaDeVocales.png"); 
        jpFondoInicio.setSize(600,600);     
        jpFondoInicio.setLayout(null);
        add(jpFondoInicio);
        
        
        jlNombre = new JLabel("Ingresa tu nombre",SwingConstants.CENTER );
        
        Image miIcono = miPantalla.getImage("src/imagenes/icono.png");
	setIconImage(miIcono);
               
        jlNombre.setBounds(90,400, 400,35);
        jlNombre.setForeground(Color.WHITE);
        jlNombre.setFont(new Font("arial", Font.BOLD, 20)); 
                
        btnIngresar = new JButton("Iniciar Juego");
        btnIngresar.setBounds(170,510, 120,35);
        
        btnAyuda = new JButton("Intrucciones");
        btnAyuda.setBounds(300,510, 120,35);
                        
        txtNombre = new JTextField("");
        txtNombre.setHorizontalAlignment(JTextField.CENTER);
        txtNombre.setForeground(Color.GRAY);
        txtNombre.setFont(new Font("arial", Font.BOLD, 20)); 
        txtNombre.setBounds(170,455,250, 40);
        
        jpFondoInicio.add(txtNombre);
        jpFondoInicio.add(jlNombre);
        jpFondoInicio.add(btnIngresar);
        jpFondoInicio.add(btnAyuda);
        
        ManejadorDeEventos manejadorEventos = new ManejadorDeEventos();
        
        btnIngresar.addActionListener(manejadorEventos);
        btnAyuda.addActionListener(manejadorEventos);
        txtNombre.addKeyListener(manejadorEventos);
        
        txtNombre.requestFocusInWindow();
        
}
    
    private void iniciarJuego(){
        String nombre =txtNombre.getText();
        if(!nombre.trim().isEmpty() || nombre.trim().length() > 0){
            Jugador jugador = new Jugador(nombre); 
            dispose();  
            VentanaCategoria nuevaVentanaCategoria = new VentanaCategoria(jugador);
          
        } 
        else {
            JOptionPane.showMessageDialog(null,"Por favor ingrese su nombre", 
                    "Advertencia", JOptionPane.ERROR_MESSAGE);
            txtNombre.requestFocusInWindow();
        }
    }    
    
    
    
            class ManejadorDeEventos implements ActionListener, KeyListener{
        @Override
        public void actionPerformed(ActionEvent evento){
            if(evento.getSource() == btnIngresar){                
                iniciarJuego();
            }
            if(evento.getSource() == btnAyuda){                
                JOptionPane.showMessageDialog(rootPane, """
                                                        Hemos tenido una fuga de vocales que se han
                                                         escapado ¿Nos ayudas a encontrarlas? """);
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
       


