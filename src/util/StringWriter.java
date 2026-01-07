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
			
			if(isItASpecialKey(letter)) {
				specialKeyPressRelease(letter, robot);
			}
			else {
				keyPressRelease(letter, robot);
			}
		}
	}
	
	private void keyPressRelease(char letter, Robot robot) throws AWTException {
		
		int key = KeyEvent.getExtendedKeyCodeForChar(letter);
		
			if (key != KeyEvent.VK_UNDEFINED && keycodeExists(key)) {
				
			if (needsShift(letter)) {
				pressWithShift(key, robot);
			}
			else {
				robot.keyPress(key);
				robot.keyRelease(key);
			}
		}
	}
	
	private void specialKeyPressRelease(char letter, Robot robot) {
		
		switch (letter) {
		
	    case '!':
	        pressWithShift(KeyEvent.VK_1, robot);
	        break;
	    case '@':
	        pressWithShift(KeyEvent.VK_2, robot);
	        break;
	    case '#':
	        pressWithShift(KeyEvent.VK_3, robot);
	        break;
	    case '$':
	        pressWithShift(KeyEvent.VK_4, robot);
	        break;
	    case '%':
	        pressWithShift(KeyEvent.VK_5, robot);
	        break;
	    case '^':
	        pressWithShift(KeyEvent.VK_6, robot);
	        break;
	    case '&':
	        pressWithShift(KeyEvent.VK_7, robot);
	        break;
	    case '*':
	        pressWithShift(KeyEvent.VK_8, robot);
	        break;
	    case '(':
	        pressWithShift(KeyEvent.VK_9, robot);
	        break;
	    case ')':
	        pressWithShift(KeyEvent.VK_0, robot);
	        break;

	    case '_':
	        pressWithShift(KeyEvent.VK_MINUS, robot);
	        break;
	    case '+':
	        pressWithShift(KeyEvent.VK_EQUALS, robot);
	        break;

	    case '{':
	        pressWithShift(KeyEvent.VK_OPEN_BRACKET, robot);
	        break;
	    case '}':
	        pressWithShift(KeyEvent.VK_CLOSE_BRACKET, robot);
	        break;

	    case '|':
	        pressWithShift(KeyEvent.VK_BACK_SLASH, robot);
	        break;

	    case ':':
	        pressWithShift(KeyEvent.VK_SEMICOLON, robot);
	        break;
	    case '"':
	        pressWithShift(KeyEvent.VK_QUOTE, robot);
	        break;

	    case '<':
	        pressWithShift(KeyEvent.VK_COMMA, robot);
	        break;
	    case '>':
	        pressWithShift(KeyEvent.VK_PERIOD, robot);
	        break;
	    
	    case '?':
	        robot.keyPress(KeyEvent.VK_CONTROL);
	        robot.keyPress(KeyEvent.VK_ALT);
	        robot.keyPress(KeyEvent.VK_W);
	        robot.keyRelease(KeyEvent.VK_CONTROL);
	        robot.keyRelease(KeyEvent.VK_ALT);
	        robot.keyRelease(KeyEvent.VK_W);
	        break;

	    case 'ç':
	        robot.keyPress(KeyEvent.VK_SEMICOLON);
	        robot.keyRelease(KeyEvent.VK_SEMICOLON);
	        break;
		}
		
	}
	
	private void pressWithShift(int key, Robot robot) {
	    robot.keyPress(KeyEvent.VK_SHIFT);
	    robot.keyPress(key);
	    robot.keyRelease(key);
	    robot.keyRelease(KeyEvent.VK_SHIFT);
	}
	
	private boolean keycodeExists(int keycode) {
        String text = java.awt.event.KeyEvent.getKeyText(keycode);                              
        return (text.contains("Desconhecido") || text.contains("Unknown") ? false : true);
	}
	
	private boolean isItASpecialKey(char key) {
		//SPECIAL KEYS ---> !@#$%^&*()_+{}|:\"<>?ç
		switch (key) {
			case '!': return true;
			case '@': return true;
			case '#': return true;
			case '$': return true;
			case '%': return true;
			case '^': return true;
			case '&': return true;
			case '*': return true;
			case '(': return true;
			case ')': return true;
			case '_': return true;
			case '+': return true;
			case '{': return true;
			case '}': return true;
			case '|': return true;
			case ':': return true;
			case '\\': return true;
			case '"': return true;
			case '<': return true;
			case '>': return true;
			case '?': return true;
			case 'ç': return true;
			default: return false;
		}
	}
	
	public boolean needsShift(char c) {
		return Character.isUpperCase(c) || "!@#$%^&*()_+{}|:\"<>?".indexOf(c) >= 0;
	}
}
