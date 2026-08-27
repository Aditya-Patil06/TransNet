import javax.swing.*;

public class clsArea
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

	public static void addNewArea(clsArea temp)
	{
		dlsArea.addNewArea(temp);
	}

	public static String [] getAllAreaNames()
	{
		return(dlsArea.getAllAreaNames());
	}
	public static String [] getAllAreaNames(int mVillageID)
	{
		return(dlsArea.getAllAreaNames(mVillageID));
	}




	public static clsArea getAreaInformation(int mAreaID)
	{
		System.out.println("-----------===============-----------------");
		return(dlsArea.getAreaInformation(mAreaID));
	}

	public static void addAreaRecords(JComboBox temp)
	{
		temp.removeAllItems();
		temp.addItem("Select Area ...");
		String AreaNames [] = clsArea.getAllAreaNames();
		for(String name : AreaNames)
		{
			temp.addItem(name);
		}
	}
	public static void addAreaRecords(JComboBox temp, int mVillageID)
	{
		temp.removeAllItems();
		temp.addItem("Select Areas ...");
		String AreaNames [] = clsArea.getAllAreaNames(mVillageID);
		for(String name : AreaNames)
		{
			temp.addItem(name);
		}
	}

	public static int getIDFromName(String mAreaName)
	{
		return dlsArea.getIDFromName(mAreaName);
	}
	public static void showArea(clsArea temp)
	{
		System.out.println("Area ID   : "+temp.getAreaID());
		System.out.println("Area Name : "+temp.getAreaName());
		System.out.println("Village ID   : "+temp.getVillageID());
		System.out.println("Taluka ID   : "+temp.getTalukaID());

	}

	public static void updateArea(clsArea temp)
	{
		dlsArea.updateArea(temp);
	}
	public static void deleteArea(clsArea temp)
	{
		dlsArea.deleteArea(temp);
	}

	public static void main(String args[])
	{
		clsArea a = dlsArea.getAreaInformation(1);
		clsArea.showArea(a);
	}


}
