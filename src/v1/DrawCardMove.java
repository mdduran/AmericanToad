package v1;

import ks.common.games.Solitaire;
import ks.common.model.Deck;
import ks.common.model.Move;
import ks.common.model.Pile;

public class DrawCardMove extends Move {
	/**The deck */
	protected Deck deck;
	
	/** The Waste Pile */
	protected Pile wastePile;
	
	public DrawCardMove(Deck d, Pile waste){
		super();
		
		/**
		 * Store all parameters with the Move Object
		 */
		this.deck = d;
		this.wastePile = waste;
	}
	@Override
	public boolean doMove(Solitaire game) {
		// If there is at least one card in the deck, add one card to the waste pile, remove one card from the deck
		if(valid(game) == false)
		return false;
		
		//Execute
		wastePile.add(deck.get());
		//update count in the deck
		game.updateNumberCardsLeft(-1);
		return true;
	}

	@Override
	public boolean undo(Solitaire game) {
		if(wastePile.empty())
		return false;
		//UNDO:
		//Reverse the order of events
		deck.add(wastePile.get());
		//update count in deck
		game.updateNumberCardsLeft(+1);
		return true;
	}

	@Override
	public boolean valid(Solitaire game) {
		boolean validation = false;
		
		//Validate
		// DrawCardMove(d): not d.empty()
		if(!deck.empty()){
			validation = true;
		}
		return validation;
	}
	
}
