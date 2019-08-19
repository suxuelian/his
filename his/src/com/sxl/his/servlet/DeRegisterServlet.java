package com.sxl.his.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sxl.his.entity.RegisterEntity;
import com.sxl.his.service.RegisterService;

//1. �̳�HttpServlet
//2.��дdoGet/doPost

@WebServlet("/deRegister")
public class DeRegisterServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// ��ȡǰ̨����
		String no = req.getParameter("no");
		// ת�� Stringתint
		int id = Integer.parseInt(no);

		RegisterService registerService = new RegisterService();
		int result = registerService.updateRegister(id);

		PrintWriter out = resp.getWriter();
		if (result == 1) {
			// �Һųɹ�
			out.write("�˺ųɹ���");
		} else {
			// �Һ�ʧ��
			out.write("�˺�ʧ�ܣ�");
		}
		out.flush();
		out.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
