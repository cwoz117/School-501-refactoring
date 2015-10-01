/* 
Chris Wozniak
10109820

Defender Object used in Assignment 1, in conjunction with Attacker, and Manager.

Version History included in Manager.java.

List of methods.
1.  int: makeDefence()
2. void: analyze()
3. void: blocked()
4. void: showblocked()

 */


import java.util.Random;

public class Defender{

    private double[] defendRatios;
    private int totalBlockedAttacks = 0;
    private Random numberGenerator;

    public Defender() {
    	defendRatios = new double[3];
    	defendRatios[0] = 33.33;
    	defendRatios[1] = 33.33;
    	defendRatios[2] = 33.33;
    	numberGenerator = new Random();
    }
    public Defender(double h, double m, double l){
    	defendRatios = new double[3];
    	defendRatios[0] = h;
    	defendRatios[1] = m;
    	defendRatios[2] = l;
    	numberGenerator = new Random();
    }

    public int defend(){ //Generate a defense, based off current ratios.
    	int defend = numberGenerator.nextInt(100);
    	if ( defend <= defendRatios[0] ) {
    		System.out.println("BLOCKED HIGH");
    		return Fighter.HIGH;
    	} else if ( defend <= (defendRatios[0] + defendRatios[1]) ) {
    		System.out.println("BLOCKED MEDIUM");
    		return Fighter.MEDIUM;
    	} else{
    		System.out.println("BLOCKED LOW");
    		return Fighter.LOW;
    	}
    }

    public void analyze(int i){//Determine opponents ratio.
    	if (i == Fighter.HIGH && defendRatios[Fighter.HIGH] <= 100 ) {
    		defendRatios[Fighter.HIGH] += 2;
    		defendRatios[Fighter.MEDIUM] -= 1;
    		defendRatios[Fighter.LOW] -= 1;
    	} else if (i == Fighter.MEDIUM && defendRatios[Fighter.MEDIUM] <= 100) {
    		defendRatios[Fighter.HIGH] -= 1;
    		defendRatios[Fighter.MEDIUM] += 2;
    		defendRatios[Fighter.LOW] -= 1;
    	} else if (i == Fighter.LOW && defendRatios[Fighter.LOW]<= 100) {
    		defendRatios[Fighter.HIGH] -= 1;
    		defendRatios[Fighter.MEDIUM] -= 1;
    		defendRatios[Fighter.LOW] += 2;
        }
    }

    public void blocked(){
    	totalBlockedAttacks += 1;
    }
   
    public void showBlocked(int rounds){
    	double dblBlockPercent = ((double)totalBlockedAttacks/(double)rounds)* 100;
    	System.out.printf("Blocked Attacks: %3.1f%% \n", dblBlockPercent);
    }
}