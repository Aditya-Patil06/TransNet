import javax.swing.*;

public class clsVillageArea
{
	private int AreaID ;
	private String AreaName ;
	private int VillageID ;
	private int TalukaID ;


	public void setAreaName(String AreaName)
    {
        this.AreaName = AreaName;
    }
    public String getAreaName()
	{
		return AreaName;
	}

	public void setAreaID(int AreaID)
    {
        this.AreaID = AreaID;
    }
    public int getAreaID()
	{
		return AreaID;
	}
	public void setVillageID(int VillageID)
    {
        this.VillageID = VillageID;
    }
    public int getVillageID()
	{
		return VillageID;
	}

	public void setTalukaID(int TalukaID)
    {
        this.TalukaID = TalukaID;
    }
    public int getTalukaID()
    {
        return TalukaID;
    }

	public static void addNewArea(clsVillageArea temp)
	{
		dlsVillageArea.addNewArea(temp);
	}

	public static String [] getAllAreaNames()
	{
		return(dlsVillageArea.getAllAreaNames());
	}
	public static String [] getAllAreaNames(int mVillageID)
	{
		return(dlsVillageArea.getAllAreaNames(mVillageID));
	}

	public static clsVillageArea getAreaInformation(int mAreaID)
	{
		return(dlsVillageArea.getAreaInformation(mAreaID));
	}

	public static void addAreaRecords(JComboBox temp)
	{
		temp.removeAllItems();
		temp.addItem("Select Area ...");
		String AreaNames [] = clsVillageArea.getAllAreaNames();
		for(String name : AreaNames)
		{
			temp.addItem(name);
		}
	}
	public static void addAreaRecords(JComboBox temp, int mVillageID)
	{
		temp.removeAllItems();
		temp.addItem("Select Areas ...");
		String AreaNames [] = clsVillageArea.getAllAreaNames(mVillageID);
		for(String name : AreaNames)
		{
			temp.addItem(name);
		}
	}

	public static int getIDFromName(String mAreaName)
	{
		return dlsVillageArea.getIDFromName(mAreaName);
	}
	public static void showArea(clsVillageArea temp)
	{
		System.out.println("Area ID   : "+temp.getAreaID());
		System.out.println("Area Name : "+temp.getAreaName());
		System.out.println("Village ID   : "+temp.getVillageID());
		System.out.println("Taluka ID   : "+temp.getTalukaID());

	}

	public static void updateArea(clsVillageArea temp)
	{
		dlsVillageArea.updateArea(temp);
	}
	public static void deleteArea(clsVillageArea temp)
	{
		dlsVillageArea.deleteArea(temp);
	}

	public static clsVillageArea [] getAllVillageAreaInformation()
	{
		return dlsVillageArea.getAllVillageAreaInformation();
	}

	public static void main(String args[])
	{

	}

}
