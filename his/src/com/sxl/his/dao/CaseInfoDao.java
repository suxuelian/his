package com.sxl.his.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.sxl.his.entity.CaseInfoEntity;
import com.sxl.his.entity.RegisterEntity;
import com.sxl.his.util.DBUtil;

public class CaseInfoDao {

	//添加诊断信息-s
	public int addCaseInfo(CaseInfoEntity caseInfoEntity) {
		// 1.创建java与数据库的连接
		Connection connection = DBUtil.getConnection();
		// 2.创建数据库操作
		String sql = "INSERT INTO `his`.`case_info` (`c_no`, `c_info`) VALUES (?,?)";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			// 3.传递参数
			ps.setString(1, caseInfoEntity.getcNo());
			ps.setString(2, caseInfoEntity.getcInfo());
			// 4.执行sql语句
			int result = ps.executeUpdate();
			// 5.取出返回值
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	//添加诊断信息-e

}
