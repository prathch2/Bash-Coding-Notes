/****************************************************************************
 * Customer.java
 ****************************************************************************
 * This is a class that creates a customized date from user input or returns
 * a default date. The class also has methods that can help you advance a day
 * ahead of your date and a week ahead of your date. It also tests for leap
 * years. The class has a method that allows you to compare different objects
 * with this class object.
 *_____________________________________________________
 * Pratham Choksi
 * 03/05/2021
 * CMSC 256-004
 ****************************************************************************/

package cmsc256;

import java.text.DecimalFormat;

public class CustomDate implements Comparable<CustomDate> {
    private int day;
    private int month;
    private int year;


    public CustomDate() {
        this.day = 1;
        this.month = 1;
        this.year = 1900;
    }

    public CustomDate(int newMonth, int newDay, int newYear) {
        setMonth(newMonth);
        setYear(newYear);
        setDay(newDay);
    }

    public CustomDate(String newMonth, int newDay, int newYear) {
        setMonth(newMonth);
        setYear(newYear);
        setDay(newDay);
    }

    public void setYear(int year) throws IllegalArgumentException {
        if (year <= 0 || year > 9999) {
            throw new IllegalArgumentException("This year is invalid");
        }
        this.year = year;
    }

    public void setMonth(int month) throws IllegalArgumentException {
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("This month is invalid");
        }
        this.month = month;
    }

    public void setMonth(String month) throws IllegalArgumentException {
        int month1 = 0;
        if (month.equalsIgnoreCase("January")) {
            month = "1";
            month1 = Integer.parseInt(month);
        } else if (month.equalsIgnoreCase("February")) {
            month = "2";
            month1 = Integer.parseInt(month);
        } else if (month.equalsIgnoreCase("March")) {
            month = "3";
            month1 = Integer.parseInt(month);
        } else if (month.equalsIgnoreCase("April")) {
            month = "4";
            month1 = Integer.parseInt(month);
        } else if (month.equalsIgnoreCase("May")) {
            month = "5";
            month1 = Integer.parseInt(month);
        } else if (month.equalsIgnoreCase("June")) {
            month = "6";
            month1 = Integer.parseInt(month);
        } else if (month.equalsIgnoreCase("July")) {
            month = "7";
            month1 = Integer.parseInt(month);
        } else if (month.equalsIgnoreCase("August")) {
            month = "8";
            month1 = Integer.parseInt(month);
        } else if (month.equalsIgnoreCase("September")) {
            month = "9";
            month1 = Integer.parseInt(month);
        } else if (month.equalsIgnoreCase("October")) {
            month = "10";
            month1 = Integer.parseInt(month);
        } else if (month.equalsIgnoreCase("November")) {
            month = "11";
            month1 = Integer.parseInt(month);
        } else if (month.equalsIgnoreCase("December")) {
            month = "12";
            month1 = Integer.parseInt(month);
        } else {
            throw new IllegalArgumentException("This month is invalid");
        }
        this.month = month1;
    }

    public void setDay(int day) throws IllegalArgumentException {
        if (day < 1) {
            throw new IllegalArgumentException("This day is invalid");
        }
        if (month == 1 && day > 31) {
            throw new IllegalArgumentException("This day is invalid");
        }
        if ((month == 2 && day > 29 && isLeapYear()) || (month == 2 && day > 28 && !isLeapYear())) {
            throw new IllegalArgumentException("This day is invalid");
        }
        if (month == 3 && day > 31) {
            throw new IllegalArgumentException("This day is invalid");
        }
        if (month == 4 && day > 30) {
            throw new IllegalArgumentException("This day is invalid");
        }
        if (month == 5 && day > 31) {
            throw new IllegalArgumentException("This day is invalid");
        }
        if (month == 6 && day > 30) {
            throw new IllegalArgumentException("This day is invalid");
        }
        if (month == 7 && day > 31) {
            throw new IllegalArgumentException("This day is invalid");
        }
        if (month == 8 && day > 31) {
            throw new IllegalArgumentException("This day is invalid");
        }
        if (month == 9 && day > 30) {
            throw new IllegalArgumentException("This day is invalid");
        }
        if (month == 10 && day > 31) {
            throw new IllegalArgumentException("This day is invalid");
        }
        if (month == 11 && day > 30) {
            throw new IllegalArgumentException("This day is invalid");
        }
        if (month == 12 && day > 31) {
            throw new IllegalArgumentException("This day is invalid");
        }
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }


    //used DecimalFormat to add zeros for a date less that 4 digits
    public String toString() {
        DecimalFormat df = new DecimalFormat("0000");
        String format = df.format(year);

        if (month < 10 && day > 9) {
            return "0" + month + "/" + day + "/" + format;
        }
        if (month > 9 && day < 10) {
            return month + "/" + "0" + day + "/" + format;
        }
        if (month < 10 && day < 10) {
            return "0" + month + "/" + "0" + day + "/" + format;
        }
        return month + "/" + day + "/" + format;
    }

    public boolean isLeapYear() {
        if (year % 100 == 0 && year % 400 == 0) {
            return true;
        } else if (year % 4 == 0 && year % 100 != 0) {
            return true;
        } else {
            return false;
        }
    }

    public void advanceOneDay() {
        if (month == 12 && day == 31) {
            month = 1;
            day = 1;
            year += 1;
        } else if (month == 11 && day == 30) {
            month = 12;
            day = 1;
        } else if (month == 10 && day == 31) {
            month = 11;
            day = 1;
        } else if (month == 9 && day == 30) {
            month = 10;
            day = 1;
        } else if (month == 8 && day == 31) {
            month = 9;
            day = 1;
        } else if (month == 7 && day == 31) {
            month = 8;
            day = 1;
        } else if (month == 6 && day == 30) {
            month = 7;
            day = 1;
        } else if (month == 5 && day == 31) {
            month = 6;
            day = 1;
        } else if (month == 4 && day == 30) {
            month = 5;
            day = 1;
        } else if (month == 3 && day == 31) {
            month = 4;
            day = 1;
        } else if (month == 2 && day == 29 && isLeapYear() || month == 2 && day == 28 && !isLeapYear()) {
            month = 3;
            day = 1;
        } else if (month == 1 && day == 31) {
            month = 2;
            day = 1;
        } else {
            day++;
        }
    }

    public void advanceOneWeek() {
        for (int i = 0; i < 7; i++) {
            advanceOneDay();
        }
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CustomDate) {
            CustomDate object = (CustomDate) obj;
            if(year == object.year && day == object.day && month == object.month) {
                return true;
            }
        }
        return false;
    }


    public int compareTo(CustomDate o) {
        if ((day == o.day && month == o.month && year == o.year)) {
            return 0;
        }
        if ((day > o.day && month == o.month && year == o.year) || (month > o.month) || (year > o.year)) {
            return 1;
        }
        return -1;
    }
}
