package tennis;

public class TennisSpiller extends Thread{

	private TennisSpiller Modstander;
	private boolean harBold = false;
	private String navn;
	
	public TennisSpiller(String Navn){
		this.navn = Navn;
		
	}
	
	public void setModstander(TennisSpiller Modstander){
		this.Modstander = Modstander;
	}
	
	public void modtagerBold(){
		harBold = true;
	}
	
	public void run(){
		while(true){
			while(harBold == false){
				nap();	
		}
			if(Math.random() <= 0.8){
				harBold = false;
				System.out.println(navn + " Ramte boldten");
				Modstander.modtagerBold();
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
