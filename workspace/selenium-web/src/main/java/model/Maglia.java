package model;

import java.util.Objects;

public class Maglia implements Comparable<Maglia> {

	
	private double prezzo;
	private String scritta;
	private String colore;
	private int taglia;
	
	public Maglia() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Maglia(double prezzo, String scritta, String colore, int taglia) {
		super();
		this.prezzo = prezzo;
		this.scritta = scritta;
		this.colore = colore;
		this.taglia = taglia;
	}

	public double getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	public String getScritta() {
		return scritta;
	}
	public void setScritta(String scritta) {
		this.scritta = scritta;
	}
	public String getColore() {
		return colore;
	}
	public void setColore(String colore) {
		this.colore = colore;
	}
	public int getTaglia() {
		return taglia;
	}
	public void setTaglia(int taglia) {
		this.taglia = taglia;
	}

	

	@Override
	public int hashCode() {
		return Objects.hash(colore, taglia);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Maglia other = (Maglia) obj;
		return Objects.equals(colore, other.colore) && taglia == other.taglia;
	}


	@Override
	public String toString() {
		return "Maglia [prezzo=" + prezzo + ", scritta=" + scritta + ", colore=" + colore + ", taglia=" + taglia + "]";
	}


	@Override
	public int compareTo(Maglia o) {
		
		return this.taglia - o.taglia;
	}

	
	
	
}
