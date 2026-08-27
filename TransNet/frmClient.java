import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import appsetting.*;
import screensetting.*;
import myUtility.*;
import ReportUtility.*;
import javax.swing.border.EmptyBorder; //New for Report

class frmClient extends JFrame implements ActionListener
{
	JPanel pnlUI;
	JPanel pnlUIReport;
	JPanel pnlClientUpdate;

	JPanel pnlApply;
	JButton btnApply;

	JPanel pnlNew;
	JButton btnNew;

	JPanel pnlSave;
	JButton btnSave;

	JPanel pnlView;
	JButton btnView;

	JPanel pnlEdit;
	JButton btnEdit;

	JPanel pnlUpdate;
	JButton btnUpdate;

	JPanel pnlDelete;
	JButton btnDelete;

	JPanel pnlCancel;
	JButton btnCancel;

	JPanel pnlReport;
	JButton btnReport;

	JPanel pnlClose;
	JButton btnClose;


	ScreenDesign myUI;

	JLabel lblProgramHeading;

	JLabel lblClientID ;
	JLabel lblClientName;
	JLabel lblAddress;
	JLabel lblAge;
	JLabel lblContactNo;
	JLabel lblEmailID;
	JLabel lblIndustryID;
	JLabel lblGender;
	JLabel lblAreaID;
	JLabel lblPinCode;
	JLabel lblCity;

	JLabel lblClientUpdate;
	JComboBox cmbClientUpdate;

	JComboBox cmbCountry;
	JComboBox cmbState;
	JComboBox cmbDistrict;
	JComboBox cmbTaluka;
	JComboBox cmbArea;
	JComboBox cmbIndustry;
	JComboBox cmbVillage;

	JCheckBox chbVillage;

	JTextField txtClientID;
	JTextField txtClientName;
	JTextField txtAddress;
	JTextField txtAge;
	JTextField txtContactNo;
	JTextField txtGender;
	JTextField txtAreaID;
	JTextField txtPinCode;
	JTextField txtEmailID ;

	ButtonGroup g1;
	JRadioButton rbMale;
	JRadioButton rbFemale;

	int Rcols;
	ReportTool tool;

	ButtonState bst;
	clsButtonManagement cbm;

