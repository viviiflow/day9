package day9;

import java.util.Scanner;

public class delete {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[][] jang = { { "철수", "소고기" }, { "철수", "김밥" }, { "영희", "김치" }, { "철수", "바나나" }, { "철수", "새우깡" },
				{ "영희", "오징어" }, { "영희", "맛밤" }, };
		int cnt = 0;
		while (cnt < 7) {
			for (int i = 0; i < 7; i++) {
				if("".equals(jang[i][0])) {
					System.out.print("");
				}else {
					System.out.println(jang[i][0] + " : " + jang[i][1]);
				}
			}
			System.out.println("[삭제]이름을 입력하세요:");
			String name = sc.next();
			System.out.println("[삭제]번호를 입력하세요:");
			int idx = sc.nextInt();

			
			if (name.equals(jang[idx][0])) {
				for (int i = idx; i < jang.length - 1; i++) {
					jang[i][0] = jang[i + 1][0];
					jang[i][1] = jang[i + 1][1];
				}
				System.out.println("delete: " + idx);
				jang[6][0] = "";
				jang[6][1] = "";
				cnt++;
			} else {
				System.out.println("이름 혹은 인덱스의 번호가 맞지 않습니다.");
			}
		}
		System.out.println("삭제 완료");
	}
}
