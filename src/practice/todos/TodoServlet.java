package practice.todos;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/practice/todo")
public class TodoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
//		ArrayList<Todo> todos = new ArrayList<Todo>();
//		todos.add(new Todo("Create a todo list"));
//		todos.add(new Todo("Check an item off of my todo list"));
//		
//		getServletContext().setAttribute("todos", todos);
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Set my content type
		response.setContentType("text/html");
		
		// Get a reference to the Print Writer
		PrintWriter out = response.getWriter();
		
		// Generate our content
		out.println("<!DOCTYPE html>");
		out.println("<html lang=\"en\">");
		out.println("<head>");
		out.println("    <meta charset=\"UTF-8\">");
		out.println("    <title>Todo</title>");
		out.println("    <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\" integrity=\"sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO\" crossorigin=\"anonymous\">");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class=\"container\">");
		
		out.println("<h1>Todo</h1>");
		
		out.println("<p class=\"text-right\">");
		out.println(" <a href=\"???\" class=\"btn btn-success\">Remove Completed Todos</a>");
		out.println("</p>");
		
//		ArrayList<Todo> todos = (ArrayList<Todo>) getServletContext().getAttribute("todos");
		
		// Get a reference to the session. If it doesn't exist, create it.
		HttpSession session = request.getSession();
		
		// Does the array list of todos exist in the session?
		if (session.getAttribute("todos") == null)
			session.setAttribute("todos", new ArrayList<Todo>());
		
		// Get a reference to the todo list in the session
		ArrayList<Todo> todos = (ArrayList<Todo>) session.getAttribute("todos");
		
		
		out.println("<table class=\"table table-hover\">");
		
		for(Todo todo : todos) {
			out.println("<tr>");
			
			out.println("  <td>");			
			
			if (todo.isDone())
				out.println("<s>" + todo.getDescription() + "</s>");
			else
				out.println(todo.getDescription());
						
			out.println("  </td>");
			
			
			out.println("  <td>");			
			out.println("	 <a class=\"btn btn-primary\" href=\"toggleDone?id=" + todo.getId() + "\">");
			if(todo.isDone())
				out.println("Mark as Not Complete");
			else
				out.println("Mark as Complete");
			out.println("	</a>");							
			out.println("  </td>");
			
			out.println("</tr>");
		}
		
		out.println("</table>");
		out.println("<hr>");
		out.println("<form action=\"todo\" method=\"post\">");
		out.println("  <input type=\"text\" name=\"description\" placeholder=\"Enter a new todo\">");
		out.println("  <input type=\"submit\" value=\"Add Todo\">");
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String description = request.getParameter("description");
		
		if (description != null && description.trim().length() >= 0) {
//			ArrayList<Todo> todos = (ArrayList<Todo>) getServletContext().getAttribute("todos");
			ArrayList<Todo> todos = (ArrayList<Todo>) request.getSession().getAttribute("todos");
			todos.add(new Todo(description));
		}
		
		doGet(request, response);
	}

}






