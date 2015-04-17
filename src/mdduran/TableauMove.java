package mdduran;

import ks.common.games.Solitaire;
import ks.common.model.BuildablePile;
import ks.common.model.Card;
import ks.common.model.Move;

public class TableauMove extends Move {
	BuildablePile tableau;
	BuildablePile stack;
	int rankOfTableau;
	Card cardBeingMoved;
	
	public TableauMove(BuildablePile from, Card cardBeingMoved, BuildablePile to, int rankOfTableau){
		this.stack = from;
		this.cardBeingMoved = cardBeingMoved;
		this.tableau = to;
		this.rankOfTableau = rankOfTableau;
	}
	
	

	@Override
	public boolean doMove(Solitaire game) {
		if(!valid(game) && stack.empty()){return false;}
		//take card off of the top of the stack
		/*Card c = stack.get();
		tableau.add(c);*/
		Card c = tableau.get();
		stack.add(c);
		return true;
	}

	@Override
	public boolean undo(Solitaire game) {
		if(!valid(game)){return false;}
		Card c = stack.get();
		tableau.add(c);
		return true;
	}

	@Override
	public boolean valid(Solitaire game) {//fix logic
		if(cardBeingMoved.getRank() < tableau.rank() && !cardBeingMoved.oppositeColor(tableau.get())){
			return true;
		}
		if(cardBeingMoved.getRank() == rankOfTableau && tableau.empty()){
			return true;//fix it here TODO
		}
		return false;
	}
}
