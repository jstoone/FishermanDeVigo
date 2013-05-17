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
		int i = random.nextInt(38);
		String s = "ERROR";
		if(i == 0)s = "Dylan";
		if(i == 1)s = "Nick";
		if(i == 2)s = "Samuel";
		if(i == 3)s = "Thomas";
		if(i == 4)s = "William";
		if(i == 5)s = "Joshua";
		if(i == 6)s = "Daniel";
		if(i == 7)s = "Ronny";
		if(i == 8)s = "Dick";
		if(i == 9)s = "Harvey";
		if(i == 10)s = "Willie";
		if(i == 11)s = "Gus";
		if(i == 12)s = "Edward";
		if(i == 13)s = "Dregg";
		if(i == 14)s = "George";
		if(i == 15)s = "Finn";
		if(i == 16)s = "Walt";
		if(i == 17)s = "Hank";
		if(i == 18)s = "Barney";
		if(i == 19)s = "Billy";
		if(i == 20)s = "Radley";
		if(i == 21)s = "Butch";
		if(i == 22)s = "Drake";
		if(i == 23)s = "Logan";
		if(i == 24)s = "Joe";
		if(i == 25)s = "Joseph";
		if(i == 26)s = "Logan";
		if(i == 27)s = "Scott";
		if(i == 28)s = "Carl";
		if(i == 29)s = "Tobias";
		if(i == 30)s = "Walter";
		if(i == 31)s = "Jonathon";
		if(i == 32)s = "Edmund";
		if(i == 33)s = "Markus";
		if(i == 34)s = "Davy";
		if(i == 35)s = "Wylie";
		if(i == 36)s = "Patrick";
		if(i == 37)s = "Jack";
		return s;
	}
	
	public String getLast(){
		int i = random.nextInt(35);
		String s = "ERROR";
		if(i == 0)s = "Swiftknife";
		if(i == 1)s = "Leadblade";
		if(i == 2)s = "Jailbird";
		if(i == 3)s = "Knifenose";
		if(i == 4)s = "Bones";
		if(i == 5)s = "Firecrotch";
		if(i == 6)s = "Roughknuckles";
		if(i == 7)s = "Pinkbeard";
		if(i == 8)s = "Bluebeard";
		if(i == 9)s = "Bloodsmear";
		if(i == 10)s = "Slasher";
		if(i == 11)s = "Bloodbeard";
		if(i == 12)s = "Bloodgut";
		if(i == 13)s = "Dregg";
		if(i == 14)s = "Skullcrack";
		if(i == 15)s = "Sharkchum";
		if(i == 16)s = "Cutler";
		if(i == 17)s = "Backstabber";
		if(i == 18)s = "Cannonball";
		if(i == 19)s = "Bloodbath";
		if(i == 20)s = "Cutthroat";
		if(i == 21)s = "Armstrong";
		if(i == 22)s = "Sharktooth";
		if(i == 23)s = "Stormbreaker";
		if(i == 23)s = "Redjaw";
		if(i == 24)s = "Whiteblood";
		if(i == 25)s = "Drake";
		if(i == 26)s = "Scarface";
		if(i == 27)s = "Whiteblood";
		if(i == 28)s = "Jones";
		if(i == 29)s = "Throatslasher";
		if(i == 30)s = "Razorface";
		if(i == 31)s = "Razorface";
		if(i == 32)s = "Razorface";
		if(i == 33)s = "Razorface";
		if(i == 34)s = "Razorface";
		return s;
	}
}
