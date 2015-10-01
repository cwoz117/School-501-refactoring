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

    private double[] aryRatios = new double[3];
    Random r = new Random();
    private int intBlockedAttacks = 0;

    public Defender() {
    	aryRatios[0] = 33.33;
    	aryRatios[1] = 33.33;
    	aryRatios[2] = 33.33;
    }
    public Defender(double h, double m, double l){
    	aryRatios[0] = h;
    	aryRatios[1] = m;
    	aryRatios[2] = l;
    }

    public int makeDefence(){//Generate a defence, based off current ratios.
    	int dfnd = r.nextInt(100);
    	if ( dfnd <= aryRatios[0] ) {
    		System.out.println("BLOCKED HIGH");
    		return Attacker.HIGH;
    	} else if ( dfnd <= (aryRatios[0] + aryRatios[1]) ) {
    		System.out.println("BLOCKED MEDIUM");
    		return Attacker.MEDIUM;
    	} else{
    		System.out.println("BLOCKED LOW");
    		return Attacker.LOW;
    	}
    }

    public void analyze(int i){//Determine opponants ratio.
    	if (i == Attacker.HIGH && aryRatios[Attacker.HIGH] <= 100 ) {
    		aryRatios[Attacker.HIGH] += 2;
    		aryRatios[Attacker.MEDIUM] -= 1;
    		aryRatios[Attacker.LOW] -= 1;
    	} else if (i == Attacker.MEDIUM && aryRatios[Attacker.MEDIUM] <= 100) {
    		aryRatios[Attacker.HIGH] -= 1;
    		aryRatios[Attacker.MEDIUM] += 2;
    		aryRatios[Attacker.LOW] -= 1;
    	} else if (i == Attacker.LOW && aryRatios[Attacker.LOW]<= 100) {
    		aryRatios[Attacker.HIGH] -= 1;
    		aryRatios[Attacker.MEDIUM] -= 1;
    		aryRatios[Attacker.LOW] += 2;
        }
    }

    public void blocked(){
    	intBlockedAttacks += 1;
    }
   
    public void showBlocked(int rounds){
    	double dblBlockPercent = ((double)intBlockedAttacks/(double)rounds)* 100;
    	System.out.printf("Blocked Attacks: %3.1f%% \n", dblBlockPercent);
    }
}