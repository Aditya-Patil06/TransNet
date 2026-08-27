
package screensetting;
import myUtility.PanelState;
import java.awt.*;
import javax.swing.*;
import appsetting.*;

public class ReportDesign2 extends JPanel
{
	JPanel  pnlMain 		;//Main Structure Panels
	JPanel  pnlTop 			;
	JPanel  pnlBottom 		;
	JPanel  pnlLeft 		;
	JPanel  pnlRight		;
	JPanel  pnlHead 		;
	JPanel  pnlCenter 		;
	JPanel  pnlButton 		;//Panel Containing all panel or functional buttons
	JPanel  pnlLeftDown  	;
	JPanel  pnlUIReport 	;
	JPanel  pnlSelection	;

	JPanel  pnlCountryLabel	;
	JPanel  pnlCountryCombo	;

	JLabel  lblCountryCombo	;

	JComboBox cmbCountryCombo;

	JPanel  pnlInfo1		;//Panels Added in place of Buttons
	JPanel  pnlInfo2        ;
	JPanel  pnlInfo3		;
	JPanel  pnlInfo4		;
	JPanel  pnlInfo5		;
	JPanel  pnlInfo6	    ;
	JPanel  pnlInfo7	    ;

	JLabel lblInfo1 		;//Labels added on panel in place of buttons
	JLabel lblInfo2        	;
	JLabel lblInfo3        	;
	JLabel lblInfo4 		;
	JLabel lblInfo5			;
	JLabel lblInfo6			;
	JLabel lblInfo7			;

	JPanel  pnlReport 		;//panels used to add button btnReport and btnClose
	JPanel  pnlClose		;

	JButton btnReport 		;//Buttons used to show Report
	JButton btnClose 		;

	JLabel lblProject 		;//Label used for Heading , blinking labels and developers name
	JLabel lblProgramHeading;
	JLabel lblDevelopedBy 	;
	JLabel lblmember1 		;
	JLabel lblmember2 		;
	JLabel lblmember3		;
	JLabel lblShip1 		;

	/*JLabel lblShip2 		;//empty labels used to add images on panels pnlLeft and pnlRight
	JLabel lblTruck1 		;
	JLabel lblTruck2 		;
	JLabel lblAllVehicles 	;

	ImageIcon imgShip1 		;
	ImageIcon imgShip2 		;
	ImageIcon imgTruck1		;
	ImageIcon imgTruck2 	;
	ImageIcon imgAllVehicles;*/

