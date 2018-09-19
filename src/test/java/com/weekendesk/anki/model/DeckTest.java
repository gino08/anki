package com.weekendesk.anki.model;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author mauro-sanchez
 */
public class DeckTest {

	@Test
	public void given_aNewDeck_when_verifiedIsEmpty_then_returnTrue() {
		Assert.assertTrue(new Deck().isEmpty());
		Assert.assertEquals(new Deck().getSize(), 0);
    }

    @Test
    public void given_aNewDeckAndAddCard_when_verifiedIsEmpty_then_returnFalse() {
    	Card card = new Card("question", "answer");
        Deck deck = new Deck();
        deck.addCard(card);
        Assert.assertFalse(deck.isEmpty());
        Assert.assertEquals(deck.getSize(), 1);
    }
    
    @Test
    public void given_aNewDeckAndAddCard_when_verifiedSize_then_returnOne() {
    	Card card = new Card("question", "answer");
        Deck deck = new Deck();
        deck.addCard(card);
        Assert.assertEquals(deck.getSize(), 1);
    }
    
    @Test
    public void given_aNewDeckAddAndRemoveCard_when_verifiedIsEmpty_then_returnTrue() {
    	Card card = new Card("question", "answer");
        Deck deck = new Deck();
        deck.addCard(card);
        deck.removeCard(card);
        Assert.assertTrue(deck.isEmpty());
        Assert.assertEquals(deck.getSize(), 0);
    }
    
    @Test
    public void given_aNewDeckWithTwoCardsAndClearDeck_when_verifiedIsEmpty_then_returnTrue() {
    	Card card1 = new Card("question1", "answer1");
    	Card card2 = new Card("question2", "answer2");
        Deck deck = new Deck();
        deck.addCard(card1);
        deck.addCard(card2);
        deck.clearCards();
        Assert.assertTrue(deck.isEmpty());
        Assert.assertEquals(deck.getSize(), 0);
    }

}
