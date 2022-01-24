package day9;

import java.util.Scanner;

public class index {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] arr = new int[3][3];

		int k = 1;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				arr[i][j] = 10 * k;
				k++;
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();

		// ���� 1
		System.out.println("���� 1)�ε��� 2���� �Է¹޾� �� ���");
		System.out.println("�ε���1 �Է�:");
		int idx1 = sc.nextInt();
		System.out.println("�ε���2 �Է�:");
		int idx2 = sc.nextInt();
		System.out.println(arr[idx1][idx2]);
		System.out.println();

		// ���� 2
		System.out.println("���� 2)���� �Է¹޾� �ε��� 2�� ���");
		System.out.println("�� �Է�:");
		int num = sc.nextInt();
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (arr[i][j] == num) {
					System.out.println("�ε���1 ���: " + i);
					System.out.println("�ε���2 ���: " + j);
				}
			}
		}
		System.out.println();

		// ���� 3
		System.out.println("���� 3)���� ū ���� �ε��� 2�� ���");
		int max = 0;
		idx1 = 0;
		idx2 = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (max < arr[i][j]) {
					max = arr[i][j];
					idx1 = i;
					idx2 = j;
				}
			}
		}
		System.out.println("���� ū �ε���1: " + idx1);
		System.out.println("���� ū �ε���2: " + idx2);
		System.out.println();

		// ���� 4
		System.out.println("���� 4)�� 2���� �Է¹޾� �� ��ü");
		int temp = 0, idx11 = 0, idx22 = 0;
		System.out.println("ù��° ���� �Է��Ͻÿ�:");
		int num1 = sc.nextInt();
		System.out.println("�ι�° ���� �Է��Ͻÿ�:");
		int num2 = sc.nextInt();
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (arr[i][j] == num1) {
					idx1 = i;
					idx2 = j;
				}
			}
		}
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (arr[i][j] == num2) {
					idx11 = i;
					idx22 = j;
				}
			}
		}
		temp = arr[idx1][idx2];
		arr[idx1][idx2] = arr[idx11][idx22];
		arr[idx11][idx22] = temp;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(arr[i][j] + " ");
			}
		}

	}
}
