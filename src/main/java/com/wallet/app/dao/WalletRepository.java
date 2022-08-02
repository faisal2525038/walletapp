package com.wallet.app.dao;

import com.wallet.app.dto.Wallet;
import com.wallet.app.exception.WalletException;

public interface WalletRepository {

	Boolean addWallet(Wallet wallet) throws WalletException;

	Wallet getWalletById(Integer walletId) throws WalletException;

	Wallet updateWallet(Wallet wallet) throws WalletException;
	
	Boolean login(Integer walletId, String password) throws WalletException;

	Boolean deleteWalletById(Integer wallet) throws WalletException;
}