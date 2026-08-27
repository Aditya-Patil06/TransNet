import myUtility.*;
import Generator.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import screensetting.*;
import ReportUtility.*;
import javax.swing.border.EmptyBorder;

public class frmCountry extends JFrame implements ActionListener
{

	JLabel lblProgramHeading 	;
	JLabel lblCountryID 		;
	JLabel lblCountryName	 	;
	JLabel lblCountryUpdate		;

	JTextField txtCountryID 	;
	JTextField txtCountryName 	;

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


    public frmCountry()
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

		lblCountryUpdate = myUI.getlblCombo1();
		lblCountryUpdate.setText("Country List ... ");

		lblProgramHeading = myUI.getlblProgramHeading();

		lblCountryID = new JLabel("Country ID");
        lblCountryID.setBounds(50, 30, 130, 50);
        lblCountryID.setFont(new Font("Basic", Font.BOLD, 18));
        lblCountryID.setForeground(Color.WHITE); // Set text color to white
        pnlUI.add(lblCountryID);

        txtCountryID = new JTextField();
        txtCountryID.setBounds(200, 40, 150, 30);
        txtCountryID.setFont(new Font("Basic", Font.BOLD, 18));
        pnlUI.add(txtCountryID);

        lblCountryName = new JLabel("Country Name");
        lblCountryName.setBounds(50, 70, 150, 50);
        lblCountryName.setFont(new Font("Basic", Font.BOLD, 18));
        lblCountryName.setForeground(Color.WHITE); // Set text color to white
        pnlUI.add(lblCountryName);

        txtCountryName = new JTextField();
        txtCountryName.setBounds(200, 80, 150, 30);
        txtCountryName.setFont(new Font("Basic", Font.BOLD, 18));
        pnlUI.add(txtCountryName);
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
		txtCountryName.setText("");
		txtCountryID.setText("0");
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

	void addCountryRecord(JComboBox temp)
	{

		clsCountry.addCountryRecords(temp);

	}

	clsCountry readUI()
	{
		clsCountry temp = new clsCountry();
		temp.setCountryID(Integer.parseInt(txtCountryID.getText()));
		temp.setCountryName(txtCountryName.getText());

		return (temp);
	}

	public void writeUI(clsCountry temp)
	{

		txtCountryID.setText(String.valueOf(temp.getCountryID()));

		txtCountryName.setText(temp.getCountryName());
	}


	void createReport()
	{
	        setColumnsHeading();
	        setColumnsAlignment();
	        setColumnsWidth();
	        setColumnsData();

    }

	void setColumnsHeading()
	{

		Rcols=0;
		Rcols+=tool.addNewColumn("CountryID");
		Rcols+=tool.addNewColumn("CountryName");
	}

	void setColumnsAlignment()
	{

		tool.setColumnAlignment(0,ReportTool.ALIGN_CENTER);
		tool.setColumnAlignment(1,ReportTool.ALIGN_CENTER);

	}

	void setColumnsWidth()
	{

		tool.setColumnWidth("CountryID",80);
		tool.setColumnWidth("CountryName",200);

	}

	void setColumnsData()
	{

		tool.removeAllRows();

		clsCountry Data[]=clsCountry.getAllCountryInformation();

		for(int i=0;i<Data.length;i++)
		{
			Object Objectdata[]=new Object[Rcols];

			Objectdata[0]=i+1;
			Objectdata[1]=Data[i].getCountryName();

			tool.addNewRow(Objectdata);
		}

	}

	public void actionPerformed(ActionEvent ae)
	{
		if (ae.getSource() == btnNew)
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

			addCountryRecord(cmbCombo1);

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
			clsCountry temp = readUI();
			clsCountry.addNewCountry(temp);
			initUI();

		}

		else if(ae.getSource()==btnApply)
		{

			bst.setButtonState(ButtonState.ApplyState);
			cbm.showButtonsOnUI(bst);
			initUI();

			if(cmbCombo1.getSelectedIndex() == 0)
			{
				//JOptionPane.showMessageDialog(null,"Please Select Country Properly...");
			}
			else
			{
				String mCountryName = (String)cmbCombo1.getSelectedItem();
				int mCountryID = clsCountry.getIDFromName(mCountryName);
				clsCountry temp = clsCountry.getCountryInformation(mCountryID);
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

			clsCountry temp = readUI();
			clsCountry.updateCountry(temp);
			initUI();

		}

		else if(ae.getSource()==btnDelete)
		{

			bst.setButtonState(ButtonState.DeleteState);
			cbm.showButtonsOnUI(bst);
			clsCountry temp = readUI();
			clsCountry.deleteCountry(temp);
			initUI();

		}

	}
	public static void main(String args[])
	{
		frmCountry f = new frmCountry();
	}
}