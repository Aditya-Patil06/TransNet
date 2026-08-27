import java.util.*;

public class dlsArea
{
	public static void addNewArea(clsArea temp)
	{
		String SQ = "'";
		String COMMA = ",";
		String SPACE = " ";

		String VillageID ;
		if(temp.getVillageID() == 0)
		{
			VillageID = null ;
		}
		else
		{
			VillageID = String.valueOf(temp.getVillageID());
		}

		String Query = "INSERT INTO dbProjectData.tblAreaVillage " + SPACE +
					   "(AreaName,TalukaID, VillageID) " + SPACE +
					   "VALUES (" + SPACE +
					   SQ + temp.getAreaName() + SQ + COMMA +
					   String.valueOf(temp.getTalukaID()) +COMMA+
					   VillageID +
					   ")";
		System.out.println(Query);

		QueryExecutor.processQuery(Query);
	}
	public static void updateArea(clsArea temp)
	{
		String SQ = "'";
		String COMMA = ",";
		String SPACE = " ";

		String Query = "update dbProjectData.tblAreaVillage set " + SPACE +
		                "AreaName=" + SQ + temp.getAreaName() + SQ + SPACE + COMMA +
		                "TalukaID=" + String.valueOf(temp.getTalukaID()) + SPACE +COMMA+
						"VillageID=" + String.valueOf(temp.getVillageID()) + SPACE +
              			"where AreaID=" + String.valueOf(temp.getAreaID());
		QueryExecutor.processQuery(Query);
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@"+Query+"@@@@@@@@@@@@@@@@");

	}

	public static void deleteArea(clsArea temp)
	{
		String SQ = "'";
		String COMMA = ",";
		String SPACE = " ";

		String Query = "delete from dbProjectData.tblAreaVillage where AreaID="+temp.getAreaID();

		QueryExecutor.processQuery(Query);
	}

	public static int getIDFromName(String mAreaName)
	{
	    String Query = "select AreaID from tblAreaVillage where AreaName='" + mAreaName + "'";
	    return QueryExecutor.getIDFromName(Query);
	}
	public static String [] getAllAreaNames()
	{
		String Query = "select AreaName from dbProjectData.tblAreaVillage";
		return(QueryExecutor.getSingleColumn(Query));
	}
	public static String [] getAllAreaNames(int mVillageID)
	{
		String Query = "select AreaName from dbProjectData.tblAreaVillage where VillageID="+String.valueOf(mVillageID);
		System.out.println(Query);
		return(QueryExecutor.getSingleColumn(Query));
	}


