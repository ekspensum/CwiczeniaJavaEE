package cwiczenia.serwlety;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PierwszySerwlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
	 	res.setContentType("text/html; charset=utf-8");
		PrintWriter pw = res.getWriter();
		pw.println("<html><head><title>Pierwszy servlet</title></head>");
		pw.println("<body><body bgcolor=\"gray\"><ol><li>Powitanie.... ąćęłńóż</li>");
		pw.println("<li>Nazwa klasy: "+getClass()+"</li>");
	 	pw.println("<li>Nazwa serwleta: "+getServletName()+"</li>");
	 	pw.println("<li><a href=\"/Pierwszy/pobierz\">Pobierz obrazek</a></li>");
	 	pw.println("<li><a href=\"/Pierwszy/formularze\">Formularze</a></li>");
	 	pw.println("<li><a href=\"/Pierwszy/ciastka\">Ciastka</a></li>");
	 	pw.println("<li><a href=\"/Pierwszy/sesja\">Sesja</a></li>");
	 	pw.println("<li><a href=\"/Pierwszy/naglowki\">Nagłówki</a></li>");
	 	pw.println("<li><a href=\"/Pierwszy/witaj2\">Witaj2 - dispatch</a></li>");
	 	pw.println("<li><a href=\"/Pierwszy/drugi\">Uzytkownicy</a></li>");
	 	pw.println("</ol></body></html>");
	}

}
