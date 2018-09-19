package com.weekendesk.anki.dao;

import com.weekendesk.anki.model.Deck;

/**
 * Interface manage decks in files.
 *
 * @author mauro-sanchez
 */
public interface DeckFileDao {
	
	Deck load(String path);
	
	void save(Deck deck, String path);
	
	boolean isExistDeck(String path);
	
	void createInitialEmptyDeck(String path);
	
	void createInitialDeck(String pathFrom, String pathTo);
	
}
