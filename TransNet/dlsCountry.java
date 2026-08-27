import java.util.*;

public class dlsCountry
{
	public static void addNewCountry(clsCountry temp)
	{

		String SQ = "'";
		String COMMA = ",";
		String SPACE = " ";

		String Query = "insert into dbProjectData.tblCountry" + SPACE +
					   "(CountryID" + COMMA + "CountryName)" +
					   "Value" + SPACE + "(" + temp.getCountryID() + COMMA + SQ + temp.getCountryName() + SQ + ")";

		QueryExecutor.processQuery(Query);

	}

	public static void updateCountry(clsCountry temp)
	{

		String SQ = "'";
		String COMMA = ",";
		String SPACE = " ";

		String Query = "update dbProjectData.tblCountry set" + SPACE +
					   "CountryName=" + SQ + temp.getCountryName() + SQ + SPACE +
					   "where CountryID=" + String.valueOf(temp.getCountryID());

		QueryExecutor.processQuery(Query);

	}

	public static String [] getAllCountryNames()
	{

		String Query = "select CountryName from dbProjectData.tblCountry";
		return(QueryExecutor.getSingleColumn(Query));

	}

	public static int getIDFromName(String mCountryName)
	{

		String Query = "select CountryID from tblCountry where CountryName='"+mCountryName+"'";

		return QueryExecutor.getIDFromName(Query);

	}
	public static String getNameFromID(int mCountryID)
	{

		String Query = "select CountryName from tblCountry where CountryID="+String.valueOf(mCountryID);

		return QueryExecutor.getNameFromID(Query);

	}

	public static int getAllCountryCount()
	{

		String Query = "select count(CountryID) from dbProjectData.tblCountry";
		return(QueryExecutor.getRowsCount(Query));

	}


	public static clsCountry getCountryInformation(int mCountryID)
	{

		String Query = "select * from tblCountry where CountryID="+String.valueOf(mCountryID);

		String data[] = QueryExecutor.getObjectInformation(Query,2);

		clsCountry temp = new clsCountry();

		temp.setCountryID(Integer.parseInt(data[0]));
		temp.setCountryName(data[1]);
		return(temp);

	}

	public static void deleteCountry(clsCountry temp)
	{

		String SQ = "'";
		String COMMA = ",";
		String SPACE = " ";

		String Query = "delete from dbProjectData.tblCountry where CountryID="+temp.getCountryID();

		QueryExecutor.processQuery(Query);

	}
	public static clsCountry [] getAllCountryInformation()
	{
		String Query = "select * from tblCountry";

		String data[][] = QueryExecutor.getAllObjectInformation(Query,2);
		clsCountry temp[] = new clsCountry[data.length];

		for(int i=0;i<data.length;i++)
		{
			temp[i]=new clsCountry();
			temp[i].setCountryID(Integer.parseInt(data[i][0]));
			temp[i].setCountryName(data[i][1]);
		}
		return(temp);
	}
}
