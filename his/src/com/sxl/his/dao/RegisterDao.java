package com.sxl.his.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sxl.his.entity.DepartmentEntity;
import com.sxl.his.entity.RegisterEntity;
import com.sxl.his.util.DBUtil;

//持久层，和数据库做交互
//数据库代管者
public class RegisterDao {

	// 添加挂号信息-s
	public int addRegister(RegisterEntity registerEntity) {
		// 1.创建java与数据库的连接
		Connection connection = DBUtil.getConnection();
		// 2.创建数据库操作
		String sql = "INSERT INTO `his`.`register` (`case_no`, `rname`, `sex`, `age`, `birthday`, `settle_type`, `mcard_no`, `medical_type`, `id_card`, `address`, `vist_date`, `reg_level`, `dept_no`, `dr_id`, `reg_pay`, `reg_src`, `diag_state`, `reg_state`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			// 3.传递参数
			ps.setString(1, registerEntity.getCaseNo());
			ps.setString(2, registerEntity.getRname());
			ps.setInt(3, registerEntity.getSex());
			ps.setInt(4, registerEntity.getAge());
			ps.setString(5, registerEntity.getBirthday());
			ps.setInt(6, registerEntity.getSettleType());
			ps.setString(7, registerEntity.getMcardNo());
			ps.setInt(8, registerEntity.getMedicalType());
			ps.setString(9, registerEntity.getIdCard());
			ps.setString(10, registerEntity.getAddress());
			ps.setString(11, registerEntity.getVistDate());
			ps.setInt(12, registerEntity.getRegLevel());
			ps.setInt(13, registerEntity.getDeptNo());
			ps.setInt(14, registerEntity.getDrId());
			ps.setInt(15, registerEntity.getRegPay());
			ps.setInt(16, registerEntity.getRegSrc());
			ps.setInt(17, registerEntity.getDiagState());
			ps.setInt(18, registerEntity.getRegState());
			// 4.执行sql语句
			int result = ps.executeUpdate();
			// 5.取出返回值
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	// 添加挂号信息-e

	// 得到所有挂号信息-s
	public List<RegisterEntity> getAllRegisterInfo() {
		// 获取连接
		Connection connection = DBUtil.getConnection();
		// 创建数据库操作
		String sql = "SELECT * FROM register";
		PreparedStatement preparedStatement = null;
		List<RegisterEntity> list = new ArrayList<RegisterEntity>();

		try {
			preparedStatement = connection.prepareStatement(sql);
			// 执行SQL
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				RegisterEntity registerEntity = new RegisterEntity();

				registerEntity.setCaseNo(resultSet.getString("case_no"));
				registerEntity.setRname(resultSet.getString("rname"));
				registerEntity.setSex(resultSet.getInt("sex"));
				registerEntity.setAge(resultSet.getInt("age"));
				registerEntity.setBirthday(resultSet.getString("birthday"));
				registerEntity.setSettleType(resultSet.getInt("settle_type"));
				registerEntity.setMcardNo(resultSet.getString("mcard_no"));
				registerEntity.setMedicalType(resultSet.getInt("medical_type"));
				registerEntity.setIdCard(resultSet.getString("id_card"));
				registerEntity.setAddress(resultSet.getString("address"));
				registerEntity.setVistDate(resultSet.getString("vist_date"));
				registerEntity.setRegLevel(resultSet.getInt("reg_level"));
				registerEntity.setDeptNo(resultSet.getInt("dept_no"));
				registerEntity.setDrId(resultSet.getInt("dr_id"));
				registerEntity.setRegPay(resultSet.getInt("reg_pay"));
				registerEntity.setRegSrc(resultSet.getInt("reg_src"));
				registerEntity.setDiagState(resultSet.getInt("diag_state"));
				registerEntity.setRegState(resultSet.getInt("reg_state"));
				// 将取出的DepartmentEntity装到List集合
				list.add(registerEntity);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	// 得到所有挂号信息-e

	// 根据病人id查询挂号信息-start
	public RegisterEntity getRegisterByPid(String pid) {
		RegisterEntity registerEntity = new RegisterEntity();
		// 获取连接
		Connection connection = DBUtil.getConnection();
		// 创建数据库操作
		String sql = "SELECT * FROM register WHERE id_card=?";
		PreparedStatement preparedStatement = null;

		try {
			preparedStatement = connection.prepareStatement(sql);
			// 传递参数
			preparedStatement.setString(1, pid);
			// 执行SQL
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				registerEntity.setCaseNo(resultSet.getString("case_no"));
				registerEntity.setRname(resultSet.getString("rname"));
				registerEntity.setSex(resultSet.getInt("sex"));
				registerEntity.setAge(resultSet.getInt("age"));
				registerEntity.setBirthday(resultSet.getString("birthday"));
				registerEntity.setSettleType(resultSet.getInt("settle_type"));
				registerEntity.setMcardNo(resultSet.getString("mcard_no"));
				registerEntity.setMedicalType(resultSet.getInt("medical_type"));
				registerEntity.setIdCard(resultSet.getString("id_card"));
				registerEntity.setAddress(resultSet.getString("address"));
				registerEntity.setVistDate(resultSet.getString("vist_date"));
				registerEntity.setRegLevel(resultSet.getInt("reg_level"));
				registerEntity.setDeptNo(resultSet.getInt("dept_no"));
				registerEntity.setDrId(resultSet.getInt("dr_id"));
				registerEntity.setRegPay(resultSet.getInt("reg_pay"));
				registerEntity.setRegSrc(resultSet.getInt("reg_src"));
				registerEntity.setDiagState(resultSet.getInt("diag_state"));
				registerEntity.setRegState(resultSet.getInt("reg_state"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return registerEntity;
	}
	// 根据病人id查询挂号信息-end

	// 更新挂号状态信息-s
	public int updateRegister(int id) {
		RegisterEntity registerEntity = new RegisterEntity();
		// 获取连接
		Connection connection = DBUtil.getConnection();
		// 创建数据库操作
		String sql = "Update register set reg_state=? where case_no=?";
		PreparedStatement preparedStatement = null;

		try {
			preparedStatement = connection.prepareStatement(sql);
			// 传递参数
			preparedStatement.setInt(1, 1);
			preparedStatement.setInt(2, id);
			// 执行SQL
			preparedStatement.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 1;
	}
	// 更新挂号信息-e

	// 根据doctorId查询挂号信息-s
	public List<RegisterEntity> getRegisterByDid(int doctorId) {
		// 获取连接
		Connection connection = DBUtil.getConnection();
		// 创建数据库操作
		String sql = "SELECT * FROM register WHERE dr_id=? AND reg_state=?";
		PreparedStatement preparedStatement = null;
		List<RegisterEntity> list = new ArrayList<RegisterEntity>();
		//System.out.println("RegisterDao.getAwaitingRegisterByDid()");
		try {
			preparedStatement = connection.prepareStatement(sql);
			// 传递参数
			preparedStatement.setInt(1, doctorId);
			preparedStatement.setInt(2, 0); // 未退号
			// 执行SQL
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				//System.out.println("new record");
				RegisterEntity registerEntity = new RegisterEntity();

				registerEntity.setCaseNo(resultSet.getString("case_no"));
				registerEntity.setRname(resultSet.getString("rname"));
				registerEntity.setSex(resultSet.getInt("sex"));
				registerEntity.setAge(resultSet.getInt("age"));
				registerEntity.setBirthday(resultSet.getString("birthday"));
				registerEntity.setSettleType(resultSet.getInt("settle_type"));
				registerEntity.setMcardNo(resultSet.getString("mcard_no"));
				registerEntity.setMedicalType(resultSet.getInt("medical_type"));
				registerEntity.setIdCard(resultSet.getString("id_card"));
				registerEntity.setAddress(resultSet.getString("address"));
				registerEntity.setVistDate(resultSet.getString("vist_date"));
				registerEntity.setRegLevel(resultSet.getInt("reg_level"));
				registerEntity.setDeptNo(resultSet.getInt("dept_no"));
				registerEntity.setDrId(resultSet.getInt("dr_id"));
				registerEntity.setRegPay(resultSet.getInt("reg_pay"));
				registerEntity.setRegSrc(resultSet.getInt("reg_src"));
				registerEntity.setDiagState(resultSet.getInt("diag_state"));
				registerEntity.setRegState(resultSet.getInt("reg_state"));
				// 将取出的DepartmentEntity装到List集合
				list.add(registerEntity);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	// 根据doctorId查询挂号信息-e

	// 根据caseNo查询待号信息-s
	public RegisterEntity getRegisterByCaseNo(int caseNo) {
		RegisterEntity registerEntity = new RegisterEntity();
		// 获取连接
		Connection connection = DBUtil.getConnection();
		// 创建数据库操作
		String sql = "SELECT * FROM register WHERE case_no=?";
		PreparedStatement preparedStatement = null;

		try {
			preparedStatement = connection.prepareStatement(sql);
			// 传递参数
			preparedStatement.setInt(1, caseNo);
			// 执行SQL
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				registerEntity.setCaseNo(resultSet.getString("case_no"));
				registerEntity.setRname(resultSet.getString("rname"));
				registerEntity.setSex(resultSet.getInt("sex"));
				registerEntity.setAge(resultSet.getInt("age"));
				registerEntity.setBirthday(resultSet.getString("birthday"));
				registerEntity.setSettleType(resultSet.getInt("settle_type"));
				registerEntity.setMcardNo(resultSet.getString("mcard_no"));
				registerEntity.setMedicalType(resultSet.getInt("medical_type"));
				registerEntity.setIdCard(resultSet.getString("id_card"));
				registerEntity.setAddress(resultSet.getString("address"));
				registerEntity.setVistDate(resultSet.getString("vist_date"));
				registerEntity.setRegLevel(resultSet.getInt("reg_level"));
				registerEntity.setDeptNo(resultSet.getInt("dept_no"));
				registerEntity.setDrId(resultSet.getInt("dr_id"));
				registerEntity.setRegPay(resultSet.getInt("reg_pay"));
				registerEntity.setRegSrc(resultSet.getInt("reg_src"));
				registerEntity.setDiagState(resultSet.getInt("diag_state"));
				registerEntity.setRegState(resultSet.getInt("reg_state"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return registerEntity;
	}
	// 根据caseNo查询待号信息-e

	// 更新诊断状态信息-s
	public int updateDiaStateRegister(int caseNo) {
		RegisterEntity registerEntity = new RegisterEntity();
		// 获取连接
		Connection connection = DBUtil.getConnection();
		// 创建数据库操作
		String sql = "Update register set diag_state=? where case_no=?";
		PreparedStatement preparedStatement = null;

		try {
			preparedStatement = connection.prepareStatement(sql);
			// 传递参数
			preparedStatement.setInt(1, 1);
			preparedStatement.setInt(2, caseNo);
			// 执行SQL
			preparedStatement.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 1;
	}
	// 更新诊断状态信息-e

	//根据caseNo和idCard查询挂号信息-s
	public RegisterEntity getRegisterByCaseNo(int caseNo, String idNo) {
		RegisterEntity registerEntity = new RegisterEntity();
		// 获取连接
		Connection connection = DBUtil.getConnection();
		// 创建数据库操作
		String sql = "SELECT * FROM register WHERE case_no=? AND id_card=?";
		PreparedStatement preparedStatement = null;

		try {
			preparedStatement = connection.prepareStatement(sql);
			// 传递参数
			preparedStatement.setInt(1, caseNo);
			preparedStatement.setString(2, idNo);
			// 执行SQL
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				registerEntity.setCaseNo(resultSet.getString("case_no"));
				registerEntity.setRname(resultSet.getString("rname"));
				registerEntity.setSex(resultSet.getInt("sex"));
				registerEntity.setAge(resultSet.getInt("age"));
				registerEntity.setBirthday(resultSet.getString("birthday"));
				registerEntity.setSettleType(resultSet.getInt("settle_type"));
				registerEntity.setMcardNo(resultSet.getString("mcard_no"));
				registerEntity.setMedicalType(resultSet.getInt("medical_type"));
				registerEntity.setIdCard(resultSet.getString("id_card"));
				registerEntity.setAddress(resultSet.getString("address"));
				registerEntity.setVistDate(resultSet.getString("vist_date"));
				registerEntity.setRegLevel(resultSet.getInt("reg_level"));
				registerEntity.setDeptNo(resultSet.getInt("dept_no"));
				registerEntity.setDrId(resultSet.getInt("dr_id"));
				registerEntity.setRegPay(resultSet.getInt("reg_pay"));
				registerEntity.setRegSrc(resultSet.getInt("reg_src"));
				registerEntity.setDiagState(resultSet.getInt("diag_state"));
				registerEntity.setRegState(resultSet.getInt("reg_state"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return registerEntity;
	}
	//根据caseNo和idCard查询挂号信息-s
}
