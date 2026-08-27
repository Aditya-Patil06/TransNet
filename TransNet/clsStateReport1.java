import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import myUtility.*;


public class clsStateReport1
{

	private String CountryName;
	private int StateID;
	private int CountryID;
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

	public static void showStateReport1(clsStateReport1 temp)
	{
		System.out.println("Country ID : " + temp.getCountryID());
		System.out.println("Country Name : " + temp.getCountryName());

		System.out.println("State ID : " + temp.getStateID());
		System.out.println("State Name : " + temp.getStateName());

	}
	public static clsStateReport1[]  getStateReport1Info()
	{
			return (dlsState.getStateReport1Info());
	}
	public static clsStateReport1[]  getStateReport1Info(int mCountryID)
	{
			return (dlsState.getStateReport1Info(mCountryID));
	}

	public static void main (String []args)
	{
		clsStateReport1 data[]= clsStateReport1.getStateReport1Info();

		for(clsStateReport1 temp : data)
		{
			showStateReport1(temp);
		}
	}

}
