package application;

import java.awt.AWTException;
import java.util.Scanner;

import util.StringWriter;

public class Program {

	public static void main(String[] args) {
		
		StringWriter sw = new StringWriter();
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Envie seu texto: ");
		String text = scan.nextLine();
		System.out.print("Envie o delay inicial: ");
		int initialDelay = scan.nextInt();
		System.out.print("Envie o delay: ");
		int delay = scan.nextInt();
		scan.close();
		try {
			sw.write(text, initialDelay, delay);
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}
}
