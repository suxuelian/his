package com.sxl.his.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sxl.his.entity.DepartmentEntity;
import com.sxl.his.entity.DrugInfoEntity;
import com.sxl.his.entity.RegisterEntity;
import com.sxl.his.util.DBUtil;

public class DrugDao {

	public List<DrugInfoEntity> getAllDrugs() {
		// 获取连接
		Connection connection = DBUtil.getConnection();
		// 创建数据库操作
		String sql = "SELECT * FROM drug_info";
		PreparedStatement preparedStatement = null;
		List<DrugInfoEntity> list = new ArrayList<DrugInfoEntity>();

		try {
			preparedStatement = connection.prepareStatement(sql);
			// 执行SQL
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				DrugInfoEntity drugInfoEntity = new DrugInfoEntity();
				drugInfoEntity.setId(resultSet.getInt("id"));
				drugInfoEntity.setDgName(resultSet.getString("dg_name"));
				drugInfoEntity.setDgSpec(resultSet.getString("dg_spec"));
				drugInfoEntity.setDgPrice(resultSet.getDouble("dg_price"));
				drugInfoEntity.setDgInv(resultSet.getInt("dg_inv"));
				drugInfoEntity.setDgUit(resultSet.getString("dg_uit"));
				// 将取出的DepartmentEntity装到List集合
				list.add(drugInfoEntity);
				;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public int upDrugInv(String[] payData) {
		// 获取连接
		Connection connection = DBUtil.getConnection();
		// 创建数据库操作  	
		String sql = "Update drug_info SET `dg_inv`=dg_inv-? WHERE `id`= ( SELECT dg_id FROM pay_info WHERE id=?)";
		int result = 0;
		try {
			for (int i = 0; i < payData.length; i++) {
				String item = payData[i];
				String data[] = item.split(",");
				int pId = Integer.parseInt(data[0]); // pay_info:id
				int payNum = Integer.parseInt(data[1]);// 退款数量
				System.out.println("payNum:"+payNum);

				PreparedStatement ps = connection.prepareStatement(sql);
				// 3.传递参数
				ps.setInt(1, payNum);
				ps.setInt(2, pId);

				// 4.执行sql语句 5.取出返回值
				result = ps.executeUpdate();

			}
			return result;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public DrugInfoEntity getDrugById(int dgId) {
		DrugInfoEntity drugInfoEntity = new DrugInfoEntity();
		// 获取连接
		Connection connection = DBUtil.getConnection();
		// 创建数据库操作
		String sql = "SELECT * FROM drug_info WHERE id=?";
		PreparedStatement preparedStatement = null;

		try {
			preparedStatement = connection.prepareStatement(sql);
			// 传递参数
			preparedStatement.setInt(1, dgId);
			// 执行SQL
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				drugInfoEntity.setDgName(resultSet.getString("dg_name"));
				drugInfoEntity.setDgSpec(resultSet.getString("dg_spec"));
				drugInfoEntity.setDgPrice(resultSet.getDouble("dg_price"));
				drugInfoEntity.setDgInv(resultSet.getInt("dg_inv"));
				drugInfoEntity.setDgUit(resultSet.getString("dg_uit"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return drugInfoEntity;
	}

	public int downDrugInv(String[] unPayData) {
		// 获取连接
		Connection connection = DBUtil.getConnection();
		// 创建数据库操作  	
		String sql = "Update drug_info SET `dg_inv`=dg_inv+? WHERE `id`= ( SELECT dg_id FROM pay_info WHERE id=?)";
		int result = 0;
		try {
			for (int i = 0; i < unPayData.length; i++) {
				String item = unPayData[i];
				String data[] = item.split(",");
				int pId = Integer.parseInt(data[0]); // pay_info:id
				int unPayNum = Integer.parseInt(data[1]);// 退款数量

				PreparedStatement ps = connection.prepareStatement(sql);
				// 3.传递参数
				ps.setInt(1, unPayNum);
				ps.setInt(2, pId);

				// 4.执行sql语句 5.取出返回值
				result = ps.executeUpdate();

			}
			return result;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

}
