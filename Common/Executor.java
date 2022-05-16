package com.polina.Common;

import com.polina.Comms.*;

import java.util.*;
import java.util.stream.Collectors;

public class Executor {
    private static final HashSet<Command> commands = new HashSet<>();
    private static final List<String> comms = new ArrayList<>();

    static {
        commands.add(new Help());
        commands.add(new Add());
        commands.add(new Show());
        commands.add(new Info());
        commands.add(new Update());
        commands.add(new Remove());
        commands.add(new Clear());
        commands.add(new Add_If_Max());
        commands.add(new Remove_If_Max());
        commands.add(new History());
        commands.add(new Max_By_Height());
        commands.add(new Filter_By_Nationality());
        commands.add(new Filter_Greater_Then_Birthday());
        commands.add(new Execute_Command());
        commands.add(new Save());
    }

    public static String getCommandsHistory(){
        StringBuilder builder = new StringBuilder();
        for (String s : comms) {
            builder.append(s).append("\n");
        }
        return builder.toString();
    }

    public static CommandStatus Execute(String command){
        List<String> args = Arrays.stream(command.split(",")).collect(Collectors.toList());
        String commName = args.get(0).toLowerCase();
        args = args.subList(1, args.size());
        for (Command current : commands){
            if(commName.startsWith(current.getName())){
                if(current.getArgsCount() == args.size()) {
                    comms.add(commName);
                    if(comms.size() == 7){
                        comms.remove(0);
                    }
                    return current.Execute(args);
                }
                return CommandStatus.ARGS;
            }
        }
        return CommandStatus.NOT_FOUND;
    }

    public static String getInfoCommand(){
        StringBuilder builder = new StringBuilder("commands:\n");

        for (Command command : commands){
            builder.append(command.toString()).append("\n");
        }
        return builder.toString();
    }
}
