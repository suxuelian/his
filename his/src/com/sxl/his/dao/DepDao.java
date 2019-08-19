package com.sxl.his.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.print.attribute.standard.RequestingUserName;

import com.sxl.his.entity.DepartmentEntity;
import com.sxl.his.util.DBUtil;

//���ҳ־ò㣬�����ݿ�������
//���ݿ������
public class DepDao {

	public List<DepartmentEntity> getAllDep() {
		//��ȡ����
		Connection connection = DBUtil.getConnection();
		//�������ݿ����
		String sql = "SELECT * FROM departmant";
		PreparedStatement preparedStatement = null;
		List<DepartmentEntity> list = new ArrayList<DepartmentEntity>();
		
		try{
			preparedStatement = connection.prepareStatement(sql);
			//ִ��SQL
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				DepartmentEntity departmentEntity = new DepartmentEntity();
				departmentEntity.setId(resultSet.getInt("id"));
				departmentEntity.setDname(resultSet.getString("dname"));
				//��ȡ����DepartmentEntityװ��List����
				list.add(departmentEntity);
;			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return list;
	}
}
