package application;

import java.awt.AWTException;

import util.StringWriter;

public class Program {

	public static void main(String[] args) {
		
		//! WARNING !
		// NOT SUPPORTED CHARACTERS --> "!@#$%^&*()_+{}|:\"<>?"
		
		StringWriter sw = new StringWriter();
		try {
			sw.write("!@#$%^&*()_+{}|:\\\"<>", 1, 0);
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}
}
