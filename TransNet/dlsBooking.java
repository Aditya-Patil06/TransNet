import java.util.*;

public class dlsBooking
{
	public static void addNewBooking(clsBooking temp)
	{

		String SQ = "'";
		String COMMA = ",";
		String SPACE = " ";

		String Query = "insert into dbProjectData.tblBooking" + SPACE +
					   "(BookingDayNo,BookingMonthNo,BookingYearNo,ClientID,SourceDepotID,"+
					   "GenerateDocketID,VehicleID,DestinationDepotID,DeliveryParty,ContactNo,EmailID,Address)" +
					   "Value" + SPACE +
					   "("+ temp.getBookingDayNo()  + COMMA +
					    + temp.getBookingMonthNo() + COMMA +
					    + temp.getBookingYearNo()+ COMMA +
					    + temp.getClientID()+ COMMA +
					    + temp.getSourceDepotID()+ COMMA +
					    + temp.getGenerateDocketID()+COMMA +
					    + temp.getVehicleID()+ COMMA +
					    + temp.getDestinationDepotID()+ COMMA +
					   SQ + temp.getDeliveryParty()+ SQ +COMMA +
					   SQ + temp.getContactNo()+ SQ + COMMA +
					   SQ + temp.getEmailID()+ SQ +COMMA +
					   SQ + temp.getAddress()+ SQ +
					   ")";

		QueryExecutor.processQuery(Query);

	}

	public static void updateBooking(clsBooking temp)
	{

		String SQ = "'";
		String COMMA = ",";
		String SPACE = " ";

		String Query = "update dbProjectData.tblbooking set" + SPACE
						+ temp.getBookingDayNo()  + COMMA +
						+ temp.getBookingMonthNo() + COMMA +
						+ temp.getBookingYearNo()+ COMMA +
						+ temp.getClientID()+ COMMA +
						+ temp.getSourceDepotID()+ COMMA +
						+ temp.getGenerateDocketID()+COMMA +
						+ temp.getVehicleID()+ COMMA +
						+ temp.getDestinationDepotID()+ COMMA +
					   SQ + temp.getDeliveryParty()+ SQ +COMMA +
					   SQ + temp.getContactNo()+ SQ + COMMA +
					   SQ + temp.getEmailID()+ SQ +COMMA +
					   SQ + temp.getAddress()+ SQ + SPACE +

					   "where BookingID=" + String.valueOf(temp.getBookingID());

		QueryExecutor.processQuery(Query);
	}
	public static int getAllCCount()
	{

		String Query = "select count(BookingID) from dbProjectData.tblBooking";
		return(QueryExecutor.getRowsCount(Query));

	}

	public static int getBookingID(int mGenerateDocketID)
	{
		String Query = "select BookingID from dbProjectData.tblBooking "+
						" where GenerateDocketID ="+String.valueOf(mGenerateDocketID);

		return QueryExecutor.getIDFromName(Query);
	}


	public static clsBooking getBookingInformation(int mBookingID)
	{

		String Query = "select * from dbProjectData.tblBooking where BookingID="+String.valueOf(mBookingID);

		String data[] = QueryExecutor.getObjectInformation(Query,13);

		clsBooking temp = new clsBooking();

		temp.setBookingID(Integer.parseInt(data[0]));
		temp.setBookingDayNo(Integer.parseInt(data[1]));
		temp.setBookingMonthNo(Integer.parseInt(data[2]));
		temp.setBookingYearNo(Integer.parseInt(data[3]));
		temp.setClientID(Integer.parseInt(data[4]));
		temp.setSourceDepotID(Integer.parseInt(data[5]));
		temp.setGenerateDocketID(Integer.parseInt(data[6]));
		temp.setVehicleID(Integer.parseInt(data[7]));
		temp.setDestinationDepotID(Integer.parseInt(data[8]));
		temp.setDeliveryParty(data[9]);
		temp.setContactNo(data[10]);
		temp.setEmailID(data[11]);
		temp.setAddress(data[12]);
		return(temp);

	}

