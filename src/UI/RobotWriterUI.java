package UI;

import java.awt.AWTException;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import util.StringWriter;

public class RobotWriterUI {
	
	public RobotWriterUI() {
		
        JFrame frame = new JFrame("Robot Writer");
        frame.setSize(400, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JTextArea textArea = new JTextArea(5, 10);
        JScrollPane scroll = new JScrollPane(textArea);

        JTextField initialDelayField = new JTextField();
        JTextField delayField = new JTextField();

        JButton startButton = new JButton("Iniciar");

        startButton.addActionListener(e -> {
            try {
                String text = textArea.getText();
                int initialDelay = Integer.parseInt(initialDelayField.getText());
                int delay = Integer.parseInt(delayField.getText());

                StringWriter sw = new StringWriter();
                sw.write(text, initialDelay, delay);

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame,
                        "Os delays devem ser números!",
                        "Erro",
                        JOptionPane.ERROR_MESSAGE);
            } catch (AWTException ex) {
                ex.printStackTrace();
            }
        });

        panel.add(new JLabel("Texto:"));
        panel.add(scroll);
        panel.add(new JLabel("Delay inicial (ms):"));
        panel.add(initialDelayField);
        panel.add(new JLabel("Delay entre teclas (ms):"));
        panel.add(delayField);
        panel.add(startButton);

        frame.setContentPane(panel);
        frame.setVisible(true);
    }
}
