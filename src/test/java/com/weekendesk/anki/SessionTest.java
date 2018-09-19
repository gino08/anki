package com.weekendesk.anki;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author mauro-sanchez
 */
public class SessionTest {
	
	private static final int ALL_CARDS_DECK_SIZE = 3;
	private static final int EMPTY_RED_DECK_SIZE = 0;
	private static final int ONE_RED_DECK_SIZE = 1;
	private static final int EMPTY_ORANGE_DECK_SIZE = 0;
	private static final int TWO_ORANGE_DECK_SIZE = 2;
	private static final int EMPTY_GREEN_DECK_SIZE = 0;
	private static final int FULL_GREEN_DECK_SIZE = 3;

	@Test
	public void given_aDeckWithCardsAndEmptyBoxes_when_creatingNewAnkiSession_then_sessionStatusIsNewGame() {
        AnkiSession ankiSession = new AnkiSession(ALL_CARDS_DECK_SIZE, EMPTY_RED_DECK_SIZE, EMPTY_ORANGE_DECK_SIZE, EMPTY_GREEN_DECK_SIZE);
        Assert.assertTrue(ankiSession.isNewGame());
    }
	
	@Test
	public void given_aDeckWithCardsAndNotEmptyBoxes_when_creatingNewAnkiSession_then_sessionStatusIsNotNewGame() {
        AnkiSession ankiSession = new AnkiSession(ALL_CARDS_DECK_SIZE, ONE_RED_DECK_SIZE, TWO_ORANGE_DECK_SIZE, EMPTY_GREEN_DECK_SIZE);
        Assert.assertFalse(ankiSession.isNewGame());
    }
	
	@Test
	public void given_aDeckWithCardsAndFullGreenBox_when_creatingNewAnkiSession_then_sessionStatusIsFinishGame() {
        AnkiSession ankiSession = new AnkiSession(ALL_CARDS_DECK_SIZE, EMPTY_RED_DECK_SIZE, EMPTY_ORANGE_DECK_SIZE, FULL_GREEN_DECK_SIZE);
        Assert.assertTrue(ankiSession.isFinishGame());
    }

}
