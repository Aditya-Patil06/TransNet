import javax.swing.*;

public class clsDepot
{
    private int DepotID ;
    private String DepotName ;
    private String Address;
    private int villagian;
    private int PlaceID;
    private String ContactNo;
    private String EmailID;
    private String ContactPerson;


    public void setDepotID(int mDepotID)
    {
        this.DepotID = mDepotID;
    }
    public int getDepotID()
    {
        return DepotID;
    }

    public void setDepotName(String mDepotName)
    {
        this.DepotName = mDepotName;
    }
    public String getDepotName()
    {
        return DepotName;
    }
    public void setAddress(String mAddress)
    {
		this.Address = mAddress;
	}
	public String getAddress()
	{
		return Address;
	}
 	public void setPlaceID(int PlaceID)
	{
		this.PlaceID = PlaceID;
	}
	public int getPlaceID()
	{
		return PlaceID;
	}
	public void setContactNo(String mContactNo)
    {
        this.ContactNo = mContactNo;
    }
    public String getContactNo()
    {
        return ContactNo;
    }
    public void setEmailID(String mEmailID)
    {
        this.EmailID = mEmailID;
    }
    public String getEmailID()
    {
        return EmailID;
    }

	public void setVillagian(int villagian)
	{
		this.villagian = villagian;
	}
	public int getVillagian()
	{
		return villagian;
	}


	public void setContactPerson(String ContactPerson)
	{
		this.ContactPerson = ContactPerson;
	}
	public String getContactPerson()
	{
		return ContactPerson;
	}

	public static void addNewDepot(clsDepot temp)
	{
		dlsDepot.addNewDepot(temp);
	}


	public static void updateDepot(clsDepot temp)
	{
		dlsDepot.updateDepot(temp);
	}

	public static void deleteDepot(clsDepot temp)
	{
		dlsDepot.deleteDepot(temp);
	}

	public static int getAllDepotCount()
	{
		return(dlsDepot.getAllDepotCount());
	}

	public static String[] getAllDepotNames()
	{
		return(dlsDepot.getAllDepotNames());
	}

	public static clsDepot getDepotInformation(int mDepot)
	{
		return(dlsDepot.getDepotInformation(mDepot));
	}

	public static clsDepot[] getAllDepotInformation()
	{
		return(dlsDepot.getAllDepotInformation());
	}

	public static void addDepotRecords(JComboBox temp)
	{
		temp.removeAllItems();
		temp.addItem("--Select Depot--");
		String DepotNames [] = clsDepot.getAllDepotNames();
		for(String name : DepotNames)
		{
			temp.addItem(name);
		}
	}

	public static int getIDFromName(String mDepotName)
	{
		return dlsDepot.getIDFromName(mDepotName);
	}

	public static void showDepot(clsDepot temp)
	{
		System.out.println("Depot ID   : "+temp.getDepotID());
		System.out.println("Name : "+temp.getDepotName());
		System.out.println("Address   : "+temp.getAddress());
		System.out.println("Place  : "+temp.getPlaceID());
		System.out.println("ContactNumber   : "+temp.getContactNo());
		System.out.println("EmailID   : "+temp.getEmailID());
		System.out.println("Villagian:"+temp.getVillagian());

    }

	public static void main(String args[])
	{

	}
}