	int vIndustryID=0;
	int vAreaID=0;
	int vVillagian=0;
	int vTalukaID=0;
	// test
	frmClient()
	{
		setSize(1950,1200);
		setLocation(1,1);
		setLayout(null);
		setTitle("Form Designing");
		setExtendedState(getExtendedState()|JFrame.MAXIMIZED_BOTH );

		myUI = new ScreenDesign();
		add(myUI);

		pnlUI = myUI.getUIPanel();
		pnlUI.setLayout(null);
		UISetting.setArea(pnlUI,700,360);

		pnlUIReport = myUI.getUIReportPanel();
		pnlUIReport.setBackground(ColorSetting.getBackColorButtonPnl());
		pnlUIReport.setLayout(new BorderLayout());

		int padding = 10;
		pnlUIReport.setBorder(new EmptyBorder(padding, padding, padding, padding));

		UISetting.setArea(pnlUIReport, 1000, 400);
		tool = new ReportTool(1000,300);
		pnlUIReport.add(tool, BorderLayout.CENTER);

		pnlNew = myUI.getNewPanel();
		btnNew = myUI.getNewButton();
		btnNew.addActionListener(this);

		pnlSave = myUI.getSavePanel();
		btnSave = myUI.getSaveButton();
		btnSave.addActionListener(this);

		pnlCancel = myUI.getCancelPanel();
		btnCancel = myUI.getCancelButton();
		btnCancel.addActionListener(this);

		lblClientUpdate = myUI.getlblCombo1();

		pnlClientUpdate = myUI.getCombo1Panel();
		cmbClientUpdate = myUI.getcmbCombo1();
		cmbClientUpdate.addActionListener(this);

		pnlView = myUI.getViewPanel();
		btnView = myUI.getViewButton();
		btnView.addActionListener(this);

		pnlReport = myUI.getReportPanel();
		btnReport = myUI.getReportButton();
		btnReport.addActionListener(this);

		pnlClose = myUI.getClosePanel();
		btnClose = myUI.getCloseButton();
		btnClose.addActionListener(this);

		pnlApply = myUI.getApplyPanel();
		btnApply = myUI.getApplyButton();
		btnApply.addActionListener(this);

		pnlEdit = myUI.getEditPanel();
		btnEdit = myUI.getEditButton();
		btnEdit.addActionListener(this);

		pnlDelete = myUI.getDeletePanel();
		btnDelete = myUI.getDeleteButton();
		btnDelete.addActionListener(this);

		pnlUpdate = myUI.getUpdatePanel();
		btnUpdate = myUI.getUpdateButton();
		btnUpdate.addActionListener(this);

		lblProgramHeading = myUI.getlblProgramHeading();
		lblProgramHeading.setText("Client Information");


		lblClientID = new JLabel("Client ID :");
		lblClientID.setLayout(null);
		lblClientID.setBounds(20, 20, 100, 30);
		lblClientID.setFont(new Font("Basic", Font.BOLD, 18));
        lblClientID.setForeground(Color.WHITE); // Set text color to white
		pnlUI.add(lblClientID);

		txtClientID = new JTextField();
		txtClientID.setLayout(null);
		txtClientID.setBounds(120, 20, 50, 30);
		txtClientID.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(txtClientID);

		lblClientName = new JLabel("Name : ");
		lblClientName.setLayout(null);
		lblClientName.setBounds(20, 65, 100, 30);
		lblClientName.setFont(new Font("Basic", Font.BOLD, 18));
        lblClientName.setForeground(Color.WHITE); // Set text color to white
		pnlUI.add(lblClientName);

		txtClientName = new JTextField();
		txtClientName.setLayout(null);
		txtClientName.setBounds(120, 65, 350, 30);
		txtClientName.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(txtClientName);

		lblAddress = new JLabel("Address : ");
		lblAddress.setLayout(null);
		lblAddress.setBounds(20, 110, 100, 30);
		lblAddress.setFont(new Font("Basic", Font.BOLD, 18));
        lblAddress.setForeground(Color.WHITE); // Set text color to white
		pnlUI.add(lblAddress);

		txtAddress = new JTextField();
		txtAddress.setLayout(null);
		txtAddress.setBounds(120, 110, 400, 40);
		txtAddress.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(txtAddress);

		lblCity = new JLabel("  City : ");
		lblCity.setLayout(null);
		lblCity.setBounds(20, 145, 110, 30);
		lblCity.setFont(new Font("Basic", Font.BOLD, 18));
        lblCity.setForeground(Color.WHITE); // Set text color to white
		pnlUI.add(lblCity);

		cmbCountry = new JComboBox();
		cmbCountry.setBounds(120, 165, 180, 30);
		cmbCountry.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(cmbCountry);
		cmbCountry.addActionListener(this);

		cmbState = new JComboBox();
		cmbState.setBounds(305, 165, 180, 30);
		cmbState.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(cmbState);

		cmbDistrict = new JComboBox();
		cmbDistrict.setBounds(490, 165, 180, 30);
		cmbDistrict.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(cmbDistrict);

		cmbTaluka = new JComboBox();
		cmbTaluka.setBounds(120,210, 180, 30);
		cmbTaluka.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(cmbTaluka);

		chbVillage = new JCheckBox("Are you Villagian?");
		chbVillage.setBounds(305, 210, 185, 30);
		chbVillage.setFont(new Font("Basic", Font.BOLD, 18));
        chbVillage.setForeground(Color.WHITE); // Set text color to white
		chbVillage.setOpaque(false);
		pnlUI.add(chbVillage);

		cmbVillage = new JComboBox();
		cmbVillage.setBounds(490, 210, 180, 30);
		cmbVillage.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(cmbVillage);

		lblAreaID = new JLabel(" Area : ");
		lblAreaID.setLayout(null);
		lblAreaID.setBounds(20, 255, 100, 30);
		lblAreaID.setFont(new Font("Basic", Font.BOLD, 18));
        lblAreaID.setForeground(Color.WHITE); // Set text color to white
		pnlUI.add(lblAreaID);

		cmbArea = new JComboBox();
		cmbArea.setBounds(120, 255, 180, 30);
		cmbArea.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(cmbArea);

		lblIndustryID = new JLabel(" Industry : ");
		lblIndustryID.setBounds(305, 255, 100, 30);
		lblIndustryID.setFont(new Font("Basic", Font.BOLD, 18));
        lblIndustryID.setForeground(Color.WHITE); // Set text color to white
		pnlUI.add(lblIndustryID);

		cmbIndustry = new JComboBox();
		cmbIndustry.setBounds(410, 255, 180, 30);
		cmbIndustry.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(cmbIndustry);

		lblEmailID = new JLabel(" Email id : ");
		lblEmailID.setBounds( 20 , 310 , 100 , 30 );
		lblEmailID.setFont(new Font("Basic", Font.BOLD, 18));
        lblEmailID.setForeground(Color.WHITE); // Set text color to white
		pnlUI.add(lblEmailID);

		txtEmailID = new JTextField();
		txtEmailID.setBounds( 120 , 310 , 180 , 30 );
		txtEmailID.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(txtEmailID);

		lblContactNo = new JLabel(" Contact No : ");
		lblContactNo.setBounds( 305 , 310 , 120 , 30 );
		lblContactNo.setFont(new Font("Basic", Font.BOLD, 18));
        lblContactNo.setForeground(Color.WHITE); // Set text color to white
		pnlUI.add(lblContactNo);

		txtContactNo = new JTextField();
		txtContactNo.setBounds( 435 , 310 , 180 , 30 );
		txtContactNo.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(txtContactNo);


		bst = new ButtonState();
		cbm = new clsButtonManagement();
		automateButtons();
		bst.setButtonState(ButtonState.InitialState);
		cbm.showButtonsOnUI(bst);

		createReport();
		chbVillage.addActionListener(this);
		addCountryRecords(cmbCountry);
		addIndustryRecords(cmbIndustry);

		show();

	}

