package cwiczenia.serwlety;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Headers extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		res.setContentType("text/html; charset=utf-8");
		PrintWriter pw = res.getWriter();
		pw.write("<html><head><title>Nagłówki</title></head><body><body bgcolor=\"gray\">");
		Enumeration<String> nazwaNaglowkaReq = req.getHeaderNames();
		String nazwaReq = null;
		pw.println("<b>Nagłówki żądania: </b><br/>");
		while (nazwaNaglowkaReq.hasMoreElements()) {
			nazwaReq = nazwaNaglowkaReq.nextElement();
			Enumeration<String> wartosciReq = req.getHeaders(nazwaReq);
			while (wartosciReq.hasMoreElements())
				pw.println(nazwaReq + "  :  " + wartosciReq.nextElement() + "<br/>");
		}
		
		//Dodanie własnych nagłówków
		res.addHeader("Nazwa1", "wartosc1");
		res.addHeader("Nazwa2", "wartosc2");
		res.addIntHeader("Liczba", 22);
		
		
		pw.println("<br/>");
		pw.println("<b>Nagłówki odpowiedzi: </b><br/>");

		URL url = new URL("http://localhost:8080/Pierwszy/naglowki/");
		URLConnection urlConnection = url.openConnection();
		Map<String, List<String>> mapa = urlConnection.getHeaderFields();
		for (Map.Entry<String, List<String>> entry : mapa.entrySet())
			pw.println(entry.getKey() + " : " + entry.getValue() + "<br/>");
		
		pw.write("</body></html>");
	}
}
