package fightSimulator;
/* 
Chris Wozniak
10109820

Attacker Object used in Assignment 1, in conjunction with Defender, and Manager.

Version History included in Manager.java.

List of methods.
1.  int: makeAttack();
2. void: showStats();
 */


import java.util.Random;
import java.util.Scanner;

public class Fighter{

    public final static int HIGH = 0;
    public final static int MEDIUM = 1;
    public final static int LOW = 2;
    public final static int BLOCK = 3;
    
    private double[] attackRatio;
    private int[] counters;
    private Random numberGenerator;
    
    public Fighter(double ratioOfHighAttack, double ratioOfMediumAttack, double ratioOfLowAttack) {
    	if ((ratioOfHighAttack + ratioOfMediumAttack + ratioOfLowAttack) > (double)100){
    		throw new IllegalArgumentException("Your ratios are greater than 100%");
    	}
    	if ((ratioOfHighAttack < 0) || (ratioOfMediumAttack < 0) || (ratioOfLowAttack < 0)){
    		throw new IllegalArgumentException("You have negative ratios");
    	}
    	counters = new int[4];
    	attackRatio = new double[3];
    	attackRatio[HIGH] = ratioOfHighAttack;
    	attackRatio[MEDIUM] = ratioOfMediumAttack;
    	attackRatio[LOW] = ratioOfLowAttack;
    	numberGenerator = new Random();
    }
    public Fighter(Scanner in){
    	if(in == null) throw new NullPointerException("Scanner is not initialized");
    	counters = new int[4];
    	attackRatio = new double[3];
    	numberGenerator = new Random();
    	boolean valid = false;
    	while(!valid){
    		System.out.println("Building you're Fighter!\n");
    		System.out.println("Please enter the ratio of High Attacks: ");
    		attackRatio[HIGH]= in.nextDouble();
    	
    		System.out.println("Please enter the ratio of Medium Attacks: ");
    		attackRatio[MEDIUM] = in.nextDouble();

    		System.out.println("Please enter the ratio of Low Attacks: ");
    		attackRatio[LOW]= in.nextDouble();
    		if (((attackRatio[HIGH] + attackRatio[MEDIUM] + attackRatio[LOW]) > (double)100) ||
        			(attackRatio[LOW] < 0) || (attackRatio[MEDIUM] < 0) || (attackRatio[HIGH] < 0)){
    			System.out.println("You're ratios are all wrong, please try again: \n");
    		} else{
    			valid = true;
    		}
    	}
    }

    public int action(String typeOfMove){//Based off of its ratios, select a 'random' attack
    	int determinedAttack = numberGenerator.nextInt(100);
    	if (determinedAttack < attackRatio[HIGH]){
    		System.out.println(typeOfMove + "ed HIGH");
    		counters[HIGH] += 1;
    		return HIGH;
    	} else if (determinedAttack <= (attackRatio[HIGH]+attackRatio[MEDIUM])){
    		System.out.println(typeOfMove + "ed MEDIUM");
    		counters[MEDIUM] += 1;
    		return MEDIUM;
    	} else{
    		System.out.println(typeOfMove + "ed LOW");
    		counters[LOW] += 1;
    		return LOW;
    	}
    }
    public void analyze(int i){//Determine opponents ratio.
    	if (i == HIGH && attackRatio[HIGH] <= 100 ) {
    		attackRatio[HIGH] += 2;
    		attackRatio[MEDIUM] -= 1;
    		attackRatio[LOW] -= 1;
    	} else if (i == MEDIUM && attackRatio[MEDIUM] <= 100) {
    		attackRatio[HIGH] -= 1;
    		attackRatio[MEDIUM] += 2;
    		attackRatio[LOW] -= 1;
    	} else if (i == LOW && attackRatio[LOW]<= 100) {
    		attackRatio[HIGH] -= 1;
    		attackRatio[MEDIUM] -= 1;
    		attackRatio[LOW] += 2;
        }
    }
    public void blocked(){
    	counters[BLOCK] += 1;
    }
    public void showBlocked(int rounds){
    	double dblBlockPercent = ((double)counters[BLOCK]/(double)rounds)* 100;
    	System.out.printf("Blocked Attacks: %3.1f%% \n", dblBlockPercent);
    }
    public void showStats(int r){//Display the log of attacks that were made.
    	double h = ((double)counters[HIGH] /(double)r)*100;
    	double m = ((double)counters[MEDIUM] /(double)r)* 100;
    	double l = ((double)counters[LOW] / (double)r) * 100;
	
    	System.out.printf("Number of High attacks made:   %2.1f%% \n", h);
    	System.out.printf("Number of Medium attacks made: %2.1f%% \n", m);
    	System.out.printf("Number of Low attacks made:    %2.1f%% \n", l);
    }
}