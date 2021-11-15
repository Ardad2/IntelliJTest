package cse360.util;

import java.util.UUID;

public class RandomNumberUtil {
    static int counter = 0;

    public static int generateId(){
        counter++;
        return counter;
    }
    public static String  getRandomNumber(){
        return UUID.randomUUID().toString();


    }
}
