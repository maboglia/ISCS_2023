package demo;

import java.util.List;

import model.Colore;
import model.Maglia;

public class MagliaDemo {

	public static void main(String[] args) {
		

		Maglia m1 = new Maglia(10, "I love you", Colore.ROSSO, 42);
		Maglia m2 = new Maglia(10, "I love you", Colore.BLU, 44);
		Maglia m3 = new Maglia(10, "I love you", Colore.VERDE, 40);;
		
		List<Maglia> maglie = List.of(m1,m2,m3);
		
		maglie
			.stream()
			//.filter(m -> m.getTaglia() > 41)
			.sorted()
			.forEach(m -> System.out.println(m));
		
//		for (Maglia maglia : maglie) {
//			if (maglia.getTaglia() > 41)
//				System.out.println(maglia);
//		}
		
		
	}

}
