package mdduran;

import ks.common.model.Card;
import ks.common.model.Column;

public class ReserveToTableauMove extends TableauMove {
	Column reserve;
	public ReserveToTableauMove(Column from, Card cardBeingMoved, Column to,
			int rankOfTableau) {
		super(from, cardBeingMoved, to, rankOfTableau);
		this.reserve = from;
	}
	
}
