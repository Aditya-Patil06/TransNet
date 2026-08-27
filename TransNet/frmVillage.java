import appsetting.*;
import myUtility.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import screensetting.*;
import ReportUtility.*;
import javax.swing.border.EmptyBorder; //New for Report

class frmVillage extends JFrame implements ActionListener
{
	ScreenDesign5 myUI				;

	JPanel pnlNew					;
	JPanel pnlView					;
	JPanel pnlSave 					;
	JPanel pnlEdit					;
	JPanel pnlUpdate				;
	JPanel pnlDelete				;
	JPanel pnlCancel				;
	JPanel pnlUIReport 				;
	JPanel pnlReport				;
	JPanel pnlUI 					;
	JPanel pnlApply					;
	JPanel pnlClose					;//New

	JButton btnClose 				;//New
	JButton btnView					;
	JButton btnNew					;
	JButton btnSave 				;
	JButton btnEdit					;
	JButton btnUpdate				;
	JButton btnDelete				;
	JButton btnCancel				;
	JButton btnReport				;
	JButton btnApply				;


	JPanel pnlCountryUpdate			;
	JPanel pnlStateUpdate			;
	JPanel pnlDistrictUpdate 		;
	JPanel pnlTalukaUpdate 			;
	JPanel pnlVillageUpdate			;

	JLabel lblProgramHeading		;
	JLabel lblProject				;
	JLabel lblVillageID 			;
	JLabel lblVillageName 			;
	JLabel lblTaluka 				;
	JLabel lblDistrict 				;
	JLabel lblState 				;
	JLabel lblCountry 				;
	JLabel lblVillageUpdate			;
	JLabel lblTalukaUpdate			;
	JLabel lblStateUpdate 			;
	JLabel lblCountryUpdate 		;
	JLabel lblDistrictUpdate 		;

	JTextField txtVillageID 		;
	JTextField txtVillageName 		;

	JComboBox cmbStateUpdate 		;
	JComboBox cmbCountryUpdate		;
	JComboBox cmbDistrictUpdate 	;
	JComboBox cmbTalukaUpdate 		;
	JComboBox cmbVillageUpdate 		;
	JComboBox cmbState 				;
	JComboBox cmbCountry 			;
	JComboBox cmbDistrict 			;
	JComboBox cmbTaluka 			;

	ButtonState bst 				;
	clsButtonManagement5 cbm 		;

	int Rcols = 0 					;		//Report Helper Class
	ReportTool tool					;

	JButton btnNewDoc				;
	JButton btnRefreshDoc			;

	int vTaluka=0;
    frmVillage()
    {
		setTitle("New Project");
		setSize(1920,1080);
		setLayout(null);
		setLocation(0,0);

		myUI = new ScreenDesign5();
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
		lblProgramHeading.setText("Village Information...");

		pnlUI = myUI.getpnlUI();
		pnlUI.setLayout(null);
		UISetting.setArea(pnlUI,400,280);

		pnlUIReport = myUI.getpnlUIReport();
		pnlUIReport.setLayout(new BorderLayout());

		int padding = 10;
		pnlUIReport.setBorder(new EmptyBorder(padding, padding, padding, padding));

		UISetting.setArea(pnlUIReport, 800, 400);
		tool = new ReportTool(600, 300);
		pnlUIReport.add(tool, BorderLayout.CENTER);


		lblVillageID = new JLabel("Village ID : ");
		lblVillageID.setBounds(15, 20, 150, 30);
		lblVillageID.setFont(new Font("Aptos", Font.BOLD, 18));
		lblVillageID.setForeground(Color.WHITE); // Set text color to white
		pnlUI.add(lblVillageID);

		lblVillageName = new JLabel("Village Name : ");
		lblVillageName.setBounds(15, 60, 150, 30);
		lblVillageName.setFont(new Font("Aptos", Font.BOLD, 18));
		lblVillageName.setForeground(Color.WHITE); // Set text color to white
		pnlUI.add(lblVillageName);

		txtVillageID = new JTextField();
		txtVillageID.setBounds(170, 20, 50, 30);
		txtVillageID.setFont(new Font("Aptos", Font.BOLD, 18));
		pnlUI.add(txtVillageID);

		txtVillageName = new JTextField();
		txtVillageName.setBounds(170, 60, 210, 30);
		txtVillageName.setFont(new Font("Aptos", Font.BOLD, 18));
		pnlUI.add(txtVillageName);

		lblState = new JLabel("State Name : ");
		lblState.setBounds(15, 140, 150, 30);
		lblState.setFont(new Font("Aptos", Font.BOLD, 18));
		lblState.setForeground(Color.WHITE); // Set text color to white
		pnlUI.add(lblState);

		lblCountry = new JLabel("State Country : ");
		lblCountry.setBounds(15, 100, 150, 30);
		lblCountry.setFont(new Font("Aptos", Font.BOLD, 18));
		lblCountry.setForeground(Color.WHITE); // Set text color to white
		pnlUI.add(lblCountry);

		lblDistrict = new JLabel("State District : ");
		lblDistrict.setBounds(15, 180, 150, 30);
		lblDistrict.setFont(new Font("Aptos", Font.BOLD, 18));
		lblDistrict.setForeground(Color.WHITE); // Set text color to white
		pnlUI.add(lblDistrict);

		lblTaluka = new JLabel("State Taluka : ");
		lblTaluka.setBounds(15, 220, 150, 30);
		lblTaluka.setFont(new Font("Aptos", Font.BOLD, 18));
		lblTaluka.setForeground(Color.WHITE); // Set text color to white
		pnlUI.add(lblTaluka);

		cmbState = new JComboBox();
		cmbState.addItem("Select State...");
		cmbState.addActionListener(this);
		cmbState.setBounds(170, 140, 210, 30);
		pnlUI.add(cmbState);

		cmbCountry = new JComboBox();
		cmbCountry.addItem("Select Country...");
		cmbCountry.addActionListener(this);
		cmbCountry.setBounds(170, 100, 210, 30);
		pnlUI.add(cmbCountry);

		cmbDistrict = new JComboBox();
		cmbDistrict.addItem("Select District...");
		cmbDistrict.addActionListener(this);
		cmbDistrict.setBounds(170, 180, 210, 30);
		pnlUI.add(cmbDistrict);

		cmbTaluka = new JComboBox();
		cmbTaluka.addItem("Select Taluka...");
		cmbTaluka.addActionListener(this);
		cmbTaluka.setBounds(170, 220, 170, 30);
        pnlUI.add(cmbTaluka);

		btnRefreshDoc = new JButton(new ImageIcon("RefreshImg1.png"));
		btnRefreshDoc.setBounds(350,220,30,30);
		btnRefreshDoc.setVisible(false);
		btnRefreshDoc.addActionListener(this);
		pnlUI.add(btnRefreshDoc);



		bst = new ButtonState();
		cbm = new clsButtonManagement5();
		automateButtons();
		bst.setButtonState(ButtonState.InitialState);
		cbm.showButtonsOnUI(bst);

		addCountryRecords(cmbCountry);

		createReport();//New

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
		txtVillageID.setText("0");
		txtVillageName.setText("");
		cmbTaluka.setSelectedIndex(0);
		cmbDistrict.setSelectedIndex(0);
		cmbState.setSelectedIndex(0);
		cmbCountry.setSelectedIndex(0);
	}

