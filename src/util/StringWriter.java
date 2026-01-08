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
	    			robot.keyPress(KeyEvent.VK_ALT);

	    			robot.keyPress(KeyEvent.VK_NUMPAD1);
	    			robot.keyRelease(KeyEvent.VK_NUMPAD1);

	    			robot.keyPress(KeyEvent.VK_NUMPAD3);
	    			robot.keyRelease(KeyEvent.VK_NUMPAD3);

	    			robot.keyPress(KeyEvent.VK_NUMPAD5);
	    			robot.keyRelease(KeyEvent.VK_NUMPAD5);

	    			robot.keyRelease(KeyEvent.VK_ALT);
	        break;
	        
	    		case 'Ç':
	    			robot.keyPress(KeyEvent.VK_ALT);

	    			robot.keyPress(KeyEvent.VK_NUMPAD1);
	    			robot.keyRelease(KeyEvent.VK_NUMPAD1);

	    			robot.keyPress(KeyEvent.VK_NUMPAD2);
	    			robot.keyRelease(KeyEvent.VK_NUMPAD2);

	    			robot.keyPress(KeyEvent.VK_NUMPAD8);
	    			robot.keyRelease(KeyEvent.VK_NUMPAD8);

	    			robot.keyRelease(KeyEvent.VK_ALT);
	        break;
	        
	        //a
	    		case 'á':
	    			accentedLetterPressRelease('´', 'a', robot);
	        break;
	        
	    		case 'à':
	    			accentedLetterPressRelease('`', 'a', robot);
	        break;
	        
	    		case 'â':
	    			accentedLetterPressRelease('^', 'a', robot);
	        break;
	        
	    		case 'ã':
	    			accentedLetterPressRelease('~', 'a', robot);
	        break;
	        
	        //e
	    		case 'é':
	    			accentedLetterPressRelease('´', 'e', robot);
	        break;
	        
	    		case 'è':
	    			accentedLetterPressRelease('`', 'e', robot);
	        break;
	        
	    		case 'ê':
	    			accentedLetterPressRelease('^', 'e', robot);
	        break;
	        
	        //i
	    		case 'í':
	    			accentedLetterPressRelease('´', 'i', robot);
	        break;
	        
	    		case 'ì':
	    			accentedLetterPressRelease('`', 'i', robot);
	        break;
	        
	    		case 'î':
	    			accentedLetterPressRelease('^', 'i', robot);
	        break;
	        
	        //o
	    		case 'ó':
	    			accentedLetterPressRelease('´', 'o', robot);
	        break;
	        
	    		case 'ò':
	    			accentedLetterPressRelease('`', 'o', robot);
	        break;
	        
	    		case 'ô':
	    			accentedLetterPressRelease('^', 'o', robot);
	        break;
	        
	    		case 'õ':
	    			accentedLetterPressRelease('~', 'o', robot);
	        break;
	        
	        //u
	    		case 'ú':
	    			accentedLetterPressRelease('´', 'u', robot);
	        break;
	        
	    		case 'ù':
	    			accentedLetterPressRelease('`', 'u', robot);
	        break;
	        
	    		case 'û':
	    			accentedLetterPressRelease('^', 'u', robot);
	        break;
	        
	        //UPPERCASE
	        //A
	    		case 'Á':
	    			accentedLetterPressRelease('´', 'A', robot);
	        break;
	        
	    		case 'À':
	    			accentedLetterPressRelease('`', 'A', robot);
	        break;
	        
	    		case 'Â':
	    			accentedLetterPressRelease('^', 'A', robot);
	        break;
	        
	    		case 'Ã':
	    			accentedLetterPressRelease('~', 'A', robot);
	        break;
	        
	        //E
	    		case 'É':
	    			accentedLetterPressRelease('´', 'E', robot);
	        break;
	        
	    		case 'È':
	    			accentedLetterPressRelease('`', 'E', robot);
	        break;
	        
	    		case 'Ê':
	    			accentedLetterPressRelease('^', 'E', robot);
	        break;
	        
	        //I
	    		case 'Í':
	    			accentedLetterPressRelease('´', 'I', robot);
	        break;
	        
	    		case 'Ì':
	    			accentedLetterPressRelease('`', 'I', robot);
	        break;
	        
	    		case 'Î':
	    			accentedLetterPressRelease('^', 'I', robot);
	        break;
	        
	        //O
	    		case 'Ó':
	    			accentedLetterPressRelease('´', 'O', robot);
	        break;
	        
	    		case 'Ò':
	    			accentedLetterPressRelease('`', 'O', robot);
	        break;
	        
	    		case 'Ô':
	    			accentedLetterPressRelease('^', 'O', robot);
	        break;
	        
	    		case 'Õ':
	    			accentedLetterPressRelease('~', 'O', robot);
	        break;
	        
	        //U
	    		case 'Ú':
	    			accentedLetterPressRelease('´', 'U', robot);
	        break;
	        
	    		case 'Ù':
	    			accentedLetterPressRelease('`', 'U', robot);
	        break;
	        
	    		case 'Û':
	    			accentedLetterPressRelease('^', 'U', robot);
	        break;
		}
	}
	
	private void accentedLetterPressRelease(char accent, char letter, Robot robot) {
		
		int letterKey = KeyEvent.getExtendedKeyCodeForChar(letter);
		
		switch (accent) {
			case '´':
        			robot.keyPress(KeyEvent.VK_DEAD_ACUTE);
        			robot.keyRelease(KeyEvent.VK_DEAD_ACUTE);
        		break;
        		
			case '`':
				pressWithShift(KeyEvent.VK_DEAD_ACUTE, robot);
    			break;
    			
			case '^':
				pressWithShift(KeyEvent.VK_DEAD_TILDE, robot);
			break;
			
			case '~':
				robot.keyPress(KeyEvent.VK_DEAD_TILDE);
				robot.keyRelease(KeyEvent.VK_DEAD_TILDE);
			break;
		}
		
		if (needsShift(letter)) {
			pressWithShift(letterKey, robot);
		}
		else{		
	        robot.keyPress(letterKey);
	        robot.keyRelease(letterKey);
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
		//			  |---> accented characters
		
		switch (Character.toLowerCase(key)) {
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
			case 'á': return true;
			case 'à': return true;
			case 'â': return true;
			case 'ã': return true;
			case 'é': return true;
			case 'è': return true;
			case 'ê': return true;
			case 'í': return true;
			case 'ì': return true;
			case 'î': return true;
			case 'ó': return true;
			case 'ò': return true;
			case 'ô': return true;
			case 'õ': return true;
			case 'ú': return true;
			case 'ù': return true;
			case 'û': return true;
			default: return false;
		}
	}
	
	public boolean needsShift(char c) {
		return Character.isUpperCase(c) || "!@#$%^&*()_+{}|:\"<>?".indexOf(c) >= 0;
	}
}
