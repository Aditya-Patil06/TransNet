import appsetting.*;
import myUtility.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import screensetting.*;
import ReportUtility.*;
import javax.swing.border.EmptyBorder; //New for Report

class frmState extends JFrame implements ActionListener
{

	ScreenDesign2 myUI			;

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
	JButton btnClose 			;

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
	JPanel pnlCountryUpdate 	;
	JPanel pnlStateUpdate		;
	JPanel pnlEdit				;
	JPanel pnlClose				;


	JLabel lblProgramHeading	;		//Labels
	JLabel lblProject			;
	JLabel lblStateID			;
	JLabel lblStateName 		;
	JLabel lblCountry 			;
	JLabel lblStateUpdate 		;
	JLabel lblCountryUpdate 	;

	JTextField txtStateID 		;		//TextFields
	JTextField txtStateName 	;

	JComboBox cmbStateUpdate	;		//ComboBox
	JComboBox cmbCountryUpdate	;
	JComboBox cmbCountry 		;

	ButtonState bst 			;		//Button Managments Class
	clsButtonManagement2 cbm 	;

	int Rcols = 0 				;		//Report Helper Class
	ReportTool tool				;

	int vCountryID = 0 			;

    frmState()
    {

		setTitle("New Project");
		setSize(1920,1080);
		setLayout(null);
		setLocation(0,0);

		myUI = new ScreenDesign2();		//ScreenDesing Initialisation
		add(myUI);
		setExtendedState(getExtendedState()|JFrame.MAXIMIZED_BOTH);

		pnlUI = myUI.getpnlUI();
		pnlUI.setLayout(null);
		UISetting.setArea(pnlUI,400,150);

		pnlUIReport = myUI.getpnlUIReport();
		pnlUIReport.setLayout(new BorderLayout());

		int padding = 10;
		pnlUIReport.setBorder(new EmptyBorder(padding, padding, padding, padding));

		UISetting.setArea(pnlUIReport, 800, 400);
		tool = new ReportTool(600, 300);
		pnlUIReport.add(tool, BorderLayout.CENTER);

		pnlNew = myUI.getNewPanel();
		btnNew = myUI.getNewButton();
		btnNew.addActionListener(this);

		pnlView = myUI.getViewPanel();
		btnView = myUI.getViewButton();
		btnView.addActionListener(this);

		pnlSave = myUI.getSavePanel();
		btnSave = myUI.getSaveButton();
		btnSave.addActionListener(this);

		pnlEdit = myUI.getEditPanel();
		btnEdit = myUI.getEditButton();
		btnEdit.addActionListener(this);

		pnlUpdate = myUI.getUpdatePanel();
		btnUpdate = myUI.getUpdateButton();
		btnUpdate.addActionListener(this);

		pnlDelete = myUI.getDeletePanel();
		btnDelete = myUI.getDeleteButton();
		btnDelete.addActionListener(this);

		pnlCancel = myUI.getCancelPanel();
		btnCancel = myUI.getCancelButton();
		btnCancel.addActionListener(this);

		pnlReport = myUI.getReportPanel();
		btnReport = myUI.getReportButton();
		btnReport.addActionListener(this);

		pnlClose = myUI.getClosePanel();
		btnClose= myUI.getCloseButton();
		btnClose.addActionListener(this);

		pnlApply = myUI.getApplyPanel();
		btnApply = myUI.getApplyButton();
		btnApply.addActionListener(this);

		pnlCountryUpdate = myUI.getCombo1Panel();
		lblCountryUpdate = myUI.getCombo1();
		lblCountryUpdate.setText("Country List ...");

		pnlStateUpdate = myUI.getCombo2Panel();
		lblStateUpdate = myUI.getCombo2();
		lblStateUpdate.setText("State List ...");

		lblProgramHeading = myUI.getlblProgramHeading();
		lblProgramHeading.setText("State Information ...");

		lblStateID = new JLabel("State ID : ");
        lblStateID.setBounds(15, 20, 150, 30);
        lblStateID.setFont(new Font("Aptos", Font.BOLD, 18));
        lblStateID.setForeground(Color.WHITE); // Set text color to white
        pnlUI.add(lblStateID);

        lblStateName = new JLabel("State Name : ");
        lblStateName.setBounds(15, 60, 150, 30);
        lblStateName.setFont(new Font("Aptos", Font.BOLD, 18));
        lblStateName.setForeground(Color.WHITE); // Set text color to white
        pnlUI.add(lblStateName);

        txtStateID = new JTextField();
        txtStateID.setBounds(170, 20, 50, 30);
        txtStateID.setFont(new Font("Aptos", Font.BOLD, 18));
        pnlUI.add(txtStateID);

        txtStateName = new JTextField();
        txtStateName.setBounds(170, 60, 210, 30);
        txtStateName.setFont(new Font("Aptos", Font.BOLD, 18));
        pnlUI.add(txtStateName);

        lblCountry = new JLabel("Country Name : ");
        lblCountry.setBounds(15, 100, 150, 30);
        lblCountry.setFont(new Font("Aptos", Font.BOLD, 18));
        lblCountry.setForeground(Color.WHITE); // Set text color to white
        pnlUI.add(lblCountry);

        cmbCountry = new JComboBox();
        cmbCountry.addItem("Select Country...");
        cmbCountry.setBounds(170, 100, 170, 30);
        pnlUI.add(cmbCountry);
        addCountryRecords(cmbCountry);

		btnNewDoc = new JButton(new ImageIcon("image1.png"));
		btnNewDoc.setBounds(350,100,30,30);
		btnNewDoc.setVisible(true);
		btnNewDoc.addActionListener(this);
		pnlUI.add(btnNewDoc);

		btnRefreshDoc = new JButton(new ImageIcon("RefreshImg1.png"));
		btnRefreshDoc.setBounds(350,100,30,30);
		btnRefreshDoc.setVisible(false);
		btnRefreshDoc.addActionListener(this);
		pnlUI.add(btnRefreshDoc);

		bst = new ButtonState();
		cbm = new clsButtonManagement2();
		automateButtons();
		bst.setButtonState(ButtonState.InitialState);
		cbm.showButtonsOnUI(bst);


		initUI();

		setDefaultOperation();

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

		txtStateID.setText("0");
		txtStateName.setText("");
		cmbCountry.setSelectedIndex(0);

	}

