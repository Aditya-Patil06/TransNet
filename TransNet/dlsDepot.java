import java.util.*;

public class dlsDepot
 {
 	public static void addNewDepot(clsDepot temp)
 	{
 		String SQ = "'";
 		String COMMA = ",";
 		String SPACE = " ";

 		String Query = "insert into dbProjectData.tblDepot" + SPACE +
 					   "(DepotName,Address,Villagian,PlaceID,ContactNo,EmailID,ContactPerson) " +"Values ("
 					   	+ SQ + temp.getDepotName() + SQ + COMMA +SPACE
 					    + SQ + temp.getAddress() + SQ + COMMA+ SPACE
 					    + SQ + temp.getVillagian() + SQ +COMMA+ SPACE +
 					    String.valueOf(temp.getPlaceID())+COMMA+SPACE+
 					    String.valueOf(temp.getContactNo())+SPACE+COMMA+
 					    SQ+String.valueOf(temp.getEmailID())+SQ+SPACE+COMMA
 					    + SQ + temp.getContactPerson() + SQ +
 					   ")" ;

 		QueryExecutor.processQuery(Query);

 	}
 	public static void updateDepot(clsDepot temp)
 	{
 		String SQ = "'";
 		String COMMA = ",";
 		String SPACE = " ";

 		String Query = "update dbProjectData.tblDepot set" + SPACE +
 					   "DepotName="+ SQ + temp.getDepotName() + SQ + SPACE +COMMA+
 					   "Address="+ SQ + temp.getAddress() + SQ  +SPACE +COMMA+
 					   "Villagian="+ SQ + temp.getVillagian() + SQ  +SPACE +COMMA+
					   "PlaceID="+String.valueOf(temp.getPlaceID())+SPACE+COMMA+
					   "ContactNo="+ SQ + temp.getContactNo() + SQ +SPACE +COMMA+
					   "EMailID="+ SQ + temp.getEmailID() + SQ +SPACE +COMMA+
					   "ContactPerson= "+SQ +String.valueOf(temp.getContactPerson())+ SQ +SPACE+
 					   "where DepotID=" + String.valueOf(temp.getDepotID());

 		QueryExecutor.processQuery(Query);

 	}

 	public static void deleteDepot(clsDepot temp)
 	{
 		String SQ = "'";
 		String COMMA = ",";
 		String SPACE = " ";

 		String Query = "delete from dbProjectData.tblDepot where DepotID="+temp.getDepotID();

 		QueryExecutor.processQuery(Query);
 	}

 	public static int getIDFromName(String mDepotName)
 	{
 		String Query = "select DepotID from dbProjectData.tblDepot where DepotName='"+mDepotName+"'";

 		return QueryExecutor.getIDFromName(Query);
 	}

 	public static String getNameFromID(int mDepotID)
 	{
 		String Query = "select DepotName from tblDepot where DepotID="+String.valueOf(mDepotID);

 		return QueryExecutor.getNameFromID(Query);
 	}

 	public static String [] getAllDepotNames()
 	{
 		String Query = "select DepotName from dbProjectData.tblDepot";
 		return(QueryExecutor.getSingleColumn(Query));
 	}

 	public static int getAllDepotCount()
 	{
 		String Query = "select count(DepotID) from dbProjectData.tblDepot";
 		return(QueryExecutor.getRowsCount(Query));
 	}


 	public static clsDepot getDepotInformation(int mDepotID)
 	{
 		String Query = "select * from tblDepot where DepotID="+String.valueOf(mDepotID);

 		String data[] = QueryExecutor.getObjectInformation(Query,8);

 		clsDepot temp = new clsDepot();

		temp=new clsDepot();
		temp.setDepotID(Integer.parseInt(data[0]));
		temp.setDepotName(data[1]);
		temp.setAddress(data[2]);
		temp.setVillagian(Integer.parseInt(data[3]));
		temp.setPlaceID(Integer.parseInt(data[4]));
		temp.setContactNo(data[5]);
		temp.setEmailID(data[6]);
		temp.setContactPerson(data[7]);

 		return(temp);
 	}

 	public static clsDepot [] getAllDepotInformation()
 	{
 		String Query = "select * from tblDepot";

 		String data[][] = QueryExecutor.getAllObjectInformation(Query,8);
 		clsDepot temp[] = new clsDepot[data.length];

		for(int i=0;i<data.length;i++)
		{
			temp[i]=new clsDepot();
 			temp[i].setDepotID(Integer.parseInt(data[i][0]));
 			temp[i].setDepotName(data[i][1]);
 			temp[i].setAddress(data[i][2]);
			temp[i].setVillagian(Integer.parseInt(data[i][3]));
			temp[i].setPlaceID(Integer.parseInt(data[i][4]));
			temp[i].setContactNo(data[i][5]);
			temp[i].setEmailID(data[i][6]);
			temp[i].setContactPerson(data[i][7]);

		}
 		return(temp);
 	}
	public static clsDepotReport[] getAllDepotReportInformation()
	{
		String Query =  "SELECT " +
						"d.DepotID, " +
						"d.DepotName, " +
						"d.Address, " +
						"d.villagian, " +
						"d.PlaceID, " +
						"t.DistrictID, " +
						"ta.AreaName, " +
						"d.ContactNo, " +
						"d.EmailID, " +
						"d.ContactPerson, " +
						"t.TalukaName, " +
						"di.DistrictName " +
						"FROM " +
						"dbProjectData.tblDepot d " +
						"JOIN dbProjectData.tblTalukaArea ta ON d.PlaceID = ta.AreaID " +
						"JOIN dbProjectData.tblTaluka t ON ta.TalukaID = t.TalukaID " +
						"JOIN dbProjectData.tblDistrict di ON t.DistrictID = di.DistrictID " ;

		String data[][] = QueryExecutor.getAllObjectInformation(Query,12);
		clsDepotReport temp[] = new clsDepotReport[data.length] ;

		for(int i=0;i<data.length;i++)
		{
			temp[i] = new clsDepotReport();

			temp[i].setDepotID(Integer.parseInt(data[i][0]));
			temp[i].setDepotName(data[i][1]);
			temp[i].setAddress(data[i][2]);
			temp[i].setVillagian(Integer.parseInt(data[i][3]));
			temp[i].setPlaceID(Integer.parseInt(data[i][4]));
			temp[i].setDistrictID(Integer.parseInt(data[i][5]));
			temp[i].setAreaName(data[i][6]);
			temp[i].setContactNo(data[i][7]);
			temp[i].setEmailID(data[i][8]);
			temp[i].setContactPerson(data[i][9]);
			temp[i].setTalukaName(data[i][10]);
			temp[i].setDistrictName(data[i][11]);
		}

		return temp ;

	}

	public static clsDepotBookingReport[] getDepotBookingReportInformation(int depotID)
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
                       "b.SourceDepotID = " + String.valueOf(depotID) + " OR b.DestinationDepotID = " + String.valueOf(depotID);

        // Assuming QueryExecutor returns a String[][] for multiple rows
        String[][] data = QueryExecutor.getAllObjectInformation(query, 7);  // 7 columns

        if (data == null || data.length == 0)
        {
            return new clsDepotBookingReport[0];  // Return empty array if no data
        }

        clsDepotBookingReport[] reports = new clsDepotBookingReport[data.length];

        for (int i = 0; i < data.length; i++)
        {
            clsDepotBookingReport temp = new clsDepotBookingReport();
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