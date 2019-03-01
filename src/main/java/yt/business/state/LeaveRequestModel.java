package yt.business.state;


import lombok.Data;

@Data
public class LeaveRequestModel {

	/**
	 * 请假人
	 */
	private String user;
	/**
	 * 请假开始日期
	 */
	private String dateBegin;
	/**
	 * 请假天数
	 */
	private Integer leaveDays;
	/**
	 * 审核结果
	 */
	private String result;

	/*public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getDateBegin() {
		return dateBegin;
	}

	public void setDateBegin(String dateBegin) {
		this.dateBegin = dateBegin;
	}

	public Integer getLeaveDays() {
		return leaveDays;
	}

	public void setLeaveDays(Integer leaveDays) {
		this.leaveDays = leaveDays;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}*/
}
