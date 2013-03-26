package code;

import java.util.ArrayList;

public abstract class Player {
	
	public ArrayList<String> cardsInHand;
	public int hand;
	
	public Player(){
		
	}
	
	public void printHand(ArrayList<String> yourHand){
		for (int i = 0; i < yourHand.size(); i++){
			String hand = yourHand.get(i);
			System.out.println(hand);
		}
		System.out.println();
	}
	
	public ArrayList<String> changeCards(int handValue, Deck deck){
		return cardsInHand;
	}
	
	//Re-sorting method to take changed hands and put them in order for evaluation needs to go here!
	
}
