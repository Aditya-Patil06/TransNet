import java.util.*;

public class dlsTalukaArea
{
	public static void addNewArea(clsTalukaArea temp)
	{
		String SQ = "'";
		String COMMA = ",";
		String SPACE = " ";

		String Query = "INSERT INTO dbProjectData.tblTalukaArea " + SPACE +
				"(AreaName,TalukaID) " + SPACE +
				"VALUES (" + SPACE +
				SQ + temp.getAreaName() + SQ + COMMA +
				String.valueOf(temp.getTalukaID()) +
				")";

		QueryExecutor.processQuery(Query);
	}

	public static void updateArea(clsTalukaArea temp)
	{
		String SQ = "'";
		String COMMA = ",";
		String SPACE = " ";

		String Query = "update dbProjectData.tblTalukaArea set " + SPACE +
				"AreaName=" + SQ + temp.getAreaName() + SQ + SPACE + COMMA +
				"TalukaID=" + String.valueOf(temp.getTalukaID()) + SPACE +
				"where AreaID=" + String.valueOf(temp.getAreaID());

		QueryExecutor.processQuery(Query);
	}

	public static void deleteArea(clsTalukaArea temp)
	{
		String Query = "delete from dbProjectData.tblTalukaArea where AreaID="
				+ temp.getAreaID();

		QueryExecutor.processQuery(Query);
	}

	public static int getIDFromName(String mAreaName)
	{
		String Query = "select AreaID from tblTalukaArea where AreaName='"
				+ mAreaName + "'";

		return QueryExecutor.getIDFromName(Query);
	}

	public static String[] getAllAreaNames()
	{
		String Query = "select AreaName from dbProjectData.tblTalukaArea";
		return QueryExecutor.getSingleColumn(Query);
	}

	public static String[] getAllAreaNames(int mTalukaID)
	{
		String Query = "select AreaName from dbProjectData.tblTalukaArea where TalukaID="
				+ String.valueOf(mTalukaID);

		return QueryExecutor.getSingleColumn(Query);
	}

	public static clsTalukaArea getAreaInformation(int mAreaID)
	{
		String Query = "select * from tblTalukaArea where AreaID="
				+ String.valueOf(mAreaID);

		String values[] = QueryExecutor.getSingleRow(Query, 3);

		clsTalukaArea temp = new clsTalukaArea();

		temp.setAreaID(Integer.parseInt(values[0]));
		temp.setAreaName(values[1]);
		temp.setTalukaID(Integer.parseInt(values[2]));

		return temp;
	}

	public static clsTalukaArea[] getAllTalukaAreaInformation()
	{
		String Query = "select * from tblTalukaArea";

		String data[][] = QueryExecutor.getAllObjectInformation(Query, 3);

		clsTalukaArea temp[] = new clsTalukaArea[data.length];

		for(int i = 0; i < data.length; i++)
		{
			temp[i] = new clsTalukaArea();

			temp[i].setAreaID(Integer.parseInt(data[i][0]));
			temp[i].setAreaName(data[i][1]);
			temp[i].setTalukaID(Integer.parseInt(data[i][2]));
		}

		return temp;
	}

	// ============================
	// TALUKA AREA REPORT
	// ============================

	public static clsTalukaAreaReport1[] getTalukaAreaReport1Info()
	{
		String Query =
				"SELECT c.CountryID, c.CountryName, " +
						"s.StateID, s.StateName, " +
						"d.DistrictID, d.DistrictName, " +
						"t.TalukaID, t.TalukaName, " +
						"a.AreaID, a.AreaName " +
						"FROM dbProjectData.tblTalukaArea a " +
						"JOIN dbProjectData.tblTaluka t " +
						"ON a.TalukaID = t.TalukaID " +
						"JOIN dbProjectData.tblDistrict d " +
						"ON t.DistrictID = d.DistrictID " +
						"JOIN dbProjectData.tblState s " +
						"ON d.StateID = s.StateID " +
						"JOIN dbProjectData.tblCountry c " +
						"ON s.CountryID = c.CountryID";

		String data[][] = QueryExecutor.getAllObjectInformation(Query, 10);

		clsTalukaAreaReport1 temp[] =
				new clsTalukaAreaReport1[data.length];

		for(int i = 0; i < data.length; i++)
		{
			temp[i] = new clsTalukaAreaReport1();

			temp[i].setCountryID(Integer.parseInt(data[i][0]));
			temp[i].setCountryName(data[i][1]);

			temp[i].setStateID(Integer.parseInt(data[i][2]));
			temp[i].setStateName(data[i][3]);

			temp[i].setDistrictID(Integer.parseInt(data[i][4]));
			temp[i].setDistrictName(data[i][5]);

			temp[i].setTalukaID(Integer.parseInt(data[i][6]));
			temp[i].setTalukaName(data[i][7]);

			temp[i].setTalukaAreaID(Integer.parseInt(data[i][8]));
			temp[i].setTalukaAreaName(data[i][9]);
		}

		return temp;
	}

	public static clsTalukaAreaReport1[] getTalukaAreaReport1Info(int mTalukaAreaID)
	{
		String Query =
				"SELECT c.CountryID, c.CountryName, " +
						"s.StateID, s.StateName, " +
						"d.DistrictID, d.DistrictName, " +
						"t.TalukaID, t.TalukaName, " +
						"a.AreaID, a.AreaName " +
						"FROM dbProjectData.tblTalukaArea a " +
						"JOIN dbProjectData.tblTaluka t " +
						"ON a.TalukaID = t.TalukaID " +
						"JOIN dbProjectData.tblDistrict d " +
						"ON t.DistrictID = d.DistrictID " +
						"JOIN dbProjectData.tblState s " +
						"ON d.StateID = s.StateID " +
						"JOIN dbProjectData.tblCountry c " +
						"ON s.CountryID = c.CountryID " +
						"WHERE a.AreaID = " + mTalukaAreaID;

		String data[][] = QueryExecutor.getAllObjectInformation(Query, 10);

		clsTalukaAreaReport1 temp[] =
				new clsTalukaAreaReport1[data.length];

		for(int i = 0; i < data.length; i++)
		{
			temp[i] = new clsTalukaAreaReport1();

			temp[i].setCountryID(Integer.parseInt(data[i][0]));
			temp[i].setCountryName(data[i][1]);

			temp[i].setStateID(Integer.parseInt(data[i][2]));
			temp[i].setStateName(data[i][3]);

			temp[i].setDistrictID(Integer.parseInt(data[i][4]));
			temp[i].setDistrictName(data[i][5]);

			temp[i].setTalukaID(Integer.parseInt(data[i][6]));
			temp[i].setTalukaName(data[i][7]);

			temp[i].setTalukaAreaID(Integer.parseInt(data[i][8]));
			temp[i].setTalukaAreaName(data[i][9]);
		}

		return temp;
	}
}