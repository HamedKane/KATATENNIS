package com.kata.tennis3;

import com.kata.tennis3.Match;
import com.kata.tennis3.IParameters;
import com.kata.tennis3.Player;

public class Match {
	
	private String statut;
	private boolean isTieBreak;

	public boolean isTieBreak() {
		return isTieBreak;
	}

	public void setTieBreak(boolean isTieBreak) {
		this.isTieBreak = isTieBreak;
	}

	public Match(String statut) {
		this.statut = statut;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public void updateScore(Player winner, Player loser, Match match) {
		switch(winner.getCurrentGameStatus()) {
		  case 0:
			  winner.setCurrentGameStatus(IParameters.GAME_STATUS_15);
		    break;
		  case 1:
			  winner.setCurrentGameStatus(IParameters.GAME_STATUS_30);
		    break;
		  case 2:
			  winner.setCurrentGameStatus(IParameters.GAME_STATUS_40);
			  if (winner.getCurrentGameStatus() == IParameters.GAME_STATUS_40 && loser.getCurrentGameStatus() == IParameters.GAME_STATUS_40){
				  winner.setCurrentGameStatus(IParameters.GAME_STATUS_DEUCE);
				  loser.setCurrentGameStatus(IParameters.GAME_STATUS_DEUCE);
			  }
			break;
		  case 3:
		  case 5:
			  	 manageGame(winner);
			  	 manageSet(winner,loser, match);
			  	 manageMatch(winner,loser, match);
			  	 winner.setCurrentGameStatus(0);
			  	 loser.setCurrentGameStatus(0);
			break;
		  case 4:
			    //DEUCE CASE
			    winner.setCurrentGameStatus(IParameters.GAME_STATUS_ADVANTAGE);
			  	if(loser.getCurrentGameStatus() == IParameters.GAME_STATUS_ADVANTAGE) {
			  		loser.setCurrentGameStatus(IParameters.GAME_STATUS_DEUCE);
			  	}
			break;	    
		}
	}
	
	public void manageGame(Player winner) {		
		winner.setNbrGame(winner.getNbrGame() + 1);	
	}
	
	public void manageSet(Player winner, Player loser, Match match) {
		if(!match.isTieBreak) {
			winner.setNbrSet(winner.getNbrSet()+1);
		}else {
			if(winner.getNbrTieBreak()==0) {
				winner.setNbrTieBreak(winner.getNbrSet() + 1);
				loser.setNbrTieBreak(loser.getNbrSet());
			}else {
				winner.setNbrTieBreak(winner.getNbrTieBreak() + 1);
			}
		}
		if(winner.getNbrSet() >= 6 && loser.getNbrSet()>= 6 )  {				
			serviceTieBreak(	winner, 	loser, match);	
		}
		winner.setNbrGame(0);
		loser.setNbrGame(0);	
		showSetWinner(winner);
		
	}

	public void serviceTieBreak(Player winner, Player loser, Match match) {
		match.setTieBreak(true);	
	}
	
	public void manageMatch(Player winner, Player loser, Match match) {		
		if(winner.getNbrSet() == 7 && !match.isTieBreak) {
			winner.setMatchWinner(true);
			match.setStatut(IParameters.MATCH_STATUS_END);
		}
		
		if(match.isTieBreak && (winner.getNbrTieBreak()-loser.getNbrTieBreak()>=2)){
			winner.setMatchWinner(true);
			match.setStatut(IParameters.MATCH_STATUS_END);
		}
		
		if(winner.getNbrSet() >= 6 && (winner.getNbrSet()-loser.getNbrSet()>=2)) {
			winner.setMatchWinner(true);
			match.setStatut(IParameters.MATCH_STATUS_END);		
		}	
	}
	
	void showSetWinner(Player winner) {
		System.out.println("Set Winner is : " + winner.getName());
	}
	
	void showScore(Player player1, Player player2, Match match){
		System.out.println("---------------Score Panel------------------------------------------------");
		System.out.println("                      Player 1 : " + player1.getName() + "               " + "Player 2 : " + player2.getName());
	  	System.out.println("GAME (Score) =>                 " + IParameters.convertStatusGameToString(player1.getCurrentGameStatus()) + "                                " + IParameters.convertStatusGameToString(player2.getCurrentGameStatus()));
	  	System.out.println("SET (Score) =>                   " + IParameters.showScoreSet(player1, player2));
	  	if(match.isTieBreak()){
	  		System.out.println("TIE-BREAK (Score) =>             " + IParameters.showScoreTieBreak(player1, player2));
	  	}
	  	
	  	if(match.getStatut().equals(IParameters.MATCH_STATUS_END)) {
	  		if(!match.isTieBreak && player1.getNbrSet()>player2.getNbrSet() ) {
	  			System.out.println("Match Winner is : " + player1.getName());
	  		}else if(!match.isTieBreak && player2.getNbrSet()>player1.getNbrSet() ) {
	  			System.out.println("Match Winner is : " + player2.getName());
	  		}	  		
	  		if(match.isTieBreak && player1.getNbrTieBreak()>player2.getNbrTieBreak() ) {
	  			System.out.println("Match Winner is : " + player1.getName());
	  		}else if(match.isTieBreak && player2.getNbrTieBreak()>player1.getNbrTieBreak() ) {
	  			System.out.println("Match Winner is : " + player2.getName());
	  		}	  		
	  	}
	  	
	  	System.out.println("Match status: " + match.getStatut());
		System.out.println("--------------------------------------------------------------------------");
	}
	
}

