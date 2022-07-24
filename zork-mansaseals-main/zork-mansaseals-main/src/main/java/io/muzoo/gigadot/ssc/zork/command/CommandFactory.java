package io.muzoo.gigadot.ssc.zork.command;

import io.muzoo.gigadot.ssc.zork.command.impl.*;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class CommandFactory {

    private static Map<CommandType, Command> commandMap = new HashMap<>();

    static {
        for (CommandType commandType : CommandType.values()){
            Command command = null;
            try {
                command = (Command) commandType.getCommandClass().getDeclaredConstructor().newInstance();
                commandMap.put(commandType, command);
            } catch (InstantiationException e ){
                e.printStackTrace();
            } catch (IllegalAccessException e){
                e.printStackTrace();
            } catch (InvocationTargetException e){
                e.printStackTrace();
            } catch (NoSuchMethodException e){
                e.printStackTrace();
            }
        }
        commandMap.put(CommandType.EXIT, new ExitCommand());
        commandMap.put(CommandType.INFO, new InfoCommand());
        commandMap.put(CommandType.TAKE, new TakeCommand());
        commandMap.put(CommandType.PLAY, new PlayCommand());
        commandMap.put(CommandType.USE, new UseCommand());
        commandMap.put(CommandType.DROP, new DropCommand());
        commandMap.put(CommandType.ATTACK_WITH, new AttackWithCommand());
        commandMap.put(CommandType.GO, new GoCommand());
        commandMap.put(CommandType.HELP, new HelpCommand());
        commandMap.put(CommandType.SAVE, new SaveCommand());
        commandMap.put(CommandType.LOAD, new LoadCommand());
        commandMap.put(CommandType.MAP, new MapCommand());
        commandMap.put(CommandType.QUIT, new QuitCommand());
    }
    public static Command get(CommandType commandType){
        return commandMap.get(commandType);

    }

}
