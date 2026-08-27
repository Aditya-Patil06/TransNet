import java.util.*;

public class dlsDistrict
{
	public static void addNewDistrict(clsDistrict temp)
	{
		String SQ = "'";
		String COMMA = ",";
		String SPACE = " ";

		String Query = "insert into dbProjectData.tblDistrict" + SPACE +
					   "(DistrictName,StateID) " +
					   "values (" + SPACE +
					   SQ + temp.getDistrictName() + SQ + COMMA +
					   String.valueOf(temp.getStateID()) +
					   ")";

		QueryExecutor.processQuery(Query);

	}
	public static void updateDistrict(clsDistrict temp)
	{
		String SQ = "'";
		String COMMA = ",";
		String SPACE = " ";

		String Query = "update dbProjectData.tblDistrict set" + SPACE +
					   "DistrictName=" + SQ + temp.getDistrictName() + SQ + SPACE + COMMA+
					   "StateID=" +String.valueOf(temp.getStateID()) +SPACE+
					   "where DistrictID=" + String.valueOf(temp.getDistrictID());

		QueryExecutor.processQuery(Query);

	}

	public static void deleteDistrict(clsDistrict temp)
	{
		String SQ = "'";
		String COMMA = ",";
		String SPACE = " ";

		String Query = "delete from dbProjectData.tblDistrict where DistrictID="+temp.getDistrictID();

		QueryExecutor.processQuery(Query);
	}

	public static int getIDFromName(String mDistrictName)
	{
		String Query = "select DistrictID from tblDistrict where DistrictName='"+mDistrictName+"'";

		return QueryExecutor.getIDFromName(Query);
	}

	public static String [] getAllDistrictNames()
	{
		String Query = "select DistrictName from dbProjectData.tblDistrict";
		return(QueryExecutor.getSingleColumn(Query));
	}
	public static String [] getAllDistrictNames(int mStateID)
	{
		String Query = "select DistrictName from dbProjectData.tblDistrict where StateID="+String.valueOf(mStateID);
		return(QueryExecutor.getSingleColumn(Query));
	}


	public static clsDistrict getDistrictInformation(int mDistrictID)
	{
		String Query = "select * from tblDistrict where DistrictID="+String.valueOf(mDistrictID);

		String values[] = QueryExecutor.getSingleRow(Query,3);

		clsDistrict temp = new clsDistrict();

		temp.setDistrictID(Integer.parseInt(values[0]));
		temp.setDistrictName(values[1]);
		temp.setStateID(Integer.parseInt(values[2]));
		return(temp);


	}
	//here
	public static clsDistrict[] getAllDistrictInformation()
		{
			String Query = "select * from tblDistrict";

			String data[][] = QueryExecutor.getAllObjectInformation(Query,3);
			clsDistrict temp[] = new clsDistrict[data.length];

			for(int i=0;i<data.length;i++)
			{
				temp[i]=new clsDistrict();
				temp[i].setDistrictID(Integer.parseInt(data[i][0]));
				temp[i].setDistrictName(data[i][1]);
				temp[i].setStateID(Integer.parseInt(data[i][2]));

			}
			return(temp);
		}
		public static clsDistrictReport1[] getDistrictReport1Info()
		{
			String Query = "SELECT d.DistrictID, d.DistrictName, s.StateID, s.StateName, c.CountryID, c.CountryName " +
						   "FROM dbProjectData.tblDistrict d " +
						   "JOIN dbProjectData.tblState s ON d.StateID = s.StateID " +
						   "JOIN dbProjectData.tblCountry c ON s.CountryID = c.CountryID";

			String data[][] = QueryExecutor.getAllObjectInformation(Query, 6);
			clsDistrictReport1 temp[] = new clsDistrictReport1[data.length];

			for(int i=0;i<data.length;i++)
			{
				temp[i]=new clsDistrictReport1();
				temp[i].setDistrictID(Integer.parseInt(data[i][0]));
				temp[i].setDistrictName(data[i][1]);
				temp[i].setStateID(Integer.parseInt(data[i][2]));
				temp[i].setStateName(data[i][3]);
				temp[i].setCountryID(Integer.parseInt(data[i][4]));
				temp[i].setCountryName(data[i][5]);

			}
			return(temp);
		}


		 public static clsDistrictReport1[] getDistrictReport1Info(int mStateID)
		 {
			String Query = "SELECT d.DistrictID, d.DistrictName, s.StateID, s.StateName, c.CountryID, c.CountryName " +
						   "FROM dbProjectData.tblDistrict d " +
						   "JOIN dbProjectData.tblState s ON d.StateID = s.StateID " +
						   "JOIN dbProjectData.tblCountry c ON s.CountryID = c.CountryID " +
						   "WHERE d.StateID = " + mStateID;
			String data[][] = QueryExecutor.getAllObjectInformation(Query, 6);
			clsDistrictReport1 temp[] = new clsDistrictReport1[data.length];

			for(int i=0;i<data.length;i++)
			{
				temp[i]=new clsDistrictReport1();
				temp[i].setDistrictID(Integer.parseInt(data[i][0]));
				temp[i].setDistrictName(data[i][1]);
				temp[i].setStateID(Integer.parseInt(data[i][2]));
				temp[i].setStateName(data[i][3]);
				temp[i].setCountryID(Integer.parseInt(data[i][4]));
				temp[i].setCountryName(data[i][5]);

			}
			return(temp);
	}
}