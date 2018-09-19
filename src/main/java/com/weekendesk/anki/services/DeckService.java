package com.weekendesk.anki.services;

import com.weekendesk.anki.model.Deck;

/**
 * Interface load and save decks game.
 *
 * @author mauro-sanchez
 */
public interface DeckService {
	
	Deck loadAllCardsDeck();
	
	Deck loadRedDeck();
	
	void saveRedDeck(Deck deck);
	
	Deck loadOrangeDeck();
	
	void saveOrangeDeck(Deck deck);
	
	Deck loadGreenDeck();
	
	void saveGreenDeck(Deck deck);
	
	void setUpDecks();
	
}
