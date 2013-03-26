package code;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
	
	private String[] suit;
	private final int CARDS_PER_SUIT = 13;
	public ArrayList<String> deck;
	
	public Deck(){
		createDeck();
		shuffleDeck();
	}
	
	private void createDeck() {
		suit = new String[4];
		deck = new ArrayList<String>();
		suit[0] = "Spades  ";
		suit[1] = "Diamonds";
		suit[2] = "Hearts  ";
		suit[3] = "Clubs   ";
 	
		//shuffle cards and replace 1,11,12 and 13 with A,J,Q and K
		//but do not replace suits with their name, use number first
		for(int i=0; i<suit.length; i++){
			for(int j=1; j<=CARDS_PER_SUIT; j++){
				if(j==10) {
					String card = ("B"+ " " +suit[i]);
					deck.add(card);
				}
				else if(j==11){
					String card = ("C"+ " " +suit[i]);
					deck.add(card);
				}
				else if(j==12){
					String card = ("D"+ " " +suit[i]);
					deck.add(card);
				}
				else if(j==13){
					String card = ("E"+ " " +suit[i]);
					deck.add(card);
				}
				else{
					String card = (j+ " " +suit[i]);
					deck.add(card);
				}
			}
		}
	}
	
	private void shuffleDeck() {
		Collections.shuffle(deck);
	}
	
	public void printDeck(){
		for(int i =0; i<deck.size(); i++){
			System.out.println(deck.get(i));
		}
	}	
}
