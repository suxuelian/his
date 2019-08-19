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
import com.sxl.his.entity.DrugInfoEntity;
import com.sxl.his.service.DoctorService;
import com.sxl.his.service.DrugService;

//1. �̳�HttpServlet
//2.��дdoGet/doPost

@WebServlet("/getDrugById")
public class GetDrugByIdServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// ȡֵ��dgId
		String id = req.getParameter("dgId");
		int dgId = 0;
		// ����idΪint�ͣ���Ҫת�ͣ�ת��ǰ��Ҫ�ж��Ƿ�Ϊ��
		if (!"".equals(id) && null != id) {
			// ��Ϊ����ת��
			dgId = Integer.parseInt(id);
			DrugService drugService = new DrugService();
			DrugInfoEntity drugInfoEntity = drugService.getDrugById(dgId);
			// �����������
			resp.setCharacterEncoding("utf-8");

			PrintWriter out = resp.getWriter();
			// ��Ϊ��
			if (drugInfoEntity != null) {
				// ������ת����JSON��ʽ
				String jsonStr = JSON.toJSONString(drugInfoEntity);
				out.write(jsonStr);
			} else {
				out.write("��ҩƷ��Ϣ��");
			}

			out.flush();
			out.close();
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
