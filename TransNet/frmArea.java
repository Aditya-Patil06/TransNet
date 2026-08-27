import appsetting.*;
import myUtility.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import screensetting.*;
import ReportUtility.*;
import javax.swing.border.EmptyBorder;

class frmArea extends JFrame implements ActionListener
{
	ScreenDesign6 myUI				;

	JPanel pnlNew					;
	JButton btnNew					;

	JPanel pnlView					;
	JButton btnView					;

	JPanel pnlSave 					;
	JButton btnSave 				;

	JPanel pnlEdit					;
	JButton btnEdit					;

	JPanel pnlUpdate				;
	JButton btnUpdate				;

	JPanel pnlDelete				;
	JButton btnDelete				;

	JPanel pnlCancel				;
	JButton btnCancel				;

	JPanel pnlReport				;
	JButton btnReport				;

	JPanel pnlApply					;
	JButton btnApply				;

	JPanel pnlUI 					;

	JPanel pnlUIReport 				;

	JPanel pnlCountryUpdate			;
	JPanel pnlStateUpdate			;
	JPanel pnlDistrictUpdate 		;
	JPanel pnlTalukaUpdate 			;
	JPanel pnlVillageUpdate			;
	JPanel pnlAreaUpdate			;

	JLabel lblProgramHeading		;
	JLabel lblProject				;

	JLabel lblAreaID 				;
	JLabel lblAreaName 				;

	JLabel lblVillage 				;
	JLabel lblTaluka 				;
	JLabel lblDistrict 				;
	JLabel lblState 				;
	JLabel lblCountry 				;

	JLabel lblVillageUpdate			;
	JLabel lblTalukaUpdate			;
	JLabel lblStateUpdate 			;
	JLabel lblCountryUpdate 		;
	JLabel lblDistrictUpdate 		;
	JLabel lblAreaUpdate 			;

	JTextField txtAreaID 			;
	JTextField txtAreaName 			;

	JComboBox cmbStateUpdate 		;
	JComboBox cmbCountryUpdate		;
	JComboBox cmbDistrictUpdate 	;
	JComboBox cmbTalukaUpdate 		;
	JComboBox cmbVillageUpdate 		;
	JComboBox cmbAreaUpdate 		;
	JComboBox cmbState 				;
	JComboBox cmbCountry 			;
	JComboBox cmbDistrict 			;
	JComboBox cmbTaluka 			;
	JComboBox cmbVillage 			;

	ButtonState bst 				;
	clsButtonManagement5 cbm 		;

	JButton btnNewDoc				;
	JButton btnRefreshDoc			;

	JPanel pnlClose					;

	JButton btnClose 				;

	int Rcols = 0 					;
	ReportTool tool					;

