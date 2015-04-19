package mdduran;

import ks.common.games.Solitaire;
import ks.common.model.BuildablePile;
import ks.common.model.Card;
import ks.common.model.Column;
import ks.common.model.Move;

public class ReserveToTableauMove extends Move {
	Column reserve;
	public ReserveToTableauMove(Column from, Card cardBeingMoved, Column to,
			int rankOfTableau) {
		super();
		this.reserve = from;
	}
	@Override
	public boolean doMove(Solitaire game) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean undo(Solitaire game) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean valid(Solitaire game) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
