import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import myUtility.*;

public class clsLocationManagementTaluka6
{
	private int CountryID;
	private String CountryName;
	private int StateID;
	private String StateName;
	private int DistrictID;
	private String DistrictName;
	private int TalukaID;
	private String TalukaName;

	private int AreaID;
	private String AreaName;


	public int getCountryID()
	{
		return CountryID;
	}
	public void setCountryID(int CountryID)
	{
		this.CountryID = CountryID;
	}

	public String getCountryName()
	{
		return CountryName;
	}

	public void setCountryName(String CountryName)
	{
		this.CountryName = CountryName;
	}

	public int getStateID()
	{
		return StateID;
	}
	public void setStateID(int StateID)
	{
		this.StateID = StateID;
	}

	public String getStateName()
	{
		return StateName;
	}

	public void setStateName(String StateName)
	{
		this.StateName = StateName;
	}

	public int getDistrictID()
	{
		return DistrictID;
	}

	public void setDistrictID(int DistrictID)
	{
		this.DistrictID = DistrictID;
	}

	public String getDistrictName()
	{
		return DistrictName;
	}

	public void setDistrictName(String DistrictName)
	{
		this.DistrictName = DistrictName;
	}

	public int getTalukaID()
	{
		return TalukaID;
	}

	public void setTalukaID(int TalukaID)
	{
		this.TalukaID = TalukaID;
	}

	public String getTalukaName()
	{
		return TalukaName;
	}

	public void setTalukaName(String TalukaName)
	{
		this.TalukaName = TalukaName;
	}


	public int getAreaID()
	{
		return AreaID;
	}
	public void setAreaID(int AreaID)
	{
		this.AreaID = AreaID;
	}

	public String getAreaName()
	{
		return AreaName;
	}

	public void setAreaName(String AreaName)
	{
		this.AreaName = AreaName;
	}

	public static void showclsLocationManagementTaluka6(clsLocationManagementTaluka6 temp)
	{
		System.out.println("Country ID : " + temp.getCountryID());
		System.out.println("Country Name : " + temp.getCountryName());
		System.out.println("State ID : " + temp.getStateID());
		System.out.println("State Name : " + temp.getStateName());
		System.out.println("District ID : " + temp.getDistrictID());
		System.out.println("District Name : " + temp.getDistrictName());
		System.out.println("Taluka ID : " + temp.getTalukaID());
		System.out.println("Taluka Name : " + temp.getTalukaName());
		System.out.println("Area ID : " + temp.getAreaID());
		System.out.println("Area Name : " + temp.getAreaName());

	}
	public static clsLocationManagementTaluka6 getLocationInfo(int mAreaID)
	{
		return (dlsLocationManagementTaluka6.getLocationInfo(mAreaID));
	}
	public static void main (String args[])
	{

	}

}
