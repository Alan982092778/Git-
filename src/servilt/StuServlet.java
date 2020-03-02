package servilt;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import enity.Stu;
import service.StuService;
import service.impl.StuServiceimpl;
@WebServlet("/Find")
public class StuServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//·ÀÖ¹ÂÒÂë
		req.setCharacterEncoding("UTF-8");
		StuService ss=new StuServiceimpl();
		List<Stu> list=ss.find();
		req.getSession().setAttribute("list", list);
		req.getRequestDispatcher("index.jsp").forward(req, resp);
	}
	
}
