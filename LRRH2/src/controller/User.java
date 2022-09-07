package controller;

import model.UserDAO;
import model.UserDTO;

public class User {
	UserDAO uDao = new UserDAO();
	UserDTO uDto;
	
	//ȸ������
	public void singUp(String id, String pw, String name, int app_cnt) {
		uDto = new UserDTO(id, pw, name, app_cnt);
		
		int cnt = uDao.insert(uDto);
		
		if (cnt > 0) {
			System.out.println("SUCCESS!");
		} else {
			System.out.println("FAIL");
		}
		
	}
	
	//login
	public void login(String user_id, String user_pw) {
		boolean result = uDao.login(user_id, user_pw);
		if (result) {
			System.out.println("�α��� ����!");
		} else {
			System.out.println("�α��� ����");
		}
		
	}
	
	
	//apple +1 count
	public int app_ok_up(String user_id) {
		int app_cnt = uDao.app_ok_up(user_id);
		System.out.println("���壽����������������������������������3��");
		System.out.println("	���� ����� "+app_cnt+"����~");
		System.out.println("���壽����������������������������������3��");
		System.out.println();
		return app_cnt;
	}

	//apple -2 count
	public int app_down_up(String user_id) {
		int app_cnt = uDao.app_down_up(user_id);
		System.out.println("���壽����������������������������������3��");
		System.out.println("	���� ����� "+app_cnt+"����~");
		System.out.println("���壽����������������������������������3��");
		System.out.println();
		return app_cnt;
	}
	
	//appReset
	public void appReset(String user_id) {
		uDao.appReset(user_id);
		
	}

}