	void automateButtons()
	{
		cbm.manageNewPanel(pnlNew);
		cbm.manageViewPanel(pnlView);
		cbm.manageUIPanel(pnlUI);
		cbm.manageUIReportPanel(pnlUIReport);
		cbm.manageSavePanel(pnlSave);
		cbm.manageViewPanel(pnlView);
		cbm.manageEditPanel(pnlEdit);
		cbm.manageUpdatePanel(pnlUpdate);
		cbm.manageDeletePanel(pnlDelete);
		cbm.manageCancelPanel(pnlCancel);
		cbm.manageReportPanel(pnlReport);
		cbm.manageApplyPanel(pnlApply);
		cbm.manageCombo1Panel(pnlClientUpdate);
		cbm.manageCombo1(cmbClientUpdate);
		cbm.manageClosePanel(pnlClose);

	}

	void setDefaultOperation()
	{
		PanelState.enabledComponents(pnlNew);
		PanelState.enabledComponents(pnlView);
		PanelState.enabledComponents(pnlReport);
		PanelState.disabledComponents(pnlUI);
	}

	void initUI()
	{
		txtClientID.setText("0");
		txtClientName.setText("");
		txtClientName.requestFocus();
		txtAddress.setText("");
		txtEmailID.setText("");
		txtContactNo.setText("");

		cmbVillage.setEnabled(false);
		cmbIndustry.setSelectedItem("Select Industry  ...");
		cmbCountry.setSelectedItem("Select Country ...");
		cmbState.setSelectedItem("Select State ...");
		cmbDistrict.setSelectedItem("Select District ...");
		cmbTaluka.setSelectedItem("Select Taluka ...");
		cmbArea.setSelectedItem("Select  Area...");
	}

	clsClient readUI()
	{
		clsClient temp = new clsClient();
		temp.setClientID(Integer.parseInt(txtClientID.getText()));
		temp.setClientName(txtClientName.getText());


		temp.setAddress(txtAddress.getText());

		if(chbVillage.isSelected())
			temp.setVillagian(1);
		else
			temp.setVillagian(0);


		temp.setContactNo(txtContactNo.getText());
		temp.setEmailID(txtEmailID.getText());
		temp.setAreaID(vAreaID);
		temp.setIndustryID(vIndustryID);
		return(temp);
	}

	void writeUI(clsClient temp)
	{
		txtClientID.setText(String.valueOf(temp.getClientID()));
		txtClientName.setText(temp.getClientName());
		txtAddress.setText(temp.getAddress());
		txtContactNo.setText(String.valueOf(temp.getContactNo()));
		txtEmailID.setText(temp.getEmailID());
		String IndustryN = clsIndustry.getNameFromID(temp.getIndustryID());
		cmbIndustry.setSelectedItem(IndustryN);


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
		Rcols+=tool.addNewColumn("ClientID");
		Rcols+=tool.addNewColumn("Name");
		Rcols+=tool.addNewColumn("Address");
		Rcols+=tool.addNewColumn("AreaID");
		Rcols+=tool.addNewColumn("ContactNo");
		Rcols+=tool.addNewColumn("EmailID");
		Rcols+=tool.addNewColumn("IndustryID");
		Rcols+=tool.addNewColumn("Villagian");

	}

