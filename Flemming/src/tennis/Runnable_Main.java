package tennis;

//kommentar2
public class Runnable_Main {

	public static void main(String[] args) {
	Runnable_TennisSpiller spiller1, spiller2; 
		
	spiller1 = new Runnable_TennisSpiller("Anders");
	spiller2 = new Runnable_TennisSpiller("Hans");
	
		spiller1.setModstander(spiller2);
		spiller2.setModstander(spiller1);
		
		Thread a = new Thread(spiller1);
		Thread b = new Thread(spiller2);
		
		a.start();
		b.start();
		
		spiller1.modtagBoldt();

	}

	}


