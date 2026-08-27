import java.util.*;

public class dlsLocationManagement2
{
	public static clsLocationManagement2 getLocationInfo(int mStateID)
	{
		String Query = "select c.CountryID,c.CountryName,s.StateID,s.StateName"+
					   " from dbProjectData.tblCountry c join dbProjectData.tblState s on c.CountryID = s.CountryID"+
					   " WHERE s.StateID ="+String.valueOf(mStateID);

		String values[] = QueryExecutor.getSingleRow(Query,4);

		clsLocationManagement2 temp = new clsLocationManagement2();

		temp.setCountryID(Integer.parseInt(values[0]));
		temp.setCountryName(values[1]);
		temp.setStateID(Integer.parseInt(values[2]));
		temp.setStateName(values[3]);

		return(temp);



	}
}