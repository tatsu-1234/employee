package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Account;
import model.Login;
import model.LoginLogic;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String employeeId = request.getParameter("employeeId");
		String pass = request.getParameter("pass");

		Login login = new Login(employeeId, pass);
		LoginLogic bo = new LoginLogic();
		Account account = (Account) bo.execute(login);

		if (account != null) {
			HttpSession session = request.getSession();
			session.setAttribute("employeeId", login);

			ServletContext application = getServletContext();
			application.setAttribute("loginData", account);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/loginRs.jsp");
			dispatcher.forward(request, response);
		} else {
			response.sendRedirect("/employee/LoginServlet");
		}
	}
}