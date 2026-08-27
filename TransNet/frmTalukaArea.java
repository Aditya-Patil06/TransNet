import appsetting.*;
import myUtility.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import screensetting.*;
import ReportUtility.*;
import javax.swing.border.EmptyBorder; //New for Report

class frmTalukaArea extends JFrame implements ActionListener
{
	ScreenDesign5 myUI;

	JPanel pnlNew;
	JButton btnNew;

	JPanel pnlView;
	JButton btnView;

	JPanel pnlSave ;
	JButton btnSave ;

	JPanel pnlEdit;
	JButton btnEdit;

	JPanel pnlUpdate;
	JButton btnUpdate;

	JPanel pnlDelete;
	JButton btnDelete;

	JPanel pnlCancel;
	JButton btnCancel;

	JPanel  pnlClose			;
	JButton btnClose 			;

	JPanel pnlReport;
	JButton btnReport;

	JPanel pnlApply;
	JButton btnApply;

	JPanel pnlUI ;

	JPanel pnlUIReport ;

	JPanel pnlCountryUpdate;
	JPanel pnlStateUpdate;
	JPanel pnlDistrictUpdate ;
	JPanel pnlTalukaUpdate ;
	JPanel pnlAreaUpdate;

	JLabel lblProgramHeading;
	JLabel lblProject;

	JLabel lblAreaID ;
	JLabel lblAreaName ;

	JLabel lblTaluka ;
	JLabel lblDistrict ;
	JLabel lblState ;
	JLabel lblCountry ;

	JLabel lblAreaUpdate;
	JLabel lblTalukaUpdate;
	JLabel lblStateUpdate ;
	JLabel lblCountryUpdate ;
	JLabel lblDistrictUpdate ;

	JTextField txtAreaID ;
	JTextField txtAreaName ;

	JComboBox cmbStateUpdate ;
	JComboBox cmbCountryUpdate;
	JComboBox cmbDistrictUpdate ;
	JComboBox cmbTalukaUpdate ;
	JComboBox cmbAreaUpdate ;
	JComboBox cmbState ;
	JComboBox cmbCountry ;
	JComboBox cmbDistrict ;
	JComboBox cmbTaluka ;

	ButtonState bst ;
	clsButtonManagement5 cbm ;

	JButton btnNewDoc ;
	JButton btnRefreshDoc ;

	int Rcols = 0 				;

	ReportTool tool				;

