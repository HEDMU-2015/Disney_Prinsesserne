package tennis;

public class Runnable_TennisSpiller implements Runnable {

	private Runnable_TennisSpiller Modstander;
	private boolean harBold = false;
	private String navn;
	
	public Runnable_TennisSpiller(String Navn){
		this.navn = Navn;
		
	}
	
	public void setModstander(Runnable_TennisSpiller Modstander){
		this.Modstander = Modstander;
	}
	
	public void modtagBoldt() {
		harBold = true;
		
	}
	
	private void println(String massage){
		System.out.println(navn + " " + massage);
	}
	
	//her
	public void start(){
		new Thread(this).start();
		Thread t = Thread.currentThread();
		//Thread t = new Thread(this);
		//t.start();
	}
	
	public void run(){
		while(true){
			while(harBold == false){
				nap();	
		}
			if(Math.random() <= 0.8){
				harBold = false;
				System.out.println(navn + " Ramte boldten");
				Modstander.modtagBoldt();
			} else {
				System.out.println(navn + " Misset");
				System.exit(0);
			}
		}
	}
	
	
	private void nap(){
		try {
			Thread.sleep((long) 2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	
}