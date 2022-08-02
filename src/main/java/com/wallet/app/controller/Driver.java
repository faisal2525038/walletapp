package com.wallet.app.controller;
import java.time.LocalDate;

import java.util.Scanner;
import com.wallet.app.dto.Wallet;
import com.wallet.app.exception.WalletException;
import com.wallet.app.service.WalletService;
import com.wallet.app.service.WalletServiceImpl;

public class Driver {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		WalletService walletService = new WalletServiceImpl();
		System.out.println("---------WELCOME TO WALLET SERVICES------");
		System.out.println("1. Create Wallet");
		System.out.println("2. Get Information by ID");
		System.out.println("3. Add Money");
		System.out.println("4. Transfer money");
		System.out.println("5. Login");
		System.out.println("6. Delete record");

		
		int a = sc.nextInt();

		switch (a) {
		case 1:
			try {
				System.out.println(walletService.createWallet(new Wallet(1, "faisal",2000.00, "faisal21",LocalDate.of(2022, 7, 14))));
			} catch (WalletException e) {
				System.out.println("Error Occured" + e.getMessage());
			}	
			break;
		case 2:
			try {
				System.out.println(walletService.getWalletById(1));
			} catch (WalletException e1) {
				System.out.println(e1.getMessage());
			}
			break;
		case 3:	
			try {
				System.out.println(walletService.addFundsToWallet(1, 30000.00));
			} catch (WalletException e) {
				System.out.println(e.getMessage());
			}	
			break;
			
		
		case 4:
			try {
				walletService.fundTransfer(2,1,500.00);
			} catch (WalletException e) {
				System.out.println(e.getMessage());
			}
			
		case 5:
			try {
				System.out.println(walletService.login(1, "faisal21"));
			} catch (WalletException e) {
				System.out.println(e.getMessage());
			}
			break;
		case 6:
			try {
				System.out.println(walletService.deleteWalletByid(1));
			} catch (WalletException e) {
				System.out.println(e.getMessage());
			}
			break;
		default:
			break;
		}
			}

}

