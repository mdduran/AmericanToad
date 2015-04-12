package v1;

import ks.common.games.Solitaire;
import ks.common.model.Deck;
import ks.common.model.Pile;

/**
 * Represents the reset of the deck.
 * <p>
 * Note that this move cannot be undone.
 * <p> *
 * 
 * @author Marco Duran
 *
 */
public class ResetDeckMove extends ks.common.model.Move {
	/** The deck */
	protected Deck deck;
	
	/** Tableau Piles */
	protected Pile tableauPile1;
	protected Pile tableauPile2;
	protected Pile tableauPile3;
	protected Pile tableauPile4;
	protected Pile tableauPile5;
	protected Pile tableauPile6;
	protected Pile tableauPile7;
	protected Pile tableauPile8;
	
	/** Foundation Piles */
	protected Pile foundationPile1;
	protected Pile foundationPile2;
	protected Pile foundationPile3;
	protected Pile foundationPile4;
	protected Pile foundationPile5;
	protected Pile foundationPile6;
	protected Pile foundationPile7;
	protected Pile foundationPile8;
	
	/** Waste Pile */
	protected Pile wastePile;
	
	/** Reserve Pile */
	protected Pile reservePile;
	
	/**
	 * ResetDeckMove constructor
	 */
	public ResetDeckMove(Deck d, Pile t1, Pile t2, Pile t3, Pile t4, Pile t5, Pile t6, Pile t7,
							Pile t8, Pile f1,Pile f2,Pile f3,Pile f4,Pile f5,Pile f6,Pile f7,Pile f8,
							Pile waste, Pile reserve){
		super();
		
		this.deck = d;
		this.tableauPile1 = t1;
		this.tableauPile2 = t2;
		this.tableauPile3 = t3;
		this.tableauPile4 = t4;
		this.tableauPile5 = t5;
		this.tableauPile6 = t6;
		this.tableauPile7 = t7;
		this.tableauPile8 = t8;
		this.foundationPile1 = f1;
		this.foundationPile2 = f2;
		this.foundationPile3 = f3;
		this.foundationPile4 = f4;
		this.foundationPile5 = f5;
		this.foundationPile6 = f6;
		this.foundationPile7 = f7;
		this.foundationPile8 = f8;
		this.wastePile = waste;
		this.reservePile = reserve;
	}
	
	public boolean doMove(Solitaire theGame){
		if(valid(theGame) == false){
			return false;
		}
		//Execute:
		int numAdded = 0;
		while(!tableauPile1.empty()){
			deck.add(tableauPile1.get());
			numAdded++;
		}
		while(!tableauPile2.empty()){
			deck.add(tableauPile2.get());
			numAdded++;
		}
		while(!tableauPile3.empty()){
			deck.add(tableauPile3.get());
			numAdded++;
		}
		while(!tableauPile4.empty()){
			deck.add(tableauPile4.get());
			numAdded++;
		}
		while(!tableauPile5.empty()){
			deck.add(tableauPile5.get());
			numAdded++;
		}
		while(!tableauPile6.empty()){
			deck.add(tableauPile6.get());
			numAdded++;
		}
		while(!tableauPile7.empty()){
			deck.add(tableauPile7.get());
			numAdded++;
		}
		while(!tableauPile8.empty()){
			deck.add(tableauPile8.get());
			numAdded++;
		}
		while(!foundationPile1.empty()){
			deck.add(foundationPile1.get());
			numAdded++;
		}
		while(!foundationPile2.empty()){
			deck.add(foundationPile2.get());
			numAdded++;
		}
		while(!foundationPile3.empty()){
			deck.add(foundationPile3.get());
			numAdded++;
		}
		while(!foundationPile4.empty()){
			deck.add(foundationPile4.get());
			numAdded++;
		}
		while(!foundationPile5.empty()){
			deck.add(foundationPile5.get());
			numAdded++;
		}
		while(!foundationPile6.empty()){
			deck.add(foundationPile6.get());
			numAdded++;
		}
		while(!foundationPile7.empty()){
			deck.add(foundationPile7.get());
			numAdded++;
		}
		while(!foundationPile8.empty()){
			deck.add(foundationPile8.get());
			numAdded++;
		}
		while(!wastePile.empty()){
			deck.add(wastePile.get());
			numAdded++;
		}
		while(!reservePile.empty()){
			deck.add(reservePile.get());
			numAdded++;
		}
		//finally update the total number
		theGame.updateNumberCardsLeft(numAdded);
		return true;
	}	
	
	public boolean undo(ks.common.games.Solitaire game){
		//cannot undo this move
		return false;
	}
	
	//Validate this move
	public boolean valid(ks.common.games.Solitaire game){
		boolean validation = false;
		
		if(deck.empty()){
			validation = true;
		}
		return validation;
	}
}
