package com.sxl.his.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.sxl.his.entity.DoctorInfoEntity;
import com.sxl.his.service.DoctorService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

//1.导入servlet.jar包
//2.继承HttpServlet
//3.重写doGet/doPost

//控制层
//控制器，处理和接收前台传过来的数据
@WebServlet("/index")
//修改后台数据需要重启服务器，修改前端不需要重启
public class DoctorServlet extends HttpServlet{
	//快捷键 Alt+/
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String code = req.getParameter("code");
		String pwd = req.getParameter("pwd");
		//System.out.println("code:"+code+"  pwd:"+pwd);
		
		DoctorService ds = new DoctorService();
		DoctorInfoEntity di = ds.login(code, pwd);
		
		//解决返回值为中文时出现乱码问题
		resp.setCharacterEncoding("UTF-8");
		//返回到页面
		PrintWriter out = resp.getWriter();
		if(null == di){
			out.write("error");
		}else{
			String jsonStr = JSON.toJSONString(di);
			//System.out.println(jsonStr);
			//将后台数据返回给前端
			out.write(jsonStr);
		}
		
		out.flush();
		out.close();
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
