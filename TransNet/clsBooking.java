import javax.swing.*;

public class clsBooking
{
    private int 	BookingID 		;
    private int 	ClientID 	;
    private int 	SourceDepotID 	;
    private int 	GenerateDocketID 	;
    private int 	VehicleID 	;
    private int 	DestinationDepotID 	;
    private String 	DeliveryParty 	;
    private String 	ContactNo 	;
    private String 	EmailID 	;
    private String 	Address 	;
    private int 	BookingDayNo 	;
    private int 	BookingMonthNo 	;
    private int 	BookingYearNo 	;

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

	public static void addNewBooking(clsBooking temp)
	{
		dlsBooking.addNewBooking(temp);
	}

	public static clsBooking getBookingInformation(int mBookingID)
	{
		return(dlsBooking.getBookingInformation(mBookingID));
	}
	public static clsBooking [] getAllBookingInformation()
	{
		return(dlsBooking.getAllBookingInformation());
	}

	public static int getBookingID(int mGenerateDocketID)
	{
		return dlsBooking.getBookingID(mGenerateDocketID);
	}
	public static void showBooking(clsBooking temp)
	{
		System.out.println("Booking ID   : "+temp.getBookingID());
		System.out.println("BookingDayNo : "+temp.getBookingDayNo());
		System.out.println("BookingMonthNo : "+temp.getBookingMonthNo());
		System.out.println("BookingYearNo : "+temp.getBookingYearNo());
		System.out.println("ClientID : "+temp.getClientID());
		System.out.println("SourceDepotID : "+temp.getSourceDepotID());
		System.out.println("GenerateDocketID : "+temp.getGenerateDocketID());
		System.out.println("VehicleID : "+temp.getVehicleID());
		System.out.println("DestinationDepotID : "+temp.getDestinationDepotID());
		System.out.println("DeliveryParty : "+temp.getDeliveryParty());
		System.out.println("ContactNo : "+temp.getContactNo());
		System.out.println("EmailID : "+temp.getEmailID());
		System.out.println("Address : "+temp.getAddress());

	}

	public static void updateBooking(clsBooking temp)
	{
		dlsBooking.updateBooking(temp);
	}

	public static void deleteBooking(clsBooking temp)
	{
		dlsBooking.deleteBooking(temp);
	}

	public static void main(String args[])
	{
		clsBooking[] countries = clsBooking.getAllBookingInformation();
		for (clsBooking country : countries)
		{
			clsBooking.showBooking(country);
		}
	}
}