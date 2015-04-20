package mdduran;

import ks.common.games.Solitaire;
import ks.common.model.Card;
import ks.common.model.Column;
import ks.common.model.Move;
import ks.common.model.Pile;


public class TableauToFoundationMove extends Move {
	Pile foundation;
	Column tableauColumn;
	Card cardBeingMoved;
	AmericanToad theGame;
	public TableauToFoundationMove(Column from, Card cardBeingMoved, Pile to, AmericanToad theGame) {
		super();
		this.tableauColumn = from;
		this.foundation = to;
		this.cardBeingMoved = cardBeingMoved;
		this.theGame = theGame;
	}
	@Override
	public boolean doMove(Solitaire game) {
		if(!valid(game)){
			return false;
		}
		foundation.add(cardBeingMoved);
		game.updateScore(+1);
		return true;
	}
	@Override
	public boolean undo(Solitaire game) {
		if(foundation.empty()){
			return false;
		}
		tableauColumn.add(foundation.get());
		game.updateScore(-1);
		return true;
	}
	@Override
	public boolean valid(Solitaire game) {
		boolean validation = false;
		if(foundation.empty() && cardBeingMoved.getRank() == theGame.getRankOfFoundation()){
			validation = true;
		}
		else if(!foundation.empty() && foundation.rank() == 13 && cardBeingMoved.getRank() == 1){
			validation = true;
		}
		else if(!foundation.empty() && cardBeingMoved.getSuit() == foundation.suit() && cardBeingMoved.getRank() == foundation.rank()+1){
			validation = true;
		}
		
		return validation;
	}

}
