import javax.swing.*;

public class clsIndustry
{
    private int 	IndustryID 		;
    private String 	IndustryName 	;

    public void setIndustryID(int IndustryID)
    {
        this.IndustryID = IndustryID;
    }

    public int getIndustryID()
    {
        return IndustryID;
    }

    public void setIndustryName(String IndustryName)
    {
        this.IndustryName = IndustryName;
    }

    public String getIndustryName()
    {
        return IndustryName;
    }

	public static void addNewIndustry(clsIndustry temp)
	{
		dlsIndustry.addNewIndustry(temp);
	}

	public static String [] getAllIndustryNames()
	{
		return(dlsIndustry.getAllIndustryNames());
	}

	public static clsIndustry getIndustryInformation(int mIndustryID)
	{
		return(dlsIndustry.getIndustryInformation(mIndustryID));
	}
	public static clsIndustry [] getAllIndustryInformation()
	{
		return(dlsIndustry.getAllIndustryInformation());
	}
	public static void addIndustryRecords(JComboBox temp)
	{
		temp.removeAllItems();
		temp.addItem("Select Industry ...");
		String IndustryNames [] = clsIndustry.getAllIndustryNames();
		for(String name : IndustryNames)
		{
			temp.addItem(name);
		}
	}

	public static int getIDFromName(String mIndustryName)
	{
		return dlsIndustry.getIDFromName(mIndustryName);
	}
	public static String getNameFromID(int mIndustryID)
	{
		return dlsIndustry.getNameFromID(mIndustryID);
	}

	public static void showIndustry(clsIndustry temp)
	{
		System.out.println("Industry ID   : "+temp.getIndustryID());
		System.out.println("Industry Name : "+temp.getIndustryName());

	}

	public static void updateIndustry(clsIndustry temp)
	{
		dlsIndustry.updateIndustry(temp);
	}

	public static void deleteIndustry(clsIndustry temp)
	{
		dlsIndustry.deleteIndustry(temp);
	}

	public static void main(String args[])
	{
		clsIndustry[] countries = clsIndustry.getAllIndustryInformation();
		for (clsIndustry country : countries)
		{
		            clsIndustry.showIndustry(country);
		}
	}
}