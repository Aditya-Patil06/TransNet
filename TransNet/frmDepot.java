import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import appsetting.*;
import screensetting.*;
import myUtility.*;
import ReportUtility.*;
import javax.swing.border.EmptyBorder; //New for Report

class frmDepot extends JFrame implements ActionListener
{
	JPanel pnlUI;
	JPanel pnlUIReport;
	JPanel pnlDepotUpdate;

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

	JLabel lblDepotID ;
	JLabel lblDepotName;
	JLabel lblAddress;
	JLabel lblContactNo;
	JLabel lblEmailID;
	JLabel lblContactPerson;
	JLabel lblPlaceID;
	JLabel lblCity;

	JLabel lblDepotUpdate;
	JComboBox cmbDepotUpdate;

	JComboBox cmbCountry;
	JComboBox cmbState;
	JComboBox cmbDistrict;
	JComboBox cmbTaluka;
	JComboBox cmbArea;
	JComboBox cmbVillage;

	JCheckBox chbVillage;

	JTextField txtDepotID;
	JTextField txtDepotName;
	JTextField txtAddress;
	JTextField txtContactNo;
	JTextField txtEmailID;
	JTextField txtPlaceID;
	JTextField txtContactPerson ;

	int Rcols;
	ReportTool tool;

	ButtonState bst;
	clsButtonManagement cbm;

	int vPlaceID=0;
	int vVillagian=0;
	int vTalukaID=0;
	// test
	frmDepot()
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
		UISetting.setArea(pnlUI,930,450);


		pnlUIReport = myUI.getUIReportPanel();
		pnlUIReport.setLayout(new BorderLayout());

		int padding = 10;
		pnlUIReport.setBorder(new EmptyBorder(padding, padding, padding, padding));

		UISetting.setArea(pnlUIReport, 1200, 600);
		tool = new ReportTool(1200, 500);
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

		lblDepotUpdate = myUI.getlblCombo1();

		pnlDepotUpdate = myUI.getCombo1Panel();
		cmbDepotUpdate = myUI.getcmbCombo1();
		cmbDepotUpdate.addActionListener(this);

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
		lblProgramHeading.setText("Depot Information");


		int y=20;
		int gap=5;

		lblDepotID = new JLabel("ID : ");
		lblDepotID.setLayout(null);
		lblDepotID.setBounds(20,20,130,30);
		lblDepotID.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(lblDepotID);

		txtDepotID = new JTextField();
		txtDepotID.setLayout(null);
		txtDepotID.setBounds(200,20,100,30);
		txtDepotID.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(txtDepotID);


		lblDepotName = new JLabel("Name : ");
		lblDepotName.setLayout(null);
		lblDepotName.setBounds(20,55,200,30);
		lblDepotName.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(lblDepotName);

		txtDepotName = new JTextField();
		txtDepotName.setLayout(null);
		txtDepotName.setBounds(200,55,500,30);
		txtDepotName.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(txtDepotName);

		lblAddress = new JLabel("Address : ");
		lblAddress.setLayout(null);
		lblAddress.setBounds(20,90,200,30);
		lblAddress.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(lblAddress);

		txtAddress = new JTextField();
		txtAddress.setLayout(null);
		txtAddress.setBounds(200,90,700,50);
		txtAddress.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(txtAddress);

		lblCity = new JLabel("City : ");
		lblCity.setLayout(null);
		lblCity.setBounds(20,150,200,30);
		lblCity.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(lblCity);

		cmbCountry=new JComboBox();
		cmbCountry.setBounds(200,150,150,40);
		cmbCountry.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(cmbCountry);
		cmbCountry.addActionListener(this);

		cmbState=new JComboBox();
		cmbState.setBounds(375,150,150,40);
		cmbState.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(cmbState);

		cmbDistrict=new JComboBox();
		cmbDistrict.setBounds(550,150,150,40);
		cmbDistrict.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(cmbDistrict);

		cmbTaluka=new JComboBox();
		cmbTaluka.setBounds(725,150,150,40);
		cmbTaluka.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(cmbTaluka);

		y=15+y+30+gap;

		chbVillage=new JCheckBox("Are you Villagian ?");
		chbVillage.setBounds(200,200,200,40);
		chbVillage.setFont(new Font("Basic", Font.BOLD, 18));
		chbVillage.setOpaque(false);
        chbVillage.setForeground(Color.WHITE); // Set text color to white
		pnlUI.add(chbVillage);

