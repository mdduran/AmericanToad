package mdduran;

import ks.common.games.Solitaire;
import ks.common.model.Card;
import ks.common.model.Column;
import ks.common.model.Move;
import ks.common.model.Pile;

public class ReserveToFoundationMove extends Move{
	Column reserveColumn;
	Pile foundation;
	int rankOfFoundation;
	Card cardBeingMoved;
	public ReserveToFoundationMove(Column from, Card cardBeingMoved, Pile to,
			int rankOfFoundation) {
		super();
		this.reserveColumn = from;
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
