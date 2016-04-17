package org.phase.game.entities;

import java.util.List;

public class Game {

	private long gameId;
	private long announce;
	private int team_one_result;
	private int team_two_result;
	private Table table = new Table();
	private Team announcing_team;
	private Team[] teams;
	
	public Game(int t1res, int t2res, List<Team> teams_) {
		team_one_result = t1res;
		team_two_result = t2res;
		int num = 0;
		for (Team team : teams_) {
			teams[num] = team;
			num++;
		}
		System.out.println("Got game");
	}
	
	public long get_announce() {
		return announce;
	}
	
	public void set_announce(long announce_, Team team) {
		announce = announce_;
		announcing_team = team;
	}
	
	public int[] get_result() {
		int[] result = null; 
		result[0] = team_one_result;
		result[1] = team_two_result;
		return result;
	}
	
	public boolean game_end() {
		// TODO: if previous distribution loss is x:0, game wil end after one distribution
		if (team_one_result >= 151 || team_two_result >= 151) {
			return true;
		}
		return false;
	}
	
	public int get_loss_type() {
		long announcing_team_id = announcing_team.get_team_id();
		long first_team_id = teams[0].get_team_id();
		long second_team_id = teams[0].get_team_id();
		if (team_one_result > team_two_result) {
			if (announcing_team_id == second_team_id) {
				// Loss x:0
			}
			// x:y
		} else {
			if (announcing_team_id == first_team_id) {
				// Loss 0:y
			}
			// x:y
		}
		
		return team_one_result;	
	}
	
	public Player getPlayerById(Integer team_id, Integer player_id) {
		Team wanted_team = teams[team_id];
		return wanted_team.get_player(player_id);
	}
	
}
