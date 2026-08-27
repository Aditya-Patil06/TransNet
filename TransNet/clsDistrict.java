import javax.swing.*;

public class clsDistrict
{
    private int DistrictID ;
    private String DistrictName ;
    private int StateID;
    private int CountryID;

	public void setCountryID(int CountryID)
    {
        this.CountryID = CountryID;
    }
    public int getCountryID()
	{
		return CountryID;
	}

    public void setDistrictID(int DistrictID)
    {
        this.DistrictID = DistrictID;
    }
    public int getDistrictID()
    {
        return DistrictID;
    }

    public void setStateID(int StateID)
    {
        this.StateID = StateID;
    }
    public int getStateID()
    {
        return StateID;
    }

    public void setDistrictName(String DistrictName)
    {
        this.DistrictName = DistrictName;
    }
    public String getDistrictName()
    {
        return DistrictName;
    }

	public static void addNewDistrict(clsDistrict temp)
	{
		dlsDistrict.addNewDistrict(temp);
	}

	public static String [] getAllDistrictNames()
	{
		return(dlsDistrict.getAllDistrictNames());
	}
	public static String [] getAllDistrictNames(int mStateID)
	{
		return(dlsDistrict.getAllDistrictNames(mStateID));
	}

	public static clsDistrict getDistrictInformation(int mDistrictID)
	{
		return(dlsDistrict.getDistrictInformation(mDistrictID));
	}

	public static void addDistrictRecords(JComboBox temp)
	{
		temp.removeAllItems();
		temp.addItem("Select District ...");
		String DistrictNames [] = clsDistrict.getAllDistrictNames();
		for(String name : DistrictNames)
		{
			temp.addItem(name);
		}
	}
	public static void addDistrictRecords(JComboBox temp, int mStateID)
	{
		temp.removeAllItems();
		temp.addItem("Select District ...");
		String DistrictNames [] = clsDistrict.getAllDistrictNames(mStateID);
		for(String name : DistrictNames)
		{
			temp.addItem(name);
		}
	}


	public static int getIDFromName(String mDistrictName)
	{
		return dlsDistrict.getIDFromName(mDistrictName);
	}
	public static void showDistrict(clsDistrict temp)
	{
		System.out.println("District ID   : "+temp.getDistrictID());
		System.out.println("District Name : "+temp.getDistrictName());
		System.out.println("State ID  : "+temp.getStateID());
		System.out.println("State ID  : "+temp.getCountryID());

	}

	public static void updateDistrict(clsDistrict temp)
	{
		dlsDistrict.updateDistrict(temp);
	}
	public static void deleteDistrict(clsDistrict temp)
	{
		dlsDistrict.deleteDistrict(temp);
	}

	public static void main(String args[])
	{

	}


}
