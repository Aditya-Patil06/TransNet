import java.util.*;

public class dlsGeneral
{
    public static clsGeneralBookingReport[] getAllBookingInformation()
    {
        String SPACE = " ";
        String query = "SELECT" + SPACE +
                       "b.BookingID," + SPACE +
                       "b.BookingDayNo," + SPACE +
                       "b.BookingMonthNo," + SPACE +
                       "b.BookingYearNo," + SPACE +
                       "b.ClientID," + SPACE +
                       "b.SourceDepotID," + SPACE +
                       "b.GenerateDocketID," + SPACE +
                       "b.VehicleID," + SPACE +
                       "b.DestinationDepotID," + SPACE +
                       "b.DeliveryParty," + SPACE +
                       "b.ContactNo," + SPACE +
                       "b.EmailID," + SPACE +
                       "b.Address," + SPACE +
                       "c.ClientName," + SPACE +
                       "sd.DepotName AS SourceDepot," + SPACE +
                       "v.VehicleNumber," + SPACE +
                       "dd.DepotName AS DestinationDepot," + SPACE +
                       "gd.GenerateDocketName" + SPACE +
                       "FROM dbProjectData.tblBooking b" + SPACE +
                       "LEFT JOIN dbProjectData.tblClient c ON b.ClientID = c.ClientID" + SPACE +
                       "LEFT JOIN dbProjectData.tblDepot sd ON b.SourceDepotID = sd.DepotID" + SPACE +
                       "LEFT JOIN dbProjectData.tblVehicle v ON b.VehicleID = v.VehicleID" + SPACE +
                       "LEFT JOIN dbProjectData.tblDepot dd ON b.DestinationDepotID = dd.DepotID" + SPACE +
                       "LEFT JOIN dbProjectData.tblGenerateDocket gd ON b.GenerateDocketID = gd.GenerateDocketID";

        String[][] data = QueryExecutor.getAllObjectInformation(query, 18); // Updated to 18 columns

        if (data == null || data.length == 0)
        {
            return new clsGeneralBookingReport[0];
        }

        clsGeneralBookingReport[] reports = new clsGeneralBookingReport[data.length];

        for (int i = 0; i < data.length; i++)
        {
            clsGeneralBookingReport temp = new clsGeneralBookingReport();
            temp.setBookingID(Integer.parseInt(data[i][0]));
            temp.setBookingDayNo(Integer.parseInt(data[i][1]));
            temp.setBookingMonthNo(Integer.parseInt(data[i][2]));
            temp.setBookingYearNo(Integer.parseInt(data[i][3]));
            temp.setClientID(Integer.parseInt(data[i][4]));
            temp.setSourceDepotID(Integer.parseInt(data[i][5]));
            temp.setDocketNo(Integer.parseInt(data[i][6]));
            temp.setVehicleID(Integer.parseInt(data[i][7]));
            temp.setDestinationDepotID(Integer.parseInt(data[i][8]));
            temp.setDiliverParty(data[i][9]);
            temp.setContactNo(data[i][10]);
            temp.setEmailID(data[i][11]);
            temp.setAddress(data[i][12]);
            temp.setClientName(data[i][13]);
            temp.setSourceDepotName(data[i][14]);
            temp.setVehicleNumber(data[i][15]);
            temp.setDestinationDepotName(data[i][16]);
            temp.setGenerateDocketName(data[i][17]); // New field
            reports[i] = temp;
        }

        return reports;
    }

