import javax.swing.*;

public class clsVehicleReport
{
    private int 	VehicleID;
    private String 	VehicleNumber;
    private String  Description;
    private String  ContactPerson;
    private String DriverName ;
    private String LicenceNo ;
    private int VehicleTypeID ;
	private String VehicleTypeName ;
	private String DepotName ;
    private int DepotID ;

    public void setVehicleID(int VehicleID)
    {
        this.VehicleID = VehicleID;
    }

    public int getVehicleID()
    {
        return VehicleID;
    }

    public void setVehicleNumber(String VehicleNumber)
    {
        this.VehicleNumber = VehicleNumber;
    }

    public String getVehicleNumber()
    {
        return VehicleNumber;
    }
    public void setDescription(String Description)
	{
		this.Description = Description;
	}
	public String getDescription()
	{
		return Description;
    }
	public void setDriverName(String DriverName)
	{
		this.DriverName = DriverName;
	}
	public String getDriverName()
	{
		return DriverName;
    }
	public void setLicenceNo(String LicenceNo)
	{
		this.LicenceNo = LicenceNo;
	}
	public String getLicenceNo()
	{
		return LicenceNo;
    }
	public void setContactPerson(String ContactPerson)
	{
		this.ContactPerson = ContactPerson;
	}
	public String getContactPerson()
	{
		return ContactPerson;
    }
    public void setVehicleTypeID(int VehicleTypeID)
	{
		this.VehicleTypeID = VehicleTypeID;
	}

	public int getVehicleTypeID()
	{
		return VehicleTypeID;
    }
	public void setVehicleTypeName(String VehicleTypeName)
	{
		this.VehicleTypeName = VehicleTypeName;
	}

	public String getVehicleTypeName()
	{
		return VehicleTypeName;
    }
	public void setDepotID(int DepotID)
	{
		this.DepotID = DepotID;
	}

	public int getDepotID()
	{
		return DepotID;
    }

	public void setDepotName(String DepotName)
	{
		this.DepotName = DepotName;
	}

	public String getDepotName()
	{
		return DepotName;
    }

	public static clsVehicleReport [] getAllVehicleReportInformation()
	{
		return(dlsVehicle.getAllVehicleReportInformation());
	}
	public static void showVehicle(clsVehicleReport temp)
	{
		System.out.println("Vehicle ID   : "+temp.getVehicleID());
		System.out.println("Vehicle Name : "+temp.getVehicleNumber());
		System.out.println("Description : "+temp.getDescription());
		System.out.println("VehicleTypeID : "+temp.getVehicleTypeID());
		System.out.println("ContactPerson    : "+temp.getContactPerson());
		System.out.println("DriverName    : "+temp.getDriverName());
		System.out.println("LicenceNo    : "+temp.getLicenceNo());
		System.out.println("VehicleType ID    : "+temp.getVehicleTypeID());
		System.out.println("Depot ID    : "+temp.getDepotID());
		System.out.println("VehicleType Name    : "+temp.getVehicleTypeName());
		System.out.println("Depot Name    : "+temp.getDepotName());
	}


	public static void main(String args[])
	{

	}
}