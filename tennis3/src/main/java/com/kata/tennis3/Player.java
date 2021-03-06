package com.kata.tennis3;

public class Player {
	
	private String name;
	private String currentService;
	private int currentGameStatus;
	private int nbrGame;
	private int nbrSet;
	private int nbrTieBreak;
	private boolean isMatchWinner;	
	
	public Player(String name, String currentService, int currentGameStatus, 
			int nbrGame, int nbrSet, boolean isMatchWinner) {
		this.name = name;
		this.currentService = currentService;
		this.currentGameStatus = currentGameStatus;
		this.nbrGame = nbrGame;
		this.nbrSet = nbrSet;
		this.isMatchWinner = isMatchWinner;
	}
	
	public int getNbrTieBreak() {
		return nbrTieBreak;
	}

	public void setNbrTieBreak(int nbrTieBreak) {
		this.nbrTieBreak = nbrTieBreak;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getCurrentService() {
		return currentService;
	}
	public void setCurrentService(String currentAction) {
		this.currentService = currentAction;
	}
	public int getCurrentGameStatus() {
		return currentGameStatus;
	}
	public void setCurrentGameStatus(int currentgameStatus) {
		this.currentGameStatus = currentgameStatus;
	}
	public int getNbrGame() {
		return nbrGame;
	}
	public void setNbrGame(int nbrGame) {
		this.nbrGame = nbrGame;
	}
	public int getNbrSet() {
		return nbrSet;
	}
	public void setNbrSet(int nbrSet) {
		this.nbrSet = nbrSet;
	}
	public boolean isMatchWinner() {
		return isMatchWinner;
	}
	public void setMatchWinner(boolean isMatchWinner) {
		this.isMatchWinner = isMatchWinner;
	}
}
