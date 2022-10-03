package com.eeit48.webProject.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.eeit48.webProject.service.Account;

import com.eeit48.webProject.utils.*;

public class AccountDB extends DaoBase {

	//登入
			public List<Account> login(String at, String pd) {
				
				List<Account> accountList = new ArrayList<Account>();

				boolean result = false;

				Connection conn = null;
				PreparedStatement ptmt = null;
				ResultSet rs = null;

				try {
					// 1.加載驅動程序
					Class.forName("com.mysql.cj.jdbc.Driver");
					// 2. 獲得數據庫連接
					System.out.println("Connecting to database...");
					conn = DriverManager.getConnection(URL, USER, PASSWORD);
					// sql
					String selectsql = "SELECT * FROM account WHERE `account`=? AND `password`=?"; // 查詢
					//// 預編譯
					ptmt = conn.prepareStatement(selectsql);
					// 3.操作數據庫
					System.out.println("Creating statement...");
					// 查詢
					ptmt.setString(1, at);
					ptmt.setString(2, pd);
					rs = ptmt.executeQuery();
					// 如果有数据，rs.next()返回true
					while (rs.next()) {
						Account account = new Account();
						
						account.setAccount_id(rs.getString("account_id"));
						account.setAccount(rs.getString("account"));
						account.setPassword(rs.getString("password"));
						accountList.add(account);
//						if (BCrypt.checkpw(pd, hashPasswd)) {
//
//							account.setAccount_id(rs.getString("account_id"));
//							account.setAccount(rs.getString("account"));
//							account.setPassword(rs.getString("password"));
//
//						}
//
//						accountList.add(account);
						
					}
					// 資料庫關閉
					rs.close();
					ptmt.close();
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					try {
						if (ptmt != null)
							ptmt.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
					try {
						if (conn != null)
							conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}

				System.out.println("資料庫已關閉");

				return accountList;
			}
	
	
//	// 登入
//	public boolean login(String at, String pd) {
//
//		
//		boolean result = false;
//
//		Connection conn = null;
//		PreparedStatement ptmt = null;
//		ResultSet rs = null;
//
//		try {
//			// 1.加載驅動程序
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			// 2. 獲得數據庫連接
//			System.out.println("Connecting to database...");
//			conn = DriverManager.getConnection(URL, USER, PASSWORD);
//			// sql
//			String selectsql = "SELECT * FROM account"; // 查詢
//			//// 預編譯
//			ptmt = conn.prepareStatement(selectsql);
//			// 3.操作數據庫
//			System.out.println("Creating statement...");
//			// 查詢
//			rs = ptmt.executeQuery();
//			// 如果有数据，rs.next()返回true
////			System.out.println(rs.next());
//			while (rs.next()) {
//				Account account = new Account();
//				
//				account.setAccount_id(rs.getString("account_id"));
//				account.setAccount(rs.getString("account"));
//				account.setPassword(rs.getString("password"));
//				System.out.println(
//						rs.getString("account_id") + " " + rs.getString("account") + " " + rs.getString("password"));
//				
//				
//				if (rs.getString("account").equals(at) && rs.getString("password").equals(pd)) {
//
//					result = true;
//					System.out.println("ooo");
//				}else {
//					System.out.println("xxx");
//				}
//
//			}
//			// 資料庫關閉
//			rs.close();
//			ptmt.close();
//			conn.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if (ptmt != null)
//					ptmt.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//			try {
//				if (conn != null)
//					conn.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//
//		System.out.println("資料庫已關閉");
//
//		return result;
//	}
	
	
	// 增加
		public void Insert(Account account) throws Exception {

			Connection conn = null;
			PreparedStatement ptmt = null;
			ResultSet rs = null;

			try {
				// 1.加載驅動程序
				Class.forName("com.mysql.cj.jdbc.Driver");
				// 2. 獲得數據庫連接
				System.out.println("Connecting to database...");
				conn = DriverManager.getConnection(URL, USER, PASSWORD);
				// sql
				String insertsql = "INSERT INTO account (account, password, realname) values (?,?,?)"; // 增加
				//// 預編譯
				ptmt = conn.prepareStatement(insertsql);
				// 3.操作數據庫
				System.out.println("Creating statement...");
				// 增加
				String passwd = account.getPassword();
				ptmt.setString(1, account.getAccount());
				ptmt.setString(2, account.getPassword());
//				ptmt.setString(2, BCrypt.hashpw(passwd, BCrypt.gensalt()));
				ptmt.setString(3, account.getRealname());
				
				ptmt.executeUpdate();
				// 資料庫關閉
				ptmt.close();
				conn.close();

			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (ptmt != null)
						ptmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				try {
					if (conn != null)
						conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			System.out.println("資料庫已關閉");

		}
	
	
	
		
		
		
		
		
//		public static Account login(String account, String password, Connection conn) throws SQLException {
//		String sql = "SELECT * FROM account WHERE account=? ";
//		PreparedStatement ps = conn.prepareStatement(sql);
//		ps.setString(1, account);
//		ResultSet rs = ps.executeQuery();
//		if (rs.next()) {
//			String hashPasswd = rs.getString("password");
//			if (BCrypt.checkpw(password,hashPasswd)) {
//				Account acct = new Account(rs.getString("account_id"),
//						rs.getString("account"), rs.getString("realname"), hashPasswd);
//				return acct;
//			} else {
//				return null;
//			}
//		} else {
//			return null;
//		}
//	}
	
		

}
