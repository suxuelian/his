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

//科室持久层，和数据库做交互
//数据库代管者
public class DepDao {

	public List<DepartmentEntity> getAllDep() {
		//获取连接
		Connection connection = DBUtil.getConnection();
		//创建数据库操作
		String sql = "SELECT * FROM departmant";
		PreparedStatement preparedStatement = null;
		List<DepartmentEntity> list = new ArrayList<DepartmentEntity>();
		
		try{
			preparedStatement = connection.prepareStatement(sql);
			//执行SQL
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				DepartmentEntity departmentEntity = new DepartmentEntity();
				departmentEntity.setId(resultSet.getInt("id"));
				departmentEntity.setDname(resultSet.getString("dname"));
				//将取出的DepartmentEntity装到List集合
				list.add(departmentEntity);
;			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return list;
	}
}
