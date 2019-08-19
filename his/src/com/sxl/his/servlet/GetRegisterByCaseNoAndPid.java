package com.sxl.his.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.sxl.his.entity.RegisterEntity;
import com.sxl.his.service.RegisterService;

//���ݲ����ź����֤�Ų�ѯ�Һ���Ϣ

//1. �̳�HttpServlet
//2.��дdoGet/doPost

@WebServlet("/getRegisterByCaseNoAndPid")
public class GetRegisterByCaseNoAndPid extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String caseno = req.getParameter("caseno");
		String idNo = req.getParameter("idcard");
		int caseNo = 0;

		if (!"".equals(caseno) && null != caseno) {
			// ��Ϊ����ת��
			caseNo = Integer.parseInt(caseno);
			RegisterService registerService = new RegisterService();
			RegisterEntity registerEntity = registerService.getRegisterByCaseNoAndPid(caseNo, idNo);

			// �������
			resp.setCharacterEncoding("utf-8");
			PrintWriter out = resp.getWriter();
			if (null != registerEntity) {
				// ������ת����JSON��ʽ
				String jsonStr = JSON.toJSONString(registerEntity);
				out.write(jsonStr);
			} else {
				out.write("null");
			}
			out.flush();
			out.close();
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
