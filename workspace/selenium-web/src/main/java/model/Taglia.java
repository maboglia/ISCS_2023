package model;

public enum Taglia {

	S(38), M(42), L(46), XL(50);
	
	int numTaglia;
	
	private Taglia(int numTaglia) {
		this.numTaglia = numTaglia;
	}
	
	public int getNumTaglia() {
		return numTaglia;
	}
}
