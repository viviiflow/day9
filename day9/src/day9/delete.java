package day9;

import java.util.Scanner;

public class delete {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[][] jang = { { "ö��", "�Ұ��" }, { "ö��", "���" }, { "����", "��ġ" }, { "ö��", "�ٳ���" }, { "ö��", "�����" },
				{ "����", "��¡��" }, { "����", "����" }, };
		int cnt = 0;
		while (cnt < 7) {
			for (int i = 0; i < 7; i++) {
				if("".equals(jang[i][0])) {
					System.out.print("");
				}else {
					System.out.println(jang[i][0] + " : " + jang[i][1]);
				}
			}
			System.out.println("[����]�̸��� �Է��ϼ���:");
			String name = sc.next();
			System.out.println("[����]��ȣ�� �Է��ϼ���:");
			int idx = sc.nextInt();

			
			if (name.equals(jang[idx][0])) {
				for (int i = idx; i < jang.length - 1; i++) {
					jang[i][0] = jang[i + 1][0];
					jang[i][1] = jang[i + 1][1];
				}
				System.out.println("delete: " + idx);
				jang[6][0] = "";
				jang[6][1] = "";
				cnt++;
			} else {
				System.out.println("�̸� Ȥ�� �ε����� ��ȣ�� ���� �ʽ��ϴ�.");
			}
		}
		System.out.println("���� �Ϸ�");
	}
}
