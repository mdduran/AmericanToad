package mdduran;

import junit.framework.TestCase;
import ks.client.gamefactory.GameWindow;
import ks.common.model.Card;
import ks.common.model.Column;
import ks.common.model.MultiDeck;
import ks.common.model.Pile;
import ks.launcher.Main;

public class TestTableauToFoundationMove extends TestCase {
	AmericanToad americanToad;
	Pile testFoundation;
	Column testTableau;
	Card testAce;
	Card testTwo;
	Card testKing;
	Card testQueen;
	
	GameWindow gw;
	public void setUp(){
		 
		
	}
	public void testSimple(){
		americanToad = new AmericanToad();
		 gw = Main.generateWindow(americanToad, MultiDeck.OrderBySuit);
		TableauToFoundationMove ttf = new TableauToFoundationMove(americanToad.tableau8, americanToad.tableau8.peek(), americanToad.foundation1, americanToad.getRankOfFoundation());
		assertTrue(ttf.valid(americanToad));
		assertTrue(ttf.doMove(americanToad));
		ttf.doMove(americanToad);
		assertTrue(ttf.undo(americanToad));
		ttf.undo(americanToad);
		
	}
	
	public void testPlacingAce(){
		 americanToad = new AmericanToad();
		 gw = Main.generateWindow(americanToad, MultiDeck.OrderByRank);
		 americanToad.foundation1.removeAll();
		 Card testAce = new Card(Card.ACE, Card.CLUBS);
		 Card testKing = new Card(Card.KING, Card.CLUBS);
		 americanToad.tableau1.add(testAce);
		 americanToad.foundation1.add(testKing);
		 assertFalse(americanToad.foundation1.empty());
		 assertEquals(americanToad.tableau1.get().getRank(), Card.ACE);
		 assertEquals(americanToad.foundation1.get().getRank(), Card.KING);
		 assertTrue(americanToad.foundation1.count() <= 13);
		 assertTrue(americanToad.foundation1.count() != 13);
		 
		TableauToFoundationMove ttf = new TableauToFoundationMove(americanToad.tableau1, americanToad.tableau1.peek(), americanToad.foundation1, americanToad.getRankOfFoundation()+2);
		assertTrue(ttf.valid(americanToad));
		assertTrue(ttf.doMove(americanToad));
		ttf.doMove(americanToad);
		
		
	}
	
	public void testEmpty(){
		AmericanToad at = new AmericanToad();
		gw = Main.generateWindow(at, 0);
		
	}

}
