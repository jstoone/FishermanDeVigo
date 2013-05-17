package com.dddbomber.fishingjam.instance.family;

import com.dddbomber.fishingjam.assets.NameGenerator;

public class Person {
	public int happiness = 100, health = 100, fatigue = 100, hunger = 100;
	public String name = "";
	
	public Person(){
		name = NameGenerator.getInstance().getName();
	}
	
}
