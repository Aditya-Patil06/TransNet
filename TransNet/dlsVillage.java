import java.util.*;

public class dlsVillage
{
	public static void addNewVillage(clsVillage temp)
	{
		String SQ = "'";
		String COMMA = ",";
		String SPACE = " ";

		String Query = "INSERT INTO dbProjectData.tblVillage " + SPACE +
					   "(VillageName, TalukaID) " + SPACE +
					   "VALUES (" + SPACE +
					   SQ + temp.getVillageName() + SQ + COMMA +
					   String.valueOf(temp.getTalukaID()) +
					   ")";

		QueryExecutor.processQuery(Query);
	}
	public static void updateVillage(clsVillage temp)
	{
		String SQ = "'";
		String COMMA = ",";
		String SPACE = " ";

		String Query = "update dbProjectData.tblVillage set " + SPACE +
		                "VillageName=" + SQ + temp.getVillageName() + SQ + SPACE + COMMA +
		                "TalukaID=" + String.valueOf(temp.getTalukaID()) + SPACE +
              			"where VillageID=" + String.valueOf(temp.getVillageID());

		QueryExecutor.processQuery(Query);

	}

	public static void deleteVillage(clsVillage temp)
	{
		String SQ = "'";
		String COMMA = ",";
		String SPACE = " ";

		String Query = "delete from dbProjectData.tblVillage where VillageID="+temp.getVillageID();

		QueryExecutor.processQuery(Query);
	}

	public static int getIDFromName(String mVillageName)
	{
	    String Query = "select VillageID from tblVillage where VillageName='" + mVillageName + "'";
	    return QueryExecutor.getIDFromName(Query);
	}
	public static String [] getAllVillageNames()
	{
		String Query = "select VillageName from dbProjectData.tblVillage";
		return(QueryExecutor.getSingleColumn(Query));
	}
	public static String [] getAllVillageNames(int mTalukaID)
	{
		String Query = "select VillageName from dbProjectData.tblVillage where TalukaID="+String.valueOf(mTalukaID);
		return(QueryExecutor.getSingleColumn(Query));
	}


	public static clsVillage getVillageInformation(int mVillageID)
	{
		String Query = "select * from tblVillage where VillageID="+String.valueOf(mVillageID);

		String values[] = QueryExecutor.getSingleRow(Query, 3);

		clsVillage temp = new clsVillage();

		temp.setVillageID(Integer.parseInt(values[0]));
		temp.setVillageName(values[1]);
		temp.setTalukaID(Integer.parseInt(values[2]));

		return(temp);


	}
	public static clsVillageReport1[] getVillageReport1Info()
	{
        String Query = "SELECT v.VillageID, v.VillageName, t.TalukaID, t.TalukaName, " +
                       "d.DistrictID, d.DistrictName, s.StateID, s.StateName, c.CountryID, c.CountryName " +
                       "FROM dbProjectData.tblVillage v " +
                       "JOIN dbProjectData.tblTaluka t ON v.TalukaID = t.TalukaID " +
                       "JOIN dbProjectData.tblDistrict d ON t.DistrictID = d.DistrictID " +
                       "JOIN dbProjectData.tblState s ON d.StateID = s.StateID " +
                       "JOIN dbProjectData.tblCountry c ON s.CountryID = c.CountryID";

        String data[][] = QueryExecutor.getAllObjectInformation(Query, 10);
        clsVillageReport1 temp[] = new clsVillageReport1[data.length];

        for (int i = 0; i < data.length; i++)
        {
            temp[i] = new clsVillageReport1();
            temp[i].setVillageID(Integer.parseInt(data[i][0]));
            temp[i].setVillageName(data[i][1]);
            temp[i].setTalukaID(Integer.parseInt(data[i][2]));
            temp[i].setTalukaName(data[i][3]);
            temp[i].setDistrictID(Integer.parseInt(data[i][4]));
            temp[i].setDistrictName(data[i][5]);
            temp[i].setStateID(Integer.parseInt(data[i][6]));
            temp[i].setStateName(data[i][7]);
            temp[i].setCountryID(Integer.parseInt(data[i][8]));
            temp[i].setCountryName(data[i][9]);
        }
        return temp;
    }

    public static clsVillageReport1[] getVillageReport1Info(int mTalukaID)
    {
        String Query = "SELECT v.VillageID, v.VillageName, t.TalukaID, t.TalukaName, " +
                       "d.DistrictID, d.DistrictName, s.StateID, s.StateName, c.CountryID, c.CountryName " +
                       "FROM dbProjectData.tblVillage v " +
                       "JOIN dbProjectData.tblTaluka t ON v.TalukaID = t.TalukaID " +
                       "JOIN dbProjectData.tblDistrict d ON t.DistrictID = d.DistrictID " +
                       "JOIN dbProjectData.tblState s ON d.StateID = s.StateID " +
                       "JOIN dbProjectData.tblCountry c ON s.CountryID = c.CountryID " +
                       "WHERE v.TalukaID = " + mTalukaID;

        String data[][] = QueryExecutor.getAllObjectInformation(Query, 10);
        clsVillageReport1 temp[] = new clsVillageReport1[data.length];

        for (int i = 0; i < data.length; i++)
        {
            temp[i] = new clsVillageReport1();
            temp[i].setVillageID(Integer.parseInt(data[i][0]));
            temp[i].setVillageName(data[i][1]);
            temp[i].setTalukaID(Integer.parseInt(data[i][2]));
            temp[i].setTalukaName(data[i][3]);
            temp[i].setDistrictID(Integer.parseInt(data[i][4]));
            temp[i].setDistrictName(data[i][5]);
            temp[i].setStateID(Integer.parseInt(data[i][6]));
            temp[i].setStateName(data[i][7]);
            temp[i].setCountryID(Integer.parseInt(data[i][8]));
            temp[i].setCountryName(data[i][9]);
        }
        return temp;
    }
}