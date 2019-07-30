package kz.eduard.first.command;

import kz.eduard.first.command.impl.EmptyCommand;

public class CommandFactory {
  //private static final Logger LOGGER = LogManager.getLogger(CommandFactory.class);

  public static Command defineCommand(String action) {
    Command current = null;
    if (action == null || action.isEmpty()) {
      return new EmptyCommand();
    }
    try {
      CommandType currentType = CommandType.valueOf(action.toUpperCase());
      current = currentType.getCommand();
    } catch (IllegalArgumentException e) {
      //LOGGER.e(e);
    }
    return current;
  }
}