	public ReportDesign2()
	{
		setVisible(true);
		setSize(1920,1080);
		setLayout(null);

		pnlMain = new JPanel();
		pnlMain.setLayout(null);
		pnlMain.setSize(1920,1080);
		pnlMain.setBackground(Color.RED);

		add(pnlMain);

		pnlTop = new JPanel();//top Panel Containing heading
		pnlTop.setBounds(0,0,1920,100);
		pnlTop.setBackground(Color.BLACK);
		pnlTop.setLayout(null);
		pnlMain.add(pnlTop);

		lblProject = new JLabel("My Project Here...");
		lblProject.setFont(new Font("Arial",Font.BOLD,26));
		lblProject.setForeground(Color.WHITE);
		lblProject.setBounds(850,30,250,30);
		pnlTop.add(lblProject);

		pnlBottom = new JPanel();//Bottom panel containing member names
		pnlBottom.setBounds(0,900,1920,100);
		pnlBottom.setBackground(Color.BLACK);
		pnlBottom.setLayout(null);
		pnlMain.add(pnlBottom);

		lblDevelopedBy = new JLabel("Developed By,");
		lblDevelopedBy.setFont(new Font("Arial",Font.BOLD,20));
		lblDevelopedBy.setForeground(Color.WHITE);
		lblDevelopedBy.setBounds(900,10,300,25);
		pnlBottom.add(lblDevelopedBy);

		lblmember1 = new JLabel("1. Developer 1");
		lblmember1.setFont(new Font("Arial",Font.BOLD,16));
		lblmember1.setForeground(Color.WHITE);
		lblmember1.setBounds(720,50,200,20);
		pnlBottom.add(lblmember1);

		lblmember2 = new JLabel("2. Developer 2");
		lblmember2.setFont(new Font("Arial",Font.BOLD,16));
		lblmember2.setForeground(Color.WHITE);
		lblmember2.setBounds(920,50,200,20);
		pnlBottom.add(lblmember2);

		lblmember3 = new JLabel("3. Developer 3");
		lblmember3.setFont(new Font("Arial",Font.BOLD,16));
		lblmember3.setForeground(Color.WHITE);
		lblmember3.setBounds(1120,50,200,20);
		pnlBottom.add(lblmember3);

		pnlLeft = new JPanel();
		pnlLeft.setBounds(0,105,290,790);
		pnlLeft.setBackground(Color.GRAY);
		pnlLeft.setLayout(null);
		pnlMain.add(pnlLeft);

//image
		/*imgShip1 = new ImageIcon("ship1.jpg");
		lblShip1 = new JLabel(imgShip1);
		lblShip1.setBounds(10,10,260,180);

		imgShip2 = new ImageIcon("ship2.jpg");
		lblShip2 = new JLabel(imgShip2);
		lblShip2.setBounds(10,210,260,200);*/

		pnlLeftDown = new JPanel();
		pnlLeftDown.setBounds(5,155,280,630);
		pnlLeftDown.setBackground(Color.BLACK);
		pnlLeftDown.setLayout(null);
		//pnlLeftDown.add(lblShip1);
		//pnlLeftDown.add(lblShip2);
		pnlLeft.add(pnlLeftDown);


		/*imgTruck1 = new ImageIcon("truck1.jpg");
		lblTruck1 = new JLabel(imgTruck1);
		lblTruck1.setBounds(10,10,270,180);

		imgTruck2 = new ImageIcon("truck2.jpg");
		lblTruck2 = new JLabel(imgTruck2);
		lblTruck2.setBounds(10,200,270,180);

		imgAllVehicles = new ImageIcon("allVehicles.jpg");
		lblAllVehicles = new JLabel(imgAllVehicles);
		lblAllVehicles.setBounds(10,390,270,180);*/

		pnlRight = new JPanel();
		pnlRight.setBounds(1630,105,290,790);
		pnlRight.setBackground(Color.BLACK);
		pnlRight.setLayout(null);
		//pnlRight.add(lblTruck1);
		//pnlRight.add(lblTruck2);
		//pnlRight.add(lblAllVehicles);
		pnlMain.add(pnlRight);

		pnlCenter = new JPanel();
		pnlCenter.setBounds(295,225,1330,605);
		pnlCenter.setLayout(null);
		pnlCenter.setBackground(Color.YELLOW);
		pnlMain.add(pnlCenter);

//Center panel where we add textField and ComboBox to insert data

		pnlUIReport =  new JPanel();
		pnlCenter.add(pnlUIReport);
		pnlUIReport.setBackground(Color.YELLOW);
		pnlUIReport.setBounds(5,5,1320,660);

// in center panel where blinking label is located

		pnlHead = new JPanel();
		pnlHead.setBounds(295,105,1330,50);
		pnlHead.setBackground(Color.GREEN);
		pnlHead.setLayout(null);
		pnlMain.add(pnlHead);

		lblProgramHeading = new JLabel("...Your Project Name Here ...");
		lblProgramHeading.setFont(new Font("Arial",Font.BOLD,22));
		lblProgramHeading.setBounds(540,10,800,30);
		pnlHead.add(lblProgramHeading);

		pnlSelection = new JPanel();
		pnlSelection.setBounds(295,160,1330,60);
		pnlSelection.setBackground(Color.GREEN);
		pnlSelection.setLayout(null);
		pnlMain.add(pnlSelection);

		pnlButton = new JPanel();
		pnlButton.setBounds(295,835,1330,60);
		pnlButton.setBackground(Color.GREEN);
		pnlButton.setLayout(null);
		pnlMain.add(pnlButton);

		pnlInfo1 = new JPanel();
		pnlInfo1.setBackground(Color.BLACK);
		pnlInfo1.setBounds(30,5,120,50);
		pnlInfo1.setLayout(null);
		pnlButton.add(pnlInfo1);

		lblInfo1 = new JLabel("..............");
		lblInfo1.setBounds(5,5,110,40);
		pnlInfo1.add(lblInfo1);

		pnlInfo2 = new JPanel();
		pnlInfo2.setBackground(Color.BLACK);
		pnlInfo2.setBounds(180,5,120,50);
		pnlInfo2.setLayout(null);
		pnlButton.add(pnlInfo2);

		lblInfo2 = new JLabel("..........");
		lblInfo2.setBounds(5,5,110,40);
		pnlInfo2.add(lblInfo2);

		pnlInfo3 = new JPanel();
		pnlInfo3.setBackground(Color.BLACK);
		pnlInfo3.setBounds(340,5,120,50);
		pnlInfo3.setLayout(null);
		pnlButton.add(pnlInfo3);

		lblInfo3 = new JLabel(".............");
		lblInfo3.setBounds(5,5,110,40);
		pnlInfo3.add(lblInfo3);

		pnlInfo4 = new JPanel();
		pnlInfo4.setBackground(Color.BLACK);
		pnlInfo4.setBounds(495,5,120,50);
		pnlInfo4.setLayout(null);
		pnlButton.add(pnlInfo4);

		lblInfo4 = new JLabel(".......");
		lblInfo4.setBounds(5,5,110,40);
		pnlInfo4.add(lblInfo4);

		pnlInfo5 = new JPanel();
		pnlInfo5.setBackground(Color.BLACK);
		pnlInfo5.setBounds(660,5,120,50);
		pnlInfo5.setLayout(null);
		pnlButton.add(pnlInfo5);

		lblInfo5 = new JLabel("........");
		lblInfo5.setBounds(5,5,110,40);
		pnlInfo5.add(lblInfo5);

		pnlInfo6 = new JPanel();
		pnlInfo6.setBackground(Color.BLACK);
		pnlInfo6.setBounds(820,5,120,50);
		pnlInfo6.setLayout(null);
		pnlButton.add(pnlInfo6);

		lblInfo6 = new JLabel(".......");
		lblInfo6.setBounds(5,5,110,40);
		pnlInfo6.add(lblInfo6);

        pnlInfo7 = new JPanel();
		pnlInfo7.setBackground(Color.BLACK);
		pnlInfo7.setBounds(980,5,120,50);
		pnlInfo7.setLayout(null);
		pnlButton.add(pnlInfo7);

		lblInfo7 = new JLabel("....");
		lblInfo7.setBounds(5,5,110,40);
		pnlInfo7.add(lblInfo7);

		pnlCountryLabel = new JPanel();
		pnlCountryLabel.setBackground(Color.BLACK);
		pnlCountryLabel.setBounds(10,5,120,50);
		pnlCountryLabel.setLayout(null);
		pnlSelection.add(pnlCountryLabel);

        lblCountryCombo = new JLabel("Select Country");
		lblCountryCombo.setBounds(10,5,120,50);
		pnlCountryLabel.add(lblCountryCombo);

		pnlCountryCombo= new JPanel();
		pnlCountryCombo.setBackground(Color.BLACK);
		pnlCountryCombo.setBounds(140,5,220,50);
		pnlCountryCombo.setLayout(null);
		pnlSelection.add(pnlCountryCombo);

		cmbCountryCombo = new JComboBox();
		cmbCountryCombo.addItem("No Records....");
		cmbCountryCombo.setBounds(5,5,210,40);
		pnlCountryCombo.add(cmbCountryCombo);

		pnlReport = new JPanel();
		pnlReport.setBackground(Color.BLACK);
		pnlReport.setBounds(1170,5,120,50);
		pnlReport.setLayout(null);
		pnlSelection.add(pnlReport);

		pnlClose = new JPanel();
		pnlClose.setBackground(Color.BLACK);
		pnlClose.setBounds(1170,5,120,50);
		pnlClose.setLayout(null);
		pnlSelection.add(pnlClose);

		btnReport = new JButton("Report");
		btnReport.setBounds(5,5,110,40);
		pnlReport.add(btnReport);

		btnClose= new JButton("Close");
		btnClose.setBounds(5,5,110,40);
		pnlClose.add(btnClose);

//Color Setting where all panels colors are set from ColorSetting Class in appsetting

		pnlTop.setBackground(ColorSetting.getBackColorTopPnl());
		pnlBottom.setBackground(ColorSetting.getBackColorBottomPnl());
		pnlCenter.setBackground(ColorSetting.getBackColorCenterPnl());
		pnlHead.setBackground(ColorSetting.getBackColorHeadPnl());
		pnlButton.setBackground(ColorSetting.getBackColorButtonPnl());
		pnlMain.setBackground(ColorSetting.getBackColorMainPnl());
		pnlLeft.setBackground(ColorSetting.getBackColorLeftPnl());
		pnlRight.setBackground(ColorSetting.getBackColorRightPnl());
		pnlLeftDown.setBackground(ColorSetting.getBackColorLeftDownPnl());
		pnlSelection.setBackground(ColorSetting.getBackColorSelectionPnl());


		lblInfo1.setBackground(ColorSetting.getBackColorButton());
		lblInfo2.setBackground(ColorSetting.getBackColorButton());
		lblInfo3.setBackground(ColorSetting.getBackColorButton());
		lblInfo4.setBackground(ColorSetting.getBackColorButton());
		lblInfo5.setBackground(ColorSetting.getBackColorButton());
		lblInfo6.setBackground(ColorSetting.getBackColorButton());
		lblInfo7.setBackground(ColorSetting.getBackColorButton());

		pnlInfo1.setBackground(ColorSetting.getBackColorLeftPnl());
		pnlInfo2.setBackground(ColorSetting.getBackColorLeftPnl());
		pnlInfo3.setBackground(ColorSetting.getBackColorLeftPnl());
		pnlInfo4.setBackground(ColorSetting.getBackColorLeftPnl());
		pnlInfo5.setBackground(ColorSetting.getBackColorLeftPnl());
		pnlInfo6.setBackground(ColorSetting.getBackColorLeftPnl());
		pnlInfo7.setBackground(ColorSetting.getBackColorLeftPnl());
		pnlCountryLabel.setBackground(ColorSetting.getBackColorLeftPnl());


		btnReport.setBackground(ColorSetting.getBackColorButton());
		btnClose.setBackground(ColorSetting.getBackColorButton());

//setting blinking label and project name through ProjectSetting in appsetting
		//lblProgramHeading.setText(ProjectSetting.getProjectTitle());
		//lblProject.setText(ProjectSetting.getProject());

		setDefaultSetting();

	}

