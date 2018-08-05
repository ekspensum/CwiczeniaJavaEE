package cwiczenia.jstl;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cwiczenia.dispatch.Uzytkownik;

/**
 * Servlet implementation class CwiczeniaJSTL
 */
@WebServlet("/CwiczeniaJSTL")
public class CwiczeniaJSTL extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CwiczeniaJSTL() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		Uzytkownik [] u = new Uzytkownik[15];
		u[0] = new Uzytkownik();
		u[0].setIdUser(0);
		u[0].setImie(null);
		u[0].setNazwisko("Kowalski");
		
		u[1] = new Uzytkownik();
		u[1].setIdUser(1);
		u[1].setImie("Bonifacy");
		u[1].setNazwisko("Śmiałowski");
		
		u[2] = new Uzytkownik();
		u[2].setIdUser(2);
		u[2].setImie("Ewa");
		u[2].setNazwisko("Krakowska");
		
//		List<Uzytkownik> lista = Arrays.asList(u);		
		request.setAttribute("users", u);

		request.setAttribute("kwota", 133.13);
		request.setAttribute("data", new Date());
		
		RequestDispatcher rd = request.getRequestDispatcher("cwiczeniaJSTL.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
