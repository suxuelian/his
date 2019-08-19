package com.sxl.his.service;

import java.util.List;

import com.sxl.his.dao.PayInfoDao;
import com.sxl.his.entity.PayInfoEntity;

public class PayInfoService {

	public static int addPayInfo(List<PayInfoEntity> payInfoEntities) {
		PayInfoDao  payInfoDao = new PayInfoDao();
		return payInfoDao.addPayInfo(payInfoEntities);
	}

	public List<PayInfoEntity> getPayedInfoByCaseNo(String caseNo) {
		PayInfoDao  payInfoDao = new PayInfoDao();
		return payInfoDao.getPayedInfoByCaseNo(caseNo);
	}
	
	public List<PayInfoEntity> getPayInfoByCaseNo(String caseNo) {
		PayInfoDao  payInfoDao = new PayInfoDao();
		return payInfoDao.getPayInfoByCaseNo(caseNo);
	}

	public static int payConfirm(String[] payData) {
		PayInfoDao  payInfoDao = new PayInfoDao();
		return payInfoDao.payConfirm(payData);
	}


	public static int unPayConfirm(String[] unPayData) {
		PayInfoDao  payInfoDao = new PayInfoDao();
		return payInfoDao.unPayConfirm(unPayData);
	}

}
