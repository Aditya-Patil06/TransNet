import javax.swing.*;

public class clsTaluka
{
	private int TalukaID ;
	private String TalukaName ;
    private int DistrictID ;
    private int StateID;
    private int CountryID;

	public void setTalukaID(int TalukaID)
    {
        this.TalukaID = TalukaID;
    }
    public int getTalukaID()
    {
        return TalukaID;
    }
	public void setTalukaName(String TalukaName)
    {
        this.TalukaName = TalukaName;
    }
    public String getTalukaName()
    {
        return TalukaName;
    }

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


	public static void addNewTaluka(clsTaluka temp)
	{
		dlsTaluka.addNewTaluka(temp);
	}

	public static String [] getAllTalukaNames()
	{
		return(dlsTaluka.getAllTalukaNames());
	}
	public static String [] getAllTalukaNames(int mDistrictID)
	{
		return(dlsTaluka.getAllTalukaNames(mDistrictID));
	}

	public static clsTaluka getTalukaInformation(int mTalukaID)
	{
		return(dlsTaluka.getTalukaInformation(mTalukaID));
	}

	public static void addTalukaRecords(JComboBox temp)
	{
		temp.removeAllItems();
		temp.addItem("Select Taluka ...");
		String TalukaNames [] = clsTaluka.getAllTalukaNames();
		for(String name : TalukaNames)
		{
			temp.addItem(name);
		}
	}
	public static void addTalukaRecords(JComboBox temp, int mDistrictID)
	{
		temp.removeAllItems();
		temp.addItem("Select Taluka ...");
		String TalukaNames [] = clsTaluka.getAllTalukaNames(mDistrictID);
		for(String name : TalukaNames)
		{
			temp.addItem(name);
		}
	}


	public static int getIDFromName(String mTalukaName)
	{
		return dlsTaluka.getIDFromName(mTalukaName);
	}
	public static void showTaluka(clsTaluka temp)
	{
		System.out.println("Taluka ID   : "+temp.getTalukaID());
		System.out.println("Taluka Name : "+temp.getTalukaName());
		System.out.println("State ID  : "+temp.getStateID());
		System.out.println("Country ID  : "+temp.getCountryID());
		System.out.println("District ID  : "+temp.getDistrictID());

	}

	public static void updateTaluka(clsTaluka temp)
	{
		dlsTaluka.updateTaluka(temp);
	}
	public static void deleteTaluka(clsTaluka temp)
	{
		dlsTaluka.deleteTaluka(temp);
	}

	public static void main(String args[])
	{

	}


}
