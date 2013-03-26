package code;

import java.util.ArrayList;
import java.util.Collections;

public class Dealer {
			
	public Dealer(){
		
	}
	
	public void dealTo(Deck deck, Player player){
		//Create a ArrayList to save the five card for a player.
		//remove five cards from the deckForPlay to avoid the duplicate.
		player.cardsInHand = new ArrayList<String>();
		for (int i = 0; i < 5; i++){
			String cardMove = deck.deck.get(i);
			String[] splitter = cardMove.split(" ");
					//changeAce(splitter[0], splitter[1], card, i);
			if(splitter[0].equals("1")){ //for the purposes of pairs, aces need to be high
				player.cardsInHand.add("F" + " " + splitter[1]);
			}
			else{
				player.cardsInHand.add(deck.deck.get(i));
			}
			deck.deck.remove(i);				
		}
								
		Collections.sort(player.cardsInHand);
		player.cardsInHand = conversion(player.cardsInHand);			
		//printHand(cardsInHand);
		//System.out.println();
	}	
	
	public ArrayList<String> conversion(ArrayList<String> cardsInHand){
		for (int i = 0; i < cardsInHand.size(); i++){
			String[] splitter = cardsInHand.get(i).split(" ");
			String replacement = "";
			switch(splitter[0]){
			case "F": replacement = "A" + " " + splitter[1];
			cardsInHand.set(i, replacement);
			break;
			case "B": replacement = "10" + " " + splitter[1];
			cardsInHand.set(i, replacement);
			break;
			case "C": replacement = "J" + " " + splitter[1];
			cardsInHand.set(i, replacement);
			break;
			case "D": replacement = "Q" + " " + splitter[1];
			cardsInHand.set(i, replacement);
			break;
			case "E": replacement = "K" + " " + splitter[1];
			cardsInHand.set(i, replacement);
			break;
			case "A": replacement = "F" + " " + splitter[1];
			cardsInHand.set(i, replacement);
			break;
			case "10": replacement = "B" + " " + splitter[1];
			cardsInHand.set(i, replacement);
			break;
			case "J": replacement = "C" + " " + splitter[1];
			cardsInHand.set(i, replacement);
			break;
			case "Q": replacement = "D" + " " + splitter[1];
			cardsInHand.set(i, replacement);
			break;
			case "K": replacement = "E" + " " + splitter[1];
			cardsInHand.set(i, replacement);
			break;
			default:
				break;
			}
		}
		return cardsInHand;
	}
	
	public String whoWins(int dealerValue, int playerValue){
		if(dealerValue > playerValue){
			return "dealer wins";
		}
		else if(playerValue > dealerValue){
			return "player wins";
		}
		else{
			return "draw";
		}
	}
}
