package screensetting;
import myUtility.PanelState;
import java.awt.*;
import javax.swing.*;
import appsetting.*;


public class VehicleDesign extends JPanel
{
	JPanel  pnlMain 		;
	JPanel  pnlTop 			;
	JPanel  pnlGodLogo 	;
	JPanel  pnlProjectLogo 	;
	JPanel  pnlBottomRight 	;
	JPanel  pnlBottomLeft 	;
	JPanel  pnlLeft 		;
	JPanel  pnlRight		;
	JPanel  pnlProgramHeading;
	JPanel  pnlCenter 		;
	JPanel  pnlButton 		;
	JPanel  pnlLeftUp 		;
	JPanel  pnlLeftDown  	;
	JPanel  pnlApply 		;
	JPanel  pnlUI 			;
	JPanel  pnlUIReport 	;
	JPanel  pnlSave 		;
	JPanel  pnlDelete 		;
	JPanel  pnlUpdate 		;
	JPanel  pnlNew 			;
	JPanel  pnlView 		;
	JPanel  pnlEdit 		;
	JPanel  pnlCancel 		;
	JPanel  pnlReport 		;
	JPanel  pnlCombo1		;
	JPanel  pnlClose		;

	JButton btnSave 		;
	JButton btnDelete 		;
	JButton btnUpdate 		;
	JButton btnNew 			;
	JButton btnView			;
	JButton btnEdit 		;
	JButton btnCancel 		;
	JButton btnReport 		;
	JButton btnClose 		;
	JButton btnApply		;

	JLabel lblProject 		;
	JLabel lblProgramHeading;
	JLabel lblDevelopedBy 	;
	JLabel lblmember1 		;
	JLabel lblmember2 		;
	JLabel lblmember3		;
	JLabel lblShip1 		;
	JLabel lblShip2 		;
	JLabel lblTruck1 		;
	JLabel lblTruck2 		;
	JLabel lblAllVehicles 	;
	JLabel lblCombo1		;
	JLabel lblGalaxy		;

	ImageIcon imgShip1 		;
	ImageIcon imgShip2 		;
	ImageIcon imgTruck1		;
	ImageIcon imgTruck2 	;
	ImageIcon imgAllVehicles;

	JComboBox cmbCombo1 	;

