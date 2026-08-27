import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import appsetting.*;
import screensetting.*;
import myUtility.*;
import ReportUtility.*;
import javax.swing.border.EmptyBorder; //New for Report

class frmVehicle extends JFrame implements ActionListener
{
	JPanel pnlUI;
	JPanel pnlUIReport;
	JPanel pnlVehicleUpdate;

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

	JLabel lblVehicleID ;
	JTextField txtVehicleID;

	JLabel lblVehicleName;
	JTextField txtVehicleName;

	JLabel lblDescription ;
	JTextArea txtDescription ;

	JLabel lblContactPerson ;
	JTextField txtContactPerson;

	JLabel lblDriverName ;
	JTextField txtDriverName;

	JLabel lblLicenceNo;
	JTextField txtLicenceNo;

	JLabel lblVehicleUpdate;
	JComboBox cmbVehicleUpdate;

	JLabel lblVehicleTypeID;
	JComboBox cmbVehicleType;

	JLabel lblDepotID;
	JComboBox cmbDepot;

	JButton btnRefreshDoc	;
	JButton btnNewDoc		;


	int Rcols;
	ReportTool tool;

	ButtonState bst;
	clsButtonManagement cbm;

	int vDepotID=0;
	int vVehicleTypeID=0;

	frmVehicle()
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
		UISetting.setArea(pnlUI,800,280);

		pnlUIReport = myUI.getUIReportPanel();
		pnlUIReport.setLayout(new BorderLayout());

		int padding = 10;
		pnlUIReport.setBorder(new EmptyBorder(padding, padding, padding, padding));

		UISetting.setArea(pnlUIReport, 1000, 400);
		tool = new ReportTool(1000, 300);
		pnlUIReport.add(tool, BorderLayout.CENTER);

		pnlUIReport = myUI.getUIReportPanel();


		pnlNew = myUI.getNewPanel();
		btnNew = myUI.getNewButton();
		btnNew.addActionListener(this);

		pnlSave = myUI.getSavePanel();
		btnSave = myUI.getSaveButton();
		btnSave.addActionListener(this);

		pnlCancel = myUI.getCancelPanel();
		btnCancel = myUI.getCancelButton();
		btnCancel.addActionListener(this);

		lblVehicleUpdate = myUI.getlblCombo1();

		pnlVehicleUpdate = myUI.getCombo1Panel();
		cmbVehicleUpdate = myUI.getcmbCombo1();
		cmbVehicleUpdate.addActionListener(this);

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
		lblProgramHeading.setText("Vehicle Information");

		lblVehicleID = new JLabel("Vehicle ID :");
		lblVehicleID.setLayout(null);
		lblVehicleID.setBounds(60, 20, 120, 30);
		lblVehicleID.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(lblVehicleID);

		txtVehicleID = new JTextField();
		txtVehicleID.setLayout(null);
		txtVehicleID.setBounds(190, 20, 50, 30);
		txtVehicleID.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(txtVehicleID);

		lblDepotID = new JLabel("Depot Name : ");
		lblDepotID.setLayout(null);
		lblDepotID.setBounds(410, 20 , 150, 30);
		lblDepotID.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(lblDepotID);

		cmbDepot = new JComboBox();
		cmbDepot.setBounds(540, 20, 180, 30);
		cmbDepot.addItem("Select Depot ...");
		pnlUI.add(cmbDepot);


		lblVehicleName = new JLabel("Vehicle Number : ");
		lblVehicleName.setLayout(null);
		lblVehicleName.setBounds(20, 65, 200, 30);
		lblVehicleName.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(lblVehicleName);

		txtVehicleName = new JTextField();
		txtVehicleName.setLayout(null);
		txtVehicleName.setBounds(190, 65, 200, 30);
		txtVehicleName.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(txtVehicleName);

		lblDescription = new JLabel("Description : ");
		lblDescription.setLayout(null);
		lblDescription.setBounds(410, 65 , 120, 30);
		lblDescription.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(lblDescription);

		txtDescription = new JTextArea();
		txtDescription.setLayout(null);
		txtDescription.setBounds(540, 65 , 200, 30);
		txtDescription.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(txtDescription);

		lblContactPerson = new JLabel("Contact Person : ");
		lblContactPerson.setLayout(null);
		lblContactPerson.setBounds(410, 115 , 170, 30);
		lblContactPerson.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(lblContactPerson);

		txtContactPerson = new JTextField();
		txtContactPerson.setLayout(null);
		txtContactPerson.setBounds(560, 115 , 200, 30);
		txtContactPerson.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(txtContactPerson);

		lblVehicleTypeID = new JLabel("Vehicle Type Name");
		lblVehicleTypeID.setLayout(null);
		lblVehicleTypeID.setBounds(20, 115 , 200, 30);
		lblVehicleTypeID.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(lblVehicleTypeID);

