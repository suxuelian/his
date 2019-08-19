package com.sxl.his.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sxl.his.entity.CaseInfoEntity;
import com.sxl.his.entity.RegisterEntity;
import com.sxl.his.service.CaseInfoService;
import com.sxl.his.service.RegisterService;

//1. �̳�HttpServlet
//2.��дdoGet/doPost

@WebServlet("/diagnose")
public class DiagnoseServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// ��ȡǰ̨����
		String cNo = req.getParameter("cNo"); // ������
		String cInfo = req.getParameter("cInfo"); // �����Ϣ

		// װ������
		CaseInfoService caseInfoService = new CaseInfoService();
		CaseInfoEntity caseInfoEntity = new CaseInfoEntity();
		caseInfoEntity.setcNo(cNo);
		caseInfoEntity.setcInfo(cInfo);

		//�����ϼ�¼
		int diaResult = caseInfoService.addCaseInfo(caseInfoEntity);
		//�޸ĹҺż�¼Ϊ�����
		//ת�� Stringתint
		int caseNo = Integer.parseInt(cNo);	
		RegisterService registerService = new RegisterService();
		int regResult = registerService.updateDiaStateRegister(caseNo);

		PrintWriter out = resp.getWriter();
		if (diaResult == 1) {
			// ��ϳɹ�
			out.write("��ϳɹ���");
		} else {
			// ���ʧ��
			out.write("���ʧ�ܣ�");
		}
		out.flush();
		out.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
