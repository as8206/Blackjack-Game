package game;

import java.util.Scanner;

public class GameRunner {
	
	private static Scanner in = new Scanner(System.in);
	private static String input = "initialized";
	
	public static void main(String args[])
	{
		System.out.println("runner started"); //debug output
		World gameWorld = World.createWorld();		
		System.out.println("\n"); //create space between debugging output and normal output
		
//		while(input.equalsIgnoreCase("y") == false && input.equalsIgnoreCase("n") == false)
//		{
//		System.out.println("Would you like to play? Y/N");
//		input = in.next();
//		}
//		
//		if(input.equalsIgnoreCase("y"))
//		{
			gameWorld.startGame();
//		}
		
		System.out.println("Game closing, goodbye!");
	}
}
