package fightSimulator;
import java.util.Scanner;

public class Simulator {

	private static final String atk = "Attack";
	private static final String def = "Defend";
	private Fighter attacker;
	private Fighter defender;
	private int rounds;
	
	public Simulator(Fighter atk, Fighter def){
		if((atk == null) || (def == null)) {
			throw new IllegalArgumentException("Fighters are not instantiated");
		}
		attacker = atk;
		defender = def;
	}
	public void determineRounds(Scanner in){
		if(in == null){
			throw new IllegalArgumentException("Scanner isnt created");
		}
		System.out.println("Please enter the number of rounds for this fight: ");
		while(!in.hasNextInt()){
		    rounds = in.nextInt();
		}
		rounds = in.nextInt();
    	if ((rounds < 1) || (rounds > 100)){
    		rounds = 10;
    	}
	}
	public void runSimulation(){
		for(int i = 0; i<rounds; i++){
    		int attack = attacker.action(atk);
    		int defend = defender.action(def);
    		defender.analyze(attack);

    		if (attack == defend){
    			System.out.println("\t Attack Blocked!");
    			defender.blocked();
    		} else {System.out.println("\t Attack Hit!");}
    		System.out.println();
    	}
	}
	public void stats(){
    	attacker.showStats(rounds);
    	defender.showBlocked(rounds);
	}
}
