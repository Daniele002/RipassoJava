//Fassetta Daniele 5BIA 26/09/2021

package Esercitazione_java;

import java.util.Scanner;

import Esercitazione_java.ThreadB;
import Esercitazione_java.ThreadClass;

import java.util.Random;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Inserimento dati da tastiera
		Scanner s = new Scanner(System.in);
		System.out.println("Inserisci T-min: ");
		int min = s.nextInt();
		System.out.println("Inserire T-max: ");
		int max = s.nextInt();
		
		
		//calcolo tempo
		Random rand = new Random();
		int randomNum = rand.nextInt((max - min) + 1) + min;
		
		
		//istanza del ThreadA
		ThreadClass t = new ThreadClass();
		Thread threadA = new Thread(t);
		

		//istanza del ThreadB
		ThreadB T = new ThreadB(randomNum, t);
		Thread threadB = new Thread(T);
		
		threadB.start();
		threadA.start();
		

	}

}
