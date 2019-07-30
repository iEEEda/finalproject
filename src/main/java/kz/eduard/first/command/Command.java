package kz.eduard.first.command;

import javax.servlet.http.HttpServletRequest;

public interface Command {
  String execute(HttpServletRequest request);
}
