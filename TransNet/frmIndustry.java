import myUtility.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import screensetting.*;
import ReportUtility.*;
import javax.swing.border.EmptyBorder; //New for Report

public class frmIndustry extends JFrame implements ActionListener
{

	JLabel lblProgramHeading 	;//change
	JLabel lblIndustryID 		;
	JLabel lblIndustryName	 	;
	JLabel lblIndustryUpdate		;

	JTextField txtIndustryID 	;
	JTextField txtIndustryName 	;

	JPanel  pnlUI				;
	JPanel  pnlSave 			;
	JPanel  pnlDelete 			;
	JPanel  pnlUpdate 			;
	JPanel  pnlNew 				;
	JPanel  pnlView	 			;
	JPanel  pnlEdit 			;
	JPanel  pnlCancel 			;
	JPanel  pnlReport 			;
	JPanel  pnlApply 			;
	JPanel  pnlClose			;
	JPanel  pnlCombo1 			;
	JPanel  pnlUIReport 		;


	JButton btnSave 			;
	JButton btnDelete 			;
	JButton btnUpdate 			;
	JButton btnNew 				;
	JButton btnView 			;
	JButton btnEdit 			;
	JButton btnCancel 			;
	JButton btnReport 			;
	JButton btnClose 			;
	JButton btnApply 			;

	JComboBox cmbCombo1 	;

	ScreenDesign myUI			;

	ButtonState bst				;
	clsButtonManagement cbm		;

	int Rcols = 0 				;

	ReportTool tool				;


    public frmIndustry()
    {
		setTitle("New Project");
		setSize(1920,1080);
		setLayout(null);
		setLocation(0,0);

		myUI = new ScreenDesign();
		add(myUI);
		setExtendedState(getExtendedState()|JFrame.MAXIMIZED_BOTH);

		pnlUI = myUI.getUIPanel();
		pnlUI.setLayout(null);
		UISetting.setArea(pnlUI,400,130);


		pnlUIReport = myUI.getUIReportPanel();
		pnlUIReport.setLayout(new BorderLayout());

		int padding = 10;
		pnlUIReport.setBorder(new EmptyBorder(padding, padding, padding, padding));

		UISetting.setArea(pnlUIReport, 800, 400);
		tool = new ReportTool(600, 300);
		pnlUIReport.add(tool, BorderLayout.CENTER);


		pnlNew = myUI.getNewPanel();

		pnlView = myUI.getViewPanel();
		pnlSave = myUI.getSavePanel();
		pnlReport = myUI.getReportPanel();
		pnlClose = myUI.getClosePanel();
		pnlCancel = myUI.getCancelPanel();
		pnlDelete = myUI.getDeletePanel();
		pnlUpdate = myUI.getUpdatePanel();
		pnlEdit = myUI.getEditPanel();
		pnlCombo1 = myUI.getCombo1Panel();
		pnlUIReport = myUI.getUIReportPanel();
		pnlApply = myUI.getApplyPanel();

		btnApply = myUI.getApplyButton();
		btnApply.addActionListener(this);

		btnEdit = myUI.getEditButton();
		btnEdit.addActionListener(this);

		btnUpdate = myUI.getUpdateButton();
		btnUpdate.addActionListener(this);

		btnDelete = myUI.getDeleteButton();
		btnDelete.addActionListener(this);

		btnCancel = myUI.getCancelButton();
		btnCancel.addActionListener(this);

		btnNew = myUI.getNewButton();
		btnNew.addActionListener(this);

		btnView = myUI.getViewButton();
		btnView.addActionListener(this);

		btnSave = myUI.getSaveButton();
		btnSave.addActionListener(this);

		btnReport = myUI.getReportButton();
		btnReport.addActionListener(this);

		btnClose= myUI.getCloseButton();
		btnClose.addActionListener(this);


		cmbCombo1 = myUI.getcmbCombo1();
		cmbCombo1.addActionListener(this);

		lblIndustryUpdate = myUI.getlblCombo1();
		lblIndustryUpdate.setText("Industry List ... ");

		lblProgramHeading = myUI.getlblProgramHeading();

		lblIndustryID = new JLabel("Industry ID");
		lblIndustryID.setBounds(50,30,130,50);
		lblIndustryID.setFont(new Font("Basic",Font.BOLD,18));
        lblIndustryID.setForeground(Color.WHITE); // Set text color to white
		pnlUI.add(lblIndustryID);

		txtIndustryID = new JTextField();
		txtIndustryID.setBounds(200,40,150,30);
		txtIndustryID.setFont(new Font("Basic",Font.BOLD,18));
		pnlUI.add(txtIndustryID);

		lblIndustryName = new JLabel("Industry Name");
		lblIndustryName.setBounds(50,70,150,50);
		lblIndustryName.setFont(new Font("Basic",Font.BOLD,18));
        lblIndustryName.setForeground(Color.WHITE); // Set text color to white
		pnlUI.add(lblIndustryName);

		txtIndustryName = new JTextField();
		txtIndustryName.setBounds(200,80,150,30);
		txtIndustryName.setFont(new Font("Basic",Font.BOLD,18));
		pnlUI.add(txtIndustryName);

		bst = new ButtonState();
		cbm = new clsButtonManagement();
		automateButtons();
		bst.setButtonState(ButtonState.InitialState);
		cbm.showButtonsOnUI(bst);

		setDefaultOperation();
		initUI();

		createReport();

		setVisible(true);
	}