		cmbVehicleType = new JComboBox();
		cmbVehicleType.setBounds(195, 115, 175, 30);
		cmbVehicleType.addItem("Select Vehicle Type ...");
		pnlUI.add(cmbVehicleType);

		btnNewDoc= new JButton(new ImageIcon("image1.png"));
		btnNewDoc.setBounds(375,115,30,30);
		btnNewDoc.setVisible(true);
		btnNewDoc.addActionListener(this);
		pnlUI.add(btnNewDoc);

		btnRefreshDoc = new JButton(new ImageIcon("RefreshImg1.png"));
		btnRefreshDoc.setBounds(375,115,30,30);
		btnRefreshDoc.setVisible(false);
		btnRefreshDoc.addActionListener(this);
		pnlUI.add(btnRefreshDoc);

		lblDriverName = new JLabel("Driver Name : ");
		lblDriverName.setLayout(null);
		lblDriverName.setBounds(20, 160 , 200, 30);
		lblDriverName.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(lblDriverName);

		txtDriverName = new JTextField();
		txtDriverName.setLayout(null);
		txtDriverName.setBounds(190, 160 , 200, 30);
		txtDriverName.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(txtDriverName);

		lblLicenceNo = new JLabel("Licence No : ");
		lblLicenceNo.setLayout(null);
		lblLicenceNo.setBounds(20, 200 , 200, 30);
		lblLicenceNo.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(lblLicenceNo);

		txtLicenceNo = new JTextField();
		txtLicenceNo.setLayout(null);
		txtLicenceNo.setBounds(190, 200 , 200, 30);
		txtLicenceNo.setFont(new Font("Basic", Font.BOLD, 18));
		pnlUI.add(txtLicenceNo);

		bst = new ButtonState();
		cbm = new clsButtonManagement();
		automateButtons();
		bst.setButtonState(ButtonState.InitialState);
		cbm.showButtonsOnUI(bst);

		createReport();

		 SwingUtilities.invokeLater(() -> { // Use invokeLater for thread safety
		            tool.setTablePreferredWidth();
        });

