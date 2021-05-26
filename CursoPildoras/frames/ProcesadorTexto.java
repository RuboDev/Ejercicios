import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ProcesadorTexto {
    public static void main(String[] args) {
        MarcoProcesador marco = new MarcoProcesador();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class MarcoProcesador extends JFrame {
    public MarcoProcesador() {
        setTitle("Mi procesador de Textos");
        setBounds(500, 300, 800, 600);
        LaminaProcesador lamina = new LaminaProcesador();
        add(lamina);
        setVisible(true);
    }
}

class LaminaProcesador extends JPanel {

    JMenu fuentes, size;
    JMenuItem fuenteItem, sizeItem;
    JTextArea areaTexto;
    int textstyle, textsize;
    String textfuente;

    public LaminaProcesador() {
        setLayout(new BorderLayout());

        JPanel barraPanel = new JPanel();

        JMenuBar barra = new JMenuBar();
        fuentes = new JMenu("Fuentes");
        JMenu estilos = new JMenu("Estilos");
        size = new JMenu("Tamaño");
        barra.add(fuentes);
        barra.add(estilos);
        barra.add(size);

        JMenuItem negrita = new JMenuItem("Negrita");
        JMenuItem cursiva = new JMenuItem("Cursiva");
        OyenteEstilos oyeEstilos = new OyenteEstilos();
        estilos.add(negrita);
        estilos.add(cursiva);
        negrita.addActionListener(oyeEstilos);
        cursiva.addActionListener(oyeEstilos);

        barraPanel.add(barra);
        add(barraPanel, BorderLayout.NORTH);

        areaTexto = new JTextArea();
        JScrollPane textoPanel = new JScrollPane(areaTexto);
        areaTexto.setText("El perro de san roque no tiene rabo, porque ramón ramirez se lo ha quitado.");
        areaTexto.setLineWrap(true);

        textfuente = areaTexto.getFont().getFontName();
        textstyle = areaTexto.getFont().getStyle();
        textsize = areaTexto.getFont().getSize();

        colocaFuenteItems();
        colocarSizeItems();

        add(textoPanel, BorderLayout.CENTER);
    }

    private class OyenteEstilos implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand() == "Negrita") {
                if (textstyle != 1 && textstyle != 3) {
                    textstyle += 1;
                } else {
                    textstyle -= 1;
                }
            }
            if (e.getActionCommand() == "Cursiva") {
                if (textstyle != 2 && textstyle != 3) {
                    textstyle += 2;
                } else {
                    textstyle -= 2;
                }
            }
            areaTexto.setFont(new Font(textfuente, textstyle, textsize));
            System.out.println(textfuente + " " + textstyle + " " + textsize);
        }
    }

    public void colocaFuenteItems() {

        String[] fuentesOS = { "Arial", "SansSerif", "Courier", "Verdana" };

        for (String fuente : fuentesOS) {
            // System.out.println(fuente);
            fuenteItem = new JMenuItem(fuente);
            fuentes.add(fuenteItem);
            fuenteItem.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    textfuente = e.getActionCommand();
                    areaTexto.setFont(new Font(textfuente, textstyle, textsize));
                    System.out.println(textfuente + " " + textstyle + " " + textsize);
                }
            });
        }
    }

    public void colocarSizeItems() {
        int[] sizeArray = { 8, 10, 12, 14, 16, 18, 20, 22, 24 };
        for (int i = 0; i < sizeArray.length; i++) {
            sizeItem = new JMenuItem(String.valueOf(sizeArray[i]));
            size.add(sizeItem);
            sizeItem.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    textsize = Integer.parseInt(e.getActionCommand());
                    areaTexto.setFont(new Font(textfuente, textstyle, textsize));
                    System.out.println(textfuente + " " + textstyle + " " + textsize);
                }
            });
        }
    }
}
