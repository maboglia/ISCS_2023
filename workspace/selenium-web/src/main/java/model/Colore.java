package model;

public enum Colore {
	
	ROSSO("#FF0000", "rgb(255,0,0)"), VERDE("#00FF00", "rgb(0,255,0)"), BLU("#0000FF", "rgb(0,0, 255)");
	
	String esadecimale;
	String rgb;
	
	private Colore(String esadecimale, String rgb) {
		this.esadecimale = esadecimale;
		this.rgb = rgb;
	}
	
	

}
