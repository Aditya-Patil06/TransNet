import myUtility.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import screensetting.*;
import ReportUtility.*;
import javax.swing.border.EmptyBorder; //New for Report


public class rptVehicle extends JFrame implements ActionListener
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


	ReportDesign myUI			;


	int Rcols = 0 				;

	ReportTool tool				;


	public rptVehicle()
	{
		setTitle("New Project");
		setSize(1920,1080);
		setLayout(null);
		setLocation(0,0);

		myUI = new ReportDesign();
		add(myUI);
		setExtendedState(getExtendedState()|JFrame.MAXIMIZED_BOTH);


		pnlUIReport = myUI.getUIReportPanel();
		pnlUIReport.setLayout(new BorderLayout());

		int padding = 10;
		pnlUIReport.setBorder(new EmptyBorder(padding, padding, padding, padding));

		UISetting.setArea(pnlUIReport, 1200, 400);
		tool = new ReportTool(1000, 300);
		pnlUIReport.add(tool, BorderLayout.CENTER);

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



		setVisible(true);
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
		Rcols+=tool.addNewColumn("VehicleID");
		Rcols+=tool.addNewColumn("Name");
		Rcols+=tool.addNewColumn("Description");
		Rcols+=tool.addNewColumn("ContactPerson");
		Rcols+=tool.addNewColumn("DriverName");
		Rcols+=tool.addNewColumn("LicenceNo");
		Rcols+=tool.addNewColumn("VehicleTypeName");
		Rcols+=tool.addNewColumn("DepotName");

	}
	void setColumnsWidth()
	{
		tool.setColumnWidth("VehicleID",200);
		tool.setColumnWidth("Name",600);
		tool.setColumnWidth("Description",600);
		tool.setColumnWidth("ContactPerson",300);
		tool.setColumnWidth("DriverName",400);
		tool.setColumnWidth("LicenceNo",400);
		tool.setColumnWidth("VehicleTypeName",200);
		tool.setColumnWidth("DepotName",400);
	}

	void setColumnsAlignment()
	{
		tool.setColumnAlignment(0,ReportTool.ALIGN_CENTER);
		tool.setColumnAlignment(1,ReportTool.ALIGN_LEFT);
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


	}
	public static void main(String args[])
	{
		rptVehicle f = new rptVehicle();
	}
}