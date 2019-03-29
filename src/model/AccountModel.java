package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entities.Account;
import util.ConnectionDB;

public class AccountModel {

	public List<Account> getAccountDB() {
		Connection conn = null;
		PreparedStatement pstm = null;
		List<Account> listAccount = new ArrayList<>();
		try {
			conn = ConnectionDB.openConnection();
			String sql = "SELECT ac.ACCOUNT_ID, ac.FIRST_NAME, ac.LAST_NAME, ac.EMAIL FROM ACCOUNT ac";
			pstm = conn.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();

			while (rs.next()) {

				Account ac = new Account();
				ac.setAccount_Id(rs.getString("ACCOUNT_ID"));
				ac.setFirst_Name(rs.getString("FIRST_NAME"));
				ac.setLast_Name(rs.getString("LAST_NAME"));
				ac.setEmail(rs.getString("EMAIL"));
				listAccount.add(ac);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return listAccount;

	}

	public Account getAccountDB1(String accountID) {
		Connection conn = null;
		PreparedStatement pstm = null;
		Account account = new Account();
		try {
			conn = ConnectionDB.openConnection();
			String sql = "SELECT ac.ACCOUNT_ID, ac.FIRST_NAME, ac.LAST_NAME, ac.EMAIL FROM ACCOUNT ac"
					+ "where ac.ACCOUNT_ID = ?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, accountID);
			ResultSet rs = pstm.executeQuery();

			if (rs.next()) {
				account.setAccount_Id(rs.getString("ACCOUNT_ID"));
				account.setFirst_Name(rs.getString("FIRST_NAME"));
				account.setLast_Name(rs.getString("LAST_NAME"));
				account.setEmail(rs.getString("EMAIL"));

			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return account;

	}
}
