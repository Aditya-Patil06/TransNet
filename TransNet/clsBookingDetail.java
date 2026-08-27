import javax.swing.*;

public class clsBookingDetail
{
	int 	BookingDetailID 		;
    int 	GoodsID 	;
    int 	BookingID 		;


    String 	Details 	;
	String 	Charges	;

    public void setBookingDetailID(int BookingDetailID)
    {
        this.BookingDetailID = BookingDetailID;
    }

    public int getBookingDetailID()
    {
        return BookingDetailID;
    }
	public void setBookingID(int BookingID)
    {
        this.BookingID = BookingID;
    }

    public int getBookingID()
    {
        return BookingID;
    }
	public void setGoodsID(int GoodsID)
    {
        this.GoodsID = GoodsID;
    }

    public int getGoodsID()
    {
        return GoodsID;
    }
    public void setDetails(String Details)
	{
		this.Details = Details;
	}

	public String getDetails()
	{
		return Details;
	}
	public void setCharges(String Charges)
    {
        this.Charges = Charges;
    }

    public String getCharges()
    {
        return Charges;
    }

	public static void addNewBookingDetail(clsBookingDetail temp)
	{
		dlsBookingDetail.addNewBookingDetail(temp);
	}

	public static void deleteBookingDetail(clsBookingDetail temp)
	{
		dlsBookingDetail.deleteBookingDetail(temp);
	}

	public static String [] getAllBookingDetail()
	{
		return(dlsBookingDetail.getAllBookingDetail());
	}

	public static clsBookingDetail getBookingDetailInformation(int mBookingDetailID)
	{
		return(dlsBookingDetail.getBookingDetailInformation(mBookingDetailID));
	}
	public static clsBookingDetail [] getAllBookingDetailInformation()
	{
		return(dlsBookingDetail.getAllBookingDetailInformation());
	}
	public static clsBookingDetail[] getAllBookingDetailInformation(int mBookingID)
	{
		return(dlsBookingDetail.getAllBookingDetailInformation(mBookingID));
	}
	public static void addBookingDetailRecords(JComboBox temp)
	{
		temp.removeAllItems();
		temp.addItem("Select Goods ...");
		String GoodsNames [] = clsBookingDetail.getAllBookingDetail();
		for(String name : GoodsNames)
		{
			temp.addItem(name);
		}
	}

	public static int getIDFromName(String mGoodsName)
	{
		return dlsBookingDetail.getIDFromName(mGoodsName);
	}

	public static void showGoods(clsBookingDetail temp)
	{
	        System.out.println("Booking Detail ID : " + temp.getBookingDetailID());
	        System.out.println("Booking ID        : " + temp.getBookingID());
	        System.out.println("Goods ID          : " + temp.getGoodsID());
	        System.out.println("Details           : " + temp.getDetails());
	        System.out.println("Charges           : " + temp.getCharges());
    }
	public static void updateBookingDetail(clsBookingDetail temp)
	{
		dlsBookingDetail.updateBookingDetail(temp);
	}

	public static void main(String args[])
	{
		clsBookingDetail temp [] = clsBookingDetail.getAllBookingDetailInformation();
		for (clsBookingDetail detail : temp)
		{
			showGoods(detail);
		}
	}
}