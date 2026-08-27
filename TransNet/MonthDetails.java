import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.Scanner;

public class MonthDetails
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        // Input: Year and Month
        System.out.print("Enter Year (e.g., 2024): ");
        int year = scanner.nextInt();

        System.out.print("Enter Month (1-12): ");
        int month = scanner.nextInt();

        scanner.close();

        // Get number of days in the month
        YearMonth yearMonth = YearMonth.of(year, month);
        int daysInMonth = yearMonth.lengthOfMonth();

        // Get the first day of the month
        LocalDate firstDay = LocalDate.of(year, month, 1);
        DayOfWeek startDay = firstDay.getDayOfWeek();

        // Output results
        System.out.println("Month: " + month + ", Year: " + year);
        System.out.println("Number of days: " + daysInMonth);
        System.out.println("Starts on: " + startDay);
    }
}