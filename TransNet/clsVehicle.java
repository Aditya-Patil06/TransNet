import javax.swing.*;

public class clsVehicle
{
    private int 	VehicleID;
    private String 	VehicleNumber;
    private String  Description;
    private String  ContactPerson;
    private String DriverName ;
    private String LicenceNo ;
    private int VehicleTypeID ;
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
	public void setDepotID(int DepotID)
	{
		this.DepotID = DepotID;
	}

	public int getDepotID()
	{
		return DepotID;
    }
	public static void addNewVehicle(clsVehicle temp)
	{
		dlsVehicle.addNewVehicle(temp);
	}
	public static String [] getAllVehicleNumbers()
	{
		return(dlsVehicle.getAllVehicleNumbers());
	}
	public static String [] getVehicleNumbers(int vVehicleTypeID)
	{
		return(dlsVehicle.getVehicleNumbers(vVehicleTypeID));
	}


	public static clsVehicle getVehicleInformation(int mVehicleID)
	{
		return(dlsVehicle.getVehicleInformation(mVehicleID));
	}
	public static clsVehicle [] getAllVehicleInformation()
	{
		return(dlsVehicle.getAllVehicleInformation());
	}
	public static void addVehicleRecords(JComboBox temp)
	{
		temp.removeAllItems();
		temp.addItem("Select Vehicle ...");
		String VehicleNumbers [] = clsVehicle.getAllVehicleNumbers();
		for(String name : VehicleNumbers)
		{
			temp.addItem(name);
		}
	}
	public static void addVehicleRecords(JComboBox temp, int vVehicleTypeID)
	{
		temp.removeAllItems();
		temp.addItem("Select Vehicle ...");
		String VehicleNumbers [] = clsVehicle.getVehicleNumbers(vVehicleTypeID);
		for(String name : VehicleNumbers)
		{
			temp.addItem(name);
		}
	}
	public static void addVehicleRecordsByDepotID(JComboBox temp, int mDepotID , int mVehicleTypeID)
	{
		temp.removeAllItems();
		temp.addItem("Select Vehicle ...");
		String VehicleNumbers [] = clsVehicle.getVehicleNumbersByDepotID(mDepotID , mVehicleTypeID);
		for(String name : VehicleNumbers)
		{
			temp.addItem(name);
		}
	}

	public static String[] getVehicleNumbersByDepotID(int mDepotID, int mVehicleTypeID)
	{
		return (dlsVehicle.getVehicleNumbersByDepotID(mDepotID,mVehicleTypeID));
	}

	public static int getIDFromName(String mVehicleNumber)
	{
		return dlsVehicle.getIDFromName(mVehicleNumber);
	}

	public static void showVehicle(clsVehicle temp)
	{
		System.out.println("Vehicle ID   : "+temp.getVehicleID());
		System.out.println("Vehicle Name : "+temp.getVehicleNumber());
		System.out.println("Description : "+temp.getDescription());
		System.out.println("VehicleTypeID : "+temp.getVehicleTypeID());
		System.out.println("ContactPerson    : "+temp.getContactPerson());
		System.out.println("DriverName    : "+temp.getDriverName());
		System.out.println("LicenceNo    : "+temp.getLicenceNo());
		System.out.println("Depot ID    : "+temp.getDepotID());

	}

	public static void updateVehicle(clsVehicle temp)
	{
		dlsVehicle.updateVehicle(temp);
	}

	public static void deleteVehicle(clsVehicle temp)
	{
		dlsVehicle.deleteVehicle(temp);
	}

	public static void main(String args[])
	{
		String[] countries = clsVehicle.getVehicleNumbersByDepotID(2,1);

		for (String country : countries)
		{
			System.out.println(country);
		}
	}
}