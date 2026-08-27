package screensetting;
import javax.swing.*;
import java.awt.*;
import appsetting.*;
import myUtility.*;

public class ScreenDesignArea5  extends JPanel
{
	JPanel  pnlmain ;
	JPanel  pnltop ;
	JPanel  pnlbottom ;
	JPanel  pnlleft ;
	JPanel  pnlright ;
	JPanel  pnlhead ;
	JPanel  pnlcenter ;
	JPanel  pnlButton ;
	JPanel  pnlleftUp ;
	JPanel  pnlleftDown ;
	JPanel  pnlApply ;
	JPanel  pnlSave ;
	JPanel  pnlDelete ;
	JPanel  pnlUpdate ;
	JPanel  pnlNew ;
	JPanel  pnlView ;
	JPanel  pnlEdit ;
	JPanel  pnlCancel ;
	JPanel  pnlReport ;
	JPanel  pnlUI ;
	JPanel  pnlUIReport;

	JButton btnSave ;
	JButton btnDelete ;
	JButton btnUpdate ;
	JButton btnNew ;
	JButton btnView ;
	JButton btnEdit ;
	JButton btnCancel ;
	JButton btnReport ;
	JButton btnApply;

	JLabel lblProject ;
	JLabel lblProgramHeading ;
	JLabel lblDevelopedBy ;
	JLabel lblmember1 ;
	JLabel lblmember2 ;
	JLabel lblmember3;

	JLabel lblShip1 ;
	JLabel lblShip2 ;
	JLabel lblTruck1 ;
	JLabel lblTruck2 ;
	JLabel lblAllVehicles ;

	ImageIcon imgShip1 ;
	ImageIcon imgShip2 ;
	ImageIcon imgTruck1 ;
	ImageIcon imgTruck2 ;
	ImageIcon imgAllVehicles ;

	JPanel  pnlComboFirst;
	JLabel lblComboFirst ;
	JComboBox cmbComboFirst ;

	JPanel pnlComboSecond ;
	JLabel lblComboSecond ;
	JComboBox cmbComboSecond ;

	JPanel pnlComboThird ;
	JLabel lblComboThird ;
	JComboBox cmbComboThird ;

	JPanel pnlComboFourth ;
	JLabel lblComboFourth ;
	JComboBox cmbComboFourth ;

	JPanel pnlComboFifth ;
	JLabel lblComboFifth ;
	JComboBox cmbComboFifth ;


