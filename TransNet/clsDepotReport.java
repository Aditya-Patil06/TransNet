import javax.swing.*;

public class clsDepotReport
{
    private int DepotID ;
    private String DepotName ;
    private String Address;
    private int villagian;
    private int PlaceID;
    private int TalukaID;
    private int DistrictID;
    private String AreaName;
    private String TalukaName;
    private String DistrictName;
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
    public void setContactPerson(String mContactPerson)
    {
		this.ContactPerson = mContactPerson;
	}
	public String getContactPerson()
	{
		return ContactPerson;
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
    public void setAreaName(String mAreaName)
    {
        this.AreaName = mAreaName;
    }
    public String getAreaName()
    {
        return AreaName;
    }

	public void setTalukaID(int TalukaID)
	{
		this.TalukaID = TalukaID;
	}
	public int getTalukaID()
	{
		return TalukaID;
	}
    public void setTalukaName(String mTalukaName)
    {
        this.TalukaName = mTalukaName;
    }
    public String getTalukaName()
    {
        return TalukaName;
    }


 	public void setDistrictID(int DistrictID)
	{
		this.DistrictID = DistrictID;
	}
	public int getDistrictID()
	{
		return DistrictID;
	}
    public void setDistrictName(String mDistrictName)
    {
        this.DistrictName = mDistrictName;
    }
    public String getDistrictName()
    {
        return DistrictName;
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

	public static clsDepotReport [] getAllDepotReportInformation()
	{
		return dlsDepot.getAllDepotReportInformation();
	}





	public static int getAllDepotCount()
	{
		return(dlsDepot.getAllDepotCount());
	}

	public static String[] getAllDepotNames()
	{
		return(dlsDepot.getAllDepotNames());
	}



	public static int getIDFromName(String mDepotName)
	{
		return dlsDepot.getIDFromName(mDepotName);
	}

	public static void showDepot(clsDepotReport temp)
	{
		System.out.println("Depot ID   : "+temp.getDepotID());
		System.out.println("Name : "+temp.getDepotName());
		System.out.println("Address   : "+temp.getAddress());
		System.out.println("Place ID  : "+temp.getPlaceID());
		System.out.println("Place Name : "+temp.getAreaName());
		System.out.println("District ID  : "+temp.getDistrictID());
		System.out.println("District Name  : "+temp.getDistrictName());
		System.out.println("ContactNumber   : "+temp.getContactNo());
		System.out.println("EmailID   : "+temp.getEmailID());
		System.out.println("Villagian:"+temp.getVillagian());

    }

	public static void main(String args[])
	{
		clsDepotReport temp[] = clsDepotReport.getAllDepotReportInformation();

		for(clsDepotReport t : temp)
		{
			showDepot(t);
		}

	}
}

