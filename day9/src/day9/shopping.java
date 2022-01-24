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
			System.out.println("[관리자 모드]");
			System.out.println("[1]카테고리 관리");
			System.out.println("[2]아 이 템  관리");
			System.out.println("[3]전체품목 출력");
			System.out.println("[0]종료");
			System.out.println("메뉴 선택:");
			int slt = sc.nextInt();

			if (slt == 1) {
				if (itmcnt == 100) {
					System.out.println("더 이상 추가할 수 없습니다.");
					continue;
				}
				System.out.println("추가할 카테고리 입력:");
				String ct = sc.next();
				items[itmcnt][0] = ct;
				itmcnt++;
			}
			if (slt == 2) {
				System.out.println("세부 카테고리 입력:");
				String ct = sc.next();
				for (int i = 0; i < 100; i++) {
					if (ct.equals(items[i][0])) {
						System.out.println("추가할 아이템 입력:");
						String itm = sc.next();
						items[i][1] += itm + "/";
						break;
					} else {
						System.out.println("해당 카테고리가 존재하지 않습니다.");
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
				System.out.println("프로그램을 종료합니다.");
				break;
			}

		}
	}
}
