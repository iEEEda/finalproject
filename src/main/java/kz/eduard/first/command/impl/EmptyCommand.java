package kz.eduard.first.command.impl;

import javax.servlet.http.HttpServletRequest;
import kz.eduard.first.command.Command;

public class EmptyCommand implements Command {
  @Override
  public String execute(HttpServletRequest request) {
    return "/index.jsp";
  }
}
