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
//		TableauToFoundationMove ttf = new TableauToFoundationMove(americanToad.tableau8, americanToad.tableau8.peek(), americanToad.foundation1, americanToad.getRankOfFoundation());
//		assertTrue(ttf.valid(americanToad));
//		ttf.doMove(americanToad);
//		ttf.undo(americanToad);
//		assertTrue(ttf.undo(americanToad));
	}
	
	public void testPlacingAce(){
		 americanToad = new AmericanToad();
		 gw = Main.generateWindow(americanToad, MultiDeck.OrderByRank);
//		TableauToFoundationMove ttf = new TableauToFoundationMove(americanToad.tableau8, americanToad.tableau8.peek(), americanToad.foundation2, americanToad.getRankOfFoundation() );
	//	assertTrue(ttf.valid(americanToad));
		//ttf.doMove(americanToad);
		
		
	}

}
