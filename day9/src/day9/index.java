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

		// 문제 1
		System.out.println("문제 1)인덱스 2개를 입력받아 값 출력");
		System.out.println("인덱스1 입력:");
		int idx1 = sc.nextInt();
		System.out.println("인덱스2 입력:");
		int idx2 = sc.nextInt();
		System.out.println(arr[idx1][idx2]);
		System.out.println();

		// 문제 2
		System.out.println("문제 2)값을 입력받아 인덱스 2개 출력");
		System.out.println("값 입력:");
		int num = sc.nextInt();
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (arr[i][j] == num) {
					System.out.println("인덱스1 출력: " + i);
					System.out.println("인덱스2 출력: " + j);
				}
			}
		}
		System.out.println();

		// 문제 3
		System.out.println("문제 3)가장 큰 값의 인덱스 2개 출력");
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
		System.out.println("가장 큰 인덱스1: " + idx1);
		System.out.println("가장 큰 인덱스2: " + idx2);
		System.out.println();

		// 문제 4
		System.out.println("문제 4)값 2개를 입력받아 값 교체");
		int temp = 0, idx11 = 0, idx22 = 0;
		System.out.println("첫번째 값을 입력하시오:");
		int num1 = sc.nextInt();
		System.out.println("두번째 값을 입력하시오:");
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
