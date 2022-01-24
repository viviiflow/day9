package day9;

public class number {
	public static void main(String[] args) {
		int[][] arr = new int[3][3];

		int k = 1;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				arr[i][j] = 10 * k;
				k++;
				System.out.print(arr[i][j] + " ");
			}
		}
		System.out.println();

		// 巩力 1
		int sum = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				sum += arr[i][j];
			}
		}
		System.out.println("sum = " + sum);

		// 巩力 2
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (arr[i][j] % 4 == 0) {
					System.out.print(arr[i][j] + " ");
				}
			}
		}
		System.out.println();

		// 巩力 3
		sum = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (arr[i][j] % 4 == 0) {
					sum += arr[i][j];
				}
			}
		}
		System.out.println("sum = " + sum);

		// 巩力 4
		int cnt = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (arr[i][j] % 4 == 0) {
					cnt++;
				}
			}
		}
		System.out.println("count = " + cnt);
	}
}