	int vTaluka=0;
    frmTalukaArea()
    {
		setTitle("New Project");
		setSize(1920,1080);
		setLayout(null);
		setLocation(0,0);

		myUI = new ScreenDesign5();
		add(myUI);
		setExtendedState(getExtendedState()|JFrame.MAXIMIZED_BOTH);

		pnlUI = myUI.getpnlUI();
		pnlUI.setLayout(null);
		UISetting.setArea(pnlUI,400,260);


		pnlNew = myUI.getNewPanel();
		btnNew = myUI.getNewButton();

		pnlView = myUI.getViewPanel();
		btnView = myUI.getViewButton();

		pnlSave = myUI.getSavePanel();
		btnSave = myUI.getSaveButton();

		pnlEdit = myUI.getEditPanel();
		btnEdit = myUI.getEditButton();

		pnlUpdate = myUI.getUpdatePanel();
		btnUpdate = myUI.getUpdateButton();

		pnlDelete = myUI.getDeletePanel();
		btnDelete = myUI.getDeleteButton();

		pnlCancel = myUI.getCancelPanel();
		btnCancel = myUI.getCancelButton();

		pnlReport = myUI.getReportPanel();
		btnReport = myUI.getReportButton();
		btnReport.addActionListener(this);

		pnlClose = myUI.getClosePanel();
		btnClose= myUI.getCloseButton();
		btnClose.addActionListener(this);


		pnlApply = myUI.getApplyPanel();
		btnApply = myUI.getApplyButton();

		pnlCountryUpdate = myUI.getCombo1Panel();
		pnlStateUpdate = myUI.getCombo2Panel();
		pnlDistrictUpdate = myUI.getCombo3Panel();
		pnlTalukaUpdate = myUI.getCombo4Panel();
		pnlAreaUpdate = myUI.getCombo5Panel();

		lblCountryUpdate = myUI.getlblCombo1();
		lblCountryUpdate.setText("Country List ...");

		lblStateUpdate = myUI.getlblCombo2();
		lblStateUpdate.setText("State List ...");

		lblDistrictUpdate = myUI.getlblCombo3();
		lblDistrictUpdate.setText("District List...");

		lblTalukaUpdate  = myUI.getlblCombo4();
		lblTalukaUpdate.setText("Taluka List...");

		lblAreaUpdate = myUI.getlblCombo5();
		lblAreaUpdate.setText("Area List...");

		cmbCountryUpdate= myUI.getcmbCombo1();
		cmbCountryUpdate.addActionListener(this);

		cmbStateUpdate= myUI.getcmbCombo2();
		cmbStateUpdate.addActionListener(this);
		cmbStateUpdate.addItem("Select State...");

		cmbDistrictUpdate = myUI.getcmbCombo3();
		cmbDistrictUpdate.addActionListener(this);
		cmbDistrictUpdate.addItem("Select District...");

		cmbTalukaUpdate = myUI.getcmbCombo4();
		cmbTalukaUpdate.addActionListener(this);
		cmbTalukaUpdate.addItem("Select Taluka...");

		cmbAreaUpdate = myUI.getcmbCombo5();
		cmbAreaUpdate.addActionListener(this);
		cmbAreaUpdate.addItem("Select Area...");

		btnNew.addActionListener(this);
		btnSave.addActionListener(this);
		btnView.addActionListener(this);
		btnEdit.addActionListener(this);
		btnUpdate.addActionListener(this);
		btnDelete.addActionListener(this);
		btnCancel.addActionListener(this);
		btnReport.addActionListener(this);
		btnApply.addActionListener(this);

		lblProgramHeading = myUI.getlblProgramHeading();
		lblProgramHeading.setText("Taluka Area Information...");

		new BlinkLabel(lblProgramHeading,1000);

		pnlUIReport = myUI.getpnlUIReport();
		pnlUIReport.setLayout(new BorderLayout());

		int padding = 10;
		pnlUIReport.setBorder(new EmptyBorder(padding, padding, padding, padding));

		UISetting.setArea(pnlUIReport, 800, 400);
		tool = new ReportTool(600, 300);
		pnlUIReport.add(tool, BorderLayout.CENTER);

		lblAreaID = new JLabel("Area ID : ");
		lblAreaID.setBounds(15,20,150,30);
		lblAreaID.setFont(new Font("Aptos",Font.BOLD,18));
		lblAreaID.setBackground(Color.black);

		lblAreaName = new JLabel("Area Name : ");
		lblAreaName.setBounds(15,60,150,30);
		lblAreaName.setFont(new Font("Aptos",Font.BOLD,18));

		txtAreaID = new JTextField();
		txtAreaID.setBounds(170,20,50,30);
		txtAreaID.setFont(new Font("Aptos",Font.BOLD,18));

		txtAreaName = new JTextField();
		txtAreaName.setBounds(170,60,160,30);
		txtAreaName.setFont(new Font("Aptos",Font.BOLD,18));

		btnNewDoc = new JButton(new ImageIcon("D:\\Aditya_Project_TransNet\\imgNewDoc.png"));
		btnNewDoc.addActionListener(this);
		btnNewDoc.setBounds(350,220,30,30);
		btnNewDoc.setVisible(true);

		btnRefreshDoc = new JButton(new ImageIcon("D:\\Aditya_Project_TransNet\\imgRefreshDoc.png"));
		btnRefreshDoc.addActionListener(this);
		btnRefreshDoc.setBounds(350,220,30,30);
		btnRefreshDoc.setVisible(false);


		pnlUI.add(lblAreaID);
		pnlUI.add(lblAreaName);
		pnlUI.add(txtAreaID);
		pnlUI.add(txtAreaName);
		pnlUI.add(btnNewDoc);
		pnlUI.add(btnRefreshDoc);

		lblState = new JLabel("State Name : ");
		lblState.setBounds(15,140,150,30);
		lblState.setFont(new Font("Aptos",Font.BOLD,18));
		pnlUI.add(lblState);

		cmbState = new JComboBox();
		cmbState.addItem("Select State...");
		cmbState.addActionListener(this);
		cmbState.setBounds(170,140,160,30);
		pnlUI.add(cmbState);

		lblCountry = new JLabel("State Country : ");
		lblCountry.setBounds(15,100,150,30);
		lblCountry.setFont(new Font("Aptos",Font.BOLD,18));
		pnlUI.add(lblCountry);

		lblDistrict = new JLabel("State District : ");
		lblDistrict.setBounds(15,180,150,30);
		lblDistrict.setFont(new Font("Aptos",Font.BOLD,18));
		pnlUI.add(lblDistrict);

		lblTaluka = new JLabel("State Taluka : ");
		lblTaluka.setBounds(15,220,150,30);
		lblTaluka.setFont(new Font("Aptos",Font.BOLD,18));
		pnlUI.add(lblTaluka);


		cmbCountry = new JComboBox();
		cmbCountry.addItem("Select Country...");
		cmbCountry.addActionListener(this);
		cmbCountry.setBounds(170,100,160,30);
		pnlUI.add(cmbCountry);

		cmbDistrict = new JComboBox();
		cmbDistrict.addItem("Select District...");
		cmbDistrict.addActionListener(this);
		cmbDistrict.setBounds(170,180,160,30);
		pnlUI.add(cmbDistrict);

		cmbTaluka = new JComboBox();
		cmbTaluka.addItem("Select Taluka...");
		cmbTaluka.addActionListener(this);
		cmbTaluka.setBounds(170,220,160,30);
		pnlUI.add(cmbTaluka);


		bst = new ButtonState();
		cbm = new clsButtonManagement5();
		automateButtons();
		bst.setButtonState(ButtonState.InitialState);
		cbm.showButtonsOnUI(bst);

		addCountryRecords(cmbCountry);

		createReport();

		setVisible(true);
	}

