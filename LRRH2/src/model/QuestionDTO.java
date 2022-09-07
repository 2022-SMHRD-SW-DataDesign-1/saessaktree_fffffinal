package model;

public class QuestionDTO {
	private int q_num;
	private String ques;
	private String ans;
	
	public QuestionDTO(int q_num, String ques, String ans) {
		super();
		this.q_num = q_num;
		this.ques = ques;
		this.ans = ans;
	}

	public int getQ_num() {
		return q_num;
	}

	public void setQ_num(int q_num) {
		this.q_num = q_num;
	}

	public String getQues() {
		return ques;
	}

	public void setQues(String ques) {
		this.ques = ques;
	}

	public String getAns() {
		return ans;
	}

	public void setAns(String ans) {
		this.ans = ans;
	}



	@Override
	public String toString() {
		return "questionVO [q_num=" + q_num + ", ques=" + ques + ", ans=" + ans + "]";
	}
	
	
	
	
	
	
}
