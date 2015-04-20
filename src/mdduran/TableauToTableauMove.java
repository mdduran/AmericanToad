package mdduran;

import ks.common.games.Solitaire;
import ks.common.model.Card;
import ks.common.model.Column;
import ks.common.model.Move;


public class TableauToTableauMove extends Move{
	Column fromTableau;
	Column toTableau;
	Card cardBeingMoved;
	public TableauToTableauMove(Column from, Card cardBeingMoved, Column to){
		super();
		this.fromTableau = from;
		this.toTableau = to;
		this.cardBeingMoved = cardBeingMoved;
		
		
	}
	@Override
	public boolean doMove(Solitaire game) {
		if(!valid(game)){
			return false;
		}
		toTableau.add(cardBeingMoved);
		return true;
	}
	@Override
	public boolean undo(Solitaire game) {
		if(toTableau.empty()){
			return false;
		}
		//undo
		fromTableau.add(toTableau.get());
		return true;
	}
	@Override
	public boolean valid(Solitaire game) {
		boolean validation = false;
		if(toTableau.empty() != false){
			validation = true;
		}
		else if(!toTableau.empty() && cardBeingMoved.getRank() < toTableau.rank() && cardBeingMoved.getSuit() == toTableau.suit()){
			validation = true;
		}
		else{
			validation = false;
		}
		return validation;
	}
}
