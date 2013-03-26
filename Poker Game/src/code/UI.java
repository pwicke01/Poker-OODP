package code;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class UI extends JFrame {

	private JPanel playerCards;
	private JPanel playerControls;
	private JPanel card1;
	private JPanel card2;
	private JPanel card3;
	private JPanel card4;
	private JPanel card5;
	private JPanel playerView;
	private JPanel stateView;
	private JPanel dealerView;
	private Dimension cardSize;
	private Color tableGreen;
	private Color cardWhite;
	public JTextArea cardOneContents;
	public JTextArea cardTwoContents;
	public JTextArea cardThreeContents;
	public JTextArea cardFourContents;
	public JTextArea cardFiveContents;
	private JButton cardOne;
	private JButton cardTwo;
	private JButton cardThree;
	private JButton cardFour;
	private JButton cardFive;
	private JButton noChange;
	private JButton dealing;
	
	
	public class dealingClickListener implements ActionListener{ //only make one actionlistener so that only one instance of Game need be instantiated
		private Game game = new Game();
		private int counter = 0;
		public void actionPerformed(ActionEvent event){ //just testing the button
			if(counter >= 2){
				finishChoosing();
			}
			if(event.getSource() == dealing){
				game.runGame();
				cardOneContents = new JTextArea();
				cardTwoContents = new JTextArea();
				cardThreeContents = new JTextArea();
				cardFourContents = new JTextArea();
				cardFiveContents = new JTextArea();
				//textLabel.setText("");
				card1.add(cardOneContents);
				card2.add(cardTwoContents);
				card3.add(cardThreeContents);
				card4.add(cardFourContents);
				card5.add(cardFiveContents);
				cardOneContents.append(game.playerHand.get(0));
				cardTwoContents.append(game.playerHand.get(1));
				cardThreeContents.append(game.playerHand.get(2));
				cardFourContents.append(game.playerHand.get(3));
				cardFiveContents.append(game.playerHand.get(4));
				cardOne.setEnabled(true);
				cardTwo.setEnabled(true);
				cardThree.setEnabled(true);
				cardFour.setEnabled(true);
				cardFive.setEnabled(true);
				noChange.setEnabled(true);
				dealing.setEnabled(false);
			}
			if(event.getSource() == cardOne && cardOneContents!= null){ //&& a counter is <1 so that you can only change it once
				cardOneContents.setText("");
				String s = game.changeOneCard(0, game.deck); 
				cardOneContents.append(s);
				cardOne.setEnabled(false);
				counter++;
				
			}
			if(event.getSource() == cardTwo && cardTwoContents!= null){ //&& a counter is <1 so that you can only change it once
				cardTwoContents.setText("");
				String s = game.changeOneCard(1, game.deck); 
				cardTwoContents.append(s);
				cardTwo.setEnabled(false);
				counter++;
			}
			if(event.getSource() == cardThree && cardThreeContents!= null){ //&& a counter is <1 so that you can only change it once
				cardThreeContents.setText("");
				String s = game.changeOneCard(2, game.deck); 
				cardThreeContents.append(s);
				cardThree.setEnabled(false);
				counter++;
			}
			if(event.getSource() == cardFour && cardFourContents!= null){ //&& a counter is <1 so that you can only change it once
				cardFourContents.setText("");
				String s = game.changeOneCard(3, game.deck); 
				cardFourContents.append(s);
				cardFour.setEnabled(false);
				counter++;
			}
			if(event.getSource() == cardFive && cardFiveContents!= null){ //&& a counter is <1 so that you can only change it once
				cardFiveContents.setText("");
				String s = game.changeOneCard(4, game.deck); 
				cardFiveContents.append(s);
				cardFive.setEnabled(false);
				counter++;
			}
			if(event.getSource() == noChange){
				finishChoosing();
			}
		}
		private void finishChoosing(){
			cardOne.setEnabled(false);
			cardTwo.setEnabled(false);
			cardThree.setEnabled(false);
			cardFour.setEnabled(false);
			cardFive.setEnabled(false);
			noChange.setEnabled(false);
			
			game.playerHand = game.reSort(game.playerHand);
			game.reEvaluate();
		}
	}

	
	
	public UI(){

		setLayout(new GridLayout(1,3));
		playerCards = new JPanel();
		playerCards.setBackground(new Color(0x006600));
		//playerButtons = new JPanel();
		playerView = new JPanel();
		stateView = new JPanel();
		dealerView = new JPanel();
		//playerView.setBackground(new Color(0xffffdd));
		stateView.setBackground(new Color(0xFF3333));
		dealerView.setBackground(new Color(0x33FF00));
		playerControls = new JPanel();
		tableGreen = new Color(0x006600);
		playerControls.setBackground(tableGreen);
		
		
		
		
		
		//statePad = new JLabel("Please decide the cards you want to change");
		//dealerCards = new JPanel();
		//showPlayerCards= new JPanel();
		cardSize = new Dimension(70, 100);
		cardWhite = new Color(0xFFFFFF);
		card1 = new JPanel();
		card1.setPreferredSize(cardSize);
		card1.setBackground(cardWhite);
		card2 = new JPanel();
		card2.setBackground(cardWhite);
		card2.setPreferredSize(cardSize);
		card3 = new JPanel();
		card3.setBackground(cardWhite);
		card3.setPreferredSize(cardSize);
		card4 = new JPanel();
		card4.setBackground(cardWhite);
		card4.setPreferredSize(cardSize);
		card5 = new JPanel();
		card5.setBackground(cardWhite);
		card5.setPreferredSize(cardSize);
		
		playerView.setLayout(new GridLayout(2, 1));
		//playerCards.setLayout(new GridLayout(1, 5));
		//playerControls.setLayout(new GridLayout(1, 6));
		playerCards.add(card1);
		playerCards.add(card2);
		playerCards.add(card3);
		playerCards.add(card4);
		playerCards.add(card5);
		
		playerView.add(playerCards);
		
		ActionListener listener = new dealingClickListener();
		//ActionListener listener2 = new cardOneClickListener();
		
		dealing = new JButton("Deal");
			
		cardOne = new JButton("Change Card One");
		cardTwo = new JButton("Change Card Two");
		cardThree = new JButton("Change Card Three");
		cardFour = new JButton("Change Card Four");
		cardFive = new JButton("Change Card Five");
		noChange = new JButton("Do not change.");
		
		
		cardOne.addActionListener(listener);
		cardTwo.addActionListener(listener);
		cardThree.addActionListener(listener);
		cardFour.addActionListener(listener);
		cardFive.addActionListener(listener);
		noChange.addActionListener(listener);
		dealing.addActionListener(listener);
		
		cardOne.setEnabled(false);
		cardTwo.setEnabled(false);
		cardThree.setEnabled(false);
		cardFour.setEnabled(false);
		cardFive.setEnabled(false);
		noChange.setEnabled(false);
		
		stateView.add(dealing);
		
		
		
		playerControls.add(cardOne);
		playerControls.add(cardTwo);
		playerControls.add(cardThree);
		playerControls.add(cardFour);
		playerControls.add(cardFive);
		playerControls.add(noChange);
		
		playerView.add(playerControls);

		add(playerView);
		add(stateView);
		add(dealerView);
	}
	
}
