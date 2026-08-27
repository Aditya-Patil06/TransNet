import javax.swing.*;

public class clsGenerateDocket
{
    private int GenerateDocketID;
    private String GenerateDocketName;
    private int DocketCounter;

    public void setGenerateDocketID(int GenerateDocketID)
    {
        this.GenerateDocketID = GenerateDocketID;
    }

    public int getGenerateDocketID()
    {
        return GenerateDocketID;
    }

    public void setDocketCounter(int DocketCounter)
    {
        this.DocketCounter = DocketCounter;
    }

    public int getDocketCounter()
    {
        return DocketCounter;
    }

    public void setGenerateDocketName(String GenerateDocketName)
    {
        this.GenerateDocketName = GenerateDocketName;
    }

    public String getGenerateDocketName()
    {
        return GenerateDocketName;
    }

    public static void addNewGenerateDocket(clsGenerateDocket temp)
    {
        dlsGenerateDocket.addNewGenerateDocket(temp);
    }

    public static String[] getAllGenerateDocketNames()
    {
        return dlsGenerateDocket.getAllGenerateDocketNames();
    }

    public static String[] getAllGenerateDocketNames(int mDocketCounter)
    {
        return dlsGenerateDocket.getAllGenerateDocketNames(mDocketCounter);
    }

    public static clsGenerateDocket getGenerateDocketInformation(int mGenerateDocketID)
    {
        return dlsGenerateDocket.getGenerateDocketInformation(mGenerateDocketID);
    }

    public static clsGenerateDocket[] getAllGenerateDocketInformation()
    {
        return dlsGenerateDocket.getAllGenerateDocketInformation();
    }

    public static String getNewDocketNo()
    {
        return dlsGenerateDocket.getNewDocketNo();
    }

    public static void addGenerateDocketRecords(JComboBox temp, int mDocketCounter)
    {
        temp.removeAllItems();
        temp.addItem("Select GenerateDocket ...");
        String GenerateDocketNames[] = clsGenerateDocket.getAllGenerateDocketNames(mDocketCounter);
        for (String name : GenerateDocketNames)
        {
            temp.addItem(name);
        }
    }

    public static void addGenerateDocketRecords(JComboBox temp)
    {
        temp.removeAllItems();
        temp.addItem("Select GenerateDocket ...");
        String GenerateDocketNames[] = clsGenerateDocket.getAllGenerateDocketNames();
        for (String name : GenerateDocketNames)
        {
            temp.addItem(name);
        }
    }

    public static int getIDFromName(String mGenerateDocketName)
    {
        return dlsGenerateDocket.getIDFromName(mGenerateDocketName);
    }

    // New method: Fetch GenerateDocketName by GenerateDocketID
    public static String getNameFromID(int generateDocketID)
    {
        return dlsGenerateDocket.getNameFromID(generateDocketID);
    }

    public static void showGenerateDocket(clsGenerateDocket temp)
    {
        System.out.println("GenerateDocket ID   : " + temp.getGenerateDocketID());
        System.out.println("GenerateDocket Name : " + temp.getGenerateDocketName());
        System.out.println("Docket Counter ID   : " + temp.getDocketCounter());
    }

    public static void updateGenerateDocket(clsGenerateDocket temp)
    {
        dlsGenerateDocket.updateGenerateDocket(temp);
    }

    public static void deleteGenerateDocket(clsGenerateDocket temp)
    {
        dlsGenerateDocket.deleteGenerateDocket(temp);
    }

    public static int getHighDocet()
    {
        return dlsGenerateDocket.getHighDocet();
    }

    public static void main(String args[])
    {

        int testID = 1;
        String docketName = clsGenerateDocket.getNameFromID(testID);
        System.out.println("Docket Name for ID " + testID + ": " + docketName);
    }
}