package fighter;
import java.util.Scanner;

public class Simulator {

	private Fighter attacker;
	private Fighter defender;
	private int rounds;
	
	public Simulator(Fighter atk, Fighter def){
		attacker = atk;
		defender = def;
	}
	public void determineRounds(Scanner in){
    	System.out.println("Please enter the number of rounds for this fight: ");
    	rounds = in.nextInt();
    	if ((rounds < 1) || (rounds > 100)){
    		rounds = 10;
    	}
	}
	public void runSimulation(){
		for(int i = 0; i<rounds; i++){
    		int attack = attacker.action("Attack");
    		int defend = defender.action("Defend");
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