		addVehicleTypeRecords(cmbVehicleType);
		addDepotRecords(cmbDepot);
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
		cbm.manageCombo1Panel(pnlVehicleUpdate);
		cbm.manageCombo1(cmbVehicleUpdate);
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
		txtVehicleID.setText("0");
		txtVehicleName.setText("");
		txtVehicleName.requestFocus();
		txtDescription.setText("");
		txtContactPerson.setText("");
		txtDriverName.setText("");
		txtLicenceNo.setText("");
		cmbVehicleType.setSelectedIndex(0);
		cmbDepot.setSelectedIndex(0);

	}

	clsVehicle readUI()
	{
		clsVehicle temp = new clsVehicle();

		temp.setVehicleID(Integer.parseInt(txtVehicleID.getText()));
		temp.setVehicleNumber(txtVehicleName.getText());
		temp.setDescription(txtDescription.getText());
		temp.setContactPerson(txtContactPerson.getText());
		temp.setDriverName(txtDriverName.getText());
		temp.setLicenceNo(txtLicenceNo.getText());
		temp.setVehicleTypeID(vVehicleTypeID);
		temp.setDepotID(vDepotID);
		return(temp);
	}

	void writeUI(clsVehicle temp)
	{
		txtVehicleID.setText(String.valueOf(temp.getVehicleID()));
		txtVehicleName.setText(temp.getVehicleNumber());
		txtDescription.setText(temp.getDescription());
		txtContactPerson.setText(temp.getContactPerson());
		txtDriverName.setText(temp.getDriverName());
		txtLicenceNo.setText(temp.getLicenceNo());
		//cmbVehicleType.setSelectedItem(temp.getVehicleTypeID());
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
		Rcols+=tool.addNewColumn("Vehicle_ID");
		Rcols+=tool.addNewColumn("Name");
		Rcols+=tool.addNewColumn("Description");
		Rcols+=tool.addNewColumn("Contact_Person");
		Rcols+=tool.addNewColumn("Driver_Name");
		Rcols+=tool.addNewColumn("Licence_No");
		Rcols+=tool.addNewColumn("Vehicle_Type");
		Rcols+=tool.addNewColumn("Depot_Name");

	}
	void setColumnsWidth()
	{
		tool.setColumnWidth("Vehicle_ID",80);
		tool.setColumnWidth("Name",200);
		tool.setColumnWidth("Description",200);
		tool.setColumnWidth("Contact_Person",80);
		tool.setColumnWidth("Driver_Name",80);
		tool.setColumnWidth("Licence_No",80);
		tool.setColumnWidth("Vehicle_Type",100);
		tool.setColumnWidth("Depot_Name",200);
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

	void setColumnsData()
	{

		tool.removeAllRows();

		clsVehicleReport Data[]=clsVehicleReport.getAllVehicleReportInformation();

		for(int i=0;i<Data.length;i++)
		{
			Object Objectdata[]=new Object[Rcols];

			Objectdata[0]=i+1;
			Objectdata[1]=Data[i].getVehicleNumber();
			Objectdata[2]=Data[i].getDescription();
			Objectdata[3]=Data[i].getContactPerson();
			Objectdata[4]=Data[i].getDriverName();
			Objectdata[5]=Data[i].getLicenceNo();
			Objectdata[6]=Data[i].getVehicleTypeName();
			Objectdata[7]=Data[i].getDepotName();

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
			addVehicleRecords(cmbVehicleUpdate);
		}
		else if(ae.getSource() == btnSave)
		{
			clsVehicle temp = readUI();
			clsVehicle.addNewVehicle(temp);

			//JOptionPane.showMessageDialog(null,"Vehicle Added Successfully....!");

		}
		else if(ae.getSource() == btnApply)
		{
			if(cmbVehicleUpdate.getSelectedIndex() == 0)
			{
			//	JOptionPane.showMessageDialog(null,"Please Select Vehicle Property....!");
			}
			else
			{
				String mVehicleName = (String)cmbVehicleUpdate.getSelectedItem();
				int mVehicleID = clsVehicle.getIDFromName(mVehicleName);
				clsVehicle temp=clsVehicle.getVehicleInformation(mVehicleID);
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

			clsVehicle temp = readUI();
			clsVehicle.updateVehicle(temp);
			PanelState.disabledComponents(pnlUI);

		}
		else if(ae.getSource() == btnDelete)
		{
			bst.setButtonState(ButtonState.DeleteState);
			cbm.showButtonsOnUI(bst);
			clsVehicle temp = readUI();
			clsVehicle.deleteVehicle(temp);
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
		else if(ae.getSource() == cmbVehicleType)
		{

			if(cmbVehicleType.getSelectedIndex() == 0)
			{
				//JOptionPane.showMessageDialog(null,"Please Select Country Properly...");
			}
			else
			{
				String mVehicleType = (String)cmbVehicleType.getSelectedItem();
				vVehicleTypeID = clsVehicleType.getIDFromName(mVehicleType);
			}

		}
		else if(ae.getSource() == cmbDepot)
		{

			if(cmbVehicleType.getSelectedIndex() == 0)
			{
				//JOptionPane.showMessageDialog(null,"Please Select Country Properly...");
			}
			else
			{
				String mDepot = (String)cmbDepot.getSelectedItem();
				vDepotID = clsDepot.getIDFromName(mDepot);
			}

		}

		else if(ae.getSource()==btnNewDoc)
		{

			btnNewDoc.setVisible(false);
			btnRefreshDoc.setVisible(true);
			frmVehicleType A = new frmVehicleType();
		}
		else if(ae.getSource()==btnRefreshDoc)
		{

			btnNewDoc.setVisible(true);
			btnRefreshDoc.setVisible(false);
			addVehicleTypeRecords(cmbVehicleType);
		}
		/*else if(ae.getSource() == cmbVehicleUpdate)
		{

			if(cmbVehicleUpdate.getSelectedIndex() == 0)
			{
				//JOptionPane.showMessageDialog(null,"Please Select Country Properly...");
			}
			else
			{
				String mVehicleName = (String)cmbVehicleUpdate.getSelectedItem();
				int mVehicleID = clsVehicle.getIDFromName(mVehicleName);
				addVehicleRecords(cmbStateUpdate,mVehicleID);
			}
		}*/
	}
	void addVehicleRecords(JComboBox temp)
	{

		temp.removeActionListener(this);
		clsVehicle.addVehicleRecords(temp);
		temp.addActionListener(this);

	}
	void addVehicleTypeRecords(JComboBox temp)
	{
		temp.removeActionListener(this);
		clsVehicleType.addVehicleTypeRecords(temp);
		temp.addActionListener(this);
	}
	void addDepotRecords(JComboBox temp)
	{
		temp.removeActionListener(this);
		clsDepot.addDepotRecords(temp);
		temp.addActionListener(this);
	}

	private void setLabelColorsInPnlUI()
	{
		lblVehicleID.setForeground(Color.WHITE);
		lblDepotID.setForeground(Color.WHITE);
		lblVehicleName.setForeground(Color.WHITE);
		lblDescription.setForeground(Color.WHITE);
		lblContactPerson.setForeground(Color.WHITE);
		lblVehicleTypeID.setForeground(Color.WHITE);
		lblDriverName.setForeground(Color.WHITE);
		lblLicenceNo.setForeground(Color.WHITE);
	}
	public static void main(String args[])
	{
		frmVehicle F = new frmVehicle();
	}
}