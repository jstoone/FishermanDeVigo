package com.dddbomber.fishingjam.instance.fish;

public enum FishType {
	salmon("Salmon"), tuna("Tuna"), haddock("Haddock", 15), mackeral("Mackeral", 15), crab("Crab", 25), shrimp("Shrimp", 5);
	
	public String name;
	public int baseValue = 10;
	
	FishType(String name){
		this.name = name;
	}
	
	FishType(String name, int baseValue){
		this.name = name;
		this.baseValue = baseValue;
	}
}
