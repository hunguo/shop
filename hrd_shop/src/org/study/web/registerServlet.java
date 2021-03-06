package org.study.web;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.study.dao.hrdshopdao;
import org.study.model.Member;

/**
 * Servlet implementation class registerServlet
 */
@WebServlet("/register")
public class registerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private hrdshopdao dao = new hrdshopdao();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int memberId = 0;
		try {
			memberId = dao.getNextMemberId();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("next Member Id: " + memberId);
		request.setAttribute("id", memberId);
		request.getRequestDispatcher("/WEB-INF/view/register.jsp")
		.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String join_date = request.getParameter("join_date");
		String grade = request.getParameter("grade");
		String city_code = request.getParameter("city_code");
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
		java.util.Date utilDate = null;
		try {
			utilDate = format.parse(join_date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(id+","+name+","+phone+","+address+","+join_date+","+grade+","+city_code);
		
		Member member = new Member();
		member.setId(Integer.parseInt(id));
		member.setName(name);
		member.setPhone(phone);
		member.setAddress(address);
		member.setJoin_date(new Date(utilDate.getTime()));
		member.setGrade(grade);
		member.setCity_code(city_code);
		
		
		try {
			dao.registerMember(member);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.setStatus(HttpServletResponse.SC_OK);
	}

}
