//Daniele Fassetta 5BIA 

package Esercizio_Museo;

import java.util.concurrent.Semaphore;

public class Visitatore implements Runnable {

	Semaphore SemaforoMuseo, mutex;
	int permanenza;
	
	public Visitatore(Semaphore SemaforoMuseo, int permanenza, Semaphore mutex)
	{
		this.SemaforoMuseo = SemaforoMuseo;
		this.permanenza = permanenza;
		this.mutex = mutex;
		
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			
			try {
				mutex.acquire();
				MainClass.Aspettano++;
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			mutex.release();
			
			try {
				SemaforoMuseo.acquire();
				mutex.acquire();
				MainClass.Aspettano--;
				MainClass.dentro ++;
				mutex.release();
				System.out.println("Visitatore " +  Thread.currentThread().getName() + " entro.");
				Thread.sleep(permanenza);			
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				mutex.acquire();
				MainClass.VisTot++;
				MainClass.dentro--;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("Visitatore " + Thread.currentThread().getName() + " esco.");
			mutex.release();
			SemaforoMuseo.release();
			
		}
		
	}

}
