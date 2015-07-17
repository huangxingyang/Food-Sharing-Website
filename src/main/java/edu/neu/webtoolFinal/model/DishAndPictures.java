package edu.neu.webtoolFinal.model;

import java.util.ArrayList;

public class DishAndPictures {
	private Dish dish;
	private String url;
	private ArrayList<PictureForDish> apd;
	private ArrayList<Hot> hl;
	
	
	
	public ArrayList<Hot> getHl() {
		return hl;
	}
	public void setHl(ArrayList<Hot> hl) {
		this.hl = hl;
	}
	public Dish getDish() {
		return dish;
	}
	public void setDish(Dish dish) {
		this.dish = dish;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public ArrayList<PictureForDish> getApd() {
		return apd;
	}
	public void setApd(ArrayList<PictureForDish> apd) {
		this.apd = apd;
	}
	
	

}
