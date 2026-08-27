import javax.swing.*;

public class clsAreaTaluka
{
	private int AreaID ;
	private String AreaName ;
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

	public void setTalukaID(int TalukaID)
    {
        this.TalukaID = TalukaID;
    }
    public int getTalukaID()
    {
        return TalukaID;
    }

	public static void addNewArea(clsAreaTaluka temp)
	{
		dlsAreaTaluka.addNewArea(temp);
	}

	public static String [] getAllAreaNames()
	{
		return(dlsAreaTaluka.getAllAreaNames());
	}
	public static String [] getAllAreaNames(int mTalukaID)
	{
		return(dlsAreaTaluka.getAllAreaNames(mTalukaID));
	}




	public static clsAreaTaluka getAreaInformation(int mAreaID)
	{
		return(dlsAreaTaluka.getAreaInformation(mAreaID));
	}

	public static void addAreaRecords(JComboBox temp)
	{
		temp.removeAllItems();
		temp.addItem("Select Area ...");
		String AreaNames [] = clsAreaTaluka.getAllAreaNames();
		for(String name : AreaNames)
		{
			temp.addItem(name);
		}
	}
	public static void addAreaRecords(JComboBox temp, int mTalukaID)
	{
		temp.removeAllItems();
		temp.addItem("Select Areas ...");
		String AreaNames [] = clsAreaTaluka.getAllAreaNames(mTalukaID);
		for(String name : AreaNames)
		{
			temp.addItem(name);
		}
	}

	public static int getIDFromName(String mAreaName)
	{
		return dlsAreaTaluka.getIDFromName(mAreaName);
	}
	public static void showArea(clsAreaTaluka temp)
	{
		System.out.println("Area ID   : "+temp.getAreaID());
		System.out.println("Area Name : "+temp.getAreaName());
		System.out.println("Taluka ID   : "+temp.getTalukaID());

	}

	public static void updateArea(clsAreaTaluka temp)
	{
		dlsAreaTaluka.updateArea(temp);
	}
	public static void deleteArea(clsAreaTaluka temp)
	{
		dlsAreaTaluka.deleteArea(temp);
	}

	public static void main(String args[])
	{
		clsAreaTaluka a = dlsAreaTaluka.getAreaInformation(1);
		clsAreaTaluka.showArea(a);
	}


}
