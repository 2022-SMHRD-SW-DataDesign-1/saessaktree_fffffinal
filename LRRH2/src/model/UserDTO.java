package model;

public class UserDTO {
	private String id;
	private String pw;
	private String name;
	private int app_cnt;
	
	public UserDTO(String id, String pw, String name, int app_cnt) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.app_cnt = app_cnt;
	}

	//·Î±×ÀÎ
	public UserDTO(String id, String pw) {
		this.id=id;
		this.pw=pw;
	}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getApp_cnt() {
		return app_cnt;
	}

	public void setApp_cnt(int app_cnt) {
		this.app_cnt = app_cnt;
	}

	@Override
	public String toString() {
		return "user_infoVO [id=" + id + ", pw=" + pw + ", name=" + name + ", app_cnt=" + app_cnt + "]";
	}
	
	
}
