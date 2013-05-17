package com.dddbomber.fishingjam.instance.equipment;

import com.dddbomber.fishingjam.instance.fish.FishType;

public enum EquipmentType {
	net(true, true, true, true, false, false), pole(true, true, false, false, true, true), line(false, false, true, true, true, true), rod(true, true, true, true, true, true);
	
	public boolean salmon, tuna, haddock, mackeral, crab, shrimp;
	
	EquipmentType(boolean salmon, boolean tuna, boolean haddock, boolean mackeral, boolean crab, boolean shrimp){
		this.salmon = salmon;
		this.tuna = tuna;
		this.haddock = haddock;
		this.mackeral = mackeral;
		this.crab = crab;
		this.shrimp = shrimp;
	}
	
	public boolean canCatch(FishType type){
		if(type == FishType.salmon)return salmon;
		if(type == FishType.tuna)return tuna;
		if(type == FishType.haddock)return haddock;
		if(type == FishType.mackeral)return mackeral;
		if(type == FishType.crab)return crab;
		if(type == FishType.shrimp)return shrimp;
		return false;
	}
}
