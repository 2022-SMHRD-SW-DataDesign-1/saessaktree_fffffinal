package view;

import java.util.Scanner;

import controller.Ending;
import controller.Front;
import controller.Question;
import controller.Question_10s;
import controller.Question_20s;
import controller.User;
import controller.wolf;
import javazoom.jl.player.MP3Player;

public class Main {

	public static void main(String[] args) {

		MP3Player mp3 = new MP3Player();

		try (Scanner sc = new Scanner(System.in)) {
			Front front = new Front();
			Ending end = new Ending();
			User user = new User();
			Question que10s = new Question_10s();
			Question que20s = new Question_20s();
			wolf wf = new wolf();

			int inputNum;
			int app = 3;

			// 첫 화면 출력 a 민지
			mp3.play(".\\music\\happyEndingBgm.mp3");
			front.title();
			front.story();

			while (true) {
				String user_id = null;
				String user_pw = null;
				boolean gameStop = false;

				while (true) {

					System.out.println("[1]로그인 [2]회원가입 [3]종료");
					System.out.print("번호 입력 >> ");
					inputNum = sc.nextInt();
					mp3.stop();
					mp3.play(".\\music\\mainBgm.mp3");

					if (inputNum == 1) {
						// 로그인 c 준석
						System.out.print("아이디 입력 : ");
						user_id = sc.next();
						System.out.print("비밀번호 입력 : ");
						user_pw = sc.next();

						user.login(user_id, user_pw);
						System.out.println();
						break;

					} else if (inputNum == 2) {
						// 회원가입 b 준석
						System.out.println("=== 회원가입 ===");
						System.out.print("아이디 입력 >> ");
						String id = sc.next();
						System.out.print("비밀번호 입력 >> ");
						String pw = sc.next();
						System.out.print("이름 입력 >> ");
						String name = sc.next();

						user.singUp(id, pw, name, 3);
						System.out.println();

					} else if (inputNum == 3) {
						mp3.stop();
						System.out.println("게임을 종료합니다");
						gameStop = true;
						break;
					}
				}

				if (gameStop == true) {
					break;
				}

				System.out.println();

				while (true) {
					// 게임 d 지수, 유리
					user.appReset(user_id);

					System.out.println("당신은 [1]LATTE..? [2]MZ..??");
					System.out.print("번호 입력 >> ");
					inputNum = sc.nextInt();
					System.out.println();
					String ans = null;
					int wolf = 1;
					while (true) {

						if (inputNum == 1) {

							if (wolf == 2 || wolf == 5 || wolf == 7) {

								System.out.println("늑대등장!! 두둥!!!");
								System.out.println("                  -!         ..         \r\n"
										+ "                  -!.        !,         \r\n"
										+ "                  -::       ~!,         \r\n"
										+ "                  ::;~-.   -;-,         \r\n"
										+ "  .,..............;;;;;;;;;;;:.         \r\n"
										+ "  *==****!;;;;;;;:;!!;:;*!:;;;.         \r\n"
										+ " .:=$$$$$=;;;;;:~~;**;;;!!;;;:.         \r\n"
										+ "  :;!*;;;;;;;;;;~-:;;;::-::;;;.         \r\n"
										+ "  :;:;;;;;;;;;;;;:;;;;;;:-~:;;.      :, \r\n"
										+ "  :;;;;;;;;;;;;;;;;;;;;;;~~:;;.     ;!  \r\n"
										+ "   -~~~:;;:;;;;;;;;;;;;;;;;;;:.    -*!  \r\n"
										+ "       .,,,,,,~:;;:;;;;;;;;;;;.    !*,  \r\n"
										+ "              .  . ~;;;;;;;;;;,   **=   \r\n"
										+ "       .,~::;;;;;;;;;;;;;;;:;;.  ;**~-  \r\n"
										+ "         .,,,~;;;;;;;;;;;;;;:;. ,!***!  \r\n"
										+ "               ,;;;;;;;;;;;;;~  ;****   \r\n"
										+ "               ,-,-~~~~;;;;;:~  *****   \r\n"
										+ "                ,,,,,.,:;;:;;.  *;!**   \r\n"
										+ "               .,,,,,,-,;;;;;  .;:!**   \r\n"
										+ "             ..~,,,,,,,-;;;:,  :;;**,   \r\n"
										+ "          . ,:;~,,,,.-~;;;::   ::;!;    \r\n"
										+ "          ..;;;.,,-,:::!;:;,  ~;;;*~    \r\n"
										+ "          ..    ,,,,,,.-;::. ,:;;!!     \r\n"
										+ "                .,,,,,,,;:~ .:;;;~,     \r\n"
										+ "               .,,,,,,,~:: -:;;:-       \r\n"
										+ "              ,--.,,,,-;;:-:;;~,        \r\n"
										+ "             -;;::~~,,:;;:;;-.          \r\n"
										+ "           .,;::::::;;;;~.              \r\n"
										+ "          ..,-    .--:;;,               \r\n"
										+ "                     -;;,               \r\n"
										+ "                     -;;,               \r\n"
										+ "                     .::.               \r\n"
										+ "                      .:.               \r\n"
										+ "                     ,.-,               \r\n"
										+ "                     ...                ");

							}

							System.out.println("──────────......＊□♡□*......──────────");
							que10s.que_select();
							System.out.println();

							System.out.print("답 입력 >> ");
							ans = sc.next();

							boolean app_cnt = que10s.ans_match(ans);
							System.out.println();
							if (app_cnt == true) {
								app = user.app_ok_up(user_id);
							} else {
								app = user.app_down_up(user_id);
							}
							wolf++;

						} else if (inputNum == 2) {
							if (wolf == 2 || wolf == 5 || wolf == 7) {
								System.out.println("늑대등장!! 두둥!!!");
								wf.wf_print();
							}

							System.out.println("──────────......＊□♡□*......──────────");
							que20s.que_select();
							System.out.println();

							System.out.print("답 입력 >> ");
							ans = sc.next();

							boolean app_cnt = que20s.ans_match(ans);
							System.out.println();
							if (app_cnt == true) {
								app = user.app_ok_up(user_id);
							} else {
								app = user.app_down_up(user_id);
							}
							wolf++;
						}

						if (app >= 10) {
							System.out.println("와~! 10개다! 할머니께 가자!");
							end.happy_ending();

							break;
						} else if (app <= 0) {
							end.bad_ending();
							break;
						}

					} // while-game

					// end
					mp3.stop();
					System.out.println("[1]다시 시작? [2]종료");
					System.out.print("번호 입력 >> ");
					int reNum = sc.nextInt();

					int i = 1;
					if (i == reNum) {
						mp3.play(".\\music\\mainBgm.mp3");
						System.out.println("다시 사과 구하러 가주아~~");
					} else if (i != reNum) {
						mp3.stop();
						System.out.println("안녕~~");
						break;
					}
				} // while-game level choice

			} // while
		}

	}
}
