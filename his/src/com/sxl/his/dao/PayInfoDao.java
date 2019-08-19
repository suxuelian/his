package com.sxl.his.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.sxl.his.entity.PayInfoEntity;
import com.sxl.his.util.DBUtil;

//�շѳ־ò㣬�����ݿ�������
public class PayInfoDao {

	public int addPayInfo(List<PayInfoEntity> payInfoEntities) {
		// 1.����java�����ݿ������
		Connection connection = DBUtil.getConnection();
		// 2.�������ݿ����
		String sql = "INSERT INTO `his`.`pay_info` (`dg_id`, `case_no`, `pay_num`, `pay_money`, `pay_state`, `remark`) VALUES (?, ?, ?, ?, '0', NULL);";
		int result = 0;
		try {
			for (PayInfoEntity tmp : payInfoEntities) {
				PreparedStatement ps = connection.prepareStatement(sql);
				// 3.���ݲ���
				int num = tmp.getPayNum(); // ����
				double price = tmp.getPrice();// ����

				ps.setInt(1, tmp.getDgId());
				ps.setString(2, tmp.getCaseNo());
				ps.setInt(3, tmp.getPayNum());
				ps.setDouble(4, num * price);

				// 4.ִ��sql��� 5.ȡ������ֵ
				result = ps.executeUpdate();

			}
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	
	//�շ�ʱ
	public List<PayInfoEntity> getPayInfoByCaseNo(String caseNo) {
		List<PayInfoEntity> list = new ArrayList<PayInfoEntity>();// ����PayInfoEntity��List����洢����
		// 1.����java�����ݿ������
		Connection connection = DBUtil.getConnection();
		// 2.�������ݿ����
		String sql = "SELECT * FROM pay_info WHERE case_no=?";

		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			// 3.���ݲ���
			ps.setString(1, caseNo);
			// 4.ִ��sql���
			ResultSet resultSet = ps.executeQuery();
			// 5.ȡ������ֵ
			while (resultSet.next()) {
				PayInfoEntity payInfoEntity = new PayInfoEntity();
				payInfoEntity.setId(resultSet.getInt("id"));
				payInfoEntity.setCaseNo(resultSet.getString("case_no"));
				payInfoEntity.setPayMoney(resultSet.getInt("pay_money"));
				payInfoEntity.setPayNum(resultSet.getInt("pay_num"));
				payInfoEntity.setPayState(resultSet.getInt("pay_state"));
				
				
				// ��ȡ���ĵ������ݴ���list
				list.add(payInfoEntity);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}
	
	
	//�˷�ʱ
	public List<PayInfoEntity> getPayedInfoByCaseNo(String caseNo) {
		List<PayInfoEntity> list = new ArrayList<PayInfoEntity>();// ����PayInfoEntity��List����洢����
		// 1.����java�����ݿ������
		Connection connection = DBUtil.getConnection();
		// 2.�������ݿ����
		String sql = "SELECT pd.id, pd.case_no, pd.pay_money, pd.pay_num, pd.pay_state, di.dg_name, di.dg_spec, di.dg_price, di.dg_uit, r.rname, r.settle_type"
				+" FROM pay_info pd, drug_info di, register r "
				+" WHERE  pd.dg_id=di.id  AND r.case_no=pd.case_no AND pd.pay_state=1 AND pd.case_no=?";

		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			// 3.���ݲ���
			ps.setString(1, caseNo);
			// 4.ִ��sql���
			ResultSet resultSet = ps.executeQuery();
			// 5.ȡ������ֵ
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
				
				// ��ȡ���ĵ������ݴ���list
				list.add(payInfoEntity);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	public int payConfirm(String[] payData) {
		// ��ȡ����
		Connection connection = DBUtil.getConnection();
		// �������ݿ����
		String sql = "Update pay_info set pay_state=? where id=?";
		int result = 0;
		try {
			for (int i = 0; i < payData.length; i++) {
				PreparedStatement ps = connection.prepareStatement(sql);
				
				String item = payData[i];
				String data[] = item.split(",");
				int pId = Integer.parseInt(data[0]); //pay_info:id
				
				// 3.���ݲ���
				ps.setInt(1, 1);
				ps.setInt(2, pId);

				// 4.ִ��sql��� 5.ȡ������ֵ
				result = ps.executeUpdate();

			}
			return result;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public int unPayConfirm(String[] unPayData) {
		// ��ȡ����
				Connection connection = DBUtil.getConnection();
				// �������ݿ����
				String sql = "Update pay_info set pay_num=pay_num-?, pay_money=pay_num*?  where id=?";
				int result = 0;
				try {
					for (int i = 0; i < unPayData.length; i++) {
						String item = unPayData[i];
						String data[] = item.split(",");
						int pId = Integer.parseInt(data[0]); //pay_info:id
						int unPayNum = Integer.parseInt(data[1]);//�˿�����
						double price = Double.parseDouble(data[2]); //����
						
						PreparedStatement ps = connection.prepareStatement(sql);
						// 3.���ݲ���
						ps.setInt(1, unPayNum);
						ps.setDouble(2, price);
						ps.setInt(3, pId);

						// 4.ִ��sql��� 5.ȡ������ֵ
						result = ps.executeUpdate();

					}
					return result;

				} catch (SQLException e) {
					e.printStackTrace();
				}
				return result;
	}

}
