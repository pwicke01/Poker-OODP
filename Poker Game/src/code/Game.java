package code;

import java.util.ArrayList;
import java.util.Collections;

public class Game {
	
	private int dealerHandValue;
	private int playerHandValue;
	public ArrayList<String> playerHand;
	public Deck deck;
	private Dealer dealer;
	public boolean chosen = false;
	private Hands determineHand;
	private ArrayList<String> dealerHand;
	
	public Game(){
		
	}
	
	public void runGame(){
		deck = new Deck();
		Player human = new HumanPlayer();
		Player bot = new AIPlayer();
		dealer = new Dealer();
		
		dealer.dealTo(deck, human);
		dealer.dealTo(deck, bot);
		
		playerHand = human.cardsInHand;
		dealerHand = bot.cardsInHand;
		
		//dealerHandValue = determineHand.evaluate(dealerHand);
		//dealerHand = bot.changeCards(dealerHandValue, deck);
		//dealerHandValue = determineHand.evaluate(dealerHand);
		
		
		//human.printHand(human.cardsInHand);
		bot.printHand(bot.cardsInHand);
		
		//Hands determineHand = new Hands();
		
		
		
		//playerHandValue = determineHand.evaluate(human.cardsInHand);
		//dealerHandValue = determineHand.evaluate(bot.cardsInHand);
		//bot.cardsInHand = bot.changeCards(dealerHandValue, deck);
		//dealerHandValue = determineHand.evaluate(bot.cardsInHand);
		
		//bot.printHand(bot.cardsInHand);
		
		
		//System.out.println(dealer.whoWins(human, bot));
	}
	
	
	public String changeOneCard(int i, Deck deck){
		ArrayList<String> converter = new ArrayList<>();		
		converter.add(deck.deck.get(0));
		deck.deck.remove(0);
		String s = converter.get(0);
			if(s.substring(0,2).equals("1 ")){
				s = s.replaceAll("1 ", "F ");
				converter.set(0, s);
			}
		converter = dealer.conversion(converter);
		s = converter.get(0);
		playerHand.set(i, s);
		return s;
	}
	public ArrayList<String> reSort(ArrayList<String> cardsInHand){
		cardsInHand = dealer.conversion(cardsInHand);
		Collections.sort(cardsInHand);
		cardsInHand = dealer.conversion(cardsInHand);
		return cardsInHand;
	}
	
	public void reEvaluate(){
		determineHand = new Hands();
		playerHandValue = determineHand.evaluate(playerHand);
		System.out.println(dealer.whoWins(dealerHandValue, playerHandValue));
	}
}
