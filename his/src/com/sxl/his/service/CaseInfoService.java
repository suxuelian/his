package com.sxl.his.service;

import com.sxl.his.dao.CaseInfoDao;
import com.sxl.his.entity.CaseInfoEntity;

//业务层
//做业务逻辑处理
public class CaseInfoService {

	public int addCaseInfo(CaseInfoEntity caseInfoEntity) {
		CaseInfoDao caseInfoDao = new CaseInfoDao();
		return caseInfoDao.addCaseInfo(caseInfoEntity);
	}

}
