import appsetting.*;
import myUtility.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import screensetting.*;
import ReportUtility.*;
import javax.swing.border.EmptyBorder; //New for Report

class frmDistrict extends JFrame implements ActionListener
{
	ScreenDesign3 myUI				;

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

	JTextField txtDistrictID 		;
	JTextField txtDistrictName 		;

	JLabel lblProgramHeading	;		//Labels
	JLabel lblProject			;
	JLabel lblDisctrictID		;
	JLabel lblDistrictName 		;
	JLabel lblState				;
	JLabel lblCountry 			;
	JLabel lblStateUpdate 		;
	JLabel lblCountryUpdate 	;
	JLabel lblDistrictUpdate 	;

	JComboBox cmbStateUpdate 		;
	JComboBox cmbCountryUpdate		;
	JComboBox cmbDistrictUpdate     ;
	JComboBox cmbState 				;
	JComboBox cmbCountry 			;

	ButtonState bst 				;
	clsButtonManagement3 cbm 		;

	int Rcols = 0 					;		//Report Helper Class
	ReportTool tool					;


	int vStateID=0					;

    frmDistrict()
    {
		setTitle("New Project");
		setSize(1920,1080);
		setLayout(null);
		setLocation(0,0);

		myUI = new ScreenDesign3();
		add(myUI);
		setExtendedState(getExtendedState()|JFrame.MAXIMIZED_BOTH);

		pnlUI = myUI.getpnlUI();//New
		pnlUI.setLayout(null);
		UISetting.setArea(pnlUI,400,200);

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
		btnClose= myUI.getCloseButton();
		btnClose.addActionListener(this);


		pnlApply = myUI.getApplyPanel();
		btnApply = myUI.getApplyButton();
		pnlCountryUpdate = myUI.getCombo1Panel();
		pnlStateUpdate = myUI.getCombo2Panel();
		pnlDistrictUpdate = myUI.getCombo3Panel();


		lblCountryUpdate = myUI.getlblCombo1();
		lblCountryUpdate.setText("Country List ...");

		lblStateUpdate = myUI.getCombo2();
		lblStateUpdate.setText("State List ...");

		lblDistrictUpdate = myUI.getlblCombo3();
		lblDistrictUpdate.setText("District List...");


		cmbCountryUpdate= myUI.getcmbCombo1();
		cmbCountryUpdate.addActionListener(this);

		cmbStateUpdate= myUI.getcmbCombo2();
		cmbStateUpdate.addActionListener(this);
		cmbStateUpdate.addItem("Select State...");

		cmbDistrictUpdate = myUI.getcmbCombo3();
		cmbDistrictUpdate.addItem("Select District...");


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
		lblProgramHeading.setText("District Information");

		lblDisctrictID = new JLabel("District ID : ");
        lblDisctrictID.setBounds(15, 20, 150, 30);
        lblDisctrictID.setFont(new Font("Aptos", Font.BOLD, 18));
        lblDisctrictID.setForeground(Color.WHITE); // Set text color to white
        pnlUI.add(lblDisctrictID);

        lblDistrictName = new JLabel("District Name : ");
        lblDistrictName.setBounds(15, 60, 150, 30);
        lblDistrictName.setFont(new Font("Aptos", Font.BOLD, 18));
        lblDistrictName.setForeground(Color.WHITE); // Set text color to white
        pnlUI.add(lblDistrictName);

        txtDistrictID = new JTextField();
        txtDistrictID.setBounds(170, 20, 50, 30);
        txtDistrictID.setFont(new Font("Aptos", Font.BOLD, 18));
        pnlUI.add(txtDistrictID);

        txtDistrictName = new JTextField();
        txtDistrictName.setBounds(170, 60, 210, 30);
        txtDistrictName.setFont(new Font("Aptos", Font.BOLD, 18));
        pnlUI.add(txtDistrictName);

        lblState = new JLabel("State Name : ");
        lblState.setBounds(15, 140, 150, 30);
        lblState.setFont(new Font("Aptos", Font.BOLD, 18));
        lblState.setForeground(Color.WHITE); // Set text color to white
        pnlUI.add(lblState);

        cmbState = new JComboBox();
        cmbState.addItem("Select State...");
        cmbState.addActionListener(this);
        cmbState.setBounds(170, 140, 170, 30);
        pnlUI.add(cmbState);

        lblCountry = new JLabel("State Country : ");
        lblCountry.setBounds(15, 100, 150, 30);
        lblCountry.setFont(new Font("Aptos", Font.BOLD, 18));
        lblCountry.setForeground(Color.WHITE); // Set text color to white
        pnlUI.add(lblCountry);

        cmbCountry = new JComboBox();
        cmbCountry.addItem("Select Country...");
        cmbCountry.addActionListener(this);
        cmbCountry.setBounds(170, 100, 210, 30);
        pnlUI.add(cmbCountry);

		btnNewDoc = new JButton(new ImageIcon("image1.png"));
		btnNewDoc.setBounds(350,140,30,30);
		btnNewDoc.setVisible(true);
		btnNewDoc.addActionListener(this);
		pnlUI.add(btnNewDoc);

		btnRefreshDoc = new JButton(new ImageIcon("RefreshImg1.png"));
		btnRefreshDoc.setBounds(350,140,30,30);
		btnRefreshDoc.setVisible(false);
		btnRefreshDoc.addActionListener(this);
		pnlUI.add(btnRefreshDoc);

		bst = new ButtonState();
		cbm = new clsButtonManagement3();
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
		txtDistrictID.setText("0");
		txtDistrictName.setText("");
		cmbState.setSelectedIndex(0);
		cmbCountry.setSelectedIndex(0);
	}

