package repos;

import java.util.ArrayList;
import java.util.List;

import model.Colore;
import model.Maglia;

public class MagliaDAO {

	private List<Maglia> maglie = new ArrayList<>();
	
	public MagliaDAO() {
		init();
	}
	
	public void init() {
		
		maglie.clear();
		
		Colore[] colori = {Colore.ROSSO, Colore.VERDE, Colore.BLU};
		int[] taglie = {38,40,42,44,46};
		
		for (int i = 0; i < 10; i++) {
			
			Colore colore = colori[(int)Math.floor(Math.random()*colori.length)];
			int taglia = taglie[(int)Math.floor(Math.random()*taglie.length)];
			
			Maglia m = new Maglia(10, "Torino", colore, taglia);
			maglie.add(m);
		}
		
		
	}
	
	public List<Maglia> getMaglie() {
		return maglie;
	}
	
	
}
