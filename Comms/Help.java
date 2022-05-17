package com.polina.Comms;

import com.polina.Common.Executor;

import java.util.List;

public class Help extends Command {

    public Help() {
        super(0);
    }

    @Override
    public CommandStatus Execute(List<String> args) {
        System.out.println(Executor.getInfoCommand());
        return CommandStatus.OK;
    }
}
