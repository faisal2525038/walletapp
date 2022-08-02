package com.wallet.app.dao;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.wallet.app.dto.Wallet;
import com.wallet.app.exception.WalletException;

public class WalletRepositoryImpl implements WalletRepository {

	public Boolean addWallet(Wallet wallet) throws WalletException {

		Connection connection = DaoUtility.getConnection();
		Boolean isWalletAdded = false;

		try {

			PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Wallet(id,name,balance,password,creationDate) VALUES(?,?,?,?,?)");
			preparedStatement.setInt(1, wallet.getId());
			preparedStatement.setString(2, wallet.getName());
			preparedStatement.setDouble(3, wallet.getBalance());
			preparedStatement.setString(4, wallet.getPassword());
			preparedStatement.setDate(5, Date.valueOf(wallet.getCreationDate()));
			if (preparedStatement.executeUpdate() > 0) {
				isWalletAdded = true;

				
			} else {
				throw new WalletException("Wallet not created");

			}

		} catch (SQLException e) {
			// To-DO handle exception

		}
		return isWalletAdded;
	}

	public Wallet getWalletById(Integer walletId) throws WalletException {

		Connection connection = DaoUtility.getConnection();

		Wallet wallet = null;
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Wallet WHERE id = ?");
			preparedStatement.setInt(1, walletId);

			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				wallet = new Wallet(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getDouble("balance"),
						resultSet.getString("password"), resultSet.getDate("creationDate").toLocalDate());
			} else {

				throw new WalletException("Wallet not found for id:" + walletId);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return wallet;

	}

	public Wallet updateWallet(Wallet wallet) throws WalletException {

		Connection connection = DaoUtility.getConnection();
		Wallet updatedWallet = null;

		try {

			PreparedStatement ps = connection
					.prepareStatement("UPDATE Wallet set name=?,balance=?,password=?,creationDate=? WHERE id = ?");
			ps.setInt(5, wallet.getId());
			ps.setString(1, wallet.getName());
			ps.setDouble(2, wallet.getBalance());
			ps.setString(3, wallet.getPassword());
			ps.setDate(4, Date.valueOf(wallet.getCreationDate()));

			if (ps.executeUpdate() > 0) {
				updatedWallet = wallet;

			} else { // TO-DO handle exception

			}

		} catch (SQLException e) {
			throw new WalletException("Wallet not updated:");

		}
		return updatedWallet;
	}

	public Boolean deleteWalletById(Integer walletId) throws WalletException {

		Connection connection = DaoUtility.getConnection();
		Boolean isWalletDeleted = false;

		try {

			PreparedStatement ps = connection.prepareStatement("DELETE FROM Wallet WHERE id = ?");
			ps.setInt(1, walletId);

			if (ps.executeUpdate() > 0) {

				isWalletDeleted = true;

			} else { 
				throw new WalletException("Wallet not deleted for id:" + walletId);

			}

		} catch (SQLException e) {
			// To-DO handle exception

		}
		return isWalletDeleted;
	}
	
	
	public Boolean login(Integer walletId, String password) throws WalletException{
		Connection connection = DaoUtility.getConnection();
		Boolean isLoginBoolean = false;
		 
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Wallet WHERE id = ? AND password = ?");
			preparedStatement.setInt(1, walletId);
			preparedStatement.setString(2,password);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				
				Wallet wallet = new Wallet(resultSet.getInt("id"), resultSet.getString("name"),resultSet.getDouble("balance"), resultSet.getString("password"),resultSet.getDate("creationDate").toLocalDate());
				System.out.println("Information Received" + wallet);
			
				isLoginBoolean = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return isLoginBoolean;
	}
}


