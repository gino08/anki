package com.weekendesk.anki.dao;

import org.junit.Assert;
import org.junit.Test;

import com.weekendesk.anki.model.Deck;

/**
 * @author mauro-sanchez
 */
public class DeckFileTest {
	
	public static final String DECKS_FILE_VALID_PATH = "./src/test/resources/decks.txt";
	public static final String DECKS_FILE_INVALID_PATH = "./src/test/resources/prueba.txt";
	public static final String DECKS_FILE_VALID_LINE = "./src/test/resources/deckValidLine.txt";
	public static final String DECKS_FILE_INVALID_LINE = "./src/test/resources/deckInvalidLine.txt";
	

	@Test
	public void given_aValidPath_when_tryReadFile_then_loadDeck() {
		DeckFileTxtDao deckFile = new DeckFileTxtDao();
		Deck deck = deckFile.load(DECKS_FILE_VALID_PATH);
		Assert.assertNotNull(deck);
	}
	
	@Test
	public void given_aInvalidPath_when_tryReadFile_then_deckIsNull() {
		DeckFileTxtDao deckFile = new DeckFileTxtDao();
		Deck deck = deckFile.load(DECKS_FILE_INVALID_PATH);
		Assert.assertNull(deck);
	}
	
	@Test
	public void given_aFileWithOneValidLine_when_tryReadFile_then_deckSizeIsOne() {
		DeckFileTxtDao deckFile = new DeckFileTxtDao();
		Deck deck = deckFile.load(DECKS_FILE_VALID_LINE);
		Assert.assertEquals(1, deck.getSize());
	}
	
	@Test
	public void given_aFileWithOneInvalidLine_when_tryReadFile_then_deckEmpty() {
		DeckFileTxtDao deckFile = new DeckFileTxtDao();
		Deck deck = deckFile.load(DECKS_FILE_INVALID_LINE);
		Assert.assertTrue(deck.isEmpty());
	}

	@Test
	public void given_aExistFile_when_verifiedIfExist_then_returnTrue() {
		DeckFileTxtDao deckFile = new DeckFileTxtDao();
		Assert.assertTrue(deckFile.isExistDeck(DECKS_FILE_VALID_PATH));
	}
	
	@Test
	public void given_aNotExistFile_when_verifiedIfExist_then_returnFalse() {
		DeckFileTxtDao deckFile = new DeckFileTxtDao();
		Assert.assertFalse(deckFile.isExistDeck(DECKS_FILE_INVALID_PATH));
	}
}
