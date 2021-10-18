//Fassetta Daniele 5BIA 26/09/2021

package Esercitazione_java;

public class ThreadB implements Runnable {

	int randNum;
	ThreadClass b = new ThreadClass();
	
	public ThreadB(int randNum, ThreadClass threadA)
	{
		this.randNum = randNum;
		b = threadA;
		
		
	}
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			
			System.out.println("ThreadB waiting...");
			Thread.sleep(this.randNum);
			b.flag = true;

			
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

}