	public ScreenDesign()
	{
		setVisible(true);
		setSize(1920,1080);
		setLayout(null);

		pnlMain = new JPanel();
		pnlMain.setLayout(null);
		pnlMain.setSize(1920,1080);
		pnlMain.setBackground(Color.RED);

		add(pnlMain);

		pnlTop = new JPanel();
		pnlTop.setBounds(170,0,1580,100);
		pnlTop.setBackground(Color.BLACK);
		pnlTop.setLayout(null);
		pnlMain.add(pnlTop);

		pnlGodLogo = new JPanel();
		pnlGodLogo.setBounds(0,0,165,100);
		pnlGodLogo.setBackground(Color.BLACK);
		pnlGodLogo.setLayout(null);
		pnlMain.add(pnlGodLogo);

		pnlProjectLogo = new JPanel();
		pnlProjectLogo.setBounds(1755,0,165,100);
		pnlProjectLogo.setBackground(Color.RED);
		pnlProjectLogo.setLayout(null);
		pnlMain.add(pnlProjectLogo);

		pnlBottomRight = new JPanel();
		pnlBottomRight.setBounds(445,900,1475,100);
		pnlBottomRight.setBackground(Color.BLACK);
		pnlBottomRight.setLayout(null);
		pnlMain.add(pnlBottomRight);

		pnlBottomLeft = new JPanel();
		pnlBottomLeft.setBounds(0,900,440,100);
		pnlBottomLeft.setBackground(Color.RED);
		pnlBottomLeft .setLayout(null);
		pnlMain.add(pnlBottomLeft );

		lblGalaxy =  new JLabel("Our Talent Spins The World ...");
		lblGalaxy.setFont(new Font("Arial",Font.BOLD,20));
		lblGalaxy.setForeground(Color.WHITE);
		lblGalaxy.setBounds(50,30,300,25);
		pnlBottomLeft.add(lblGalaxy);

		lblDevelopedBy = new JLabel("Developed By,");
		lblDevelopedBy.setFont(new Font("Arial",Font.BOLD,20));
		lblDevelopedBy.setForeground(Color.WHITE);
		lblDevelopedBy.setBounds(700,10,300,25);
		pnlBottomRight.add(lblDevelopedBy);

		lblmember1 = new JLabel("1. Mayur Chaudhari");
		lblmember1.setFont(new Font("Arial",Font.BOLD,16));
		lblmember1.setForeground(Color.WHITE);
		lblmember1.setBounds(420,50,200,20);
		pnlBottomRight.add(lblmember1);

		lblmember2 = new JLabel("2. Aditya Patil");
		lblmember2.setFont(new Font("Arial",Font.BOLD,16));
		lblmember2.setForeground(Color.WHITE);
		lblmember2.setBounds(620,50,200,20);
		pnlBottomRight.add(lblmember2);

		lblmember3 = new JLabel("3. Tejas Kankhare");
		lblmember3.setFont(new Font("Arial",Font.BOLD,16));
		lblmember3.setForeground(Color.WHITE);
		lblmember3.setBounds(820,50,200,20);
		pnlBottomRight.add(lblmember3);

		lblProject = new JLabel("My Project Here...");
		lblProject.setFont(new Font("Arial",Font.BOLD,26));
		lblProject.setForeground(Color.WHITE);
		lblProject.setBounds(700,30,250,30);
		pnlTop.add(lblProject);

		pnlLeft = new JPanel();
		pnlLeft.setBounds(0,105,290,790);
		pnlLeft.setBackground(Color.GRAY);
		pnlLeft.setLayout(null);
		pnlMain.add(pnlLeft);

		pnlLeftUp = new JPanel();
		pnlLeftUp.setBounds(5,5,280,145);
		pnlLeftUp.setBackground(Color.WHITE);
		pnlLeftUp.setLayout(null);
		pnlLeft.add(pnlLeftUp);

		pnlCombo1 = new JPanel();
		pnlCombo1.setBounds(5,5,270,80);
		pnlCombo1.setBackground(Color.LIGHT_GRAY);
		pnlCombo1.setLayout(null);
		pnlLeftUp.add(pnlCombo1);

		lblCombo1 = new JLabel("Label is not set");
		lblCombo1.setBounds(5,5,260,30);
		pnlCombo1.add(lblCombo1);

		cmbCombo1 = new JComboBox();
		cmbCombo1.addItem("No Records....");
		cmbCombo1.setBounds(5,40,260,30);
		pnlCombo1.add(cmbCombo1);


		pnlApply = new JPanel();
		pnlApply.setBounds(5,90,270,50);
		pnlApply.setBackground(Color.LIGHT_GRAY);
		pnlApply.setLayout(null);
		pnlLeftUp.add(pnlApply);

		btnApply = new JButton("Apply");
		btnApply.setBounds(5,5,260,40);
		pnlApply.add(btnApply);

		imgShip1 = new ImageIcon("ship1.jpg");
		lblShip1 = new JLabel(imgShip1);
		lblShip1.setBounds(10,10,260,180);

		imgShip2 = new ImageIcon("ship2.jpg");
		lblShip2 = new JLabel(imgShip2);
		lblShip2.setBounds(10,210,260,200);

		pnlLeftDown = new JPanel();
		pnlLeftDown.setBounds(5,155,280,630);
		pnlLeftDown.setBackground(Color.BLACK);
		pnlLeftDown.setLayout(null);
		pnlLeftDown.add(lblShip1);
		pnlLeftDown.add(lblShip2);
		pnlLeft.add(pnlLeftDown);


		imgTruck1 = new ImageIcon("truck1.jpg");
		lblTruck1 = new JLabel(imgTruck1);
		lblTruck1.setBounds(10,10,270,180);

		imgTruck2 = new ImageIcon("truck2.jpg");
		lblTruck2 = new JLabel(imgTruck2);
		lblTruck2.setBounds(10,200,270,180);

		imgAllVehicles = new ImageIcon("allVehicles.jpg");
		lblAllVehicles = new JLabel(imgAllVehicles);
		lblAllVehicles.setBounds(10,390,270,180);

		pnlRight = new JPanel();
		pnlRight.setBounds(1630,105,290,790);
		pnlRight.setBackground(Color.BLACK);
		pnlRight.setLayout(null);
		pnlRight.add(lblTruck1);
		pnlRight.add(lblTruck2);
		pnlRight.add(lblAllVehicles);
		pnlMain.add(pnlRight);

		pnlCenter = new JPanel();
		pnlCenter.setBounds(295,160,1330,670);
		pnlCenter.setLayout(null);
		pnlCenter.setBackground(Color.YELLOW);
		pnlMain.add(pnlCenter);

		pnlUI =  new JPanel();
		pnlCenter.add(pnlUI);
		pnlUI.setBackground(Color.RED);
		pnlUI.setBounds(5,5,1320,660);


		pnlUIReport =  new JPanel();
		pnlCenter.add(pnlUIReport);
		pnlUIReport.setBackground(Color.YELLOW);
		pnlUIReport.setBounds(5,5,1320,660);

		pnlProgramHeading = new JPanel();
		pnlProgramHeading.setBounds(295,105,1330,50);
		pnlProgramHeading.setBackground(Color.GREEN);
		pnlProgramHeading.setLayout(null);
		pnlMain.add(pnlProgramHeading);

		lblProgramHeading = new JLabel("...Transportation Management System...");
		lblProgramHeading.setFont(new Font("Arial",Font.BOLD,22));
		lblProgramHeading.setBounds(470,10,800,30);
		pnlProgramHeading.add(lblProgramHeading);

		pnlButton = new JPanel();
		pnlButton.setBounds(295,835,1330,60);
		pnlButton.setBackground(Color.GREEN);
		pnlButton.setLayout(null);
		pnlMain.add(pnlButton);

		pnlSave = new JPanel();
		pnlSave.setBackground(Color.BLACK);
		pnlSave.setBounds(180,5,120,50);
		pnlSave.setLayout(null);
		pnlButton.add(pnlSave);

		pnlDelete = new JPanel();
		pnlDelete.setBackground(Color.BLACK);
		pnlDelete.setBounds(820,5,120,50);
		pnlDelete.setLayout(null);
		pnlButton.add(pnlDelete);

		pnlUpdate = new JPanel();
		pnlUpdate.setBackground(Color.BLACK);
		pnlUpdate.setBounds(660,5,120,50);
		pnlUpdate.setLayout(null);
		pnlButton.add(pnlUpdate);

		pnlNew = new JPanel();
		pnlNew.setBackground(Color.BLACK);
		pnlNew.setBounds(30,5,120,50);
		pnlNew.setLayout(null);
		pnlButton.add(pnlNew);

		pnlView = new JPanel();
		pnlView.setBackground(Color.BLACK);
		pnlView.setBounds(340,5,120,50);
		pnlView.setLayout(null);
		pnlButton.add(pnlView);

		pnlEdit = new JPanel();
		pnlEdit.setBackground(Color.BLACK);
		pnlEdit.setBounds(495,5,120,50);
		pnlEdit.setLayout(null);
		pnlButton.add(pnlEdit);

		pnlCancel = new JPanel();
		pnlCancel.setBackground(Color.BLACK);
		pnlCancel.setBounds(980,5,120,50);
		pnlCancel.setLayout(null);
		pnlButton.add(pnlCancel);

		pnlReport = new JPanel();
		pnlReport.setBackground(Color.BLACK);
		pnlReport.setBounds(1170,5,120,50);
		pnlReport.setLayout(null);
		pnlButton.add(pnlReport);

		pnlClose = new JPanel();
		pnlClose.setBackground(Color.BLACK);
		pnlClose.setBounds(1170,5,120,50);
		pnlClose.setLayout(null);
		pnlButton.add(pnlClose);

		btnSave = new JButton("Save");
		btnSave.setBounds(5,5,110,40);
		pnlSave.add(btnSave);

		btnDelete = new JButton("Delete");
		btnDelete.setBounds(5,5,110,40);
		pnlDelete.add(btnDelete);

		btnUpdate = new JButton("Update");
		btnUpdate.setBounds(5,5,110,40);
		pnlUpdate.add(btnUpdate);

		btnNew = new JButton("New");
		btnNew.setBounds(5,5,110,40);
		pnlNew.add(btnNew);

		btnView = new JButton("View");
		btnView.setBounds(5,5,110,40);
		pnlView.add(btnView);

		btnEdit = new JButton("Edit");
		btnEdit.setBounds(5,5,110,40);
		pnlEdit.add(btnEdit);

		btnCancel = new JButton("Cancle");
		btnCancel.setBounds(5,5,110,40);
		pnlCancel.add(btnCancel);

		btnReport = new JButton("Report");
		btnReport.setBounds(5,5,110,40);
		pnlReport.add(btnReport);

		btnClose= new JButton("Close");
		btnClose.setBounds(5,5,110,40);
		pnlClose.add(btnClose);

		pnlTop.setBackground(ColorSetting.getBackColorTopPnl());
		pnlGodLogo.setBackground(ColorSetting.getBackColorTopPnl());
		pnlProjectLogo.setBackground(ColorSetting.getBackColorTopPnl());
		pnlBottomRight.setBackground(ColorSetting.getBackColorBottomPnl());
		pnlBottomLeft.setBackground(ColorSetting.getBackColorBottomPnl());
		pnlCenter.setBackground(ColorSetting.getBackColorCenterPnl());
		pnlProgramHeading.setBackground(ColorSetting.getBackColorHeadPnl());
		pnlButton.setBackground(ColorSetting.getBackColorButtonPnl());
		pnlMain.setBackground(ColorSetting.getBackColorMainPnl());
		pnlLeft.setBackground(ColorSetting.getBackColorLeftPnl());
		pnlRight.setBackground(ColorSetting.getBackColorRightPnl());
		pnlLeftUp.setBackground(ColorSetting.getBackColorLeftUpPnl());
		pnlLeftDown.setBackground(ColorSetting.getBackColorLeftDownPnl());
		pnlCombo1.setBackground(ColorSetting.getBackColorCombo1Pnl());
		pnlApply.setBackground(ColorSetting.getBackColorApplyPnl());

		btnApply.setBackground(ColorSetting.getBackColorButton());
		btnSave.setBackground(ColorSetting.getBackColorButton());
		btnUpdate.setBackground(ColorSetting.getBackColorButton());
		btnDelete.setBackground(ColorSetting.getBackColorButton());
		btnReport.setBackground(ColorSetting.getBackColorButton());
		btnNew.setBackground(ColorSetting.getBackColorButton());
		btnEdit.setBackground(ColorSetting.getBackColorButton());
		btnView.setBackground(ColorSetting.getBackColorButton());
		btnCancel.setBackground(ColorSetting.getBackColorButton());
		btnClose.setBackground(ColorSetting.getBackColorButton());


		lblProgramHeading.setText(ProjectSetting.getProjectTitle());
		lblProject.setText(ProjectSetting.getProject());

		setDefaultSetting();

	}

