import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

import javax.swing.*;

public class CreandoMarcos {

	public static void main(String[] args) {
		MiMarco marco1=new MiMarco();
		marco1.setVisible(true);
		marco1.setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

}

class MiMarco extends JFrame{
	
	public MiMarco(){
		//setSize(250,250);
		//setLocation(835,415);
		setBounds(835,415, 250, 250); // Setea las dos, Location y Size.
		//setResizable(false); // true por defecto
		//setExtendedState(Frame.MAXIMIZED_BOTH); //La pantalla aparece maximizada
		setTitle("Mi ventana");
		
	}
	
	
}