package day9;

public class sum {
	public static void main(String[] args) {
		int[][] arr = { { 101, 102, 103, 104 }, { 201, 202, 203, 204 }, { 301, 302, 303, 304 } };

		int[] garo = new int[3];
		int[] sero = new int[4];
		int sum = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 4; j++) {
				sum += arr[i][j];	
			}
			garo[i] = sum;
			System.out.println("sum" + (i + 1) + "=" + garo[i]);
			sum = 0;
		}
		System.out.println();
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 3; j++) {
				sum += arr[j][i];
			}
			sero[i] = sum;
			System.out.println("sum" + (i + 1) + "=" + sero[i]);
			sum=0;
		}
	}
}
