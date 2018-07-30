package cwiczenia.serwlety;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FiltrSerwlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		PrintWriter pw = resp.getWriter();
		resp.setContentType("text/html; charset=utf-8");
		pw.write("<html><head><title>Filtr</title></head><body><body bgcolor=\"gray\">");
		pw.write("<p>Wybrana opcja to: "+req.getParameter("opcje")+"</p>");
		pw.write("</body></html>");
	}
}
