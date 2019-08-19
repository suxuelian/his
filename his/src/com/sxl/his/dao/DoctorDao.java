package com.sxl.his.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sxl.his.entity.DoctorInfoEntity;
import com.sxl.his.util.DBUtil;

//持久层，和数据库做交互
//数据库代管者
public class DoctorDao {

	//登陆
	public DoctorInfoEntity login(String code, String pwd) {
		DoctorInfoEntity doctorInfoEntity = null; //创建DoctorInfoEntity对象存储数据
		//1.创建java与数据库的连接
		Connection connection = DBUtil.getConnection();
		//2.创建数据库操作
		String sql = "SELECT * from doctor_info WHERE code=? AND pwd=?";
		try{
			PreparedStatement ps = connection.prepareStatement(sql);
			//3.传递参数
			ps.setString(1, code);
			ps.setString(2, pwd);
			//4.执行sql语句
			ResultSet resultSet = ps.executeQuery();
			//5.取出返回值
			if(resultSet.next()){
				doctorInfoEntity = new DoctorInfoEntity();
				doctorInfoEntity.setId(resultSet.getInt("id"));
				doctorInfoEntity.setCode(resultSet.getString("code"));
				doctorInfoEntity.setUsername(resultSet.getString("username"));
				doctorInfoEntity.setPwd(resultSet.getString("pwd"));
				doctorInfoEntity.setDep(resultSet.getString("dep"));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}

		return doctorInfoEntity;
	}

	public List<DoctorInfoEntity> getDoctorByDep(int depNo) {
		List<DoctorInfoEntity> list = new ArrayList<DoctorInfoEntity>();//创建DoctorInfoEntity的List对象存储数据
		//1.创建java与数据库的连接
		Connection connection = DBUtil.getConnection();
		//2.创建数据库操作
		String sql = "SELECT * from doctor_info WHERE dep=?";
		try{
			PreparedStatement ps = connection.prepareStatement(sql);
			//3.传递参数
			ps.setInt(1, depNo);
			//4.执行sql语句
			ResultSet resultSet = ps.executeQuery();
			//5.取出返回值
			while(resultSet.next()){
				DoctorInfoEntity doctorInfoEntity = new DoctorInfoEntity();
				doctorInfoEntity.setId(resultSet.getInt("id"));
				doctorInfoEntity.setUsername(resultSet.getString("username"));
				//将取出的单挑数据存入list
				list.add(doctorInfoEntity);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}

		return list;
	}

}


















