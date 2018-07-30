package cwiczenia.dispatch;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListaUzytkownikow extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter pw = resp.getWriter();
		pw.write("<html><head><title>Użytkownicy</title></head><body><body bgcolor=\"gray\">");
		pw.write("Servlet: "+ req.getServletPath());
		
		Uzytkownik u = new Uzytkownik();
		u.setIdUser(1);
		u.setImie("Adam");
		u.setNazwisko("Nowak");
		req.setAttribute("uzytkownik", u);
		
		RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
//		rd.include(req, resp);
		rd.forward(req, resp);
		
		pw.write("</body></html>");
		
	}
}
