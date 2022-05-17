package com.polina.Comms;

import com.polina.Common.Input;
import com.polina.Comms.Command;
import com.polina.Comms.CommandStatus;
import com.polina.Objects.ListPersons;
import com.polina.Objects.Person;

import java.util.List;

public class Update extends Command {

    public Update(){
        super(1);
    }
    @Override
    public CommandStatus Execute(List<String> args) {
       try{
           int id = Integer.parseInt(args.get(0));
           for (Person person : ListPersons.getInstance().getPeople()) {
               if(person.getId() == id){
                   ListPersons.getInstance().Remove(person);
                   Person person1 = Input.InputPerson();
                   person1.setId(id);
                   ListPersons.getInstance().Add(person1);
                   return CommandStatus.OK;
               }
           }
           return CommandStatus.OBJ_NOT_FOUND;

       }
       catch (Exception e){
           return CommandStatus.ARGS_NOT_TYPE;
       }
    }
}