	public void setDefaultOperation()
	{

		PanelState.enabledComponents(pnlNew);
		PanelState.enabledComponents(pnlView);
		PanelState.enabledComponents(pnlReport);
		PanelState.disabledComponents(pnlUI);
	}

	public void initUI()
	{
		txtAreaID.setText("0");
		txtAreaName.setText("");
		cmbTaluka.setSelectedIndex(0);
		cmbDistrict.setSelectedIndex(0);
		cmbState.setSelectedIndex(0);
		cmbCountry.setSelectedIndex(0);
	}

	public clsTalukaArea readUI()
	{
		clsTalukaArea temp = new clsTalukaArea();
		temp.setAreaID(Integer.parseInt(txtAreaID.getText()));
		temp.setAreaName(txtAreaName.getText());
		temp.setTalukaID(vTaluka);
		return temp ;

	}

	public void writeUI(clsTalukaArea temp)
	{
		txtAreaID.setText(String.valueOf(temp.getAreaID()));
		txtAreaName.setText(temp.getAreaName());

		clsLocationManagementTaluka6 temp1 = clsLocationManagementTaluka6.getLocationInfo(temp.getAreaID());
		cmbCountry.setSelectedItem(temp1.getCountryName());
		vTaluka =temp1.getTalukaID();
		cmbState.setSelectedItem(temp1.getStateName());
		cmbDistrict.setSelectedItem(temp1.getDistrictName());
		cmbTaluka.setSelectedItem(temp1.getTalukaName());



	}

	void createReport()
	{
		setColumnsHeading();
		setColumnsAlignment();
		setColumnsWidth();
	}

	void setColumnsHeading()
	{

		Rcols=0;
		Rcols+=tool.addNewColumn("TalukaAreaID");
		Rcols+=tool.addNewColumn("TalukaAreaName");
		Rcols+=tool.addNewColumn("TalukaID");

	}

	void setColumnsAlignment()
	{

		tool.setColumnAlignment(0,ReportTool.ALIGN_CENTER);
		tool.setColumnAlignment(1,ReportTool.ALIGN_CENTER);
		tool.setColumnAlignment(2,ReportTool.ALIGN_CENTER);

	}

	void setColumnsWidth()
	{

		tool.setColumnWidth("TalukaAreaID",80);
		tool.setColumnWidth("TalukaAreaName",200);
		tool.setColumnWidth("TalukaID",80);

	}

	void setColumnsData()
	{

		tool.removeAllRows();

		clsTalukaArea Data[]=clsTalukaArea.getAllTalukaAreaInformation();

		for(int i=0;i<Data.length;i++)
		{
			Object Objectdata[]=new Object[Rcols];

			Objectdata[0]=i+1;
			Objectdata[1]=Data[i].getAreaName();
			Objectdata[2]=Data[i].getTalukaID();

			tool.addNewRow(Objectdata);
		}

	}

