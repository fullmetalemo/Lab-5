package com.polina.Comms;

import com.polina.Common.Input;
import com.polina.Comms.Command;
import com.polina.Comms.CommandStatus;
import com.polina.Objects.ListPersons;

import java.util.List;

public class Add extends Command {

    public Add(){
        super(0);
    }
    @Override
    public CommandStatus Execute(List<String> args) {
        ListPersons.getInstance().Add(Input.InputPerson());
        return CommandStatus.OK;
    }
}
