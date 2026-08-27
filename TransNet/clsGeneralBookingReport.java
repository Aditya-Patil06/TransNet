import javax.swing.*;

public class clsGeneralBookingReport
{
    private int bookingID;
    private int bookingDayNo;
    private int bookingMonthNo;
    private int bookingYearNo;
    private int clientID;
    private int destinationDepotID;
	private int vehicleID;
	private int docketNo;
	private int sourceDepotID;
	private String diliverParty;
	private String contactNo;
	private String emailID;
	private String address;
	private String clientName;
	private String sourceDepotName;
	private String vehicleNumber;
	private String destinationDepotName;
	private String generateDocketName;

	public void setGenerateDocketName(String generateDocketName)
	{
		this.generateDocketName = generateDocketName;
	}

	public String getGenerateDocketName()
	{
		return generateDocketName;
	}
    public void setBookingID(int bookingID)
    {
        this.bookingID = bookingID;
    }
    public int getBookingID()
    {
        return bookingID;
    }

    public void setBookingDayNo(int bookingDayNo)
    {
        this.bookingDayNo = bookingDayNo;
    }
    public int getBookingDayNo()
    {
        return bookingDayNo;
    }

    public void setBookingMonthNo(int bookingMonthNo)
    {
        this.bookingMonthNo = bookingMonthNo;
    }
    public int getBookingMonthNo()
    {
        return bookingMonthNo;
    }

    public void setBookingYearNo(int bookingYearNo)
    {
        this.bookingYearNo = bookingYearNo;
    }
    public int getBookingYearNo()
    {
        return bookingYearNo;
    }

    public void setClientID(int clientID)
    {
        this.clientID = clientID;
    }
    public int getClientID()
    {
        return clientID;
    }

    public void setSourceDepotID(int sourceDepotID)
    {
        this.sourceDepotID = sourceDepotID;
    }
    public int getSourceDepotID()
    {
        return sourceDepotID;
    }

    public void setDocketNo(int docketNo)
    {
        this.docketNo = docketNo;
    }
    public int getDocketNo()
    {
        return docketNo;
    }

    public void setVehicleID(int vehicleID)
    {
        this.vehicleID = vehicleID;
    }
    public int getVehicleID()
    {
        return vehicleID;
    }

    public void setDestinationDepotID(int destinationDepotID)
    {
        this.destinationDepotID = destinationDepotID;
    }
    public int getDestinationDepotID()
    {
        return destinationDepotID;
    }

    public void setDiliverParty(String diliverParty)
    {
        this.diliverParty = diliverParty;
    }
    public String getDiliverParty()
    {
        return diliverParty;
    }

    public void setContactNo(String contactNo)
    {
        this.contactNo = contactNo;
    }
    public String getContactNo()
    {
        return contactNo;
    }

    public void setEmailID(String emailID)
    {
        this.emailID = emailID;
    }
    public String getEmailID()
    {
        return emailID;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }
    public String getAddress()
    {
        return address;
    }

    public void setClientName(String clientName)
    {
        this.clientName = clientName;
    }
    public String getClientName()
    {
        return clientName;
    }

    public void setSourceDepotName(String sourceDepotName)
    {
        this.sourceDepotName = sourceDepotName;
    }
    public String getSourceDepotName()
    {
        return sourceDepotName;
    }

    public void setVehicleNumber(String vehicleNumber)
    {
        this.vehicleNumber = vehicleNumber;
    }
    public String getVehicleName()
    {
        return vehicleNumber;
    }

    public void setDestinationDepotName(String destinationDepotName)
    {
        this.destinationDepotName = destinationDepotName;
    }
    public String getDestinationDepotName()
    {
        return destinationDepotName;
    }

    public String getBookingDate()
    {
        return String.format("%02d/%02d/%d", bookingDayNo, bookingMonthNo, bookingYearNo);
    }

    public static clsGeneralBookingReport[] getAllBookingInformation()
    {
        return dlsGeneral.getAllBookingInformation();
    }

    public static clsGeneralBookingReport[] getOverallBookingReportInformation()
    {
        return dlsGeneral.getAllBookingInformation();
    }

    public static clsGeneralBookingReport[] getDateBookingReportInformation(String date)
    {
        return dlsGeneral.getDateBookingReportInformation(date);
    }

    public static clsGeneralBookingReport[] getMonthBookingReportInformation(String monthYear)
    {
        return dlsGeneral.getMonthBookingReportInformation(monthYear);
    }

    public static clsGeneralBookingReport[] getYearBookingReportInformation(String year)
    {
        return dlsGeneral.getYearBookingReportInformation(year);
    }

    public static clsGeneralBookingReport[] getClientBookingReportInformation(int clientID)
    {
        return dlsGeneral.getClientBookingReportInformation(clientID);
    }

    public static clsGeneralBookingReport[] getDepotBookingReportInformation(int depotID)
    {
        return dlsGeneral.getDepotBookingReportInformation(depotID);
    }

    public static void showGeneralBooking(clsGeneralBookingReport temp)
	{
	    System.out.println("Booking ID           : " + temp.getBookingID());
	    System.out.println("Booking Date         : " + temp.getBookingDate());
	    System.out.println("Client ID            : " + temp.getClientID());
	    System.out.println("Client Name          : " + temp.getClientName());
	    System.out.println("Source Depot ID      : " + temp.getSourceDepotID());
	    System.out.println("Source Depot Name    : " + temp.getSourceDepotName());
	    System.out.println("Destination Depot ID : " + temp.getDestinationDepotID());
	    System.out.println("Destination Depot Name: " + temp.getDestinationDepotName());
	    System.out.println("Vehicle Name         : " + temp.getVehicleName());
	    System.out.println("Docket No            : " + temp.getDocketNo());
	    System.out.println("Generate Docket Name : " + temp.getGenerateDocketName());
	    System.out.println("Delivery Party       : " + temp.getDiliverParty());
	    System.out.println("Contact No           : " + temp.getContactNo());
	    System.out.println("Email ID             : " + temp.getEmailID());
	    System.out.println("Address              : " + temp.getAddress());
	}

    public static void main(String[] args)
    {
        clsGeneralBookingReport[] reports = getClientBookingReportInformation(1);

        if (reports != null && reports.length > 0)
        {
            System.out.println("Booking Report for Client ID: " + 1);
            System.out.println("-----------------------------");
            for (clsGeneralBookingReport report : reports)
            {
                showGeneralBooking(report);
                System.out.println("-----------------------------");
            }
        }
        else
        {
            System.out.println("No booking records found for Client ID: " + 1);
        }
    }
}