import javax.swing.*;

public class clsVehicleType
{
    private int 	VehicleTypeID 		;
    private String 	VehicleTypeName 	;

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

	public static void addNewVehicleType(clsVehicleType temp)
	{
		dlsVehicleType.addNewVehicleType(temp);
	}

	public static String [] getAllVehicleTypeNames()
	{
		return(dlsVehicleType.getAllVehicleTypeNames());
	}

	public static clsVehicleType getVehicleTypeInformation(int mVehicleTypeID)
	{
		return(dlsVehicleType.getVehicleTypeInformation(mVehicleTypeID));
	}
	public static clsVehicleType [] getAllVehicleTypeInformation()
	{
		return(dlsVehicleType.getAllVehicleTypeInformation());
	}
	public static void addVehicleTypeRecords(JComboBox temp)
	{
		temp.removeAllItems();
		temp.addItem("Select VehicleTypeName ...");
		String VehicleTypeNames [] = clsVehicleType.getAllVehicleTypeNames();
		for(String name : VehicleTypeNames)
		{
			temp.addItem(name);
		}
	}

	public static int getIDFromName(String mVehicleTypeName)
	{
		return dlsVehicleType.getIDFromName(mVehicleTypeName);
	}
	public static String getNameFromID(int mVehicleTypeID)
	{
		return dlsVehicleType.getNameFromID(mVehicleTypeID);
	}

	public static void showVehicleType(clsVehicleType temp)
	{
		System.out.println("VehicleTypeID   : "+temp.getVehicleTypeID());
		System.out.println("VehicleTypeName : "+temp.getVehicleTypeName());

	}

	public static void updateVehicleType(clsVehicleType temp)
	{
		dlsVehicleType.updateVehicleType(temp);
	}

	public static void deleteVehicleType(clsVehicleType temp)
	{
		dlsVehicleType.deleteVehicleType(temp);
	}

	public static void main(String args[])
	{

	}
}