package tw.ws1.classes;

public class Member {

	private int id;
	private String account, realname, birthday;
	private boolean isMale;

	public Member() {
		
	}
	public Member(int id, String account, String realname, String birthday) {
		this.id = id;
		this.account = account;
		this.realname = realname;
		this.birthday = birthday;
	}
	
	
	public boolean isMale() {
		return isMale;
	}
	public void setMale(boolean isMale) {
		this.isMale = isMale;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	@Override
	public String toString() {
		return String.format("%s:%s", account, realname);
	}


}
