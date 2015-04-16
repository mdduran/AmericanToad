package mdduran;

import ks.common.model.Card;
import ks.common.model.Column;

public class TableauToTableauMove extends TableauMove{
	Column fromTableau;	
	public TableauToTableauMove(Column from, Card cardBeingMoved, Column to, int rankOfTableau){
		super(from, cardBeingMoved, to, rankOfTableau);
		this.fromTableau = from;
		
	}
}
