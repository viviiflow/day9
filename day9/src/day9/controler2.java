package day9;

import java.util.Scanner;

public class controler2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = 5;
		int[] arr = new int[size];
		int cnt = 0;

		while (true) {
			System.out.println("=============");
			for (int i = 0; i < arr.length; i++) {
				/*
				 * if (arr[i] == 0) { continue; } else {
				 */
				System.out.print(arr[i] + " ");
			}
			// }
			System.out.println();
			String menu = "=============\n";
			menu += "[���� ��Ʈ�ѷ�]\n[1]�߰�\n[2]����(�ε���)\n[3]����(��)\n[4]����\n[0]����\n";
			menu += "�޴� ����:";
			System.out.println(menu);
			int slt = sc.nextInt();

			if (slt == 0) {
				System.out.println("��Ʈ�ѷ� ���α׷��� �����մϴ�.");
				break;
			}
			if (slt == 1) {
				if (cnt >= 5) {
					System.out.println("�� �̻� �߰��� �� �����ϴ�.");
					continue;
				} else {
					System.out.println("���� �Է�:");
					int score = sc.nextInt();
					for (int i = 0; i < 5; i++) {
						if (arr[i] == 0) {
							arr[i] = score;
							cnt++;
							break;
						}
					}
				}
			}
			if (slt == 2) {
				System.out.println("�ε��� �Է�:");
				int idx = sc.nextInt();
				for (int i = 0; i < 5; i++) {
					if (i == idx) {
						arr[i] = 0;
						cnt--;
						for (int j = i; j < 4; j++) {
							arr[j] = arr[j + 1];
						}
						arr[4] = 0;
						break;
					}
				}
			}
			if (slt == 3) {
				System.out.println("�� �Է�:");
				int score = sc.nextInt();
				int temp = cnt;
				for (int i = 0; i < 5; i++) {
					if (arr[i] == score) {
						arr[i] = 0;
						cnt--;
						for (int j = i; j < 4; j++) {
							arr[j] = arr[j + 1];
						}
						arr[4] = 0;
						break;
					}
				}
				if (temp == cnt) {
					System.out.println("�ش� ���� �������� �ʽ��ϴ�.");
				}
			}
			if (slt == 4) {
				if (cnt >= 5) {
					int[] t = new int[size + 1];
					for (int i = 0; i < size; i++) {
						t[i] = arr[i];
					}
					size += 1;
					arr = new int[size];
					for (int i = 0; i < t.length; i++) {
						arr[i] = t[i];
					}
				}
				System.out.println("�� �Է�:");
				int score = sc.nextInt();
				System.out.println("��ġ �Է�:");
				int idx = sc.nextInt();
				for (int i = arr.length - 2; i >= idx; i--) {
					arr[i + 1] = arr[i];
				}
				arr[idx] = score;
			}
		}
	}
}
