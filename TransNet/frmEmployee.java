import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import screensetting.*;
import myUtility.*;
import ReportUtility.*;

class frmEmployee extends JFrame implements ActionListener
{
	JPanel pnlUI;
	JPanel pnlUIReport;
	JPanel pnlEmployeeUpdate;

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

	JLabel lblEmployeeID ;
	JLabel lblEmployeeName;
	JLabel lblAddress;
	JLabel lblAge;
	JLabel lblContactNo;
	JLabel lblEmailID;
	JLabel lblDesignationID;
	JLabel lblGender;
	JLabel lblAreaID;
	JLabel lblBillaNo;
	JLabel lblLicenceNo;
	JLabel lblPinCode;
	JLabel lblCity;

	JLabel lblEmployeeUpdate;
	JComboBox cmbEmployeeUpdate;

	JComboBox cmbCountry;
	JComboBox cmbState;
	JComboBox cmbDistrict;
	JComboBox cmbTaluka;
	JComboBox cmbArea;
	JComboBox cmbDesignation;
	JComboBox cmbVillage;

	JCheckBox chbVillage;

	JTextField txtClientID;
	JTextField txtEmployeeName;
	JTextField txtAddress;
	JTextField txtAge;
	JTextField txtContactNo;
	JTextField txtEmailID;
	JTextField txtGender;
	JTextField txtAreaID;
	JTextField txtBillaNo;
	JTextField txtLicenceNo;
	JTextField txtPinCode;

	ButtonGroup g1;
	JRadioButton rbMale;
	JRadioButton rbFemale;

	int Rcols;
	ReportTool tool;

	ButtonState bst;
	clsButtonManagement cbm;

	int vDesignationID=0;
	int vAreaID=0;
	int vVillagian=0;
	int vTalukaID=0;

	public frmEmployee()
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
		UISetting.setArea(pnlUI,1000,390);

		pnlUIReport = myUI.getUIReportPanel();
		UISetting.setArea(pnlUIReport,1200,590);

		tool = new ReportTool(1000,500);
		tool.setBounds(10,10,1200,590);
		pnlUIReport.add(tool);

		pnlNew = myUI.getNewPanel();
		btnNew = myUI.getNewButton();
		btnNew.addActionListener(this);

		pnlSave = myUI.getSavePanel();
		btnSave = myUI.getSaveButton();
		btnSave.addActionListener(this);

		pnlCancel = myUI.getCancelPanel();
		btnCancel = myUI.getCancelButton();
		btnCancel.addActionListener(this);

		lblEmployeeUpdate = myUI.getlblCombo1();

		pnlEmployeeUpdate = myUI.getCombo1Panel();
		cmbEmployeeUpdate = myUI.getcmbCombo1();
		cmbEmployeeUpdate.addActionListener(this);

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

		//pnlUIReport = myUI.getUIReportPanel();

		lblProgramHeading = myUI.getlblProgramHeading();
		lblProgramHeading.setText("Employee Information");
		new BlinkLabel(lblProgramHeading,800).start();


		int y=20;
		int h=30;
		int gap=5;

		lblEmployeeID = new JLabel("ID : ");
		lblEmployeeID.setLayout(null);
		lblEmployeeID.setBounds(20,y,130,h);
		lblEmployeeID.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(lblEmployeeID);

		txtClientID = new JTextField();
		txtClientID.setLayout(null);
		txtClientID.setBounds(200,y,100,h);
		txtClientID.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(txtClientID);


		y=y+h+gap;

		lblEmployeeName = new JLabel("Name : ");
		lblEmployeeName.setLayout(null);
		lblEmployeeName.setBounds(20,y,200,h);
		lblEmployeeName.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(lblEmployeeName);

		txtEmployeeName = new JTextField();
		txtEmployeeName.setLayout(null);
		txtEmployeeName.setBounds(200,y,500,h);
		txtEmployeeName.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(txtEmployeeName);

		lblGender = new JLabel(" Gender :");
		lblGender.setLayout(null);
		lblGender.setBounds(705,y,200,h);
		lblGender.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(lblGender);

		/*Gender RadioButton Here*/
		g1=new ButtonGroup();

		rbMale=new JRadioButton("Male");
		rbMale.setBounds(800,y,80,h);
		rbMale.setFont(new Font("Basic", Font.BOLD, 18));
		g1.add(rbMale);

		pnlUI.add(rbMale);

		rbFemale=new JRadioButton("Female");
		rbFemale.setBounds(880,y,100,h);
		rbFemale.setFont(new Font("Basic", Font.BOLD, 18));
		g1.add(rbFemale);

		pnlUI.add(rbFemale);

		y=y+h+gap;

		lblAddress = new JLabel(" Address : ");
		lblAddress.setLayout(null);
		lblAddress.setBounds(20,y,200,h);
		lblAddress.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(lblAddress);

