package com.sxl.his.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.sxl.his.entity.PayInfoEntity;
import com.sxl.his.service.PayInfoService;

//1. �̳�HttpServlet
//2.��дdoGet/doPost

@WebServlet("/addpayInfo")
public class AddPayInfoServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// ��ȡǰ̨����(*��ȡ����ʹ��HttpServletReques.getParameterValues())
		String caseNo = req.getParameter("caseNo");
		String[] detailArr = req.getParameterValues("detailArr");
		System.out.println("caseNo:" + caseNo);

		// װ������
		List<PayInfoEntity> payInfoEntities = new ArrayList<PayInfoEntity>();
		for (int i = 0; i < detailArr.length; i++) {
			String item = detailArr[i];
			String[] data = item.split(",");
			System.out.println("dgNo:" + data[0] + "dgNum:" + data[1]);
			PayInfoEntity payInfoEntity = new PayInfoEntity();

			payInfoEntity.setDgId(Integer.parseInt(data[0]));
			payInfoEntity.setCaseNo(caseNo);
			payInfoEntity.setPayNum(Integer.parseInt(data[1]));
			payInfoEntity.setPrice(Double.parseDouble(data[2]));

			payInfoEntities.add(payInfoEntity);
		}

		int result = PayInfoService.addPayInfo(payInfoEntities);

		PrintWriter out = resp.getWriter();
		if (result == 1) {
			// ���۳ɹ�
			out.write("yes");
		} else {
			// ����ʧ��
			out.write("no");
		}
		out.flush();
		out.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
