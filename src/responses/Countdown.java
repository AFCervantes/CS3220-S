package responses;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/responses/Countdown")
public class Countdown extends HttpServlet {
	private static final long serialVersionUID = 1L;

	int count = 5;
	
	int delay = 1;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
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
		out.println("    <title>Countdown</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class=\"container\">");
		
		// Page-Specific Content Goes Here...
		out.println("<h1>Countdown</h1>");
		
		if (count > 0) {
			out.println("<p class=\"lead\">T-minus " + count + " second(s) and counting...</p>");
			--count;
			response.setIntHeader( "Refresh", delay );
		}
		else {
			out.println("<p class=\"lead text-danger\">Blast Off</p>");
			count = 5;
		}
		
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
