package com.naver;

import java.util.Scanner;

public class InsertCommand implements Command {

	@Override
	public void execute(Scanner sc) {
		System.out.println("ȸ�� ������ �����մϴ�.");

		System.out.println("id�� �Է����ּ���.");
		String id = sc.nextLine();

		System.out.println("�̸��� �Է����ּ���.");
		String name = sc.nextLine();

		userDTO dto = new userDTO(id, name, 0, 0);
		userDAO dao = new userDAO();
		dao.insert(dto);

	}

	@Override
	public String toString() {
		return "ȸ�� ����";
	}

}
