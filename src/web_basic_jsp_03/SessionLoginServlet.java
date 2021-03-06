package web_basic_jsp_03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/JSP/ch03/SessionLogin")
public class SessionLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		
		if (id.equals("java") && passwd.equals("java")) {
			HttpSession session = request.getSession();
			session.setAttribute("id", id);
			//클라이언트의 주소를 변경 (forwarding)
			RequestDispatcher dispatcher = request.getRequestDispatcher("menu.jsp");
			dispatcher.forward(request, response);
		} else {
			out.println ("<script>");
			out.println ("alter('아이디나 비밀번호가 일치하지 않습니다.')");
			out.println ("history.back()");
			out.println ("</script>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
