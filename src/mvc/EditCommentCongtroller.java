package mvc;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.GuestBookEntry;

@WebServlet("/mvc/EditComment")
public class EditCommentCongtroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	private GuestBookEntry getEntry(int id) {
		
		// Get a reference to the guest book
		ArrayList<GuestBookEntry> guestbookEntries = (ArrayList<GuestBookEntry>) getServletContext().getAttribute("guestbookEntries");
		
		// Find the entry who's id matches the id passed in
		for(GuestBookEntry entry : guestbookEntries) {
			if (entry.getId() == id)
				return entry;
		}
		
		return null;
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try {
			// Get a reference to the comment we want to edit
			int id = Integer.parseInt(request.getParameter("id"));
			GuestBookEntry entry = getEntry( id );
		
			// If the comment doesn't exist, redirect back to the main page (GuestBook)
			if (entry == null) {
				response.sendRedirect("GuestBook");
				return;
			}
			
			// Add the comment to the REQUEST scope			
			request.setAttribute("entry", entry);
		
			// Forward the request and response to the VIEW
			request.getRequestDispatcher("/WEB-INF/mvc/EditComment.jsp").forward(request, response);
		} catch(Exception e) {
			response.sendRedirect("GuestBook");
		}
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Read the values of name and message from the request
		String name = request.getParameter("name");
		String message = request.getParameter("message");
		
		boolean isValidName = name != null && name.trim().length() > 0;
		boolean isValidMessage = message != null && message.trim().length() > 0;
		
		if (isValidName && isValidMessage) {
			
			// Get a reference to the comment we want to edit
			int id = Integer.parseInt(request.getParameter("id"));
			GuestBookEntry entry = getEntry( id );
			entry.setName(name);
			entry.setMessage(message);
			
			// Redirect the User back to the main page
			response.sendRedirect("GuestBook");
		}
		else {
			
			if (!isValidName)
				request.setAttribute("nameError", "Please enter your name");
			
			if (!isValidMessage)
				request.setAttribute("messageError", "Please enter a message");
			
			
			doGet(request, response);
			return;
			
		}
		
	}

}
