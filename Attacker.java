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

public class Attacker{

    public final static int HIGH = 0;
    public final static int MEDIUM = 1;
    public final static int LOW = 2;
    
    private double[] aryRatio = new double[3];
    private int[] aryLog = new int[3];
    Random r = new Random();

    public Attacker(double a, double b, double c){
    	aryRatio[HIGH] = a;
    	aryRatio[MEDIUM] = b;
    	aryRatio[LOW] = c;
    }
    public Attacker(){//Default Constructor sets all to 33%
    	aryRatio[HIGH] = 33.33;
    	aryRatio[MEDIUM] = 33.33;
    	aryRatio[LOW] = 33.33;
    }

    public int  makeAttack(){//Based off of its ratios, select a 'random' attack
    	int atk = r.nextInt(100);
    	if (atk < aryRatio[HIGH]){
    		System.out.println("ATTACKED HIGH");
    		aryLog[HIGH] += 1;
    		return HIGH;
    	} else if (atk <= (aryRatio[HIGH]+aryRatio[MEDIUM])){
    		System.out.println("ATTACKED MEDIUM");
    		aryLog[MEDIUM] += 1;
    		return MEDIUM;
    	} else{
    		System.out.println("ATTACKED LOW");
    		aryLog[LOW] += 1;
    		return LOW;
    	}
    }
    
    public void showStats(int r){//Desplay the log of attacks that were made.
    	double h = ((double)aryLog[HIGH] /(double)r)*100;
    	double m = ((double)aryLog[MEDIUM] /(double)r)* 100;
    	double l = ((double)aryLog[LOW] / (double)r) * 100;
	
    	System.out.printf("Number of High attacks made:   %2.1f%% \n", h);
    	System.out.printf("Number of Medium attacks made: %2.1f%% \n", m);
    	System.out.printf("Number of Low attacks made:    %2.1f%% \n", l);
    }
}