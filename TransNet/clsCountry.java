import javax.swing.*;
public class clsCountry
{
    private int 	CountryID 		;
    private String 	CountryName 	;

    public void setCountryID(int CountryID)
    {
        this.CountryID = CountryID;
    }

    public int getCountryID()
    {
        return CountryID;
    }

    public void setCountryName(String CountryName)
    {
        this.CountryName = CountryName;
    }

    public String getCountryName()
    {
        return CountryName;
    }

	public static void addNewCountry(clsCountry temp)
	{
		dlsCountry.addNewCountry(temp);
	}

	public static String [] getAllCountryNames()
	{
		return(dlsCountry.getAllCountryNames());
	}

	public static clsCountry getCountryInformation(int mCountryID)
	{
		return(dlsCountry.getCountryInformation(mCountryID));
	}
	public static clsCountry [] getAllCountryInformation()
	{
		return(dlsCountry.getAllCountryInformation());
	}
	public static void addCountryRecords(JComboBox temp)
	{
		temp.removeAllItems();
		temp.addItem("Select Country ...");
		String CountryNames [] = clsCountry.getAllCountryNames();
		for(String name : CountryNames)
		{
			temp.addItem(name);
		}
	}

	public static int getIDFromName(String mCountryName)
	{
		return dlsCountry.getIDFromName(mCountryName);
	}

	public static void showCountry(clsCountry temp)
	{
		System.out.println("Country ID   : "+temp.getCountryID());
		System.out.println("Country Name : "+temp.getCountryName());

	}

	public static void updateCountry(clsCountry temp)
	{
		dlsCountry.updateCountry(temp);
	}

	public static void deleteCountry(clsCountry temp)
	{
		dlsCountry.deleteCountry(temp);
	}

	public static void createDocument(clsCountry[] countries) {
        CreateCountryWordDocument.CreateWord(countries);
    }
	public static void main(String args[])
	{
		clsCountry[] temp = clsCountry.getAllCountryInformation();

		clsCountry.createDocument(temp);
	}
}