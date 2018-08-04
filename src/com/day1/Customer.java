package com.day1;

public class Customer {
	
	private int id;
	private String name;
	private double balance;
	static int count=100;
	
	
	public Customer() {
		super();
		
	}
	public Customer(String name, double balance) {
		super();
		this.id = count++;
		this.name = name;
		this.balance = balance;
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
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", balance=" + balance + "]\n";
	}
	

	

}
