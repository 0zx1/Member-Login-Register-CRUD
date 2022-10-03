package com.eeit48.webProject.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.eeit48.webProject.service.Member;

public class MemberDB extends DaoBase {

	// 查詢
	public List<Member> Select() throws Exception {
		List<Member> memberList = new ArrayList<Member>();

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
			String selectsql = "SELECT * FROM member"; // 查詢
			//// 預編譯
			ptmt = conn.prepareStatement(selectsql);
			// 3.操作數據庫
			System.out.println("Creating statement...");
			// 查詢
			rs = ptmt.executeQuery();
			// 如果有数据，rs.next()返回true
			while (rs.next()) {
				Member member = new Member();
				member.setMember_id(rs.getString("member_id"));
				member.setUser_name(rs.getString("user_name"));
				member.setPassword(rs.getString("password"));
				member.setEmail(rs.getString("email"));
				member.setTel(rs.getString("tel"));
				member.setAddr(rs.getString("addr"));
//				member.setbirthday(rs.getString("birthday"));

				memberList.add(member);
				System.out.println(rs.getString("member_id") + " " + rs.getString("user_name") + " "
						+ rs.getString("password") + " " + rs.getString("email") + " " 
						+ rs.getString("tel") + " " + rs.getString("addr"));
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
			try {
				if (conn != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		System.out.println("資料庫已關閉");

		return memberList;

	}

	// 增加
	public void Insert(Member member) throws Exception {

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
			String insertsql = "INSERT INTO member (user_name, password, email,  tel, addr) values (?,?,?,?,?)"; // 增加
			//// 預編譯
			ptmt = conn.prepareStatement(insertsql);
			// 3.操作數據庫
			System.out.println("Creating statement...");
			// 增加
			
			ptmt.setString(1, member.getUser_name());
			ptmt.setString(2, member.getPassword());
			ptmt.setString(3, member.getEmail());
			ptmt.setString(4, member.getTel());
			ptmt.setString(5, member.getAddr());
//			ptmt.setString(6, member.getbirthday());
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

	// 刪除
	public void Delete(Member member) throws Exception {

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
			String deletesql = "DELETE FROM member where member_id=?"; // 刪除
			// 預編譯
			ptmt = conn.prepareStatement(deletesql);
			// 3.操作數據庫
			System.out.println("Creating statement...");
			// 刪除
			ptmt.setString(1, member.getMember_id());
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

	// 修改
	public void Update(Member member) throws Exception {

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
			String updatesql = "UPDATE member SET user_name=?, password=?, email=?,  tel=?, addr=? WHERE member_id=?"; // 更改
			//// 預編譯
			ptmt = conn.prepareStatement(updatesql);
			// 3.操作數據庫
			System.out.println("Creating statement...");
			// 更改
			ptmt.setString(1, member.getUser_name());
			ptmt.setString(2, member.getPassword());
			ptmt.setString(3, member.getEmail());
			ptmt.setString(4, member.getTel());
			ptmt.setString(5, member.getAddr());
			ptmt.setString(6, member.getMember_id());
//			ptmt.setString(7, member.getbirthday());
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

	// 登入
	public boolean login(String username, String pd) {

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
			String selectsql = "SELECT * FROM member"; // 查詢
			//// 預編譯
			ptmt = conn.prepareStatement(selectsql);
			// 3.操作數據庫
			System.out.println("Creating statement...");
			// 查詢
			rs = ptmt.executeQuery();
			// 如果有数据，rs.next()返回true
			System.out.println(rs);
			while (rs.next()) {
				Member member = new Member();
				member.setMember_id(rs.getString("member_id"));
				member.setUser_name(rs.getString("user_name"));
				member.setPassword(rs.getString("password"));
				System.out.println(
						rs.getString("member_id") + " " + rs.getString("user_name") + " " + rs.getString("password"));

				if (rs.getString("user_name").equals(username) && rs.getString("password").equals(pd)) {

					result = true;
				}

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

		return result;
	}

}
