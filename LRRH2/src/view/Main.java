package view;

import java.util.Scanner;

import controller.Ending;
import controller.Front;
import controller.Question;
import controller.Question_10s;
import controller.Question_20s;
import controller.User;

public class Main {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			Front front = new Front();
			Ending end = new Ending();
			User user = new User();
			Question que10s = new Question_10s();
			Question que20s = new Question_20s();
			
			int inputNum;
			int app=3;
			
			//ù ȭ�� ��� a ����
			front.title();
			front.story();
			
			
			while (true) {
				
				System.out.println("[1]�α��� [2]ȸ������ [3]����");
				System.out.print("��ȣ �Է� >> ");
				inputNum = sc.nextInt();
				String user_id = null;
				String user_pw = null;
				
				if (inputNum==1) {
					//�α��� c �ؼ�
					System.out.print("���̵� �Է� : ");
					user_id = sc.next();
					System.out.print("��й�ȣ �Է� : ");
					user_pw = sc.next();
					
					user.login(user_id, user_pw);
					
					
				} else if (inputNum==2) {
					//ȸ������ b �ؼ�
					System.out.println("=== ȸ������ ===");
					System.out.print("���̵� �Է� >> ");
					String id = sc.next();
					System.out.print("��й�ȣ �Է� >> ");
					String pw = sc.next();
					System.out.print("�̸� �Է� >> ");
					String name = sc.next();
					
					user.singUp(id, pw, name, 3);
				}
				else if(inputNum==3) {
					System.out.println("������ �����մϴ�");
					break;
				}
				System.out.println();
				
				
				
				while (true) {
					//���� d ����, ����
					user.appReset(user_id);
					
					
					System.out.println("����� [1]LATTE..? [2]MZ..??");
					System.out.print("��ȣ �Է� >> ");
					inputNum = sc.nextInt();
					System.out.println();
					String ans = null;
					int wolf = 1;
					while (true) {
					
						if (inputNum==1) {
							if (wolf == 2 || wolf == 5 || wolf == 7) {
								System.out.println("�������!");
							}
							
							System.out.println("��������������������......���ࢽ��*......��������������������");
							que10s.que_select();
							System.out.println();
							
							System.out.print("�� �Է� >> ");
							ans = sc.next();
							
							boolean app_cnt = que10s.ans_match(ans);					
							System.out.println();
							if (app_cnt == true) {
								app = user.app_ok_up(user_id);
								
							} else{
								app = user.app_down_up(user_id);	
							}
							wolf++;
							
							
							
						} else if(inputNum==2) {
							if (wolf == 2 || wolf == 5 || wolf == 7) {
								System.out.println("�������!");
							}
							
							que20s.que_select();
							System.out.println();
							
							System.out.print("�� �Է� >> ");
							ans = sc.next();
							
							boolean app_cnt = que20s.ans_match(ans);
							System.out.println();
							if (app_cnt == true) {
								app = user.app_ok_up(user_id);
								
							} else{
								app = user.app_down_up(user_id);	
							}
							wolf++;
						}
						
						
						
						
						if (app >= 10) {
							System.out.println("��~! 10����! �ҸӴϲ� ����!");
							end.happy_ending();
						
							break;
						} else if(app <= 0) {
							end.bad_ending();
							break;
						}
						
					}//while-game

					//end
					System.out.println("[1]�ٽ� ����? [2]����");
					int reNum = sc.nextInt();

					int i = 1;
					if (i == reNum) {
						System.out.println("�ٽ� ��� ���Ϸ� ���־�~~");
					} else if (i != reNum) {
						System.out.println("�ȳ�~~");
						break;
					}
				}//while-game level choice
				
			}//while
		}
			
			
			

	}
}