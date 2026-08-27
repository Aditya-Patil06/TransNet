import myUtility.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import screensetting.*;
import ReportUtility.*;

public class rptState extends JFrame implements ActionListener
{

	JLabel lblProjectName 		;

	JTextField txtCountryID 	;
	JTextField txtCountryName 	;

	JPanel  pnlInfo1 			;
	JLabel lblInfo1 			;

	JPanel  pnlInfo2 			;
	JLabel lblInfo2 			;

	JPanel pnlInfo3             ;
	JLabel lblInfo3             ;

	JPanel pnlInfo4            ;
	JLabel lblInfo4           ;

	JPanel pnlInfo5            ;
	JLabel lblInfo5           ;

	JPanel pnlInfo6            ;
	JLabel lblInfo6           ;

	JPanel pnlInfo7            ;
	JLabel lblInfo7           ;


	JPanel  pnlSave 			;
	JPanel  pnlEdit 			;
	JPanel  pnlCancel 			;
	JPanel  pnlReport 			;
	JPanel  pnlClose			;
	JPanel  pnlUIReport 		;


	JButton btnSave 			;
	JButton btnEdit 			;
	JButton btnCancel 			;
	JButton btnReport 			;
	JButton btnClose 			;

	JPanel pnlCountryLabel;
	JLabel lblComboCountry;
	JPanel pnlCountryCombo;
	JComboBox cmbCountryCombo;


	ReportDesign2 myUI			;


	int vCountryID=0;
	int Rcols = 0 				;

	ReportTool tool				;


    public rptState()
    {
		setTitle("New Project");
		setSize(1920,1080);
		setLayout(null);
		setLocation(0,0);

		myUI = new ReportDesign2();
		add(myUI);
		//setExtendedState(getExtendedState()|JFrame.MAXIMIZED_BOTH);



		pnlUIReport = myUI.getUIReportPanel();
		tool = new ReportTool(100,100);
		tool.setBounds(10,10,500,300);
		pnlUIReport.add(tool);

		UISetting.setArea(pnlUIReport,560,460);


		pnlInfo1 = myUI.getInfo1Panel();
		lblInfo1 = myUI.getlblInfo1();
		lblInfo1.setText("Info1");
		lblInfo1.setForeground(Color.WHITE);
		pnlInfo1.add(lblInfo1);

		pnlInfo2 = myUI.getInfo2Panel();
		lblInfo2= myUI.getlblInfo2();
		lblInfo2.setText("lblInfo2");
		lblInfo2.setForeground(Color.WHITE);

		pnlInfo3 = myUI.getInfo3Panel();
		lblInfo3 = myUI.getlblInfo3();
		lblInfo3.setText("lblInfo3");
		lblInfo3.setForeground(Color.WHITE);

		pnlInfo4 = myUI.getInfo4Panel();
		lblInfo4= myUI.getlblInfo4();
		lblInfo4.setText("lblInfo4");
		lblInfo4.setForeground(Color.WHITE);

		pnlInfo5 = myUI.getInfo5Panel();
		lblInfo5= myUI.getlblInfo5();
		lblInfo5.setText("lblInfo5");
		lblInfo5.setForeground(Color.WHITE);

		pnlInfo6 = myUI.getInfo6Panel();
		lblInfo6= myUI.getlblInfo6();
		lblInfo6.setText("lblInfo6");
		lblInfo6.setForeground(Color.WHITE);

		pnlInfo7 = myUI.getInfo7Panel();
		lblInfo7= myUI.getlblInfo7();
		lblInfo7.setText("lblInfo7");
		lblInfo7.setForeground(Color.WHITE);


    	pnlCountryLabel = myUI.getCountryLabelPanel();
    	lblComboCountry= myUI.getlblCountry();

    	pnlCountryCombo = myUI.getCountryComboPanel();

    	cmbCountryCombo= myUI.getcmbCountry();
    	cmbCountryCombo.addActionListener(this);


		pnlReport = myUI.getReportPanel();
		pnlClose = myUI.getClosePanel();
		pnlUIReport = myUI.getUIReportPanel();

		btnReport = myUI.getReportButton();
		btnReport.addActionListener(this);

		btnClose= myUI.getCloseButton();
		btnClose.addActionListener(this);


		lblProjectName = myUI.getlblProgramHeading();
		new BlinkLabel(lblProjectName,500);


		setDefaultOperation();
		createReport();

		addCountryRecords(cmbCountryCombo);

		setVisible(true);
	}



	void addCountryRecords(JComboBox temp)
	{
		temp.removeActionListener(this);
		clsCountry.addCountryRecords(temp);
		temp.addActionListener(this);
	}

	void setDefaultOperation()
	{
		PanelState.enabledComponents(pnlReport);

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
		tool.setColumnWidth("CountryName",80);

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


	public void actionPerformed(ActionEvent ae)
	{
		 if(ae.getSource()== btnCancel)
		{

		}
		else if(ae.getSource()==btnReport)
		{
			PanelState.visibleComponents(pnlUIReport);
			PanelState.visibleComponents(pnlClose);
			//PanelState.disabledComponents(pnlEntry);
			//PanelState.hideComponents(pnlUI);
			PanelState.hideComponents(pnlReport);
			setColumnsData();

		}
		else if(ae.getSource()==btnClose)
		{
           // PanelState.visibleComponents(pnlUI);
			PanelState.hideComponents(pnlUIReport);
			PanelState.visibleComponents(pnlReport);
			PanelState.hideComponents(pnlClose);
			//bst.setButtonCommonState(ButtonState.ResetState);

		}
		else if(ae.getSource()==btnSave)
		{

		}

		else if(ae.getSource()==btnEdit)
		{


		}
		else if(ae.getSource() == cmbCountryCombo)
		{
			if(cmbCountryCombo.getSelectedIndex() == 0)
			{
				JOptionPane.showMessageDialog(null,"Please Select Country Properly...");
			}
			else
			{
				String mCountryName = (String)cmbCountryCombo.getSelectedItem();
				vCountryID = clsCountry.getIDFromName(mCountryName);
			}


		}


	}
	public static void main(String args[])
	{
		rptState f = new rptState();

	}
}