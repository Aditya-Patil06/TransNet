import java.util.*;

public class dlsVehicleType
{
	public static void addNewVehicleType(clsVehicleType temp)
	{

		String SQ = "'";
		String COMMA = ",";
		String SPACE = " ";

		String Query = "insert into dbProjectData.tblVehicleType" + SPACE +
					   "(VehicleTypeID" + COMMA + "VehicleTypeName)" +
					   "Value" + SPACE + "(" + temp.getVehicleTypeID() + COMMA + SQ + temp.getVehicleTypeName() + SQ + ")";

		QueryExecutor.processQuery(Query);

	}

	public static void updateVehicleType(clsVehicleType temp)
	{

		String SQ = "'";
		String COMMA = ",";
		String SPACE = " ";

		String Query = "update dbProjectData.tblVehicleType set" + SPACE +
					   "VehicleTypeName=" + SQ + temp.getVehicleTypeName() + SQ + SPACE +
					   "where VehicleTypeID=" + String.valueOf(temp.getVehicleTypeID());

		QueryExecutor.processQuery(Query);

	}

	public static String [] getAllVehicleTypeNames()
	{

		String Query = "select VehicleTypeName from dbProjectData.tblVehicleType";
		return(QueryExecutor.getSingleColumn(Query));

	}

	public static int getIDFromName(String mVehicleTypeName)
	{

		String Query = "select VehicleTypeID from tblVehicleType where VehicleTypeName='"+mVehicleTypeName+"'";

		return QueryExecutor.getIDFromName(Query);

	}
	public static String getNameFromID(int mVehicleTypeID)
	{

		String Query = "select VehicleTypeName from tblVehicleType where VehicleTypeID="+String.valueOf(mVehicleTypeID);

		return QueryExecutor.getNameFromID(Query);

	}

	public static int getAllVehicleTypeCount()
	{

		String Query = "select count(VehicleTypeID) from dbProjectData.tblVehicleType";
		return(QueryExecutor.getRowsCount(Query));

	}


	public static clsVehicleType getVehicleTypeInformation(int mVehicleTypeID)
	{

		String Query = "select * from tblVehicleType where VehicleTypeID="+String.valueOf(mVehicleTypeID);

		String data[] = QueryExecutor.getObjectInformation(Query,2);

		clsVehicleType temp = new clsVehicleType();

		temp.setVehicleTypeID(Integer.parseInt(data[0]));
		temp.setVehicleTypeName(data[1]);
		return(temp);

	}

	public static void deleteVehicleType(clsVehicleType temp)
	{

		String SQ = "'";
		String COMMA = ",";
		String SPACE = " ";

		String Query = "delete from dbProjectData.tblVehicleType where VehicleTypeID="+temp.getVehicleTypeID();

		QueryExecutor.processQuery(Query);

	}
	public static clsVehicleType [] getAllVehicleTypeInformation()
	{
		String Query = "select * from tblVehicleType";

		String data[][] = QueryExecutor.getAllObjectInformation(Query,2);
		clsVehicleType temp[] = new clsVehicleType[data.length];

		for(int i=0;i<data.length;i++)
		{
			temp[i]=new clsVehicleType();
			temp[i].setVehicleTypeID(Integer.parseInt(data[i][0]));
			temp[i].setVehicleTypeName(data[i][1]);
		}
		return(temp);
	}
}
