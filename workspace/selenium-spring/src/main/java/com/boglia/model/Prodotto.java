package com.boglia.model;


class Rating{
	private double rate;
	private int count;
	
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "Rating [rate=" + rate + ", count=" + count + "]";
	}
	
	
}

public class Prodotto {

	private int id;
	private String title;
	private String description;
	private String category;
	private String image;
	
	private Rating rating;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Rating getRating() {
		return rating;
	}
	public void setRating(Rating rating) {
		this.rating = rating;
	}
	@Override
	public String toString() {
		return "Prodotto [id=" + id + ", title=" + title + ", description=" + description + ", category=" + category
				+ ", image=" + image + ", rating=" + rating + "]";
	}
	
	
	
	
	
	
}
