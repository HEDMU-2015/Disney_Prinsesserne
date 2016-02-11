package logik;

public class Logik_SK {


	public String[] kørSøgestrengenIgennemFlereTingForAtÆndreDenTilNogetViKanBrugeISQL(String søgestreng) {
		String string = søgestreng;
		String string3 = string.toLowerCase();

		
		String string2 = string3.replaceAll("[^a-zA-Z0-9@ ]", "");

		String[] parts = string2.split(" ");
		
		return parts;
	}
}
