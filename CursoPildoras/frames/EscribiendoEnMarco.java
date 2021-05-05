import javax.swing.*;
import java.awt.*;

public class EscribiendoEnMarco {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoConTexto mimarco=new MarcoConTexto();
		mimarco.setVisible(true);
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}

class MarcoConTexto extends JFrame{
	public MarcoConTexto() {
		Toolkit mipantalla = Toolkit.getDefaultToolkit();
	    setLocation(400, 200);
	    setSize(600,450);
	    setTitle("primer texto");
	    
	    Image miIcono = mipantalla.getImage("src/resources/iconos/icono.png");
	    setIconImage(miIcono);
	    
	    Lamina milamina=new Lamina();//Instanciamos la lámina desde el constructor del marco
	    this.add(milamina);
	    add(milamina);
	}
}

class Lamina extends JPanel{
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawString("Estamos aprendiendo Swing", 100, 100);
	}
}