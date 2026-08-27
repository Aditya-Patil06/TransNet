package myUtility;
import javax.swing.*;
import java.awt.*;
public class UISetting
{
	public static void setArea(JPanel pnlTemp,int requireWidth,int requireHeight)
	{
		Dimension parentDimension =pnlTemp.getParent().getSize();
		int parentWidth = parentDimension.width;
		int parentHeight = parentDimension.height;
		int x = (parentWidth-requireWidth)/2;
		int y = ((parentHeight-requireHeight)/2);

		pnlTemp.setBounds(x,y,requireWidth,requireHeight);
	}
}


