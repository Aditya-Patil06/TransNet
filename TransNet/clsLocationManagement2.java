import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import myUtility.*;


public class clsLocationManagement2
{
	private int CountryID;
	private String CountryName;
	private int StateID;
	private String StateName;


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

	public static void showClsLocationManagement2(clsLocationManagement2 temp)
	{
		System.out.println("Country ID : " + temp.getCountryID());
		System.out.println("Country Name : " + temp.getCountryName());
		System.out.println("State ID : " + temp.getStateID());
		System.out.println("State Name : " + temp.getStateName());

	}
	public static clsLocationManagement2 getLocationInfo(int mStateID)
	{
		return (dlsLocationManagement2.getLocationInfo(mStateID));
	}
	public static void main (String []args)
	{
		/*clsLocationManagement2 temp = clsLocationManagement2.getLocationInfo(4);
		showClsLocationManagement2(temp);*/
	}

}
