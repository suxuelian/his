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
import com.sxl.his.entity.RegisterEntity;
import com.sxl.his.service.DepService;
import com.sxl.his.service.RegisterService;

//1. �̳�HttpServlet
//2.��дdoGet/doPost
@WebServlet("/getRegister")
public class GetRegisterServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		RegisterService registerService = new RegisterService();
		//��ѯ���йҺż�¼
		List<RegisterEntity> registerEntities = registerService.getAllRegisterInfo();
		
		resp.setCharacterEncoding("utf-8");	//���ǰ������
		//�����ѯ������ؿգ�
		PrintWriter out = resp.getWriter();
		if(registerEntities.size() == 0){
			out.write("��ǰû�йҺż�¼��");
		}else{
			//���������ҳ��
			//����������ת����json�ַ�������
			String dataJson = JSON.toJSONString(registerEntities);
			//System.out.println(dataJson);
			out.write(dataJson);
		}
		out.flush();
		out.close();
	}
}
