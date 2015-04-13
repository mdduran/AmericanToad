package mdduran;

import ks.common.games.Solitaire;
import ks.common.model.Card;
import ks.common.model.Move;
import ks.common.model.Pile;

/**
 * Move card from top of the waste pile to the top of the foundation pile
 * @author Marco
 *
 */
public class WastePileToFoundationMove extends Move {
	Pile wastePile;
	Card cardBeingDragged;
	Pile foundation;
	boolean isHigherRank;
	
	public WastePileToFoundationMove(Pile from,Card cardBeingDragged, Pile to, boolean isHigherRank){
		this.wastePile = from;
		this.cardBeingDragged = cardBeingDragged;
		this.foundation = to;
		this.isHigherRank = isHigherRank;
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
		// TODO Auto-generated method stub
		boolean draggingHigherCard = true;
		if(wastePile.empty()) return false;
		if(!isHigherRank && draggingHigherCard && cardBeingDragged.oppositeColor(foundation.get()) ){
			return true;
		}
		if(cardBeingDragged.getSuit() == foundation.suit() && !cardBeingDragged.oppositeColor(foundation.get())){
			return false;
		}
		return false;
		
	}

}
