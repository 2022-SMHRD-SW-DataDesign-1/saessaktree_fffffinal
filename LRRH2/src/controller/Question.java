package controller;

public abstract class Question {
	
	//문제범위 
	public abstract void que_select();

	public abstract boolean ans_match(String ans);
}
