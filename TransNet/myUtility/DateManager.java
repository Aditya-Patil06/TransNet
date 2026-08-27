package myUtility;

public class DateManager
{
	private int Day	 ;
	private int Month;
	private int Year ;

	public void setDay( int Day)
	{
		this.Day = Day ;
	}
	public int getDay()
	{
		return Day;
	}
	public void setMonth( int Month)
	{
		this.Month = Month ;
	}
	public int getMonth()
	{
		return Month;
	}
	public void setYear( int Year)
	{
		this.Year = Year ;
	}
	public int getYear()
	{
		return Year;
	}

	public static DateManager convertToDate(String strDate)
	{
		DateManager a = new DateManager();

		String dateString = strDate;
		String[] dateParts = dateString.split("-");

		int day = Integer.parseInt(dateParts[0]);
		int month = Integer.parseInt(dateParts[1]);
        int year = Integer.parseInt(dateParts[2]);


		a.setDay(day);
		a.setMonth(month);
		a.setYear(year);

		return a ;
	}
	public static void showDate(DateManager temp)
	{
		System.out.println("Day : " + temp.getDay());
		System.out.println("Month : " + temp.getMonth());
		System.out.println("Yeay : " + temp.getYear());
	}
}
