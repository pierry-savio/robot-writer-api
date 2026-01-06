package util;

import java.awt.Robot;

public final class StringWriter {
	
	public StringWriter() {};
	
	public static void write(String txt, int initialDelayInSeconds, int delay) {
		try {
			Robot robot = new Robot();
			robot.setAutoDelay(delay);
			robot.delay(initialDelayInSeconds*1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
