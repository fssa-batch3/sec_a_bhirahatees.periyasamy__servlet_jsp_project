package com.fssa.pupdesk.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

import com.fssa.pupdesk.model.Ticket;
import com.fssa.pupdesk.services.TicketService;
import com.fssa.pupdesk.services.exceptions.ServiceException;

/**
 * Servlet implementation class CreateeTicketServlet
 */
@WebServlet("/CreateTicketServlet")
public class CreateTicketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateTicketServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String fromEmail = request.getParameter("from_email");
		String toEmail = request.getParameter("to_email");
		String summary = request.getParameter("summary");
		String priority = request.getParameter("priority");
		String description = request.getParameter("description");
		PrintWriter out = response.getWriter();
		TicketService ticketService = new TicketService();
		try {
			ticketService.createTicketService(new Ticket(fromEmail,
					toEmail, summary, priority, "Open",
					description));
			out.println("Ticket Created !");
		} catch (ServiceException e) {
			out.println("Failed To Create Ticket " + e.getMessage());
		}
	}

}