package com.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerDemo2 {

	public static void main(String[] args) {
		function();

	}

	private static void function() {
		Scanner sc = new Scanner(System.in);
		List<Customer> customerList = new ArrayList<Customer>();

		int choice, id;
		String name;
		double ammount, transferableMoney;

		do {
			System.out.println("1. Add Customer");
			System.out.println("2. Display All Customer");
			System.out.println("3. Display Customer By ID");
			System.out.println("4. Deposit Money");
			System.out.println("5. Withdraw");
			System.out.println("6. Transfer");
			System.out.println("7. EXIT");

			System.out.println("Enter Your Choice: ");
			choice = sc.nextInt();

			switch (choice) {
			case 1:
				System.out.println("Enter Name: ");
				name = sc.next();
				System.out.println("Enter Ammount: ");
				ammount = sc.nextDouble();
				Customer customer = new Customer(name, ammount);
				customerList.add(customer);
				break;
			case 2:
				System.out.println(customerList);
				break;

			case 3:
				System.out.println("Enter ID: ");
				id = sc.nextInt();
				boolean accountExist = false;

				for (Customer cust : customerList) {
					if (cust.getId() == id) {
						System.out.println(cust);
						accountExist = true;
					}
				}
				if (accountExist == false) {
					System.out.println("Customer Does not Exist.");
				}
				break;

			case 4:
				System.out.println("Enter Your Account number: ");
				id = sc.nextInt();
				boolean acctExist = false;
				for (Customer cust : customerList) {
					if (cust.getId() == id) {
						acctExist = true;
						System.out.println("Enter the Ammount to deposit: ");
						ammount = sc.nextDouble();
						if (ammount <= 10000) {
							cust.setBalance(cust.getBalance() + ammount);
							System.out.println("Your Deposit of " + ammount + " has been successful."
									+ " Your New balance = " + cust.getBalance());
						} else {
							System.out.println("We Are sorry, You can Only deposit up $1000 here.");
						}
					}

				}
				if (acctExist == false) {
					System.out.println("Customer Does not Exist.");
				}
				break;

			case 5:
				System.out.println("Enter Your Account number: ");
				id = sc.nextInt();
				boolean accExist = false;
				for (Customer cust : customerList) {
					if (cust.getId() == id) {
						accExist = true;

						System.out.println("Your Balance : " + cust.getBalance());
						System.out.println("You can Withdraw up to $10,000 at once");
						double withdrawableMoney = cust.getBalance() - 500;
						if (withdrawableMoney >= 10000) {
							System.out.println("Available to withdraw: $10000");
						} else {

							System.out.println("Available to withdraw: " + (cust.getBalance() - 500));
						}
						System.out.println("Enter the Ammount to Withdraw: ");
						ammount = sc.nextDouble();
						if (ammount <= 10000 && ammount <= withdrawableMoney) {
							cust.setBalance(cust.getBalance() - ammount);
							System.out.println("Your withdraw of " + ammount + " has been successful."
									+ " Your New balance = " + cust.getBalance());
						} else {
							System.out.println("We Are sorry, Limit Crossed or You do not hava enough Balance");
						}
					}
				}
				if (accExist == false) {
					System.out.println("Invalid Account Number");
				}
				break;

			case 6:
				System.out.println("Welcme to Trnasfer Portal");
				System.out.println("Please Enter your Account Number: ");
				id = sc.nextInt();
				boolean acExist = false;
				for (Customer cust : customerList) {
					if (cust.getId() == id) {
						acExist = true;
						System.out.println("Your Balance : " + cust.getBalance());
						System.out.println("You can Transfer up to $10,000 at once");
						transferableMoney = cust.getBalance() - 500;
						if (transferableMoney >= 10000) {
							transferableMoney = 10000;
						}

						System.out.println("Available to transfer: " + transferableMoney);

						System.out.println("Please Enter the Receiving Account Number:");
						int receivingId = sc.nextInt();
						boolean aExist = false;
						for (Customer custm : customerList) {
							if (custm.getId() == receivingId) {
								aExist = true;
								System.out.println("Enter the ammount to Transfer: ");
								double transfer = sc.nextDouble();
								if (transfer <= transferableMoney) {
									custm.setBalance(custm.getBalance() + transfer);
									cust.setBalance(cust.getBalance() - transfer);
									System.out.println("Your Transfer of " + transfer + " to Account " + receivingId
											+ " has been completed. \nyour New Balance is " + cust.getBalance());
								} else {
									System.out.println("You do not have enougn Balance or Limit Crossed");
								}
							}
						}
						if (aExist == false) {
							System.out.println("invalid receiving Account Number");
						}
					}
				}
				if (acExist == false) {
					System.out.println("Your Account Number is invalid");
				}
				break;

			case 7:
				System.out.println("Thank you for using our service \nhave a Good Day");

			}
		} while (choice < 7);

	}
}
