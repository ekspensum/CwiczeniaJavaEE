package cwiczenia.serwlety;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Pobieranie extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		byte [] plik = pobierzPlik("C:\\Users\\Andrzej\\Pictures\\Tapety\\0124a.jpg");
		res.setContentType("image/jpg");
		res.setContentLength(plik.length);
		res.addHeader("Content-Disposition", "attachment;filename=obraz.jpg");
		OutputStream os = res.getOutputStream();
		os.write(plik);
		os.flush();	
	}
	
	private byte[] pobierzPlik(String nazwaPliku) throws IOException {
		File f = new File(nazwaPliku);
		FileInputStream fis = new FileInputStream(f);
		long rozmiar = f.length();
		byte [] zawartosc = new byte[(int)rozmiar];
		fis.read(zawartosc);
		fis.close();
		return zawartosc;
	}
}
