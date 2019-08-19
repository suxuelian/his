package com.sxl.his.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.sxl.his.entity.DoctorInfoEntity;
import com.sxl.his.entity.PayInfoEntity;
import com.sxl.his.service.DoctorService;
import com.sxl.his.service.PayInfoService;

//1. �̳�HttpServlet
//2.��дdoGet/doPost

@WebServlet("/getPayInfoByCaseNo")
public class GetPayInfoByCaseNo extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// ȡֵ��������caseNo
		String caseNo = req.getParameter("caseNo");
		
		PayInfoService payInfoService = new PayInfoService();
		List<PayInfoEntity> payInfoEntities= payInfoService.getPayInfoByCaseNo(caseNo);
		// �����������
		resp.setCharacterEncoding("utf-8");

		PrintWriter out = resp.getWriter();
		// list��Ϊ��
		if (payInfoEntities.size() != 0) {
			// ������ת����JSON��ʽ
			String jsonStr = JSON.toJSONString(payInfoEntities);
			out.write(jsonStr);
		} else {
			out.write("����Ϣ��");
		}

		out.flush();
		out.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
