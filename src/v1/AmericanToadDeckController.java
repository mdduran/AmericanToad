package v1;

import ks.common.controller.SolitaireReleasedAdapter;
import ks.common.games.Solitaire;
import ks.common.model.Column;
import ks.common.model.Deck;
import ks.common.model.Move;
import ks.common.model.Pile;

/**
 * Controller for DeckView widgets used in Narcotic
 * @author MarcoCustom
 *
 */
public class AmericanToadDeckController extends SolitaireReleasedAdapter {

	public AmericanToadDeckController(Solitaire game) {
		super(game);
		
	}
	
	/**
	 * A MousePressed event on the DeckView is a signal to deal the next set
	 * of cards (if the deck is nonempty).
	 * 
	 * @param me  low-level mouse event
	 */
	public void mousePressed(java.awt.event.MouseEvent me){
		Deck deck = (Deck) theGame.getModelElement("deck");
		//Tableau Columns
		Column t1 = (Column) theGame.getModelElement("tableauColumn1");
		Column t2 = (Column) theGame.getModelElement("tableauColumn2");
		Column t3 = (Column) theGame.getModelElement("tableauColumn3");
		Column t4 = (Column) theGame.getModelElement("tableauColumn4");
		Column t5 = (Column) theGame.getModelElement("tableauColumn5");
		Column t6 = (Column) theGame.getModelElement("tableauColumn6");
		Column t7 = (Column) theGame.getModelElement("tableauColumn7");
		Column t8 = (Column) theGame.getModelElement("tableauColumn8");
		//Foundation Piles
		Pile f1 = (Pile) theGame.getModelElement("foundationPile1");
		Pile f2 = (Pile) theGame.getModelElement("foundationPile2");
		Pile f3 = (Pile) theGame.getModelElement("foundationPile3");
		Pile f4 = (Pile) theGame.getModelElement("foundationPile4");
		Pile f5 = (Pile) theGame.getModelElement("foundationPile5");
		Pile f6 = (Pile) theGame.getModelElement("foundationPile6");
		Pile f7 = (Pile) theGame.getModelElement("foundationPile7");
		Pile f8 = (Pile) theGame.getModelElement("foundationPile8");
		//Waste Pile
		Pile waste = (Pile) theGame.getModelElement("wastePile");
		//Reserve Pile
		Column reserve = (Column) theGame.getModelElement("reservePile");
		
	}
	
}
