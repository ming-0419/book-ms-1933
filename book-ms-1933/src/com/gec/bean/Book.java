package com.gec.bean;

/**
 * 这里建立一个Book类这个JavaBean里面封装了这个图书信息
 * 
 * 	根据对象关系的原则，从数据表查询出来的数据，会存放到java对象中
 * 
 * 	java对象的类里面存放的内容就跟对应的数据库表存放字段信息是一样的
 * @author lenovo
 *
 */
public class Book {
	private int id;
	private String name;
	private String author;
	private double price;
	
	
	
	public Book(int id, String name, String author, double price) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
		this.price = price;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public Book() {

	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}


	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", author=" + author + ", price=" + price + "]";
	}
	

	
	
	
	

}
