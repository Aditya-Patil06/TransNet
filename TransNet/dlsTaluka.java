import java.util.*;

public class dlsTaluka
{
	public static void addNewTaluka(clsTaluka temp)
	{
		String SQ = "'";
		String COMMA = ",";
		String SPACE = " ";

		String Query = "insert into dbProjectData.tblTaluka" + SPACE +
					   "(TalukaName,DistrictID) " +
					   "values (" + SPACE +
					   SQ + temp.getTalukaName() + SQ + COMMA +
					   String.valueOf(temp.getDistrictID()) +
					   ")";

		QueryExecutor.processQuery(Query);

	}
	public static void updateTaluka(clsTaluka temp)
	{
		String SQ = "'";
		String COMMA = ",";
		String SPACE = " ";

		String Query = "update dbProjectData.tblTaluka set" + SPACE +
					   "TalukaName=" + SQ + temp.getTalukaName() + SQ + SPACE + COMMA+
					   "DistrictID=" +String.valueOf(temp.getDistrictID()) +SPACE+
					   "where TalukaID=" + String.valueOf(temp.getTalukaID());

		QueryExecutor.processQuery(Query);

	}

	public static void deleteTaluka(clsTaluka temp)
	{
		String SQ = "'";
		String COMMA = ",";
		String SPACE = " ";

		String Query = "delete from dbProjectData.tblTaluka where TalukaID="+temp.getTalukaID();

		QueryExecutor.processQuery(Query);
	}

	public static int getIDFromName(String mTalukaName)
	{
		String Query = "select TalukaID from tblTaluka where TalukaName='"+mTalukaName+"'";

		return QueryExecutor.getIDFromName(Query);
	}

	public static String [] getAllTalukaNames()
	{
		String Query = "select TalukaName from dbProjectData.tblTaluka";
		return(QueryExecutor.getSingleColumn(Query));
	}
	public static String [] getAllTalukaNames(int mDistrictID)
	{
		String Query = "select TalukaName from dbProjectData.tblTaluka where DistrictID="+String.valueOf(mDistrictID);
		return(QueryExecutor.getSingleColumn(Query));
	}


	public static clsTaluka getTalukaInformation(int mTalukaID)
	{
		String Query = "select * from tblTaluka where TalukaID="+String.valueOf(mTalukaID);

		String values[] = QueryExecutor.getSingleRow(Query,3);

		clsTaluka temp = new clsTaluka();

		temp.setTalukaID(Integer.parseInt(values[0]));
		temp.setTalukaName(values[1]);
		temp.setDistrictID(Integer.parseInt(values[2]));
		return(temp);


	}
	public static clsTalukaReport1[] getTalukaReport1Info()
	{
        String Query = "SELECT t.TalukaID, t.TalukaName, d.DistrictID, d.DistrictName, " +
                       "s.StateID, s.StateName, c.CountryID, c.CountryName " +
                       "FROM dbProjectData.tblTaluka t " +
                       "JOIN dbProjectData.tblDistrict d ON t.DistrictID = d.DistrictID " +
                       "JOIN dbProjectData.tblState s ON d.StateID = s.StateID " +
                       "JOIN dbProjectData.tblCountry c ON s.CountryID = c.CountryID";

        String data[][] = QueryExecutor.getAllObjectInformation(Query, 8);
        clsTalukaReport1 temp[] = new clsTalukaReport1[data.length];

        for (int i = 0; i < data.length; i++)
        {
            temp[i] = new clsTalukaReport1();
            temp[i].setTalukaID(Integer.parseInt(data[i][0]));
            temp[i].setTalukaName(data[i][1]);
            temp[i].setDistrictID(Integer.parseInt(data[i][2]));
            temp[i].setDistrictName(data[i][3]);
            temp[i].setStateID(Integer.parseInt(data[i][4]));
            temp[i].setStateName(data[i][5]);
            temp[i].setCountryID(Integer.parseInt(data[i][6]));
            temp[i].setCountryName(data[i][7]);
        }
        return temp;
    }

    public static clsTalukaReport1[] getTalukaReport1Info(int mDistrictID)
    {
        String Query = "SELECT t.TalukaID, t.TalukaName, d.DistrictID, d.DistrictName, " +
                       "s.StateID, s.StateName, c.CountryID, c.CountryName " +
                       "FROM dbProjectData.tblTaluka t " +
                       "JOIN dbProjectData.tblDistrict d ON t.DistrictID = d.DistrictID " +
                       "JOIN dbProjectData.tblState s ON d.StateID = s.StateID " +
                       "JOIN dbProjectData.tblCountry c ON s.CountryID = c.CountryID " +
                       "WHERE t.DistrictID = " + mDistrictID;

        String data[][] = QueryExecutor.getAllObjectInformation(Query, 8);
        clsTalukaReport1 temp[] = new clsTalukaReport1[data.length];

        for (int i = 0; i < data.length; i++)
        {
            temp[i] = new clsTalukaReport1();
            temp[i].setTalukaID(Integer.parseInt(data[i][0]));
            temp[i].setTalukaName(data[i][1]);
            temp[i].setDistrictID(Integer.parseInt(data[i][2]));
            temp[i].setDistrictName(data[i][3]);
            temp[i].setStateID(Integer.parseInt(data[i][4]));
            temp[i].setStateName(data[i][5]);
            temp[i].setCountryID(Integer.parseInt(data[i][6]));
            temp[i].setCountryName(data[i][7]);
        }
        return temp;
    }
}