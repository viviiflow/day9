package day9;

import java.util.Scanner;

public class shopping {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[][] items = new String[100][2];
		for (int i = 0; i < items.length; i++) {
			items[i][0] = "";
			items[i][1] = "";
		}
		int itmcnt = 0;

		while (true) {
			System.out.println("[������ ���]");
			System.out.println("[1]ī�װ� ����");
			System.out.println("[2]�� �� ��  ����");
			System.out.println("[3]��üǰ�� ���");
			System.out.println("[0]����");
			System.out.println("�޴� ����:");
			int slt = sc.nextInt();

			if (slt == 1) {
				if (itmcnt == 100) {
					System.out.println("�� �̻� �߰��� �� �����ϴ�.");
					continue;
				}
				System.out.println("�߰��� ī�װ� �Է�:");
				String ct = sc.next();
				items[itmcnt][0] = ct;
				itmcnt++;
			}
			if (slt == 2) {
				System.out.println("���� ī�װ� �Է�:");
				String ct = sc.next();
				for (int i = 0; i < 100; i++) {
					if (ct.equals(items[i][0])) {
						System.out.println("�߰��� ������ �Է�:");
						String itm = sc.next();
						items[i][1] += itm + "/";
						break;
					} else {
						System.out.println("�ش� ī�װ��� �������� �ʽ��ϴ�.");
						break;
					}
				}

			}
			if (slt == 3) {
				for (int i = 0; i < itmcnt; i++) {
					for (int j = 0; j < 2; j++) {
						System.out.print(items[i][j] + " ");
					}
					System.out.println();
				}

			}
			if (slt == 0) {
				System.out.println("���α׷��� �����մϴ�.");
				break;
			}

		}
	}
}
