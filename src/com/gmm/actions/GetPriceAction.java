package com.gmm.actions;

import com.gmm.db.DBConnector;
import com.gmm.filter.GameFilter;


//Action class to process the input name value and to set price value
public class GetPriceAction {
	private String name;
	private int price;
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	//preliminary check for presence of given game name in bloom filter
	private boolean isPossible() {
		return new GameFilter().mightContain(this.name);
	}
	
	public String execute() throws Exception{
		if(isPossible()) {
			DBConnector connector = new DBConnector();
			if(connector.isPresent(name)) {
				price = connector.getPrice(name);
				return "success";
			}
		}
		return "error";
	}
}