package com.dddbomber.fishingjam.assets;

import java.util.Random;

public class NameGenerator {
	
	public static NameGenerator instance;
	
	public static NameGenerator getInstance(){
		if(instance == null)instance = new NameGenerator();
		return instance;
	}
	
	Random random = new Random();
	
	public String getName(){
		return getFirst() +" " + getLast();
	}
	
	public String getFirst(){
		int i = random.nextInt(35);
		String s = "ERROR";
		if(i == 0)s = "Bruno";
		if(i == 1)s = "Carles";
		if(i == 2)s = "Carlos";
		if(i == 3)s = "Daniel";
		if(i == 4)s = "Diego";
		if(i == 5)s = "Enric";
		if(i == 6)s = "Fabio";
		if(i == 7)s = "Felipe";
		if(i == 8)s = "Gabriel";
		if(i == 9)s = "Gonzalo";
		if(i == 10)s = "Jose";
		if(i == 11)s = "Hector";
		if(i == 12)s = "Gustavo";
		if(i == 13)s = "Hugo";
		if(i == 14)s = "Lucio";
		if(i == 15)s = "Marcello";
		if(i == 16)s = "Martin";
		if(i == 17)s = "Miquel";
		if(i == 18)s = "Nando";
		if(i == 19)s = "Nico";
		if(i == 20)s = "Pablo";
		if(i == 21)s = "Pepe";
		if(i == 22)s = "Rafael";
		if(i == 23)s = "Raul";
		if(i == 24)s = "Sergio";
		if(i == 25)s = "Silvio";
		if(i == 26)s = "Teo";
		if(i == 27)s = "Tulio";
		if(i == 28)s = "Vasco";
		if(i == 29)s = "Vicent";
		if(i == 30)s = "Victor";
		if(i == 31)s = "Xabi";
		if(i == 32)s = "Xavi";
		if(i == 33)s = "Yago";
		if(i == 34)s = "Zacarias";
		return s;
	}
	
	public String getLast(){
		int i = random.nextInt(25);
		String s = "ERROR";
		if(i == 0)s = "Garcia";
		if(i == 1)s = "Martinez";
		if(i == 2)s = "Rodriguez";
		if(i == 3)s = "Gonzalez";
		if(i == 4)s = "Hernandez";
		if(i == 5)s = "Sanchez";
		if(i == 6)s = "Gomez";
		if(i == 7)s = "Cruz";
		if(i == 8)s = "Ramos";
		if(i == 9)s = "Chavez";
		if(i == 10)s = "Castillo";
		if(i == 11)s = "Garza";
		if(i == 12)s = "Romero";
		if(i == 13)s = "Fernandez";
		if(i == 14)s = "Mendoza";
		if(i == 15)s = "Rosales";
		if(i == 16)s = "Castro";
		if(i == 17)s = "Rodriguez";
		if(i == 18)s = "Mendez";
		if(i == 19)s = "Santiago";
		if(i == 20)s = "Valdez";
		if(i == 21)s = "Rios";
		if(i == 22)s = "Delgado";
		if(i == 23)s = "Salazar";
		if(i == 23)s = "Morales";
		if(i == 24)s = "Banez";
		return s;
	}
}
