package com.sxl.his.service;

import java.util.List;

import com.sxl.his.dao.DepDao;
import com.sxl.his.entity.DepartmentEntity;

//业务层
//做业务逻辑处理
public class DepService {

	public static List<DepartmentEntity> getAllDep() {
		DepDao depDao = new DepDao();
		return depDao.getAllDep();
	}

}