	void setDefaultSetting ()
	{
	    PanelState.enabledComponents(pnlInfo1);
        PanelState.enabledComponents(pnlInfo2);
        PanelState.enabledComponents(pnlInfo3);
		PanelState.enabledComponents(pnlInfo4);
		PanelState.enabledComponents(pnlInfo5);
        PanelState.enabledComponents(pnlInfo6);
		PanelState.enabledComponents(pnlInfo7);

		PanelState.enabledComponents(pnlReport);
		PanelState.hideComponents(pnlUIReport);
		PanelState.hideComponents(pnlClose);

	}

public JLabel getlblProgramHeading()
	{
		return lblProgramHeading ;
	}
	public JPanel getUIReportPanel()
	{
		return pnlUIReport ;
	}

	public JPanel getInfo1Panel()
	{
		return pnlInfo1;
	}
	public JLabel getlblInfo1()
	{
		return lblInfo1;
	}
	public JPanel getInfo2Panel()
	{
		return pnlInfo2;
	}
	public JLabel getlblInfo2()
	{
		return lblInfo2;
	}
	public JPanel getInfo3Panel()
	{
		return pnlInfo3;
	}
	public JLabel getlblInfo3()
	{
		return lblInfo3;
	}
	public JPanel getInfo4Panel()
	{
		return pnlInfo4;
	}
	public JLabel getlblInfo4()
	{
		return lblInfo4;
	}

	public JPanel getInfo5Panel()
	{
		return pnlInfo5;
	}
	public JLabel getlblInfo5()
	{
		return lblInfo5;
	}

	public JPanel getInfo6Panel()
	{
		return pnlInfo6;
	}
	public JLabel getlblInfo6()
	{
		return lblInfo6;
	}

	public JPanel getInfo7Panel()
	{
		return pnlInfo7;
	}
	public JLabel getlblInfo7()
	{
		return lblInfo7;
	}

	public JButton getCloseButton()
	{
		return btnClose;
	}
	public JPanel getClosePanel()
	{
		return pnlClose ;
	}
	public JPanel getReportPanel()
	{
		return pnlReport;
	}
	public JButton getReportButton()
	{
		return btnReport;
	}

	public JPanel getCountryLabelPanel()//might want to give lblCountryPanel or pnlCountryLabel
	{
		return pnlCountryLabel;
	}
	public JLabel getlblCountry()
	{
		return lblCountryCombo;
	}
	public JPanel getCountryComboPanel()
	{
		return pnlCountryCombo;
	}
	public JComboBox getcmbCountry()
	{
		return cmbCountryCombo;
	}


}
