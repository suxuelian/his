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

//1. �̳�HttpServlet
//2.��дdoGet/doPost

@WebServlet("/getAllGrugs")
public class GetAllGrugsServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//��ѯ���п���
		List<DrugInfoEntity> drugInfoList = DrugService.getAllDrugs();
		
		resp.setCharacterEncoding("utf-8");	//���ǰ������
		//�����ѯ������ؿգ�
		PrintWriter out = resp.getWriter();
		if(drugInfoList.size() == 0){
			out.write("��ǰû��ҩƷ��");
		}else{
			//���������ҳ��
			//����������ת����json�ַ�������
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
