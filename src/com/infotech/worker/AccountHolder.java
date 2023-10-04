package com.infotech.worker;

import com.infotech.model.Account;

public class AccountHolder implements Runnable {
	private Account account;

	public AccountHolder(Account account) {
		this.account = account;
	}

	@Override
	public void run() {
		for (int i = 1; i <= 4; i++) {
			makeWithdrawal(3000);
			addBalance(1000);
			if (account.getBalance() < 0) {
				System.out.println("Insufficient Balance in your account! "+account.getBalance());
			}
		}
	}

	private synchronized void addBalance(int addAmpont) {
		account.addBalance(addAmpont);
		System.out.println("Total balance = "+account.getBalance());
	}

	private synchronized void makeWithdrawal(int withdrawAmount) {
		if (account.getBalance() >= withdrawAmount) {
			System.out.println(Thread.currentThread().getName()	+ " is going to withdraw $"+withdrawAmount);
			try {
				Thread.sleep(3000);
			} catch (InterruptedException ex) {
			}
			account.withdraw(withdrawAmount);
			System.out.println(Thread.currentThread().getName()	+ " completes the withdrawal of $"+withdrawAmount);
		} else {
			System.out.println("Not enough in account balance for "	+ Thread.currentThread().getName() + " to withdraw "
					+withdrawAmount+" Current account balance is = "+account.getBalance());
		}
	}
}