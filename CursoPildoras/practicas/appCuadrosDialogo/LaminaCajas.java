import javax.swing.*;
import java.awt.event.*;

public class LaminaCajas extends JPanel {
    OyenteSelectores oyeSelectores = new OyenteSelectores();

    public LaminaCajas(String titulo, String[] opciones) {
        setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), titulo));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        ButtonGroup grupo = new ButtonGroup();

        for (int i = 0; i < opciones.length; i++) {
            JRadioButton bot = new JRadioButton(opciones[i]);
            add(bot);
            grupo.add(bot);
            bot.setSelected(i == 0);
        }
    }

    private class OyenteSelectores implements ActionListener {

        JRadioButton tipoB, tipomsg, msg;

        @Override
        public void actionPerformed(ActionEvent e) {
            String cosas = e.getActionCommand();

            if (cosas == "Mensaje" || cosas == "Confirmar" || cosas == "Opcion" || cosas == "Entrada") {

                // boolean msgonoff = rButton.isSelected();
                tipoB = (JRadioButton) e.getSource();
                System.out.println(tipoB.isSelected());
            }

            if (cosas == "ERROR_MESSAGE" || cosas == "INFORMATION_MESSAGE" || cosas == "WARNING_MESSAGE"
                    || cosas == "QUESTION_MESSAGE" || cosas == "PLAIN_MESSAGE") {
                tipomsg = (JRadioButton) e.getSource();
                // boolean erroronoff = rButton.isSelected();
                System.out.println(tipomsg.isSelected());

            }

            if (cosas == "Cadena" || cosas == "Icono" || cosas == "Componente" || cosas == "Otros"
                    || cosas == "Object[]") {
                msg = (JRadioButton) e.getSource();
                // boolean erroronoff = rButton.isSelected();
                System.out.println(msg.isSelected());

            }
        }

    }
}
