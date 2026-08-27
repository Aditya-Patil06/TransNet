import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import myUtility.*;


public class clsLocationManagement3
{
	private int CountryID;
	private String CountryName;
	private int StateID;
	private String StateName;
	private int DistrictID;
	private String DistrictName;


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


	public static void showClsLocationManagement3(clsLocationManagement3 temp)
	{
		System.out.println("Country ID : " + temp.getCountryID());
		System.out.println("Country Name : " + temp.getCountryName());
		System.out.println("State ID : " + temp.getStateID());
		System.out.println("State Name : " + temp.getStateName());
		System.out.println("District ID : " + temp.getDistrictID());
		System.out.println("District Name : " + temp.getDistrictName());

	}
	public static clsLocationManagement3 getLocationInfo(int mStateID)
	{
		return (dlsLocationManagement3.getLocationInfo(mStateID));
	}
	public static void main (String []args)
	{

	}

}
