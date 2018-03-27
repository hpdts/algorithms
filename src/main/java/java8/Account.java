package java8;

import java.util.*;
import static java.lang.Math.*;
import java.util.stream.*;

public class Account {
	private String name;
	private int date; //unix timestamp
	private int balance; 

	public Account(String name, int date, int balance){
		this.name = name;
		this.date = date;
		this.balance = balance;
	}

	@Override
	public boolean equals(Object object){
		if(object instanceof Account){
			Account account = (Account) object;
			return this.name == account.name && this.date == account.date;
		}else{
			return false;
		}
	}

	public static void checkOldAccounts(List<Account> previousAccounts, List<Account> currentAccounts){
		//Set<Account> duplicatedAccounts = new HashSet<>();
		for(Account previousAccount : previousAccounts){
			for(Account currentAccount : currentAccounts){
				if(previousAccount.equals(currentAccount)){
					int balanceDifference = previousAccount.balance - currentAccount.balance;
					System.out.println("duplicated account: " + previousAccount.name + ", balanceDifference: " + balanceDifference);
					//duplicatedAccounts.add(previousAccount);
				}
			}
		}
		List<Account> clonePreviousAccounts = new ArrayList<>(previousAccounts);
		clonePreviousAccounts.removeAll(currentAccounts);
		for(Account deletedAccount : clonePreviousAccounts){
			System.out.println("Deleted account: " + deletedAccount.name);
		}
		/*for(Account previousAccount : previousAccounts){
			if(!duplicatedAccounts.contains(previousAccount)){
				System.out.println("Deleted account: " + previousAccount.name);
			}
		}*/

		//check contains on list
		/*for(Account currentAccount : currentAccounts){
			boolean found = false;
			for(Account previousAccount : previousAccounts){
				if(currentAccount.equals(previousAccount)){
					found = true;
					break;
				}
			}
			if(!found){
				System.out.println("Added account: " + currentAccount.name);
			}
		}*/

		List<Account> clonecurrentAccounts = new ArrayList<>(currentAccounts);
		clonecurrentAccounts.removeAll(previousAccounts);
		for(Account addedAccount : clonecurrentAccounts){
			System.out.println("Added account: " + addedAccount.name);
		}

	}
}