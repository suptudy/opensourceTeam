/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package open_teamproject;

import java.util.Scanner;

public class App {
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        // 나중에 요일 관련된 것 함수화
        int year, month, day;
        Scanner sc = new Scanner(System.in);

        System.out.print("년도 : ");
        year = sc.nextInt();
        System.out.print("월 : ");
        month = sc.nextInt();
        System.out.print("일 : ");
        day = sc.nextInt();
        GetDayCalendar calendar = new GetDayCalendar(year, month, day);
        calendar.check();
    }
}
