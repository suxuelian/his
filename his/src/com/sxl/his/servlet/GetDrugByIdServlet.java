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
import com.sxl.his.entity.DrugInfoEntity;
import com.sxl.his.service.DoctorService;
import com.sxl.his.service.DrugService;

//1. 继承HttpServlet
//2.重写doGet/doPost

@WebServlet("/getDrugById")
public class GetDrugByIdServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 取值，dgId
		String id = req.getParameter("dgId");
		int dgId = 0;
		// 科室id为int型，需要转型，转型前需要判断是否为空
		if (!"".equals(id) && null != id) {
			// 不为空则转型
			dgId = Integer.parseInt(id);
			DrugService drugService = new DrugService();
			DrugInfoEntity drugInfoEntity = drugService.getDrugById(dgId);
			// 解决中文乱码
			resp.setCharacterEncoding("utf-8");

			PrintWriter out = resp.getWriter();
			// 不为空
			if (drugInfoEntity != null) {
				// 将数据转换成JSON格式
				String jsonStr = JSON.toJSONString(drugInfoEntity);
				out.write(jsonStr);
			} else {
				out.write("无药品信息！");
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
