import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import myUtility.*;

public class clsTalukaReport1
{
	private int CountryID;
	private String CountryName;
	private int StateID;
	private String StateName;
	private int DistrictID;
	private String DistrictName;
	private int TalukaID;
	private String TalukaName;


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


	  public static void showTalukaReport1(clsTalukaReport1 temp)
	  {
	        System.out.println("Country ID : " + temp.getCountryID());
	        System.out.println("Country Name : " + temp.getCountryName());
	        System.out.println("State ID : " + temp.getStateID());
	        System.out.println("State Name : " + temp.getStateName());
	        System.out.println("District ID : " + temp.getDistrictID());
	        System.out.println("District Name : " + temp.getDistrictName());
	        System.out.println("Taluka ID : " + temp.getTalukaID());
	        System.out.println("Taluka Name : " + temp.getTalukaName());
	    }

	    public static clsTalukaReport1[] getTalukaReport1Info()
	    {
	        return (dlsTaluka.getTalukaReport1Info());
	    }

	    public static clsTalukaReport1[] getTalukaReport1Info(int mDistrictID)
	    {
	        return (dlsTaluka.getTalukaReport1Info(mDistrictID));
	    }

	    public static void main(String[] args)
	    {
	        clsTalukaReport1[] data = clsTalukaReport1.getTalukaReport1Info(1);
	        for (int i = 0; i < data.length; i++)
	        {
	            showTalukaReport1(data[i]);
	        }
	    }
}


