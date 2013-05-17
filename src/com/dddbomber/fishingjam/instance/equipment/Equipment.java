package com.dddbomber.fishingjam.instance.equipment;

public class Equipment {

	public static final Equipment smallNet = new Equipment("Small Net");
	public static final Equipment net = new Equipment("Net");
	public static final Equipment largeNet = new Equipment("Large Net");

	public static final Equipment smallPole = new Equipment("Small Pole");
	public static final Equipment pole = new Equipment("Pole");
	public static final Equipment largePole = new Equipment("Large Pole");
	
	public static final Equipment smallLine = new Equipment("Small Line");
	public static final Equipment line = new Equipment("Line");
	public static final Equipment largeLine = new Equipment("Large Line");

	public static final Equipment smallRod = new Equipment("Small Rod");
	public static final Equipment rod = new Equipment("Rod");
	public static final Equipment largeRod = new Equipment("Large Rod");
	
	public String name;
	
	public Equipment(String name){
		this.name = name;
	}
}
