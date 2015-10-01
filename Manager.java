/* 
Chris Wozniak
10109820

Manager for Assignment 1, in conjunction with Defender, and Manager.

Version 1.0 "Molly"
-Rolls out 100 attacks
-Generates 100 Defends
-Displays the info

Version 1.1 "Jen"
-Included analyze function for Defender, to determine Attackers attack ratios.
-Output included, to show the Attackers number of attacks for each type.

Version 2.0 "Anistasia"
-Included Defender's block counter, including an output to display the data.
-Made use of the public constants in Attacker in Defender, strictly for ease of understanding.

Version 2. "Hemera"
-Included range counter for number of rounds.
 */


import java.util.Scanner;


public class Manager{

    public static void main(String[] args){
    	Defender defender = new Defender(33.33, 33.33, 33.33);
    	Scanner in = new Scanner(System.in);

    	System.out.println("Please enter the number of rounds for this fight: ");
    	int rounds = in.nextInt();

    	if (rounds < 1 || rounds > 100){
    		rounds = 10;
    	}

    	System.out.println("Please enter the ratio of High Attacks: ");
    	double high = in.nextDouble();
    	System.out.println("Please enter the ratio of Medium Attacks: ");
    	double medium = in.nextDouble();
    	System.out.println("Please enter the ratio of Low Attacks: ");
    	double low = in.nextDouble();
	
    	Fighter attacker = new Fighter(high,medium,low);


    	for(int i = 0; i<rounds; i++){
    		int attack;
    		int defend;
    		attack = attacker.attack();
    		defend = defender.defend();
    		defender.analyze(attack);

    		if (attack == defend){
    			System.out.println("\t Attack Blocked!");
    			defender.blocked();
    		} else{
    			System.out.println("\t Attack Hit!");
    		}
    		System.out.println();
    	}
    	attacker.showStats(rounds);
    	defender.showBlocked(rounds);
    	in.close();
    }
}