package org.phase.game.entities;

import java.util.ArrayList;
import java.util.List;

public class Room {
	
	private long roomId;
	private int status = 0;
	private List<Team> teams = new ArrayList<Team>();
	private Game game = new Game();
	
	public Room(long room_id) {
		this.roomId = room_id;
		System.out.println("ROOM ID IS " + this.roomId);
		createTeams();
	}
	
	private void createTeams() {
		if (teams.isEmpty()) {
			Team teamOne = new Team();
			teamOne.setTeamId(1);
			Team teamTwo = new Team();
			teamTwo.setTeamId(2);
			teams.add(teamOne);
			teams.add(teamTwo);
		}		
	}
	
	private void addTeamsToGame() {
		this.game.updateTeams(teams);
	}
	
	public void addPlayer(Player player) {
		for (Team team : teams) {
			if (team.if_ready() != 1) {
				try {
					team.new_player(player);
					return;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			continue;
		}
		if (teams.get(0).if_ready() == 1 && teams.get(1).if_ready() == 1) {
			// Game ready to begin
			this.addTeamsToGame();
		}
	}

	public long get_id() {
		return this.roomId;
	}
	
	public Team getTeams(Integer teamId) {
		return teams.get(teamId);
	}
	
	public int get_status() {
		return status;
	}
	
	public Game get_game() {
		return this.game;
	}
	
	public List<Team> getAllTeams() {
		return this.teams;
	}
	
}
