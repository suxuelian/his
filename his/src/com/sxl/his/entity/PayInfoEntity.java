package com.sxl.his.entity;

public class PayInfoEntity {
	private int id;	//编号，唯一标识
	private int dgId;	//药品标号
	private String caseNo;	//病历号
	private int payNum;	//药品数量
	private double payMoney;	//收费金额
	private String payDate;	  //收费时间
	private int payState; // 收费状态{0:未收费,1:已收费}
	private String remark;	//备注
	
	//扩展字段(*不对应数据库中的表结构)
	//caseInfo
	private String rname;//患者姓名
	private int settleType;//结算类型
	
	//drugInfo 
	private double price;//单价
	private String dgName;	//药品名称
	private String dgSpec; 	//药品规格
	private String dgUit;	//药品单位
	
	
	public String getDgName() {
		return dgName;
	}
	public void setDgName(String dgName) {
		this.dgName = dgName;
	}
	public String getDgSpec() {
		return dgSpec;
	}
	public void setDgSpec(String dgSpec) {
		this.dgSpec = dgSpec;
	}
	public String getDgUit() {
		return dgUit;
	}
	public void setDgUit(String dgUit) {
		this.dgUit = dgUit;
	}
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	public int getSettleType() {
		return settleType;
	}
	public void setSettleType(int settleType) {
		this.settleType = settleType;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDgId() {
		return dgId;
	}
	public void setDgId(int dgId) {
		this.dgId = dgId;
	}
	public String getCaseNo() {
		return caseNo;
	}
	public void setCaseNo(String caseNo) {
		this.caseNo = caseNo;
	}
	public int getPayNum() {
		return payNum;
	}
	public void setPayNum(int payNum) {
		this.payNum = payNum;
	}
	public double getPayMoney() {
		return payMoney;
	}
	public void setPayMoney(double payMoney) {
		this.payMoney = payMoney;
	}
	public String getPayDate() {
		return payDate;
	}
	public void setPayDate(String payDate) {
		this.payDate = payDate;
	}
	public int getPayState() {
		return payState;
	}
	public void setPayState(int payState) {
		this.payState = payState;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
