package com.kata.tennis3;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    		System.out.println( "*******************************************" );
        System.out.println( "*************  KATA TENNIS ****************" );
        System.out.println( "*******************************************" );
        Scanner sc = new Scanner(System.in);
               	
        	System.out.println( "Nouvelle Partie : Pour jouer tapez [J]" );
        	String choice = sc.nextLine();
        	String isWinner;
        	
        	Match match = new Match(IParameters.MATCH_STATUS_IN_PROGRESS);
        	Player player1 = new Player("Player1", null, 0, 0, 0, false);
    		Player player2 = new Player("Player2", null, 0, 0, 0, false);
        	
        	if(!choice.equals("J")){
        		System.out.println("Bad choice!");
        		System.exit(0);
        	}
        	
        	//Tant que le Match n'est pas terminé!
        	while(!player1.isMatchWinner() && !player2.isMatchWinner()) {
        		System.out.println( "==> New service"  );
        		System.out.print( player1.getName() +" is the service winner?  (Y/N) : "  );
        		isWinner = sc.nextLine();        		
        		
        		if(isWinner.toUpperCase().equals("Y")) {
        			player1.setCurrentService(CurrentService.W.toString());
        			player2.setCurrentService(CurrentService.L.toString());
        			match.updateScore(player1, player2, match);
        		}else if(isWinner.toUpperCase().equals("N")){
        			player1.setCurrentService(CurrentService.L.toString());
        			player2.setCurrentService(CurrentService.W.toString());
        			match.updateScore(player2, player1, match);
        		}else {
        			System.out.println( " Bad choice!" );
        		}
        		
        		//show Scores
        		match.showScore(player1, player2, match);		
        	}
        	
        	sc.close();
        	System.out.println( "********************************************" );
    		System.out.println( "*************** GAME OVER *****************" );
    		System.out.println( "********************************************" );
        	
    }
}
