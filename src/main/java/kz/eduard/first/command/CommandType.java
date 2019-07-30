package kz.eduard.first.command;

import kz.eduard.first.command.impl.LoginCommand;
import kz.eduard.first.command.impl.LogoutCommand;

public enum CommandType {
  LOGIN(new LoginCommand()), LOGOUT(new LogoutCommand());

  CommandType(Command command) {
    this.command = command;
  }

  private Command command;

  public Command getCommand() {
    return command;
  }
}
