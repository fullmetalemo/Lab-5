package com.polina;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.polina.Common.Executor;
import com.polina.Common.Input;
import com.polina.Comms.CommandStatus;
import com.polina.Comms.Save;
import com.polina.Objects.*;

import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.util.List;

public class Main {
    public static XmlMapper mapper = XmlMapper.builder().addModule(new JavaTimeModule()).defaultUseWrapper(false).configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false).build();

    public static void main(String[] args){
        String path = System.getenv().get("pathh");
        System.out.println(path);
        try{
            File file = new File(path);
            if(file.exists()) {
                InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file));
                StringBuilder builder = new StringBuilder();
                int data = inputStreamReader.read();
                while (data != -1) {
                    builder.append((char) data);
                    data = inputStreamReader.read();
                }
                ListPersons.setInstance(mapper.readValue(builder.toString(), ListPersons.class));
            }
            else{
                System.out.println("file doesn`t exist");
                ListPersons.setInstance(new ListPersons());
            }
        }
        catch (Exception e){
            System.out.println("file doesn`t exist");
            ListPersons.setInstance(new ListPersons());
        }
        Input.InputCommandCircle();
    }
}
