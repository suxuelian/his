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

//1.����servlet.jar��
//2.�̳�HttpServlet
//3.��дdoGet/doPost

//���Ʋ�
//������������ͽ���ǰ̨������������
@WebServlet("/index")
//�޸ĺ�̨������Ҫ�������������޸�ǰ�˲���Ҫ����
public class DoctorServlet extends HttpServlet{
	//��ݼ� Alt+/
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String code = req.getParameter("code");
		String pwd = req.getParameter("pwd");
		//System.out.println("code:"+code+"  pwd:"+pwd);
		
		DoctorService ds = new DoctorService();
		DoctorInfoEntity di = ds.login(code, pwd);
		
		//�������ֵΪ����ʱ������������
		resp.setCharacterEncoding("UTF-8");
		//���ص�ҳ��
		PrintWriter out = resp.getWriter();
		if(null == di){
			out.write("error");
		}else{
			String jsonStr = JSON.toJSONString(di);
			//System.out.println(jsonStr);
			//����̨���ݷ��ظ�ǰ��
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