	public static void deleteBooking(clsBooking temp)
	{

		String SQ = "'";
		String COMMA = ",";
		String SPACE = " ";

		String Query = "delete from dbProjectData.tblBooking where BookingID="+temp.getBookingID();

		QueryExecutor.processQuery(Query);

	}
	public static clsBooking [] getAllBookingInformation()
	{
		String Query = "select * from tblBooking";

		String data[][] = QueryExecutor.getAllObjectInformation(Query,13);
		clsBooking temp[] = new clsBooking[data.length];

		for(int i=0;i<data.length;i++)
		{
			temp[i]=new clsBooking();
			temp[i].setBookingID(Integer.parseInt(data[i][0]));
			temp[i].setBookingDayNo(Integer.parseInt(data[i][1]));
			temp[i].setBookingMonthNo(Integer.parseInt(data[i][2]));
			temp[i].setBookingYearNo(Integer.parseInt(data[i][3]));
			temp[i].setClientID(Integer.parseInt(data[i][4]));
			temp[i].setSourceDepotID(Integer.parseInt(data[i][5]));
			temp[i].setGenerateDocketID(Integer.parseInt(data[i][6]));
			temp[i].setVehicleID(Integer.parseInt(data[i][7]));
			temp[i].setDestinationDepotID(Integer.parseInt(data[i][8]));
			temp[i].setDeliveryParty(data[i][9]);
			temp[i].setContactNo(data[i][10]);
			temp[i].setEmailID(data[i][11]);
			temp[i].setAddress(data[i][12]);

		}
		return(temp);
	}

	public static clsBookingReport getBookingReportInformation(int mBookingID)
	{
		String Query =  "SELECT " +
						"b.BookingID, " +
						"b.ClientID, " +
						"b.SourceDepotID, " +
						"b.GenerateDocketID, " +
						"b.VehicleID, " +
						"vt.VehicleTypeID, " +
						"b.DestinationDepotID, " +
						"b.DeliveryParty, " +
						"b.ContactNo, " +
						"b.EmailID, " +
						"b.Address, " +
						"b.BookingDayNo, " +
						"b.BookingMonthNo, " +
						"b.BookingYearNo, " +
						"c.ClientName, " +
						"sd.DepotName, " +
						"gd.GenerateDocketName, " +
						"v.VehicleNumber, " +
						"vt.VehicleTypeName, " +
						"dd.DepotName " +
						"FROM " +
						"dbProjectData.tblBooking b " +
						"JOIN dbProjectData.tblClient c ON c.ClientID = b.ClientID " +
						"JOIN dbProjectData.tblDepot sd ON sd.DepotID = b.SourceDepotID " +
						"JOIN dbProjectData.tblGenerateDocket gd ON gd.GenerateDocketID = b.GenerateDocketID " +
						"JOIN dbProjectData.tblVehicle v ON v.VehicleID = b.VehicleID " +
						"JOIN dbProjectData.tblDepot dd ON dd.DepotID = b.DestinationDepotID " +
						"JOIN dbProjectData.tblVehicleType vt ON v.VehicleTypeID = vt.VehicleTypeID " +
						"WHERE " +
						"b.BookingID = " + String.valueOf(mBookingID);

		String data[] = QueryExecutor.getObjectInformation(Query,20);
		clsBookingReport temp = new clsBookingReport();

		temp=new clsBookingReport();
		temp.setBookingID(Integer.parseInt(data[0]));
		temp.setClientID(Integer.parseInt(data[1]));
		temp.setSourceDepotID(Integer.parseInt(data[2]));
		temp.setGenerateDocketID(Integer.parseInt(data[3]));
		temp.setVehicleID(Integer.parseInt(data[4]));
		temp.setVehicleTypeID(Integer.parseInt(data[5]));
		temp.setDestinationDepotID(Integer.parseInt(data[6]));
		temp.setDeliveryParty(data[7]);
		temp.setContactNo(data[8]);
		temp.setEmailID(data[9]);
		temp.setAddress(data[10]);
		temp.setBookingDayNo(Integer.parseInt(data[11]));
		temp.setBookingMonthNo(Integer.parseInt(data[12]));
		temp.setBookingYearNo(Integer.parseInt(data[13]));
		temp.setClientName(data[14]);
		temp.setSourceDepotName(data[15]);
		temp.setGenerateDocketName(data[16]);
		temp.setVehicleNumber(data[17]);
		temp.setVehicleTypeName(data[18]);
		temp.setDestinationDepotName(data[19]);

		return temp ;

	}

}
