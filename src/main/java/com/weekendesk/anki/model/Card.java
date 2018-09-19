package com.weekendesk.anki.model;

import java.util.Comparator;
import java.util.Objects;

/**
 * Object representing a card.
 * 
 * @author mauro-sanchez
 */
public class Card implements Cloneable {
	
	public static Comparator<Card> cardQuestionComparator = Comparator.comparing(Card::getQuestion);
	public static Comparator<Card> cardAnswerComparator = Comparator.comparing(Card::getAnswer);

	private String question;
	private String answer;
	
	public Card(String question, String answer) {
		Objects.requireNonNull(question, "question cannot be null");
		Objects.requireNonNull(answer, "answer cannot be null");
		this.question = question;
		this.answer = answer;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	@Override
    public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj == this) {
	        return true;
		}
	    if (obj.getClass() != getClass())
	        return false;
	    
        Card card = (Card) obj;
        return question.equals(card.getQuestion()) 
        		&& answer.equals(card.getAnswer());
    }

    @Override
    public int hashCode() {
        return question.hashCode() + answer.hashCode();
    }
    
    public Object clone() {
		return new Card(question, answer);
	}
}
