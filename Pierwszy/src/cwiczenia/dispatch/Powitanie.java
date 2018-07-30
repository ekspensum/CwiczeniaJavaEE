package cwiczenia.dispatch;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Powitanie extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter pw = resp.getWriter();
		pw.write("<html><head><title>Formularze</title></head><body><body bgcolor=\"gray\">");
		pw.write("Przekazanie na servlet ListaUzytkownikow<br/>");
		

		
		String nazwa = "jakaś nazwa";
		req.setAttribute("nazwa", nazwa);
		
//		RequestDispatcher rd = req.getRequestDispatcher("/drugi");
		RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
		rd.include(req, resp);
//		rd.forward(req, resp);

//		Przekierowanie na inną stronę:
//		resp.sendRedirect("/Pierwszy/drugi");
//		resp.sendRedirect("/Pierwszy/formularze");
//		resp.sendRedirect("http://www.google.pl");
		
		
		
		pw.write("</body></html>");
	}
}
