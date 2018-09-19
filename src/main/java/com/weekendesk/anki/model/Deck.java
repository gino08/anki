package com.weekendesk.anki.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Object representing a deck.
 * 
 * @author mauro-sanchez
 */
public class Deck implements Cloneable {

	private List<Card> cards;
	
	public Deck() {
		this.cards = new ArrayList<Card>();
	}

	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}

	public void addCard(Card card) {
		if (cards == null)
			cards = new ArrayList<Card>();
		
		cards.add(card);
	}
	
	public void removeCard(Card card) {
        cards.remove(card);
    }
	
	public void clearCards() {
        cards.clear();
    }
	
	public void addAll(List<Card> cards) {
        this.cards.addAll(cards);
    }
	
	public boolean isEmpty() {
        return cards == null || 
        		(cards != null && cards.isEmpty());
    }
	
	public int getSize() {
		if (this.isEmpty()) return 0;
		return cards.size();
	}
	
	public Object clone() {
		Deck deck = new Deck();
		cards.forEach(card -> deck.addCard((Card) card.clone()));
		return deck;
	}
	
	public void sortCards(Comparator<Card> cardComparator) {
        cards.sort(cardComparator);
    }
}
