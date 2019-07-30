package kz.eduard.first.command.impl;

import javax.servlet.http.HttpServletRequest;
import kz.eduard.first.command.Command;

public class LogoutCommand implements Command {
  @Override
  public String execute(HttpServletRequest request) {
      request.getSession().invalidate();
      return "/index.jsp";
  }
}
