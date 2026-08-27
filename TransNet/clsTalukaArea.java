import javax.swing.*;

public class clsTalukaArea
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

	public static void addNewArea(clsTalukaArea temp)
	{
		dlsTalukaArea.addNewArea(temp);
	}

	public static String [] getAllAreaNames()
	{
		return(dlsTalukaArea.getAllAreaNames());
	}
	public static String [] getAllAreaNames(int mTalukaID)
	{
		return(dlsTalukaArea.getAllAreaNames(mTalukaID));
	}

	public static clsTalukaArea getAreaInformation(int mAreaID)
	{
		return(dlsTalukaArea.getAreaInformation(mAreaID));
	}

	public static void addAreaRecords(JComboBox temp)
	{
		temp.removeAllItems();
		temp.addItem("Select Area ...");
		String AreaNames [] = clsTalukaArea.getAllAreaNames();
		for(String name : AreaNames)
		{
			temp.addItem(name);
		}
	}
	public static void addAreaRecords(JComboBox temp, int mTalukaID)
	{
		temp.removeAllItems();
		temp.addItem("Select Areas ...");
		String AreaNames [] = clsTalukaArea.getAllAreaNames(mTalukaID);
		for(String name : AreaNames)
		{
			temp.addItem(name);
		}
	}

	public static int getIDFromName(String mAreaName)
	{
		return dlsTalukaArea.getIDFromName(mAreaName);
	}
	public static void showArea(clsTalukaArea temp)
	{
		System.out.println("Area ID   : "+temp.getAreaID());
		System.out.println("Area Name : "+temp.getAreaName());
		System.out.println("Taluka ID   : "+temp.getTalukaID());

	}

	public static void updateArea(clsTalukaArea temp)
	{
		dlsTalukaArea.updateArea(temp);
	}
	public static void deleteArea(clsTalukaArea temp)
	{
		dlsTalukaArea.deleteArea(temp);
	}

	public static clsTalukaArea [] getAllTalukaAreaInformation()
	{
		return dlsTalukaArea.getAllTalukaAreaInformation();
	}

	public static void main(String args[])
	{

	}

}
