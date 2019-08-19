package com.sxl.his.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sxl.his.entity.DoctorInfoEntity;
import com.sxl.his.util.DBUtil;

//�־ò㣬�����ݿ�������
//���ݿ������
public class DoctorDao {

	//��½
	public DoctorInfoEntity login(String code, String pwd) {
		DoctorInfoEntity doctorInfoEntity = null; //����DoctorInfoEntity����洢����
		//1.����java�����ݿ������
		Connection connection = DBUtil.getConnection();
		//2.�������ݿ����
		String sql = "SELECT * from doctor_info WHERE code=? AND pwd=?";
		try{
			PreparedStatement ps = connection.prepareStatement(sql);
			//3.���ݲ���
			ps.setString(1, code);
			ps.setString(2, pwd);
			//4.ִ��sql���
			ResultSet resultSet = ps.executeQuery();
			//5.ȡ������ֵ
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
		List<DoctorInfoEntity> list = new ArrayList<DoctorInfoEntity>();//����DoctorInfoEntity��List����洢����
		//1.����java�����ݿ������
		Connection connection = DBUtil.getConnection();
		//2.�������ݿ����
		String sql = "SELECT * from doctor_info WHERE dep=?";
		try{
			PreparedStatement ps = connection.prepareStatement(sql);
			//3.���ݲ���
			ps.setInt(1, depNo);
			//4.ִ��sql���
			ResultSet resultSet = ps.executeQuery();
			//5.ȡ������ֵ
			while(resultSet.next()){
				DoctorInfoEntity doctorInfoEntity = new DoctorInfoEntity();
				doctorInfoEntity.setId(resultSet.getInt("id"));
				doctorInfoEntity.setUsername(resultSet.getString("username"));
				//��ȡ���ĵ������ݴ���list
				list.add(doctorInfoEntity);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}

		return list;
	}

}


















