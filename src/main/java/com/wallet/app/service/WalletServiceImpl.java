package com.wallet.app.service;

import com.wallet.app.dao.WalletRepository;
import com.wallet.app.dao.WalletRepositoryImpl;
import com.wallet.app.dto.Wallet;
import com.wallet.app.exception.WalletException;

public class WalletServiceImpl implements WalletService {

	WalletRepository walletrepo = new WalletRepositoryImpl();

	public Boolean createWallet(Wallet wallet) throws WalletException {
		if (wallet == null)
			return false;
		return this.walletrepo.addWallet(wallet);
	}

	public Wallet getWalletById(Integer walletId) throws WalletException {

		return this.walletrepo.getWalletById(walletId);
	}

	public Double addFundsToWallet(Integer walletId, Double addamount) throws WalletException {

		Wallet foundWallet = this.walletrepo.getWalletById(walletId);
		Double newBalance = foundWallet.getBalance() + addamount;
		foundWallet.setBalance(newBalance);
		this.walletrepo.updateWallet(foundWallet);

		return newBalance;
	}

	public Boolean fundTransfer(Integer fromWalletId, Integer toWalletId, Double transferAmt)
			throws WalletException {

		Wallet fromWallet = this.getWalletById(fromWalletId);
		Wallet toWallet = this.getWalletById(toWalletId);

		Boolean isAmtTransfered = false;
		
		if (fromWallet == null)
			throw new WalletException("Fromwallet does not exists!");
		

		if (toWallet == null)
			throw new WalletException("Towallet does not exists!");

		if (fromWallet.getBalance() >= transferAmt) {

			Double newBalance = fromWallet.getBalance() - transferAmt;			
			fromWallet.setBalance(newBalance);
			this.walletrepo.updateWallet(fromWallet);
			newBalance = toWallet.getBalance() + transferAmt;
			toWallet.setBalance(newBalance);
			this.walletrepo.updateWallet(toWallet);
			
			isAmtTransfered = true;
			
		} else {
			throw new WalletException("Insufficent amount in Fromwallet");
		}

		return isAmtTransfered;
	}

	public Boolean login(Integer walletId, String password) throws WalletException {
		return this.walletrepo.login(walletId, password);
	}

	public Boolean deleteWalletByid(Integer walletId) throws WalletException {

		return this.walletrepo.deleteWalletById(walletId);
	}

}