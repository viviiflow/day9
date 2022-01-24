package day9;

import java.util.Scanner;

public class ATM_cmt {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int max = 5;

		int[] arID = new int[max];
		int[] arPW = new int[max];
		int[] arMONEY = new int[max];

		int count = 0, log = -1;
		int nid = 100;

		String menu = "=== 메가IT ATM ===\n";
		menu += "1. 회원가입\n2. 회원탈퇴\n3. 로그인\n4. 로그아웃\n";
		menu += "5. 입금\n6. 이체\n7. 잔액조회\n0. 종료"; // 메뉴 출력

		while (true) {
			System.out.println(menu);
			System.out.println("");
			System.out.println("메뉴 선택:");
			int slt = sc.nextInt();
			if (slt == 0) { // 0 입력시 종료
				System.out.println("ATM 종료");
				break;
			}
			if (slt == 1) { // 1 입력시 회원가입
				System.out.println("<회원가입>");
				if (count == 5) { // count 수가 5가 되면 가입 불가능
					System.out.println("가입 인원 초과. 가입 불가능");
					continue;
				}
				while (true) {
					System.out.println("ID 입력:");
					int id = sc.nextInt();
					for (int i = 0; i < 5; i++) {
						if (arID[i] == id) { // 입력된 아이디와 저장된 아이디가 같을 경우 중복 처리
							System.out.println("중복된 아이디입니다.");
							break;
						} else if (arID[i] == 0) { // 중복 아이디가 없을 경우 0 위치(빈자리)에 저장
							arID[i] = id;
							arMONEY[i] += 1000; // 가입금 1000원 부여 후 count 증가
							count++;
							break;
						}
					}
					if (arID[count - 1] != 0) { // 아이디가 채워졌으면 반복문 종료
						break;
					}
				}
				while (true) {
					System.out.println("PW 입력:");
					int pw = sc.nextInt();
					if (pw != 0) { // 0이 아닐 경우 사용 가능
						arPW[count - 1] = pw;
						break;
					} else {
						System.out.println("사용 불가한 패스워드");
					}
				}
			}
			if (slt == 2 && log == 1) { // 2 선택, 로그인 시 회원탈퇴 가능
				System.out.println("<회원탈퇴>");
				while (true) {
					int chkid = 100, chkpw = 1000;
					System.out.println("ID 입력:");
					int logid = sc.nextInt();
					System.out.println("PW 입력:");
					int logpw = sc.nextInt();
					for (int i = 0; i < 5; i++) {
						if (arID[i] == logid) { // 저장된 아이디와 입력 받은 아이디가 동일할 경우 위치 기억
							chkid = i;
						}
					}
					for (int j = 0; j < 5; j++) {
						if (arPW[j] == logpw) { // 아이디와 동일
							chkpw = j;
						}
					}
					if ((chkid == chkpw) && (chkid == nid)) { // 아이디와 패스워드의 위치, 기억된 아이디와 현재 로그인된 아이디의 위치가 같을 경우 탈퇴 처리
						arID[chkid] = 0;
						arPW[chkpw] = 0;
						log = -1;
					} else { // 아닐 경우 메시지 띄움
						System.out.println("아이디 또는 패스워드가 틀립니다.");
						log = 1;
					}
					if (log == -1) { // 탈퇴 처리가 되었을 경우
						for (int x = nid; x < arID.length - 1; x++) { // 아이디와 패스워드, 계좌 재정렬
							arID[x] = arID[x + 1];
							arPW[x] = arPW[x + 1];
							arMONEY[x] = arMONEY[x + 1];
						}
						arID[4] = 0; // 인덱스 터짐 방지로 마지막 인덱스는 따로 지워줌
						arMONEY[4] = 0;
						arPW[4] = 0;
						System.out.println("회원탈퇴가 완료되었습니다.");
						count--; // 회원 탈퇴 후 count 감소
						break;
					}
				}
			} else if (slt == 2 && log == -1) { // 로그아웃 상태에서 2 입력 시 탈퇴 불가
				System.out.println("로그인 후 이용하여 주시길 바랍니다.");
			}
			if (slt == 3 && log == -1) { // 3 입력, 로그아웃 상태일 떄 로그인 가능
				System.out.println("<로그인>");
				while (true) {
					int chkid = 100, chkpw = 1000;
					System.out.println("ID 입력:");
					int logid = sc.nextInt();
					System.out.println("PW 입력:");
					int logpw = sc.nextInt();
					for (int i = 0; i < 5; i++) { // 저장된 아이디와 입력 받은 아이디가 동일할 경우 위치 기억
						if (arID[i] == logid) {
							chkid = i;
						}
					}
					for (int j = 0; j < 5; j++) {
						if ((arPW[j] == logpw) && (j == chkid)) { // 입력 받은 패스워드와 저장된 패스워드가 같고, 그 위치가 아이디와 같을 때 위치 기억
							chkpw = j;
						}
					}
					if (chkid == chkpw) { // 아이디와 패스워드의 위치가 같을 경우 로그인
						nid = chkid; // 현재 로그인된 아이디 위치 기억
						log = 1;
					} else { // 아닐 경우 로그인 실패 메시지
						System.out.println("아이디 또는 패스워드가 틀립니다.");
						log = -1;
					}
					if (log == 1) { // 로그인 되었으면 로그인 성공 메시지
						System.out.println("로그인 되었습니다.");
						break;
					}
				}
			} else if (slt == 3 && log == 1) { // 로그인 상태에서 3 입력 시 로그인 불가
				System.out.println("현재 로그인 상태 입니다.");
			}
			if (slt == 4 && log == 1) { // 4 입력, 로그인 상태일 떄 로그아웃 가능
				while (true) {
					int chkid = 100, chkpw = 1000;
					System.out.println("ID 입력:");
					int logid = sc.nextInt();
					System.out.println("PW 입력:");
					int logpw = sc.nextInt();
					for (int i = 0; i < 5; i++) {
						if (arID[i] == logid) { // 저장된 아이디와 입력 받은 아이디가 동일할 경우 위치 기억
							chkid = i;
						}
					}
					for (int j = 0; j < 5; j++) {
						if ((arPW[j] == logpw) && (j == chkid)) { // 입력 받은 패스워드와 저장된 패스워드가 같고, 그 위치가 아이디와 같을 때 위치 기억
							chkpw = j;
						}
					}
					if ((chkid == chkpw) && (chkid == nid)) { // 아이디와 패스워드의 위치가 같고, 기억된 아이디와 현재 로그인된 아이디의 위치가 같을 경우 로그아웃
						log = -1;
					} else { // 아닐 경우 로그아웃 실패 메시지
						System.out.println("아이디 또는 패스워드가 틀립니다.");
						log = 1;
					}
					if (log == -1) {
						nid = 100; // 로그아웃 되었으면 로그아웃 성공 메시지, 현재 아이디 위치 초기화
						System.out.println("로그아웃 되었습니다.");
						break;
					}
				}
			} else if (slt == 4 && log == -1) { // 로그아웃 상태에서 4 입력 시 로그아웃 불가
				System.out.println("로그인 후 이용하여 주시길 바랍니다.");
			}

			if (slt == 5 && log == 1) { // 5 입력, 로그인 상태일 떄 입금 가능
				System.out.println("<입금>");
				while (true) {
					int chkpw = 100;
					System.out.println("확인 패스워드 입력:");
					int logpw = sc.nextInt();

					for (int i = 0; i < 5; i++) { // 입력 받은 패스워드와 저장된 패스워드가 같고, 그 위치가 현재 로그인된 아이디의 위치와 같을 때 위치 기억
						if ((arPW[i] == logpw) && (nid == i)) {
							chkpw = i;
						}
					}
					if (chkpw == 100) { // 패스워드의 위치가 초기화 값에서 변함 없을 시 다시 입력
						System.out.println("패스워드를 다시 입력하여 주세요.");
					} else {
						System.out.println("입금할 금액 입력:"); // 아닐 경우 입금 처리
						int logmn = sc.nextInt();
						arMONEY[chkpw] += logmn;
						System.out.println(logmn + "원 입금되었습니다.");
						break;
					}
				}
			} else if (slt == 5 && log == -1) { // 로그아웃 상태에서 5 입력 시 입금 불가
				System.out.println("로그인 후 이용하여 주시길 바랍니다.");
			}
			if (slt == 6 && log == 1) { // 6 입력, 로그인 상태일 떄 이체 가능
				System.out.println("<이체>");
				while (true) {
					int chkpw = 100, chk = -1;
					System.out.println("확인 패스워드 입력:");
					int logpw = sc.nextInt();
					for (int i = 0; i < 5; i++) { // 입력 받은 패스워드와 저장된 패스워드가 같고, 그 위치가 현재 로그인된 아이디의 위치와 같을 때 위치 기억
						if ((arPW[i] == logpw) && (nid == i)) {
							chkpw = i;
						}
					}
					if (chkpw == 100) { // 패스워드의 위치가 초기화 값에서 변함 없을 시 다시 입력
						System.out.println("패스워드를 다시 입력하여 주세요.");
						chk = -1;
						continue;
					} else { // 아닐 경우 chk 값 1로 바꿈
						chk = 1;
					}
					if (chk == 1) { // chk 값이 1일 떄 이체 가능
						while (chk != 2) { // chk 값이 2가 되지 않을 떄 까지(이체가 완료되지 않을 떄 까지) 반복
							int sndid = 100;
							System.out.println("받는 사람 ID 입력:");
							int logid2 = sc.nextInt();
							for (int n = 0; n < 5; n++) { // 저장된 아이디와 입력 받은 아이디(받는 사람 아이디)가 동일할 경우 위치 기억
								if (arID[n] == logid2) {
									sndid = n;
								}
							}
							if ((sndid == 100) || (sndid == nid)) { // sndid 값이 변함 없거나, 받는 사람 아이디가 본인 아이디일 경우 다시 입력
								System.out.println("아이디를 다시 입력하여 주세요.");
								continue;
							} else { // 아닐 경우 금액 입력
								while (true) {
									System.out.println("이체할 금액 입력:");
									int logmn = sc.nextInt();
									if (arMONEY[nid] >= logmn) { // 이체 금액이 통장 잔고보다 많거나 같을 경우 이체 가능
										arMONEY[nid] -= logmn;
										arMONEY[sndid] += logmn;
										System.out.println(logid2 + "님의 통장으로 " + logmn + "원 이체되었습니다.");
										chk = 2; // 이체 완료 표시
										break;
									} else { // 잔고 초과 시 금액 다시 입력
										System.out.println("잔고 초과");
									}
								}
							}
						}
					}
					if (chk == 2) {	//이체 완료 시 종료
						break;
					}
				}
			} else if (slt == 6 && log == -1) { // 로그아웃 상태에서 6 입력 시 이체 불가
				System.out.println("로그인 후 이용하여 주시길 바랍니다.");
			}
			if (slt == 7 && log == 1) {	// 7 입력, 로그인 상태일 떄 잔액조회 가능
				System.out.println("<잔액조회>");
				while (true) {
					int chkpw = 100;
					System.out.println("확인 패스워드 입력:");
					int logpw = sc.nextInt();
					for (int i = 0; i < 5; i++) {	// 입력 받은 패스워드와 저장된 패스워드가 같고, 그 위치가 현재 로그인된 아이디의 위치와 같을 때 위치 기억
						if ((arPW[i] == logpw) && (nid == i)) {
							chkpw = i;
						}
					}
					if (chkpw == 100) {	 // 패스워드의 위치가 초기화 값에서 변함 없을 시 다시 입력
						System.out.println("패스워드를 다시 입력하여 주세요.");
					} else {	//아닐 경우 잔고 확인 메시지
						System.out.println(arID[nid] + "님의 통장 잔고: " + arMONEY[nid] + "원");
						break;
					}
				}
			} else if (slt == 7 && log == -1) {	// 로그아웃 상태에서 7 입력 시 잔액조회 불가
				System.out.println("로그인 후 이용하여 주시길 바랍니다.");
			}
		}
	}
}
