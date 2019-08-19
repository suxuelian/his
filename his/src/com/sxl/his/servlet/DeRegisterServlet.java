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

//1. 继承HttpServlet
//2.重写doGet/doPost

@WebServlet("/deRegister")
public class DeRegisterServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 获取前台数据
		String no = req.getParameter("no");
		// 转型 String转int
		int id = Integer.parseInt(no);

		RegisterService registerService = new RegisterService();
		int result = registerService.updateRegister(id);

		PrintWriter out = resp.getWriter();
		if (result == 1) {
			// 挂号成功
			out.write("退号成功！");
		} else {
			// 挂号失败
			out.write("退号失败！");
		}
		out.flush();
		out.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
