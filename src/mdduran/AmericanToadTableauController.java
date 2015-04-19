package mdduran;

import heineman.idiot.MoveCardMove;

import java.awt.event.MouseEvent;

import ks.common.model.Card;
import ks.common.model.Column;
import ks.common.model.Move;
import ks.common.model.Pile;
import ks.common.model.Stack;
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
//	/**
//	 * Coordinate reaction to the completion of a Drag Event.
//	 * <p>
//	 * A bit of a challenge to construct the appropriate move, because cards
//	 * can be dragged both from the WastePile (as a CardView object) and the 
//	 * BuildablePileView (as a ColumnView).
//	 * @param me java.awt.event.MouseEvent
//	 */
//	public void mouseReleased(MouseEvent me) {
//		Container c = theGame.getContainer();
//
//		/** Return if there is no card being dragged chosen. */
//		Widget draggingWidget = c.getActiveDraggingObject();
//		if (draggingWidget == Container.getNothingBeingDragged()) {
//			System.err.println ("AmericanToadTableauController::mouseReleased() unexpectedly found nothing being dragged.");
//			c.releaseDraggingObject();		
//			return;
//		}
//
//		/** Must be cardview widget */
//		
//		CardView cardView = (CardView) draggingWidget;
//		Card theCard = (Card) cardView.getModelElement();
//		Widget fromWidget = c.getDragSource();
//		if(theCard == null){
//			System.err.println("AmericanToad::releaseCardController(): somehow the cardview model element is null ");
//			return;
//		}
//		Column fromColumn = (Column) fromWidget.getModelElement();
//		Stack toStack = (Stack) src.getModelElement();
//		
//		TableauMove m = new TableauMove(fromColumn, theCard, toStack, fromColumn.get().getRank());
//		
//		
//		Column tableau = (Column) src.getModelElement();
//		if(fromWidget instanceof ColumnView){
//			//coming from column pile
//			Column fromPile = (Column) fromWidget.getModelElement();
//			/** Must be the ColumnView widget being dragged. */
//			ColumnView columnView = (ColumnView) draggingWidget;
//			Column col = (Column) columnView.getModelElement();
//			if(col == null){
//				System.err.println("AmericanToadTableauController::mouseReleased(): somehow ColumnView model element is null.");
//				c.releaseDraggingObject();
//				return;
//			}
//			// must use peek() so we don't modify col prematurely. Here is a HACK! Presumably
//			// we only want the Move object to know things about the move, but we have to put
//			// in a check to verify that Column is of size one. NO good solution that I can
//			// see right now.
//			if (col.count() != 1) {
//				fromWidget.returnWidget (draggingWidget);  // return home
//			} else {
//				Move m2 = new TableauMove(fromPile, col.peek(), tableau, tableau.get().getRank());
//				if(m2.doMove (theGame)){
//					//Success
//					theGame.pushMove(m);
//				}
//				else{
//					fromWidget.returnWidget(draggingWidget);
//				}
//			}
//		}
//		else{
//			//Coming from a waste [number of cards being dragged must be one]
//			Pile wastePile = (Pile) fromWidget.getModelElement();
//			
//			
//			//must use peek so we do not modify the column prematurely
//			Move m3 = new WastePileToTableauMove(wastePile, theCard, tableau, tableau.get().getRank());
//			if(m3.doMove(theGame)){
//				//Success
//				theGame.pushMove(m);
//			}
//			else{
//				fromWidget.returnWidget(draggingWidget);
//			}
//		}
//		c.releaseDraggingObject();
//		c.repaint();
//	}
	
	/**
	 * Coordinate reaction to the beginning of a Drag Event.
	 * <p>
	 * Note: There is no way to differentiate between a press that
	 *       will become part of a double click vs. a click that will
	 *       be held and dragged. Only releaseCardController will be
	 *       able to help us out with that one.
	 * <p>
	 * Note: uses KombatSolitaire v1.6 capability of having container remember drag source widget.
	 * <p>
	 * Creation date: (10/4/01 6:05:55 PM)
	 * @param me java.awt.event.MouseEvent
	 */
	public void mousePressed (java.awt.event.MouseEvent me) {
		Container c = theGame.getContainer();

		/** Return if there is no card to be chosen. */
		Column col = (Column) src.getModelElement();
		if (col.count() == 0) {
			c.releaseDraggingObject();
			return;
		}

		// Could be something! Verify that the user clicked on the TOP card in the Column.
		// Note that this method will alter the model for columnView if the condition is met.
		CardView cardView = src.getCardViewForTopCard(me);
		if (cardView == null) {
			return;
		}

		// If we get here, then the user has indeed clicked on the top card in the ColumnView and
		// we are able to now move it on the screen at will. For smooth action, the bounds for the
		// cardView widget reflect the original card location on the screen.
		Widget w = c.getActiveDraggingObject();
		if (w != Container.getNothingBeingDragged()) {
			System.err.println ("AmericanToad::pressCardController(): Unexpectedly encountered a Dragging Object during a Mouse press.");
			return;
		}

		// Tell container which object is being dragged, and where in that widget the mouse was clicked.
		c.setActiveDraggingObject (cardView, me);

		// Have container remember who initiated the drag
		c.setDragSource (src);

		// we simply redraw our source pile to avoid flicker,
		// rather than refreshing all widgets...
		src.redraw();
	}
	
	/**
	 * Coordinate reaction to the completion of a Drag Event.
	 * <p>
	 * Note: if cv is null, then it is assumed that the mouse was released on a non-ColumnView Widget
	 * and this is a sign that no move has been made by the user. When this happens, the card must
	 * be returned to the originating column from which it was dragged.
	 * <p>
	 * Note: uses KombatSolitaire v1.6 capability of having container remember drag source widget.
	 * <p>
	 * Creation date: (10/4/01 6:56:34 PM)
	 * @param cv edu.wpi.cs.solitaire.common.view.ColumnView
	 * @param me java.awt.event.MouseEvent
	 */
	public void mouseReleased (java.awt.event.MouseEvent me) {
		Container c = theGame.getContainer();

		/** Return if there is no card being dragged chosen. */
		Widget w = c.getActiveDraggingObject();
		if (w == Container.getNothingBeingDragged()) return;

		/** Must be the CardView widget. */
		CardView cardView = (CardView) w;
		Card theCard = (Card) cardView.getModelElement();
		if (theCard == null) {
			System.err.println ("AmericanToad::releaseCardController(): somehow CardView model element is null.");
			return;
		}

		/** Recover the From Column */
		Widget fromWidget = c.getDragSource();
		if (fromWidget == null) {
			System.err.println ("AmericanToad::releaseCardController(): somehow fromWidget is null.");
			return;
		}
		Column fromColumn = (Column) fromWidget.getModelElement();

		Column toColumn = (Column) src.getModelElement();

		// Try to make the move
		Move m = new TableauToTableauMove (fromColumn, theCard, toColumn, toColumn.get().getRank());
		if (m.doMove (theGame)) {
			// Successful move!  
			// add move to our set of moves
			theGame.pushMove (m);
		} else {
			// Invalid move. Restore dragging widget to source
			fromWidget.returnWidget (w);
		}

		c.releaseDraggingObject();    // also releases dragSource

		c.repaint();
	}
}