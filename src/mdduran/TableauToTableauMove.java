package mdduran;

import ks.common.model.BuildablePile;
import ks.common.model.Card;


public class TableauToTableauMove extends TableauMove{
	BuildablePile fromTableau;	
	public TableauToTableauMove(BuildablePile from, Card cardBeingMoved, BuildablePile to, int rankOfTableau){
		super(from, cardBeingMoved, to, rankOfTableau);
		this.fromTableau = from;
		
	}
}
