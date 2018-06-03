/**
 * Created by kjeged01 on 03/06/2018.
 */
public class TimeRecordSolution {
    private static final int MINSINHOUR = 60;
    private int hours;
    private int minutes; // 0 <= minutes < 60
    public void add(TimeRecordSolution extraTime) {
        minutes += extraTime.getMinutes();
        if (minutes >= MINSINHOUR) {
            minutes -= MINSINHOUR;
            hours++;
        }
        hours += extraTime.getHours();
    }
    public int getHours() {
        return hours;
    }
    public void setHours(int hours) {
        this.hours = hours;
    }
    public int getMinutes() {
        return minutes;
    }
    public void setMinutes(int minutes) {
        if (minutes < 0 || minutes >= MINSINHOUR)
            throw new IllegalArgumentException();
        this.minutes = minutes;
    }

    public static void main(String[] args) {
        TimeRecordSolution exTime = new TimeRecordSolution();
            exTime.add(exTime);
            System.out.println(
                    + exTime.getHours() + " Hours and "
                    + exTime.getMinutes() +  " Minutes");
    }
}
