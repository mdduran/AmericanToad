package mdduran;




import ks.common.model.Card;
import ks.common.model.Column;
import ks.common.model.Move;
import ks.common.model.Pile;
import ks.common.model.Stack;
import ks.common.view.CardView;
import ks.common.view.Container;
import ks.common.view.PileView;
import ks.common.view.Widget;

public class AmericanToadFoundationController extends java.awt.event.MouseAdapter {

	/** The American Toad Game */
	protected AmericanToad theGame;
	/** The specific Foundation pileView being controlled. */
	protected PileView src;
	/**
	 * FoundationController constructor comment.
	 */
	public AmericanToadFoundationController(AmericanToad theGame, PileView foundation){
		super();
		
		this.theGame = theGame;
		this.src = foundation;
	}
	
//	/**
//	 * Coordinate reaction to the completion of a Drag Event.
//	 * <p>
//	 * A bit of a challenge to construct the appropriate move, 
//	 * can be dragged both from the WastePile(as a cardview)
//	 * And a BuildablePileView(as a columnView)
//	 * @param me java.awt.event.MouseEvent
//	 */
//	public void mouseReleased(MouseEvent me){
//		Container c = theGame.getContainer();
//		
//		/** Return if there is no card being dragged chosen. */
//		Widget draggingWidget = c.getActiveDraggingObject();
//		if(draggingWidget == Container.getNothingBeingDragged()){
//			System.err.println("FoundationPileController::mouseReleased() unexpectedly found nothing being dragged. ");
//			c.releaseDraggingObject();
//			return;
//		}
//		/** Recover the from BuildablePile, OR waste Pile */
//		Widget fromWidget = c.getDragSource();
//		if(fromWidget == null){
//			System.err.println("FoundationController::mouseReleased(): somehow no dragSource in container.");
//			c.releaseDraggingObject();
//			return;
//		}
//		
//		//Determine the To Pile
//		Pile foundation = (Pile) src.getModelElement();
//		
//		if(fromWidget instanceof ColumnView){
//			//coming from a buildable pile [user may be trying to move multiple cards]
//			Column fromColumn = (Column) fromWidget.getModelElement();
//			/** Must be the ColumnView widget being dragged. */
//			ColumnView columnView = (ColumnView) draggingWidget;
//			Column col = (Column) columnView.getModelElement();
//			if(col == null){
//				System.err.println("FoundationPileController::mouseReleased(): somehow ColumnView model element is null.");
//				c.releaseDraggingObject();
//				return;
//			}
//			// must use peek() so we don't modify col prematurely. Here is a HACK! Presumably
//						// we only want the Move object to know things about the move, but we have to put
//						// in a check to verify that Column is of size one. NO good solution that I can
//						// see right now.
//						if (col.count() != 1) {
//							fromWidget.returnWidget (draggingWidget);  // return home
//						} else {
//							Move m = new FoundationMove(fromColumn, col.peek(), foundation, theGame.foundation1.rank());
//
//							if (m.doMove (theGame)) {
//								// Success
//								theGame.pushMove (m);
//							} else {
//								fromWidget.returnWidget (draggingWidget);
//							}
//						}
//					} else {
//						// Coming from the waste [number of cards being dragged must be one]
//						Pile wastePile = (Pile) fromWidget.getModelElement();
//
//						/** Must be the CardView widget being dragged. */
//						CardView cardView = (CardView) draggingWidget;
//						Card theCard = (Card) cardView.getModelElement();
//						if (theCard == null) {
//							System.err.println ("FoundationController::mouseReleased(): somehow CardView model element is null.");
//							c.releaseDraggingObject();
//							return;
//						}
//
//						// must use peek() so we don't modify col prematurely
//						Move m = new WastePileToFoundationMove(wastePile, theCard, foundation,theGame);
//						if (m.doMove (theGame)) {
//							// Success
//							theGame.pushMove (m);
//						} else {
//							fromWidget.returnWidget (draggingWidget);
//						}
//					}
//
//					// Ahhhh. Instead of dealing with multiple 'instanceof' difficulty, why don't we allow
//					// for multiple controllers to be set on the same widget? Each will be invoked, one
//					// at a time, until someone returns TRUE+ (stating that they are processing the event).
//					// Then we have controllers for each MOVE TYPE, not just for each entity. In this way,
//					// I wouldn't have to convert the CardView from wastePile into a ColumnView. I would
//					// still have to do some sort of instanceOf check, however, to validate: But if the
//					// instanceof failed, the controller could safely return and say NOT ME! See! There
//					// always is a way to avoid layered if statements in OO.
//
//					// release the dragging object, (this will reset dragSource)
//					c.releaseDraggingObject();
//					
//					// finally repaint
//					c.repaint();
//				}
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
		Stack from = (Stack) fromWidget.getModelElement();
		

		Pile toPile = (Pile) src.getModelElement();
		
		// Try to make the move
		//if frompile is a wastepile, try this move
		if(c.getDragSource().equals(theGame.wastePileView)){
			Pile fromPile = (Pile) from;
			Move m = new WastePileToFoundationMove (fromPile, theCard, toPile, theGame);
			if (m.doMove (theGame)) {
				// Successful move!  
				// add move to our set of moves
				theGame.pushMove (m);
			} else {
				// Invalid move. Restore dragging widget to source
				fromWidget.returnWidget (w);
			}
		}
		else if(c.getDragSource().equals(theGame.reserveColumnView)){
			Column fromReserve = (Column) from;
			Move m = new ReserveToFoundationMove (fromReserve, theCard, toPile, theGame);
			if (m.doMove (theGame)) {
				// Successful move!  
				// add move to our set of moves
				theGame.pushMove (m);
			} else {
				// Invalid move. Restore dragging widget to source
				fromWidget.returnWidget (w);
			}
		}
		else{
			Column fromTableau = (Column) from;
			Move m = new TableauToFoundationMove (fromTableau, theCard, toPile, theGame);
			if (m.doMove (theGame)) {
				// Successful move!  
				// add move to our set of moves
				theGame.pushMove (m);
			} else {
				// Invalid move. Restore dragging widget to source
				fromWidget.returnWidget (w);
			}
		}
		c.releaseDraggingObject();    // also releases dragSource

		c.repaint();
	}
}