	public ScreenDesignArea5()
	{
		setVisible(true);
		setSize(1536,884);
		setLayout(null);

		pnlmain = new JPanel();
		pnlmain.setLayout(null);
		pnlmain.setSize(1536,884);
		pnlmain.setBackground(Color.RED);

		add(pnlmain);

		pnltop = new JPanel();
		pnltop.setBounds(0,0,1550,100);
		pnltop.setBackground(Color.BLACK);
		pnltop.setLayout(null);
		pnlmain.add(pnltop);

		lblProject = new JLabel("My Project Here...", SwingConstants.CENTER);
		lblProject.setFont(new Font("Arial",Font.BOLD,26));
		lblProject.setForeground(Color.WHITE);
		lblProject.setBounds(650,30,250,30);
		pnltop.add(lblProject);

		pnlbottom = new JPanel();
		pnlbottom.setBounds(0,700,1550,100);
		pnlbottom.setBackground(Color.BLACK);
		pnlbottom.setLayout(null);
		pnlmain.add(pnlbottom);

		lblDevelopedBy = new JLabel("Developed By,");
		lblDevelopedBy.setFont(new Font("Arial",Font.BOLD,20));
		lblDevelopedBy.setForeground(Color.WHITE);
		lblDevelopedBy.setBounds(700,10,300,25);
		pnlbottom.add(lblDevelopedBy);

		lblmember1 = new JLabel("1. Mayur Chaudhari");
		lblmember1.setFont(new Font("Arial",Font.BOLD,16));
		lblmember1.setForeground(Color.WHITE);
		lblmember1.setBounds(520,50,200,20);
		pnlbottom.add(lblmember1);

		lblmember2 = new JLabel("2. Aditya Patil");
		lblmember2.setFont(new Font("Arial",Font.BOLD,16));
		lblmember2.setForeground(Color.WHITE);
		lblmember2.setBounds(720,50,200,20);
		pnlbottom.add(lblmember2);

		lblmember3 = new JLabel("3. Tejas Kankhare");
		lblmember3.setFont(new Font("Arial",Font.BOLD,16));
		lblmember3.setForeground(Color.WHITE);
		lblmember3.setBounds(920,50,200,20);
		pnlbottom.add(lblmember3);

		pnlleft = new JPanel();
		pnlleft.setBounds(0,105,290,590);
		pnlleft.setBackground(Color.GRAY);
		pnlleft.setLayout(null);
		pnlmain.add(pnlleft);

		pnlleftUp = new JPanel();
		pnlleftUp.setBounds(5,5,280,500);
		pnlleftUp.setBackground(Color.WHITE);
		pnlleftUp.setLayout(null);
		pnlleft.add(pnlleftUp);

		pnlComboFirst = new JPanel();
		pnlComboFirst.setBounds(5,5,270,80);
		pnlComboFirst.setBackground(Color.LIGHT_GRAY);
		pnlComboFirst.setLayout(null);
		pnlleftUp.add(pnlComboFirst);

		pnlComboSecond= new JPanel();
		pnlComboSecond.setBounds(5,90,270,80);
		pnlComboSecond.setBackground(Color.LIGHT_GRAY);
		pnlComboSecond.setLayout(null);
		pnlleftUp.add(pnlComboSecond);

		pnlComboThird= new JPanel();
		pnlComboThird.setBounds(5,175,270,80);
		pnlComboThird.setBackground(Color.LIGHT_GRAY);
		pnlComboThird.setLayout(null);
		pnlleftUp.add(pnlComboThird);

		pnlComboFourth= new JPanel();
		pnlComboFourth.setBounds(5,260,270,80);
		pnlComboFourth.setBackground(Color.LIGHT_GRAY);
		pnlComboFourth.setLayout(null);
		pnlleftUp.add(pnlComboFourth);

		pnlComboFifth= new JPanel();
		pnlComboFifth.setBounds(5,345,270,80);
		pnlComboFifth.setBackground(Color.LIGHT_GRAY);
		pnlComboFifth.setLayout(null);
		pnlleftUp.add(pnlComboFifth);

		lblComboFirst = new JLabel("Label is not set");
		lblComboFirst.setBounds(5,5,260,30);
		pnlComboFirst.add(lblComboFirst);

		lblComboSecond = new JLabel("Label is not set");
		lblComboSecond.setBounds(5,5,260,30);
		pnlComboSecond.add(lblComboSecond);

		lblComboThird = new JLabel("Label is not set");
		lblComboThird.setBounds(5,5,260,30);
		pnlComboThird.add(lblComboThird);

		lblComboFourth = new JLabel("Label is not set");
		lblComboFourth.setBounds(5,5,260,30);
		pnlComboFourth.add(lblComboFourth);

		lblComboFifth = new JLabel("Label is not set");
		lblComboFifth.setBounds(5,5,260,30);
		pnlComboFifth.add(lblComboFifth);


		String strcombo[] = {"Select","Maharastra","Rajasthan","Gujrat","MadhyaPradesh"};
		cmbComboFirst = new JComboBox(strcombo);
		cmbComboFirst.setBounds(5,40,260,30);
		pnlComboFirst.add(cmbComboFirst);

		cmbComboSecond = new JComboBox(strcombo);
		cmbComboSecond.setBounds(5,40,260,30);
		pnlComboSecond.add(cmbComboSecond);

		cmbComboThird = new JComboBox(strcombo);
		cmbComboThird.setBounds(5,40,260,30);
		pnlComboThird.add(cmbComboThird);

		cmbComboFourth = new JComboBox(strcombo);
		cmbComboFourth.setBounds(5,40,260,30);
		pnlComboFourth.add(cmbComboFourth);

		cmbComboFifth = new JComboBox(strcombo);
		cmbComboFifth.setBounds(5,40,260,30);
		pnlComboFifth.add(cmbComboFifth);

		pnlApply = new JPanel();
		pnlApply.setBounds(5,430,270,50);
		pnlApply.setBackground(Color.LIGHT_GRAY);
		pnlApply.setLayout(null);
		pnlleftUp.add(pnlApply);

		btnApply = new JButton("Apply");
		btnApply.setBounds(5,5,260,40);
		pnlApply.add(btnApply);

		imgShip1 = new ImageIcon("C:\\Users\\mdc56\\OneDrive\\Desktop\\java programs\\database programs\\FinalProject\\screensetting\\ship1.jpg");
		lblShip1 = new JLabel(imgShip1);
		lblShip1.setBounds(10,10,260,180);

		imgShip2 = new ImageIcon("C:\\Users\\mdc56\\OneDrive\\Desktop\\java programs\\database programs\\FinalProject\\screensetting\\ship2.jpeg");
		lblShip2 = new JLabel(imgShip2);
		lblShip2.setBounds(10,210,260,200);

		pnlleftDown = new JPanel();
		pnlleftDown.setBounds(5,155,280,430);
		pnlleftDown.setBackground(Color.BLACK);
		pnlleftDown.setLayout(null);
	//	pnlleftDown.add(lblShip1);
	//	pnlleftDown.add(lblShip2);
		pnlleft.add(pnlleftDown);


		imgTruck1 = new ImageIcon("C:\\Users\\mdc56\\OneDrive\\Desktop\\java programs\\database programs\\FinalProject\\screensetting\\truck1.jpeg");
		lblTruck1 = new JLabel(imgTruck1);
		lblTruck1.setBounds(10,10,270,180);

		imgTruck2 = new ImageIcon("C:\\Users\\mdc56\\OneDrive\\Desktop\\java programs\\database programs\\FinalProject\\screensetting\\truck2.jpg");
		lblTruck2 = new JLabel(imgTruck2);
		lblTruck2.setBounds(10,200,270,180);

		imgAllVehicles = new ImageIcon("C:\\Users\\mdc56\\OneDrive\\Desktop\\java programs\\database programs\\FinalProject\\screensetting\\allVehicles.jpg");
		lblAllVehicles = new JLabel(imgAllVehicles);
		lblAllVehicles.setBounds(10,390,270,180);

		pnlright = new JPanel();
		pnlright.setBounds(1240,105,290,590);
		pnlright.setBackground(Color.BLACK);
		pnlright.setLayout(null);
		pnlright.add(lblTruck1);
		pnlright.add(lblTruck2);
		pnlright.add(lblAllVehicles);
		pnlmain.add(pnlright);

		pnlcenter = new JPanel();
		pnlcenter.setLayout(null);
		pnlcenter.setBounds(295,160,940,480);
		pnlcenter.setBackground(Color.YELLOW);
		pnlmain.add(pnlcenter);

		pnlUI = new JPanel();
		pnlUI.setBounds(5,5,930,470);
		pnlUI.setBackground(new Color(48,213,200));
		pnlcenter.add(pnlUI);

		pnlUIReport = new JPanel();
		pnlUIReport.setBounds(5,5,930,470);
		pnlUIReport.setBackground(Color.yellow);
		pnlcenter.add(pnlUIReport);

		pnlhead = new JPanel();
		pnlhead.setBounds(295,105,940,50);
		pnlhead.setBackground(Color.GREEN);
		pnlhead.setLayout(null);
		pnlmain.add(pnlhead);

		lblProgramHeading = new JLabel( );
		lblProgramHeading.setFont(new Font("Arial",Font.BOLD,22));
		lblProgramHeading.setBounds(250,10,800,30);
		pnlhead.add(lblProgramHeading);

		pnlButton = new JPanel();
		pnlButton.setBounds(295,645,940,50);
		pnlButton.setBackground(Color.GREEN);
		pnlButton.setLayout(null);
		pnlmain.add(pnlButton);

		pnlSave = new JPanel();
		pnlSave.setBackground(Color.BLACK);
		pnlSave.setBounds(118,5,111,40);//118,5,111,40
		pnlSave.setLayout(null);
		pnlButton.add(pnlSave);

		pnlDelete = new JPanel();
		pnlDelete.setBackground(Color.BLACK);
		pnlDelete.setBounds(588,5,111,40);//588,5,111,40
		pnlDelete.setLayout(null);
		pnlButton.add(pnlDelete);

		pnlUpdate = new JPanel();
		pnlUpdate.setBackground(Color.BLACK);
		pnlUpdate.setBounds(470,5,111,40);//470,5,111,40
		pnlUpdate.setLayout(null);
		pnlButton.add(pnlUpdate);

		pnlNew = new JPanel();
		pnlNew.setBackground(Color.BLACK);
		pnlNew.setBounds(2,5,111,40);//2,5,111,40
		pnlNew.setLayout(null);
		pnlButton.add(pnlNew);

		pnlView = new JPanel();
		pnlView.setBackground(Color.BLACK);
		pnlView.setBounds(234,5,111,40);//234,5,111,40
		pnlView.setLayout(null);
		pnlButton.add(pnlView);

		pnlEdit = new JPanel();
		pnlEdit.setBackground(Color.BLACK);
		pnlEdit.setBounds(350,5,111,40);//350,5,111,40
		pnlEdit.setLayout(null);
		pnlButton.add(pnlEdit);

		pnlCancel = new JPanel();
		pnlCancel.setBackground(Color.BLACK);
		pnlCancel.setBounds(706,5,111,40);
		pnlCancel.setLayout(null);
		pnlButton.add(pnlCancel);

		pnlReport = new JPanel();
		pnlReport.setBackground(Color.BLACK);
		pnlReport.setBounds(824,5,111,40);
		pnlReport.setLayout(null);
		pnlButton.add(pnlReport);

		btnSave = new JButton("Save");
		btnSave.setBounds(5,5,101,30);
		pnlSave.add(btnSave);

		btnDelete = new JButton("Delete");
		btnDelete.setBounds(5,5,101,30);
		pnlDelete.add(btnDelete);

		btnUpdate = new JButton("Update");
		btnUpdate.setBounds(5,5,101,30);
		pnlUpdate.add(btnUpdate);

		btnNew = new JButton("New");
		btnNew.setBounds(5,5,101,30);
		pnlNew.add(btnNew);

		btnView = new JButton("View");
		btnView.setBounds(5,5,101,30);
		pnlView.add(btnView);

		btnEdit = new JButton("Edit");
		btnEdit.setBounds(5,5,101,30);
		pnlEdit.add(btnEdit);

		btnCancel = new JButton("Cancel");
		btnCancel.setBounds(5,5,101,30);
		pnlCancel.add(btnCancel);

		btnReport = new JButton("Report");
		btnReport.setBounds(5,5,101,30);
		pnlReport.add(btnReport);

		pnltop.setBackground(ColorSetting.getBackColorTopPnl());
		pnlbottom.setBackground(ColorSetting.getBackColorBottomPnl());
		pnlcenter.setBackground(ColorSetting.getBackColorCenterPnl());
		pnlhead.setBackground(ColorSetting.getBackColorHeadPnl());
		pnlButton.setBackground(ColorSetting.getBackColorButtonPnl());
		pnlmain.setBackground(ColorSetting.getBackColorMainPnl());
		pnlleft.setBackground(ColorSetting.getBackColorLeftPnl());
		pnlright.setBackground(ColorSetting.getBackColorRightPnl());
		pnlleftUp.setBackground(ColorSetting.getBackColorLeftUpPnl());
		pnlleftDown.setBackground(ColorSetting.getBackColorLeftDownPnl());
		pnlComboFirst.setBackground(ColorSetting.getBackColorCombo1Pnl());
		pnlComboSecond.setBackground(ColorSetting.getBackColorCombo1Pnl());
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

		pnlApply.setBackground(ColorSetting.getBackColorButttonPnl());
		pnlSave.setBackground(ColorSetting.getBackColorButttonPnl());
		pnlUpdate.setBackground(ColorSetting.getBackColorButttonPnl());
		pnlDelete.setBackground(ColorSetting.getBackColorButttonPnl());
		pnlReport.setBackground(ColorSetting.getBackColorButttonPnl());
		pnlNew.setBackground(ColorSetting.getBackColorButttonPnl());
		pnlEdit.setBackground(ColorSetting.getBackColorButttonPnl());
		pnlView.setBackground(ColorSetting.getBackColorButttonPnl());
		pnlCancel.setBackground(ColorSetting.getBackColorButttonPnl());

		lblProgramHeading.setText(ProjectSetting.getProjectTitle());
		lblProject.setText(ProjectSetting.getProject());

		lblmember1.setText(ProjectSetting.getDev1());
		lblmember2.setText(ProjectSetting.getDev2());
		lblmember3.setText(ProjectSetting.getDev3());

		setdefaultSetting();

	}