	void setColumnsAlignment()
	{
		tool.setColumnAlignment(0,ReportTool.ALIGN_CENTER);
		tool.setColumnAlignment(1,ReportTool.ALIGN_CENTER);
		tool.setColumnAlignment(2,ReportTool.ALIGN_CENTER);
		tool.setColumnAlignment(3,ReportTool.ALIGN_CENTER);
		tool.setColumnAlignment(4,ReportTool.ALIGN_CENTER);
		tool.setColumnAlignment(5,ReportTool.ALIGN_CENTER);
		tool.setColumnAlignment(6,ReportTool.ALIGN_CENTER);
		tool.setColumnAlignment(7,ReportTool.ALIGN_CENTER);
	}

	void setColumnsWidth()
	{
		tool.setColumnWidth("ClientID",70);
		tool.setColumnWidth("Name",200);
		tool.setColumnWidth("Address",200);
		tool.setColumnWidth("AreaID",100);
		tool.setColumnWidth("ContactNo",100);
		tool.setColumnWidth("EmailID",200);
		tool.setColumnWidth("IndustryID",100);
		tool.setColumnWidth("Villagian",80);

	}

	void setColumnsData()
	{

		tool.removeAllRows();

		clsClient Data[]=clsClient.getAllClientInformation();

		for(int i=0;i<Data.length;i++)
		{
			Object Objectdata[]=new Object[Rcols];

			Objectdata[0]=i+1;
			Objectdata[1]=Data[i].getClientName();
			Objectdata[2]=Data[i].getAddress();
			Objectdata[3]=Data[i].getAreaID();
			Objectdata[4]=Data[i].getContactNo();
			Objectdata[5]=Data[i].getEmailID();
			Objectdata[6]=Data[i].getIndustryID();
			Objectdata[7]=Data[i].getVillagian();


			tool.addNewRow(Objectdata);
		}
	}

	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==btnNew)
		{
			initUI();
			bst.setButtonState(ButtonState.NewState);
			cbm.showButtonsOnUI(bst);
		}
		else if(ae.getSource() == btnView)
		{
			bst.setButtonState(ButtonState.ViewState);
			cbm.showButtonsOnUI(bst);
			addClientRecords(cmbClientUpdate);
		}
		else if(ae.getSource() == btnSave)
		{
			clsClient temp = readUI();
			clsClient.addNewClient(temp);

			//JOptionPane.showMessageDialog(null,"Client Added Successfully....!");
			bst.setButtonState(ButtonState.SaveState);
			cbm.showButtonsOnUI(bst);
			initUI();
			/*if(clsClient.isClientDulplicate(temp.getClientName()))
			{

			}
			else
			{
				bst.setButtonState(ButtonState.SaveState);
				cbm.showButtonsOnUI(bst);
				clsClient.addNewClient(temp);
				JOptionPane.showMessageDialog(null,"Client Added Successfully....!");
			}*/
		}
		else if(ae.getSource() == btnApply)
		{
			if(cmbClientUpdate.getSelectedIndex() == 0)
			{
				//JOptionPane.showMessageDialog(null,"Please Select Client Property....!");
			}
			else
			{
				String mClientName = (String)cmbClientUpdate.getSelectedItem();
				int mClientID = clsClient.getIDFromName(mClientName);
				clsClient temp=clsClient.getClientInformation(mClientID);
				writeUI(temp);

				bst.setButtonState(ButtonState.ApplyState);
				cbm.showButtonsOnUI(bst);
			}


		}
		else if(ae.getSource() == btnEdit)
		{
			bst.setButtonState(ButtonState.EditState);
			cbm.showButtonsOnUI(bst);
		}
		else if(ae.getSource() == btnUpdate)
		{
			bst.setButtonState(ButtonState.UpdateState);
			cbm.showButtonsOnUI(bst);

			clsClient temp = readUI();
			clsClient.updateClient(temp);
			PanelState.disabledComponents(pnlUI);
			//JOptionPane.showMessageDialog(null,"Client Updated Successfully....!");
		}
		else if(ae.getSource() == btnDelete)
		{
			bst.setButtonState(ButtonState.DeleteState);
			cbm.showButtonsOnUI(bst);
			clsClient temp = readUI();
			clsClient.deleteClient(temp);
			//JOptionPane.showMessageDialog(null,"Client Deleted Successfully....!");
		}
		else if(ae.getSource() == btnCancel)
		{
			bst.setButtonUniqueState(ButtonState.CancelState);
			cbm.showButtonsOnUI(bst);
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

		else if(ae.getSource() == cmbCountry)
		{
			if(cmbCountry.getSelectedIndex() == 0)
			{
				//JOptionPane.showMessageDialog(null,"Please Select Country Property....!");
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
				//JOptionPane.showMessageDialog(null,"Please Select State Property....!");
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
			if(cmbDistrict.getSelectedIndex() == 0)
			{
				//JOptionPane.showMessageDialog(null,"Please Select District Property....!");
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
			if(cmbTaluka.getSelectedIndex() == 0)
			{
				//JOptionPane.showMessageDialog(null,"Please Select Taluka Property....!");
			}
			else
			{
				String mTalukaName = (String)cmbTaluka.getSelectedItem();
				vTalukaID = clsTaluka.getIDFromName(mTalukaName);
				addTalukaAreaRecords(cmbArea,vTalukaID);
			}
		}
		else if(ae.getSource() == cmbVillage)
		{
			if(cmbVillage.getSelectedIndex() == 0)
			{
				//JOptionPane.showMessageDialog(null,"Please Select Village Property....!");
			}
			else
			{
				String mVillageName = (String)cmbVillage.getSelectedItem();
				int mVillageID = clsVillage.getIDFromName(mVillageName);
				addVillageAreaRecords(cmbArea,mVillageID);
			}
		}
		else if(ae.getSource() == chbVillage)
		{
				// test
				if(chbVillage.isSelected())
				{
					addVillageRecords(cmbVillage,vTalukaID);
					cmbVillage.setEnabled(true);
					vVillagian=1;
				}
				else
				{
					addTalukaAreaRecords(cmbArea,vTalukaID);
					cmbVillage.setEnabled(false);
					vVillagian=1;
				}
		}
		else if(ae.getSource() == cmbIndustry)
		{
			if(cmbIndustry.getSelectedIndex() == 0)
			{
				//JOptionPane.showMessageDialog(null,"Please Select Industry Property....!");
			}
			else
			{
				String mIndustryName = (String)cmbIndustry.getSelectedItem();
				vIndustryID = clsIndustry.getIDFromName(mIndustryName);
			}
		}
		else if(ae.getSource() == cmbArea)
		{
			if(cmbArea.getSelectedIndex() == 0)
			{
				//JOptionPane.showMessageDialog(null,"Please Select Industry Property....!");
			}
			else
			{
				String mAreaName = (String)cmbArea.getSelectedItem();

				if(chbVillage.isSelected()==true)
				{
					vAreaID = clsVillageArea.getIDFromName(mAreaName);
				}
				else
				{
					vAreaID = clsTalukaArea.getIDFromName(mAreaName);
				}
			}
		}

	}



	void addIndustryRecords(JComboBox temp)
	{
		temp.removeActionListener(this);
		clsIndustry.addIndustryRecords(temp);
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
		temp.removeActionListener(this);
		clsState.addStateRecords(temp,mCountryID);
		temp.addActionListener(this);
	}
	void addDistrictRecords(JComboBox temp,int mStateID)
	{
		temp.removeActionListener(this);
		clsDistrict.addDistrictRecords(temp,mStateID);
		temp.addActionListener(this);
	}
	void addTalukaRecords(JComboBox temp,int mDistrictID)
	{
		temp.removeActionListener(this);
		clsTaluka.addTalukaRecords(temp,mDistrictID);
		temp.addActionListener(this);
	}
	void addVillageRecords(JComboBox temp,int mTalukaID)
	{
		temp.removeActionListener(this);
		clsVillage.addVillageRecords(temp,mTalukaID);
		temp.addActionListener(this);
	}
	void addTalukaAreaRecords(JComboBox temp,int mTalukaID)
	{
		temp.removeActionListener(this);
		clsTalukaArea.addAreaRecords(temp,mTalukaID);
		temp.addActionListener(this);
	}
	void addVillageAreaRecords(JComboBox temp,int mVillageID)
	{
		temp.removeActionListener(this);
		clsVillageArea.addAreaRecords(temp,mVillageID);
		temp.addActionListener(this);
	}

	void addClientRecords(JComboBox temp)
	{
		clsClient.addClientRecords(temp);
	}

	public static void main(String args[])
	{
		frmClient F = new frmClient();
	}
}