package com.polina.Comms;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JSR310Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.polina.Common.Executor;
import com.polina.Main;
import com.polina.Objects.ListPersons;

import java.io.*;
import java.text.DateFormat;
import java.util.List;

public class Save extends Command{

    public Save(){
        super(1);
    }
    @Override
    public CommandStatus Execute(List<String> args) {
        try{
            File file = new File(args.get(0));
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file));

            outputStreamWriter.write(Main.mapper.writeValueAsString(ListPersons.getInstance()));
            outputStreamWriter.close();

            return CommandStatus.OK;
        }
        catch (Exception e){
            e.printStackTrace();
            return CommandStatus.OBJ_NOT_FOUND;
        }
    }
}
