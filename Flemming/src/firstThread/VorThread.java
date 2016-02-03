package firstThread;

public class VorThread extends Thread{

	@Override
	public void run() { //start-metoden kalder run-metoden som er nedarvet af THREAD
		System.out.println("Her er noget med Threads");
		//super.run();
	}
	
}
