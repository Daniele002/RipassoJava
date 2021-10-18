//Daniele Fassetta 5BIA 

package Esercizio_Museo;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Generatore implements Runnable {

	int permanenza;
	int rNumV;
	Semaphore SemaforoMuseo, mutex;
	
	public Generatore(int minV, int maxV, int permanenza, Semaphore SemaforoMuseo, Semaphore mutex )
	{
		Random randN = new Random();
		
		this.rNumV = randN.nextInt((maxV - minV) + 1) + minV;
		this.permanenza = permanenza;
		this.SemaforoMuseo = SemaforoMuseo;
		this.mutex = mutex;

	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){

			Visitatore visitatore = new Visitatore(SemaforoMuseo, permanenza, mutex);
			Thread ThreadVis = new Thread(visitatore);
			
			ThreadVis.start();
			
			try {
				Thread.sleep(rNumV);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
