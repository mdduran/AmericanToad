package mdduran;

import ks.common.model.Card;
import ks.common.model.Column;
import ks.common.model.Pile;

public class WastePileToTableauMove extends TableauMove {
	Pile wastePile;
	public WastePileToTableauMove(Pile from, Card cardBeingMoved, Column to,
			int rankOfTableau) {
		super(from, cardBeingMoved, to, rankOfTableau);
		this.wastePile = from;
	}
	
}
