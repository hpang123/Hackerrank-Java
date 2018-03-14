package hackerrank.java.Introduction;

import java.util.Calendar;
import java.util.Scanner;

/*
 * https://www.hackerrank.com/challenges/java-date-and-time/problem
 */
public class DateTime {

	public static void main(String[] args) {
		String[] WEEK = { "SUNDAY", "MONDAY", "TUESDAY", "WEDNESDAY",
				"THURSDAY", "FRIDAY", "SATURDAY" };
		Scanner in = new Scanner(System.in);
		String month = in.next();
		String day = in.next();
		String year = in.next();
		Calendar cal = Calendar.getInstance();
		cal.set(Integer.parseInt(year), Integer.parseInt(month) - 1,
				Integer.parseInt(day));
		String day_of_week = WEEK[cal.get(Calendar.DAY_OF_WEEK) - 1];
		System.out.println(day_of_week);

	}
}
