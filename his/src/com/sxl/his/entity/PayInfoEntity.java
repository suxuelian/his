package com.sxl.his.entity;

public class PayInfoEntity {
	private int id;	//��ţ�Ψһ��ʶ
	private int dgId;	//ҩƷ���
	private String caseNo;	//������
	private int payNum;	//ҩƷ����
	private double payMoney;	//�շѽ��
	private String payDate;	  //�շ�ʱ��
	private int payState; // �շ�״̬{0:δ�շ�,1:���շ�}
	private String remark;	//��ע
	
	//��չ�ֶ�(*����Ӧ���ݿ��еı�ṹ)
	//caseInfo
	private String rname;//��������
	private int settleType;//��������
	
	//drugInfo 
	private double price;//����
	private String dgName;	//ҩƷ����
	private String dgSpec; 	//ҩƷ���
	private String dgUit;	//ҩƷ��λ
	
	
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