		cmbVillage=new JComboBox();
		cmbVillage.setBounds(400,200,150,40);
		cmbVillage.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(cmbVillage);

		lblPlaceID = new JLabel(" Place : ");
		lblPlaceID.setLayout(null);
		lblPlaceID.setBounds(20,250,100,40);
		lblPlaceID.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(lblPlaceID);

		cmbArea=new JComboBox();
		cmbArea.setBounds(200,250,150,40);
		cmbArea.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(cmbArea);

		lblContactPerson = new JLabel(" Contact Person : ");
		lblContactPerson.setLayout(null);
		lblContactPerson.setBounds(400,250,200,30);
		lblContactPerson.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(lblContactPerson);

		txtContactPerson = new JTextField();
		txtContactPerson.setLayout(null);
		txtContactPerson.setBounds(620,250,200,40);
		txtContactPerson.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(txtContactPerson);

		lblContactNo = new JLabel(" Contact No : ");
		lblContactNo.setLayout(null);
		lblContactNo.setBounds(20,300,175,30);
		lblContactNo.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(lblContactNo);

		txtContactNo = new JTextField();
		txtContactNo.setLayout(null);
		txtContactNo.setBounds(200,300,175,30);
		txtContactNo.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(txtContactNo);

		lblEmailID = new JLabel(" Email ID : ");
		lblEmailID.setLayout(null);
		lblEmailID.setBounds(400,300,270,30);
		lblEmailID.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(lblEmailID);

		txtEmailID = new JTextField();
		txtEmailID.setLayout(null);
		txtEmailID.setBounds(520,300,300,30);
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

		setLabelColorsInPnlUI();
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
		cbm.manageCombo1Panel(pnlDepotUpdate);
		cbm.manageCombo1(cmbDepotUpdate);
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
		txtDepotID.setText("0");
		txtDepotName.setText("");
		txtDepotName.requestFocus();
		cmbVillage.setEnabled(false);
		chbVillage.setSelected(false);
		txtAddress.setText("");
		txtContactNo.setText("");
		txtContactPerson.setText("");
		txtEmailID.setText("");


