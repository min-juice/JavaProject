package com.naver;

import java.util.Scanner;

public class DeleteCommand implements Command {

	@Override
	public void execute(Scanner sc) {
		System.out.println("ȸ�� ������ �����մϴ�.");

		System.out.println("������ id�� �Է����ּ���.");
		String id = sc.nextLine();

		userDTO dto = new userDTO(id, null, 0, 0);
		userDAO dao = new userDAO();
		dao.delete(dto);

	}

	@Override
	public String toString() {
		return "ȸ�� ����";
	}

}
