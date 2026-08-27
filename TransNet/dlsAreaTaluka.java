import java.util.*;

public class dlsAreaTaluka
{
	public static void addNewArea(clsAreaTaluka temp)
	{
		String SQ = "'";
		String COMMA = ",";
		String SPACE = " ";



		String Query = "INSERT INTO dbProjectData.tblAreaTaluka " + SPACE +
					   "(AreaName,TalukaID) " + SPACE +
					   "VALUES (" + SPACE +
					   SQ + temp.getAreaName() + SQ + COMMA +
					   String.valueOf(temp.getTalukaID()) +
					   ")";
		QueryExecutor.processQuery(Query);
	}
	public static void updateArea(clsAreaTaluka temp)
	{
		String SQ = "'";
		String COMMA = ",";
		String SPACE = " ";

		String Query = "update dbProjectData.tblAreaTaluka set " + SPACE +
		                "AreaName=" + SQ + temp.getAreaName() + SQ + SPACE + COMMA +
		                "TalukaID=" + String.valueOf(temp.getTalukaID()) + SPACE +
              			"where AreaID=" + String.valueOf(temp.getAreaID());
		QueryExecutor.processQuery(Query);

	}

	public static void deleteArea(clsAreaTaluka temp)
	{
		String SQ = "'";
		String COMMA = ",";
		String SPACE = " ";

		String Query = "delete from dbProjectData.tblAreaTaluka where AreaID="+temp.getAreaID();

		QueryExecutor.processQuery(Query);
	}

	public static int getIDFromName(String mAreaName)
	{
	    String Query = "select AreaID from tblAreaTaluka where AreaName='" + mAreaName + "'";
	    return QueryExecutor.getIDFromName(Query);
	}
	public static String [] getAllAreaNames()
	{
		String Query = "select AreaName from dbProjectData.tblAreaTaluka";
		return(QueryExecutor.getSingleColumn(Query));
	}
	public static String [] getAllAreaNames(int mTalukaID)
	{
		String Query = "select AreaName from dbProjectData.tblAreaTaluka where TalukaID="+String.valueOf(mTalukaID);
		return(QueryExecutor.getSingleColumn(Query));
	}


	public static clsAreaTaluka getAreaInformation(int mAreaID)
	{
		String Query = "select * from tblAreaTaluka where AreaID="+String.valueOf(mAreaID);

		String values[] = QueryExecutor.getSingleRow(Query, 4);

		clsAreaTaluka temp = new clsAreaTaluka();

		temp.setAreaID(Integer.parseInt(values[0]));
		temp.setAreaName(values[1]);
		temp.setTalukaID(Integer.parseInt(values[2]));

		return(temp);


	}
}