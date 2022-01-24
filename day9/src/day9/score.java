package day9;

public class score {
	public static void main(String[] args) {
		String[] name = { "È«±æµ¿", "±è¿µ", "ÀÚ¹ÙÅ·", "¹Îº´Ã¶", "¸Þ°¡¸Ç" };
		int[] score = { 87, 42, 100, 11, 98 };
		int temp = 0, max = 0, idx = 0;
		String nt = "", nm = "";

		while (idx < 5) {
			temp = score[idx];
			nt = name[idx];
			max = 0;
			for (int i = idx; i < 5; i++) {
				if (max < score[i]) {
					max = score[i];
					nm = name[i];
				}
			}
			for (int i = idx; i < 5; i++) {
				if (max == score[i]) {
					score[i] = temp;
					name[i] = nt;
				}
			}
			score[idx] = max;
			name[idx] = nm;
			System.out.println(name[idx] + " " + score[idx]);
			idx++;
		}
	}
}
