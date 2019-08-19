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
import com.sxl.his.service.DoctorService;

//1. 继承HttpServlet
//2.重写doGet/doPost
@WebServlet("/getDoctor")
public class GetDoctorServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//取值，科室Id
		String depId = req.getParameter("depId");
		int depNo = 0;
		//科室id为int型，需要转型，转型前需要判断是否为空
		if(!"".equals(depId) && null != depId){
			//不为空则转型
			depNo = Integer.parseInt(depId);
			DoctorService doctorService = new DoctorService();
			List<DoctorInfoEntity> doctorInfoList= doctorService.getDoctorByDep(depNo);
			//解决中文乱码
			resp.setCharacterEncoding("utf-8");
			
			PrintWriter out = resp.getWriter();
			//list不为空
			if(doctorInfoList.size() != 0){
				//将数据转换成JSON格式
				String jsonStr = JSON.toJSONString(doctorInfoList);
				out.write(jsonStr);
			}else {
				out.write("无医生信息！");
			}
			
			out.flush();
			out.close();
		}
		DoctorService doctorService = new DoctorService();
		doctorService.getDoctorByDep(depNo);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
