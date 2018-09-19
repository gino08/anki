package com.weekendesk.anki;

import com.weekendesk.anki.ui.AnkiGameUIConsole;

/**
 * Application's entry point.
 *
 * @author mauro-sanchez
 */
public final class AnkiMain {
	
	public static void main(String[] args) {

		System.out.println("*****************************************");
        System.out.println("******      .:  ANKI GAME  :.      ******");
        System.out.println("*****************************************");
        
        AnkiGameImpl.createAnkiGame().play(new AnkiGameUIConsole());

    }
}
