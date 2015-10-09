package test;

import org.junit.Assert;
import org.junit.Test;

import java.util.Scanner;

import fightSimulator.Fighter;
import fightSimulator.Simulator;

public class FightSimulatorTest {

	private Fighter ftr;
	private Fighter ftr2;
	private Simulator sim;
	
	@Test(expected=IllegalArgumentException.class)
	public void testFighter(){
		ftr = new Fighter(100,100,100);
		ftr = new Fighter(-200, 0, 0);
		ftr = new Fighter(0, -200, 0);
		ftr = new Fighter(0, 0, -200);
		Scanner in = null;
		ftr = new Fighter(in);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testSimulator(){
		ftr = new Fighter(20,20,20);
		ftr2 = null;
		sim = new Simulator(ftr, ftr2);
		sim = new Simulator(ftr2, ftr);
		
		Scanner in = null;
		sim.determineRounds(in);
	}


}