    public static clsGeneralBookingReport[] getDateBookingReportInformation(String date)
    {
        if (date == null || date.isEmpty() || !date.matches("\\d{2}/\\d{2}/\\d{4}"))
        {
            return new clsGeneralBookingReport[0];
        }

        String[] parts = date.split("/");
        int day = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int year = Integer.parseInt(parts[2]);

        String SPACE = " ";
        String query = "SELECT" + SPACE +
                       "b.BookingID," + SPACE +
                       "b.BookingDayNo," + SPACE +
                       "b.BookingMonthNo," + SPACE +
                       "b.BookingYearNo," + SPACE +
                       "b.ClientID," + SPACE +
                       "b.SourceDepotID," + SPACE +
                       "b.GenerateDocketID," + SPACE +
                       "b.VehicleID," + SPACE +
                       "b.DestinationDepotID," + SPACE +
                       "b.DeliveryParty," + SPACE +
                       "b.ContactNo," + SPACE +
                       "b.EmailID," + SPACE +
                       "b.Address," + SPACE +
                       "c.ClientName," + SPACE +
                       "sd.DepotName AS SourceDepot," + SPACE +
                       "v.VehicleNumber," + SPACE +
                       "dd.DepotName AS DestinationDepot," + SPACE +
                       "gd.GenerateDocketName" + SPACE +
                       "FROM dbProjectData.tblBooking b" + SPACE +
                       "LEFT JOIN dbProjectData.tblClient c ON b.ClientID = c.ClientID" + SPACE +
                       "LEFT JOIN dbProjectData.tblDepot sd ON b.SourceDepotID = sd.DepotID" + SPACE +
                       "LEFT JOIN dbProjectData.tblVehicle v ON b.VehicleID = v.VehicleID" + SPACE +
                       "LEFT JOIN dbProjectData.tblDepot dd ON b.DestinationDepotID = dd.DepotID" + SPACE +
                       "LEFT JOIN dbProjectData.tblGenerateDocket gd ON b.GenerateDocketID = gd.GenerateDocketID" + SPACE +
                       "WHERE b.BookingDayNo = " + day + " AND b.BookingMonthNo = " + month + " AND b.BookingYearNo = " + year;

        String[][] data = QueryExecutor.getAllObjectInformation(query, 18); // Updated to 18 columns

        if (data == null || data.length == 0)
        {
            return new clsGeneralBookingReport[0];
        }

        clsGeneralBookingReport[] reports = new clsGeneralBookingReport[data.length];
        for (int i = 0; i < data.length; i++)
        {
            clsGeneralBookingReport temp = new clsGeneralBookingReport();
            temp.setBookingID(Integer.parseInt(data[i][0]));
            temp.setBookingDayNo(Integer.parseInt(data[i][1]));
            temp.setBookingMonthNo(Integer.parseInt(data[i][2]));
            temp.setBookingYearNo(Integer.parseInt(data[i][3]));
            temp.setClientID(Integer.parseInt(data[i][4]));
            temp.setSourceDepotID(Integer.parseInt(data[i][5]));
            temp.setDocketNo(Integer.parseInt(data[i][6]));
            temp.setVehicleID(Integer.parseInt(data[i][7]));
            temp.setDestinationDepotID(Integer.parseInt(data[i][8]));
            temp.setDiliverParty(data[i][9]);
            temp.setContactNo(data[i][10]);
            temp.setEmailID(data[i][11]);
            temp.setAddress(data[i][12]);
            temp.setClientName(data[i][13]);
            temp.setSourceDepotName(data[i][14]);
            temp.setVehicleNumber(data[i][15]);
            temp.setDestinationDepotName(data[i][16]);
            temp.setGenerateDocketName(data[i][17]); // New field
            reports[i] = temp;
        }
        return reports;
    }

