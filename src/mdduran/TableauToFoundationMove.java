package mdduran;

import ks.common.model.Card;
import ks.common.model.Column;
import ks.common.model.Pile;


public class TableauToFoundationMove extends FoundationMove {
	Pile foundation;
	Column tableauColumn;
	int rankOfFoundation;
	Card cardBeingMoved;
	public TableauToFoundationMove(Column from, Card cardBeingMoved, Pile to,
			int rankOfFoundation) {
		super(from, cardBeingMoved, to, rankOfFoundation);
		this.tableauColumn = from;
		this.foundation = to;
		
	}

}
