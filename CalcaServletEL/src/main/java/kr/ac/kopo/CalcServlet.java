package kr.ac.kopo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CalcServlet")
public class CalcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/calc.html").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String left = request.getParameter("left");
		String op = request.getParameter("op");
		String right = request.getParameter("right");
		
		int result = 0;
		
		if("pls".equals(op))
			result = Integer.parseInt(left) + Integer.parseInt(right);
		else if("min".equals(op))
			result = Integer.parseInt(left) - Integer.parseInt(right);
		else if("mul".equals(op))
			result = Integer.parseInt(left) * Integer.parseInt(right);
		else if("div".equals(op))
			result = Integer.parseInt(left) / Integer.parseInt(right);
		
		request.setAttribute("left", left);
		request.setAttribute("op", op);
		request.setAttribute("right", right);
		
		request.setAttribute("result", result);
		request.getRequestDispatcher("/WEB-INF/views/result.jsp").forward(request, response);
	}

}
