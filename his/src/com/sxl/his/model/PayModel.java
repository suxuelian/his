package com.sxl.his.model;


//��Ӧ�շѽ���ģ̬��
public class PayModel {
	private int id;
	private String caseNo; //������
	private int totalMoney; //�ܽ��
	private int payState; 	//֧��״̬{0:δ֧��,1:��֧��}
	private int payNum;	//����
	private int dgPrice;//ҩƷ����
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
	public int getTotalMoney() {
		return totalMoney;
	}
	public void setTotalMoney(int totalMoney) {
		this.totalMoney = totalMoney;
	}
	public int getPayState() {
		return payState;
	}
	public void setPayState(int payState) {
		this.payState = payState;
	}
	public int getPayNum() {
		return payNum;
	}
	public void setPayNum(int payNum) {
		this.payNum = payNum;
	}
	public int getDgPrice() {
		return dgPrice;
	}
	public void setDgPrice(int dgPrice) {
		this.dgPrice = dgPrice;
	}
	
	
}
