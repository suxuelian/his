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
//根据病历号查询挂号信息

//1. 继承HttpServlet
//2.重写doGet/doPost

@WebServlet("/getRegisterByCaseNo")
public class GetRegisterByCaseNo extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String caseno = req.getParameter("caseno");
		int caseNo = 0;

		if (!"".equals(caseno) && null != caseno) {
			// 不为空则转型
			caseNo = Integer.parseInt(caseno);
			RegisterService registerService = new RegisterService();
			RegisterEntity registerEntity = registerService.getRegisterByCaseNo(caseNo);

			// 解决乱码
			resp.setCharacterEncoding("utf-8");
			PrintWriter out = resp.getWriter();
			if (null != registerEntity) {
				// 将数据转换成JSON格式
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
