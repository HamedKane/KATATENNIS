package com.kata.tennis3;

import org.junit.Test;
import com.kata.tennis3.CurrentService;
import com.kata.tennis3.IParameters;
import com.kata.tennis3.Player;
import com.kata.tennis3.Match;

import junit.framework.TestCase;


public class MatchTest extends TestCase {

	@Test
	public void testIfGameStartScoreIsZeroforeachPlayer() {
		Player player1 = new Player("Player1", null, 0, 0, 0, false);
		Player player2 = new Player("Player2", null, 0, 0, 0, false);
		assertEquals(0,player1.getNbrGame());
		assertEquals(0,player1.getNbrSet());
		assertEquals(0,player1.getNbrTieBreak());
		assertEquals(0,player2.getNbrGame());
		assertEquals(0,player2.getNbrSet());
		assertEquals(0,player2.getNbrTieBreak());
	}
		
	@Test
	public void testWinPoint0To15() {	
		Match match = new Match(IParameters.MATCH_STATUS_IN_PROGRESS);
		Player player1 = new Player("Player1", CurrentService.W.toString(), 0, 0, 0, false);
		Player player2 = new Player("Player2", CurrentService.L.toString(), 0, 0, 0, false);
		match.updateScore(player1, player2, match);
		assertEquals(IParameters.GAME_STATUS_15,player1.getCurrentGameStatus());
	}
		
	@Test
	public void testWinPoint15To30() {		
		Match match = new Match(IParameters.MATCH_STATUS_IN_PROGRESS);
		Player player1 = new Player("Player1", CurrentService.W.toString(), IParameters.GAME_STATUS_15, 0, 0, false);
		Player player2 = new Player("Player2", CurrentService.L.toString(), 0, 0, 0, false);
		match.updateScore(player1, player2, match);
		assertEquals(IParameters.GAME_STATUS_30,player1.getCurrentGameStatus());
	}

	@Test
	public void testWinPoint30To40() {	
		Match match = new Match(IParameters.MATCH_STATUS_IN_PROGRESS);
		Player player1 = new Player("Player1", CurrentService.W.toString(), IParameters.GAME_STATUS_30, 0, 0, false);
		Player player2 = new Player("Player2", CurrentService.L.toString(), 0, 0, 0, false);
		match.updateScore(player1, player2, match);
		assertEquals(IParameters.GAME_STATUS_40,player1.getCurrentGameStatus());
	}
	
	
	@Test
	public void testWinPoint40ToDeuce() {	
		Match match = new Match(IParameters.MATCH_STATUS_IN_PROGRESS);
		Player player1 = new Player("Player1", CurrentService.W.toString(), IParameters.GAME_STATUS_30, 0, 0, false);
		Player player2 = new Player("Player2", CurrentService.L.toString(), IParameters.GAME_STATUS_40, 0, 0, false);
		match.updateScore(player1, player2, match);
		assertEquals(IParameters.GAME_STATUS_DEUCE,player1.getCurrentGameStatus());
		assertEquals(IParameters.GAME_STATUS_DEUCE,player2.getCurrentGameStatus());		
	}
	
	
	@Test
	public void testWinPointDeuceToAdvantage() {	
		Match match = new Match(IParameters.MATCH_STATUS_IN_PROGRESS);
		Player player1 = new Player("Player1", CurrentService.W.toString(), IParameters.GAME_STATUS_DEUCE, 0, 0, false);
		Player player2 = new Player("Player2", CurrentService.L.toString(), IParameters.GAME_STATUS_DEUCE, 0, 0, false);
		match.updateScore(player1, player2, match);
		assertEquals(IParameters.GAME_STATUS_ADVANTAGE,player1.getCurrentGameStatus());
		assertEquals(IParameters.GAME_STATUS_DEUCE,player2.getCurrentGameStatus());
	}
	
	
	@Test
	public void testLoseAdvantageToDeuce() {	
		Match match = new Match(IParameters.MATCH_STATUS_IN_PROGRESS);
		Player player1 = new Player("Player1", CurrentService.W.toString(), IParameters.GAME_STATUS_DEUCE, 0, 0, false);
		Player player2 = new Player("Player2", CurrentService.L.toString(), IParameters.GAME_STATUS_ADVANTAGE, 0, 0, false);
		match.updateScore(player1, player2, match);
		assertEquals(IParameters.GAME_STATUS_DEUCE,player2.getCurrentGameStatus());
	}
	
	@Test
	public void testManageSets() {
		Match match = new Match(IParameters.MATCH_STATUS_IN_PROGRESS);
		Player player1 = new Player("Player1", CurrentService.W.toString(), IParameters.GAME_STATUS_40, 0, 0, false);
		Player player2 = new Player("Player2", CurrentService.L.toString(), IParameters.GAME_STATUS_15, 0, 0, false);
		match.updateScore(player1, player2, match);
		assertEquals(1,player1.getNbrSet());
		assertEquals(0,player2.getNbrSet());
	}
		
	@Test
	public void testManageMatchs() {
		Match match = new Match(IParameters.MATCH_STATUS_IN_PROGRESS);
		Player player1 = new Player("Player1", CurrentService.W.toString(), IParameters.GAME_STATUS_40, 0, 6, false);
		Player player2 = new Player("Player2", CurrentService.L.toString(), IParameters.GAME_STATUS_15, 0, 5, false);
		match.updateScore(player1, player2, match);
		assertEquals(true,player1.isMatchWinner());
		assertEquals(false,player2.isMatchWinner());
		assertEquals(IParameters.MATCH_STATUS_END,match.getStatut());
	}
	
	@Test
	public void testManageTieBreakMatchs() {
		Match match = new Match(IParameters.MATCH_STATUS_IN_PROGRESS);
		Player player1 = new Player("Player1", CurrentService.W.toString(), IParameters.GAME_STATUS_40, 0, 5, false);
		Player player2 = new Player("Player2", CurrentService.L.toString(), IParameters.GAME_STATUS_15, 0, 6, false);
		match.updateScore(player1, player2, match);
		assertEquals(false,player1.isMatchWinner());
		assertEquals(false,player2.isMatchWinner());
		assertEquals(6,player1.getNbrSet());
		assertEquals(6,player2.getNbrSet());
		assertEquals(true,match.isTieBreak());
		assertEquals(IParameters.MATCH_STATUS_IN_PROGRESS,match.getStatut());
	}
	
	@Test
	public void testManageTieBreakEndMatchs() {
		Match match = new Match(IParameters.MATCH_STATUS_IN_PROGRESS);
		Player player1 = new Player("Player1", CurrentService.W.toString(), IParameters.GAME_STATUS_40, 0, 9, false);
		Player player2 = new Player("Player2", CurrentService.L.toString(), IParameters.GAME_STATUS_15, 0, 8, false);
		match.updateScore(player1, player2, match);
		assertEquals(true,player1.isMatchWinner());
		assertEquals(false,player2.isMatchWinner());
		assertEquals(10,player1.getNbrSet());
		assertEquals(8,player2.getNbrSet());
		assertEquals(true,match.isTieBreak());
		assertEquals(IParameters.MATCH_STATUS_END,match.getStatut());
	}

}
