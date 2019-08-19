package com.sxl.his.service;

import java.util.List;

import com.sxl.his.dao.DrugDao;
import com.sxl.his.entity.DrugInfoEntity;

public class DrugService {

	public static List<DrugInfoEntity> getAllDrugs() {
		DrugDao drugDao = new DrugDao();
		return drugDao.getAllDrugs();
	}

	public static int upDrugInv(String[] payData) {
		DrugDao drugDao = new DrugDao();
		return drugDao.upDrugInv(payData);
	}

	public DrugInfoEntity getDrugById(int dgId) {
		DrugDao drugDao = new DrugDao();
		return drugDao.getDrugById(dgId);
	}

	public static int downDrugInv(String[] unPayData) {
		DrugDao drugDao = new DrugDao();
		return drugDao.downDrugInv(unPayData);
	}

}
