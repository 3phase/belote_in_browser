package org.phase.game.entities;

import java.util.Iterator;
import java.util.Stack;

public class Table {

	private long tableId;
	private Stack<Card> cards_on_table = new Stack<Card>();
	
	public void add_card_to_table(Card card) {
		cards_on_table.push(card);
	}
	
	public void take_cards_to_winner(Team winning_team) {
		Iterator<Card> it = cards_on_table.iterator();
		while (it.hasNext()) {
			winning_team.add_card_to_won_cards(it.next());
		}
		while (it.hasNext()) {
			cards_on_table.pop();
		}
	}
	
}
