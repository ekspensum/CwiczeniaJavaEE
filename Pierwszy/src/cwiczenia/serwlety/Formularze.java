package cwiczenia.serwlety;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Formularze extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter pw = response.getWriter().append("Served at: ").append(request.getContextPath());
		pw.println("<html><head><title>Formularze</title></head><body><body bgcolor=\"gray\">");
		pw.println("<p>Formularze</p>");
	 	pw.println("<form method=\"get\"><input type=\"text\" name=\"imie\" /><input type=\"submit\" value=\"OK\" /></form>");
	 	
	 	String imie = request.getParameter("imie");
	 	System.out.println("Imie "+imie);
	 	pw.println("<p>Twoje imie wysłane metodą GET: "+imie+"</p>");

	 	pw.println("<form method=\"post\"><select name=\"opcje\" />"
				+ "<option value=\"volvo\">Volvo</option>\r\n" + 
				"  <option value=\"saab\">Saab</option>\r\n" + 
				"  <option value=\"fiat\">Fiat</option>\r\n" + 
				"  <option value=\"audi\">Audi</option>\r\n" + 
				"  </select>\r\n" +
				"  <input type=\"submit\" value=\"Wyślij\" />\r\n" +
				"  </form>");
	 	pw.println("</body></html>");
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doGet(request, response);
		response.setContentType("text/html; charset=utf-8");
		String wartosc = request.getParameter("opcje");
		PrintWriter pw = response.getWriter();
		
		request.setAttribute("wartosc", wartosc);
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.include(request, response);
		
		pw.println("<html><head><title>Formularze</title></head><body><body bgcolor=\"gray\">");
		pw.println("<p>Wybrana opcja: "+wartosc+"</p></body></html>");
	}

}
