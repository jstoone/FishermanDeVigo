package com.dddbomber.fishingjam.instance;

import java.util.ArrayList;

import com.dddbomber.fishingjam.instance.boat.Boat;
import com.dddbomber.fishingjam.instance.equipment.Equipment;

public class Instance {
	public int day = 0;
	public int money = 100;
	
	public ArrayList<Boat> boats = new ArrayList<Boat>();
	public ArrayList<Equipment> equipment = new ArrayList<Equipment>();
	
	public Boat selectedBoat;
	public Equipment selectedEquipment;
}