		txtAddress = new JTextField();
		txtAddress.setLayout(null);
		txtAddress.setBounds(200,y,770,50);
		txtAddress.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(txtAddress);

		y=25+y+h+gap;

		lblCity = new JLabel("City : ");
		lblCity.setLayout(null);
		lblCity.setBounds(20,y,200,h);
		lblCity.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(lblCity);

		cmbCountry=new JComboBox();
		cmbCountry.setBounds(200,y,175,40);
		cmbCountry.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(cmbCountry);
		cmbCountry.addActionListener(this);

		cmbState=new JComboBox();
		cmbState.setBounds(400,y,175,40);
		cmbState.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(cmbState);

		cmbDistrict=new JComboBox();
		cmbDistrict.setBounds(600,y,175,40);
		cmbDistrict.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(cmbDistrict);

		cmbTaluka=new JComboBox();
		cmbTaluka.setBounds(800,y,175,40);
		cmbTaluka.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(cmbTaluka);

		y=15+y+h+gap;

		chbVillage=new JCheckBox("Are you Villagian ?");
		chbVillage.setBounds(200,y,200,40);
		chbVillage.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(chbVillage);

		cmbVillage=new JComboBox();
		cmbVillage.setBounds(400,y,175,40);
		cmbVillage.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(cmbVillage);

		y=15+y+h+gap;

		lblAreaID = new JLabel(" Area : ");
		lblAreaID.setLayout(null);
		lblAreaID.setBounds(20,y,100,40);
		lblAreaID.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(lblAreaID);

		cmbArea=new JComboBox();
		cmbArea.setBounds(200,y,175,40);
		cmbArea.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(cmbArea);

		lblPinCode = new JLabel(" Pin Code : ");
		lblPinCode.setLayout(null);
		lblPinCode.setBounds(400,y,120,h);
		lblPinCode.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(lblPinCode);

		txtPinCode = new JTextField();
		txtPinCode.setLayout(null);
		txtPinCode.setBounds(520,y,100,h);
		txtPinCode.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(txtPinCode);

		lblDesignationID = new JLabel(" Designation : ");
		lblDesignationID.setLayout(null);
		lblDesignationID.setBounds(640,y,200,h);
		lblDesignationID.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(lblDesignationID);

		cmbDesignation = new JComboBox();
		cmbDesignation.setBounds(800,y,175,40);
		cmbDesignation.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(cmbDesignation);

		y=15+y+h+gap;


		lblContactNo = new JLabel(" Contact No : ");
		lblContactNo.setLayout(null);
		lblContactNo.setBounds(20,y,175,h);
		lblContactNo.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(lblContactNo);

		txtContactNo = new JTextField();
		txtContactNo.setLayout(null);
		txtContactNo.setBounds(200,y,175,h);
		txtContactNo.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(txtContactNo);


		lblAge = new JLabel(" Age : ");
		lblAge.setLayout(null);
		lblAge.setBounds(400,y,200,h);
		lblAge.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(lblAge);

		txtAge = new JTextField();
		txtAge.setLayout(null);
		txtAge.setBounds(520,y,100,h);
		txtAge.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(txtAge);

		lblBillaNo = new JLabel(" Billa No : ");
		lblBillaNo.setLayout(null);
		lblBillaNo.setBounds(640,y,200,h);
		lblBillaNo.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(lblBillaNo);

		txtBillaNo = new JTextField();
		txtBillaNo.setLayout(null);
		txtBillaNo.setBounds(800,y,175,h);
		txtBillaNo.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(txtBillaNo);

		y=y+h+gap;


		lblLicenceNo = new JLabel("DrivingLicence No :");
		lblLicenceNo.setBounds(22, 370, 200, h); // Example - Adjust as needed
		lblLicenceNo.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(lblLicenceNo);

		txtLicenceNo = new JTextField();
		txtLicenceNo.setBounds(200, 370, 250, h); // Example - Adjust as needed
		txtLicenceNo.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(txtLicenceNo);

		lblEmailID = new JLabel(" Email ID : ");
		lblEmailID.setLayout(null);
		lblEmailID.setBounds(520,370,270,h);
		lblEmailID.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(lblEmailID);

		txtEmailID = new JTextField();
		txtEmailID.setLayout(null);
		txtEmailID.setBounds(640,370,335,h);
		txtEmailID.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(txtEmailID);


		bst = new ButtonState();
		cbm = new clsButtonManagement();
		automateButtons();
		bst.setButtonState(ButtonState.InitialState);
		cbm.showButtonsOnUI(bst);

		createReport();
		chbVillage.addActionListener(this);
		addCountryRecords(cmbCountry);
		addDesignationRecords(cmbDesignation);
		//addStateRecords(cmbState);
		//addCountryRecords(cmbCountry);
		//addCountryRecords(cmbCountry);


