import javax.swing.*;

public class clsEmployee
{
    private int EmployeeID ;
    private String EmployeeName ;
    private String Address ;
    private int Age ;
    private int ContactNo ;
    private String EmailID ;
    private int DesignationID ;
    private int Gender ;
    private int AreaID ;
    private int BillaNo ;
    private String LicenceNo ;

    public void setEmployeeID(int EmployeeID)
    {
        this.EmployeeID = EmployeeID;
    }
    public int getEmployeeID()
    {
        return EmployeeID;
    }

    public void setEmployeeName(String EmployeeName)
    {
        this.EmployeeName = EmployeeName;
    }
    public String getEmployeeName()
    {
        return EmployeeName;
    }

	public void setAddress(String Address)
    {
        this.Address = Address;
    }
    public String getAddress()
    {
        return Address;
    }

    public void setAge(int Age)
    {
        this.Age = Age;
    }
    public int getAge()
    {
        return Age;
    }

	public void setContactNo(int ContactNo)
    {
        this.ContactNo = ContactNo;
    }
    public int getContactNo()
    {
        return ContactNo;
    }

    public void setEmailID(String EmailID)
    {
        this.EmailID = EmailID;
    }
    public String getEmailID()
    {
        return EmailID;
    }

	public void setDesignationID(int DesignationID)
    {
        this.DesignationID = DesignationID;
    }
    public int getDesignationID()
    {
        return DesignationID;
    }

    public void setGender(int Gender)
    {
        this.Gender = Gender;
    }
    public int getGender()
    {
        return Gender;
    }

	public void setAreaID(int AreaID)
    {
        this.AreaID = AreaID;
    }
    public int getAreaID()
    {
        return AreaID;
    }

    public void setBillaNo(int BillaNo)
    {
        this.BillaNo = BillaNo;
    }
    public int getBillaNo()
    {
        return BillaNo;
    }

	public void setLicenceNo(String LicenceNo)
    {
        this.LicenceNo = LicenceNo;
    }
    public String getLicenceNo()
    {
        return LicenceNo;
    }

	public static void addNewEmployee(clsEmployee temp)
	{
		System.out.println("cls Add new Employee");

		dlsEmployee.addNewEmployee(temp);
	}


	public static void updateEmployee(clsEmployee temp)
	{
		dlsEmployee.updateEmployee(temp);
	}

	public static void deleteEmployee(clsEmployee temp)
	{
		dlsEmployee.deleteEmployee(temp);
	}

	public static int getAllEmployeeCount()
	{
		return(dlsEmployee.getAllEmployeeCount());
	}

	public static String [] getAllEmployeeNames()
	{
		return(dlsEmployee.getAllEmployeeNames());
	}

	public static clsEmployee getEmployeeInformation(int mEmployeeID)
	{
		return(dlsEmployee.getEmployeeInformation(mEmployeeID));
	}

	public static clsEmployee[] getAllEmployeeInformation()
	{
		return(dlsEmployee.getAllEmployeeInformation());
	}


	public static void addEmployeeRecords(JComboBox temp)
	{
		temp.removeAllItems();
		temp.addItem("SelectEmployee ...");
		String EmployeeNames [] = clsEmployee.getAllEmployeeNames();
		for(String name :EmployeeNames)
		{
			temp.addItem(name);
		}
	}


	public static int getIDFromName(String mEmployeeName)
	{
		return dlsEmployee.getIDFromName(mEmployeeName);
	}
	public static void showEmployee(clsEmployee temp)
	{
		System.out.println("Employee ID   : "+temp.getEmployeeID());
		System.out.println("Employee Name : "+temp.getEmployeeName());
		System.out.println("Employee Address   : "+temp.getAddress());
		System.out.println("Employee Age : "+temp.getAge());
		System.out.println("Employee ContactNo   : "+temp.getContactNo());
		System.out.println("Employee EmailID : "+temp.getEmailID());
		System.out.println("Employee DesignationID  : "+temp.getDesignationID());
		System.out.println("Employee Gender : "+temp.getGender());
		System.out.println("Employee AreaID  : "+temp.getAreaID());
		System.out.println("Employee BillaNo : "+temp.getBillaNo());
		System.out.println("Employee LicenceNo : "+temp.getLicenceNo());

	}

	public static void main(String args[])
	{
		clsEmployee temp = clsEmployee.getEmployeeInformation(106);
		clsEmployee.showEmployee(temp);

	}


}
