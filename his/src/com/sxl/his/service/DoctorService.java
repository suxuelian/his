package com.sxl.his.service;

import java.util.List;

import com.sxl.his.dao.DoctorDao;
import com.sxl.his.entity.DoctorInfoEntity;

//ҵ���
//��ҵ���߼�����
public class DoctorService {

	public DoctorInfoEntity login(String code, String pwd) {
		//�����ݿ��в�ѯ
		DoctorDao doctorDao = new DoctorDao();
		return doctorDao.login(code, pwd);
	}

	//���ݿ���ID��ѯ��ǰ�����µ�����ҽ����Ϣ
	public List<DoctorInfoEntity> getDoctorByDep(int depNo) {
		DoctorDao doctorDao = new DoctorDao();
		return doctorDao.getDoctorByDep(depNo);
		
	}

	
}
