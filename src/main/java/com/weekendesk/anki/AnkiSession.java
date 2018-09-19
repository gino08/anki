package com.weekendesk.anki;

/**
 * Maintains the state of the session game.
 * Has control of the size decks.
 *
 * @author mauro-sanchez
 */
public class AnkiSession {

	private int allCardsDeckSize;
	private int redDeckSize;
	private int orangeDeckSize;
	private int greenDeckSize;
	
	public AnkiSession(int allCardsDeckSize, int redDeckSize, int orangeDeckSize, int greenDeckSize) {
		this.setAllCardsDeckSize(allCardsDeckSize);
		this.redDeckSize = redDeckSize;
		this.orangeDeckSize = orangeDeckSize;
		this.greenDeckSize = greenDeckSize;
	}
	
	public int getAllCardsDeckSize() {
		return allCardsDeckSize;
	}
	public void setAllCardsDeckSize(int allCardsDeckSize) {
		this.allCardsDeckSize = allCardsDeckSize;
	}
	public int getRedDeckSize() {
		return redDeckSize;
	}
	public void setRedDeckSize(int redDeckSize) {
		this.redDeckSize = redDeckSize;
	}
	public int getOrangeDeckSize() {
		return orangeDeckSize;
	}
	public void setOrangeDeckSize(int orangeDeckSize) {
		this.orangeDeckSize = orangeDeckSize;
	}
	public int getGreenDeckSize() {
		return greenDeckSize;
	}
	public void setGreenDeckSize(int greenDeckSize) {
		this.greenDeckSize = greenDeckSize;
	}
	public boolean isFinishGame() {
		return allCardsDeckSize == greenDeckSize;
	}
	public boolean isNewGame() {
        return redDeckSize == 0 && orangeDeckSize == 0 && greenDeckSize == 0;
    }
}
