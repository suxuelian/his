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

//根据病人身份证号查询挂号记录

//1. 继承HttpServlet
//2.重写doGet/doPost

@WebServlet("/getRegisterByPid")
public class GetRegisterByPid extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RegisterService registerService = new RegisterService();
		String pid = req.getParameter("pid");
		RegisterEntity registerEntity = registerService.getRegisterByPid(pid);
		
		//解决乱码
		resp.setCharacterEncoding("utf-8");
		PrintWriter out = resp.getWriter();
		if (null != registerEntity) {
			//将数据转换成JSON格式
			String jsonStr = JSON.toJSONString(registerEntity);
			out.write(jsonStr);
		}else {
			out.write("当前病人无挂号信息");
		}
		out.flush();
		out.close();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
}