	public clsState readUI()
	{

		clsState temp = new clsState();
		temp.setStateID(Integer.parseInt(txtStateID.getText()));
		temp.setStateName(txtStateName.getText());
		temp.setCountryID(vCountryID);
		return temp ;

	}

	public void writeUI(clsState temp)
	{

		txtStateID.setText(String.valueOf(temp.getStateID()));
		txtStateName.setText(temp.getStateName());

		clsLocationManagement2 temp1 = clsLocationManagement2.getLocationInfo(temp.getStateID());
		vCountryID = temp1.getCountryID();
		cmbCountry.setSelectedItem(temp1.getCountryName());

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
		Rcols+=tool.addNewColumn("StateID");
		Rcols+=tool.addNewColumn("StateName");
		Rcols+=tool.addNewColumn("CountryName");


	}

	void setColumnsAlignment()
	{

		tool.setColumnAlignment(0,ReportTool.ALIGN_CENTER);
		tool.setColumnAlignment(1,ReportTool.ALIGN_CENTER);
		tool.setColumnAlignment(2,ReportTool.ALIGN_CENTER);


	}

	void setColumnsWidth()
	{

		tool.setColumnWidth("StateID",80);
		tool.setColumnWidth("StateName",200);
		tool.setColumnWidth("CountryName",200);

	}

	void setColumnsData()
	{

		tool.removeAllRows();

		clsStateReport1 Data[] = clsStateReport1.getStateReport1Info();

		for(int i=0;i<Data.length;i++)
		{
			Object Objectdata[]=new Object[Rcols];

			Objectdata[0]=i+1;
			Objectdata[1]=Data[i].getStateName();
			Objectdata[2]=Data[i].getCountryName();


			tool.addNewRow(Objectdata);
		}
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
		cbm.manageClosePanel(pnlClose);

		cbm.manageCombo1Panel(pnlCountryUpdate);
		cbm.manageCombo1(cmbCountryUpdate);

		cbm.manageCombo2Panel(pnlStateUpdate);
		cbm.manageCombo2(cmbStateUpdate);

	}

	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource() == btnNew)
		{

			bst.setButtonState(bst.NewState);
			cbm.showButtonsOnUI(bst) ;

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

			clsState temp = readUI();
			clsState.addNewState(temp);
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

			clsState temp = readUI();
			clsState.updateState(temp);
			initUI();

		}

		else if(ae.getSource() == btnDelete)
		{

			bst.setButtonState(bst.DeleteState);
			cbm.showButtonsOnUI(bst);

			clsState temp = readUI();
			clsState.deleteState(temp);
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
			//	JOptionPane.showMessageDialog(null,"Please Select State Properly...");
			}
			else
			{
				String mStateName = (String)cmbStateUpdate.getSelectedItem();
				int mStateID = clsState.getIDFromName(mStateName);
				clsState temp = clsState.getStateInformation(mStateID);
				writeUI(temp);

			}
		}

		else if(ae.getSource() == cmbCountry)
		{

			if(cmbCountry.getSelectedIndex() == 0)
			{
				//JOptionPane.showMessageDialog(null,"Please Select Country Properly...");
			}
			else
			{
				String mCountryName = (String)cmbCountry.getSelectedItem();
				vCountryID = clsCountry.getIDFromName(mCountryName);
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

		else if(ae.getSource()==btnNewDoc)
		{

			btnNewDoc.setVisible(false);
			btnRefreshDoc.setVisible(true);
			frmCountry A = new frmCountry();

		}

		else if(ae.getSource()==btnRefreshDoc)
		{

			btnNewDoc.setVisible(true);
			btnRefreshDoc.setVisible(false);
			addCountryRecords(cmbCountry);

		}

	}

	public static void main(String args[])
	{
		frmState f = new frmState();
	}
}