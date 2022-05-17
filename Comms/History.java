package com.polina.Comms;

import com.polina.Common.Executor;
import com.polina.Comms.Command;
import com.polina.Comms.CommandStatus;

import java.util.List;

public class History extends Command {
    public History(){
        super(0);
    }
    @Override
    public CommandStatus Execute(List<String> args) {
        System.out.println(Executor.getCommandsHistory());
        return CommandStatus.OK;
    }
}
