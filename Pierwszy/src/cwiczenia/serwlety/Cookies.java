package cwiczenia.serwlety;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Cookies extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		res.setContentType("text/html; charset=utf-8");
		PrintWriter pw = res.getWriter();
		pw.println("<html><head><title>Ciasteczka</title></head><body><body bgcolor=\"gray\">");
		pw.println("<form method=\"POST\" ><input type=\"text\" name=\"wartoscCiastka1\" /><input type=\"text\" name=\"wartoscCiastka2\" /><input type=\"submit\" value=\"OK\" /></form>");
		for (int i=0; i<req.getCookies().length; i++) {
//			if ("nazwaPolaCiastka1".equals(req.getCookies()[i].getName()))
				pw.println("<p>Ciastko: "+req.getCookies()[i].getValue()+"</p>");	
		}
		
		
		pw.println("</body></html>");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException , ServletException {
//		doGet(req, res);
		String wartoscCiastka1 = req.getParameter("wartoscCiastka1");
		String wartoscCiastka2 = req.getParameter("wartoscCiastka2");
		PrintWriter pw = res.getWriter();
		
		Cookie ciastko1 = new Cookie("nazwaPolaCiastka1", wartoscCiastka1);
		ciastko1.setMaxAge(20);
		res.addCookie(ciastko1);
		
		Cookie ciastko2 = new Cookie("nazwaPolaCiastka2", wartoscCiastka2);
		ciastko2.setMaxAge(40);
		res.addCookie(ciastko2);
		
		
		res.setContentType("text/html; charset=utf-8");
		pw.println("<html><head><title>Ciasteczka</title></head><body><body bgcolor=\"gray\">");
		pw.println("<p>"+wartoscCiastka1+"</p>");
		pw.println("<p>"+wartoscCiastka2+"</p>");
		pw.println("</body></html>");
	}
}