		cmbCountry.setSelectedItem("Select Country...");
		cmbState.setSelectedItem("Select State...");
		cmbDistrict.setSelectedItem("Select District...");
		cmbTaluka.setSelectedItem("Select Taluka...");
		cmbArea.setSelectedItem("Select Area...");
		cmbVillage.setSelectedItem("Select Village...");
		cmbDepotUpdate.setSelectedItem("Select Depot...");

    }

	clsDepot readUI()
	{
		clsDepot temp = new clsDepot();
		temp.setDepotID(Integer.parseInt(txtDepotID.getText()));
		temp.setDepotName(txtDepotName.getText());


		temp.setAddress(txtAddress.getText());

		if(chbVillage.isSelected())
			temp.setVillagian(1);
		else
			temp.setVillagian(0);


		temp.setContactNo(txtContactNo.getText());
		temp.setEmailID(txtEmailID.getText());
		temp.setPlaceID(vPlaceID);
		temp.setContactPerson(txtContactPerson.getText());
		return(temp);
	}

	void writeUI(clsDepot temp)
	{
		txtDepotID.setText(String.valueOf(temp.getDepotID()));
		txtDepotName.setText(temp.getDepotName());
		txtAddress.setText(temp.getAddress());
		txtContactNo.setText(String.valueOf(temp.getDepotID()));
		txtContactPerson.setText(temp.getContactPerson());
		txtEmailID.setText(temp.getEmailID());
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
		Rcols+=tool.addNewColumn("DepotID");
		Rcols+=tool.addNewColumn("Name");
		Rcols+=tool.addNewColumn("Address");
		Rcols+=tool.addNewColumn("Villagian");
		Rcols+=tool.addNewColumn("AreaName");
		Rcols+=tool.addNewColumn("DistrictName");
		Rcols+=tool.addNewColumn("ContactNo");
		Rcols+=tool.addNewColumn("EmailID");
		Rcols+=tool.addNewColumn("ContactPerson");

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
		tool.setColumnAlignment(8,ReportTool.ALIGN_CENTER);
	}

	void setColumnsWidth()
	{
		tool.setColumnWidth("DepotID",200);
		tool.setColumnWidth("Name",600);
		tool.setColumnWidth("Address",600);
		tool.setColumnWidth("AreaName",200);
		tool.setColumnWidth("DistrictName",200);
		tool.setColumnWidth("Villagian",200);
		tool.setColumnWidth("ContactNo",600);
		tool.setColumnWidth("EmailID",600);
		tool.setColumnWidth("ContactPerson",600);


	}

	void setColumnsData()
	{

		tool.removeAllRows();

		clsDepotReport Data[]=clsDepotReport.getAllDepotReportInformation();

		for(int i=0;i<Data.length;i++)
		{
			Object Objectdata[]=new Object[Rcols];

			Objectdata[0]=i+1;
			Objectdata[1]=Data[i].getDepotName();
			Objectdata[2]=Data[i].getAddress();
			Objectdata[3]=Data[i].getVillagian();
			Objectdata[4]=Data[i].getAreaName();
			Objectdata[5]=Data[i].getDistrictName();
			Objectdata[6]=Data[i].getContactNo();
			Objectdata[7]=Data[i].getEmailID();
			Objectdata[8]=Data[i].getContactPerson();


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
			addDepotRecords(cmbDepotUpdate);
		}
		else if(ae.getSource() == btnSave)
		{
			clsDepot temp = readUI();
			clsDepot.addNewDepot(temp);

			//JOptionPane.showMessageDialog(null,"Depot Added Successfully....!");

			/*if(clsDepot.isDepotDulplicate(temp.getDepotName()))
			{

			}
			else
			{
				bst.setButtonState(ButtonState.SaveState);
				cbm.showButtonsOnUI(bst);
				clsDepot.addNewDepot(temp);
				JOptionPane.showMessageDialog(null,"Depot Added Successfully....!");
			}*/
			bst.setButtonState(ButtonState.SaveState);
			cbm.showButtonsOnUI(bst);
			initUI();
		}
		else if(ae.getSource() == btnApply)
		{
			if(cmbDepotUpdate.getSelectedIndex() == 0)
			{
				//JOptionPane.showMessageDialog(null,"Please Select Depot Property....!");
			}
			else
			{
				String mDepotName = (String)cmbDepotUpdate.getSelectedItem();
				int mDepotID = clsDepot.getIDFromName(mDepotName);
				clsDepot temp=clsDepot.getDepotInformation(mDepotID);
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

			clsDepot temp = readUI();
			clsDepot.updateDepot(temp);
			PanelState.disabledComponents(pnlUI);
			//JOptionPane.showMessageDialog(null,"Depot Updated Successfully....!");
		}
		else if(ae.getSource() == btnDelete)
		{
			bst.setButtonState(ButtonState.DeleteState);
			cbm.showButtonsOnUI(bst);
			clsDepot temp = readUI();
			clsDepot.deleteDepot(temp);
			//JOptionPane.showMessageDialog(null,"Depot Deleted Successfully....!");
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
			//	JOptionPane.showMessageDialog(null,"Please Select Country Property....!");
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
			//	JOptionPane.showMessageDialog(null,"Please Select State Property....!");
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
			//	JOptionPane.showMessageDialog(null,"Please Select Taluka Property....!");
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
			//	JOptionPane.showMessageDialog(null,"Please Select Village Property....!");
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

		else if(ae.getSource() == cmbArea)
		{
			if(cmbArea.getSelectedIndex() == 0)
			{
			//	JOptionPane.showMessageDialog(null,"Please Select Industry Property....!");
			}
			else
			{
				String mAreaName = (String)cmbArea.getSelectedItem();

				if(chbVillage.isSelected()==true)
				{
					vPlaceID = clsVillageArea.getIDFromName(mAreaName);
					System.out.println("\n\tVillage Area ID  : "+vPlaceID);
				}
				else
				{
					vPlaceID = clsTalukaArea.getIDFromName(mAreaName);
					System.out.println("\n\tTaluka Area ID  : "+vPlaceID);
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


	void addDepotRecords(JComboBox temp)
	{
		clsDepot.addDepotRecords(temp);
	}
	private void setLabelColorsInPnlUI()
	{
	    lblDepotID.setForeground(Color.WHITE);
	    lblDepotName.setForeground(Color.WHITE);
	    lblAddress.setForeground(Color.WHITE);
	    lblCity.setForeground(Color.WHITE);
	    lblPlaceID.setForeground(Color.WHITE);
	    lblContactPerson.setForeground(Color.WHITE);
	    lblContactNo.setForeground(Color.WHITE);
	    lblEmailID.setForeground(Color.WHITE);
	}


	public static void main(String args[])
	{
		frmDepot F = new frmDepot();
	}
}