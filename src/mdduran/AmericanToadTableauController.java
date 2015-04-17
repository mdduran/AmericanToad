package mdduran;

import java.awt.event.MouseEvent;

import ks.common.model.BuildablePile;
import ks.common.model.Card;
import ks.common.model.Column;
import ks.common.model.Move;
import ks.common.model.Pile;
import ks.common.view.BuildablePileView;
import ks.common.view.CardView;
import ks.common.view.ColumnView;
import ks.common.view.Container;
import ks.common.view.Widget;

public class AmericanToadTableauController extends java.awt.event.MouseAdapter {
	//American toad game
	protected AmericanToad theGame;
	
	//Specific  tableau column view being controlled
	protected ColumnView src;
	
	//TableauController constructor
	public AmericanToadTableauController(AmericanToad theGame, ColumnView tableau){
		super();
		this.theGame = theGame;
		this.src = tableau;
	}
	/**
	 * Coordinate reaction to the completion of a Drag Event.
	 * <p>
	 * A bit of a challenge to construct the appropriate move, because cards
	 * can be dragged both from the WastePile (as a CardView object) and the 
	 * BuildablePileView (as a ColumnView).
	 * @param me java.awt.event.MouseEvent
	 */
	public void mouseReleased(MouseEvent me) {
		Container c = theGame.getContainer();

		/** Return if there is no card being dragged chosen. */
		Widget draggingWidget = c.getActiveDraggingObject();
		if (draggingWidget == Container.getNothingBeingDragged()) {
			System.err.println ("AmericanToadTableauController::mouseReleased() unexpectedly found nothing being dragged.");
			c.releaseDraggingObject();		
			return;
		}

		/** Recover the from BuildablePile OR waste Pile */
		Widget fromWidget = c.getDragSource();
		if (fromWidget == null) {
			System.err.println ("AmericanToadTableauController::mouseReleased(): somehow no dragSource in container.");
			c.releaseDraggingObject();
			return;
		}
		BuildablePile tableau = (BuildablePile) src.getModelElement();
		if(fromWidget instanceof BuildablePileView){
			//coming from buildable pile
			BuildablePile fromPile = (BuildablePile) fromWidget.getModelElement();
			/** Must be the ColumnView widget being dragged. */
			ColumnView columnView = (ColumnView) draggingWidget;
			Column col = (Column) columnView.getModelElement();
			if(col == null){
				System.err.println("AmericanToadTableauController::mouseReleased(): somehow ColumnView model element is null.");
				c.releaseDraggingObject();
				return;
			}
			// must use peek() so we don't modify col prematurely. Here is a HACK! Presumably
			// we only want the Move object to know things about the move, but we have to put
			// in a check to verify that Column is of size one. NO good solution that I can
			// see right now.
			if (col.count() != 1) {
				fromWidget.returnWidget (draggingWidget);  // return home
			} else {
				Move m = new TableauMove(fromPile, col.peek(), tableau, tableau.get().getRank());
				if(m.doMove (theGame)){
					//Success
					theGame.pushMove(m);
				}
				else{
					fromWidget.returnWidget(draggingWidget);
				}
			}
		}
		else{
			//Coming from a waste [number of cards being dragged must be one]
			Pile wastePile = (Pile) fromWidget.getModelElement();
			
			/** Must be the CardView widget being dragged. */
			CardView cardView = (CardView) draggingWidget;
			Card theCard = (Card) cardView.getModelElement();
			if(theCard == null){
				System.err.println("AmericanToadTableauController::mouseReleased(): somehow CardView model element is null.");
				c.releaseDraggingObject();
				return;
			}
			//must use peek so we do not modify the column prematurely
			Move m = new WastePileToTableauMove(wastePile, theCard, tableau, tableau.get().getRank());
			if(m.doMove(theGame)){
				//Success
				theGame.pushMove(m);
			}
			else{
				fromWidget.returnWidget(draggingWidget);
			}
		}
		c.releaseDraggingObject();
		c.repaint();
	}
}