import javax.swing.*;

public class clsBookingReport
{
    private int 	BookingID 		;
    private int 	ClientID 	;
    private int 	SourceDepotID 	;
    private int 	GenerateDocketID 	;
    private int 	VehicleID 	;
    private int 	VehicleTypeID 	;
    private int 	DestinationDepotID 	;
    private String 	DeliveryParty 	;
    private String 	ContactNo 	;
    private String 	EmailID 	;
    private String 	Address 	;
    private int 	BookingDayNo 	;
    private int 	BookingMonthNo 	;
    private int 	BookingYearNo 	;

    private String ClientName ;
    private String SourceDepotName ;
    private String GenerateDocketName ;
    private String VehicleNumber ;
    private String VehicleTypeName ;
    private String DestinationDepotName ;


    public void setClientName(String ClientName)
    {
        this.ClientName = ClientName;
    }

    public String getClientName()
    {
        return ClientName;
    }

    public void setDestinationDepotName(String DestinationDepotName)
    {
        this.DestinationDepotName = DestinationDepotName;
    }

    public String getDestinationDepotName()
    {
        return DestinationDepotName;
    }

    public void setVehicleNumber(String VehicleNumber)
    {
        this.VehicleNumber = VehicleNumber;
    }

    public String getVehicleNumber()
    {
        return VehicleNumber;
    }
    public void setVehicleTypeName(String VehicleTypeName)
    {
        this.VehicleTypeName = VehicleTypeName;
    }

    public String getVehicleTypeName()
    {
        return VehicleTypeName;
    }




    public void setGenerateDocketName(String GenerateDocketName)
    {
        this.GenerateDocketName = GenerateDocketName;
    }

    public String getGenerateDocketName()
    {
        return GenerateDocketName;
    }


    public void setSourceDepotName(String SourceDepotName)
    {
        this.SourceDepotName = SourceDepotName;
    }

    public String getSourceDepotName()
    {
        return SourceDepotName;
    }

    public void setBookingID(int BookingID)
    {
        this.BookingID = BookingID;
    }

    public int getBookingID()
    {
        return BookingID;
    }

    public void setClientID(int ClientID)
    {
        this.ClientID = ClientID;
    }

    public int getClientID()
    {
        return ClientID;
    }
    public void setSourceDepotID(int SourceDepotID)
    {
        this.SourceDepotID = SourceDepotID;
    }

    public int getSourceDepotID()
    {
        return SourceDepotID;
    }
    public void setGenerateDocketID(int GenerateDocketID)
    {
        this.GenerateDocketID = GenerateDocketID;
    }

    public int getGenerateDocketID()
    {
        return GenerateDocketID;
    }
    public void setVehicleID(int VehicleID)
    {
        this.VehicleID = VehicleID;
    }

    public int getVehicleID()
    {
        return VehicleID;
    }
    public void setVehicleTypeID(int VehicleTypeID)
    {
        this.VehicleTypeID = VehicleTypeID;
    }

    public int getVehicleTypeID()
    {
        return VehicleTypeID;
    }


    public void setDestinationDepotID(int DestinationDepotID)
    {
        this.DestinationDepotID = DestinationDepotID;
    }

    public int getDestinationDepotID()
    {
        return DestinationDepotID;
    }
    public void setDeliveryParty(String DeliveryParty)
    {
        this.DeliveryParty = DeliveryParty;
    }

    public String getDeliveryParty()
    {
        return DeliveryParty;
    }
    public void setContactNo(String ContactNo)
    {
        this.ContactNo = ContactNo;
    }

    public String getContactNo()
    {
        return ContactNo;
    }
    public void setEmailID(String EmailID)
    {
        this.EmailID = EmailID;
    }

    public String getEmailID()
    {
        return EmailID;
    }
    public void setAddress(String Address)
    {
        this.Address = Address;
    }

    public String getAddress()
    {
        return Address;
    }
    public void setBookingDayNo(int BookingDayNo)
    {
        this.BookingDayNo = BookingDayNo;
    }

    public int getBookingDayNo()
    {
        return BookingDayNo;
    }
    public void setBookingMonthNo(int BookingMonthNo)
    {
        this.BookingMonthNo = BookingMonthNo;
    }

    public int getBookingMonthNo()
    {
        return BookingMonthNo;
    }
    public void setBookingYearNo(int BookingYearNo)
    {
        this.BookingYearNo = BookingYearNo;
    }

    public int getBookingYearNo()
    {
        return BookingYearNo;
    }

    public String getBookingDate()
    {
		String myDate = String.valueOf(BookingDayNo)+"-"+String.valueOf(BookingMonthNo)+"-"+String.valueOf(BookingYearNo);
		return myDate ;
	}

	public static clsBookingReport getBookingReportInformation(int mBookingID)
	{
		return(dlsBooking.getBookingReportInformation(mBookingID));
	}

	public static int getBookingID(int mGenerateDocketID)
	{
		return dlsBooking.getBookingID(mGenerateDocketID);
	}

	public static void showBooking(clsBookingReport temp)
	{
	    System.out.println("Booking ID : " + temp.getBookingID());
	    System.out.println("Booking Date : " + temp.getBookingDate());
	    System.out.println("Booking Day No : " + temp.getBookingDayNo());
	    System.out.println("Booking Month No : " + temp.getBookingMonthNo());
	    System.out.println("Booking Year No : " + temp.getBookingYearNo());
	    System.out.println("Client ID : " + temp.getClientID());
	    System.out.println("Client Name : " + temp.getClientName());
	    System.out.println("Source Depot ID : " + temp.getSourceDepotID());
	    System.out.println("Source Depot Name : " + temp.getSourceDepotName());
	    System.out.println("Docket ID : " + temp.getGenerateDocketID());
	    System.out.println("Docket Name : " + temp.getGenerateDocketName());
	    System.out.println("Vehicle ID : " + temp.getVehicleID());
	    System.out.println("Vehicle Number : " + temp.getVehicleNumber());
	    System.out.println("Vehicle Type ID : " + temp.getVehicleTypeID());
	    System.out.println("Vehicle Type Name : " + temp.getVehicleTypeName());
	    System.out.println("Destination Depot ID: " + temp.getDestinationDepotID());
	    System.out.println("Destination Depot : " + temp.getDestinationDepotName());
	    System.out.println("Delivery Party : " + temp.getDeliveryParty());
	    System.out.println("Contact Number : " + temp.getContactNo());
	    System.out.println("Email ID : " + temp.getEmailID());
	    System.out.println("Address : " + temp.getAddress());

	}
	public static void main(String args[])
	{
		clsBookingReport temp = clsBookingReport.getBookingReportInformation(1);
		clsBookingReport.showBooking(temp);

	}
}