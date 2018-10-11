package org.study.model;

public class Sale {
	
	private int id;
	private String name;
	private String grade;
	private int sales;
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
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public int getSales() {
		return sales;
	}
	public void setSales(int sales) {
		this.sales = sales;
	}
	@Override
	public String toString() {
		return "Sale [id=" + id + ", name=" + name + ", grade=" + grade + ", sales=" + sales + "]";
	}

	
	
}
