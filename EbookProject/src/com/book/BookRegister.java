package com.book;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.naming.ldap.ManageReferralControl;


public class BookRegister {
	private static final long bookCode = 0;
	private static final String bookName = null;
	private static final String point = null;
	
	
	List<ShowAllBook> bookinfo = new ArrayList<ShowAllBook>();
	ShowAllBook list = new ShowAllBook(bookCode, bookName, point);
	
	public void setlist() {
		
		bookinfo.add(1, new ShowAllBook(001, "�޷���Ʈ �� ��ȭ��", "100 ����Ʈ����"));
		bookinfo.add(2, new ShowAllBook(002, "����Ī �ܼ�" , "200 ����Ʈ����"));
		bookinfo.add(3, new ShowAllBook(003, "����ì���� ��" , "100 ����Ʈ����"));
		bookinfo.add(4, new ShowAllBook(004, "�Ƹ��", "150 ����Ʈ����"));
		bookinfo.add(5, new ShowAllBook(005, "�λ��� �Ҽ��̴�", "100 ����Ʈ����"));
	}
	
	public void print() {
		System.out.println("�ٿ�ε� ������ å�� ��� �Դϴ�.");
		
	}
		
	
	
	public void getlist() {
		System.out.println("Code/ name/ point");
		System.out.println("------------------");
		for(ShowAllBook book : bookinfo) {
			System.out.println(book.toString());
		}
	}
}
