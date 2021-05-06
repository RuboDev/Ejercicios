import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

import java.awt.*;
import javax.swing.*;

public class CreandoMarcoCentrado {
	public static void main(String[] args) {
		MarcoCentrado marco2=new MarcoCentrado();
		marco2.setVisible(true);
		marco2.setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

}

class MarcoCentrado extends JFrame{
	
	public MarcoCentrado() {
		Toolkit mipantalla = Toolkit.getDefaultToolkit();
		Dimension tamanoPantalla=mipantalla.getScreenSize();
		int alturaPantalla=tamanoPantalla.height;
		int anchoPantalla=tamanoPantalla.width;
		
	    setLocation(anchoPantalla/4 , alturaPantalla/4);
	    setSize(anchoPantalla/2, alturaPantalla/2);
	    
	    setTitle("Marco Centrado");
	    
	    Image miIcono = mipantalla.getImage("src/resources/iconos/icono.png");
	    setIconImage(miIcono);
	}
}