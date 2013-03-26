package code;

import java.util.ArrayList;

public class Hands {
	
	public Hands(){
		
	}
	
	public int evaluate(ArrayList<String> cardsInHand){
        
        if(fourKind(cardsInHand)){
                //System.out.println("Four of a Kind");
                //hand = "4Kind";
        	return 6;
        }
        else if(flush(cardsInHand)){
                //System.out.println("Flush");
                //hand = "Flush";
        	return 5;
        }       
        else if(straight(cardsInHand)){
                //System.out.println("Straight");
                //hand = "Straight";
        	return 4;
        }               
        else if(threeKind(cardsInHand)){
                //System.out.println("Three of a Kind");
                //hand = "3Kind";
        	return 3;
        }       
        else if(twoPair(cardsInHand)){
                //cardsInHand.add("E");
                //System.out.println("You have two pairs");
                //hand = "2Pairs";
            return 2;
        }
        else if(pair(cardsInHand)){
                //cardsInHand.add("F");
                //System.out.println("You have a pair");
                //hand = "1Pair";
            return 1;
        }
        else{
               // System.out.println("No Hands");
                //hand = "NoHand";
        	return 0;
        }        
	}
	
	public boolean fourKind(ArrayList<String> cardsInHand){
        
        int i = 0;
        int j = 1;
        int k = 2;
        int l = 3;
        
        while(l < cardsInHand.size()){
        	char a = cardsInHand.get(i).charAt(0);
        	char b = cardsInHand.get(j).charAt(0);
         	char c = cardsInHand.get(k).charAt(0);
          	char d = cardsInHand.get(l).charAt(0);
                if(a == b && b == c && c == d){
                	return true;
                }
                else{
                 	i++;j++;k++;l++;
                }
        }
        return false;
	}

	public boolean flush(ArrayList<String> cardsInHand){

        String[] suits = new String[5];
        for (int i = 0; i < cardsInHand.size(); i++){
        	String[] splitter = cardsInHand.get(i).split(" ");
        	suits[i] = splitter[1];
        }
        
        String a = suits[0];
        String b = suits[1];
        String c = suits[2];
        String d = suits[3];
        String e = suits[4];
        
        if(a.equals(b) && b.equals(c) && c.equals(d) && d.equals(e)){
        	return true;
        }
        else{
        	return false;
        }
	}

	public boolean straight(ArrayList<String> cardsInHand){
        
        ArrayList<Integer> straight = new ArrayList<>();
        int num = 0;
                
        if(cardsInHand.get(4).substring(0,1).equals("A") &&
        		cardsInHand.get(0).substring(0,1).equals("2") &&
        		cardsInHand.get(1).substring(0,1).equals("3") &&
        		cardsInHand.get(2).substring(0,1).equals("4") &&
        		cardsInHand.get(3).substring(0,1).equals("5")){
        	return true;
        }        
        else{
        	for(int i = 0; i < cardsInHand.size(); i++){
        		switch (cardsInHand.get(i).substring(0,1)){
                	case "1": straight.add(10);
                    break;
                    case "A": straight.add(14);
                    break;
                    case "J": straight.add(11);
                    break;
                    case "Q": straight.add(12);
                    break;
                    case "K": straight.add(13);
                    break;
                    default: num = Integer.parseInt(cardsInHand.get(i).substring(0, 1));
                    straight.add(num);
                    break;
                }                       
        	}
        
            int a = straight.get(0);        
            int b = straight.get(1);
            int c = straight.get(2);
            int d = straight.get(3);
            int e = straight.get(4);
        
            if(e == d+1 && d == c+1 && c == b+1 && b == a+1){       
                return true;
            }
            else{
                return false;
            }
        }      
	}

	public boolean threeKind(ArrayList<String> cardsInHand){
                
    	int i = 0;
        int j = 1;
        int k = 2;
        while(k < cardsInHand.size()){
        	char a = cardsInHand.get(i).charAt(0);
        	char b = cardsInHand.get(j).charAt(0);
        	char c = cardsInHand.get(k).charAt(0);
         	if(a == b && b == c){
         		return true;
            }
            else{
            	i++;j++;k++;
            }
        }
        return false;
	}

	public boolean twoPair(ArrayList<String> cardsInHand){
        for(int i = 0; i < cardsInHand.size(); i++){
        	for(int j = 0; j < cardsInHand.size(); j++){
        		int countPairs = 0;
            	if(j != i && cardsInHand.get(i).substring(0, 1).equals(cardsInHand.get(j).substring(0, 1))){
                	countPairs++;
                    if(countPairs== 4){
                    	return true;
                    }
                }                                       
        	}                       
        }               
        return false;
	}

	public boolean pair(ArrayList<String> cardsInHand){
        for(int i = 0; i < cardsInHand.size(); i++){
        	for(int j = 0; j < cardsInHand.size(); j++){
            	if(j != i && cardsInHand.get(i).substring(0, 1).equals(cardsInHand.get(j).substring(0, 1))){
                	return true;    
                }                                       
        	}                       
        }               
        return false;
	}
}