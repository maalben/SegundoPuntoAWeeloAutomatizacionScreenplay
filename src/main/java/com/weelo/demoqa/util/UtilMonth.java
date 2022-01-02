package com.weelo.demoqa.util;

public class UtilMonth {

    public static String getMonth(String month){

        switch (month){
            case "01":
                month = "January";
                break;

            case "02":
                month = "February";
                break;

            case "03":
                month = "March";
                break;

            case "04":
                month = "April";
                break;

            case "05":
                month = "May";
                break;

            case "06":
                month = "June";
                break;

            case "07":
                month = "July";
                break;

            case "08":
                month = "August";
                break;

            case "09":
                month = "September";
                break;

            case "10":
                month = "October";
                break;

            case "11":
                month = "November";
                break;

            case "12":
                month = "December";
                break;
        }
        return month;
    }

    public static String dateValidation(String date){
        String[] splitDate = date.split("-");
        String day = splitDate[0];
        int value = Integer.parseInt(day);
        day = String.valueOf(value);
        String month = splitDate[1];
        String year = splitDate[2];

        return splitDate[0]+" "+getMonth(month)+","+year;
    }

}