	public clsVillage readUI()
	{
		clsVillage temp = new clsVillage();
		temp.setVillageID(Integer.parseInt(txtVillageID.getText()));
		temp.setVillageName(txtVillageName.getText());
		temp.setTalukaID(vTaluka);
		return temp ;

	}

	public void writeUI(clsVillage temp)
	{
		txtVillageID.setText(String.valueOf(temp.getVillageID()));
		txtVillageName.setText(temp.getVillageName());

		clsLocationManagement5 temp1 = clsLocationManagement5.getLocationInfo(temp.getVillageID());
		System.out.println("testing"+txtVillageID);
		cmbCountry.setSelectedItem(temp1.getCountryName());
		vTaluka =temp1.getTalukaID();
		cmbState.setSelectedItem(temp1.getStateName());
		cmbDistrict.setSelectedItem(temp1.getDistrictName());
		cmbTaluka.setSelectedItem(temp1.getTalukaName());

	}

	void createReport()//New
	{

		setColumnsHeading();
		setColumnsAlignment();
		setColumnsWidth();

	}

	void setColumnsHeading()//New
	{

		Rcols=0;
		Rcols+=tool.addNewColumn("VillageID");
		Rcols+=tool.addNewColumn("VillageName");
		Rcols+=tool.addNewColumn("TalukaName");

	}

	void setColumnsAlignment()//New
	{

		tool.setColumnAlignment(0,ReportTool.ALIGN_CENTER);
		tool.setColumnAlignment(1,ReportTool.ALIGN_CENTER);
		tool.setColumnAlignment(2,ReportTool.ALIGN_CENTER);

	}

	void setColumnsWidth()//New
	{

		tool.setColumnWidth("VillageID",80);
		tool.setColumnWidth("VillageName",200);
		tool.setColumnWidth("TalukaName",200);

	}

	void setColumnsData()//New
	{

		tool.removeAllRows();

		clsVillageReport1 Data[] = clsVillageReport1.getVillageReport1Info();

		for(int i=0;i<Data.length;i++)
		{
			Object Objectdata[]=new Object[Rcols];

			Objectdata[0]=i+1;
			Objectdata[1]=Data[i].getVillageName();
			Objectdata[2]=Data[i].getTalukaName();


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
	void addVillageRecords(JComboBox temp,int mTalukaID)
	{
		clsVillage.addVillageRecords(temp,mTalukaID);
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

			clsVillage temp = readUI();
			clsVillage.showVillage(temp);
			clsVillage.addNewVillage(temp);
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

			clsVillage temp = readUI();
			clsVillage.updateVillage(temp);
			initUI();
		}
		else if(ae.getSource() == btnDelete)
		{
			bst.setButtonState(bst.DeleteState);
			cbm.showButtonsOnUI(bst);

			clsVillage temp = readUI();
			clsVillage.deleteVillage(temp);
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
			bst.setButtonCommonState(ButtonState.ReportState);//New
			cbm.showButtonsOnUI(bst);
			setColumnsData();

		}

		else if(ae.getSource()==btnClose)
		{
			bst.setButtonCommonState(ButtonState.CloseReportState);//New
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
				String mVillageName = (String)cmbVillageUpdate.getSelectedItem();
				int mVillageID = clsVillage.getIDFromName(mVillageName);
				clsVillage temp = clsVillage.getVillageInformation(mVillageID);
				clsVillage.showVillage(temp);
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
				addVillageRecords(cmbVillageUpdate, mTalukaID);
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
		new frmVillage();
	}
}