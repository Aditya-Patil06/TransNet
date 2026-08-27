import appsetting.*;
import myUtility.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import screensetting.*;
import ReportUtility.*;
import javax.swing.border.EmptyBorder;

class frmTaluka extends JFrame implements ActionListener
{
	ScreenDesign4 myUI				;

	JButton btnNew				;		//Buttons
	JButton btnView				;
	JButton btnSave				;
	JButton btnEdit				;
	JButton btnUpdate			;
	JButton btnDelete			;
	JButton btnCancel			;
	JButton btnApply			;
	JButton btnReport			;
	JButton btnNewDoc			;
	JButton btnRefreshDoc		;
	JButton btnClose 			;//New

	JPanel pnlNew				;		//Panels
	JPanel pnlView				;
	JPanel pnlSave 				;
	JPanel pnlUpdate			;
	JPanel pnlDelete			;
	JPanel pnlCancel			;
	JPanel pnlApply				;
	JPanel pnlReport			;
	JPanel pnlUI 				;
	JPanel pnlUIReport 			;
	JPanel pnlEdit				;
	JPanel pnlClose				;//New
	JPanel pnlCountryUpdate 	;
	JPanel pnlStateUpdate		;
	JPanel pnlDistrictUpdate 	;
	JPanel pnlTalukaUpdate		;

	JTextField txtTalukaID 	;
	JTextField txtTalukaName 	;

	JLabel lblProgramHeading	;		//Labels
	JLabel lblProject			;
	JLabel lblTalukaID		;
	JLabel lblTalukaName 		;
	JLabel lblDistrict			;
	JLabel lblState				;
	JLabel lblCountry 			;
	JLabel lblStateUpdate 		;
	JLabel lblCountryUpdate 	;
	JLabel lblDistrictUpdate 	;
	JLabel lblTalukaUpdate		;

	JComboBox cmbStateUpdate 		;
	JComboBox cmbCountryUpdate		;
	JComboBox cmbDistrictUpdate     ;
	JComboBox cmbTalukaUpdate		;
	JComboBox cmbDistrict			;
	JComboBox cmbState 				;
	JComboBox cmbCountry 			;

	ButtonState bst 				;
	clsButtonManagement4 cbm 		;

	int Rcols = 0 					;
	ReportTool tool					;


	int vDistrictID=0;
    frmTaluka()
    {
		setTitle("New Project");
		setSize(1920,1080);
		setLayout(null);
		setLocation(0,0);

		myUI = new ScreenDesign4();
		add(myUI);
		setExtendedState(getExtendedState()|JFrame.MAXIMIZED_BOTH);

		pnlUI = myUI.getpnlUI();
		pnlUI.setLayout(null);
		UISetting.setArea(pnlUI,400,240);

		pnlUIReport = myUI.getpnlUIReport();
		pnlUIReport.setLayout(new BorderLayout());

		int padding = 10;
		pnlUIReport.setBorder(new EmptyBorder(padding, padding, padding, padding));

		UISetting.setArea(pnlUIReport, 800, 400);
		tool = new ReportTool(600, 300);
		pnlUIReport.add(tool, BorderLayout.CENTER);


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

		lblCountryUpdate = myUI.getlblCombo1();
		lblCountryUpdate.setText("Country List ...");

		lblStateUpdate = myUI.getlblCombo2();
		lblStateUpdate.setText("State List ...");

		lblDistrictUpdate = myUI.getlblCombo3();
		lblDistrictUpdate.setText("District List...");

		lblTalukaUpdate  = myUI.getlblCombo4();
		lblTalukaUpdate.setText("Taluka List...");

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


		btnNew.addActionListener(this);
		btnSave.addActionListener(this);
		btnView.addActionListener(this);
		btnEdit.addActionListener(this);
		btnUpdate.addActionListener(this);
		btnDelete.addActionListener(this);
		btnCancel.addActionListener(this);
		btnReport.addActionListener(this);
		btnApply.addActionListener(this);
		btnClose.addActionListener(this);//New

		lblProgramHeading = myUI.getlblProgramHeading();
		lblProgramHeading.setText("Taluka Information");

		lblTalukaID = new JLabel("Taluka ID : ");
		lblTalukaID.setBounds(15, 20, 150, 30);
		lblTalukaID.setFont(new Font("Aptos", Font.BOLD, 18));
		lblTalukaID.setForeground(Color.WHITE); // Set text color to white
		pnlUI.add(lblTalukaID);

		lblTalukaName = new JLabel("Taluka Name : ");
		lblTalukaName.setBounds(15, 60, 150, 30);
		lblTalukaName.setFont(new Font("Aptos", Font.BOLD, 18));
		lblTalukaName.setForeground(Color.WHITE); // Set text color to white
		pnlUI.add(lblTalukaName);

		txtTalukaID = new JTextField();
		txtTalukaID.setBounds(170, 20, 50, 30);
		txtTalukaID.setFont(new Font("Aptos", Font.BOLD, 18));
		pnlUI.add(txtTalukaID);

		txtTalukaName = new JTextField();
		txtTalukaName.setBounds(170, 60, 210, 30);
		txtTalukaName.setFont(new Font("Aptos", Font.BOLD, 18));
		pnlUI.add(txtTalukaName);

		lblState = new JLabel("State Name : ");
		lblState.setBounds(15, 140, 150, 30);
		lblState.setFont(new Font("Aptos", Font.BOLD, 18));
		lblState.setForeground(Color.WHITE); // Set text color to white
		pnlUI.add(lblState);

		cmbState = new JComboBox();
		cmbState.addItem("Select State...");
		cmbState.addActionListener(this);
		cmbState.setBounds(170, 140, 210, 30);
		pnlUI.add(cmbState);

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

		cmbCountry = new JComboBox();
		cmbCountry.addItem("Select Country...");
		cmbCountry.addActionListener(this);
		cmbCountry.setBounds(170, 100, 210, 30);
		pnlUI.add(cmbCountry);

		cmbDistrict = new JComboBox();
		cmbDistrict.addItem("Select District...");
		cmbDistrict.addActionListener(this);
		cmbDistrict.setBounds(170, 180, 170, 30);
        pnlUI.add(cmbDistrict);

		btnNewDoc = new JButton(new ImageIcon("image1.png"));
		btnNewDoc.setBounds(350,180,30,30);
		btnNewDoc.setVisible(true);
		btnNewDoc.addActionListener(this);
		pnlUI.add(btnNewDoc);

		btnRefreshDoc = new JButton(new ImageIcon("RefreshImg1.png"));
		btnRefreshDoc.setBounds(350,180,30,30);
		btnRefreshDoc.setVisible(false);
		btnRefreshDoc.addActionListener(this);
		pnlUI.add(btnRefreshDoc);


		bst = new ButtonState();
		cbm = new clsButtonManagement4();
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
		txtTalukaID.setText("0");
		txtTalukaName.setText("");

		cmbDistrict.setSelectedIndex(0);
		cmbState.setSelectedIndex(0);
		cmbCountry.setSelectedIndex(0);
	}

