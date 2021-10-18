//Fassetta Daniele 5BIA 26/09/2021

package Esercitazione_java;

import java.util.*;


public class ThreadClass implements Runnable {

	public Boolean flag = false;
	int i=0;
	
	@Override
	public void run() {
		// TODO Auto-generated method stub

		
		while(flag == false){
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				System.out.println("ThreadA: "+i); 
				i++;
		}
		
		
	}
	

}
