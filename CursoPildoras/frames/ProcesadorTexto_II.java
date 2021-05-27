import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;

public class ProcesadorTexto_II {
    public static void main(String[] args) {
        MarcoProcesador_II marco = new MarcoProcesador_II();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class MarcoProcesador_II extends JFrame {
    public MarcoProcesador_II() {
        setTitle("Mi procesador de Textos");
        setBounds(500, 300, 800, 600);
        LaminaProcesador_II lamina = new LaminaProcesador_II();
        add(lamina);
        setVisible(true);
    }
}

class LaminaProcesador_II extends JPanel {

    JMenu fuentes, sizeMenu;
    JMenuItem fuenteItem, sizeItem;
    JTextPane textoPanel;

    public LaminaProcesador_II() {
        setLayout(new BorderLayout());
        // Constructing Menu's Panel, Menus, MenuBar, menus etc.
        // ------------------------------------------------------------------------- //
        JPanel barraPanel = new JPanel();

        JMenuBar barra = new JMenuBar();
        fuentes = new JMenu("Fuentes");
        JMenu estilos = new JMenu("Estilos");
        sizeMenu = new JMenu("Tamaño");
        barra.add(fuentes);
        barra.add(estilos);
        barra.add(sizeMenu);

        JCheckBoxMenuItem negrita = new JCheckBoxMenuItem("Negrita",
                new ImageIcon("Ejercicios/CursoPildoras/resources/iconos/negrita.png"));
        JCheckBoxMenuItem cursiva = new JCheckBoxMenuItem("Cursiva",
                new ImageIcon("Ejercicios/CursoPildoras/resources/iconos/cursiva.png"));
        negrita.addActionListener(new StyledEditorKit.BoldAction());
        cursiva.addActionListener(new StyledEditorKit.ItalicAction());
        estilos.add(negrita);
        estilos.add(cursiva);

        barraPanel.add(barra);
        add(barraPanel, BorderLayout.NORTH);
        // ------------------------------------------------------------------------- //

        // Constructing JTextPane
        textoPanel = new JTextPane();
        add(textoPanel, BorderLayout.CENTER);

        // Initializing methods that put Items in menus
        colocaFuenteItems();
        colocarSizeItems();
    }

    public void colocaFuenteItems() {
        String[] fuentesOS = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        for (String fuente : fuentesOS) {
            fuenteItem = new JMenuItem(fuente);
            fuenteItem.addActionListener(new StyledEditorKit.FontFamilyAction("cambia_fuente", fuente));
            fuentes.add(fuenteItem);
        }
    }

    public void colocarSizeItems() {
        ButtonGroup grupoSizeItems = new ButtonGroup();
        JRadioButtonMenuItem radioItems;
        int[] sizeArray = { 8, 10, 12, 14, 16, 18, 20, 22, 24 };
        for (int i = 0; i < sizeArray.length; i++) {
            radioItems = new JRadioButtonMenuItem(String.valueOf(sizeArray[i]));
            radioItems.addActionListener(new StyledEditorKit.FontSizeAction("cambia_size", sizeArray[i]));
            grupoSizeItems.add(radioItems);
            sizeMenu.add(radioItems);
        }
    }
}