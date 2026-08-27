import javax.swing.*;

public class clsDepotBookingReport
{
    private int bookingID;
    private String bookingDate;
    private String sourceDepotName;
    private String destinationDepotName;
    private String vehicleName;

    // Setters
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

    // Getters
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

    public static clsDepotBookingReport[] getDepotBookingReportInformation(int depotID)
    {
        return dlsDepot.getDepotBookingReportInformation(depotID);  // Delegate to dlsDepot
    }

    public static void showDepotBooking(clsDepotBookingReport temp)
    {
        System.out.println("Booking ID           : " + temp.getBookingID());
        System.out.println("Booking Date         : " + temp.getBookingDate());
        System.out.println("Source Depot Name    : " + temp.getSourceDepotName());
        System.out.println("Destination Depot Name : " + temp.getDestinationDepotName());
        System.out.println("Vehicle Name         : " + temp.getVehicleName());
    }

    public static void main(String[] args)
    {
        int testDepotID = 1;
        clsDepotBookingReport[] reports = getDepotBookingReportInformation(testDepotID);

        if (reports != null && reports.length > 0)
        {
            System.out.println("Booking Report for Depot ID: " + testDepotID);
            System.out.println("-----------------------------");
            for (clsDepotBookingReport report : reports)
            {
                showDepotBooking(report);
                System.out.println("-----------------------------");
            }
        }
        else
        {
            System.out.println("No booking records found for Depot ID: " + testDepotID);
        }
    }
}