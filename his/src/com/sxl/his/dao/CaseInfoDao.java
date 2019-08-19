package com.sxl.his.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.sxl.his.entity.CaseInfoEntity;
import com.sxl.his.entity.RegisterEntity;
import com.sxl.his.util.DBUtil;

public class CaseInfoDao {

	//��������Ϣ-s
	public int addCaseInfo(CaseInfoEntity caseInfoEntity) {
		// 1.����java�����ݿ������
		Connection connection = DBUtil.getConnection();
		// 2.�������ݿ����
		String sql = "INSERT INTO `his`.`case_info` (`c_no`, `c_info`) VALUES (?,?)";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			// 3.���ݲ���
			ps.setString(1, caseInfoEntity.getcNo());
			ps.setString(2, caseInfoEntity.getcInfo());
			// 4.ִ��sql���
			int result = ps.executeUpdate();
			// 5.ȡ������ֵ
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	//��������Ϣ-e

}
