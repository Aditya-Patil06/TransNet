import javax.swing.*;

public class clsState
{
    private int 	StateID 	 ;
    private String 	StateName 	 ;
    private int 	CountryID	 ;

    public void setStateID(int StateID)
    {
        this.StateID = StateID;
    }

    public int getStateID()
    {
        return StateID;
    }

    public void setCountryID(int CountryID)
    {
        this.CountryID = CountryID;
    }

    public int getCountryID()
    {
        return CountryID;
    }

    public void setStateName(String StateName)
    {
        this.StateName = StateName;
    }

    public String getStateName()
    {
        return StateName;
    }

	public static void addNewState(clsState temp)
	{
		dlsState.addNewState(temp);
	}

	public static String [] getAllStateNames()
	{
		return(dlsState.getAllStateNames());
	}

	public static String [] getAllStateNames(int mCountryID)
	{
		return(dlsState.getAllStateNames(mCountryID));
	}

	public static clsState getStateInformation(int mStateID)
	{
		return(dlsState.getStateInformation(mStateID));
	}
	public static clsState [] getAllStateInformation()
	{
		return(dlsState.getAllStateInformation());
	}

	public static void addStateRecords(JComboBox temp,int mCountryID)
	{

		temp.removeAllItems();
		temp.addItem("Select State ...");
		String StateNames [] = clsState.getAllStateNames(mCountryID);
		for(String name : StateNames)
		{
			temp.addItem(name);
		}

	}

	public static void addStateRecords(JComboBox temp)
	{

		temp.removeAllItems();
		temp.addItem("Select State ...");
		String StateNames [] = clsState.getAllStateNames();
		for(String name : StateNames)
		{
			temp.addItem(name);
		}

	}

	public static int getIDFromName(String mStateName)
	{
		return dlsState.getIDFromName(mStateName);
	}

	public static void showState(clsState temp)
	{

		System.out.println("State ID   : "+temp.getStateID());
		System.out.println("State Name : "+temp.getStateName());
		System.out.println("Country ID  : "+temp.getCountryID());

	}

	public static void updateState(clsState temp)
	{
		dlsState.updateState(temp);
	}

	public static void deleteState(clsState temp)
	{
		dlsState.deleteState(temp);
	}

	public static void main(String args[])
	{

	}
}
