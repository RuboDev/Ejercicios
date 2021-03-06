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
        setBounds(500, 300, 550, 420);
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
    JToolBar barraH;

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
        // set a shortcut for JMenuItem negrita (Bold)
        negrita.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));

        cursiva.addActionListener(new EstatusBoldItalic("Cursiva"));
        cursiva.addActionListener(new StyledEditorKit.ItalicAction());
        // set a shortcut for JMenuItem cursiva (Italic)
        cursiva.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_K, InputEvent.CTRL_DOWN_MASK));

        estilos.add(negrita);
        estilos.add(cursiva);

        barraPanel.add(barra);
        add(barraPanel, BorderLayout.NORTH);
        // ------------------------------------------------------------------------- //

        // Constructing JTextPane
        textoPanel = new JTextPane();
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

        // Constructing JToolBar
        // ------------------------------------------------------------------------- //
        barraH = new JToolBar();
        // Style Buttons ---------------------
        JButton negritaBarra = configura_barraH("Ejercicios/CursoPildoras/resources/iconos/negrita.png");
        negritaBarra.addActionListener(new StyledEditorKit.BoldAction());
        JButton cursivaBarra = configura_barraH("Ejercicios/CursoPildoras/resources/iconos/cursiva.png");
        cursivaBarra.addActionListener(new StyledEditorKit.ItalicAction());
        configura_barraH("Ejercicios/CursoPildoras/resources/iconos/underline.png")
                .addActionListener(new StyledEditorKit.UnderlineAction());
        // Bold and Italic Status Control Listeners -----
        negritaBarra.addActionListener(new EstatusBoldItalic("Negrita"));
        cursivaBarra.addActionListener(new EstatusBoldItalic("Cursiva"));

        barraH.addSeparator();
        // Color Buttons ---------------------
        configura_barraH("Ejercicios/CursoPildoras/resources/iconos/azul.png")
                .addActionListener(new StyledEditorKit.ForegroundAction("texto en azul", Color.BLUE));
        configura_barraH("Ejercicios/CursoPildoras/resources/iconos/amarillo.png")
                .addActionListener(new StyledEditorKit.ForegroundAction("texto en amarillo", Color.YELLOW));
        configura_barraH("Ejercicios/CursoPildoras/resources/iconos/rojo.png")
                .addActionListener(new StyledEditorKit.ForegroundAction("texto en rojo", Color.RED));

        barraH.addSeparator();
        // Alignment Buttons -----------------
        configura_barraH("Ejercicios/CursoPildoras/resources/iconos/centrado.png")
                .addActionListener(new StyledEditorKit.AlignmentAction("Center Alignment", 1));
        configura_barraH("Ejercicios/CursoPildoras/resources/iconos/justificado.png")
                .addActionListener(new StyledEditorKit.AlignmentAction("Justified Alignment", 3));
        configura_barraH("Ejercicios/CursoPildoras/resources/iconos/left.png")
                .addActionListener(new StyledEditorKit.AlignmentAction("Left Alignment", 0));
        configura_barraH("Ejercicios/CursoPildoras/resources/iconos/right.png")
                .addActionListener(new StyledEditorKit.AlignmentAction("Right Alignment", 2));
        // ----
        barraH.setOrientation(JToolBar.VERTICAL);
        // ------------------------------------------------------------------------- //

        add(barraH, BorderLayout.WEST);
    }

    public JButton configura_barraH(String ruta) {
        JButton boton = new JButton(new ImageIcon(ruta));
        barraH.add(boton);
        return boton;
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
            } else if (e.getSource() == negrita || e.getSource() == cursiva) {
                if (ultimo == "Negrita") {
                    negritaE.setSelected(!negritaE.isSelected());
                } else if (ultimo == "Cursiva") {
                    cursivaE.setSelected(!cursivaE.isSelected());
                }
            } else {
                if (ultimo == "Negrita") {
                    negritaE.setSelected(!negritaE.isSelected());
                    negrita.setSelected(!negrita.isSelected());
                } else if (ultimo == "Cursiva") {
                    cursivaE.setSelected(!cursivaE.isSelected());
                    cursiva.setSelected(!cursiva.isSelected());
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