	public JPanel getSavePanel()
	{
		return pnlSave ;
	}
	public JPanel getDeletePanel()
	{
		return pnlDelete ;
	}
	public JPanel getUpdatePanel()
	{
		return pnlUpdate ;
	}
	public JPanel getNewPanel()
	{
		return pnlNew ;
	}
	public JPanel getViewPanel()
	{
		return pnlView ;
	}
	public JPanel getEditPanel()
	{
		return pnlEdit ;
	}
	public JPanel getCancelPanel()
	{
		return pnlCancel ;
	}
	public JPanel getReportPanel()
	{
		return pnlReport ;
	}

	public JPanel getApplyPanel()
	{
		return pnlApply ;
	}
	public JButton getNewButton()
	{
		return btnNew ;
	}
	public JButton getSaveButton()
	{
		return btnSave ;
	}
	public JButton getDeleteButton()
	{
		return btnDelete ;
	}
	public JButton getUpdateButton()
	{
		return btnUpdate ;
	}
	public JButton getViewButton()
	{
		return btnView ;
	}
	public JButton getEditButton()
	{
		return btnEdit ;
	}
	public JButton getCancelButton()
	{
		return btnCancel ;
	}
	public JButton getReportButton()
	{
		return btnReport ;
	}
	public JButton getApplyButton()
	{
		return btnApply;
	}

