import javax.swing.*;

public class clsClient
{
    private int ClientID ;
    private String ClientName ;
    private String Address;
    private int mAreaID;
    private String ContactNo;
    private String EmailID;
    private int mIndustryID;
    private String mIndustryName;
    private String mAreaName;
    private int villagian;

    public void setClientID(int mClientID)
    {
        this.ClientID = mClientID;
    }
    public int getClientID()
    {
        return ClientID;
    }

    public void setClientName(String mClientName)
    {
        this.ClientName = mClientName;
    }
    public String getClientName()
    {
        return ClientName;
    }
    public void setAddress(String mAddress)
    {
		this.Address = mAddress;
	}
	public String getAddress()
	{
		return Address;
	}
 	public void setAreaID(int mAreaID)
	{
		this.mAreaID = mAreaID;
	}
	public int getAreaID()
	{
		return mAreaID;
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
    public void setIndustryID(int mIndustryID)
	{
		this.mIndustryID = mIndustryID;
	}
	public int getIndustryID()
	{
		return mIndustryID;
	}

	public void setVillagian(int villagian)
	{
		this.villagian = villagian;
	}
	public int getVillagian()
	{
		return villagian;
	}

	public void setIndustryName(String IndustryName)
	{
		this.mIndustryName = IndustryName;
	}
	public String getIndustryName()
	{
		return mIndustryName;
	}
	public void setAreaName(String AreaName)
	{
		this.mAreaName = AreaName;
	}
	public String getAreaName()
	{
		return mAreaName;
	}
	/*public void setArea(String mArea)
	{
		this.aaea = mArea;
	}
	public int getArea()
	{
		return villagian;
	}*/


	public static void addNewClient(clsClient temp)
	{
		dlsClient.addNewClient(temp);
	}


	public static void updateClient(clsClient temp)
	{
		dlsClient.updateClient(temp);
	}

	public static void deleteClient(clsClient temp)
	{
		dlsClient.deleteClient(temp);
	}

	public static int getAllClientCount()
	{
		return(dlsClient.getAllClientCount());
	}

	public static String[] getAllClientNames()
	{
		return(dlsClient.getAllClientNames());
	}

	public static clsClient getClientInformation(int mClient)
	{
		return(dlsClient.getClientInformation(mClient));
	}

	public static clsClient[] getAllClientInformation()
	{
		return(dlsClient.getAllClientInformation());
	}



	public static void addClientRecords(JComboBox temp)
	{
		temp.removeAllItems();
		temp.addItem("--Select Client--");
		String ClientNames [] = clsClient.getAllClientNames();
		for(String name : ClientNames)
		{
			temp.addItem(name);
		}
	}

	public static int getIDFromName(String mClientName)
	{
		return dlsClient.getIDFromName(mClientName);
	}

	public static void showClient(clsClient temp)
	{
		System.out.println("Client ID   : "+temp.getClientID());
		System.out.println("Name : "+temp.getClientName());
		System.out.println("Address   : "+temp.getAddress());
		System.out.println("Area  : "+temp.getAreaID());
		System.out.println("ContactNumber   : "+temp.getContactNo());
		System.out.println("EmailID   : "+temp.getEmailID());
		System.out.println("Industry   : "+temp.getIndustryID());
		System.out.println("Villagian:"+temp.getVillagian());

    }

	public static void main(String args[])
	{
		 clsClient[] emp= clsClient.getAllClientInformation();
		 for(clsClient emps : emp)
		 {
			clsClient.showClient(emps);
		 }
	}
}

