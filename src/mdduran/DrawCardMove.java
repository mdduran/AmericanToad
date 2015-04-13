package mdduran;

import ks.common.games.Solitaire;
import ks.common.model.Card;
import ks.common.model.Move;
import ks.common.model.MultiDeck;
import ks.common.model.Pile;
import ks.common.model.Stack;
/**
 * Move cards from top of deck to top of waste pile
 * @author Marco Duran
 *
 */
public class DrawCardMove extends Move {
	MultiDeck deck;
	Stack stack;
	
	public DrawCardMove(MultiDeck deck, Stack stack){
		this.deck = deck;
		this.stack = stack;
	}
	
	@Override
	public boolean doMove(Solitaire game) {
		// TODO Auto-generated method stub
		if(!valid(game)){ return false;}
		
		Card card = deck.get();
		stack.add(card);
		game.updateNumberCardsLeft(-1);
		return true;
	}

	@Override
	public boolean undo(Solitaire game) {
		Card c = stack.get();
		deck.add(c);
		game.updateNumberCardsLeft(+1);
		return true;
	}

	@Override
	public boolean valid(Solitaire game) {
		return !deck.empty();
	}

}
