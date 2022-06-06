package open_teamproject;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class GetDayCalendar {
    private int year, month, day;
    String[] result = { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };

    public GetDayCalendar(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public String check() { // 요일 확인
        LocalDate date = LocalDate.of(year, month, day);
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        int dayOfWeekNum = dayOfWeek.getValue();
        return result[dayOfWeekNum];
    }

}
