package bean;

import java.util.Date;

/**
 * 查询借阅记录中的一本书
 * 
 * @author Administrator
 *
 */
public class Book {
	private String name;// 书名
	private String barCode;// 条码号
	private Date borrowDate;// 借阅日期
	private Date shouldReturnDate;// 应还日期
	private String storagePlace;// 馆藏地点
	private Integer renewedTimes;// 已续借次数
	private String renewArg_sn;// 续借参数
	private String renewArg_code;// 续借参数
	private String renewArg_check;// 续借参数
	private String renewArg_schoolId;// 续借参数
	private String renewArg_pdsToken;// 续借参数

	public Book() {
		super();
	}

	public Book(String name, String barCode, Date borrowDate, Date shouldReturnDate, String storagePlace,
			Integer renewedTimes, String renewArg_sn, String renewArg_code, String renewArg_check,
			String renewArg_schoolId, String renewArg_pdsToken) {
		super();
		this.name = name;
		this.barCode = barCode;
		this.borrowDate = borrowDate;
		this.shouldReturnDate = shouldReturnDate;
		this.storagePlace = storagePlace;
		this.renewedTimes = renewedTimes;
		this.renewArg_sn = renewArg_sn;
		this.renewArg_code = renewArg_code;
		this.renewArg_check = renewArg_check;
		this.renewArg_schoolId = renewArg_schoolId;
		this.renewArg_pdsToken = renewArg_pdsToken;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBarCode() {
		return barCode;
	}

	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}

	public Date getBorrowDate() {
		return borrowDate;
	}

	public void setBorrowDate(Date borrowDate) {
		this.borrowDate = borrowDate;
	}

	public Date getShouldReturnDate() {
		return shouldReturnDate;
	}

	public void setShouldReturnDate(Date shouldReturnDate) {
		this.shouldReturnDate = shouldReturnDate;
	}

	public String getStoragePlace() {
		return storagePlace;
	}

	public void setStoragePlace(String storagePlace) {
		this.storagePlace = storagePlace;
	}

	public Integer getRenewedTimes() {
		return renewedTimes;
	}

	public void setRenewedTimes(Integer renewedTimes) {
		this.renewedTimes = renewedTimes;
	}

	public String getRenewArg_sn() {
		return renewArg_sn;
	}

	public void setRenewArg_sn(String renewArg_sn) {
		this.renewArg_sn = renewArg_sn;
	}

	public String getRenewArg_code() {
		return renewArg_code;
	}

	public void setRenewArg_code(String renewArg_code) {
		this.renewArg_code = renewArg_code;
	}

	public String getRenewArg_check() {
		return renewArg_check;
	}

	public void setRenewArg_check(String renewArg_check) {
		this.renewArg_check = renewArg_check;
	}

	public String getRenewArg_schoolId() {
		return renewArg_schoolId;
	}

	public void setRenewArg_schoolId(String renewArg_schoolId) {
		this.renewArg_schoolId = renewArg_schoolId;
	}

	public String getRenewArg_pdsToken() {
		return renewArg_pdsToken;
	}

	public void setRenewArg_pdsToken(String renewArg_pdsToken) {
		this.renewArg_pdsToken = renewArg_pdsToken;
	}

	@Override
	public String toString() {
		return "Book [name=" + name + ", barCode=" + barCode + ", borrowDate=" + borrowDate + ", shouldReturnDate="
				+ shouldReturnDate + ", storagePlace=" + storagePlace + ", renewedTimes=" + renewedTimes
				+ ", renewArg_sn=" + renewArg_sn + ", renewArg_code=" + renewArg_code + ", renewArg_check="
				+ renewArg_check + ", renewArg_schoolId=" + renewArg_schoolId + ", renewArg_pdsToken="
				+ renewArg_pdsToken + "]";
	}

}