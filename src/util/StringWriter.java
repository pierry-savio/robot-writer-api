package util;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

public final class StringWriter {
	
	public StringWriter() {};
	
	public void write(String txt, int initialDelayInSeconds, int delay) throws AWTException {
		
		Robot robot = new Robot();
		robot.setAutoDelay(delay);
		robot.delay(initialDelayInSeconds*1000);
			
		for (int i = 0; i<txt.length(); i++) {
			char letter = txt.charAt(i);
			keyPressRelease(letter, robot);
		}

	}
	
	private void keyPressRelease(char letter, Robot robot) throws AWTException {
		
		int key = KeyEvent.getExtendedKeyCodeForChar(letter);
			
		if (key != KeyEvent.VK_UNDEFINED) {
			
			if (needsShift(letter)) {
				robot.keyPress(KeyEvent.VK_SHIFT);
			}
				
			robot.keyPress(key);
			robot.keyRelease(key);
				
			if (needsShift(letter)) {
				robot.keyRelease(KeyEvent.VK_SHIFT);
			}
		}
	}
	
	public boolean needsShift(char c) {
		return Character.isUpperCase(c) || "!@#$%^&*()_+{}|:\"<>?".indexOf(c) >= 0;
	}
}
