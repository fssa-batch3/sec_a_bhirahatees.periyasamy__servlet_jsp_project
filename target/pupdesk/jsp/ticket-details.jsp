<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.fssa.pupdesk.model.Ticket"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Ticket Preview</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
            margin: 0;
            padding: 0;
        }

        h1 {
            color: #333;
            text-align: center;
            padding: 20px 0;
        }

        .ticket-details {
            max-width: 600px;
            margin: 0 auto;
            background-color: #fff;
            padding: 20px;
            border: 1px solid #ddd;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        .ticket-details h2 {
            font-size: 24px;
            margin-bottom: 10px;
        }

        .ticket-details p {
            font-size: 16px;
            margin-bottom: 10px;
        }
    </style>
</head>
<body>
    <h1>Ticket Preview</h1>
    <div class="ticket-details">
        <%
        Ticket ticket = (Ticket) request.getAttribute("ticket");
        if (ticket != null) {
        %>
        <h2>Ticket Details</h2>
        <p><strong>Ticket ID:</strong> <%= ticket.getTicketId() %></p>
        <p><strong>Created Time:</strong> <%= ticket.getCreatedTime() %></p>
        <p><strong>From:</strong> <%= ticket.getFrom() %></p>
        <p><strong>To:</strong> <%= ticket.getTo() %></p>
        <p><strong>Summary:</strong> <%= ticket.getSummary() %></p>
        <p><strong>Description:</strong> <%= ticket.getDescription() %></p>
        <p><strong>Priority:</strong> <%= ticket.getPriority() %></p>
        <p><strong>Status:</strong> <%= ticket.getStatus() %></p>
        <p><strong>Closing Description:</strong> <%=ticket.getClosingDescription() %></p>
      <%} %>
    </div>
</body>
</html>
