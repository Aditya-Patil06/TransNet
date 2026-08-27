import java.util.*;

public class dlsClient
 {
 	public static void addNewClient(clsClient temp)
 	{
 		String SQ = "'";
 		String COMMA = ",";
 		String SPACE = " ";

 		String Query = "insert into dbProjectData.tblClient" + SPACE +
 					   "(ClientName,Address,Villagian,AreaID,ContactNo,EmailID,IndustryID) " +"Values ("
 					   	+ SQ + temp.getClientName() + SQ + COMMA +SPACE
 					    + SQ + temp.getAddress() + SQ + COMMA+ SPACE
 					    + SQ + temp.getVillagian() + SQ +COMMA+ SPACE +
 					    String.valueOf(temp.getAreaID())+COMMA+SPACE+
 					    String.valueOf(temp.getContactNo())+SPACE+COMMA+
 					    SQ+String.valueOf(temp.getEmailID())+SQ+SPACE+COMMA
 					    + SQ + temp.getIndustryID() + SQ +
 					   ")" ;

 		System.out.println(Query);

 		QueryExecutor.processQuery(Query);

 	}
 	public static void updateClient(clsClient temp)
 	{
 		String SQ = "'";
 		String COMMA = ",";
 		String SPACE = " ";

 		String Query = "update dbProjectData.tblClient set" + SPACE +
 					   "ClientName="+ SQ + temp.getClientName() + SQ + SPACE +COMMA+
 					   "Address="+ SQ + temp.getAddress() + SQ  +SPACE +COMMA+
 					   "Villagian="+ SQ + temp.getVillagian() + SQ  +SPACE +COMMA+
					   "AreaID="+String.valueOf(temp.getAreaID())+SPACE+COMMA+
					   "ContactNo="+ SQ + temp.getContactNo() + SQ +SPACE +COMMA+
					   "EMailID="+ SQ + temp.getEmailID() + SQ +SPACE +COMMA+
					   "IndustryID="+String.valueOf(temp.getIndustryID())+SPACE+
 					   "where ClientID=" + String.valueOf(temp.getClientID());


 		System.out.println(Query);

 		QueryExecutor.processQuery(Query);

 	}

 	public static void deleteClient(clsClient temp)
 	{
 		String SQ = "'";
 		String COMMA = ",";
 		String SPACE = " ";

 		String Query = "delete from dbProjectData.tblClient where ClientID="+temp.getClientID();

 		QueryExecutor.processQuery(Query);
 	}

 	public static int getIDFromName(String mClientName)
 	{
 		String Query = "select ClientID from dbProjectData.tblClient where ClientName='"+mClientName+"'";

 		return QueryExecutor.getIDFromName(Query);
 	}

 	public static String getNameFromID(int mClientID)
 	{
 		String Query = "select ClientName from tblClient where ClientID="+String.valueOf(mClientID);

 		return QueryExecutor.getNameFromID(Query);
 	}

 	public static String [] getAllClientNames()
 	{
 		String Query = "select ClientName from dbProjectData.tblClient";
 		return(QueryExecutor.getSingleColumn(Query));
 	}

 	public static int getAllClientCount()
 	{
 		String Query = "select count(ClientID) from dbProjectData.tblClient";
 		return(QueryExecutor.getRowsCount(Query));
 	}


 	public static clsClient getClientInformation(int mClientID)
 	{
 		String Query = "select * from tblClient where ClientID="+String.valueOf(mClientID);

 		String data[] = QueryExecutor.getObjectInformation(Query,8);

 		clsClient temp = new clsClient();

		temp=new clsClient();
		temp.setClientID(Integer.parseInt(data[0]));
		temp.setClientName(data[1]);
		temp.setAddress(data[2]);
		temp.setVillagian(Integer.parseInt(data[3]));
		temp.setAreaID(Integer.parseInt(data[4]));
		temp.setContactNo(data[5]);
		temp.setEmailID(data[6]);
		temp.setIndustryID(Integer.parseInt(data[7]));

 		return(temp);
 	}

 	public static clsClient [] getAllClientInformation()
 	{
 		String Query = "select * from tblClient";

 		String data[][] = QueryExecutor.getAllObjectInformation(Query,8);
 		clsClient temp[] = new clsClient[data.length];

		for(int i=0;i<data.length;i++)
		{
			temp[i]=new clsClient();
 			temp[i].setClientID(Integer.parseInt(data[i][0]));
 			temp[i].setClientName(data[i][1]);
 			temp[i].setAddress(data[i][2]);
			temp[i].setVillagian(Integer.parseInt(data[i][3]));
			temp[i].setAreaID(Integer.parseInt(data[i][4]));
			temp[i].setContactNo(data[i][5]);
			temp[i].setEmailID(data[i][6]);
			temp[i].setIndustryID(Integer.parseInt(data[i][7]));

		}
 		return(temp);
 	}

	public static clsClientBookingReport[] getClientBookingReportInformation(int clientID)
	{
		String query = "SELECT " +
					   "b.BookingID, " +
					   "b.BookingDayNo, " +
					   "b.BookingMonthNo, " +
					   "b.BookingYearNo, " +
					   "v.VehicleNumber, " +
					   "sd.DepotName AS SourceDepotName, " +
					   "dd.DepotName AS DestinationDepotName " +
					   "FROM " +
					   "dbProjectData.tblBooking b " +
					   "LEFT JOIN dbProjectData.tblVehicle v ON v.VehicleID = b.VehicleID " +
					   "LEFT JOIN dbProjectData.tblDepot sd ON sd.DepotID = b.SourceDepotID " +
					   "LEFT JOIN dbProjectData.tblDepot dd ON dd.DepotID = b.DestinationDepotID " +
					   "WHERE " +
					   "b.ClientID = " + String.valueOf(clientID);

		// Assuming QueryExecutor returns a String[][] for multiple rows
		String[][] data = QueryExecutor.getAllObjectInformation(query, 7);  // 7 columns

		if (data == null || data.length == 0)
		{
			return new clsClientBookingReport[0];  // Return empty array if no data
		}

		clsClientBookingReport[] reports = new clsClientBookingReport[data.length];

		for (int i = 0; i < data.length; i++)
		{
			clsClientBookingReport temp = new clsClientBookingReport();
			temp.setBookingID(Integer.parseInt(data[i][0]));
			int day = Integer.parseInt(data[i][1]);
			int month = Integer.parseInt(data[i][2]);
			int year = Integer.parseInt(data[i][3]);
			String bookingDate = String.format("%02d/%02d/%d", day, month, year);
			temp.setBookingDate(bookingDate);
			temp.setVehicleName(data[i][4] != null ? data[i][4] : "N/A");
			temp.setSourceDepotName(data[i][5] != null ? data[i][5] : "N/A");
			temp.setDestinationDepotName(data[i][6] != null ? data[i][6] : "N/A");

			reports[i] = temp;
		}

		return reports;
	}
}