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
import org.study.model.Sale;

/**
 * Servlet implementation class saleServlet
 */
@WebServlet("/sale_list")
public class saleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private hrdshopdao dao = new hrdshopdao();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 try {
				List<Sale> list = dao.getsaleList();
				System.out.println(list.size());
				request.setAttribute("list", list);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
				
				request.getRequestDispatcher("/WEB-INF/view/sale_list.jsp")
				.forward(request, response);
	}
}
