import java.util.*;

public class dlsBookingDetail
{
	public static void addNewBookingDetail(clsBookingDetail temp)
	{

		String SQ = "'";
		String COMMA = ",";
		String SPACE = " ";

		String Query = "insert into dbProjectData.tblBookingDetail" + SPACE +
					   "(BookingID,GoodsID,Details,Charges)" +
					   "Value" + SPACE + "("
					   + temp.getBookingID() + COMMA
					   + temp.getGoodsID() + COMMA
					   + SQ + temp.getDetails() + SQ + COMMA
					   + SQ + temp.getCharges() + SQ +")";

		QueryExecutor.processQuery(Query);

	}

	public static void updateBookingDetail(clsBookingDetail temp)
	{

		String SQ = "'";
		String COMMA = ",";
		String SPACE = " ";

		String Query = "update dbProjectData.tblBookingDetail set" + SPACE +
					   "BookingID=" +String.valueOf(temp.getBookingID())+ SPACE + COMMA +
					   "GoodsID=" + String.valueOf(temp.getGoodsID())+ SPACE + COMMA +
					   "Details = " + SQ + temp.getDetails() + SQ + SPACE + COMMA +
					   "Charges = " +SQ + temp.getCharges() + SQ +
					   "WHERE BookingDetailID = " + String.valueOf(temp.getBookingDetailID());

		QueryExecutor.processQuery(Query);

	}

	public static String [] getAllBookingDetail()
	{

		String Query = "select GoodsName from dbProjectData.tblBookingDetail";
		return(QueryExecutor.getSingleColumn(Query));

	}

	public static int getIDFromName(String mGoodsName)
	{

		String Query = "select GoodsID from dbProjectData.tblBookingDetail where GoodsName='"+mGoodsName+"'";

		return QueryExecutor.getIDFromName(Query);

	}
	public static String getNameFromID(int mBookingDetailID)
	{

		String Query = "select GoodsName from dbProjectData.tblBookingDetail where GoodsID="+String.valueOf(mBookingDetailID);

		return QueryExecutor.getNameFromID(Query);

	}

	public static int getAllBookingDetailCount()
	{

		String Query = "select count(BookingDetailID) from dbProjectData.tblBookingDetail";
		return(QueryExecutor.getRowsCount(Query));

	}


	public static clsBookingDetail getBookingDetailInformation(int mBookingDetailID)
	{

		String Query = "select * from dbProjectData.tblBookingDetail where BookingDetailID="+String.valueOf(mBookingDetailID);

		String data[] = QueryExecutor.getObjectInformation(Query,5);

		clsBookingDetail temp = new clsBookingDetail();

		temp.setBookingDetailID(Integer.parseInt(data[0]));
		temp.setBookingID(Integer.parseInt(data[1]));
		temp.setGoodsID(Integer.parseInt(data[2]));
		temp.setDetails(data[3]);
		temp.setCharges(data[4]);
		return(temp);

	}

	public static clsBookingDetail [] getAllBookingDetailInformation(int mBookingID)
	{
		String Query = "select * from dbProjectData.tblBookingDetail where BookingID="+String.valueOf(mBookingID);

		String data[][] = QueryExecutor.getAllObjectInformation(Query,5);

		clsBookingDetail temp[] = new clsBookingDetail[data.length];

		for(int i=0;i<data.length;i++)
		{
			temp[i]=new clsBookingDetail();
			temp[i].setBookingDetailID(Integer.parseInt(data[i][0]));
			temp[i].setBookingID(Integer.parseInt(data[i][1]));
			temp[i].setGoodsID(Integer.parseInt(data[i][2]));
			temp[i].setDetails(data[i][3]);
			temp[i].setCharges(data[i][4]);
		}

		return temp ;

	}
	public static void deleteBookingDetail(clsBookingDetail temp)
	{

		String SQ = "'";
		String COMMA = ",";
		String SPACE = " ";

		String Query = "delete from dbProjectData.tblBookingDetail where BookingDetailID="+temp.getBookingDetailID();

		QueryExecutor.processQuery(Query);

	}
	public static clsBookingDetail [] getAllBookingDetailInformation()
	{
		String Query = "select * from dbProjectData.tblBookingDetail";

		String data[][] = QueryExecutor.getAllObjectInformation(Query,5);
		clsBookingDetail temp[] = new clsBookingDetail [data.length];

		for(int i=0;i<data.length;i++)
		{
			temp[i]=new clsBookingDetail();
			temp[i].setBookingDetailID(Integer.parseInt(data[i][0]));
			temp[i].setBookingID(Integer.parseInt(data[i][1]));
			temp[i].setGoodsID(Integer.parseInt(data[i][2]));
			temp[i].setDetails(data[i][3]);
			temp[i].setCharges(data[i][4]);

		}
		return(temp);
	}

	public static clsBookingDetailReport [] getBookingDetailReportInformation(int mBookingID)
	{
		String Query = "SELECT " +
		               "bd.BookingDetailID, " +
		               "bd.GoodsID, " +
		               "bd.BookingID, " +
		               "bd.Details, " +
		               "bd.Charges, " +
		               "g.GoodsName " +
		               "FROM " +
		               "dbProjectData.tblBookingDetail bd " +
		               "JOIN dbProjectData.tblGoods g ON g.GoodsID = bd.GoodsID " +
               		   "WHERE bd.BookingID = " + String.valueOf(mBookingID);

		String data[][] = QueryExecutor.getAllObjectInformation(Query,6);
		clsBookingDetailReport temp[] = new clsBookingDetailReport[data.length];

		for(int i=0;i<data.length;i++)
		{

			temp[i]=new clsBookingDetailReport();
			temp[i].setBookingDetailID(Integer.parseInt(data[i][0]));
			temp[i].setBookingID(Integer.parseInt(data[i][1]));
			temp[i].setGoodsID(Integer.parseInt(data[i][2]));
			temp[i].setDetails(data[i][3]);
			temp[i].setCharges(data[i][4]);
			temp[i].setGoodsName(data[i][5]);
		}

		return temp ;

	}

	public static clsBookingDetailReport getBookingDetailUpdateInformation(int mBookingDetailID)
	{
		String Query = "SELECT " +
					   "bd.BookingDetailID, " +
					   "bd.GoodsID, " +
					   "bd.BookingID, " +
					   "bd.Details, " +
					   "bd.Charges, " +
					   "g.GoodsName " +
					   "FROM " +
					   "dbProjectData.tblBookingDetail bd " +
					   "JOIN dbProjectData.tblGoods g ON g.GoodsID = bd.GoodsID " +
					   "WHERE bd.BookingDetailID = " + String.valueOf(mBookingDetailID);

		String data[] = QueryExecutor.getObjectInformation(Query,6);
		clsBookingDetailReport temp = new clsBookingDetailReport();


		temp.setBookingDetailID(Integer.parseInt(data[0]));
		temp.setBookingID(Integer.parseInt(data[1]));
		temp.setGoodsID(Integer.parseInt(data[2]));
		temp.setDetails(data[3]);
		temp.setCharges(data[4]);
		temp.setGoodsName(data[5]);


		return temp ;
	}

}
