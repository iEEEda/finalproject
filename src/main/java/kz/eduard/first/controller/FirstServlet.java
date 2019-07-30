package kz.eduard.first.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kz.eduard.first.command.Command;
import kz.eduard.first.command.CommandFactory;

@WebServlet(urlPatterns = {"/controller", "*.do"})
public class FirstServlet extends HttpServlet {
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
      processPost(request, response);
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) // 2 KB
      throws ServletException, IOException {
        processPost(request, response);
  }

  private void processPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
        String page = null;
        Command command = CommandFactory.defineCommand(request.getParameter("command"));
        page = command.execute(request);
        if (page != null) {
          RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
          dispatcher.forward(request, response);
        } else {
          page = "/index.jsp";
          request.getSession().setAttribute("nullPage", "message.nullPage");
          response.sendRedirect(request.getContextPath() + page);
        }
      }

  private void processGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
  }
}