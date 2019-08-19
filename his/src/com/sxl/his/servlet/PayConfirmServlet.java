package com.sxl.his.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sxl.his.service.DrugService;
import com.sxl.his.service.PayInfoService;

//1. 继承HttpServlet
//2.重写doGet/doPost

@WebServlet("/payConfirm")
public class PayConfirmServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String[] payData = req.getParameterValues("payData");
		//System.out.println("ids:" + ids[0]);
		
		//1-修改pay_info的付款状态 
		int result = PayInfoService.payConfirm(payData);
		
		//2-减少库存对应药品数
		int invresult = DrugService.upDrugInv(payData);

		PrintWriter out = resp.getWriter();
		if (result == 1) {
			//付费成功
			out.write("yes");
		} else {
			//付费失败
			out.write("no");
		}
		out.flush();
		out.close();

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