	public clsTaluka readUI()
	{
		clsTaluka temp = new clsTaluka();
		temp.setTalukaID(Integer.parseInt(txtTalukaID.getText()));
		temp.setTalukaName(txtTalukaName.getText());
		temp.setDistrictID(vDistrictID);
		return temp ;

	}

	public void writeUI(clsTaluka temp)
	{
		txtTalukaID.setText(String.valueOf(temp.getTalukaID()));
		txtTalukaName.setText(temp.getTalukaName());

		clsLocationManagement4 temp1 = clsLocationManagement4.getLocationInfo(temp.getTalukaID());
		cmbCountry.setSelectedItem(temp1.getCountryName());
		vDistrictID =temp1.getDistrictID();
		cmbState.setSelectedItem(temp1.getStateName());
		cmbDistrict.setSelectedItem(temp1.getDistrictName());
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
		Rcols+=tool.addNewColumn("TalukaID");
		Rcols+=tool.addNewColumn("TalukaName");
		Rcols+=tool.addNewColumn("DistrictName");

	}

	void setColumnsAlignment()
	{

		tool.setColumnAlignment(0,ReportTool.ALIGN_CENTER);
		tool.setColumnAlignment(1,ReportTool.ALIGN_CENTER);
		tool.setColumnAlignment(2,ReportTool.ALIGN_CENTER);

	}

	void setColumnsWidth()
	{

		tool.setColumnWidth("TalukaID",80);
		tool.setColumnWidth("TalukaName",200);
		tool.setColumnWidth("DistrictName",200);

	}

	void setColumnsData()//New
	{

		tool.removeAllRows();

		clsTalukaReport1 Data[] = clsTalukaReport1.getTalukaReport1Info();

		for(int i=0;i<Data.length;i++)
		{
			Object Objectdata[]=new Object[Rcols];

			Objectdata[0]=i+1;
			Objectdata[1]=Data[i].getTalukaName();
			Objectdata[2]=Data[i].getDistrictName();


			tool.addNewRow(Objectdata);
		}
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
	void addDistrictRecords(JComboBox temp)
	{
		temp.removeActionListener(this);
		clsDistrict.addDistrictRecords(temp);
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
		cbm.manageApplyPanel(pnlApply);
		cbm.manageClosePanel(pnlClose);//New

		cbm.manageCombo1Panel(pnlCountryUpdate);
		cbm.manageCombo1(cmbCountryUpdate);

		cbm.manageCombo2Panel(pnlStateUpdate);
		cbm.manageCombo2(cmbStateUpdate);

		cbm.manageCombo3Panel(pnlDistrictUpdate);
		cbm.manageCombo3(cmbDistrictUpdate);

		cbm.manageCombo4Panel(pnlTalukaUpdate);
		cbm.manageCombo4(cmbTalukaUpdate);

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

			clsTaluka temp = readUI();
			clsTaluka.addNewTaluka(temp);
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

			clsTaluka temp = readUI();
			clsTaluka.updateTaluka(temp);
			initUI();
			//JOptionPane.showMessageDialog(null,"Updated successfully...");
		}
		else if(ae.getSource() == btnDelete)
		{
			bst.setButtonState(bst.DeleteState);
			cbm.showButtonsOnUI(bst);

			clsTaluka temp = readUI();
			clsTaluka.deleteTaluka(temp);
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
				String mTalukaName = (String)cmbTalukaUpdate.getSelectedItem();
				int mTalukaID = clsTaluka.getIDFromName(mTalukaName);
				clsTaluka temp = clsTaluka.getTalukaInformation(mTalukaID);
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
				vDistrictID = clsDistrict.getIDFromName(mDistrictName);

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
		else if(ae.getSource()==btnNewDoc)
		{
			btnNewDoc.setVisible(false);
			btnRefreshDoc.setVisible(true);
			frmDistrict A = new frmDistrict();
		}
		else if(ae.getSource()==btnRefreshDoc)
		{
			btnNewDoc.setVisible(true);
			btnRefreshDoc.setVisible(false);
			addDistrictRecords(cmbDistrict);
		}

	}

	public static void main(String args[])
	{
		new frmTaluka();
	}
}