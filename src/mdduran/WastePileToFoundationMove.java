package mdduran;

import ks.common.games.Solitaire;
import ks.common.model.Card;
import ks.common.model.Pile;

/**
 * Move card from top of the waste pile to the top of the foundation pile
 * @author Marco
 *
 */
public class WastePileToFoundationMove extends FoundationMove {
	Pile wastePile;
	Card cardBeingDragged;
	Pile foundation;
	int rankOfFoundation;
	
	public WastePileToFoundationMove(Pile from,Card cardBeingDragged, Pile to, int rankOfFoundation){
		super(from, cardBeingDragged, to, rankOfFoundation);
		this.wastePile = from;
	}
	@Override
	public boolean doMove(Solitaire game) {
		if(!valid(game)){return false;}
		//take top card off of wastepile
		Card c = wastePile.get();
		foundation.add(c);
		game.updateScore(+1);
		return true;
		//move on to top of foundation
		
		
		
	}

	@Override
	public boolean undo(Solitaire game) {
		if(!valid(game)){
			return false;
		}
		Card c = foundation.get();
		wastePile.add(c);
		game.updateScore(-1);
		return true;
	}

	@Override
	public boolean valid(Solitaire game) {
		
		if(cardBeingDragged.getRank() > foundation.suit()&& !cardBeingDragged.oppositeColor(foundation.get()) ){
			return true;
		}
		if(cardBeingDragged.getRank() == rankOfFoundation && foundation.empty()){
			return true;
		}
		return false;
		
	}

}
