import java.util.*;

public class dlsGenerateDocket
{
	public static void addNewGenerateDocket(clsGenerateDocket temp)
	{

		String SQ 	 = "'";
		String COMMA = ",";
		String SPACE = " ";

		String Query = "insert into dbProjectData.tblGenerateDocket" + SPACE +
					   "(GenerateDocketName,DocketCounter) " +
					   "values (" + SPACE +
					   SQ + temp.getGenerateDocketName() + SQ + COMMA +
					   String.valueOf(temp.getDocketCounter()) +
					   ")";

		System.out.println(Query);

		QueryExecutor.processQuery(Query);

	}

	public static void updateGenerateDocket(clsGenerateDocket temp)
	{

		String SQ    = "'";
		String COMMA = ",";
		String SPACE = " ";

		String Query = "update dbProjectData.tblGenerateDocket set" + SPACE +
					   "GenerateDocketName=" + SQ + temp.getGenerateDocketName() + SQ + SPACE + COMMA+
					   "DocketCounter=" +String.valueOf(temp.getDocketCounter()) +SPACE+
					   "where GenerateDocketID=" + String.valueOf(temp.getGenerateDocketID());

		QueryExecutor.processQuery(Query);
		System.out.println(Query);

	}

	public static void deleteGenerateDocket(clsGenerateDocket temp)
	{

		String SQ    = "'";
		String COMMA = ",";
		String SPACE = " ";

		String Query = "delete from dbProjectData.tblGenerateDocket where GenerateDocketID="+temp.getGenerateDocketID();

		QueryExecutor.processQuery(Query);

	}

	public static int getIDFromName(String mGenerateDocketName)
	{

		String Query = "select GenerateDocketID from dbProjectData.tblGenerateDocket where GenerateDocketName='"+mGenerateDocketName+"'";

		return QueryExecutor.getIDFromName(Query);

	}
	public static String getNameFromID(int generateDocketID)
    {
        String Query = "SELECT GenerateDocketName FROM dbProjectData.tblGenerateDocket WHERE GenerateDocketID = " + String.valueOf(generateDocketID);

        return (QueryExecutor.getNameFromID(Query));
    }
	public static String [] getAllGenerateDocketNames()
	{

		String Query = "select GenerateDocketName from dbProjectData.tblGenerateDocket";
		return(QueryExecutor.getSingleColumn(Query));

	}

	public static String [] getAllGenerateDocketNames(int mDocketCounter)
	{

		String Query = "select GenerateDocketName from dbProjectData.tblGenerateDocket where DocketCounter="+String.valueOf(mDocketCounter);
		return(QueryExecutor.getSingleColumn(Query));

	}

	public static int getHighDocet()
	{
		String Query = "select max(DocketCounter) from dbProjectData.tblGenerateDocket";
		return(QueryExecutor.getRowsCount(Query));
	}
	public static String getNewDocketNo()
	{
		String PreFix="Trans-Doc-";
		String PostFix ="-24-25";
		int HeightDoc = getHighDocet();
		HeightDoc++;
		String str = String.valueOf(HeightDoc);
		if(str.length()==1)
		{
			str = "000"+str;
		}
		else if(str.length()==2)
		{
			str = "00"+str;
		}
		else if(str.length()==3)
		{
			str = "0"+str;
		}

		String NewDoc = PreFix + str+PostFix;
		return(NewDoc);
	}



	public static clsGenerateDocket getGenerateDocketInformation(int mGenerateDocketID)
	{

		String Query = "select * from tblGenerateDocket where GenerateDocketID="+String.valueOf(mGenerateDocketID);

		String data[]= QueryExecutor.getSingleRow(Query,3);

		clsGenerateDocket temp = new clsGenerateDocket();

		temp.setGenerateDocketID(Integer.parseInt(data[0]));
		temp.setGenerateDocketName((String)(data[1]));
		temp.setDocketCounter(Integer.parseInt(data[2]));

		return(temp);

	}
	public static clsGenerateDocket[] getAllGenerateDocketInformation()
	{
		String Query = "select * from dbProjectData.tblGenerateDocket";

		String data[][] = QueryExecutor.getAllObjectInformation(Query,3);
		clsGenerateDocket temp[] = new clsGenerateDocket[data.length];

		for(int i=0;i<data.length;i++)
		{
			temp[i]=new clsGenerateDocket();
			temp[i].setGenerateDocketID(Integer.parseInt(data[i][0]));
			temp[i].setGenerateDocketName(data[i][1]);
			temp[i].setDocketCounter(Integer.parseInt(data[i][2]));

		}
		return(temp);
	}
}