		setVisible(true);

	}

	void automateButtons()
	{
		cbm.manageNewPanel(pnlNew);
		cbm.manageViewPanel(pnlView);
		cbm.manageUIPanel(pnlUI);
		cbm.manageUIReportPanel(pnlUIReport);
		//cbm.manageEntryPanel(pnlEntry);
		//cbm.manageDataReportPanel(pnlDataReport);
		cbm.manageSavePanel(pnlSave);
		cbm.manageViewPanel(pnlView);
		cbm.manageEditPanel(pnlEdit);
		cbm.manageUpdatePanel(pnlUpdate);
		cbm.manageDeletePanel(pnlDelete);
		cbm.manageCancelPanel(pnlCancel);
		cbm.manageReportPanel(pnlReport);
		cbm.manageApplyPanel(pnlApply);
		//cbm.manageCombo1Label(lblEmployeeUpdate);
		cbm.manageCombo1Panel(pnlEmployeeUpdate);
		cbm.manageCombo1(cmbEmployeeUpdate);
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
		txtEmployeeName.setText("");
		txtEmployeeName.requestFocus();
		cmbVillage.setEnabled(false);
		//chbVillage.setVisible(false);
	}

	clsEmployee readUI()
	{
		clsEmployee temp = new clsEmployee();
		temp.setEmployeeID(Integer.parseInt(txtClientID.getText()));
		temp.setEmployeeName(txtEmployeeName.getText());

		if(rbMale.isSelected())
			temp.setGender(1);
		else
			temp.setGender(0);

		temp.setAddress(txtAddress.getText());

//     if(chbVillage.isSelected())
//        temp.setVillagian(1);
//     else
//        temp.setVillagian(0);

		temp.setContactNo(Integer.parseInt(txtContactNo.getText()));
		temp.setBillaNo(Integer.parseInt(txtBillaNo.getText()));
		temp.setLicenceNo(txtLicenceNo.getText());
		temp.setEmailID(txtEmailID.getText());
		temp.setAge(Integer.parseInt(txtAge.getText()));
		temp.setAreaID(vAreaID);
		temp.setDesignationID(vDesignationID);
		return(temp);
	}

	void writeUI(clsEmployee temp)
	{
		txtClientID.setText(String.valueOf(temp.getEmployeeID()));
		txtEmployeeName.setText(temp.getEmployeeName());
		txtAddress.setText(temp.getAddress());
		txtAge.setText(String.valueOf(temp.getAge()));
		txtContactNo.setText(String.valueOf(temp.getContactNo()));
		txtEmailID.setText(temp.getEmailID());
		txtBillaNo.setText(String.valueOf(temp.getBillaNo()));
		txtLicenceNo.setText(temp.getLicenceNo());

		if(temp.getGender() == 1)
			rbMale.setSelected(true);
		else
			rbFemale.setSelected(true);
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
		Rcols+=tool.addNewColumn("EmployeeID");
		Rcols+=tool.addNewColumn("Name");
		Rcols+=tool.addNewColumn("Address");
		Rcols+=tool.addNewColumn("AreaID");
		Rcols+=tool.addNewColumn("Age");
		Rcols+=tool.addNewColumn("Gender");
		Rcols+=tool.addNewColumn("ContactNo");
		Rcols+=tool.addNewColumn("EmailID");
		Rcols+=tool.addNewColumn("DesignationID");
		Rcols+=tool.addNewColumn("BillaNo");
		Rcols+=tool.addNewColumn("LicenceNo");
	}

	void setColumnsAlignment()
	{
		tool.setColumnAlignment(0,ReportTool.ALIGN_CENTER);
		tool.setColumnAlignment(1,ReportTool.ALIGN_CENTER);
	}

	void setColumnsWidth()
	{
		tool.setColumnWidth("EmployeeID",80);
		tool.setColumnWidth("Name",600);
		tool.setColumnWidth("Address",600);
		tool.setColumnWidth("AreaID",200);
		tool.setColumnWidth("Age",100);
		tool.setColumnWidth("Gender",100);
		tool.setColumnWidth("ContactNo",250);
		tool.setColumnWidth("EmailID",300);
		tool.setColumnWidth("DesignationID",200);
		tool.setColumnWidth("BillaNo",200);
		tool.setColumnWidth("LicenceNo",250);
	}

	void setColumnsData()
	{

		tool.removeAllRows();

		clsEmployee Data[]=clsEmployee.getAllEmployeeInformation();

		for(int i=0;i<Data.length;i++)
		{
			Object Objectdata[]=new Object[Rcols];

			Objectdata[0]=Data[i].getEmployeeID();
			Objectdata[1]=Data[i].getEmployeeName();
			Objectdata[2]=Data[i].getAddress();
			Objectdata[3]=Data[i].getAreaID();
			Objectdata[4]=Data[i].getAge();
			Objectdata[5]=Data[i].getGender();
			Objectdata[6]=Data[i].getContactNo();
			Objectdata[7]=Data[i].getEmailID();
			Objectdata[8]=Data[i].getDesignationID();
			Objectdata[9]=Data[i].getBillaNo();
			Objectdata[10]=Data[i].getLicenceNo();


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
			addEmployeeRecords(cmbEmployeeUpdate);
		}
		else if(ae.getSource() == btnSave)
		{
			clsEmployee temp = readUI();
			clsEmployee.showEmployee(temp);
			clsEmployee.addNewEmployee(temp);

			JOptionPane.showMessageDialog(null,"Entered Employee Already Exist......! ");

          /*if(clsEmployee.isEmployeeDulplicate(temp.getEmployeeName()))
          {

          }
          else
          {
             bst.setButtonState(ButtonState.SaveState);
             cbm.showButtonsOnUI(bst);
             clsEmployee.addNewEmployee(temp);
             JOptionPane.showMessageDialog(null,"Employee Added Successfully....!");
          }*/
		}
		else if(ae.getSource() == btnApply)
		{
			if(cmbEmployeeUpdate.getSelectedIndex() == 0)
			{
				JOptionPane.showMessageDialog(null,"Please Select Employee Property....!");
			}
			else
			{
				String mEmployeeName = (String)cmbEmployeeUpdate.getSelectedItem();
				int mEmployeeID = clsEmployee.getIDFromName(mEmployeeName);
				clsEmployee temp=clsEmployee.getEmployeeInformation(mEmployeeID);
				clsEmployee.showEmployee(temp);
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

			clsEmployee temp = readUI();
			clsEmployee.updateEmployee(temp);
			PanelState.disabledComponents(pnlUI);
			JOptionPane.showMessageDialog(null,"Employee Updated Successfully....!");
		}
		else if(ae.getSource() == btnDelete)
		{
			bst.setButtonState(ButtonState.DeleteState);
			cbm.showButtonsOnUI(bst);
			clsEmployee temp = readUI();
			clsEmployee.deleteEmployee(temp);
			JOptionPane.showMessageDialog(null,"Employee Deleted Successfully....!");
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
				JOptionPane.showMessageDialog(null,"Please Select Country Property....!");
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
				JOptionPane.showMessageDialog(null,"Please Select State Property....!");
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
				JOptionPane.showMessageDialog(null,"Please Select District Property....!");
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
				JOptionPane.showMessageDialog(null,"Please Select Taluka Property....!");
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
				JOptionPane.showMessageDialog(null,"Please Select Village Property....!");
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
		else if(ae.getSource() == cmbDesignation)
		{
			if(cmbDesignation.getSelectedIndex() == 0)
			{
				JOptionPane.showMessageDialog(null,"Please Select Designation Property....!");
			}
			else
			{
				String mDesignationName = String.valueOf(cmbDesignation.getSelectedItem());
				try
				{
					vDesignationID = Integer.parseInt(mDesignationName);
				}
				catch(NumberFormatException e)
				{
					vDesignationID = 0;
				}
				System.out.println("Designation ID   : "+vDesignationID);
				System.out.println("Designation Name : "+mDesignationName);
			}
		}
		else if(ae.getSource() == cmbArea)
		{
			//System.out.println("\n\tStart : ");
			if(cmbArea.getSelectedIndex() == 0)
			{
				JOptionPane.showMessageDialog(null,"Please Select Designation Property....!");
			}
			else
			{
				String mAreaName = (String)cmbArea.getSelectedItem();

				System.out.println("\n\tArea Name  : "+mAreaName);

				if(chbVillage.isSelected()==true)
				{
					vAreaID = clsVillageArea.getIDFromName(mAreaName);
					System.out.println("\n\tVillage Area ID  : "+vAreaID);
				}
				else
				{
					vAreaID = clsAreaTaluka.getIDFromName(mAreaName);
					System.out.println("\n\tTaluka Area ID  : "+vAreaID);
				}
			}
		}

	}



	void addDesignationRecords(JComboBox temp)
	{
		temp.removeAllItems();
		temp.addItem("Select Designation ...");
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
		clsAreaTaluka.addAreaRecords(temp,mTalukaID);
		temp.addActionListener(this);
	}
	void addVillageAreaRecords(JComboBox temp,int mVillageID)
	{
		temp.removeActionListener(this);
		clsVillageArea.addAreaRecords(temp,mVillageID);
		temp.addActionListener(this);
	}

	void addEmployeeRecords(JComboBox temp)
	{
		clsEmployee.addEmployeeRecords(temp);
	}

	public static void main(String args[])
	{
		frmEmployee F = new frmEmployee();
	}
}