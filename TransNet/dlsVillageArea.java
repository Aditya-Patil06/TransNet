import java.util.*;

public class dlsVillageArea
{
	public static void addNewArea(clsVillageArea temp)
	{
		String SQ = "'";
		String COMMA = ",";
		String SPACE = " ";

		String VillageID ;
		if(temp.getVillageID() == 0){
			VillageID = null ;
		}
		else{
			VillageID = String.valueOf(temp.getVillageID());
		}

		String Query = "INSERT INTO dbProjectData.tblVillageArea " + SPACE +
					   "(AreaName,TalukaID, VillageID) " + SPACE +
					   "VALUES (" + SPACE +
					   SQ + temp.getAreaName() + SQ + COMMA +
					   String.valueOf(temp.getTalukaID()) +COMMA+
					   VillageID +
					   ")";

		QueryExecutor.processQuery(Query);
	}
	public static void updateArea(clsVillageArea temp)
	{
		String SQ = "'";
		String COMMA = ",";
		String SPACE = " ";

		String Query = "update dbProjectData.tblVillageArea set " + SPACE +
		                "AreaName=" + SQ + temp.getAreaName() + SQ + SPACE + COMMA +
		                "TalukaID=" + String.valueOf(temp.getTalukaID()) + SPACE +COMMA+
						"VillageID=" + String.valueOf(temp.getVillageID()) + SPACE +
              			"where AreaID=" + String.valueOf(temp.getAreaID());
		QueryExecutor.processQuery(Query);

	}

	public static void deleteArea(clsVillageArea temp)
	{
		String SQ = "'";
		String COMMA = ",";
		String SPACE = " ";

		String Query = "delete from dbProjectData.tblVillageArea where AreaID="+temp.getAreaID();

		QueryExecutor.processQuery(Query);
	}

	public static int getIDFromName(String mAreaName)
	{
	    String Query = "select AreaID from tblVillageArea where AreaName='" + mAreaName + "'";
	    return QueryExecutor.getIDFromName(Query);
	}
	public static String [] getAllAreaNames()
	{
		String Query = "select AreaName from dbProjectData.tblVillageArea";
		return(QueryExecutor.getSingleColumn(Query));
	}
	public static String [] getAllAreaNames(int mVillageID)
	{
		String Query = "select AreaName from dbProjectData.tblVillageArea where VillageID="+String.valueOf(mVillageID);
		return(QueryExecutor.getSingleColumn(Query));
	}


	public static clsVillageArea getAreaInformation(int mAreaID)
	{
		String Query = "select * from tblVillageArea where AreaID="+String.valueOf(mAreaID);

		String values[] = QueryExecutor.getSingleRow(Query, 4);

		clsVillageArea temp = new clsVillageArea();

		temp.setAreaID(Integer.parseInt(values[0]));
		temp.setAreaName(values[1]);
		temp.setTalukaID(Integer.parseInt(values[2]));

		return(temp);

	}

	public static clsVillageArea [] getAllVillageAreaInformation()
	{
		String Query = "select * from tblVillageArea";

		String data[][] = QueryExecutor.getAllObjectInformation(Query,4);
		clsVillageArea temp[] = new clsVillageArea[data.length];

		for(int i=0;i<data.length;i++)
		{
			temp[i]=new clsVillageArea();
			temp[i].setAreaID(Integer.parseInt(data[i][0]));
			temp[i].setAreaName(data[i][1]);
			temp[i].setVillageID(Integer.parseInt(data[i][2]));
			temp[i].setTalukaID(Integer.parseInt(data[i][3]));
		}
		return(temp);
	}
}