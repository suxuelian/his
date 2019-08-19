package com.sxl.his.entity;

import java.util.Date;

public class RegisterEntity {
	private int id;	//编号
	private String caseNo;	//病历号
	private String rname; 	//姓名
	private int sex; 	//性别
	private int age;  //年龄
	private String birthday; // 生日
	private int settleType; //结算类别
	private String mcardNo;  //医疗证号
	private int medicalType; //医疗类型
	private String idCard; //身份证号
	private String address; //地址
	private String vistDate; //看诊日期
	private int regLevel; //挂号级别
	private int deptNo;  //挂号科室编号
	private int drId; //看诊医生
	private int regPay; //挂号费用
	private int regSrc; //挂号来源
	private int diagState; //诊断状态
	private int regState;  //挂号状态
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCaseNo() {
		return caseNo;
	}
	public void setCaseNo(String caseNo) {
		this.caseNo = caseNo;
	}
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public int getSettleType() {
		return settleType;
	}
	public void setSettleType(int settleType) {
		this.settleType = settleType;
	}
	public String getMcardNo() {
		return mcardNo;
	}
	public void setMcardNo(String mcardNo) {
		this.mcardNo = mcardNo;
	}
	public int getMedicalType() {
		return medicalType;
	}
	public void setMedicalType(int medicalType) {
		this.medicalType = medicalType;
	}
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getVistDate() {
		return vistDate;
	}
	public void setVistDate(String vistDate) {
		this.vistDate = vistDate;
	}
	public int getRegLevel() {
		return regLevel;
	}
	public void setRegLevel(int regLevel) {
		this.regLevel = regLevel;
	}
	public int getDeptNo() {
		return deptNo;
	}
	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}
	public int getDrId() {
		return drId;
	}
	public void setDrId(int drId) {
		this.drId = drId;
	}
	public int getRegPay() {
		return regPay;
	}
	public void setRegPay(int regPay) {
		this.regPay = regPay;
	}
	public int getRegSrc() {
		return regSrc;
	}
	public void setRegSrc(int regSrc) {
		this.regSrc = regSrc;
	}
	public int getDiagState() {
		return diagState;
	}
	public void setDiagState(int diagState) {
		this.diagState = diagState;
	}
	public int getRegState() {
		return regState;
	}
	public void setRegState(int regState) {
		this.regState = regState;
	}
	
}
