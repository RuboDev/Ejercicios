import javax.swing.*;
import javax.swing.text.StyledEditorKit;
import java.awt.*;
import java.awt.event.*;

public class MenuEmergente {
    public static void main(String[] args) {
        MarcoMenuEmergente marco = new MarcoMenuEmergente();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class MarcoMenuEmergente extends JFrame {
    public MarcoMenuEmergente() {
        setTitle("Prueba Menu Emergente");
        setBounds(500, 300, 500, 350);
        LaminaMenuEmergente lamina = new LaminaMenuEmergente();
        add(lamina);
        setVisible(true);
    }
}

class LaminaMenuEmergente extends JPanel {

    JMenu fuentes, sizeMenu;
    JMenuItem fuenteItem, sizeItem;
    JTextPane textoPanel;
    JCheckBoxMenuItem negrita, cursiva, negritaE, cursivaE;

    public LaminaMenuEmergente() {
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

        negrita = new JCheckBoxMenuItem("Negrita",
                new ImageIcon("Ejercicios/CursoPildoras/resources/iconos/negrita.png"));
        cursiva = new JCheckBoxMenuItem("Cursiva",
                new ImageIcon("Ejercicios/CursoPildoras/resources/iconos/cursiva.png"));

        negrita.addActionListener(new EstatusBoldItalic("Negrita"));
        negrita.addActionListener(new StyledEditorKit.BoldAction());
        //set a shortcut for JMenuItem negrita (Bold)
        negrita.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));

        cursiva.addActionListener(new EstatusBoldItalic("Cursiva"));
        cursiva.addActionListener(new StyledEditorKit.ItalicAction());
        //set a shortcut for JMenuItem cursiva (Italic)
        cursiva.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_K, InputEvent.CTRL_DOWN_MASK));

        estilos.add(negrita);
        estilos.add(cursiva);

        barraPanel.add(barra);
        add(barraPanel, BorderLayout.NORTH);
        // ------------------------------------------------------------------------- //

        // Constructing JTextPane
        textoPanel = new JTextPane();
        // textoPanel.setLineWrap(true);
        add(textoPanel, BorderLayout.CENTER);

        // Constructing PopupMenu
        JPopupMenu popMenu = new JPopupMenu();
        negritaE = new JCheckBoxMenuItem("Negrita",
                new ImageIcon("Ejercicios/CursoPildoras/resources/iconos/negrita.png"));
        cursivaE = new JCheckBoxMenuItem("Cursiva",
                new ImageIcon("Ejercicios/CursoPildoras/resources/iconos/cursiva.png"));

        negritaE.addActionListener(new EstatusBoldItalic("Negrita"));
        negritaE.addActionListener(new StyledEditorKit.BoldAction());

        cursivaE.addActionListener(new EstatusBoldItalic("Cursiva"));
        cursivaE.addActionListener(new StyledEditorKit.ItalicAction());

        popMenu.add(negritaE);
        popMenu.add(cursivaE);

        textoPanel.setComponentPopupMenu(popMenu);

        // Initializing methods that put Items in menus
        colocaFuenteItems();
        colocarSizeItems();
    }

    private class EstatusBoldItalic implements ActionListener {
        String ultimo;

        public EstatusBoldItalic(String a) {
            ultimo = a;
        }

        public void actionPerformed(ActionEvent e) {
            System.out.println("Nuevo evento escuchado. ");
            System.out.println("-------------------------");
            System.out.println("+Estados:");
            if (e.getSource() == negritaE || e.getSource() == cursivaE) {
                if (ultimo == "Negrita") {
                    negrita.setSelected(!negrita.isSelected());
                } else if (ultimo == "Cursiva") {
                    cursiva.setSelected(!cursiva.isSelected());
                }
            } else {
                if (ultimo == "Negrita") {
                    negritaE.setSelected(!negritaE.isSelected());
                } else if (ultimo == "Cursiva") {
                    cursivaE.setSelected(!cursivaE.isSelected());
                }
            }

            System.out.println("Menu-Negrita: " + negrita.isSelected());
            System.out.println("Popup-Negrita: " + negritaE.isSelected());
            System.out.println("Menu-Cursiva: " + cursiva.isSelected());
            System.out.println("Popup-Cursiva: " + cursivaE.isSelected());
            System.out.println("-------------------------");
            System.out.println("");
        }
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
            if (i == 8) {
                radioItems.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, InputEvent.CTRL_DOWN_MASK));
            }
            grupoSizeItems.add(radioItems);
            sizeMenu.add(radioItems);
        }
    }
}