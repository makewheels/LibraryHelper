package bean;

/**
 * 用户
 * 
 * @author Administrator
 *
 */
public class User {
	private String username;// 用户名
	private String mail;// 邮箱
	private String phone;// 手机
	private String searchBorrowedUrl;// 微信公众号，查询借阅已借书的网址
	private Integer maxBorrowDays;// 最大可借天数

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getSearchBorrowedUrl() {
		return searchBorrowedUrl;
	}

	public void setSearchBorrowedUrl(String searchBorrowedUrl) {
		this.searchBorrowedUrl = searchBorrowedUrl;
	}

	public Integer getMaxBorrowDays() {
		return maxBorrowDays;
	}

	public void setMaxBorrowDays(Integer maxBorrowDays) {
		this.maxBorrowDays = maxBorrowDays;
	}

}