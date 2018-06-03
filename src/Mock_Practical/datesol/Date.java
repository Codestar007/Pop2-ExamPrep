package Mock_Practical.datesol;

/**
 * Created by kjeged01 on 03/06/2018.
 */
public abstract class Date {
    private int day; // from 1 to 31
    private int month; // from 1 to 12
    private int year; // from 2000 upwards

    // Default date Q1
    public Date() {
        this(1, 1, 2000);
    }
    public Date(int day, int month, int year) {
        setDay(day);
        setMonth(month);
        setYear(year);
    }
    // "advance" to next day
    public void advance() {
        if (day < 31) {
            setDay(day + 1);
        } else {
            if (month < 12) {
                setDay(1);
                setMonth(month + 1);
            } else {
                setYear(year + 1);
                setMonth(1);
                setDay(1);
            }
        }
    }
    // Getters and setter Q2
    public int getDay() {
        return day;
    }
    public void setDay(int day) {
        this.day = day;
    }
    public int getMonth() {
        return month;
    }
    public void setMonth(int month) {
        this.month = month;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }

    // Question 3
    @Override
    public String toString() {
        return "Day " + day + " Month " + month + " Year " + year;
    }
    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (this == obj) return true;
        if (!(obj instanceof Date)) return false;
        Date d = (Date) obj;
        return this.getDay() == d.getDay()
                && this.getMonth() == d.getMonth()
                && this.getYear() == d.getYear();
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + getDay();
        result = prime * result + getMonth();
        result = prime * result + getYear();
        return result;
    }
}
