package com.sxl.his.service;

import java.util.List;

import com.sxl.his.dao.DepDao;
import com.sxl.his.entity.DepartmentEntity;

//ҵ���
//��ҵ���߼�����
public class DepService {

	public static List<DepartmentEntity> getAllDep() {
		DepDao depDao = new DepDao();
		return depDao.getAllDep();
	}

}
