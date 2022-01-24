package day9;

import java.util.Scanner;

public class manage {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] apt = { { 101, 102, 103 }, { 201, 202, 203 }, { 301, 302, 303 } };
		int[][] pay = { { 1000, 2100, 1300 }, { 4100, 2000, 1000 }, { 3000, 1600, 800 } };
		
		// ���� 1
		System.out.println("���� 1) �� ���� ������ �� ���");
		int sum=0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				sum += pay[i][j];	
			}
			System.out.println((i + 1) + "��: " + sum);
			sum = 0;
		}
		System.out.println();
		
		// ���� 2
		System.out.println("���� 2) ȣ�� �Է��ϸ� ������ ���");
		System.out.println("ȣ�� �Է��Ͻÿ�:");
		int h=sc.nextInt();
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (apt[i][j] == h) {
					System.out.println(h+"ȣ�� ������� "+pay[i][j]+"���Դϴ�.");
				}
			}
		}
		System.out.println();
		
		// ���� 3
		System.out.println("���� 3) ������ ���� ���� ���� ��, ���� ���� �� ���");
		int max = 0, min=10000, idx1 = 0,idx2 = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (max < pay[i][j]) {
					max = pay[i][j];
					idx1 = i;
					idx2 = j;
				}
			}
		}
		System.out.println("���� ���� ���� ����Ʈ�� " + apt[idx1][idx2]+"ȣ �Դϴ�.");
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (min > pay[i][j]) {
					min = pay[i][j];
					idx1 = i;
					idx2 = j;
				}
			}
		}
		System.out.println("���� ���� ���� ����Ʈ�� " + apt[idx1][idx2]+"ȣ �Դϴ�.");
		System.out.println();
		
		// ���� 4
		System.out.println("���� 4) ȣ 2���� �Է��ϸ� ������ ��ü");
		int temp = 0, idx11 = 0, idx22 = 0;
		System.out.println("ù��° ����Ʈ�� �Է��Ͻÿ�:");
		int num1 = sc.nextInt();
		System.out.println("�ι�° ����Ʈ�� �Է��Ͻÿ�:");
		int num2 = sc.nextInt();
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (apt[i][j] == num1) {
					idx1 = i;
					idx2 = j;
				}
			}
		}
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (apt[i][j] == num2) {
					idx11 = i;
					idx22 = j;
				}
			}
		}
		temp = pay[idx1][idx2];
		pay[idx1][idx2] = pay[idx11][idx22];
		pay[idx11][idx22] = temp;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(pay[i][j] + " ");
			}
			System.out.println();
		}
		
	}
}