    public static clsGeneralBookingReport[] getMonthBookingReportInformation(String monthYear)
    {
        if (monthYear == null || monthYear.isEmpty() || !monthYear.matches("\\d{2}/\\d{4}"))
        {
            return new clsGeneralBookingReport[0];
        }

        String[] parts = monthYear.split("/");
        int month = Integer.parseInt(parts[0]);
        int year = Integer.parseInt(parts[1]);

        String SPACE = " ";
        String query = "SELECT" + SPACE +
                       "b.BookingID," + SPACE +
                       "b.BookingDayNo," + SPACE +
                       "b.BookingMonthNo," + SPACE +
                       "b.BookingYearNo," + SPACE +
                       "b.ClientID," + SPACE +
                       "b.SourceDepotID," + SPACE +
                       "b.GenerateDocketID," + SPACE +
                       "b.VehicleID," + SPACE +
                       "b.DestinationDepotID," + SPACE +
                       "b.DeliveryParty," + SPACE +
                       "b.ContactNo," + SPACE +
                       "b.EmailID," + SPACE +
                       "b.Address," + SPACE +
                       "c.ClientName," + SPACE +
                       "sd.DepotName AS SourceDepot," + SPACE +
                       "v.VehicleNumber," + SPACE +
                       "dd.DepotName AS DestinationDepot," + SPACE +
                       "gd.GenerateDocketName" + SPACE +
                       "FROM dbProjectData.tblBooking b" + SPACE +
                       "LEFT JOIN dbProjectData.tblClient c ON b.ClientID = c.ClientID" + SPACE +
                       "LEFT JOIN dbProjectData.tblDepot sd ON b.SourceDepotID = sd.DepotID" + SPACE +
                       "LEFT JOIN dbProjectData.tblVehicle v ON b.VehicleID = v.VehicleID" + SPACE +
                       "LEFT JOIN dbProjectData.tblDepot dd ON b.DestinationDepotID = dd.DepotID" + SPACE +
                       "LEFT JOIN dbProjectData.tblGenerateDocket gd ON b.GenerateDocketID = gd.GenerateDocketID" + SPACE +
                       "WHERE b.BookingMonthNo = " + month + " AND b.BookingYearNo = " + year;

        String[][] data = QueryExecutor.getAllObjectInformation(query, 18); // Updated to 18 columns

        if (data == null || data.length == 0)
        {
            return new clsGeneralBookingReport[0];
        }

        clsGeneralBookingReport[] reports = new clsGeneralBookingReport[data.length];
        for (int i = 0; i < data.length; i++)
        {
            clsGeneralBookingReport temp = new clsGeneralBookingReport();
            temp.setBookingID(Integer.parseInt(data[i][0]));
            temp.setBookingDayNo(Integer.parseInt(data[i][1]));
            temp.setBookingMonthNo(Integer.parseInt(data[i][2]));
            temp.setBookingYearNo(Integer.parseInt(data[i][3]));
            temp.setClientID(Integer.parseInt(data[i][4]));
            temp.setSourceDepotID(Integer.parseInt(data[i][5]));
            temp.setDocketNo(Integer.parseInt(data[i][6]));
            temp.setVehicleID(Integer.parseInt(data[i][7]));
            temp.setDestinationDepotID(Integer.parseInt(data[i][8]));
            temp.setDiliverParty(data[i][9]);
            temp.setContactNo(data[i][10]);
            temp.setEmailID(data[i][11]);
            temp.setAddress(data[i][12]);
            temp.setClientName(data[i][13]);
            temp.setSourceDepotName(data[i][14]);
            temp.setVehicleNumber(data[i][15]);
            temp.setDestinationDepotName(data[i][16]);
            temp.setGenerateDocketName(data[i][17]); // New field
            reports[i] = temp;
        }
        return reports;
    }

    public static clsGeneralBookingReport[] getYearBookingReportInformation(String year)
    {
        if (year == null || year.isEmpty() || !year.matches("\\d{4}"))
        {
            return new clsGeneralBookingReport[0];
        }

        int yearNum = Integer.parseInt(year);

        String SPACE = " ";
        String query = "SELECT" + SPACE +
                       "b.BookingID," + SPACE +
                       "b.BookingDayNo," + SPACE +
                       "b.BookingMonthNo," + SPACE +
                       "b.BookingYearNo," + SPACE +
                       "b.ClientID," + SPACE +
                       "b.SourceDepotID," + SPACE +
                       "b.GenerateDocketID," + SPACE +
                       "b.VehicleID," + SPACE +
                       "b.DestinationDepotID," + SPACE +
                       "b.DeliveryParty," + SPACE +
                       "b.ContactNo," + SPACE +
                       "b.EmailID," + SPACE +
                       "b.Address," + SPACE +
                       "c.ClientName," + SPACE +
                       "sd.DepotName AS SourceDepot," + SPACE +
                       "v.VehicleNumber," + SPACE +
                       "dd.DepotName AS DestinationDepot," + SPACE +
                       "gd.GenerateDocketName" + SPACE +
                       "FROM dbProjectData.tblBooking b" + SPACE +
                       "LEFT JOIN dbProjectData.tblClient c ON b.ClientID = c.ClientID" + SPACE +
                       "LEFT JOIN dbProjectData.tblDepot sd ON b.SourceDepotID = sd.DepotID" + SPACE +
                       "LEFT JOIN dbProjectData.tblVehicle v ON b.VehicleID = v.VehicleID" + SPACE +
                       "LEFT JOIN dbProjectData.tblDepot dd ON b.DestinationDepotID = dd.DepotID" + SPACE +
                       "LEFT JOIN dbProjectData.tblGenerateDocket gd ON b.GenerateDocketID = gd.GenerateDocketID" + SPACE +
                       "WHERE b.BookingYearNo = " + yearNum;

        String[][] data = QueryExecutor.getAllObjectInformation(query, 18); // Updated to 18 columns

        if (data == null || data.length == 0)
        {
            return new clsGeneralBookingReport[0];
        }

        clsGeneralBookingReport[] reports = new clsGeneralBookingReport[data.length];
        for (int i = 0; i < data.length; i++)
        {
            clsGeneralBookingReport temp = new clsGeneralBookingReport();
            temp.setBookingID(Integer.parseInt(data[i][0]));
            temp.setBookingDayNo(Integer.parseInt(data[i][1]));
            temp.setBookingMonthNo(Integer.parseInt(data[i][2]));
            temp.setBookingYearNo(Integer.parseInt(data[i][3]));
            temp.setClientID(Integer.parseInt(data[i][4]));
            temp.setSourceDepotID(Integer.parseInt(data[i][5]));
            temp.setDocketNo(Integer.parseInt(data[i][6]));
            temp.setVehicleID(Integer.parseInt(data[i][7]));
            temp.setDestinationDepotID(Integer.parseInt(data[i][8]));
            temp.setDiliverParty(data[i][9]);
            temp.setContactNo(data[i][10]);
            temp.setEmailID(data[i][11]);
            temp.setAddress(data[i][12]);
            temp.setClientName(data[i][13]);
            temp.setSourceDepotName(data[i][14]);
            temp.setVehicleNumber(data[i][15]);
            temp.setDestinationDepotName(data[i][16]);
            temp.setGenerateDocketName(data[i][17]); // New field
            reports[i] = temp;
        }
        return reports;
    }

