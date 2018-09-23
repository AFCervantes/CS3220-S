package intro;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns= {"/intro/CurrentDateAndTime"}, loadOnStartup=1)
public class CurrentDateAndTime extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
		// Create a local variable
		int count = 0;
		
		// Get a reference to the Application Scope (ServletContext)
		ServletContext context = this.getServletContext();
		
		// Store the count in the application scope
		context.setAttribute("dateAndTimeCounter", count);  // Auto Boxing		
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		ServletContext context = getServletContext();
		
		// Get a reference to the current count
		int currentCount = (Integer) context.getAttribute("dateAndTimeCounter"); // Auto Unboxing
		
		// Increment the count
		currentCount++;
		
		// Put the updated count back into the application scope
		context.setAttribute("dateAndTimeCounter", currentCount);
		
		// Set the content type to HTML
		response.setContentType("text/html");
		
		// Get a reference to the output stream
		PrintWriter out = response.getWriter();
		
		// Generate our HTML
		out.println("<!DOCTYPE html>");
		out.println("<html lang=\"en\">");
		out.println("<head>");
		out.println("    <meta charset=\"UTF-8\">");
		out.println("	 <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\" integrity=\"sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO\" crossorigin=\"anonymous\">");
		out.println("    <title>Current Date and Time</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class=\"container\">");
		
		out.println("<h1>Current Date &amp; Time</h1>");
		out.println("<p class=\"lead\">The current date and time is: " + new Date() + "</p>");
		out.println("<a class=\"btn btn-primary\" href=\"DateAndTimeMetrics\">Metrics</a>");
		
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
