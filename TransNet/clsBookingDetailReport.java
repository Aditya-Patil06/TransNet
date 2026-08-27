import javax.swing.*;

public class clsBookingDetailReport
{
	int 	BookingDetailID ;
    int 	GoodsID 		;
    int 	BookingID 		;

	String  GoodsName		;
    String 	Details 		;
	String 	Charges			;

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
    public void setGoodsName(String GoodsName)
    {
        this.GoodsName = GoodsName;
    }

    public String getGoodsName()
    {
        return GoodsName;
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

	public static clsBookingDetailReport [] getBookingDetailReportInformation(int mBookingID)
	{
		return(dlsBookingDetail.getBookingDetailReportInformation(mBookingID));
	}

	public static clsBookingDetailReport getBookingDetailUpdateInformation(int mBookingDetailID)
	{
		return(dlsBookingDetail.getBookingDetailUpdateInformation(mBookingDetailID));
	}

	public static void showGoods(clsBookingDetailReport temp)
	{
	        System.out.println("Booking Detail ID : " + temp.getBookingDetailID());
	        System.out.println("Booking ID        : " + temp.getBookingID());
	        System.out.println("Goods ID          : " + temp.getGoodsID());
	        System.out.println("Goods Name        : " + temp.getGoodsName());
	        System.out.println("Details           : " + temp.getDetails());
	        System.out.println("Charges           : " + temp.getCharges());
    }

	public static void main(String args[])
	{
		clsBookingDetailReport temp = clsBookingDetailReport.getBookingDetailUpdateInformation(1);

		clsBookingDetailReport.showGoods(temp);

	}
}