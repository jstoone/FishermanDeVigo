package com.dddbomber.fishingjam.instance.equipment;

public class Equipment {

	public static final Equipment smallNet = new Equipment("Small Net", EquipmentType.net);
	public static final Equipment net = new Equipment("Net", EquipmentType.net);
	public static final Equipment largeNet = new Equipment("Large Net", EquipmentType.net);

	public static final Equipment smallPole = new Equipment("Small Pole", EquipmentType.pole);
	public static final Equipment pole = new Equipment("Pole", EquipmentType.pole);
	public static final Equipment largePole = new Equipment("Large Pole", EquipmentType.pole);
	
	public static final Equipment smallLine = new Equipment("Small Line", EquipmentType.line);
	public static final Equipment line = new Equipment("Line", EquipmentType.line);
	public static final Equipment largeLine = new Equipment("Large Line", EquipmentType.line);

	public static final Equipment smallRod = new Equipment("Small Rod", EquipmentType.rod);
	public static final Equipment rod = new Equipment("Rod", EquipmentType.rod);
	public static final Equipment largeRod = new Equipment("Large Rod", EquipmentType.rod);
	
	public String name;
	public EquipmentType type;
	
	public Equipment(String name, EquipmentType type){
		this.name = name;
	}
}
