package com.sxl.his.service;

import java.util.List;

import com.sxl.his.dao.RegisterDao;
import com.sxl.his.entity.RegisterEntity;

//ҵ���
//��ҵ���߼�����
public class RegisterService {

	//�Һųɹ�����1��ʧ�ܷ���0
	public int addRegister(RegisterEntity registerEntity) {
		RegisterDao registerDao = new RegisterDao();
		return registerDao.addRegister(registerEntity);
	}

	public List<RegisterEntity> getAllRegisterInfo() {
		RegisterDao registerDao = new RegisterDao();
		return registerDao.getAllRegisterInfo();
	}

	public RegisterEntity getRegisterByPid(String pid) {
		RegisterDao registerDao = new RegisterDao();
		return registerDao.getRegisterByPid(pid);
	}

	public int updateRegister(int id) {
		RegisterDao registerDao = new RegisterDao();
		return registerDao.updateRegister(id);
	}

	public List<RegisterEntity> getRegisterByDid(int doctorId) {
		RegisterDao registerDao = new RegisterDao();
		return registerDao.getRegisterByDid(doctorId);
	}

	public RegisterEntity getRegisterByCaseNo(int caseNo) {
		RegisterDao registerDao = new RegisterDao();
		return registerDao.getRegisterByCaseNo(caseNo);
	}

	public int updateDiaStateRegister(int caseNo) {
		RegisterDao registerDao = new RegisterDao();
		return registerDao.updateDiaStateRegister(caseNo);
	}

	public RegisterEntity getRegisterByCaseNoAndPid(int caseNo, String idNo) {
		RegisterDao registerDao = new RegisterDao();
		return registerDao.getRegisterByCaseNo(caseNo,idNo);
	}

}
