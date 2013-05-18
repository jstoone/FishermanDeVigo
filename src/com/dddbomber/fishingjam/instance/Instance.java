package com.dddbomber.fishingjam.instance;

import java.util.ArrayList;

import com.dddbomber.fishingjam.instance.boat.Boat;
import com.dddbomber.fishingjam.instance.equipment.Equipment;
import com.dddbomber.fishingjam.instance.family.Person;

public class Instance {
	private static Instance instance;
	public static Instance getInstance(){
		if(instance != null)return instance;
		instance = new Instance();
		return instance;
	}
	
	public Instance(){
		//YOU
		family.add(new Person(true, true, "Abel Pescadoado"));
		//WIFE
		family.add(new Person(false, false, "Vanesa Pescadoado"));
		//SON
		family.add(new Person(true, false, "Frederico Pescadoado"));
		//DAUGHTER
		family.add(new Person(false, false, "Adelita Pescadoado"));
		
		selectedBoat = Boat.rowboat2;
		selectedEquipment = Equipment.smallRod;
	}
	
	public int day = 0;
	public int money = 100;
	
	public ArrayList<Boat> boats = new ArrayList<Boat>();
	public ArrayList<Equipment> equipment = new ArrayList<Equipment>();
	
	public Boat selectedBoat;
	public Equipment selectedEquipment;

	public ArrayList<Person> family = new ArrayList<Person>();
	public ArrayList<Person> workers = new ArrayList<Person>();
}
