package application;

import java.awt.AWTException;

import util.StringWriter;

public class Program {

	public static void main(String[] args) {
		
		/*
		
		! WARNING !
		NOT SUPPORTED CHARACTERS:
		
		   * ç
		   * all the accented letters

		*/
		
		StringWriter sw = new StringWriter();
		try {
			sw.write("The previous not supported characters --> !@#$%^&*()_+{}|:\\\\\\\"<>? <-- are now supported!", 1, 0);
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}
}
