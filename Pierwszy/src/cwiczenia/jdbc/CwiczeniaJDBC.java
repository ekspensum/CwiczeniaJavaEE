package cwiczenia.jdbc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.jdbc.Driver;



/**
 * Servlet implementation class CwiczeniaJDBC
 */
@WebServlet("/CwiczeniaJDBC")
public class CwiczeniaJDBC extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw = response.getWriter();
		try {
			Driver sterownik = new com.mysql.cj.jdbc.Driver();
			DriverManager.registerDriver(sterownik);
			Connection conn = sterownik.connect("jdbc:mysql://localhost/javaee?user=root&password=123&characterEncoding=utf8&serverTimezone=UTC", null);
			Statement stat = conn.createStatement();
			if(stat.execute("SELECT * from users")) {
				ResultSet zbior = stat.getResultSet();
				while(zbior.next())
				pw.println(zbior.getString(1) + " " + zbior.getString(2) + " " + zbior.getString(3) + "<br/>");
			}
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		RequestDispatcher rd = request.getRequestDispatcher("formularz.jsp");
		rd.include(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Driver sterownik = new com.mysql.cj.jdbc.Driver();
			DriverManager.registerDriver(sterownik);
			Connection conn = sterownik.connect("jdbc:mysql://localhost/javaee?user=root&password=123&characterEncoding=utf8&serverTimezone=UTC", null);
			PreparedStatement ps = conn.prepareStatement("INSERT INTO users VALUES(null, ?, ?)");
			ps.setString(1, request.getParameter("imie"));
			ps.setString(2, request.getParameter("nazwisko"));
			if(ps.executeUpdate() > 0) {
				doGet(request, response);
				request.setAttribute("komunikaty", "Dodano nowego użytkownika");
				RequestDispatcher rd = request.getRequestDispatcher("komunikaty.jsp");
				rd.include(request, response);
			}
			conn.close();			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
