package cwiczenia.serwlety;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Sesja extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		res.setContentType("text/html; charset=utf-8");
		PrintWriter pw = res.getWriter();
		HttpSession sesja = req.getSession();
		sesja.setMaxInactiveInterval(1200);
		pw.write("Id sesji: "+sesja.getId());
//		ServletContext kontekst = getServletContext();
//		synchronized (kontekst) {
//		kontekst.setAttribute("licznik1", "licznik1");			
//		}
//		sesja.invalidate();
		Integer licznik = (Integer) sesja.getAttribute("licznik");
		if(licznik == null)
			licznik = 1;
		else
			licznik++;
		pw.write("<html><head><title>Sesja</title></head><body><body bgcolor=\"gray\">");
		sesja.setAttribute("licznik", licznik);
		pw.write("<p>"+sesja.getAttribute("licznik")+"</p>");
		
		pw.write("<p>"+req.getContextPath()+"</p>");
		pw.write("<p>"+req.getRequestURI()+"</p>");
		pw.write("<p>"+req.getRequestURL().toString()+"</p>");
	
		pw.write("</body></html>");
	}
}
