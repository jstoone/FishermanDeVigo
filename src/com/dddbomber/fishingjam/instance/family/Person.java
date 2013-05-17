package com.dddbomber.fishingjam.instance.family;

import com.dddbomber.fishingjam.assets.NameGenerator;

public class Person {
	public int happiness = 100, health = 100, fatigue = 100, hunger = 100;
	public boolean canWork, male;
	public String name = "";
	
	public Person(boolean male, boolean canWork){
		this.male = male;
		this.canWork = canWork;
		name = NameGenerator.getInstance().getName();
	}
	
}
