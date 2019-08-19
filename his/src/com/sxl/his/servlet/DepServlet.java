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
import com.sxl.his.service.DepService;

//1. �̳�HttpServlet
//2.��дdoGet/doPost

@WebServlet("/dep")
public class DepServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//��ѯ���п���
		List<DepartmentEntity> departmentList = DepService.getAllDep();
		
		resp.setCharacterEncoding("utf-8");	//���ǰ������
		//�����ѯ������ؿգ�
		PrintWriter out = resp.getWriter();
		if(departmentList.size() == 0){
			out.write("��ǰû�п��ң�");
		}else{
			//���������ҳ��
			//����������ת����json�ַ�������
			String dataJson = JSON.toJSONString(departmentList);
			//System.out.println(dataJson);
			out.write(dataJson);
		}
		out.flush();
		out.close();
	}
	
}
