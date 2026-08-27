import java.util.*;

public class dlsTalukaAreaReport1
{
	public static clsTalukaAreaReport1 getLocationInfo(int mAreaID)
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
						"a.AreaID,"+
						"a.AreaName "+
						"FROM " +
						"dbProjectData.tblCountry c " +
						"JOIN dbProjectData.tblState s ON c.CountryID = s.CountryID " +
						"JOIN dbProjectData.tblDistrict d ON s.StateID = d.StateID " +
						"JOIN dbProjectData.tblTaluka t ON d.DistrictID = t.DistrictID " +
						"JOIN dbProjectData.tblTalukaArea a ON a.TalukaID = t.TalukaID " +
						"WHERE " +
						"a.AreaID = " + String.valueOf(mAreaID);
		System.out.println(Query);

		String values[] = QueryExecutor.getSingleRow(Query,10);
		clsTalukaAreaReport1 temp = new clsTalukaAreaReport1();

		temp.setCountryID(Integer.parseInt(values[0]));
		temp.setCountryName(values[1]);
		temp.setStateID(Integer.parseInt(values[2]));
		temp.setStateName(values[3]);
		temp.setDistrictID(Integer.parseInt(values[4]));
		temp.setDistrictName(values[5]);
		temp.setTalukaID(Integer.parseInt(values[6]));
		temp.setTalukaName(values[7]);
		temp.setTalukaAreaID(Integer.parseInt(values[8]));
		temp.setTalukaAreaName(values[9]);


		return(temp);



	}

	public static void main(String args[])
	{

		clsTalukaAreaReport1 temp = dlsTalukaAreaReport1.getLocationInfo(1);

		System.out.println("Country id : "+temp.getCountryID());


	}
}