package usothreads;

import java.awt.geom.*;
import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;

public class UsoThreads {
	public static void main(String[] args) {
		JFrame marco = new MarcoRebote();
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		marco.setVisible(true);
	}
}

class PelotaHilos implements Runnable {
	private Pelota pelota;
	private Component componente;

	public PelotaHilos(Pelota unaPelota, Component unComponente) {
		pelota = unaPelota;
		componente = unComponente;
	}

	@Override
	public void run() {
		System.out.println("Estado del hilo al comenzar: " + Thread.currentThread().isInterrupted());
		// for (int i = 1; i <= 3000; i++) {
		// while (!Thread.interrupted()) {
		while (!Thread.currentThread().isInterrupted()) {
			pelota.mueve_pelota(componente.getBounds());
			componente.paint(componente.getGraphics());

			try {
				Thread.sleep(4);
			} catch (InterruptedException e) { //
				// e.printStackTrace();
				// System.out.println("Hilo bloqueado. Imposible su interrupción");
				Thread.currentThread().interrupt();
			}

		}
		System.out.println("Estado del hilo al terminar " + Thread.currentThread().isInterrupted());
	}
}

// Movimiento de la
// pelota-----------------------------------------------------------------------------------------

class Pelota {
	private static final int TAMX = 15;
	private static final int TAMY = 15;
	private double x = 0;
	private double y = 0;
	private double dx = 1;
	private double dy = 1;

	// Mueve la pelota invirtiendo posici�n si choca con l�mites
	public void mueve_pelota(Rectangle2D limites) {
		x += dx;
		y += dy;

		if (x < limites.getMinX()) {
			x = limites.getMinX();
			dx = -dx;
		}

		if (x + TAMX >= limites.getMaxX()) {
			x = limites.getMaxX() - TAMX;
			dx = -dx;
		}

		if (y < limites.getMinY()) {
			y = limites.getMinY();
			dy = -dy;
		}

		if (y + TAMY >= limites.getMaxY()) {
			y = limites.getMaxY() - TAMY;
			dy = -dy;
		}
	}

	// Forma de la pelota en su posici�n inicial

	public Ellipse2D getShape() {
		return new Ellipse2D.Double(x, y, TAMX, TAMY);
	}
}

// L�mina que dibuja las
// pelotas----------------------------------------------------------------------

class LaminaPelota extends JPanel {
	private ArrayList<Pelota> pelotas = new ArrayList<Pelota>();

	// A�adimos pelota a la l�mina
	public void add(Pelota b) {
		pelotas.add(b);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;

		for (Pelota b : pelotas) {
			g2.fill(b.getShape());
		}
		// Asegura que el objeto gráfico se actualiza
		Toolkit.getDefaultToolkit().sync();
	}
}

// Marco con l�mina y
// botones------------------------------------------------------------------------------

class MarcoRebote extends JFrame {
	private LaminaPelota lamina;
	Thread hilo1, hilo2, hilo3;
	JButton arranca1, arranca2, arranca3, detener1, detener2, detener3;

	public MarcoRebote() {
		setBounds(600, 300, 800, 350);
		setTitle("Rebotes");

		lamina = new LaminaPelota();
		add(lamina, BorderLayout.CENTER);

		JPanel laminaBotones = new JPanel();

		arranca1 = new JButton("Hilo1");
		arranca1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				comienza_el_juego(e);
			}
		});
		laminaBotones.add(arranca1);

		arranca2 = new JButton("Hilo2");
		arranca2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				comienza_el_juego(e);
			}
		});
		laminaBotones.add(arranca2);

		arranca3 = new JButton("Hilo3");
		arranca3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				comienza_el_juego(e);
			}
		});
		laminaBotones.add(arranca3);

		detener1 = new JButton("Deten1");
		detener1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				detener(e);
			}
		});
		laminaBotones.add(detener1);

		detener2 = new JButton("Deten2");
		detener2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				detener(e);
			}
		});
		laminaBotones.add(detener2);

		detener3 = new JButton("Deten3");
		detener3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				detener(e);
			}
		});
		laminaBotones.add(detener3);

		add(laminaBotones, BorderLayout.SOUTH);
	}

	// A�ade pelota y la bota 1000 veces
	public void comienza_el_juego(ActionEvent e) {
		Pelota pelota = new Pelota();
		lamina.add(pelota);

		Runnable r = new PelotaHilos(pelota, lamina);

		// Arranca hilo de ejecucion segun el boton pulsado
		if (e.getSource().equals(arranca1)) {
			hilo1 = new Thread(r);
			hilo1.start();
		} else if (e.getSource().equals(arranca2)) {
			hilo2 = new Thread(r);
			hilo2.start();
		} else if (e.getSource().equals(arranca3)) {
			hilo3 = new Thread(r);
			hilo3.start();
		}
	}

	// Detiene hilo de ejecucion segun el boton pulsado
	public void detener(ActionEvent e) {
		// hilo1.stop(); (obsoleto/deprected)

		if (e.getSource().equals(detener1)) {
			hilo1.interrupt();
		} else if (e.getSource().equals(detener2)) {
			hilo2.interrupt();
		} else if (e.getSource().equals(detener3)) {
			hilo3.interrupt();
		}
	}
}
