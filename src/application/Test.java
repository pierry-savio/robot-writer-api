package application;    

public class Test {  
	
    public static void main(String[] a) {     
    	
    	int keycode = 10;
    	
        String text = java.awt.event.KeyEvent.getKeyText(keycode);                              
        System.out.println((text.contains("Desconhecido") || text.contains("Unknown") ? false : true));
    }                                                                                         
}
