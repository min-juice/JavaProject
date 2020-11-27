package com.naver;

import java.util.Scanner;

public class UpdateCommand implements Command{

	@Override
	public void execute(Scanner sc) {
		System.out.println("ȸ�� �̸��� �����մϴ�.");
		
		System.out.println("���Ե� id�� �Է����ּ���.");
		String id = sc.nextLine();
		
		System.out.println("������ �̸��� �Է����ּ���.");
		String name = sc.nextLine();
		
		userDAO dao = new userDAO();
		userDTO dto = new userDTO(id, name, 0, 0);
		dao.update(dto);
		
	}

	@Override
	public String toString() {
		return "ȸ�� �̸� ����";
	}
	
}
