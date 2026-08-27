import javax.swing.*;

public class clsGoods
{
    private int 	GoodsID 		;
    private String 	GoodsName 	;

    public void setGoodsID(int GoodsID)
    {
        this.GoodsID = GoodsID;
    }

    public int getGoodsID()
    {
        return GoodsID;
    }

    public void setGoodsName(String GoodsName)
    {
        this.GoodsName = GoodsName;
    }

    public String getGoodsName()
    {
        return GoodsName;
    }

	public static void addNewGoods(clsGoods temp)
	{
		dlsGoods.addNewGoods(temp);
	}

	public static String [] getAllGoodsNames()
	{
		return(dlsGoods.getAllGoodsNames());
	}

	public static clsGoods getGoodsInformation(int mGoodsID)
	{
		return(dlsGoods.getGoodsInformation(mGoodsID));
	}
	public static clsGoods [] getAllGoodsInformation()
	{
		return(dlsGoods.getAllGoodsInformation());
	}
	public static void addGoodsRecords(JComboBox temp)
	{
		temp.removeAllItems();
		temp.addItem("Select Goods ...");
		String GoodsNames [] = clsGoods.getAllGoodsNames();
		for(String name : GoodsNames)
		{
			temp.addItem(name);
		}
	}

	public static int getIDFromName(String mGoodsName)
	{
		return dlsGoods.getIDFromName(mGoodsName);
	}

	public static void showGoods(clsGoods temp)
	{
		System.out.println("Goods ID   : "+temp.getGoodsID());
		System.out.println("Goods Name : "+temp.getGoodsName());

	}

	public static void updateGoods(clsGoods temp)
	{
		dlsGoods.updateGoods(temp);
	}

	public static void deleteGoods(clsGoods temp)
	{
		dlsGoods.deleteGoods(temp);
	}

	public static void main(String args[])
	{

	}
}