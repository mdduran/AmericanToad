package mdduran;

import ks.common.games.Solitaire;
import ks.common.model.BuildablePile;
import ks.common.model.Card;
import ks.common.model.Column;
import ks.common.model.Move;
import ks.common.model.Pile;


public class WastePileToTableauMove extends Move {
	Pile wastePile;
	Column tableau;
	Card cardBeingMoved;
	int rankOfTableau;
	public WastePileToTableauMove(Pile from, Card cardBeingMoved, Column tableau2,
			int rankOfTableau) {
		this.wastePile = from;
		this.cardBeingMoved = cardBeingMoved;
		this.tableau = tableau2;
		this.rankOfTableau = rankOfTableau;
	}
	@Override
	public boolean doMove(Solitaire game) {
		if(!valid(game) && wastePile.empty()){return false;}
		//take card off of the top of the stack
		Card c = wastePile.get();
		tableau.add(c);
		game.updateScore(+1);
		return true;
	}

	@Override
	public boolean undo(Solitaire game) {
		if(!valid(game)){return false;}
		Card c = tableau.get();
		wastePile.add(c);
		game.updateScore(-1);
		return true;
	}

	@Override
	public boolean valid(Solitaire game) {
		if(cardBeingMoved.getRank() < tableau.rank() && !cardBeingMoved.oppositeColor(tableau.get())){
			return true;
		}
		if(cardBeingMoved.getRank() == rankOfTableau && tableau.empty()){
			return true;
		}
		return false;
	}
	
}
