import java.util.*;

public class dlsVehicle
{
	public static void addNewVehicle(clsVehicle temp)
	{

		String SQ = "'";
		String COMMA = ",";
		String SPACE = " ";

		String Query = "insert into dbProjectData.tblVehicle" + SPACE +
					   "(VehicleNumber,Descr,ContactPerson,DriverName,LicenceNo,VehicleTypeID,DepotID)" + SPACE +
					   "Values" + SPACE + "("+
					   SQ + temp.getVehicleNumber() + SQ + COMMA +
					   SQ + temp.getDescription() + SQ + COMMA +
					   SQ+ temp.getContactPerson()+SQ+COMMA +
					   SQ+ temp.getDriverName()+SQ+COMMA +
					   SQ+ temp.getLicenceNo()+SQ+COMMA +
					   temp.getVehicleTypeID()+COMMA +
					   temp.getDepotID()+")" ;

		QueryExecutor.processQuery(Query);
	}

	public static void updateVehicle(clsVehicle temp)
	{

		String SQ = "'";
		String COMMA = ",";
		String SPACE = " ";

		String Query = "update dbProjectData.tblVehicle set" + SPACE +
		             "VehicleNumber=" + SQ + temp.getVehicleNumber() + SQ + COMMA + SPACE +
		             "Descr=" + SQ + temp.getDescription() + SQ + COMMA + SPACE +
		             "ContactPerson=" + SQ + temp.getContactPerson() + SQ + COMMA + SPACE +
		             "DriverName=" + SQ + temp.getDriverName() + SQ + COMMA + SPACE +
		             "LicenceNo=" + SQ + temp.getLicenceNo() + SQ + COMMA + SPACE +
		             "VehicleTypeID=" + temp.getVehicleTypeID() + COMMA + SPACE +
		             "DepotID=" + temp.getDepotID() + SPACE +
             		  "where VehicleID=" + SQ + String.valueOf(temp.getVehicleID()) + SQ;

		QueryExecutor.processQuery(Query);

	}

	public static String [] getAllVehicleNumbers()
	{

		String Query = "select VehicleNumber from dbProjectData.tblVehicle";
		return(QueryExecutor.getSingleColumn(Query));

	}

	public static String [] getVehicleNumbers(int vVehicleTypeID)
	{

		String Query = "select VehicleNumber from dbProjectData.tblVehicle where VehicleTypeID = "+vVehicleTypeID;
		return(QueryExecutor.getSingleColumn(Query));

	}
	public static String [] getVehicleNumbersByDepotID(int mDepotID, int mVehicleTypeID)
	{
		String Query = "select VehicleNumber from dbProjectData.tblVehicle where DepotID = "+mDepotID+" and VehicleTypeID = "+mVehicleTypeID;
		return(QueryExecutor.getSingleColumn(Query));

	}

	public static int getIDFromName(String mVehicleNumber)
	{

		String Query = "select VehicleID from tblVehicle where VehicleNumber='"+mVehicleNumber+"'";

		return QueryExecutor.getIDFromName(Query);

	}
	public static String getNameFromID(int mVehicleID)
	{

		String Query = "select VehicleNumber from tblVehicle where VehicleID="+String.valueOf(mVehicleID);

		return QueryExecutor.getNameFromID(Query);

	}

	public static int getAllVehicleCount()
	{

		String Query = "select count(VehicleID) from dbProjectData.tblVehicle";
		return(QueryExecutor.getRowsCount(Query));

	}
	public static clsVehicle getVehicleInformation(int mVehicleID)
	{
	    String Query = "select * from dbProjectData.tblVehicle where VehicleID=" + String.valueOf(mVehicleID);
	    String data[] = QueryExecutor.getObjectInformation(Query, 8);

	    if (data == null || data.length == 0)
	    {
	        return null;
	    }

	    clsVehicle temp = new clsVehicle();
	    temp.setVehicleID(Integer.parseInt(data[0]));
	    temp.setVehicleNumber(data[1]);
	    temp.setDescription(data[2]);
	    temp.setContactPerson(data[3]);
	    temp.setDriverName(data[4]);
	    temp.setLicenceNo(data[5]);
	    temp.setVehicleTypeID(Integer.parseInt(data[6]));
	    temp.setDepotID(Integer.parseInt(data[7]));

	    return temp;
	}
	public static void deleteVehicle(clsVehicle temp)
	{

		String SQ = "'";
		String COMMA = ",";
		String SPACE = " ";

		String Query = "delete from dbProjectData.tblVehicle where VehicleID="+temp.getVehicleID();

		QueryExecutor.processQuery(Query);

	}
	public static clsVehicleReport [] getAllVehicleReportInformation()
	{
		String Query =  "SELECT " +
						"v.VehicleID, " +
						"v.VehicleNumber, " +
						"v.Descr," +
						"v.ContactPerson, " +
						"v.DriverName, " +
						"v.LicenceNo, " +
						"v.VehicleTypeID, " +
						"v.DepotID, " +
						"vt.VehicleTypeName, " +
						"d.DepotName " +
						"FROM " +
						"dbProjectData.tblVehicle v " +
						"JOIN dbProjectData.tblVehicleType vt ON v.VehicleTypeID = vt.VehicleTypeID " +
						"JOIN dbProjectData.tblDepot d ON v.DepotID = d.DepotID " ;

		String data[][] = QueryExecutor.getAllObjectInformation(Query,10);
		clsVehicleReport temp[] = new clsVehicleReport[data.length];

		for(int i=0;i<data.length;i++)
		{
			temp[i]=new clsVehicleReport();
			temp[i].setVehicleID(Integer.parseInt(data[i][0]));
			temp[i].setVehicleNumber(data[i][1]);
			temp[i].setDescription(data[i][2]);
			temp[i].setContactPerson(data[i][3]);
			temp[i].setDriverName(data[i][4]);
			temp[i].setLicenceNo(data[i][5]);
			temp[i].setVehicleTypeID(Integer.parseInt(data[i][6]));
			temp[i].setDepotID(Integer.parseInt(data[i][7]));
			temp[i].setVehicleTypeName(data[i][8]);
			temp[i].setDepotName(data[i][9]);


		}
		return(temp);
	}


