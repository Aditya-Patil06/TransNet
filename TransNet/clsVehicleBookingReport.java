import javax.swing.*;

public class clsVehicleBookingReport
{
    private int bookingID;
    private String bookingDate;
    private String sourceDepotName;
    private String destinationDepotName;
    private String vehicleName;

    public void setBookingID(int bookingID)
    {
        this.bookingID = bookingID;
    }

    public void setBookingDate(String bookingDate)
    {
        this.bookingDate = bookingDate;
    }

    public void setSourceDepotName(String sourceDepotName)
    {
        this.sourceDepotName = sourceDepotName;
    }

    public void setDestinationDepotName(String destinationDepotName)
    {
        this.destinationDepotName = destinationDepotName;
    }

    public void setVehicleName(String vehicleName)
    {
        this.vehicleName = vehicleName;
    }

    public int getBookingID()
    {
        return bookingID;
    }

    public String getBookingDate()
    {
        return bookingDate;
    }

    public String getSourceDepotName()
    {
        return sourceDepotName;
    }

    public String getDestinationDepotName()
    {
        return destinationDepotName;
    }

    public String getVehicleName()
    {
        return vehicleName;
    }

    public static clsVehicleBookingReport[] getVehicleBookingReportInformation(int vehicleID)
    {
        return dlsVehicle.getVehicleBookingReportInformation(vehicleID);
    }
	public static clsVehicleBookingReport[] getVehicleBookingReportByNumber(String vehicleNumber)
	{
        return dlsVehicle.getVehicleBookingReportByNumber(vehicleNumber);
    }
    public static void showVehicleBooking(clsVehicleBookingReport temp)
    {
        System.out.println("Booking ID           : " + temp.getBookingID());
        System.out.println("Booking Date         : " + temp.getBookingDate());
        System.out.println("Source Depot Name    : " + temp.getSourceDepotName());
        System.out.println("Destination Depot Name : " + temp.getDestinationDepotName());
        System.out.println("Vehicle Name         : " + temp.getVehicleName());
    }

    public static void main(String[] args)
    {
        int testVehicleID = 169;
        clsVehicleBookingReport[] reports = getVehicleBookingReportInformation(testVehicleID);

        if (reports != null && reports.length > 0)
        {
            System.out.println("Booking Report for Vehicle ID: " + testVehicleID);
            System.out.println("-----------------------------");
            for (clsVehicleBookingReport report : reports)
            {
                showVehicleBooking(report);
                System.out.println("-----------------------------");
       		 }
        }
        else
        {
            System.out.println("No booking records found for Vehicle ID: " + testVehicleID);
        }
    }
}
