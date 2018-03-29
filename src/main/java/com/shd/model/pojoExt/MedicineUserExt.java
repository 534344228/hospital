package com.shd.model.pojoExt;

import com.shd.model.pojo.Medicine;

public class MedicineUserExt extends Medicine {
	private String startTime;

	private String endTime;

	private String userName;

	private String q;

	private String term;

	private String _type;

	private Integer page;

	private Integer pageUp;

	private Integer pageDown;

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getQ() {
		return q;
	}

	public void setQ(String q) {
		this.q = q;
	}

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public String get_type() {
		return _type;
	}

	public void set_type(String _type) {
		this._type = _type;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getPageUp() {
		return pageUp;
	}

	public void setPageUp(Integer pageUp) {
		this.pageUp = pageUp;
	}

	public Integer getPageDown() {
		return pageDown;
	}

	public void setPageDown(Integer pageDown) {
		this.pageDown = pageDown;
	}

}