    public static clsGeneralBookingReport[] getClientBookingReportInformation(int clientID)
    {
        if (clientID <= 0)
        {
            return new clsGeneralBookingReport[0];
        }

        String SPACE = " ";
        String query = "SELECT" + SPACE +
                       "b.BookingID," + SPACE +
                       "b.BookingDayNo," + SPACE +
                       "b.BookingMonthNo," + SPACE +
                       "b.BookingYearNo," + SPACE +
                       "b.ClientID," + SPACE +
                       "b.SourceDepotID," + SPACE +
                       "b.GenerateDocketID," + SPACE +
                       "b.VehicleID," + SPACE +
                       "b.DestinationDepotID," + SPACE +
                       "b.DeliveryParty," + SPACE +
                       "b.ContactNo," + SPACE +
                       "b.EmailID," + SPACE +
                       "b.Address," + SPACE +
                       "c.ClientName," + SPACE +
                       "sd.DepotName AS SourceDepot," + SPACE +
                       "v.VehicleNumber," + SPACE +
                       "dd.DepotName AS DestinationDepot," + SPACE +
                       "gd.GenerateDocketName" + SPACE +
                       "FROM dbProjectData.tblBooking b" + SPACE +
                       "LEFT JOIN dbProjectData.tblClient c ON b.ClientID = c.ClientID" + SPACE +
                       "LEFT JOIN dbProjectData.tblDepot sd ON b.SourceDepotID = sd.DepotID" + SPACE +
                       "LEFT JOIN dbProjectData.tblVehicle v ON b.VehicleID = v.VehicleID" + SPACE +
                       "LEFT JOIN dbProjectData.tblDepot dd ON b.DestinationDepotID = dd.DepotID" + SPACE +
                       "LEFT JOIN dbProjectData.tblGenerateDocket gd ON b.GenerateDocketID = gd.GenerateDocketID" + SPACE +
                       "WHERE b.ClientID = " + clientID;

        String[][] data = QueryExecutor.getAllObjectInformation(query, 18); // Updated to 18 columns

        if (data == null || data.length == 0)
        {
            return new clsGeneralBookingReport[0];
        }

        clsGeneralBookingReport[] reports = new clsGeneralBookingReport[data.length];
        for (int i = 0; i < data.length; i++)
        {
            clsGeneralBookingReport temp = new clsGeneralBookingReport();
            temp.setBookingID(Integer.parseInt(data[i][0]));
            temp.setBookingDayNo(Integer.parseInt(data[i][1]));
            temp.setBookingMonthNo(Integer.parseInt(data[i][2]));
            temp.setBookingYearNo(Integer.parseInt(data[i][3]));
            temp.setClientID(Integer.parseInt(data[i][4]));
            temp.setSourceDepotID(Integer.parseInt(data[i][5]));
            temp.setDocketNo(Integer.parseInt(data[i][6]));
            temp.setVehicleID(Integer.parseInt(data[i][7]));
            temp.setDestinationDepotID(Integer.parseInt(data[i][8]));
            temp.setDiliverParty(data[i][9]);
            temp.setContactNo(data[i][10]);
            temp.setEmailID(data[i][11]);
            temp.setAddress(data[i][12]);
            temp.setClientName(data[i][13]);
            temp.setSourceDepotName(data[i][14]);
            temp.setVehicleNumber(data[i][15]);
            temp.setDestinationDepotName(data[i][16]);
            temp.setGenerateDocketName(data[i][17]); // New field
            reports[i] = temp;
        }
        return reports;
    }