	int vVillage=0;
    frmArea()
    {
		setTitle("New Project");
		setSize(1920,1080);
		setLayout(null);
		setLocation(0,0);

		myUI = new ScreenDesign6();
		add(myUI);
		setExtendedState(getExtendedState()|JFrame.MAXIMIZED_BOTH);

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

		pnlClose = myUI.getClosePanel();//New
		btnClose = myUI.getCloseButton();

		pnlApply = myUI.getApplyPanel();
		btnApply = myUI.getApplyButton();

		pnlCountryUpdate = myUI.getCombo1Panel();
		pnlStateUpdate = myUI.getCombo2Panel();
		pnlDistrictUpdate = myUI.getCombo3Panel();
		pnlTalukaUpdate = myUI.getCombo4Panel();
		pnlVillageUpdate = myUI.getCombo5Panel();
		pnlAreaUpdate = myUI.getCombo6Panel();

		lblCountryUpdate = myUI.getlblCombo1();
		lblCountryUpdate.setText("Country List ...");

		lblStateUpdate = myUI.getlblCombo2();
		lblStateUpdate.setText("State List ...");

		lblDistrictUpdate = myUI.getlblCombo3();
		lblDistrictUpdate.setText("District List...");

		lblTalukaUpdate  = myUI.getlblCombo4();
		lblTalukaUpdate.setText("Taluka List...");

		lblVillageUpdate = myUI.getlblCombo5();
		lblVillageUpdate.setText("Village List...");

		lblAreaUpdate = myUI.getlblCombo6();
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

		cmbVillageUpdate = myUI.getcmbCombo5();
		cmbVillageUpdate.addActionListener(this);
		cmbVillageUpdate.addItem("Select Village...");

		cmbAreaUpdate = myUI.getcmbCombo6();
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
		btnClose.addActionListener(this);//New
		btnApply.addActionListener(this);

		lblProgramHeading = myUI.getlblProgramHeading();
		lblProgramHeading.setText("Area Information...");

		pnlUI = myUI.getpnlUI();
		pnlUI.setLayout(null);
		UISetting.setArea(pnlUI,400,320);

		pnlUIReport = myUI.getpnlUIReport();
		pnlUIReport.setLayout(new BorderLayout());

		int padding = 10;
		pnlUIReport.setBorder(new EmptyBorder(padding, padding, padding, padding));

		UISetting.setArea(pnlUIReport, 800, 400);
		tool = new ReportTool(600, 300);
		pnlUIReport.add(tool, BorderLayout.CENTER);

		lblAreaID = new JLabel("Area ID : ");
		lblAreaID.setBounds(15, 20, 150, 30);
		lblAreaID.setFont(new Font("Aptos", Font.BOLD, 18));
		lblAreaID.setForeground(Color.WHITE); // Set font color to white
		pnlUI.add(lblAreaID);

		lblAreaName = new JLabel("Area Name : ");
		lblAreaName.setBounds(15, 60, 150, 30);
		lblAreaName.setFont(new Font("Aptos", Font.BOLD, 18));
		lblAreaName.setForeground(Color.WHITE); // Set font color to white
		pnlUI.add(lblAreaName);

		txtAreaID = new JTextField();
		txtAreaID.setBounds(170, 20, 50, 30);
		txtAreaID.setFont(new Font("Aptos", Font.BOLD, 18));
		pnlUI.add(txtAreaID);

		txtAreaName = new JTextField();
		txtAreaName.setBounds(170, 60, 200, 30);
		txtAreaName.setFont(new Font("Aptos", Font.BOLD, 18));
		pnlUI.add(txtAreaName);

		lblCountry = new JLabel("State Country : ");
		lblCountry.setBounds(15, 100, 150, 30);
		lblCountry.setFont(new Font("Aptos", Font.BOLD, 18));
		lblCountry.setForeground(Color.WHITE); // Set font color to white
		pnlUI.add(lblCountry);

		lblState = new JLabel("State Name : ");
		lblState.setBounds(15, 140, 150, 30);
		lblState.setFont(new Font("Aptos", Font.BOLD, 18));
		lblState.setForeground(Color.WHITE); // Set font color to white
		pnlUI.add(lblState);

		lblDistrict = new JLabel("State District : ");
		lblDistrict.setBounds(15, 180, 150, 30);
		lblDistrict.setFont(new Font("Aptos", Font.BOLD, 18));
		lblDistrict.setForeground(Color.WHITE); // Set font color to white
		pnlUI.add(lblDistrict);

		lblTaluka = new JLabel("State Taluka : ");
		lblTaluka.setBounds(15, 220, 150, 30);
		lblTaluka.setFont(new Font("Aptos", Font.BOLD, 18));
		lblTaluka.setForeground(Color.WHITE); // Set font color to white
		pnlUI.add(lblTaluka);

		lblVillage = new JLabel("State Village : ");
		lblVillage.setBounds(15, 260, 150, 30);
		lblVillage.setFont(new Font("Aptos", Font.BOLD, 18));
		lblVillage.setForeground(Color.WHITE); // Set font color to white
		pnlUI.add(lblVillage);

		cmbCountry = new JComboBox();
		cmbCountry.addItem("Select Country...");
		cmbCountry.addActionListener(this);
		cmbCountry.setBounds(170, 100, 200, 30);
		pnlUI.add(cmbCountry);

		cmbState = new JComboBox();
		cmbState.addItem("Select State...");
		cmbState.addActionListener(this);
		cmbState.setBounds(170, 140, 200, 30);
		pnlUI.add(cmbState);

		cmbDistrict = new JComboBox();
		cmbDistrict.addItem("Select District...");
		cmbDistrict.addActionListener(this);
		cmbDistrict.setBounds(170, 180, 200, 30);
		pnlUI.add(cmbDistrict);

		cmbTaluka = new JComboBox();
		cmbTaluka.addItem("Select Taluka...");
		cmbTaluka.addActionListener(this);
		cmbTaluka.setBounds(170, 220, 200, 30);
		pnlUI.add(cmbTaluka);

		cmbVillage = new JComboBox();
		cmbVillage.addItem("Select Village...");
		cmbVillage.addActionListener(this);
		cmbVillage.setBounds(170, 260, 160, 30);
		pnlUI.add(cmbVillage);

		btnNewDoc = new JButton(new ImageIcon("image1.png"));
		btnNewDoc.setBounds(340,260,30,30);
		btnNewDoc.setVisible(true);
		btnNewDoc.addActionListener(this);
		pnlUI.add(btnNewDoc);

		btnRefreshDoc = new JButton(new ImageIcon("RefreshImg1.png"));
		btnRefreshDoc.setBounds(340,260,30,30);
		btnRefreshDoc.setVisible(false);
		btnRefreshDoc.addActionListener(this);
		pnlUI.add(btnRefreshDoc);

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
		cmbVillage.setSelectedIndex(0);
	}

//	public clsArea readUI()
	{
//		clsArea temp = new clsArea();
//		temp.setAreaID(Integer.parseInt(txtAreaID.getText()));
//		temp.setAreaName(txtAreaName.getText());
//		temp.setVillageID(vVillage);
//		return temp ;

	}

	public void writeUI(clsVillage temp)
	{
		txtAreaID.setText(String.valueOf(temp.getVillageID()));
		txtAreaName.setText(temp.getVillageName());

		clsLocationManagement5 temp1 = clsLocationManagement5.getLocationInfo(temp.getVillageID());
		System.out.println("testing"+txtAreaID);
		cmbCountry.setSelectedItem(temp1.getCountryName());

		vVillage =temp1.getVillageID();
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
		Rcols+=tool.addNewColumn("Sr_No");
		Rcols+=tool.addNewColumn("AreaName");
		Rcols+=tool.addNewColumn("VillageName");
		Rcols+=tool.addNewColumn("TalukaName");

	}