	void setDefaultOperation()
	{
		PanelState.enabledComponents(pnlNew);
		PanelState.enabledComponents(pnlView);
		PanelState.enabledComponents(pnlReport);
		PanelState.disabledComponents(pnlUI);
	}

	public void initUI()
	{
		txtIndustryName.setText("");
		txtIndustryID.setText("0");
	}

	void automateButtons()
	{
		cbm.manageNewPanel(pnlNew);
		cbm.manageViewPanel(pnlView);
		cbm.manageCancelPanel(pnlCancel);
		cbm.manageReportPanel(pnlReport);
		cbm.manageUpdatePanel(pnlUpdate);
		cbm.manageEditPanel(pnlEdit);
		cbm.manageDeletePanel(pnlDelete);
		cbm.manageSavePanel(pnlSave);
		cbm.manageUIReportPanel(pnlUIReport);
		cbm.manageUIPanel(pnlUI);
		cbm.manageApplyPanel(pnlApply);
		cbm.manageClosePanel(pnlClose);
		cbm.manageCombo1Panel(pnlCombo1);
		cbm.manageCombo1(cmbCombo1);

	}

	void addIndustryRecord(JComboBox temp)
	{

		clsIndustry.addIndustryRecords(temp);

	}

	clsIndustry readUI()
	{
		clsIndustry temp = new clsIndustry();
		temp.setIndustryID(Integer.parseInt(txtIndustryID.getText()));
		temp.setIndustryName(txtIndustryName.getText());

		return (temp);
	}

	public void writeUI(clsIndustry temp)
	{

		txtIndustryID.setText(String.valueOf(temp.getIndustryID()));

		txtIndustryName.setText(temp.getIndustryName());
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
		Rcols+=tool.addNewColumn("Serial_No");
		Rcols+=tool.addNewColumn("IndustryName");
	}

	void setColumnsAlignment()
	{

		tool.setColumnAlignment(0,ReportTool.ALIGN_CENTER);
		tool.setColumnAlignment(1,ReportTool.ALIGN_CENTER);

	}

	void setColumnsWidth()
	{

		tool.setColumnWidth("Serial_No",80);
		tool.setColumnWidth("IndustryName",200);

	}

	void setColumnsData()
	{

		tool.removeAllRows();

		clsIndustry Data[]=clsIndustry.getAllIndustryInformation();

		for(int i=0;i<Data.length;i++)
		{
			Object Objectdata[]=new Object[Rcols];

			Objectdata[0]=i+1;
			Objectdata[1]=Data[i].getIndustryName();

			tool.addNewRow(Objectdata);
		}

	}

	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==btnNew)
		{

			bst.setButtonState(ButtonState.NewState);
			cbm.showButtonsOnUI(bst);
			initUI();

		}

		else if(ae.getSource()==btnView)
		{

			bst.setButtonState(ButtonState.ViewState);
			cbm.showButtonsOnUI(bst);
			initUI();

			addIndustryRecord(cmbCombo1);

		}

		else if(ae.getSource()== btnCancel)
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

		else if(ae.getSource()==btnSave)
		{

			bst.setButtonState(ButtonState.SaveState);
			cbm.showButtonsOnUI(bst);
			clsIndustry temp = readUI();
			clsIndustry.addNewIndustry(temp);
			initUI();

		}

		else if(ae.getSource()==btnApply)
		{

			bst.setButtonState(ButtonState.ApplyState);
			cbm.showButtonsOnUI(bst);
			initUI();

			if(cmbCombo1.getSelectedIndex() == 0)
			{
				//JOptionPane.showMessageDialog(null,"Please Select Industry Properly...");
			}
			else
			{
				String mIndustryName = (String)cmbCombo1.getSelectedItem();
				int mIndustryID = clsIndustry.getIDFromName(mIndustryName);
				clsIndustry temp = clsIndustry.getIndustryInformation(mIndustryID);
				writeUI(temp);
			}

		}

		else if(ae.getSource()==btnEdit)
		{

			bst.setButtonState(ButtonState.EditState);
			cbm.showButtonsOnUI(bst);

		}

		else if(ae.getSource()==btnUpdate)
		{

			bst.setButtonState(ButtonState.UpdateState);
			cbm.showButtonsOnUI(bst);

			clsIndustry temp = readUI();
			clsIndustry.updateIndustry(temp);
			initUI();

		}

		else if(ae.getSource()==btnDelete)
		{

			bst.setButtonState(ButtonState.DeleteState);
			cbm.showButtonsOnUI(bst);
			clsIndustry temp = readUI();
			clsIndustry.deleteIndustry(temp);
			initUI();

		}

	}
	public static void main(String args[])
	{
		frmIndustry f = new frmIndustry();
	}
}