	void setDefaultSetting ()
	{
		PanelState.disabledComponents(pnlSave);
		PanelState.disabledComponents(pnlDelete);
		PanelState.disabledComponents(pnlUpdate);
		PanelState.disabledComponents(pnlNew);
		PanelState.disabledComponents(pnlView);
		PanelState.disabledComponents(pnlEdit);
		PanelState.disabledComponents(pnlCancel);
		PanelState.disabledComponents(pnlReport);
		PanelState.disabledComponents(pnlCombo1);
		PanelState.disabledComponents(pnlApply);
		PanelState.hideComponents(pnlUIReport);
		PanelState.hideComponents(pnlClose);

	}
	public JLabel getlblCombo11()
	{
		return lblCombo1;
	}

	public JLabel getlblProgramHeading()
	{
		return lblProgramHeading ;
	}
	public JPanel getpnlUIReport()
	{
		return pnlUIReport ;
	}
	public JPanel getUIPanel()
	{
		return pnlUI;
	}
	public JPanel getNewPanel()
	{
		return pnlNew;
	}
	public JButton getNewButton()
	{
		return btnNew;
	}
	public JPanel getSavePanel()
	{
		return pnlSave;
	}
	public JButton getSaveButton()
	{
		return btnSave;
	}
	public JPanel getReportPanel()
	{
		return pnlReport;
	}
	public JButton getReportButton()
	{
		return btnReport;
	}
	public JPanel getViewPanel()
	{
		return pnlView;
	}
	public JButton getViewButton()
	{
		return btnView;
	}
	public JPanel getUpdatePanel()
	{
		return pnlUpdate;
	}
	public JButton getUpdateButton()
	{
		return btnUpdate;
	}
	public JPanel getDeletePanel()
	{
		return pnlDelete;
	}
	public JButton getDeleteButton()
	{
		return btnDelete;
	}
	public JPanel getEditPanel()
	{
		return pnlEdit;
	}
	public JButton getEditButton()
	{
		return btnEdit;
	}
	public JPanel getCancelPanel()
	{
		return pnlCancel;
	}
	public JButton getCancelButton()
	{
		return btnCancel;
	}
	public JPanel getCombo1Panel()
	{
		return pnlCombo1 ;
	}
	public JComboBox getcmbCombo1()
	{
		return cmbCombo1;
	}
	public JPanel getApplyPanel()
	{
		return pnlApply;
	}
	public JButton getApplyButton()
	{
		return btnApply;
	}
	public JButton getCloseButton()
	{
		return btnClose;
	}
	public JPanel getClosePanel()
	{
		return pnlClose ;
	}

}
