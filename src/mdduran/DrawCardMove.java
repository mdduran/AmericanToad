package mdduran;

import ks.common.games.Solitaire;
import ks.common.model.Move;
import ks.common.model.MultiDeck;
import ks.common.model.Pile;
/**
 * Move cards from top of deck to top of waste pile
 * @author Marco Duran
 *
 */
public class DrawCardMove extends Move {
	MultiDeck deck;
	Pile wastePile;
	@Override
	public boolean doMove(Solitaire game) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean undo(Solitaire game) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean valid(Solitaire game) {
		return false;
	}

}
