package day9;

import java.util.Scanner;

public class manage {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] apt = { { 101, 102, 103 }, { 201, 202, 203 }, { 301, 302, 303 } };
		int[][] pay = { { 1000, 2100, 1300 }, { 4100, 2000, 1000 }, { 3000, 1600, 800 } };
		
		// 문제 1
		System.out.println("문제 1) 각 층별 관리비 합 출력");
		int sum=0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				sum += pay[i][j];	
			}
			System.out.println((i + 1) + "층: " + sum);
			sum = 0;
		}
		System.out.println();
		
		// 문제 2
		System.out.println("문제 2) 호를 입력하면 관리비 출력");
		System.out.println("호를 입력하시오:");
		int h=sc.nextInt();
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (apt[i][j] == h) {
					System.out.println(h+"호의 관리비는 "+pay[i][j]+"원입니다.");
				}
			}
		}
		System.out.println();
		
		// 문제 3
		System.out.println("문제 3) 관리비가 가장 많이 나온 집, 적게 나온 집 출력");
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
		System.out.println("가장 많이 나온 아파트는 " + apt[idx1][idx2]+"호 입니다.");
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (min > pay[i][j]) {
					min = pay[i][j];
					idx1 = i;
					idx2 = j;
				}
			}
		}
		System.out.println("가장 적게 나온 아파트는 " + apt[idx1][idx2]+"호 입니다.");
		System.out.println();
		
		// 문제 4
		System.out.println("문제 4) 호 2개를 입력하면 관리비 교체");
		int temp = 0, idx11 = 0, idx22 = 0;
		System.out.println("첫번째 아파트를 입력하시오:");
		int num1 = sc.nextInt();
		System.out.println("두번째 아파트를 입력하시오:");
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