	public clsDistrict readUI()
	{
		clsDistrict temp = new clsDistrict();
		temp.setDistrictID(Integer.parseInt(txtDistrictID.getText()));
		temp.setDistrictName(txtDistrictName.getText());
		temp.setStateID(vStateID);

		return temp ;
	}

	public void writeUI(clsDistrict temp)
	{
		txtDistrictID.setText(String.valueOf(temp.getDistrictID()));
		txtDistrictName.setText(temp.getDistrictName());

		clsLocationManagement3 temp1 = clsLocationManagement3.getLocationInfo(temp.getDistrictID());
		cmbCountry.setSelectedItem(temp1.getCountryName());
		vStateID=temp1.getStateID();
		cmbState.setSelectedItem(temp1.getStateName());
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
		Rcols+=tool.addNewColumn("DistrictID");
		Rcols+=tool.addNewColumn("DistrictName");
		Rcols+=tool.addNewColumn("StateName");


	}

	void setColumnsAlignment()//New
	{

		tool.setColumnAlignment(0,ReportTool.ALIGN_CENTER);
		tool.setColumnAlignment(1,ReportTool.ALIGN_CENTER);
		tool.setColumnAlignment(2,ReportTool.ALIGN_CENTER);


	}

	void setColumnsWidth()//New
	{

		tool.setColumnWidth("DistrictID",80);
		tool.setColumnWidth("DistrictName",200);
		tool.setColumnWidth("StateName",200);

	}

	void setColumnsData()//New
	{

		tool.removeAllRows();

		clsDistrictReport1 Data[] = clsDistrictReport1.getDistrictReport1Info();

		for(int i=0;i<Data.length;i++)
		{
			Object Objectdata[]=new Object[Rcols];

			Objectdata[0]=i+1;
			Objectdata[1]=Data[i].getDistrictName();
			Objectdata[2]=Data[i].getStateName();


			tool.addNewRow(Objectdata);
		}
	}
	void addStateRecords(JComboBox temp)
	{
		temp.removeActionListener(this);
		clsState.addStateRecords(temp);
		temp.addActionListener(this);
	}
	void addStateRecords(JComboBox temp,int mCountryID)
	{
		clsState.addStateRecords(temp,mCountryID);
	}

	void addCountryRecords(JComboBox temp)
	{
		temp.removeActionListener(this);
		clsCountry.addCountryRecords(temp);
		temp.addActionListener(this);
	}


	void addDistrictRecords(JComboBox temp,int mStateID)
	{
		clsDistrict.addDistrictRecords(temp,mStateID);
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

			clsDistrict temp = readUI();
			clsDistrict.addNewDistrict(temp);
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

			clsDistrict temp = readUI();
			clsDistrict.updateDistrict(temp);
			initUI();
			//JOptionPane.showMessageDialog(null,"Updated successfully...");
		}
		else if(ae.getSource() == btnDelete)
		{
			bst.setButtonState(bst.DeleteState);
			cbm.showButtonsOnUI(bst);

			clsDistrict temp = readUI();
			clsDistrict.deleteDistrict(temp);
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
				String mDistrictName = (String)cmbDistrictUpdate.getSelectedItem();
				int mDistrictID = clsDistrict.getIDFromName(mDistrictName);
				clsDistrict temp = clsDistrict.getDistrictInformation(mDistrictID);
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
				vStateID = clsState.getIDFromName(mStateName);
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
		else if(ae.getSource()==btnNewDoc)
		{
			btnNewDoc.setVisible(false);
			btnRefreshDoc.setVisible(true);
			frmState A = new frmState();
		}
		else if(ae.getSource()==btnRefreshDoc)
		{
			btnNewDoc.setVisible(true);
			btnRefreshDoc.setVisible(false);
			addStateRecords(cmbState);
		}

	}


	public static void main(String args[])
	{
		new frmDistrict();
	}
}