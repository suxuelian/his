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

//1. �̳�HttpServlet
//2.��дdoGet/doPost
@WebServlet("/getDoctor")
public class GetDoctorServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//ȡֵ������Id
		String depId = req.getParameter("depId");
		int depNo = 0;
		//����idΪint�ͣ���Ҫת�ͣ�ת��ǰ��Ҫ�ж��Ƿ�Ϊ��
		if(!"".equals(depId) && null != depId){
			//��Ϊ����ת��
			depNo = Integer.parseInt(depId);
			DoctorService doctorService = new DoctorService();
			List<DoctorInfoEntity> doctorInfoList= doctorService.getDoctorByDep(depNo);
			//�����������
			resp.setCharacterEncoding("utf-8");
			
			PrintWriter out = resp.getWriter();
			//list��Ϊ��
			if(doctorInfoList.size() != 0){
				//������ת����JSON��ʽ
				String jsonStr = JSON.toJSONString(doctorInfoList);
				out.write(jsonStr);
			}else {
				out.write("��ҽ����Ϣ��");
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
