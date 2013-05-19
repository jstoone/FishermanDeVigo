package com.dddbomber.fishingjam.instance;

import java.util.ArrayList;

import com.dddbomber.fishingjam.instance.boat.Boat;
import com.dddbomber.fishingjam.instance.equipment.Equipment;
import com.dddbomber.fishingjam.instance.family.Person;
import com.dddbomber.fishingjam.instance.fish.Fish;
import com.dddbomber.fishingjam.menu.FamilyMenu;
import com.dddbomber.fishingjam.menu.Menu;
import com.dddbomber.fishingjam.menu.NewspaperMenu;
import com.dddbomber.fishingjam.news.News;

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
		
		unlockBoat(Boat.rowboat);
		selectedEquipment = Equipment.smallRod;
	}
	
	public void unlockBoat(Boat boat){
		if(!boats.contains(boat)){
			boats.add(boat);
		}
		selectedBoat = boat;
	}
	
	public void nextDay(){
		for(Person p : family){
			p.health -= 5;
			p.happiness -= 5;
			p.hunger -= 5;
			
			if(!p.male)p.health -= 5;
		}
		family.get(0).hunger -= 5;
		family.get(1).hunger -= 5;

		family.get(2).happiness -= 5;
		family.get(3).happiness -= 5;
		Menu.menu = new FamilyMenu(new NewspaperMenu(News.newsList[day++]));
	}
	
	public ArrayList<Fish> fishInBoat = new ArrayList<Fish>();
	
	public int day = 0;
	public int money = 100;
	
	public ArrayList<Boat> boats = new ArrayList<Boat>();
	public ArrayList<Equipment> equipment = new ArrayList<Equipment>();
	
	public Boat selectedBoat;
	public Equipment selectedEquipment;

	public ArrayList<Person> family = new ArrayList<Person>();
	public ArrayList<Person> workers = new ArrayList<Person>();
}
