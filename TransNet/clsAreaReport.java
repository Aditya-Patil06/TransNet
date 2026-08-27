import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import myUtility.*;

public class clsAreaReport
{
	private int CountryID		;
	private String CountryName	;
	private int StateID			;
	private String StateName	;
	private int DistrictID		;
	private String DistrictName	;
	private int TalukaID		;
	private String TalukaName	;
	private int VillageID		;
	private String VillageName	;
	private int TalukaAreaID			;
	private String TalukaAreaName		;
	private int VillageAreaID			;
	private String VillageAreaName		;


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

	public int getVillageID()
	{
		return VillageID;
	}
	public void setVillageID(int VillageID)
	{
		this.VillageID = VillageID;
	}

	public String getVillageName()
	{
		return VillageName;
	}

	public void setVillageName(String VillageName)
	{
		this.VillageName = VillageName;
	}
	public int getTalukaAreaID()
	{
		return TalukaAreaID;
	}
	public void setTalukaAreaID(int TalukaAreaID)
	{
		this.TalukaAreaID = TalukaAreaID;
	}

	public String getTalukaAreaName()
	{
		return TalukaAreaName;
	}

	public void setTalukaAreaName(String TalukaAreaName)
	{
		this.TalukaAreaName = TalukaAreaName;
	}
	public int getVillageAreaID()
	{
		return VillageAreaID;
	}
	public void setVillageAreaID(int VillageAreaID)
	{
		this.VillageAreaID = VillageAreaID;
	}

	public String getVillageAreaName()
	{
		return VillageAreaName;
	}

	public void setVillageAreaName(String VillageAreaName)
	{
		this.VillageAreaName = VillageAreaName;
	}

	public static void showAreaReport(clsAreaReport temp)
	{
	        System.out.println("Country ID : " + temp.getCountryID());
	        System.out.println("Country Name : " + temp.getCountryName());
	        System.out.println("State ID : " + temp.getStateID());
	        System.out.println("State Name : " + temp.getStateName());
	        System.out.println("District ID : " + temp.getDistrictID());
	        System.out.println("District Name : " + temp.getDistrictName());
	        System.out.println("Taluka ID : " + temp.getTalukaID());
	        System.out.println("Taluka Name : " + temp.getTalukaName());
	        System.out.println("TalukaArea ID : " + temp.getTalukaAreaID());
	        System.out.println("TalukaArea Name : " + temp.getTalukaAreaName());
	        System.out.println("Village ID : " + temp.getVillageID());
	        System.out.println("Village Name : " + temp.getVillageName());
	        System.out.println("VillageArea ID : " + temp.getVillageAreaID());
	        System.out.println("VillageArea Name : " + temp.getVillageAreaName());
	    }

	    public static clsAreaReport[] getAreaReportInformation()
	    {
	        return (dlsArea.getAreaReportInformation());
	    }

	    public static clsAreaReport[] getTalukaAreaReportInformation(int mTalukaAreaID)
	    {
	        return (dlsArea.getTalukaAreaReportInformation(mTalukaAreaID));
	    }
	    public static clsAreaReport[] getVillageAreaReportInformation(int mVillageAreaID)
	    {
	        return (dlsArea.getVillageAreaReportInformation(mVillageAreaID));
	    }

	    public static void main(String[] args)
	    {
			/*int count = 0 ;
	        clsAreaReport[] reportData = clsAreaReport.getVillageAreaReportInformation(3);
	        for (int i = 0; i < reportData.length; i++)
	        {
	            showAreaReport(reportData[i]);
	            count = i;
	        }
	        System.out.println(count);*/
    }

}
