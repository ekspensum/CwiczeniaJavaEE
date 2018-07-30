package cwiczenia.filtry;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FiltrRegulowy implements Filter {

	public FiltrRegulowy() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		String opcje =  arg0.getParameter("opcje");	
		System.out.println("OPCJA "+opcje);
//		filtr przepusci opcję volvo wpisną do paska adresu (metodą GET)
		if (opcje != null && opcje.equals("volvo"))
			arg2.doFilter(arg0, arg1);
		
	}

}
