package signupproject;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
@WebServlet("/test")
public class SignUpServlet extends HttpServlet {
  @Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	  String username=req.getParameter("username");
	  int password=Integer.parseInt(req.getParameter("password"));
	  
	  ConfigurableApplicationContext configurableApplicationContext=new AnnotationConfigApplicationContext(My_Config.class);
	   Users users=(Users)configurableApplicationContext.getBean("users");
	   users.setName(username);
	   users.setId(password); 
	   
	   EntityManager entityManager=(EntityManager)configurableApplicationContext.getBean("entityManager");
	    entityManager.getTransaction().begin();
	    entityManager.persist(users);
	    entityManager.getTransaction().commit();
}
}
