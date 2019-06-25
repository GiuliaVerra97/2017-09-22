package it.polito.tdp.formulaone.model;

public class Archi {
	
	private int gara1;
	private int gara2;
	private int numPiloti;
	
	 public Archi(int gara1, int gara2, int numPiloti) {
		super();
		this.gara1 = gara1;
		this.gara2 = gara2;
		this.numPiloti = numPiloti;
	}
	
	 
	public int getGara1() {
		return gara1;
	}
	public void setGara1(int gara1) {
		this.gara1 = gara1;
	}
	public int getGara2() {
		return gara2;
	}
	public void setGara2(int gara2) {
		this.gara2 = gara2;
	}
	public int getNumPiloti() {
		return numPiloti;
	}
	public void setNumPiloti(int numPiloti) {
		this.numPiloti = numPiloti;
	}
	

}
