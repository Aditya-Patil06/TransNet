import java.util.*;

public class dlsLocationManagement3
{
	public static clsLocationManagement3 getLocationInfo(int mDistrictID)
	{
		String Query =  "SELECT " +
						"c.CountryID, " +
						"c.CountryName, " +
						"s.StateID, " +
						"s.StateName, " +
						"d.DistrictID, " +
						"d.DistrictName " +
						"FROM " +
						"dbProjectData.tblCountry c " +
						"JOIN dbProjectData.tblState s ON c.CountryID = s.CountryID " +
						"JOIN dbProjectData.tblDistrict d ON s.StateID = d.StateID " +
						"WHERE " +
						"d.DistrictID =" + String.valueOf(mDistrictID);

		String values[] = QueryExecutor.getSingleRow(Query,6);
		clsLocationManagement3 temp = new clsLocationManagement3();

		temp.setCountryID(Integer.parseInt(values[0]));
		temp.setCountryName(values[1]);
		temp.setStateID(Integer.parseInt(values[2]));
		temp.setStateName(values[3]);
		temp.setDistrictID(Integer.parseInt(values[4]));
		temp.setDistrictName(values[5]);

		return(temp);

	}
}