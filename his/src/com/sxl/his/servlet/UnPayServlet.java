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
import com.sxl.his.entity.PayInfoEntity;
import com.sxl.his.entity.RegisterEntity;
import com.sxl.his.service.PayInfoService;
import com.sxl.his.service.RegisterService;

//1. 继承HttpServlet
//2.重写doGet/doPost

@WebServlet("/unpay")
public class UnPayServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String caseNo = req.getParameter("caseNo");
		int cn = 0;
		if(caseNo != ""){
			//不为空转int
			cn = Integer.parseInt(caseNo);
		}
		//System.out.println(caseNo);
	
	    
	    //获取单据号、总金额等信息
	    PayInfoService payInfoService = new PayInfoService();
	    List<PayInfoEntity> payInfoEntities= payInfoService.getPayedInfoByCaseNo(caseNo);
	    
	    resp.setCharacterEncoding("utf-8");	//解决前端乱码
		//如果查询结果返回空，
		PrintWriter out = resp.getWriter();
		if(payInfoEntities.size() == 0){
			out.write("no");
		}else{
			//将结果返回页面
			//将返回类型转换成json字符串类型
			String dataJson = JSON.toJSONString(payInfoEntities);
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
