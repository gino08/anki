package com.weekendesk.anki.model;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author mauro-sanchez
 */
public class CardTest {
	
	@Test(expected = NullPointerException.class)
	public void given_aNullQuestion_when_createCard_then_nullPointerException() {
		new Card(null, "answer");
	}
	
	@Test(expected = NullPointerException.class)
	public void given_aNullAnswer_when_createCard_then_nullPointerException() {
		new Card("question", null);
	}
	
	@Test
	public void given_aQuestionAndAnswer_when_createCard_then_createSuccess() {
		Assert.assertNotNull(new Card("question", "answer"));
	}
	
	@Test
	public void given_aTwoCardsWithSameQuestionAndAnswer_when_useEquals_then_returnTrue() {
        Card cardOne = new Card("question", "answer");
        Card cardTwo = new Card("question", "answer");
        Assert.assertTrue(cardOne.equals(cardTwo));
    }

    @Test
    public void given_aTwoCardsWithDifferentQuestionAndAnswer_when_useEquals_then_returnFalse() {
    	Card cardOne = new Card("question1", "answer1");
        Card cardTwo = new Card("question2", "answer2");
        Assert.assertFalse(cardOne.equals(cardTwo));
    }
    
    @Test
    public void given_aTwoCardsInAlphabeticOrderByQuestion_when_compare_then_returnNegativeInteger() {
    	Card cardOne = new Card("question1", "answer1");
        Card cardTwo = new Card("question2", "answer2");
        Assert.assertTrue(Card.cardQuestionComparator.compare(cardOne, cardTwo) < 0);
    }
    
    @Test
    public void given_aTwoCardsInAlphabeticDisorderByQuestion_when_compare_then_returnPositiveInteger() {
    	Card cardOne = new Card("question2", "answer2");
        Card cardTwo = new Card("question1", "answer1");
        Assert.assertTrue(Card.cardQuestionComparator.compare(cardOne, cardTwo) > 0);
    }
    
    @Test
    public void given_aTwoCardsInAlphabeticOrderByAnswer_when_compare_then_returnNegativeInteger() {
    	Card cardOne = new Card("question1", "answer1");
        Card cardTwo = new Card("question2", "answer2");
        Assert.assertTrue(Card.cardAnswerComparator.compare(cardOne, cardTwo) < 0);
    }
    
    @Test
    public void given_aTwoCardsInAlphabeticDisorderByAnswer_when_compare_then_returnPositiveInteger() {
    	Card cardOne = new Card("question2", "answer2");
        Card cardTwo = new Card("question1", "answer1");
        Assert.assertTrue(Card.cardAnswerComparator.compare(cardOne, cardTwo) > 0);
    }
}
