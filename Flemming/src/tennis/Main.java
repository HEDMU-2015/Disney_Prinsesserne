package tennis;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TennisSpiller SpillerA = new TennisSpiller("Trine");
		TennisSpiller SpillerB = new TennisSpiller("Elisa");
		
		SpillerA.setModstander(SpillerB);
		SpillerB.setModstander(SpillerA);
		
		SpillerA.start();
		SpillerB.start();
		
		SpillerB.modtagerBold();
	}

}
