package mdduran;

import junit.framework.TestCase;
import ks.client.gamefactory.GameWindow;
import ks.common.model.Card;
import ks.common.model.MultiDeck;
import ks.launcher.Main;

public class TestDrawCardMove extends TestCase {
	public void testSimple(){
		AmericanToad americanToad = new AmericanToad();
		@SuppressWarnings("unused")
		GameWindow gw = Main.generateWindow(americanToad, MultiDeck.OrderBySuit);
		
		Card topCard = americanToad.deck.peek();
		DrawCardMove dcm = new DrawCardMove(americanToad.deck, americanToad.wastePile);
	
		assertTrue(dcm.valid(americanToad));
		
		dcm.doMove(americanToad);
		
		assertEquals(103, americanToad.getNumLeft().getValue());
		assertEquals(topCard, americanToad.wastePile.peek());
		int deckvalue = americanToad.getNumLeft().getValue();
		
		assertEquals(103, deckvalue);
		
		dcm.undo(americanToad);
		
		assertEquals(75, americanToad.deck.count());
	}
}
