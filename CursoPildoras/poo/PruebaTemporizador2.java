import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.Timer;
import java.awt.Toolkit;

public class PruebaTemporizador2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Reloj mireloj=new Reloj();
		mireloj.enMarcha(3000, true);
		
		JOptionPane.showMessageDialog(null, "Pulsa Ok para terminar");
		System.exit(0);

	}

}

class Reloj{

	/*public Reloj(int intervalo, final boolean sonido) {	
		this.intervalo=intervalo;
		this.sonido=sonido;
	}*/
	
	public void enMarcha(int intervalo, boolean sonido) {
		
		class DameLaHora2 implements ActionListener{//Clase interna local

			public void actionPerformed(ActionEvent evento) {
				
				Date ahora=new Date();
				
				System.out.println("Te pongo la hora cada 3 seg: "+ahora);
				if(sonido) {
					Toolkit.getDefaultToolkit().beep();
				}	
				
			}
			
		}
		
		ActionListener oyente=new DameLaHora2();
		
		Timer mitemporizador=new Timer(intervalo, oyente);
		mitemporizador.start();
		
		
	}
	
	
}
