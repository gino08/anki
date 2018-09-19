package com.weekendesk.anki.services;

import java.io.File;

import com.weekendesk.anki.AnkiConstants;
import com.weekendesk.anki.dao.DeckFileDao;
import com.weekendesk.anki.dao.DeckFileTxtDao;
import com.weekendesk.anki.model.Deck;

/**
 * Implementation of the interface DeckService.
 * Use DeckFileDao for load and save decks.
 *
 * @author mauro-sanchez
 */
public class DeckServiceFiles implements DeckService {
	
	private DeckFileDao dao;
	
	public DeckServiceFiles() {
		dao = new DeckFileTxtDao();
	}
	
	@Override
	public Deck loadAllCardsDeck() {
		return dao.load(AnkiConstants.FOLDER_RESOURCES_PATH + AnkiConstants.DECKS_FILE_PATH);
	}

	@Override
	public Deck loadRedDeck() {
		return dao.load(AnkiConstants.FOLDER_BOX_PATH + AnkiConstants.RED_BOX_FILE_PATH);
	}

	@Override
	public void saveRedDeck(Deck deck) {
		dao.save(deck, AnkiConstants.FOLDER_BOX_PATH + AnkiConstants.RED_BOX_FILE_PATH);
	}

	@Override
	public Deck loadOrangeDeck() {
		return dao.load(AnkiConstants.FOLDER_BOX_PATH + AnkiConstants.ORANGE_BOX_FILE_PATH);
	}

	@Override
	public void saveOrangeDeck(Deck deck) {
		dao.save(deck, AnkiConstants.FOLDER_BOX_PATH + AnkiConstants.ORANGE_BOX_FILE_PATH);
	}

	@Override
	public Deck loadGreenDeck() {
		return dao.load(AnkiConstants.FOLDER_BOX_PATH + AnkiConstants.GREEN_BOX_FILE_PATH);
	}

	@Override
	public void saveGreenDeck(Deck deck) {
		dao.save(deck, AnkiConstants.FOLDER_BOX_PATH + AnkiConstants.GREEN_BOX_FILE_PATH);
	}

	@Override
	public void setUpDecks() {
		createFolderIfNotExist(AnkiConstants.FOLDER_RESOURCES_PATH);
		createFolderIfNotExist(AnkiConstants.FOLDER_BOX_PATH);
		if (!dao.isExistDeck(AnkiConstants.FOLDER_RESOURCES_PATH + AnkiConstants.DECKS_FILE_PATH))
			dao.createInitialDeck(AnkiConstants.DECKS_FILE_PATH, AnkiConstants.FOLDER_RESOURCES_PATH + AnkiConstants.DECKS_FILE_PATH);
		if (!dao.isExistDeck(AnkiConstants.FOLDER_BOX_PATH + AnkiConstants.RED_BOX_FILE_PATH))
			dao.createInitialEmptyDeck(AnkiConstants.FOLDER_BOX_PATH + AnkiConstants.RED_BOX_FILE_PATH);
		if (!dao.isExistDeck(AnkiConstants.FOLDER_BOX_PATH + AnkiConstants.ORANGE_BOX_FILE_PATH))
			dao.createInitialEmptyDeck(AnkiConstants.FOLDER_BOX_PATH + AnkiConstants.ORANGE_BOX_FILE_PATH);
		if (!dao.isExistDeck(AnkiConstants.FOLDER_BOX_PATH + AnkiConstants.GREEN_BOX_FILE_PATH))
			dao.createInitialEmptyDeck(AnkiConstants.FOLDER_BOX_PATH + AnkiConstants.GREEN_BOX_FILE_PATH);
	}
	
	private void createFolderIfNotExist(String path) {
		File folder = new File(path);
		if (!folder.exists()) {
			folder.mkdirs();
		}
	}
}
