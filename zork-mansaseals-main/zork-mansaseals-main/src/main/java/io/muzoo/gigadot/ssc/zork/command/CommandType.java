package io.muzoo.gigadot.ssc.zork.command;

import io.muzoo.gigadot.ssc.zork.command.impl.*;

public enum CommandType {

  INFO(InfoCommand.class, "info"),
  EXIT(ExitCommand.class, "exit"),
  TAKE(TakeCommand.class, "take"),
  PLAY(PlayCommand.class, "play"),
  USE(UseCommand .class, "use"),
  DROP(DropCommand.class, "drop"),
  ATTACK_WITH(AttackWithCommand.class, "attack with"),
  GO(GoCommand.class, "go"),
  HELP(HelpCommand.class, "help"),
  SAVE(SaveCommand.class, "save"),
  MAP(MapCommand.class, "map"),
  LOAD(LoadCommand.class, "load"),
  QUIT(ExitCommand.class, "quit");



  private Class<? extends Command> commandClass;

  private String commandWord;

  public String getCommandWord() {
    return commandWord;
  }

  CommandType(Class<? extends Command> commandClass,String commandWord) {
    this.commandClass = commandClass;
    this.commandWord = commandWord;

  }

  public Class getCommandClass(){
    return commandClass;
  }

  public boolean match(String rawInput){
    return rawInput.startsWith(commandWord);
  }


}
