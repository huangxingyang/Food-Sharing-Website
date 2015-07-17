package edu.neu.webtoolFinal.model;

public class Picture {
private int id;
private String url;
private String type;//for user profolio or dish
private  String date;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getUrl() {
	return url;
}
public void setUrl(String url) {
	this.url = url;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}


}
