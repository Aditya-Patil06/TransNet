import java.util.*;

public class dlsLocationManagement6
{
	public static clsLocationManagement6 getLocationInfo(int mAreaID)
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
						"v.VillageName, " +
						"a.AreaID,"+
						"a.AreaName "+
						"FROM " +
						"dbProjectData.tblCountry c " +
						"JOIN dbProjectData.tblState s ON c.CountryID = s.CountryID " +
						"JOIN dbProjectData.tblDistrict d ON s.StateID = d.StateID " +
						"JOIN dbProjectData.tblTaluka t ON d.DistrictID = t.DistrictID " +
						"JOIN dbProjectData.tblVillage v ON t.TalukaID = v.TalukaID " +
						"JOIN dbProjectData.tblVillageArea a ON a.VillageID = v.VillageID " +
						"WHERE " +
						"a.AreaID = " + String.valueOf(mAreaID);

		String values[] = QueryExecutor.getSingleRow(Query,12);
		clsLocationManagement6 temp = new clsLocationManagement6();

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
		temp.setAreaID(Integer.parseInt(values[10]));
		temp.setAreaName(values[11]);


		return(temp);



	}

	public static void main(String args[])
	{

	}
}