package com.sxl.his.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sxl.his.service.DrugService;
import com.sxl.his.service.PayInfoService;

//1. �̳�HttpServlet
//2.��дdoGet/doPost

@WebServlet("/unPayConfirm")
public class UnPayConfirmServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String[] unPayData = req.getParameterValues("unPayData");

		// 1-�޸�pay_info��pay_num��pay_money
		int result = PayInfoService.unPayConfirm(unPayData);

		// 2-���ٿ���ӦҩƷ��
		int invresult = DrugService.downDrugInv(unPayData);

		PrintWriter out = resp.getWriter();
		if (result == 1) {
			// ���ѳɹ�
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
