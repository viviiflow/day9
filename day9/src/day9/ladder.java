package day9;

import java.util.Scanner;

public class ladder {
	public static void main(String[] args) {
		//코드 분석해보기
		Scanner sc = new Scanner(System.in);
		int ladder[][] = { { 0, 0, 0, 0, 0 }, { 1, 1, 0, 1, 1 }, { 0, 1, 1, 0, 0 }, { 0, 0, 1, 1, 0 },
				{ 1, 1, 0, 0, 0 }, { 0, 1, 1, 0, 0 }, { 1, 1, 0, 0, 0 }, { 0, 0, 0, 1, 1 }, { 0, 0, 0, 0, 0 } };

		int x = 0;
		int y = 0;

		System.out.println(" 0  1  2  3  4");
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 5; j++) {
				if (ladder[i][j] == 0) {
					System.out.print(" │ ");
				} else if (ladder[i][j] == 1) {
					if (j != 0 && ladder[i][j - 1] == 1) {
						System.out.print("─┤ ");
					} else if (j != 5 && ladder[i][j + 1] == 1) {
						System.out.print(" ├─");
					}
				}
			}
			System.out.println();
		}
		System.out.println();
		System.out.println("[0]~[4] 입력하여라");
		x = sc.nextInt();

		for (int i = 0; i < 9; i++) {
			if (ladder[y][x] == 0) {
				y++;
			} else if (ladder[y][x] == 1) {
				if (x != 0 && ladder[y][x - 1] == 1) {
					x--;
				} else if (x != 5 && ladder[y][x + 1] == 1) {
					x++;
				}
				y++;
			}
		}

		System.out.println(x);
	}
}
