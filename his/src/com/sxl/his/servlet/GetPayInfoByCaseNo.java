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

//1. 继承HttpServlet
//2.重写doGet/doPost

@WebServlet("/getPayInfoByCaseNo")
public class GetPayInfoByCaseNo extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 取值，病历号caseNo
		String caseNo = req.getParameter("caseNo");
		
		PayInfoService payInfoService = new PayInfoService();
		List<PayInfoEntity> payInfoEntities= payInfoService.getPayInfoByCaseNo(caseNo);
		// 解决中文乱码
		resp.setCharacterEncoding("utf-8");

		PrintWriter out = resp.getWriter();
		// list不为空
		if (payInfoEntities.size() != 0) {
			// 将数据转换成JSON格式
			String jsonStr = JSON.toJSONString(payInfoEntities);
			out.write(jsonStr);
		} else {
			out.write("无信息！");
		}

		out.flush();
		out.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
