package com.book;

import java.util.Scanner;

import com.naver.Command;

public class BorrowBook implements Command {

	@Override
	public void execute(Scanner sc) {
		
		System.out.println("���̵� �Է��ϼ���");
		String id = sc.nextLine();
		
		System.out.println("�뿩 �� å�� �Է��ϼ���.");
		
		
	}

	@Override
	public String toString() {
		return "���� �뿩";
	}
	
	

}
