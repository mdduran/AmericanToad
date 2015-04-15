package mdduran;

import ks.common.model.Card;
import ks.common.model.Column;
import ks.common.model.Pile;

public class ReserveToFoundationMove extends FoundationMove {
	Column reserveColumn;
	Pile foundation;
	int rankOfFoundation;
	Card cardBeingMoved;
	public ReserveToFoundationMove(Column from, Card cardBeingMoved, Pile to,
			int rankOfFoundation) {
		super(from, cardBeingMoved, to, rankOfFoundation);
		this.reserveColumn = from;
	}

}
