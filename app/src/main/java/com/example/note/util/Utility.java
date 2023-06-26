package com.example.note.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Utility {

    public static String getCurrentTimeStamp(){
        try{
            SimpleDateFormat dateFormat = new SimpleDateFormat("MMM yyyy", Locale.getDefault());
            String currentDateTime = dateFormat.format(new Date());
            return currentDateTime;
        }catch(Exception e){
            return null;
        }

    }

}
