package controller;

import java.util.Random;

import model.QuestionDAO;
import model.QuestionDTO;


public class Question_20s extends Question {
	QuestionDAO qDao = new QuestionDAO();
	QuestionDTO qDto;

	Random rd = new Random();
	int rdNum;

	//객체생성
	public Question_20s() {};

	//문제 출력 
	@Override
	public void que_select() {
		rdNum = rd.nextInt(22) + 1;
		qDao.ques_select20(rdNum);

	}

	//답 확인
	@Override
	public boolean ans_match(String ans) {
		boolean re = qDao.ques_select20(ans);
		return re;
	}

}