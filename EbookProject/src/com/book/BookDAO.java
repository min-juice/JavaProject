package com.book;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.naver.MemberDTO;

public class BookDAO {
	private final String DRIVER = "oracle.jdbc.OracleDriver";
	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String USER_NAME = "ezen";
	private final String PASSWORD = "ezen";
	
	public BookDAO() {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			System.out.println("Ebook �۵� ����");
			e.printStackTrace();
		}	
		}
	
	public void closeAll(ResultSet rs, PreparedStatement pstmt, Connection conn) {
		
		try {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void insert(BookDTO bdto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO ebookList (bookName, bookCode, price, point) VALUES (?, ?, ?, ?)";
		boolean isOk = false;
		
		try {
			conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(sql); 
			
			pstmt.setString(1, bdto.getBookName());
			pstmt.setInt(2, bdto.getBookCode());
			pstmt.setInt(3, bdto.getPrice());
			pstmt.setInt(4, bdto.getPoint());
			
			pstmt.executeUpdate();
			
			isOk = true;
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (isOk) {
					conn.commit();
				} else {
					conn.rollback();
				}
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			closeAll(null, pstmt, conn);
			
		}
	}
	
	public void update(BookDTO bdto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE ebookList SET bookName =? price =? point =? WHERE bookCode =?";
		String sql2 = "UPDATE ebookList SET bookName =? point =? FROM ebookMember WHERE id =?";
		
		// MemberDTO dto = new MemberDTO(id, name, cash, point, books);
		
		boolean isOk = false;
		
		try {
			conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, bdto.getBookName());
			pstmt.setInt(2, bdto.getPrice());
			pstmt.setInt(3, bdto.getPoint());
			pstmt.setInt(4, bdto.getBookCode());
			
			pstmt.executeUpdate();
			isOk = true;
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (isOk) {
					conn.commit();
				} else {
					conn.rollback();
				}
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			closeAll(null, pstmt, conn);
			
		}
				
	}
	public void delete(BookDTO bdto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM bookList borrowing =? returning =? WHERE bookCode =?";
		boolean isOk = false;
		
		try {
			conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, bdto.getborrowing());
			pstmt.setString(2, bdto.getReturning());
			pstmt.setInt(3, bdto.getBookCode());
			
			pstmt.executeUpdate();
			isOk = true;
			
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (isOk) {
					conn.commit();
				} else {
					conn.rollback();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			closeAll(null, pstmt, conn);
		}
	}
	
	public List<BookDTO> select() {
		
	
	List<BookDTO> list = new ArrayList<BookDTO>();
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	String sql = "SELECT bookName å�̸�, bookCode å�ڵ�, price å����, point ����Ʈ,"
			+ " borrowing �뿩���, returning �ݳ���� FROM ebookList";
	ResultSet rs = null;
	
	boolean isOk = false;
	
	try {
		conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
		conn.setAutoCommit(false);
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();

		while (rs.next()) {
			String bookName = rs.getString("å�̸�");
			int bookCode = rs.getInt("å�ڵ�");
			int price = rs.getInt("å����");
			int point = rs.getInt("����Ʈ");
			String borrowing = rs.getString("�뿩���");
			String returning = rs.getString("�ݳ����");
			
			BookDTO bdto = new BookDTO(bookName, bookCode, price, point, borrowing, returning);
			list.add(bdto);

			isOk = true;
		}
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		try {
			if (isOk) {
				conn.commit();
			} else {
				conn.rollback();
			}
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		closeAll(rs, pstmt, conn);
	}
	
	return list;
	}
}
