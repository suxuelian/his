package com.sxl.his.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sxl.his.entity.RegisterEntity;
import com.sxl.his.service.RegisterService;

//1. �̳�HttpServlet
//2.��дdoGet/doPost

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//��ȡǰ̨����
		String caseNo = req.getParameter("caseNo");
		String rname = req.getParameter("rname");
		//ת�� Stringתint
		int sex = Integer.parseInt(req.getParameter("sex"));
		int age = Integer.parseInt(req.getParameter("age"));
		String birthday = req.getParameter("birthday");
		int settleType = Integer.parseInt(req.getParameter("settleType"));
		String mcardNo = req.getParameter("mcardNo");
		int medicalType = Integer.parseInt(req.getParameter("medicalType"));
		String idCard = req.getParameter("idCard");
		String address = req.getParameter("address");
		String vistDate = req.getParameter("vistDate");
		int regLevel = Integer.parseInt(req.getParameter("regLevel"));
		int deptNo = Integer.parseInt(req.getParameter("deptNo"));
		int drId = Integer.parseInt(req.getParameter("drId"));
		int regPay = Integer.parseInt(req.getParameter("regPay"));
		int regSrc = Integer.parseInt(req.getParameter("regSrc"));
		
		//װ������
		RegisterService registerService = new RegisterService();
		RegisterEntity registerEntity = new RegisterEntity();
		registerEntity.setCaseNo(caseNo);
		registerEntity.setRname(rname);
		registerEntity.setSex(sex);
		registerEntity.setAge(age);
		registerEntity.setBirthday(birthday);
		registerEntity.setSettleType(settleType);
		registerEntity.setMcardNo(mcardNo);
		registerEntity.setMedicalType(medicalType);
		registerEntity.setIdCard(idCard);
		registerEntity.setAddress(address);
		registerEntity.setVistDate(vistDate);
		registerEntity.setRegLevel(regLevel);
		registerEntity.setDeptNo(deptNo);
		registerEntity.setDrId(drId);
		registerEntity.setRegPay(regPay);
		registerEntity.setRegSrc(regSrc);
		registerEntity.setDiagState(0);
		registerEntity.setRegState(0);
		
		
		int result = registerService.addRegister(registerEntity);
		
		PrintWriter out = resp.getWriter();
		if(result == 1){
			//�Һųɹ�
			out.write("�Һųɹ���");
		}else{
			//�Һ�ʧ��
			out.write("�Һ�ʧ�ܣ�");
		}
		out.flush();
		out.close();
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 doGet(req, resp);
	}
}
