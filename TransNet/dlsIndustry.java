import java.util.*;

public class dlsIndustry
{
	public static void addNewIndustry(clsIndustry temp)
	{

		String SQ = "'";
		String COMMA = ",";
		String SPACE = " ";

		String Query = "insert into dbProjectData.tblIndustry" + SPACE +
					   "(IndustryID" + COMMA + "IndustryName)" +
					   "Value" + SPACE + "(" + temp.getIndustryID() + COMMA + SQ + temp.getIndustryName() + SQ + ")";

		QueryExecutor.processQuery(Query);

	}

	public static void updateIndustry(clsIndustry temp)
	{

		String SQ = "'";
		String COMMA = ",";
		String SPACE = " ";

		String Query = "update dbProjectData.tblIndustry set" + SPACE +
					   "IndustryName=" + SQ + temp.getIndustryName() + SQ + SPACE +
					   "where IndustryID=" + String.valueOf(temp.getIndustryID());

		QueryExecutor.processQuery(Query);

	}

	public static String [] getAllIndustryNames()
	{

		String Query = "select IndustryName from dbProjectData.tblIndustry";
		return(QueryExecutor.getSingleColumn(Query));

	}

	public static int getIDFromName(String mIndustryName)
	{

		String Query = "select IndustryID from tblIndustry where IndustryName='"+mIndustryName+"'";

		return QueryExecutor.getIDFromName(Query);

	}
	public static String getNameFromID(int mIndustryID)
	{

		String Query = "select IndustryName from tblIndustry where IndustryID="+String.valueOf(mIndustryID);

		return QueryExecutor.getNameFromID(Query);

	}

	public static int getAllIndustryCount()
	{

		String Query = "select count(IndustryID) from dbProjectData.tblIndustry";
		return(QueryExecutor.getRowsCount(Query));

	}


	public static clsIndustry getIndustryInformation(int mIndustryID)
	{

		String Query = "select * from tblIndustry where IndustryID="+String.valueOf(mIndustryID);

		String data[] = QueryExecutor.getObjectInformation(Query,2);

		clsIndustry temp = new clsIndustry();

		temp.setIndustryID(Integer.parseInt(data[0]));
		temp.setIndustryName(data[1]);
		return(temp);

	}

	public static void deleteIndustry(clsIndustry temp)
	{

		String SQ = "'";
		String COMMA = ",";
		String SPACE = " ";

		String Query = "delete from dbProjectData.tblIndustry where IndustryID="+temp.getIndustryID();

		QueryExecutor.processQuery(Query);

	}
	public static clsIndustry [] getAllIndustryInformation()
	{
		String Query = "select * from tblIndustry";

		String data[][] = QueryExecutor.getAllObjectInformation(Query,2);
		clsIndustry temp[] = new clsIndustry[data.length];

		for(int i=0;i<data.length;i++)
		{
			temp[i]=new clsIndustry();
			temp[i].setIndustryID(Integer.parseInt(data[i][0]));
			temp[i].setIndustryName(data[i][1]);
		}
		return(temp);
	}
}
