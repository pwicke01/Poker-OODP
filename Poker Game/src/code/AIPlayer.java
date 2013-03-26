package code;

import java.util.ArrayList;

public class AIPlayer extends Player{
	
	public AIPlayer(){
		
	}
	
	public ArrayList<String> changeCards(int handValue, Deck deck){
		 
        if(handValue == 3){
                if(cardsInHand.get(0).charAt(0) == cardsInHand.get(2).charAt(0)){
                       
                        
                        cardsInHand.set(3, deck.deck.get(0));
                        deck.deck.remove(0);
                        cardsInHand.set(4, deck.deck.get(0));
                        deck.deck.remove(0);
                        
                       
                }
                else if(cardsInHand.get(4).charAt(0) == cardsInHand.get(2).charAt(0)){
                  
                    
                    cardsInHand.set(0, deck.deck.get(0));
                    deck.deck.remove(0);
                    cardsInHand.set(1, deck.deck.get(0));
                    deck.deck.remove(0);
                    
                 
            }
                else if(cardsInHand.get(0).charAt(0) != cardsInHand.get(2).charAt(0) && cardsInHand.get(4).charAt(0) != cardsInHand.get(2).charAt(0)){
                  
                    
                    cardsInHand.set(0, deck.deck.get(0));
                    deck.deck.remove(0);
                    cardsInHand.set(4, deck.deck.get(0));
                    deck.deck.remove(0);
                    
                 
            }
             return cardsInHand;   
        }
        else if(handValue == 2)
        {
                //change 0,1,3
        	if(cardsInHand.get(4).charAt(0) != cardsInHand.get(3).charAt(0)){
        		if(randomNumber() == 3){
        			for(int i = 4; i > 1; i--){
        				 cardsInHand.set(i, deck.deck.get(0));
        				 deck.deck.remove(0);
        			}
        		}
        		else if(randomNumber()== 1){
        			cardsInHand.set(4, deck.deck.get(0));
        			deck.deck.remove(0);
        		}
        		return cardsInHand;
        	}
        	else if(cardsInHand.get(0).charAt(0) != cardsInHand.get(1).charAt(0)){
        		if(randomNumber() == 3){
        			for(int i = 0; i < 3; i++){
        				 cardsInHand.set(i, deck.deck.get(0));
        				 deck.deck.remove(0);
        			}
        		}
        		else if(randomNumber()== 1){
        			cardsInHand.set(0, deck.deck.get(0));
        			deck.deck.remove(0);
       			}
        		
        		return cardsInHand;
        	}
        	else if(cardsInHand.get(2).charAt(0) != cardsInHand.get(1).charAt(0) && cardsInHand.get(2).charAt(0) != cardsInHand.get(3).charAt(0)){
        		if(randomNumber() == 3){
        			for(int i = 0; i < 3; i++){
        				 cardsInHand.set(i, deck.deck.get(0));
        				 deck.deck.remove(0);
        			}
        		}
        		else if(randomNumber()== 1){
        			cardsInHand.set(2, deck.deck.get(0));
        			deck.deck.remove(0);
       			}
        	
        		return cardsInHand;
        	}
        	return cardsInHand;
        }
        else if(handValue == 1 || handValue == 0)
        {
            ArrayList<Integer> increment = new ArrayList<>(5);
            for(int i = 0; i < 4; i++){
            	if(cardsInHand.get(i).charAt(0) == cardsInHand.get(i+1).charAt(0)){
            		increment.remove(i);
            		increment.remove(i+1);
            		for(int j = 0; j < increment.size(); j ++){
            			cardsInHand.set(increment.get(j), deck.deck.get(0));
            			deck.deck.remove(0);
            		}
            	}
            }
        	return cardsInHand;
        }
        else{
        	return cardsInHand;
        }
	}
	private int randomNumber(){
    	int random = 0 + (int)(Math.random()*4); 
		//System.out.println(randomNum);
    	if(random == 2){
    		random = randomNumber();
    	}
    	return random;
    }
}
