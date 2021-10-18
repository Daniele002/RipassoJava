//Daniele Fassetta 5BIA 

package Esercizio_Museo;

import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class MainClass {
	public static int VisTot=0;
	public static int Aspettano = 0;
	public static int dentro =0;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Semaphore SemaforoMuseo = new Semaphore(4);
		Semaphore Mutex = new Semaphore(1);

		Scanner s = new Scanner(System.in);
		
		//input dati
		System.out.println("T-min visitatore: ");
		int minV = s.nextInt();
		System.out.println("T-max visitatore: ");
		int maxV = s.nextInt();
		System.out.println("Tempo Permanenza: ");
		int permanenza = s.nextInt();
		
		Generatore genDati = new Generatore(minV, maxV, permanenza, SemaforoMuseo, Mutex);
		Thread ThreadGen = new Thread(genDati);
		
		
		
		ThreadGen.start();
		
		while(true)
		{
			if(s.nextLine().equals("status"))
			{
				try {
					Mutex.acquire();
					System.out.println("-----------------------");
					System.out.println("Totali: " + VisTot);
					System.out.println("Aspettano: "+ Aspettano);
					System.out.println("Dentro al Museo: " + dentro);
					System.out.println("-----------------------");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				Mutex.release();
			}
		}
		

	}

}
