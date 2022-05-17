package com.polina.Comms;

import com.polina.Comms.Command;
import com.polina.Comms.CommandStatus;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Info extends Command {
    LocalDateTime time;
    public Info() {
        super(0);
        time = LocalDateTime.now();
    }

    @Override
    public CommandStatus Execute(List<String> args) {
        System.out.println("date of start: " + time.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
        System.out.println("to see list of all commands enter: help");
        return CommandStatus.OK;
    }
}
