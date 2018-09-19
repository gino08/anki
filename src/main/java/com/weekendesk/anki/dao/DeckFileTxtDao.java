package com.weekendesk.anki.dao;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.stream.Stream;

import com.weekendesk.anki.AnkiConstants;
import com.weekendesk.anki.model.Card;
import com.weekendesk.anki.model.Deck;

/**
 * Implementation of the interface DeckFileDao.
 * Manage decks in TXT files.
 *
 * @author mauro-sanchez
 */
public class DeckFileTxtDao implements DeckFileDao {
	
	private Deck deck;

	@Override
	public Deck load(String path) {
		deck = null;
		try (Stream<String> stream = Files.lines(Paths.get(path))) {
			deck = new Deck();
			stream.forEach(line -> {
				if (validLine(line)) {
					String[] cardLine = line.split(AnkiConstants.CARD_SPLITTER);
					deck.addCard(new Card(getQuestion(cardLine),getAnswer(cardLine)));
				}
			});
		} catch (IOException e) {
			System.out.println("File not found.");
		}
		return deck;
	}

	@Override
	public void save(Deck deck, String path) {
		try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(path)))
		{
			Iterator<Card> iter = deck.getCards().iterator();
			while (iter.hasNext()) {
				Card card = iter.next();
				writer.write(card.getQuestion() + AnkiConstants.CARD_SPLITTER_SAVE + card.getAnswer());
				writer.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public boolean isExistDeck(String path) {
		File deck = new File(path);
		return deck.exists();
	}

	@Override
	public void createInitialEmptyDeck(String path) {
		File deck = new File(path);
		try {
			deck.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void createInitialDeck(String pathFrom, String pathTo) {
		File deck = new File(pathTo);
		if (!deck.exists()) {
			try
			{
				deck.createNewFile();
				InputStream inputStreamDeck = getClass().getResourceAsStream(pathFrom);
				BufferedInputStream bufferedInput = new BufferedInputStream(inputStreamDeck);
				FileOutputStream fileOutputDeck = new FileOutputStream (deck);
				BufferedOutputStream bufferedOutput = new BufferedOutputStream(fileOutputDeck);
				byte [] array = new byte[1000];
				int leidos = bufferedInput.read(array);
				while (leidos > 0)
				{
					bufferedOutput.write(array,0,leidos);
					leidos=bufferedInput.read(array);
				}
	
				bufferedOutput.close();
				bufferedInput.close();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	
	private boolean validLine(String line) {
        String[] lines = line.trim().split(AnkiConstants.CARD_SPLITTER);
        return lines.length == 2 && !lines[0].isEmpty() && !lines[1].isEmpty();
    }
	
	private String getQuestion(String[] line) {
		return line[0];
	}

	private String getAnswer(String[] line) {
		return line[1];
	}
}
