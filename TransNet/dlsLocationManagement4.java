import java.util.*;

public class dlsLocationManagement4
{
	public static clsLocationManagement4 getLocationInfo(int mTalukaID)
	{
		String Query =  "SELECT " +
						"c.CountryID, " +
						"c.CountryName, " +
						"s.StateID, " +
						"s.StateName, " +
						"d.DistrictID, " +
						"d.DistrictName, " +
						"t.TalukaID, " +
						"t.TalukaName " +
						"FROM " +
						"dbProjectData.tblCountry c " +
						"JOIN dbProjectData.tblState s ON c.CountryID = s.CountryID " +
						"JOIN dbProjectData.tblDistrict d ON s.StateID = d.StateID " +
						"JOIN dbProjectData.tblTaluka t ON d.DistrictID = t.DistrictID " +
						"WHERE " +
						"t.TalukaID = " + String.valueOf(mTalukaID);

		String values[] = QueryExecutor.getSingleRow(Query,8);
		clsLocationManagement4 temp = new clsLocationManagement4();

		temp.setCountryID(Integer.parseInt(values[0]));
		temp.setCountryName(values[1]);
		temp.setStateID(Integer.parseInt(values[2]));
		temp.setStateName(values[3]);
		temp.setDistrictID(Integer.parseInt(values[4]));
		temp.setDistrictName(values[5]);
		temp.setTalukaID(Integer.parseInt(values[6]));
		temp.setTalukaName(values[7]);

		return(temp);



	}
}