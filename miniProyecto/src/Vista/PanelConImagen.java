package Vista;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Admin
 */
class PanelConImagen extends JPanel{
    ImageIcon imagen;
    String nombre;
    
    public PanelConImagen(String nombre){
        this.nombre = nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    @Override
    public void paint(Graphics g){
        imagen = new ImageIcon(getClass().getResource(nombre));
        g.drawImage(imagen.getImage(), 0, 0, null);
        setOpaque(false);
        super.paint(g);
    }
}