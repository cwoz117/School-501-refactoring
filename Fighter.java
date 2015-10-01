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

public class Fighter{

    public final static int HIGH = 0;
    public final static int MEDIUM = 1;
    public final static int LOW = 2;
    
    private double[] attackRatio = new double[3];
    private int[] attackCount = new int[3];
    private int blockedAttackCounter; 
    private Random numberGenerator;

    public Fighter(){ //Default Constructor sets all ratios to 33%
    	attackRatio[HIGH] = 33.33;
    	attackRatio[MEDIUM] = 33.33;
    	attackRatio[LOW] = 33.33;
    	numberGenerator = new Random();
    	blockedAttackCounter = 0;
    }
    
    public Fighter(double ratioOfHighAttack, double ratioOfMediumAttack, double ratioOfLowAttack){
    	attackRatio[HIGH] = ratioOfHighAttack;
    	attackRatio[MEDIUM] = ratioOfMediumAttack;
    	attackRatio[LOW] = ratioOfLowAttack;
    	numberGenerator = new Random();
    	blockedAttackCounter = 0;
    }


    public int attack(){//Based off of its ratios, select a 'random' attack
    	int determinedAttack = numberGenerator.nextInt(100);
    	if (determinedAttack < attackRatio[HIGH]){
    		System.out.println("ATTACKED HIGH");
    		attackCount[HIGH] += 1;
    		return HIGH;
    	} else if (determinedAttack <= (attackRatio[HIGH]+attackRatio[MEDIUM])){
    		System.out.println("ATTACKED MEDIUM");
    		attackCount[MEDIUM] += 1;
    		return MEDIUM;
    	} else{
    		System.out.println("ATTACKED LOW");
    		attackCount[LOW] += 1;
    		return LOW;
    	}
    }
    
    
    public void showStats(int r){//Display the log of attacks that were made.
    	double h = ((double)attackCount[HIGH] /(double)r)*100;
    	double m = ((double)attackCount[MEDIUM] /(double)r)* 100;
    	double l = ((double)attackCount[LOW] / (double)r) * 100;
	
    	System.out.printf("Number of High attacks made:   %2.1f%% \n", h);
    	System.out.printf("Number of Medium attacks made: %2.1f%% \n", m);
    	System.out.printf("Number of Low attacks made:    %2.1f%% \n", l);
    }
}