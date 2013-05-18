package com.dddbomber.fishingjam.news;

public class News {
	public static News[] newsList = new News[120];
	public static int idToGive = 0;

	public static final News start = new News("January 4th 1930", "Depression Hits Vigo");
	public static final News fish = new News("February 1st 1930", "Tuna Spotted At Coast");
	
	public String date;
	public String headline;
	
	public News(String date, String headline){
		this.date = date;
		this.headline = headline;
		newsList[idToGive] = this;
	}
}
