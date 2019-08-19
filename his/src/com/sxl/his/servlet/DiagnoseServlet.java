package com.sxl.his.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sxl.his.entity.CaseInfoEntity;
import com.sxl.his.entity.RegisterEntity;
import com.sxl.his.service.CaseInfoService;
import com.sxl.his.service.RegisterService;

//1. 继承HttpServlet
//2.重写doGet/doPost

@WebServlet("/diagnose")
public class DiagnoseServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 获取前台数据
		String cNo = req.getParameter("cNo"); // 病历号
		String cInfo = req.getParameter("cInfo"); // 诊断信息

		// 装载数据
		CaseInfoService caseInfoService = new CaseInfoService();
		CaseInfoEntity caseInfoEntity = new CaseInfoEntity();
		caseInfoEntity.setcNo(cNo);
		caseInfoEntity.setcInfo(cInfo);

		//添加诊断记录
		int diaResult = caseInfoService.addCaseInfo(caseInfoEntity);
		//修改挂号记录为已诊断
		//转型 String转int
		int caseNo = Integer.parseInt(cNo);	
		RegisterService registerService = new RegisterService();
		int regResult = registerService.updateDiaStateRegister(caseNo);

		PrintWriter out = resp.getWriter();
		if (diaResult == 1) {
			// 诊断成功
			out.write("诊断成功！");
		} else {
			// 诊断失败
			out.write("诊断失败！");
		}
		out.flush();
		out.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