	public static clsVehicle [] getAllVehicleInformation()
	{
		String Query = "select * from tblVehicle";

		String data[][] = QueryExecutor.getAllObjectInformation(Query,8);
		clsVehicle temp[] = new clsVehicle[data.length];

		for(int i=0;i<data.length;i++)
		{
			temp[i]=new clsVehicle();
			temp[i].setVehicleID(Integer.parseInt(data[i][0]));
			temp[i].setVehicleNumber(data[i][1]);
			temp[i].setDescription(data[i][2]);
			temp[i].setContactPerson(data[i][3]);
			temp[i].setDriverName(data[i][4]);
			temp[i].setLicenceNo(data[i][5]);
			temp[i].setVehicleTypeID(Integer.parseInt(data[i][6]));
			temp[i].setDepotID(Integer.parseInt(data[i][7]));


		}
		return(temp);
	}
	public static clsVehicleBookingReport[] getVehicleBookingReportInformation(int vehicleID)
	{
		String SPACE = " ";
		String COMMA = ",";
		String SQ = "'";

		String Query = "SELECT" + SPACE +
					   "b.BookingID," + SPACE +
					   "CONCAT(b.BookingYearNo, '-', LPAD(b.BookingMonthNo, 2, '0'), '-', LPAD(b.BookingDayNo, 2, '0')) AS BookingDate," + SPACE +
					   "ds.DepotName AS SourceDepotName," + SPACE +
					   "dd.DepotName AS DestinationDepotName," + SPACE +
					   "v.VehicleNumber" + SPACE +
					   "FROM" + SPACE +
					   "dbProjectData.tblBooking b" + SPACE +
					   "JOIN dbProjectData.tblDepot ds ON b.SourceDepotID = ds.DepotID" + SPACE +
					   "JOIN dbProjectData.tblDepot dd ON b.DestinationDepotID = dd.DepotID" + SPACE +
					   "JOIN dbProjectData.tblVehicle v ON b.VehicleID = v.VehicleID" + SPACE +
					   "WHERE" + SPACE +
					   "b.VehicleID = " + String.valueOf(vehicleID);

		String data[][] = QueryExecutor.getAllObjectInformation(Query, 5);

		if (data == null || data.length == 0) {
			return new clsVehicleBookingReport[0];
		}

		clsVehicleBookingReport[] reports = new clsVehicleBookingReport[data.length];

		for (int i = 0; i < data.length; i++) {
			reports[i] = new clsVehicleBookingReport();
			reports[i].setBookingID(Integer.parseInt(data[i][0]));
			reports[i].setBookingDate(data[i][1]);
			reports[i].setSourceDepotName(data[i][2]);
			reports[i].setDestinationDepotName(data[i][3]);
			reports[i].setVehicleName(data[i][4]);
		}

		return reports;
	}
	public static clsVehicleBookingReport[] getVehicleBookingReportByNumber(String vehicleNumber)
	{
		String SPACE = " ";
		String COMMA = ",";
		String SQ = "'";

		String Query = "SELECT" + SPACE +
					   "b.BookingID," + SPACE +
					   "CONCAT(b.BookingYearNo, '-', LPAD(b.BookingMonthNo, 2, '0'), '-', LPAD(b.BookingDayNo, 2, '0')) AS BookingDate," + SPACE +
					   "ds.DepotName AS SourceDepotName," + SPACE +
					   "dd.DepotName AS DestinationDepotName," + SPACE +
					   "v.VehicleNumber" + SPACE +
					   "FROM" + SPACE +
					   "dbProjectData.tblBooking b" + SPACE +
					   "JOIN dbProjectData.tblDepot ds ON b.SourceDepotID = ds.DepotID" + SPACE +
					   "JOIN dbProjectData.tblDepot dd ON b.DestinationDepotID = dd.DepotID" + SPACE +
					   "JOIN dbProjectData.tblVehicle v ON b.VehicleID = v.VehicleID" + SPACE +
					   "WHERE" + SPACE +
					   "v.VehicleNumber = " + SQ + vehicleNumber + SQ;

		String data[][] = QueryExecutor.getAllObjectInformation(Query, 5);

		if (data == null || data.length == 0)
		{
			return new clsVehicleBookingReport[0];
		}

		clsVehicleBookingReport[] reports = new clsVehicleBookingReport[data.length];

		for (int i = 0; i < data.length; i++)
		{
			reports[i] = new clsVehicleBookingReport();
			reports[i].setBookingID(Integer.parseInt(data[i][0]));
			reports[i].setBookingDate(data[i][1]);
			reports[i].setSourceDepotName(data[i][2]);
			reports[i].setDestinationDepotName(data[i][3]);
			reports[i].setVehicleName(data[i][4]);
		}

		return reports;
	}
}
