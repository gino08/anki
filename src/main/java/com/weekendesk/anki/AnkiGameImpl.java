package com.weekendesk.anki;

import com.weekendesk.anki.model.Box;
import com.weekendesk.anki.model.Card;
import com.weekendesk.anki.model.Deck;
import com.weekendesk.anki.services.DeckService;
import com.weekendesk.anki.services.DeckServiceFiles;
import com.weekendesk.anki.ui.AnkiGameUI;

/**
 * Implementation of the interface AnkiGame.
 * 
 * Maintains the state of the game.
 * Has control of the session and decks.
 *
 * @author mauro-sanchez
 */
public class AnkiGameImpl implements AnkiGame {
	
	private Deck allCardsDeck;
    private Deck redDeck;
    private Deck orangeDeck;
    private Deck greenDeck;
	private AnkiSession session;
	private DeckService deckService;
    private AnkiGameUI ankiGameUI;
    
    private AnkiGameImpl() {
    }
    
    public static AnkiGame createAnkiGame() {
        return new AnkiGameImpl();
    }
    
	@Override
	public void play(AnkiGameUI ankiGameUI) {
		setUpGame();
		this.ankiGameUI = ankiGameUI;
		loadDecks();
		refreshStatusDecksSession();
		ankiGameUI.initSession(session);
		answerCards();
		if (!finishGame()) {
			refreshDecks();
		}
		refreshStatusDecksSession();
        ankiGameUI.finishSession(session);
        saveDecks();
	}
	
	private void setUpGame() {
		this.deckService = new DeckServiceFiles();
		this.deckService.setUpDecks();
    	this.allCardsDeck = deckService.loadAllCardsDeck();
    	this.allCardsDeck.sortCards(Card.cardQuestionComparator);
	}

	public boolean finishGame() {
		return allCardsDeck.getSize() == greenDeck.getSize();
	}

	private void loadDecks() {
		redDeck = deckService.loadRedDeck();
		orangeDeck = deckService.loadOrangeDeck();
		greenDeck = deckService.loadGreenDeck();
	}
	
	private void saveDecks() {
		if (finishGame()) {
			redDeck.clearCards();
			orangeDeck.clearCards();
			greenDeck.clearCards();
		}
			
		deckService.saveRedDeck(redDeck);
		deckService.saveOrangeDeck(orangeDeck);
		deckService.saveGreenDeck(greenDeck);
	}
	
	private void refreshStatusDecksSession() {
		if (session == null) {
			this.session = new AnkiSession(allCardsDeck.getSize(), redDeck.getSize(), orangeDeck.getSize(), greenDeck.getSize());
		}
		else {
			session.setRedDeckSize(redDeck.getSize());
			session.setOrangeDeckSize(orangeDeck.getSize());
			session.setGreenDeckSize(greenDeck.getSize());
		}
	}
	
	private boolean newGame() {
        return redDeck.isEmpty() && orangeDeck.isEmpty() && greenDeck.isEmpty();
    }
	
	private void answerCards() {
		if (newGame()) {
			displayCardsDeck((Deck) allCardsDeck.clone());
        }
        while (!redDeck.isEmpty()) {
        	displayCardsDeck(redDeck);
        }
	}
	
	private void displayCardsDeck(Deck deck) {
		Deck deckClone = (Deck) deck.clone();
		deckClone.getCards().forEach(card -> {
			ankiGameUI.showQuestion(card.getQuestion());
			ankiGameUI.showAnswer(card.getAnswer());
			ankiGameUI.showQuestionBox();
			Box box = ankiGameUI.getSelectedBox();
			deck.removeCard(card);
			loadCardIntoBox(box, card);
		});
	}
	
	private void loadCardIntoBox(Box box, Card card) {
        if (box == Box.RED) {
            redDeck.addCard(card);
        } else if (box == Box.ORANGE) {
            orangeDeck.addCard(card);
        } else {
            greenDeck.addCard(card);
        }
    }
	
	private void refreshDecks() {
		orangeDeck.getCards().forEach(redDeck::addCard);
        orangeDeck.clearCards();
        greenDeck.getCards().forEach(orangeDeck::addCard);
        greenDeck.clearCards();
	}
}
