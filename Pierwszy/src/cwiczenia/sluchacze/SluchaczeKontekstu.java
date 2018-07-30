package cwiczenia.sluchacze;

import java.util.Date;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


public class SluchaczeKontekstu implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		 System.out.println("Koniec aplikacji: "+ new Date());
		ServletContextListener.super.contextDestroyed(sce);
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {

		System.out.println("Start aplikacji: "+ new Date());
		ServletContextListener.super.contextInitialized(sce);
	}


}
