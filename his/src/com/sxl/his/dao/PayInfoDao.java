package com.sxl.his.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.sxl.his.entity.PayInfoEntity;
import com.sxl.his.util.DBUtil;

//收费持久层，和数据库做交互
public class PayInfoDao {

	public int addPayInfo(List<PayInfoEntity> payInfoEntities) {
		// 1.创建java与数据库的连接
		Connection connection = DBUtil.getConnection();
		// 2.创建数据库操作
		String sql = "INSERT INTO `his`.`pay_info` (`dg_id`, `case_no`, `pay_num`, `pay_money`, `pay_state`, `remark`) VALUES (?, ?, ?, ?, '0', NULL);";
		int result = 0;
		try {
			for (PayInfoEntity tmp : payInfoEntities) {
				PreparedStatement ps = connection.prepareStatement(sql);
				// 3.传递参数
				int num = tmp.getPayNum(); // 数量
				double price = tmp.getPrice();// 单价

				ps.setInt(1, tmp.getDgId());
				ps.setString(2, tmp.getCaseNo());
				ps.setInt(3, tmp.getPayNum());
				ps.setDouble(4, num * price);

				// 4.执行sql语句 5.取出返回值
				result = ps.executeUpdate();

			}
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	
	//收费时
	public List<PayInfoEntity> getPayInfoByCaseNo(String caseNo) {
		List<PayInfoEntity> list = new ArrayList<PayInfoEntity>();// 创建PayInfoEntity的List对象存储数据
		// 1.创建java与数据库的连接
		Connection connection = DBUtil.getConnection();
		// 2.创建数据库操作
		String sql = "SELECT * FROM pay_info WHERE case_no=?";

		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			// 3.传递参数
			ps.setString(1, caseNo);
			// 4.执行sql语句
			ResultSet resultSet = ps.executeQuery();
			// 5.取出返回值
			while (resultSet.next()) {
				PayInfoEntity payInfoEntity = new PayInfoEntity();
				payInfoEntity.setId(resultSet.getInt("id"));
				payInfoEntity.setCaseNo(resultSet.getString("case_no"));
				payInfoEntity.setPayMoney(resultSet.getInt("pay_money"));
				payInfoEntity.setPayNum(resultSet.getInt("pay_num"));
				payInfoEntity.setPayState(resultSet.getInt("pay_state"));
				
				
				// 将取出的单条数据存入list
				list.add(payInfoEntity);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}
	
	
	//退费时
	public List<PayInfoEntity> getPayedInfoByCaseNo(String caseNo) {
		List<PayInfoEntity> list = new ArrayList<PayInfoEntity>();// 创建PayInfoEntity的List对象存储数据
		// 1.创建java与数据库的连接
		Connection connection = DBUtil.getConnection();
		// 2.创建数据库操作
		String sql = "SELECT pd.id, pd.case_no, pd.pay_money, pd.pay_num, pd.pay_state, di.dg_name, di.dg_spec, di.dg_price, di.dg_uit, r.rname, r.settle_type"
				+" FROM pay_info pd, drug_info di, register r "
				+" WHERE  pd.dg_id=di.id  AND r.case_no=pd.case_no AND pd.pay_state=1 AND pd.case_no=?";

		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			// 3.传递参数
			ps.setString(1, caseNo);
			// 4.执行sql语句
			ResultSet resultSet = ps.executeQuery();
			// 5.取出返回值
			while (resultSet.next()) {
				PayInfoEntity payInfoEntity = new PayInfoEntity();
				payInfoEntity.setId(resultSet.getInt("id"));
				payInfoEntity.setCaseNo(resultSet.getString("case_no"));
				payInfoEntity.setPayMoney(resultSet.getInt("pay_money"));
				payInfoEntity.setPayNum(resultSet.getInt("pay_num"));
				payInfoEntity.setDgName(resultSet.getString("dg_name"));
				payInfoEntity.setDgSpec(resultSet.getString("dg_spec"));
				payInfoEntity.setPrice(resultSet.getInt("dg_price"));
				payInfoEntity.setDgUit(resultSet.getString("dg_uit"));
				payInfoEntity.setRname(resultSet.getString("rname"));
				payInfoEntity.setSettleType(resultSet.getInt("settle_type"));
				
				// 将取出的单条数据存入list
				list.add(payInfoEntity);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	public int payConfirm(String[] payData) {
		// 获取连接
		Connection connection = DBUtil.getConnection();
		// 创建数据库操作
		String sql = "Update pay_info set pay_state=? where id=?";
		int result = 0;
		try {
			for (int i = 0; i < payData.length; i++) {
				PreparedStatement ps = connection.prepareStatement(sql);
				
				String item = payData[i];
				String data[] = item.split(",");
				int pId = Integer.parseInt(data[0]); //pay_info:id
				
				// 3.传递参数
				ps.setInt(1, 1);
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

	public int unPayConfirm(String[] unPayData) {
		// 获取连接
				Connection connection = DBUtil.getConnection();
				// 创建数据库操作
				String sql = "Update pay_info set pay_num=pay_num-?, pay_money=pay_num*?  where id=?";
				int result = 0;
				try {
					for (int i = 0; i < unPayData.length; i++) {
						String item = unPayData[i];
						String data[] = item.split(",");
						int pId = Integer.parseInt(data[0]); //pay_info:id
						int unPayNum = Integer.parseInt(data[1]);//退款数量
						double price = Double.parseDouble(data[2]); //单价
						
						PreparedStatement ps = connection.prepareStatement(sql);
						// 3.传递参数
						ps.setInt(1, unPayNum);
						ps.setDouble(2, price);
						ps.setInt(3, pId);

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
