package com.sxl.his.entity;

public class DrugInfoEntity {
	private int id;//���
	private String dgName; //��Ŀ���ƣ�ҩƷ���ƣ�
	private String dgSpec; //���
	private double dgPrice;//�۸�
	private int dgInv;	//���������
	private String dgUit;	//��λ
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	public double getDgPrice() {
		return dgPrice;
	}
	public void setDgPrice(double dgPrice) {
		this.dgPrice = dgPrice;
	}
	public int getDgInv() {
		return dgInv;
	}
	public void setDgInv(int dgInv) {
		this.dgInv = dgInv;
	}
	public String getDgUit() {
		return dgUit;
	}
	public void setDgUit(String dgUit) {
		this.dgUit = dgUit;
	}

}
