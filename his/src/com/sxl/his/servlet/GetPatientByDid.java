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
import com.sxl.his.entity.RegisterEntity;
import com.sxl.his.service.DoctorService;
import com.sxl.his.service.RegisterService;

//1. 继承HttpServlet
//2.重写doGet/doPost

@WebServlet("/getPatient")
public class GetPatientByDid extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("doctorId");
		// String转int
		int doctorId = 0;
		
		if (!"".equals(id) && null != id) {
			// 不为空则转型
			doctorId = Integer.parseInt(id);
			//System.out.println("doctorId"+doctorId);
			RegisterService registerService = new RegisterService();

			// 根据doctorId查询所有所属挂号记录
			List<RegisterEntity> registerEntities = registerService.getRegisterByDid(doctorId);

			resp.setCharacterEncoding("utf-8"); // 解决前端乱码
			// 如果查询结果返回空，
			PrintWriter out = resp.getWriter();
			if (registerEntities.size() == 0) {
				out.write("当前没有挂号记录！");
			} else {
				// 将结果返回页面
				// 将返回类型转换成json字符串类型
				String dataJson = JSON.toJSONString(registerEntities);
				//System.out.println(dataJson);
				out.write(dataJson);
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
