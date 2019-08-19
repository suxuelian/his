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
import com.sxl.his.entity.DepartmentEntity;
import com.sxl.his.entity.DrugInfoEntity;
import com.sxl.his.service.DepService;
import com.sxl.his.service.DrugService;

//1. 继承HttpServlet
//2.重写doGet/doPost

@WebServlet("/getAllGrugs")
public class GetAllGrugsServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//查询所有科室
		List<DrugInfoEntity> drugInfoList = DrugService.getAllDrugs();
		
		resp.setCharacterEncoding("utf-8");	//解决前端乱码
		//如果查询结果返回空，
		PrintWriter out = resp.getWriter();
		if(drugInfoList.size() == 0){
			out.write("当前没有药品！");
		}else{
			//将结果返回页面
			//将返回类型转换成json字符串类型
			String dataJson = JSON.toJSONString(drugInfoList);
			//System.out.println(dataJson);
			out.write(dataJson);
		}
		out.flush();
		out.close();
	}
	
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