	public static clsArea getAreaInformation(int mAreaID)
	{
		String Query = "select * from tblAreaVillage where AreaID="+String.valueOf(mAreaID);

		String values[] = QueryExecutor.getSingleRow(Query, 4);

		clsArea temp = new clsArea();

		temp.setAreaID(Integer.parseInt(values[0]));
		temp.setAreaName(values[1]);
		temp.setTalukaID(Integer.parseInt(values[2]));



		return(temp);


	}
    public static clsAreaReport[] getAreaReportInformation()
    {
	    String Query = "SELECT" +
	            " t.TalukaID," +
	            " t.TalukaName," +
	            " d.DistrictID," +
	            " d.DistrictName," +
	            " s.StateID," +
	            " s.StateName," +
	            " c.CountryID," +
	            " c.CountryName," +
	            " ta.AreaID AS TalukaAreaID," +
	            " ta.AreaName AS TalukaAreaName," +
	            " va.AreaID AS VillageAreaID," +
	            " va.AreaName AS VillageAreaName " +
	            "FROM dbProjectData.tblTaluka t " +
	            "JOIN dbProjectData.tblDistrict d ON t.DistrictID = d.DistrictID " +
	            "JOIN dbProjectData.tblState s ON d.StateID = s.StateID " +
	            "JOIN dbProjectData.tblCountry c ON s.CountryID = c.CountryID " +
	            "LEFT JOIN dbProjectData.tblTalukaArea ta ON t.TalukaID = ta.TalukaID " +
	            "LEFT JOIN dbProjectData.tblVillageArea va ON t.TalukaID = va.TalukaID";

		System.out.println(Query);
	    String[][] data = QueryExecutor.getAllObjectInformation(Query, 12);
	    clsAreaReport[] temp = new clsAreaReport[data.length];

	    for (int i = 0; i < data.length; i++)
	    {
	        temp[i] = new clsAreaReport();
	        temp[i].setTalukaID(data[i][0] != null ? Integer.parseInt(data[i][0]) : 0);
	        temp[i].setTalukaName(data[i][1]); // String, no parsing needed
	        temp[i].setDistrictID(data[i][2] != null ? Integer.parseInt(data[i][2]) : 0);
	        temp[i].setDistrictName(data[i][3]); // String, no parsing needed
	        temp[i].setStateID(data[i][4] != null ? Integer.parseInt(data[i][4]) : 0);
	        temp[i].setStateName(data[i][5]); // String, no parsing needed
	        temp[i].setCountryID(data[i][6] != null ? Integer.parseInt(data[i][6]) : 0);
	        temp[i].setCountryName(data[i][7]); // String, no parsing needed
	        temp[i].setTalukaAreaID(data[i][8] != null ? Integer.parseInt(data[i][8]) : 0);
	        temp[i].setTalukaAreaName(data[i][9]); // String, no parsing needed
	        temp[i].setVillageAreaID(data[i][10] != null ? Integer.parseInt(data[i][10]) : 0);
	        temp[i].setVillageAreaName(data[i][11]); // String, no parsing needed
	    }
	    return temp;
	}
	public static clsAreaReport[] getVillageAreaReportInformation(int mVillageAreaID)
	{
		String Query = "SELECT" +
				" t.TalukaID," +
				" t.TalukaName," +
				" d.DistrictID," +
				" d.DistrictName," +
				" s.StateID," +
				" s.StateName," +
				" c.CountryID," +
				" c.CountryName," +
				" ta.AreaID AS TalukaAreaID," +
				" ta.AreaName AS TalukaAreaName," +
				" va.AreaID AS VillageAreaID," +
				" va.AreaName AS VillageAreaName," +
				" v.VillageID," +
				" v.VillageName " +
				"FROM dbProjectData.tblTaluka t " +
				"JOIN dbProjectData.tblDistrict d ON t.DistrictID = d.DistrictID " +
				"JOIN dbProjectData.tblState s ON d.StateID = s.StateID " +
				"JOIN dbProjectData.tblCountry c ON s.CountryID = c.CountryID " +
				"LEFT JOIN dbProjectData.tblTalukaArea ta ON t.TalukaID = ta.TalukaID " +
				"LEFT JOIN dbProjectData.tblVillageArea va ON t.TalukaID = va.TalukaID " +
				"LEFT JOIN dbProjectData.tblVillage v ON t.TalukaID = v.TalukaID " +
				"WHERE va.AreaID = " + mVillageAreaID;

		String[][] data = QueryExecutor.getAllObjectInformation(Query, 14);
		clsAreaReport[] temp = new clsAreaReport[data.length];

		for (int i = 0; i < data.length; i++) {
			temp[i] = new clsAreaReport();
			temp[i].setTalukaID(data[i][0] != null ? Integer.parseInt(data[i][0]) : 0);
			temp[i].setTalukaName(data[i][1]);
			temp[i].setDistrictID(data[i][2] != null ? Integer.parseInt(data[i][2]) : 0);
			temp[i].setDistrictName(data[i][3]);
			temp[i].setStateID(data[i][4] != null ? Integer.parseInt(data[i][4]) : 0);
			temp[i].setStateName(data[i][5]);
			temp[i].setCountryID(data[i][6] != null ? Integer.parseInt(data[i][6]) : 0);
			temp[i].setCountryName(data[i][7]);
			temp[i].setTalukaAreaID(data[i][8] != null ? Integer.parseInt(data[i][8]) : 0);
			temp[i].setTalukaAreaName(data[i][9]);
			temp[i].setVillageAreaID(data[i][10] != null ? Integer.parseInt(data[i][10]) : 0);
			temp[i].setVillageAreaName(data[i][11]);
			temp[i].setVillageID(data[i][12] != null ? Integer.parseInt(data[i][12]) : 0);
			temp[i].setVillageName(data[i][13]);
		}
		return temp;
	}
	public static clsAreaReport[] getTalukaAreaReportInformation(int mTalukaAreaID)
	{
		String Query = "SELECT" +
				" t.TalukaID," +
				" t.TalukaName," +
				" d.DistrictID," +
				" d.DistrictName," +
				" s.StateID," +
				" s.StateName," +
				" c.CountryID," +
				" c.CountryName," +
				" ta.AreaID AS TalukaAreaID," +
				" ta.AreaName AS TalukaAreaName," +
				" va.AreaID AS VillageAreaID," +
				" va.AreaName AS VillageAreaName," +
				" v.VillageID," +
				" v.VillageName " +
				"FROM dbProjectData.tblTaluka t " +
				"JOIN dbProjectData.tblDistrict d ON t.DistrictID = d.DistrictID " +
				"JOIN dbProjectData.tblState s ON d.StateID = s.StateID " +
				"JOIN dbProjectData.tblCountry c ON s.CountryID = c.CountryID " +
				"LEFT JOIN dbProjectData.tblTalukaArea ta ON t.TalukaID = ta.TalukaID " +
				"LEFT JOIN dbProjectData.tblVillageArea va ON t.TalukaID = va.TalukaID " +
				"LEFT JOIN dbProjectData.tblVillage v ON t.TalukaID = v.TalukaID " +
				"WHERE ta.AreaID = " + mTalukaAreaID;

		String[][] data = QueryExecutor.getAllObjectInformation(Query, 14);
		clsAreaReport[] temp = new clsAreaReport[data.length];

		for (int i = 0; i < data.length; i++) {
			temp[i] = new clsAreaReport();
			temp[i].setTalukaID(data[i][0] != null ? Integer.parseInt(data[i][0]) : 0);
			temp[i].setTalukaName(data[i][1]);
			temp[i].setDistrictID(data[i][2] != null ? Integer.parseInt(data[i][2]) : 0);
			temp[i].setDistrictName(data[i][3]);
			temp[i].setStateID(data[i][4] != null ? Integer.parseInt(data[i][4]) : 0);
			temp[i].setStateName(data[i][5]);
			temp[i].setCountryID(data[i][6] != null ? Integer.parseInt(data[i][6]) : 0);
			temp[i].setCountryName(data[i][7]);
			temp[i].setTalukaAreaID(data[i][8] != null ? Integer.parseInt(data[i][8]) : 0);
			temp[i].setTalukaAreaName(data[i][9]);
			temp[i].setVillageAreaID(data[i][10] != null ? Integer.parseInt(data[i][10]) : 0);
			temp[i].setVillageAreaName(data[i][11]);
			temp[i].setVillageID(data[i][12] != null ? Integer.parseInt(data[i][12]) : 0);
			temp[i].setVillageName(data[i][13]);
		}
		return temp;
	}
}