package com.shd.model.pojoExt;

import java.util.Date;

import com.shd.model.pojo.Prescription;

/**
 * 处方扩展
 * 
 * @author S5343
 * @date 2018年3月28日下午2:14:06
 */
public class PrescriptionExt extends Prescription {
	private String startTime;
	private String endTime;
	private String userName;
	private String medicineName;
	private String patientName;
	private Integer patientAge;
	private Date patientBirthday;
	private Integer count;
	private String dise;
	private String patientGenderid;
	private String medicines;
	private String lesion;
	private String patientId;
	private String text;

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

	public String getMedicineName() {
		return medicineName;
	}

	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public Integer getPatientAge() {
		return patientAge;
	}

	public void setPatientAge(Integer patientAge) {
		this.patientAge = patientAge;
	}

	public Date getPatientBirthday() {
		return patientBirthday;
	}

	public void setPatientBirthday(Date patientBirthday) {
		this.patientBirthday = patientBirthday;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public String getDise() {
		return dise;
	}

	public void setDise(String dise) {
		this.dise = dise;
	}

	public String getPatientGenderid() {
		return patientGenderid;
	}

	public void setPatientGenderid(String patientGenderid) {
		this.patientGenderid = patientGenderid;
	}

	public String getMedicines() {
		return medicines;
	}

	public void setMedicines(String medicines) {
		this.medicines = medicines;
	}

	public String getLesion() {
		return lesion;
	}

	public void setLesion(String lesion) {
		this.lesion = lesion;
	}

	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
