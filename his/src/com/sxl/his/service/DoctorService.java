package com.sxl.his.service;

import java.util.List;

import com.sxl.his.dao.DoctorDao;
import com.sxl.his.entity.DoctorInfoEntity;

//业务层
//做业务逻辑处理
public class DoctorService {

	public DoctorInfoEntity login(String code, String pwd) {
		//到数据库中查询
		DoctorDao doctorDao = new DoctorDao();
		return doctorDao.login(code, pwd);
	}

	//根据科室ID查询当前科室下的所有医生信息
	public List<DoctorInfoEntity> getDoctorByDep(int depNo) {
		DoctorDao doctorDao = new DoctorDao();
		return doctorDao.getDoctorByDep(depNo);
		
	}

	
}
