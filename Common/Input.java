package com.polina.Common;

import com.polina.Comms.CommandStatus;
import com.polina.Objects.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Input {
    private static final Scanner scanner = new Scanner(System.in);

    public static String getLine(){
        return scanner.nextLine();
    }

    public static void InputCommandCircle(){
        String command;
        do {
            System.out.println("input command");
            command = scanner.nextLine();
            CommandStatus status = Executor.Execute(command);
            switch (status){
                case NOT_FOUND:
                    System.out.println("command is not found");
                    break;
                case OK:
                    System.out.println("command finished successfully");
                    break;
                case ARGS:
                    System.out.println("wrong amount of arguments");
                    break;
                case ARGS_NOT_TYPE:
                    System.out.println("types of arguments are not the same");
                    break;
                case OBJ_NOT_FOUND:
                    System.out.println("object is not found");
                    break;
            }
        }
        while (!command.toLowerCase(Locale.ROOT).startsWith("exit"));
    }

    public static Person InputPerson(){
        String name;
        Coordinates coordinates;
        LocalDateTime birth = null;
        Color color = null;
        Country country = null;
        double height = -1;
        Location location = null;

        do {
            System.out.println("input name");
            name = scanner.nextLine();
        }
        while (name.equals(""));

        coordinates = InputCoordinates();

        do {
            System.out.println("input height");
            try {
                height = Double.parseDouble(scanner.nextLine());
            }
            catch (Exception ignored){}
        }
        while (height <= 0);


        do {
            System.out.println("input date of birth");
            try {
                birth = LocalDateTime.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
            }
            catch (Exception ignored){}
        }
        while (birth == null);

        do {
            System.out.println("input color\n list of constants");
            try {
                for (Color colors : Color.values()){
                    System.out.println(colors);
                }
                color = Color.valueOf(scanner.nextLine());
            }
            catch (Exception ignored){}
        }
        while (color == null);

        do {
            System.out.println("input nationality\n list of constants");
            try {
                for (Country country1 : Country.values()){
                    System.out.println(country1);
                }
                country = Country.valueOf(scanner.nextLine());
            }
            catch (Exception ignored){}
        }
        while (country == null);


        location = InputLocation();

        return new Person(name, coordinates, height, birth, color, country, location);
    }
    public static Coordinates InputCoordinates(){
        System.out.println("creating coordinates");
        Double x = (double)850;
        Long y = (long)964;

        do {
            System.out.println("input x");
            try {
                x = Double.parseDouble(scanner.nextLine());
            }
            catch (Exception ignored){}
        }
        while (x >= 849);

        do {
            System.out.println("input y");
            try {
                y = Long.parseLong(scanner.nextLine());
            }
            catch (Exception ignored){}
        }
        while (y < -963);

        return new Coordinates(x,y);
    }

    public static Location InputLocation(){
        System.out.println("creating location");
        float x = 0;
        Float y = (float) 0;
        int z = 0;
        String name = "";

        boolean isX = false, isY = false, isZ = false;
        do {
            System.out.println("input x");
            try {
                x = Float.parseFloat(scanner.nextLine());
                isX = true;
            }
            catch (Exception ignored){}
        }
        while (!isX);

        do {
            System.out.println("input y");
            try {
                y = Float.parseFloat(scanner.nextLine());
                isY = true;
            }
            catch (Exception ignored){}
        }
        while (!isY);

        do {
            System.out.println("input z");
            try {
                z = Integer.parseInt(scanner.nextLine());
                isZ = true;
            }
            catch (Exception ignored){}
        }
        while (!isZ);

        do {
            System.out.println("input 'name' ");
            try {
                name = scanner.nextLine();
            }
            catch (Exception ignored){}
        }
        while (name == null || name.equals("") || name.length() > 465);

        return new Location(x,y,z,name);
    }

    public static LocalDateTime inputDate(){
        return LocalDateTime.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
    }
}
