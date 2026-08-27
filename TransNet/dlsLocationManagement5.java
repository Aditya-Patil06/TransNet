import java.util.*;

public class dlsLocationManagement5
{
	public static clsLocationManagement5 getLocationInfo(int mVillageID)
	{
		String Query =  "SELECT " +
						"c.CountryID, " +
						"c.CountryName, " +
						"s.StateID, " +
						"s.StateName, " +
						"d.DistrictID, " +
						"d.DistrictName, " +
						"t.TalukaID, " +
						"t.TalukaName, " +
						"v.VillageID, " +
						"v.VillageName " +
						"FROM " +
						"dbProjectData.tblCountry c " +
						"JOIN dbProjectData.tblState s ON c.CountryID = s.CountryID " +
						"JOIN dbProjectData.tblDistrict d ON s.StateID = d.StateID " +
						"JOIN dbProjectData.tblTaluka t ON d.DistrictID = t.DistrictID " +
						"JOIN dbProjectData.tblVillage v ON t.TalukaID = v.TalukaID " +
						"WHERE " +
						"v.VillageID = " + String.valueOf(mVillageID);

		String values[] = QueryExecutor.getSingleRow(Query,10);
		clsLocationManagement5 temp = new clsLocationManagement5();

		temp.setCountryID(Integer.parseInt(values[0]));
		temp.setCountryName(values[1]);
		temp.setStateID(Integer.parseInt(values[2]));
		temp.setStateName(values[3]);
		temp.setDistrictID(Integer.parseInt(values[4]));
		temp.setDistrictName(values[5]);
		temp.setTalukaID(Integer.parseInt(values[6]));
		temp.setTalukaName(values[7]);
		temp.setVillageID(Integer.parseInt(values[8]));
		temp.setVillageName(values[9]);

		return(temp);

	}
}