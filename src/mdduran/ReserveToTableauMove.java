package mdduran;

import ks.common.model.BuildablePile;
import ks.common.model.Card;

public class ReserveToTableauMove extends TableauMove {
	BuildablePile reserve;
	public ReserveToTableauMove(BuildablePile from, Card cardBeingMoved, BuildablePile to,
			int rankOfTableau) {
		super(from, cardBeingMoved, to, rankOfTableau);
		this.reserve = from;
	}
	
}
