/* pooya panahandeh S7RFBI */


import java.util.*;
import javax.sound.midi.*;

public class Heads_Or_Tails{
	
	//coin toss method 
	public int tossCoin(){
		Random rand = new Random();
		
		int toss = Math.abs(rand.nextInt()) % 2;
		if (toss == 0) {
			// 0 for head
			return 0;
		} else {
			// 1 for tail
			return 1;
		}
	}
	
	
	
	// main class 
	public static void main(String[] args) {
				
		Heads_Or_Tails flip = new Heads_Or_Tails();
				
		//get the number of experiment max 1000
		Scanner sc = new Scanner(System.in);
		int expNum = sc.nextInt();
		if (expNum <= 1000) {
			for(int counter = 0 ; counter <= expNum ; counter++){
				flip.tossCoin();
			}
						
		} else {
			System.out.print("\n"+"invalid input, exit ...");
			System.exit(0);
			
		}
				
		//ins method
//		Heads_Or_Tails flip = new Heads_Or_Tails();
//		System.out.print(flip.tossCoin());
	}
}