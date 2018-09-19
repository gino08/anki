package com.weekendesk.anki.ui;

import com.weekendesk.anki.AnkiSession;
import com.weekendesk.anki.model.Box;

/**
 * Interface for interaction with the user.
 *
 * @author mauro-sanchez
 */
public interface AnkiGameUI {

	void initSession(AnkiSession session);
	
	void finishSession(AnkiSession session);
	
	void showQuestion(String question);
	
	void showAnswer(String answer);
	
	void showQuestionBox();
	
	Box getSelectedBox();
}
