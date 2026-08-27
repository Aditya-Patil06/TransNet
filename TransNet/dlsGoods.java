import java.util.*;

public class dlsGoods
{
	public static void addNewGoods(clsGoods temp)
	{

		String SQ = "'";
		String COMMA = ",";
		String SPACE = " ";

		String Query = "insert into dbProjectData.tblGoods" + SPACE +
					   "(GoodsID" + COMMA + "GoodsName)" +
					   "Value" + SPACE + "(" + temp.getGoodsID() + COMMA + SQ + temp.getGoodsName() + SQ + ")";

		QueryExecutor.processQuery(Query);

	}

	public static void updateGoods(clsGoods temp)
	{

		String SQ = "'";
		String COMMA = ",";
		String SPACE = " ";

		String Query = "update dbProjectData.tblGoods set" + SPACE +
					   "GoodsName=" + SQ + temp.getGoodsName() + SQ + SPACE +
					   "where GoodsID=" + String.valueOf(temp.getGoodsID());

		QueryExecutor.processQuery(Query);

	}

	public static String [] getAllGoodsNames()
	{

		String Query = "select GoodsName from dbProjectData.tblGoods";
		return(QueryExecutor.getSingleColumn(Query));

	}

	public static int getIDFromName(String mGoodsName)
	{

		String Query = "select GoodsID from tblGoods where GoodsName='"+mGoodsName+"'";

		return QueryExecutor.getIDFromName(Query);

	}
	public static String getNameFromID(int mGoodsID)
	{

		String Query = "select GoodsName from tblGoods where GoodsID="+String.valueOf(mGoodsID);

		return QueryExecutor.getNameFromID(Query);

	}

	public static int getAllGoodsCount()
	{

		String Query = "select count(GoodsID) from dbProjectData.tblGoods";
		return(QueryExecutor.getRowsCount(Query));

	}


	public static clsGoods getGoodsInformation(int mGoodsID)
	{

		String Query = "select * from tblGoods where GoodsID="+String.valueOf(mGoodsID);

		String data[] = QueryExecutor.getObjectInformation(Query,2);

		clsGoods temp = new clsGoods();

		temp.setGoodsID(Integer.parseInt(data[0]));
		temp.setGoodsName(data[1]);
		return(temp);

	}

	public static void deleteGoods(clsGoods temp)
	{

		String SQ = "'";
		String COMMA = ",";
		String SPACE = " ";

		String Query = "delete from dbProjectData.tblGoods where GoodsID="+temp.getGoodsID();

		QueryExecutor.processQuery(Query);

	}
	public static clsGoods [] getAllGoodsInformation()
	{
		String Query = "select * from tblGoods";

		String data[][] = QueryExecutor.getAllObjectInformation(Query,2);
		clsGoods temp[] = new clsGoods[data.length];

		for(int i=0;i<data.length;i++)
		{
			temp[i]=new clsGoods();
			temp[i].setGoodsID(Integer.parseInt(data[i][0]));
			temp[i].setGoodsName(data[i][1]);
		}
		return(temp);
	}
}
