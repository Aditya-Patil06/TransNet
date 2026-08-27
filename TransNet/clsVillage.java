import javax.swing.*;

public class clsVillage
{
	private int VillageID ;
	private String VillageName ;
	private int TalukaID ;
	private int DistrictID ;
    private int StateID;
    private int CountryID;

	public void setVillageName(String VillageName)
    {
        this.VillageName = VillageName;
    }
    public String getVillageName()
	{
		return VillageName;
	}

	public void setVillageID(int VillageID)
    {
        this.VillageID = VillageID;
    }
    public int getVillageID()
	{
		return VillageID;
	}

	public void setCountryID(int CountryID)
    {
        this.CountryID = CountryID;
    }
    public int getCountryID()
	{
		return CountryID;
	}

    public void setStateID(int StateID)
    {
        this.StateID = StateID;
    }
    public int getStateID()
    {
        return StateID;
    }

    public void setDistrictID(int DistrictID)
    {
        this.DistrictID = DistrictID;
    }
    public int getDistrictID()
    {
        return DistrictID;
    }

	public void setTalukaID(int TalukaID)
    {
        this.TalukaID = TalukaID;
    }
    public int getTalukaID()
    {
        return TalukaID;
    }

	public static void addNewVillage(clsVillage temp)
	{
		dlsVillage.addNewVillage(temp);
	}

	public static String [] getAllVillageNames()
	{
		return(dlsVillage.getAllVillageNames());
	}
	public static String [] getAllVillageNames(int mTalukaID)
	{
		return(dlsVillage.getAllVillageNames(mTalukaID));
	}

	public static clsVillage getVillageInformation(int mVillageID)
	{
		return(dlsVillage.getVillageInformation(mVillageID));
	}

	public static void addVillageRecords(JComboBox temp)
	{
		temp.removeAllItems();
		temp.addItem("Select Village ...");
		String VillageNames [] = clsVillage.getAllVillageNames();
		for(String name : VillageNames)
		{
			temp.addItem(name);
		}
	}
	public static void addVillageRecords(JComboBox temp, int mTalukaID)
	{
		temp.removeAllItems();
		temp.addItem("Select Villages ...");
		String VillageNames [] = clsVillage.getAllVillageNames(mTalukaID);
		for(String name : VillageNames)
		{
			temp.addItem(name);
		}
	}


	public static int getIDFromName(String mVillageName)
	{
		return dlsVillage.getIDFromName(mVillageName);
	}
	public static void showVillage(clsVillage temp)
	{
		System.out.println("Village ID   : "+temp.getVillageID());
		System.out.println("Village Name : "+temp.getVillageName());
		System.out.println("State ID  : "+temp.getStateID());
		System.out.println("Country ID  : "+temp.getCountryID());
		System.out.println("District ID  : "+temp.getDistrictID());
		System.out.println("Taluka ID   : "+temp.getTalukaID());

	}

	public static void updateVillage(clsVillage temp)
	{
		dlsVillage.updateVillage(temp);
	}
	public static void deleteVillage(clsVillage temp)
	{
		dlsVillage.deleteVillage(temp);
	}

	public static void main(String args[])
	{

	}

}
