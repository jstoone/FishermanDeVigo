package com.dddbomber.fishingjam.instance.boat;

import com.dddbomber.fishingjam.assets.Asset;
import com.dddbomber.fishingjam.assets.Bitmap;
import com.dddbomber.fishingjam.instance.Instance;

public class Boat {

	public static final Boat rowboat = new Boat("Rowboat", 1, 1).setRender(Asset.smallRowboat);
	public static final Boat rowboat2 = new Boat("Rowboat", 2, 1).setRender(Asset.bigRowboat);
	
	public static final Boat anglersBoat = new Boat("Anglers Boat", 1, 2);
	public static final Boat fishersBoat = new Boat("Fishers Boat", 2, 2);
	public static final Boat castersBoat = new Boat("Casters Boat", 3, 2);
	
	public static final Boat anglersShip = new Boat("Anglers Ship", 2, 2);
	public static final Boat fishersShip = new Boat("Fishers Ship", 3, 2);
	public static final Boat castersShip = new Boat("Casters Ship", 4, 2);
	
	public static final Boat anglersVessel = new Boat("Anglers Vessel", 1, 3);
	public static final Boat fishersVessel = new Boat("Fishers Vessel", 2, 3);
	public static final Boat castersVessel = new Boat("Casters Vessel", 3, 3);

	public static final Boat trawler = new Boat("Trawler", 4, 3);
	
	public String name;
	public int capacity, speed;
	
	public Boat(String name, int capacity, int speed){
		this.name = name;
		this.capacity = capacity;
		this.speed = speed;
	}
	
	public Bitmap render;
	
	public Boat setRender(Bitmap render){
		this.render = render;
		return this;
	}
}
