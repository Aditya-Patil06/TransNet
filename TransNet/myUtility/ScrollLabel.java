package myUtility;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class ScrollLabel extends Thread
{
	JLabel currentLabel;
	JPanel pnlScrollPanel;
	int lblposition ;

	int speed;

	int LabelX;
	int LabelY;
	int LabelWidth;
	int LabelHeight;
	int ResetValue;

	int StartValue;

	public ScrollLabel(JLabel currentLabel,int speed,JPanel pnlScrollPanel)
	{
		this.currentLabel=currentLabel;
		this.pnlScrollPanel=pnlScrollPanel;
		this.speed=speed;
		Dimension parentPanel = pnlScrollPanel.getSize();
		Dimension currentLabelSize = currentLabel.getSize();
		Point currentLabelLocation = currentLabel.getLocation();
		LabelWidth=currentLabelSize.width;
		LabelHeight=currentLabelSize.height;
		LabelY=currentLabelLocation.y;
		StartValue=parentPanel.width;
		LabelX=StartValue;
		ResetValue=0-LabelWidth;

		start();
	}
	public void run()
	{
		while(true)
		{
			startScrolling();
		}
	}
	public void startScrolling()
	{

		try
		{
			LabelX=LabelX-1;

			if(LabelX < ResetValue)
			{
				LabelX=StartValue;
			}

			currentLabel.setBounds(LabelX,LabelY,LabelWidth,LabelHeight);

			Thread.sleep(speed);
		}
		catch(Exception e)
		{

		}
	}
}