	public JPanel getpnlUI()
	{
		return pnlUI ;
	}
	public JPanel getpnlUIReport()
	{
		return pnlUIReport;
	}

	public JPanel getComboFirstPanel()
	{
		return pnlComboFirst ;
	}
	public JPanel getComboSecondPanel()
	{
		return pnlComboSecond ;
	}
	public JPanel getComboThirdPanel()
	{
		return pnlComboThird ;
	}
	public JPanel getComboFourthPanel()
	{
		return pnlComboFourth ;
	}
	public JPanel getComboFifthPanel()
	{
		return pnlComboFifth ;
	}
	public JComboBox getcmbComboFirst()
	{
		return cmbComboFirst ;
	}
	public JComboBox getcmbComboSecond()
	{
		return cmbComboSecond ;
	}
	public JComboBox getcmbComboThird()
	{
		return cmbComboThird ;
	}
	public JComboBox getcmbComboFourth()
	{
		return cmbComboFourth ;
	}
	public JComboBox getcmbComboFifth()
	{
		return cmbComboFifth ;
	}

	public JLabel getComboFirst()
	{
		return lblComboFirst ;
	}
	public JLabel getComboSecond()
	{
		return lblComboSecond ;
	}
	public JLabel getComboThird()
	{
		return lblComboThird ;
	}
	public JLabel getComboFourth()
	{
		return lblComboFourth ;
	}
	public JLabel getComboFifth()
	{
		return lblComboFifth ;
	}

	void setdefaultSetting()
	{
		PanelState.disabledComponents(pnlSave);
		PanelState.disabledComponents(pnlDelete);
		PanelState.disabledComponents(pnlUpdate);
		PanelState.disabledComponents(pnlNew);
		PanelState.disabledComponents(pnlView);
		PanelState.disabledComponents(pnlEdit);
		PanelState.disabledComponents(pnlCancel);
		PanelState.disabledComponents(pnlReport);
		PanelState.disabledComponents(pnlComboFirst);
		PanelState.disabledComponents(pnlComboSecond);
		PanelState.disabledComponents(pnlApply);
		PanelState.disabledComponents(pnlUI);
		PanelState.hideComponents(pnlUIReport);

	}

	public JLabel getlblProgramHeading()
	{
		return lblProgramHeading;
	}

}