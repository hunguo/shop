package org.study.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.study.dao.hrdshopdao;
import org.study.model.Member;

/**
 * Servlet implementation class member_listServlet
 */
@WebServlet("/member_list")
public class member_listServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private hrdshopdao dao = new hrdshopdao();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 try {
		List<Member> list = dao.getMemberList();
		request.setAttribute("list", list);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		
		request.getRequestDispatcher("/WEB-INF/view/member_list.jsp")
		.forward(request, response);
	}

}
