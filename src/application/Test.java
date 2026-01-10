package application;

import javax.swing.SwingUtilities;
import UI.RobotWriterUI;

public class Test {  
	
	public static void main(String[] args) {
        SwingUtilities.invokeLater(RobotWriterUI::new);
    }                                             
}
