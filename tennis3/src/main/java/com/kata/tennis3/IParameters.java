package com.kata.tennis3;

import java.util.List;

public interface IParameters {
	
	public static final int GAME_STATUS_0 = 0;
	public static final int GAME_STATUS_15 = 1;
	public static final int GAME_STATUS_30 = 2;
	public static final int GAME_STATUS_40 = 3;
	public static final int GAME_STATUS_DEUCE = 4;
	public static final int GAME_STATUS_ADVANTAGE = 5;
	public static final String MATCH_STATUS_IN_PROGRESS= "IN PROGRESS";
	public static final String MATCH_STATUS_END= "END";
	
	public static String convertStatusGameToString(int status) {		
		String statusGameString = null;
		switch(status) {
		  case 0:
			  statusGameString = "0";
		    break;
		  case 1:
			  statusGameString = "15";
		    break;
		  case 2:
			  statusGameString = "30";
			  break;
		  case 3:
			  statusGameString = "40";
			  break;
		  case 4:
			  statusGameString = "DEUCE";
			  break;
		  case 5:
			  statusGameString = "ADVANTAGE";
			  break;
		}
		return statusGameString;	
	}
	
	public static String showScoreSet(Player p1, Player p2){			
		String message = "";
		message = p1.getNbrSet() + "                                " + p2.getNbrSet();
		return message;
	}
	
	public static String showScoreTieBreak(Player p1, Player p2){			
		String message = "";
		message = p1.getNbrTieBreak() + "                                " + p2.getNbrTieBreak();
		return message;
	}
}