	void addTalukaRecords(JComboBox temp)
	{
		temp.removeActionListener(this);
		clsTaluka.addTalukaRecords(temp);
		temp.addActionListener(this);
	}
	void addDistrictRecords(JComboBox temp)
	{
		temp.removeActionListener(this);
		clsDistrict.addDistrictRecords(temp);
		temp.addActionListener(this);
	}
	void addStateRecords(JComboBox temp)
	{
		temp.removeActionListener(this);
		clsState.addStateRecords(temp);
		temp.addActionListener(this);
	}
	void addCountryRecords(JComboBox temp)
	{
		temp.removeActionListener(this);
		clsCountry.addCountryRecords(temp);
		temp.addActionListener(this);
	}

	void addStateRecords(JComboBox temp,int mCountryID)
	{
		clsState.addStateRecords(temp,mCountryID);
	}

	void addDistrictRecords(JComboBox temp,int mStateID)
	{
		clsDistrict.addDistrictRecords(temp,mStateID);
	}
	void addTalukaRecords(JComboBox temp,int mDistrictID)
	{
		clsTaluka.addTalukaRecords(temp,mDistrictID);
	}
	void addAreaRecords(JComboBox temp,int mTalukaID)
	{
		clsTalukaArea.addAreaRecords(temp,mTalukaID);
	}

	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource() == btnNew)
		{
			bst.setButtonState(bst.NewState);
			cbm.showButtonsOnUI(bst) ;
			initUI();

		}
		else if(ae.getSource() == btnView)
		{

			bst.setButtonState(bst.ViewState);
			cbm.showButtonsOnUI(bst);

			addCountryRecords(cmbCountryUpdate);

		}
		else if(ae.getSource() == btnSave)
		{

			bst.setButtonState(bst.SaveState);
			cbm.showButtonsOnUI(bst);

			clsTalukaArea temp = readUI();
			clsTalukaArea.addNewArea(temp);
			initUI();
		}
		else if(ae.getSource() == btnEdit)
		{
			bst.setButtonState(bst.EditState);
			cbm.showButtonsOnUI(bst);
		}
		else if(ae.getSource() == btnUpdate)
		{
			bst.setButtonState(bst.UpdateState);
			cbm.showButtonsOnUI(bst);

			clsTalukaArea temp = readUI();
			clsTalukaArea.updateArea(temp);
			initUI();
		}
		else if(ae.getSource() == btnDelete)
		{
			bst.setButtonState(bst.DeleteState);
			cbm.showButtonsOnUI(bst);

			clsTalukaArea temp = readUI();
			clsTalukaArea.deleteArea(temp);
			initUI();
			//JOptionPane.showMessageDialog(null,"Deleted successfully...");

		}
		else if(ae.getSource() == btnCancel)
		{
			bst.setButtonUniqueState(bst.CancelState);
			cbm.showButtonsOnUI(bst);

			initUI();

		}
		else if(ae.getSource()==btnReport)
		{

			bst.setButtonCommonState(ButtonState.ReportState);
			cbm.showButtonsOnUI(bst);
			setColumnsData();

		}

		else if(ae.getSource()==btnClose)
		{

			bst.setButtonCommonState(ButtonState.CloseReportState);
			cbm.showButtonsOnUI(bst);

		}

		else if(ae.getSource() == btnApply)
		{

			bst.setButtonState(bst.ApplyState);
			cbm.showButtonsOnUI(bst);

			if(cmbStateUpdate.getSelectedIndex() == 0)
			{
				//JOptionPane.showMessageDialog(null,"Please Select State Properly...");
			}
			else
			{
				String mAreaName = (String)cmbAreaUpdate.getSelectedItem();
				int mAreaID = clsTalukaArea.getIDFromName(mAreaName);
				clsTalukaArea temp = clsTalukaArea.getAreaInformation(mAreaID);
				writeUI(temp);
			}
		}

		else if(ae.getSource() == cmbCountry)
		{

			if(cmbCountry.getSelectedIndex() == 0)
			{
				//JOptionPane.showMessageDialog(null,"Please Select State Properly...");
			}
			else
			{
				String mCountryName = (String)cmbCountry.getSelectedItem();
				int mCountryID = clsCountry.getIDFromName(mCountryName);
				addStateRecords(cmbState,mCountryID);

			}
		}
		else if(ae.getSource() == cmbState)
		{
			if(cmbState.getSelectedIndex() == 0)
			{
				//JOptionPane.showMessageDialog(null,"Please Select State Properly...");
			}
			else
			{
				String mStateName = (String)cmbState.getSelectedItem();
				int mStateID = clsState.getIDFromName(mStateName);
				addDistrictRecords(cmbDistrict,mStateID);
			}
		}
		else if(ae.getSource() == cmbDistrict)
		{
			if(cmbState.getSelectedIndex() == 0)
			{
				//JOptionPane.showMessageDialog(null,"Please Select State Properly...");
			}
			else
			{
				String mDistrictName = (String)cmbDistrict.getSelectedItem();
				int mDistrictID = clsDistrict.getIDFromName(mDistrictName);
				addTalukaRecords(cmbTaluka,mDistrictID);

			}
		}
		else if(ae.getSource() == cmbTaluka)
		{
			if(cmbState.getSelectedIndex() == 0)
			{
				//JOptionPane.showMessageDialog(null,"Please Select State Properly...");
			}
			else
			{
				String mTalukaName = (String)cmbTaluka.getSelectedItem();
				vTaluka = clsTaluka.getIDFromName(mTalukaName);

			}
		}
		else if(ae.getSource() == cmbCountryUpdate)
		{
			if(cmbCountryUpdate.getSelectedIndex() == 0)
			{
				//JOptionPane.showMessageDialog(null,"Please Select Country Properly...");
			}
			else
			{
				String mCountryName = (String)cmbCountryUpdate.getSelectedItem();
				int mCountryID = clsCountry.getIDFromName(mCountryName);
				addStateRecords(cmbStateUpdate,mCountryID);
			}
		}
		else if(ae.getSource() == cmbStateUpdate)
		{
			if(cmbStateUpdate.getSelectedIndex() == 0)
			{
				//JOptionPane.showMessageDialog(null,"Please Select State Properly...");
			}
			else
			{
				String mStateName = (String)cmbStateUpdate.getSelectedItem();
				int mStateID = clsState.getIDFromName(mStateName);
				addDistrictRecords(cmbDistrictUpdate,mStateID);
			}
		}
		else if(ae.getSource() == cmbDistrictUpdate)
		{
			if(cmbStateUpdate.getSelectedIndex() == 0)
			{
				//JOptionPane.showMessageDialog(null,"Please Select State Properly...");
			}
			else
			{
				String mDistrictName = (String)cmbDistrictUpdate.getSelectedItem();
				int mDistrictID = clsDistrict.getIDFromName(mDistrictName);
				addTalukaRecords(cmbTalukaUpdate, mDistrictID);
			}
		}
		else if(ae.getSource() == cmbTalukaUpdate)
		{
			if(cmbStateUpdate.getSelectedIndex() == 0)
			{
				//JOptionPane.showMessageDialog(null,"Please Select State Properly...");
			}
			else
			{
				String mTalukaName = (String)cmbTalukaUpdate.getSelectedItem();
				int mTalukaID = clsTaluka.getIDFromName(mTalukaName);
				addAreaRecords(cmbAreaUpdate, mTalukaID);
			}
		}

		else if(ae.getSource()==btnNewDoc)
		{
			btnNewDoc.setVisible(false);
			btnRefreshDoc.setVisible(true);
			frmTaluka A = new frmTaluka();
		}
		else if(ae.getSource()==btnRefreshDoc)
		{
			btnNewDoc.setVisible(true);
			btnRefreshDoc.setVisible(false);
			addTalukaRecords(cmbTaluka);
		}


	}

	void automateButtons()
	{
		cbm.manageDataPanel(pnlUI);
		cbm.manageDataReportPanel(pnlUIReport);
		cbm.manageNewPanel(pnlNew);
		cbm.manageSavePanel(pnlSave);
		cbm.manageViewPanel(pnlView);
		cbm.manageEditPanel(pnlEdit);
		cbm.manageUpdatePanel(pnlUpdate);
		cbm.manageDeletePanel(pnlDelete);
		cbm.manageCancelPanel(pnlCancel);
		cbm.manageReportPanel(pnlReport);
		cbm.manageClosePanel(pnlClose);
		cbm.manageApplyPanel(pnlApply);

		cbm.manageCombo1Panel(pnlCountryUpdate);
		cbm.manageCombo1(cmbCountryUpdate);

		cbm.manageCombo2Panel(pnlStateUpdate);
		cbm.manageCombo2(cmbStateUpdate);

		cbm.manageCombo3Panel(pnlDistrictUpdate);
		cbm.manageCombo3(cmbDistrictUpdate);

		cbm.manageCombo4Panel(pnlTalukaUpdate);
		cbm.manageCombo4(cmbTalukaUpdate);

		cbm.manageCombo5Panel(pnlAreaUpdate);
		cbm.manageCombo5(cmbAreaUpdate);

	}

	public static void main(String args[])
	{
		new frmTalukaArea();
	}
}