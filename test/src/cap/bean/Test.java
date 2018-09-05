package cap.bean;
/**
* @author 作者:
* @createDate 创建时间：2018年7月5日 下午3:36:37
*/
public class Test {
	private int id;
	private String username;
	private String password;

	public Test() {
	}
	
	public Test( String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public Test(int id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
 