package com.day1;

public class CustomerDemo {

	public static void main(String[] args) {
		Customer c1=new Customer("pasha", 123);
		System.out.println(c1);
		c1.setName("Kab");
		c1.setBalance(111);
		System.out.println(c1);

	}

}
