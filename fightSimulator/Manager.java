package fightSimulator;
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
    	
    	Scanner in = new Scanner(System.in);
   		Fighter attacker = new Fighter(in);
   		Fighter defender = new Fighter(33.33, 33.33, 33.33);
   		Simulator sim = new Simulator(attacker, defender);
    		
       	sim.determineRounds(in);
       	sim.runSimulation();
       	sim.stats();
        	
       	in.close();
    }
}