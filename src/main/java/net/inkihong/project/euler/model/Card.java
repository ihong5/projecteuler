package net.inkihong.project.euler.model;

public class Card {
	
	private char value, suit;
	
	public Card(char value, char suit) {
		this.value = value;
		this.suit = suit;
	}

	public char getValue() {
		return value;
	}

	public void setValue(char value) {
		this.value = value;
	}

	public char getSuit() {
		return suit;
	}

	public void setSuit(char suit) {
		this.suit = suit;
	}
}
