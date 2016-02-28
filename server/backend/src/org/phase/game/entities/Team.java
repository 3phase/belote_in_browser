package org.phase.game.entities;

import java.util.ArrayList;
import java.util.List;

public class Team {

	private long teamId;
	private List<Player> players = new ArrayList<Player>();
	private int ready = 0;
	
	public void new_player(Player player) throws Exception {
		if (players.size() < 2) {
			players.add(player);
			if (players.size() == 2) {
				ready = 1;
			}
		} else {
			throw new Exception("Player cannot be added to this team since "
					+ "maximum of players in a team was reached.");
		}
	}
	
	public int if_ready() {
		return ready;
	}
	
	
}