    public static clsGeneralBookingReport[] getDepotBookingReportInformation(int depotID)
    {
        if (depotID <= 0)
        {
            return new clsGeneralBookingReport[0];
        }

        String SPACE = " ";
        String query = "SELECT" + SPACE +
                       "b.BookingID," + SPACE +
                       "b.BookingDayNo," + SPACE +
                       "b.BookingMonthNo," + SPACE +
                       "b.BookingYearNo," + SPACE +
                       "b.ClientID," + SPACE +
                       "b.SourceDepotID," + SPACE +
                       "b.GenerateDocketID," + SPACE +
                       "b.VehicleID," + SPACE +
                       "b.DestinationDepotID," + SPACE +
                       "b.DeliveryParty," + SPACE +
                       "b.ContactNo," + SPACE +
                       "b.EmailID," + SPACE +
                       "b.Address," + SPACE +
                       "c.ClientName," + SPACE +
                       "sd.DepotName AS SourceDepot," + SPACE +
                       "v.VehicleNumber," + SPACE +
                       "dd.DepotName AS DestinationDepot," + SPACE +
                       "gd.GenerateDocketName" + SPACE +
                       "FROM dbProjectData.tblBooking b" + SPACE +
                       "LEFT JOIN dbProjectData.tblClient c ON b.ClientID = c.ClientID" + SPACE +
                       "LEFT JOIN dbProjectData.tblDepot sd ON b.SourceDepotID = sd.DepotID" + SPACE +
                       "LEFT JOIN dbProjectData.tblVehicle v ON b.VehicleID = v.VehicleID" + SPACE +
                       "LEFT JOIN dbProjectData.tblDepot dd ON b.DestinationDepotID = dd.DepotID" + SPACE +
                       "LEFT JOIN dbProjectData.tblGenerateDocket gd ON b.GenerateDocketID = gd.GenerateDocketID" + SPACE +
                       "WHERE b.SourceDepotID = " + depotID + " OR b.DestinationDepotID = " + depotID;

        String[][] data = QueryExecutor.getAllObjectInformation(query, 18); // Updated to 18 columns

        if (data == null || data.length == 0)
        {
            return new clsGeneralBookingReport[0];
        }

        clsGeneralBookingReport[] reports = new clsGeneralBookingReport[data.length];
        for (int i = 0; i < data.length; i++)
        {
            clsGeneralBookingReport temp = new clsGeneralBookingReport();
            temp.setBookingID(Integer.parseInt(data[i][0]));
            temp.setBookingDayNo(Integer.parseInt(data[i][1]));
            temp.setBookingMonthNo(Integer.parseInt(data[i][2]));
            temp.setBookingYearNo(Integer.parseInt(data[i][3]));
            temp.setClientID(Integer.parseInt(data[i][4]));
            temp.setSourceDepotID(Integer.parseInt(data[i][5]));
            temp.setDocketNo(Integer.parseInt(data[i][6]));
            temp.setVehicleID(Integer.parseInt(data[i][7]));
            temp.setDestinationDepotID(Integer.parseInt(data[i][8]));
            temp.setDiliverParty(data[i][9]);
            temp.setContactNo(data[i][10]);
            temp.setEmailID(data[i][11]);
            temp.setAddress(data[i][12]);
            temp.setClientName(data[i][13]);
            temp.setSourceDepotName(data[i][14]);
            temp.setVehicleNumber(data[i][15]);
            temp.setDestinationDepotName(data[i][16]);
            temp.setGenerateDocketName(data[i][17]); // New field
            reports[i] = temp;
        }
        return reports;
    }
}