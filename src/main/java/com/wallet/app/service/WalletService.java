package com.wallet.app.service;

import com.wallet.app.dto.Wallet;
import com.wallet.app.exception.WalletException;

public interface WalletService {

	Boolean createWallet(Wallet wallet) throws WalletException;

	Wallet getWalletById(Integer walletId) throws WalletException;

	Double addFundsToWallet(Integer walletId, Double amount) throws WalletException;

	Boolean fundTransfer(Integer fromWalletId, Integer toWalletId, Double amount) throws WalletException;

	Boolean login(Integer walletId, String password) throws WalletException;
	
	Boolean deleteWalletByid(Integer walletId) throws WalletException;

}