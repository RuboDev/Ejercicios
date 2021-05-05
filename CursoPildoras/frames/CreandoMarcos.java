import java.awt.Frame;
import javax.swing.*;

public class CreandoMarcos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		miMarco marco1=new miMarco();
		marco1.setVisible(true);
		marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

class miMarco extends JFrame{
	
	public miMarco(){
		//setSize(250,250);
		//setLocation(835,415);
		setBounds(835,415, 250, 250); // Setea las dos, Location y Size.
		//setResizable(false); // true por defecto
		//setExtendedState(Frame.MAXIMIZED_BOTH); //La pantalla aparece maximizada
		setTitle("Mi ventana");
		
	}
	
	
}