import javax.swing.*;

public class LaminaCajas extends JPanel {
    private ButtonGroup grupo;

    public LaminaCajas(String titulo, String[] opciones) {
        setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), titulo));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        grupo = new ButtonGroup();

        for (int i = 0; i < opciones.length; i++) {
            JRadioButton bot = new JRadioButton(opciones[i]);
            add(bot);
            grupo.add(bot);
            bot.setSelected(i == 0);
            bot.setActionCommand(opciones[i]);
        }
    }

    public String dameSeleccion() {
        ButtonModel miboton = grupo.getSelection();
        String s = miboton.getActionCommand();
        return s;
    }
}
