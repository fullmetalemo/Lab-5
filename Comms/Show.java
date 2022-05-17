package com.polina.Comms;

import com.polina.Comms.Command;
import com.polina.Comms.CommandStatus;
import com.polina.Objects.ListPersons;

import java.util.List;

public class Show extends Command {
    public Show(){
        super(0);
    }
    @Override
    public CommandStatus Execute(List<String> args) {
        System.out.println(ListPersons.getInstance().getToStrings());
        return CommandStatus.OK;
    }
}
