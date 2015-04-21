package mdduran;

import junit.framework.TestCase;
import ks.client.gamefactory.GameWindow;
import ks.common.model.Card;
import ks.common.model.MultiDeck;
import ks.launcher.Main;

public class TestWastePileToFoundationMove extends TestCase {
	public void testSimple(){
		AmericanToad americanToad = new AmericanToad();
		GameWindow gw = Main.generateWindow(americanToad, MultiDeck.OrderBySuit);
		DrawCardMove dcm = new DrawCardMove(americanToad.deck, americanToad.wastePile);
		for(int i = 0; i < 12; i++){
			dcm.doMove(americanToad);
		}
		WastePileToFoundationMove wtfm = new WastePileToFoundationMove(americanToad.wastePile,americanToad.wastePile.get(), americanToad.foundation8, americanToad);
		assertTrue(wtfm.valid(americanToad));
		wtfm.doMove(americanToad);
		assertEquals(63, americanToad.deck.count());
	
	}
}
