package com.weekendesk.anki.ui;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.weekendesk.anki.AnkiSession;
import com.weekendesk.anki.model.Box;

/**
 * Implementation of the interface AnkiGameUI.
 * use the system console.
 *
 * @author mauro-sanchez
 */
public class AnkiGameUIConsole implements AnkiGameUI {
	
	private final Scanner scanner;

    public AnkiGameUIConsole() {
        scanner = new Scanner(System.in);
    }

	@Override
	public void initSession(AnkiSession session) {
		if (session.isNewGame()) {
			System.out.println("Starting a new session.");
			System.out.println("\n-----------------------------------------");
		} else {
			System.out.println("Session status:\n");
            System.out.println("\t" + session.getRedDeckSize() + " card/s in the red box");
            System.out.println("\t" + session.getOrangeDeckSize() + " card/s in the orange box");
            System.out.println("\t" + session.getGreenDeckSize() + " card/s in the green box");
		}
	}

	@Override
	public void finishSession(AnkiSession session) {
		System.out.println("\n-----------------------------------------");
        System.out.println("This session is finish.");
        if (session.isFinishGame()) {
        	System.out.println("\n***************************************************");
        	System.out.println(".:  Congratulations! You have finish the cards.  :.");
        	System.out.println("***************************************************\n");
        } else {
            System.out.println("\nStatus the next session:");
            System.out.println("\t- " + session.getRedDeckSize() + " card/s in the red box");
            System.out.println("\t- " + session.getOrangeDeckSize() + " card/s in the orange box");
            System.out.println("\t- " + session.getGreenDeckSize() + " card/s in the green box");
        }
		
	}

	@Override
	public void showQuestion(String question) {
		System.out.println("\n-----------------------------------------");
		System.out.println("\nQuestion: " + question + " [PRESS ENTER TO SEE THE ANSWER]");
		scanner.nextLine();
	}

	@Override
	public void showAnswer(String answer) {
		System.out.println("Answer: " + answer + " [PRESS ENTER TO SELECT THE BOX]");
		scanner.nextLine();
	}

	@Override
	public void showQuestionBox() {
		System.out.print("In which box stacks the card ?\nSelect:\n");
		System.out.println("\t- 1 (red box)");
        System.out.println("\t- 2 (orange box)");
        System.out.println("\t- 3 (green box)");
        System.out.println("\n[SELECT BOX AND PRESS ENTER TO READ THE NEXT CARD]");
	}

	@Override
	public Box getSelectedBox() {
		int selectedBox = 0;
		boolean read = true;
		while (read) {
			try {
				selectedBox = scanner.nextInt();
				if (invalidSelectedBox(selectedBox)) {
					System.out.println("Invalid value!");
				} else {
					read = false;
				}
			} catch (InputMismatchException e) {
			    System.out.println("Invalid value!");
			    scanner.next();
			} 
        }
        scanner.nextLine();
        if (selectedBox == Box.RED.ordinal() + 1) {
            return Box.RED;
        } else if (selectedBox == Box.ORANGE.ordinal() + 1) {
            return Box.ORANGE;
        } else {
            return Box.GREEN;
        }
	}
	
	private boolean invalidSelectedBox(int selectedBox) {
		return selectedBox != 1 && selectedBox != 2 && selectedBox != 3;
	}
}
