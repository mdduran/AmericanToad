package v1;

import ks.client.gamefactory.GameWindow;
import ks.common.controller.SolitaireReleasedAdapter;
import ks.common.games.Solitaire;
import ks.common.model.*;
import ks.common.view.*;
import ks.launcher.Main;

/**
 * 
 * @author MarcoDuran
 * <p>
 * NAME OF SOLITAIRE VARIATION: American Toad
 * <p>
 * DESCRIPTION:
 * Explain this game here
 * MODEL:
 * <p>
 * 	deck: two 52-card decks of playing cards<br>
 * 	continue model description here
 * <p>
 * VIEW:
 * <p>
 * 	DeckView for the deck. PileView for the piles. IntegerView for the scores.
 * <p>
 * CONTROLLERS:
 * <p>
 * Deck controller to deal cards to piles. Include move for showing the drag action.
 * <p>
 * INITIALIZATION:
 * <p>
 * shuffle both decks into one deck
 * deal one card face up to tableau1,2,3,4,5,6,7,8, foundation1 and waste
 * deal 19 cards face down to reserve column
 *
 */

public class AmericanToad extends Solitaire {
	/** Each game has a deck */
	protected Deck deck;
	
	/** And 8  tableau columns */
	protected Column tableauColumn1, tableauColumn2, tableauColumn3, tableauColumn4,
				   tableauColumn5, tableauColumn6, tableauColumn7, tableauColumn8;
	/** 8 Foundation Piles */
	protected Pile foundationPile1, foundationPile2, foundationPile3,
				   foundationPile4, foundationPile5, foundationPile6, 
				   foundationPile7, foundationPile8;
	/** A waste pile */
	protected Pile wastePile;
	
	/** And a reserve pile */
	protected Column reserveColumn;
	
	/** The view of the deck */
	protected DeckView deckView;
	
	/** The tableauViews */
	protected ColumnView tableauColumnView1, tableauColumnView2, tableauColumnView3,
					   tableauColumnView4,tableauColumnView5, tableauColumnView6,
					   tableauColumnView7, tableauColumnView8;
	
	/**The foundation views */
	protected PileView foundationPileView1, foundationPileView2, foundationPileView3,
	   				   foundationPileView4, foundationPileView5, foundationPileView6,
	   				   foundationPileView7, foundationPileView8;
	
	/** The waste and reserve views*/
	protected PileView wastePileView;
	
	protected ColumnView reservePileView;
	
	/**Display for the score */
	protected IntegerView scoreView;
	
	
	/**To select a new deck type */
	public String getDeckType(){
		return "big";
	}
	
	/**Prepare the controllers*/
	private void initializeController(){
		//Initialize Controllers for deck view
		deckView.setMouseAdapter(null);//add deck controller
	}
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasWon() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void initialize() {
		// TODO Auto-generated method stub
		
	}

}
