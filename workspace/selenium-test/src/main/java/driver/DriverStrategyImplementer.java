package driver;

import utils.Costanti;

public class DriverStrategyImplementer {

	public static DriverStrategy scegliStrategia(String strategia) {

		switch (strategia) {
		
		case Costanti.CHROME:
			return new Chrome();

		case Costanti.FIREFOX:
			return new Firefox();

		case Costanti.EDGE:
			// return new Edge();
			System.out.println("Browser non disponibile su questa macchina");
			break;

		}

		return new Chrome();
	}
}