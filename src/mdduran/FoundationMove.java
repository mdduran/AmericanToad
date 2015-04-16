package mdduran;

import ks.common.games.Solitaire;
import ks.common.model.Card;
import ks.common.model.Move;
import ks.common.model.Pile;
import ks.common.model.Stack;

public class FoundationMove extends Move {
	Pile foundationPile;
	Stack stack;
	int rankOfFoundation;
	Card cardBeingMoved;
	
	public FoundationMove(Stack from, Card cardBeingMoved, Pile to, int rankOfFoundation){
		this.stack = from;
		this.cardBeingMoved = cardBeingMoved;
		this.foundationPile = to;
		this.rankOfFoundation = rankOfFoundation;
	}
	
	@Override
	public boolean doMove(Solitaire game) {
		if(!valid(game) && stack.empty()){return false;}
		//take card off of the top of the stack
		Card c = stack.get();
		foundationPile.add(c);
		game.updateScore(+1);
		return true;
	}

	@Override
	public boolean undo(Solitaire game) {
		if(!valid(game)){return false;}
		Card c = foundationPile.get();
		stack.add(c);
		game.updateScore(-1);
		return true;
	}

	@Override
	public boolean valid(Solitaire game) {
		if(cardBeingMoved.getRank() > foundationPile.rank() && !cardBeingMoved.oppositeColor(foundationPile.get())){
			return true;
		}
		if(cardBeingMoved.getRank() == rankOfFoundation && foundationPile.empty()){
			return true;
		}
		return false;
	}
	
}