	void setColumnsAlignment()
	{

		tool.setColumnAlignment(0,ReportTool.ALIGN_CENTER);
		tool.setColumnAlignment(1,ReportTool.ALIGN_CENTER);
		tool.setColumnAlignment(2,ReportTool.ALIGN_CENTER);
		tool.setColumnAlignment(3,ReportTool.ALIGN_CENTER);
		tool.setColumnAlignment(2,ReportTool.ALIGN_CENTER);

	}

	void setColumnsWidth()
	{

		tool.setColumnWidth("Sr_No",80);
		tool.setColumnWidth("AreaName",200);
		tool.setColumnWidth("VillageName",200);
		tool.setColumnWidth("TalukaName",200);

	}

	void setColumnsData()
	{

		tool.removeAllRows();

		clsAreaReport Data[] = clsAreaReport.getAreaReportInformation();

		for(int i=0;i<Data.length;i++)
		{
			Object Objectdata[]=new Object[Rcols];

			Objectdata[0]=i+1;
			if (Data[i].getVillageAreaID() != 0)
			{
				Objectdata[1] = Data[i].getVillageAreaName();
				Objectdata[2] = "";
			}
			else
			{
				Objectdata[1] = Data[i].getTalukaAreaName();
				Objectdata[2] = "";
        	}
        	Objectdata[3]=Data[i].getTalukaName();

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
	void addVillageRecords(JComboBox temp)
	{
		temp.removeActionListener(this);
		clsVillage.addVillageRecords(temp);
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
	void addVillageRecords(JComboBox temp,int mTalukaID)
	{
		clsVillage.addVillageRecords(temp,mTalukaID);
	}
	void addAreaRecords(JComboBox temp,int mVillageID)
	{
//		clsArea.addAreaRecords(temp,mVillageID);
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

//			clsVillage temp = readUI();
//			clsVillage.showVillage(temp);
//			clsVillage.addNewVillage(temp);
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


//			clsVillage temp = readUI();
//			clsVillage.updateVillage(temp);
			initUI();
		}
		else if(ae.getSource() == btnDelete)
		{
			bst.setButtonState(bst.DeleteState);
			cbm.showButtonsOnUI(bst);

//			clsVillage temp = readUI();
//			clsVillage.deleteVillage(temp);
			initUI();

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
//				int mAreaID = clsArea.getIDFromName(mAreaName);
//				clsArea temp = clsVillage.getAreaInformation(mAreaID);
//				clsArea.showArea(temp);
//				writeUI(temp);
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
				int mTalukaID = clsTaluka.getIDFromName(mTalukaName);
				addVillageRecords(cmbVillage,mTalukaID);

			}
		}
		else if(ae.getSource() == cmbVillage)
		{
			if(cmbState.getSelectedIndex() == 0)
			{
				//JOptionPane.showMessageDialog(null,"Please Select State Properly...");
			}
			else
			{
				String mVillageName = (String)cmbVillage.getSelectedItem();
				vVillage = clsVillage.getIDFromName(mVillageName);

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
				addVillageRecords(cmbVillageUpdate, mTalukaID);
			}
		}
		else if(ae.getSource() == cmbVillageUpdate)
		{
			if(cmbStateUpdate.getSelectedIndex() == 0)
			{
				//JOptionPane.showMessageDialog(null,"Please Select State Properly...");
			}
			else
			{
				String mVillageName = (String)cmbVillageUpdate.getSelectedItem();
				int mVillageID = clsVillage.getIDFromName(mVillageName);
				addAreaRecords(cmbAreaUpdate, mVillageID);
			}
		}
		else if(ae.getSource()==btnNewDoc)
		{
			btnNewDoc.setVisible(false);
			btnRefreshDoc.setVisible(true);
			frmVillage A = new frmVillage();
		}
		else if(ae.getSource()==btnRefreshDoc)
		{
			btnNewDoc.setVisible(true);
			btnRefreshDoc.setVisible(false);
			addVillageRecords(cmbTaluka);
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
		cbm.manageClosePanel(pnlClose);//New
		cbm.manageApplyPanel(pnlApply);

		cbm.manageCombo1Panel(pnlCountryUpdate);
		cbm.manageCombo1(cmbCountryUpdate);

		cbm.manageCombo2Panel(pnlStateUpdate);
		cbm.manageCombo2(cmbStateUpdate);

		cbm.manageCombo3Panel(pnlDistrictUpdate);
		cbm.manageCombo3(cmbDistrictUpdate);

		cbm.manageCombo4Panel(pnlTalukaUpdate);
		cbm.manageCombo4(cmbTalukaUpdate);

		cbm.manageCombo5Panel(pnlVillageUpdate);
		cbm.manageCombo5(cmbVillageUpdate);

	}



	public static void main(String args[])
	{
		new frmArea();
	}
}