import myUtility.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import screensetting.*;
import ReportUtility.*;
import javax.swing.border.EmptyBorder;

public class frmBooking extends JFrame implements ActionListener
{

	JLabel lblProgramHeading 	;

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

	JPanel  pnlClient 			;
	JPanel  pnlSourceDepot		;
	JPanel  pnlDestinationDepot	;
	JPanel 	pnlParty			;
	JPanel 	pnlVehicleType		;
	JPanel  pnlCancelConsignment;
	JPanel 	pnlDocket			;
	JPanel  pnlImage			;
	JLabel	lblImage			;
	JPanel  pnlGoods			;
	JPanel  pnlMessageDisplay	;
	JPanel  pnlGoodsReport		;

	JLabel  lblGoodsDocketNo		;
	JLabel  lblGoodsReportDocketNo	;
	JLabel  lblClientName			;
	JLabel	lblGoodsBookingDate		;
	JLabel  lblGoodsSourceDepot		;
	JLabel  lblGoodsDestinationDepot;
	JLabel  lblGoodsPartyName		;
	JLabel  lblGoodsPartyAddress	;
	JLabel  lblGoodsPartyContactNo	;
	JLabel  lblGoodsSrNo			;
	JLabel	lblSelectGoods			;
	JLabel	lblDetails				;
	JLabel	lblCharges				;
	JLabel  lblConfirmWarning		;

	JLabel lblBookingID			;//New Consignment
	JLabel lblBookingDate		;
	JLabel lblDocketNo			;

	JTextField txtBookingID		;
	JTextField txtBookingDate	;
	JTextField txtDocketNo		;

	JLabel lblClientID			;//pnlClient
	JLabel lblAddressInfo 		;
	JLabel lblContactInfo 		;
	JLabel lblEmailInfo  		;

	JButton btnRefreshDocClient	;
	JButton btnNewDocClient		;

	JComboBox cmbClient			;

	JTextField txtDetails		;//pnlGoods
	JTextField txtCharges		;

	JButton btnSaveGoodsRecord	;
	JButton btnRefreshDocGoods	;
	JButton btnNewDocGoods		;

	JComboBox cmbGoods			;

	JPanel pnlSteps				;//Steps101

	JButton btnLoadConsignment	;
	JButton btnAddClient		;
	JButton btnSourceDepot		;
	JButton btnDestinationDepot	;
	JButton btnSelectVehicle	;
	JButton btnAddParty			;
	JButton btnConfirm			;
	JButton btnAddGoods			;
	JButton btnFinish			;
	JButton btnCancelConsignment;

	JButton btnGoToClient		;
	JButton btnGoToSourceDepot	;
	JButton btnGoToDestinationDepot;
	JButton btnGoToSelectVehicle;
	JButton btnGoToAddParty		;//GoTo101

	JButton btnBackToConsignment	 ;
	JButton btnBackToClient			 ;
	JButton btnBackToSourceDepot	 ;
	JButton btnBackToDestinationDepot;
	JButton btnBackToSelectVehicle   ;
	JButton btnPressToConfirm		 ;

	JPanel pnlbtnSaveGoodsRecords	;//Panel to add Buttons
	JPanel pnlbtnNewConsignment		;
	JPanel pnlbtnAddClient			;
	JPanel pnlbtnSourceDepot		;
	JPanel pnlbtnDestinationDepot	;
	JPanel pnlbtnSelectVehicle		;
	JPanel pnlbtnAddParty			;
	JPanel pnlbtnAddGoods			;
	JPanel pnlbtnFinish				;
	JPanel pnlbtnConfirm			;


	JPanel pnlbtnDeleteGoodsRecords		;
	JButton btnDeleteGoodsRecord		;

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

	JTextField txtDocketNoUpdate;
	JLabel lblDocketUpdate 		;


	JLabel lblSourceDepot					;//Source Depot Panel
	JLabel lblSourceDepotAddressInfo		;
	JLabel lblSourceDepotContactInfo		;
	JLabel lblSourceDepotContactPersonInfo	;
	JLabel lblSourceDepotEmailInfo			;

	JComboBox cmbSourceDepot				;

	JLabel lblDestinationDepot					;//Destination Depot Panel
	JLabel lblDestinationDepotAddressInfo		;
	JLabel lblDestinationDepotContactInfo		;
	JLabel lblDestinationDepotContactPersonInfo	;
	JLabel lblDestinationDepotEmailInfo			;

	JComboBox cmbDestinationDepot				;

	JLabel lblVehicleType	; // Vehicle Panel
	JLabel lblVehicle  		;
	JLabel lblDeliveryParty	;
	JLabel lblContactNo		;
	JLabel lblEmailID		;
	JLabel lblAddress		;

	JButton btnRefreshDocVehicle;
	JButton btnNewDocVehicle	;

	JTextField txtDeliveryParty	;
	JTextField txtContactNo		;
	JTextField txtEmailID		;
	JTextField txtAddress		;

	JLabel lblVehicleNameInfo		;
	JLabel lblVehicleContactPersonInfo ;
	JLabel lblVehicleDriverNameInfo ;
	JLabel lblVehicleLicenceNoInfo 	;

	JComboBox cmbVehicleType		;
	JComboBox cmbVehicle			;

	BookingDesign myUI				;
	ButtonState bst					;
	clsButtonManagement cbm			;


	int Rcols = 0 					;
	int Rcols1 = 0 					;

	int vGoodsID					;
	int vClientID					;
	int vSourceDepotID				;
	int vDestinationDepotID			;
	int vVehicleID					;
	int vVehicleTypeID				;
	int vDay						;
	int vMonth						;
	int vYear						;
	int vGenerateDocketID			;
	int vBookingID					;

	ReportTool tool					;
	ReportTool GoodsReportTool		;

	JTable MyTable					;


	String  ImagePath = "D:/Aditya_Project_TransNet/Truck/img2_1.jpg"	;

	String  PrintBookingDate ;
	String  PrintDocketNo ;
	String  PrintClientName;
	String	PrintSourceDepotName;
	String  PrintDestinationDepotName;
	String  PrintVehicleNumber;
	String  PrintVehicleTypeName;

	int ConsignmentStatus = 0 ;

    public frmBooking()
    {
		setTitle("New Project");
		setSize(1920,1080);
		setLayout(null);
		setLocation(0,0);

		myUI = new BookingDesign();
		add(myUI);
		setExtendedState(getExtendedState()|JFrame.MAXIMIZED_BOTH);

		bst = new ButtonState();
		cbm = new clsButtonManagement();
		bst.setButtonState(ButtonState.InitialState);

		pnlUI = myUI.getUIPanel();
		pnlUI.setLayout(null);
		UISetting.setArea(pnlUI,1200,600);


		pnlUIReport = myUI.getUIReportPanel();
		tool = new ReportTool(100,100);
		tool.setBounds(10,10,500,400);
		pnlUIReport.add(tool);

		UISetting.setArea(pnlUIReport,550,500);


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
		PanelState.disabledComponents(pnlReport);
		btnReport.addActionListener(this);

		btnClose= myUI.getCloseButton();
		btnClose.addActionListener(this);


		lblDocketUpdate = myUI.getComboLabel();

		txtDocketNoUpdate = myUI.getcmbCombo1();

		pnlSteps = new JPanel();
		pnlSteps.setLayout(null);
		pnlSteps.setBounds(10,10,170,580);

		int y2 = 10 ;
		int h2 = 40 ;

		pnlbtnNewConsignment = new JPanel();
		pnlbtnNewConsignment.setBounds(10,y2,150,35);
		pnlbtnNewConsignment.setLayout(null);
		pnlSteps.add(pnlbtnNewConsignment);

		btnLoadConsignment = new JButton("Load Consignment");
		btnLoadConsignment.setBounds(0,0,150,30);
		pnlbtnNewConsignment.add(btnLoadConsignment);
		btnLoadConsignment.addActionListener(this);

		y2 = y2+h2 ;

		pnlbtnAddClient = new JPanel();
		pnlbtnAddClient.setLayout(null);
		pnlbtnAddClient.setBounds(10,y2,150,35);
		pnlSteps.add(pnlbtnAddClient);

		btnAddClient = new JButton("Add Client");
		btnAddClient.setBounds(0,0,150,30);
		pnlbtnAddClient.add(btnAddClient);
		btnAddClient.addActionListener(this);

		y2 = y2+h2 ;

		pnlbtnSourceDepot = new JPanel();
		pnlbtnSourceDepot.setBounds(10,y2,150,35);
		pnlbtnSourceDepot.setLayout(null);
		pnlSteps.add(pnlbtnSourceDepot);

		btnSourceDepot = new JButton("Source Depot");
		btnSourceDepot.setBounds(0,0,150,30);
		pnlbtnSourceDepot.add(btnSourceDepot);
		btnSourceDepot.addActionListener(this);

		y2 = y2+h2 ;

		pnlbtnDestinationDepot = new JPanel();
		pnlbtnDestinationDepot.setBounds(10,y2,150,35);
		pnlbtnDestinationDepot.setLayout(null);
		pnlSteps.add(pnlbtnDestinationDepot);

		btnDestinationDepot = new JButton("Destination Depot");
		btnDestinationDepot.setBounds(0,0,150,30);
		pnlbtnDestinationDepot.add(btnDestinationDepot);
		btnDestinationDepot.addActionListener(this);

		y2 = y2+h2 ;

		pnlbtnSelectVehicle = new JPanel();
		pnlbtnSelectVehicle.setBounds(10,y2,150,35);
		pnlbtnSelectVehicle.setLayout(null);
		pnlSteps.add(pnlbtnSelectVehicle);


		btnSelectVehicle = new JButton("Select Vehicle");
		btnSelectVehicle.setBounds(0,0,150,30);
		pnlbtnSelectVehicle.add(btnSelectVehicle);
		btnSelectVehicle.addActionListener(this);

		y2 = y2+h2 ;


		pnlbtnAddParty = new JPanel();
		pnlbtnAddParty.setBounds(10,y2,150,35);
		pnlbtnAddParty.setLayout(null);
		pnlSteps.add(pnlbtnAddParty);

		btnAddParty = new JButton("Add Party");
		btnAddParty.setBounds(0,0,150,30);
		pnlbtnAddParty.add(btnAddParty);
		btnAddParty.addActionListener(this);

		y2 = y2+h2 ;

		pnlbtnConfirm = new JPanel();
		pnlbtnConfirm.setBounds(10,y2,150,35);
		pnlbtnConfirm.setLayout(null);
		pnlSteps.add(pnlbtnConfirm);

		btnConfirm = new JButton("Confirm");
		btnConfirm.setBounds(0,0,150,30);
		pnlbtnConfirm.add(btnConfirm);
		btnConfirm.addActionListener(this);


		y2 = y2+h2 ;

		pnlbtnAddGoods= new JPanel();
		pnlbtnAddGoods.setBounds(10,y2,150,35);
		pnlbtnAddGoods.setLayout(null);
		pnlSteps.add(pnlbtnAddGoods);

		btnAddGoods = new JButton("Add Goods");
		btnAddGoods.setBounds(0,0,150,30);
		pnlbtnAddGoods.add(btnAddGoods);
		btnAddGoods.addActionListener(this);

		y2 = y2+h2 ;

		pnlbtnFinish= new JPanel();
		pnlbtnFinish.setBounds(10,y2,150,35);
		pnlbtnFinish.setLayout(null);
		pnlSteps.add(pnlbtnFinish);

		btnFinish = new JButton("Finish");
		btnFinish.setBounds(0,0,150,30);
		pnlbtnFinish.add(btnFinish);
		btnFinish.addActionListener(this);

		y2 = y2+h2 ;

		pnlCancelConsignment= new JPanel();
		pnlCancelConsignment.setBounds(10,y2,150,35);
		pnlCancelConsignment.setLayout(null);
		pnlSteps.add(pnlCancelConsignment);

		btnCancelConsignment = new JButton("Cancel Consignment");
		btnCancelConsignment.setBounds(0,0,150,30);
		pnlCancelConsignment.add(btnCancelConsignment);
		btnCancelConsignment.addActionListener(this);

		pnlUI.add(pnlSteps);

		pnlImage = new JPanel();
		pnlImage.setBounds(660,10,530,220);
		pnlImage.setLayout(null);
		pnlUI.add(pnlImage);

		lblImage = new JLabel(new ImageIcon(ImagePath));
		lblImage.setBounds(0,0,530,220);
		pnlImage.add(lblImage);

		pnlDocket = new JPanel();
		pnlDocket.setLayout(null);
		pnlDocket.setBounds(200,10,450,220);

		int y = 10 ;
		int gap = 10 ;
		int height = 30;

		lblBookingID = new JLabel("Booking ID");
		lblBookingID.setBounds(10,y,100,height);
		lblBookingID.setFont(new Font("Basic",Font.BOLD,14));
		pnlDocket.add(lblBookingID);


		txtBookingID = new JTextField();
		txtBookingID.setBounds(130,y,100,height);
		txtBookingID.setFont(new Font("Basic",Font.BOLD,14));
		pnlDocket.add(txtBookingID);

		y = y + height + gap ;

		lblBookingDate = new JLabel("Booking Date");
		lblBookingDate.setBounds(10,y,100,30);
		lblBookingDate.setFont(new Font("Basic",Font.BOLD,14));
		pnlDocket.add(lblBookingDate);

		txtBookingDate = new JTextField();
		txtBookingDate.setBounds(130,y,100,30);
		txtBookingDate.setFont(new Font("Basic",Font.BOLD,14));
		pnlDocket.add(txtBookingDate);

		y = y + height + gap ;

		lblDocketNo = new JLabel("Docket no");
		lblDocketNo.setBounds(10,y,100,height);
		lblDocketNo.setFont(new Font("Basic",Font.BOLD,14));
		pnlDocket.add(lblDocketNo);

		txtDocketNo = new JTextField();
		txtDocketNo.setBounds(130,y,200,height);
		txtDocketNo.setFont(new Font("Basic",Font.BOLD,14));
		pnlDocket.add(txtDocketNo);

		y = y + height + gap ;

		btnGoToClient = new JButton("Next ...");
		btnGoToClient.setBounds(363,y+57,80,height);
		btnGoToClient.setFont(new Font("Basic",Font.BOLD,14));
		btnGoToClient.addActionListener(this);
		//btnGoToClient.setEnabled(false);
		pnlDocket.add(btnGoToClient);

		pnlUI.add(pnlDocket);

		int	y3 = 10 ;

		pnlClient = new JPanel();
		pnlClient.setLayout(null);
		pnlClient.setBounds(200,10,450,220);
		pnlUI.add(pnlClient);


		lblClientID = new JLabel("Client ID");
		lblClientID.setBounds(10,y3,100,height);
		lblClientID.setFont(new Font("Basic",Font.BOLD,14));
		pnlClient.add(lblClientID);

		cmbClient = new JComboBox();
		cmbClient.setBounds(150,y3,200,height);
		cmbClient.setFont(new Font("Basic",Font.BOLD,14));
		pnlClient.add(cmbClient);

		btnNewDocClient = new JButton(new ImageIcon("image1.png"));
		btnNewDocClient.setBounds(360,y3,30,30);
		btnNewDocClient.setVisible(true);
		btnNewDocClient.addActionListener(this);
		pnlClient .add(btnNewDocClient );

		btnRefreshDocClient = new JButton(new ImageIcon("RefreshImg1.png"));
		btnRefreshDocClient.setBounds(360,y3,30,30);
		btnRefreshDocClient.setVisible(false);
		btnRefreshDocClient.addActionListener(this);
		pnlClient .add(btnRefreshDocClient );//

		y3 = y3 + height + 10 ;

		lblContactInfo = new JLabel("-------------");
		lblContactInfo.setBounds(10,y3,200,height);
		lblContactInfo.setFont(new Font("Basic",Font.BOLD,14));
		pnlClient.add(lblContactInfo);

		y3 = y3 + height + 10 ;

		lblEmailInfo = new JLabel("-------------");
		lblEmailInfo.setBounds(10,y3,500,height);
		lblEmailInfo.setFont(new Font("Basic",Font.BOLD,14));
		pnlClient.add(lblEmailInfo);

		y3 = y3 + height + 10 ;

		lblAddressInfo = new JLabel("-------------");
		lblAddressInfo.setBounds(10,y3,900,50);
		lblAddressInfo.setFont(new Font("Basic",Font.BOLD,14));
		pnlClient.add(lblAddressInfo);

		y3 = y3 + height + 10 ;

		btnGoToSourceDepot = new JButton("Next...");
		btnGoToSourceDepot.setBounds(363,y3+17,80,height);
		btnGoToSourceDepot.setFont(new Font("Basic",Font.BOLD,14));
		btnGoToSourceDepot.addActionListener(this);
		pnlClient.add(btnGoToSourceDepot);

		btnBackToConsignment  = new JButton("Back ...");
		btnBackToConsignment.setBounds(10,y3+17,80,height);
		btnBackToConsignment.setFont(new Font("Basic",Font.BOLD,14));
		btnBackToConsignment.addActionListener(this);
		pnlClient.add(btnBackToConsignment);

		y = y+100+gap ;

		pnlSourceDepot = new JPanel();
		pnlSourceDepot.setLayout(null);
		pnlSourceDepot.setBounds(200,10,450,220);
		pnlUI.add(pnlSourceDepot);

		int	y1 = 40 ;

		lblSourceDepot = new JLabel("Source Depot");
		lblSourceDepot.setBounds(10,10,100,height);
		lblSourceDepot.setFont(new Font("Basic",Font.BOLD,14));
		pnlSourceDepot.add(lblSourceDepot);

		cmbSourceDepot = new JComboBox();
		cmbSourceDepot.setBounds(120,10,200,height);
		cmbSourceDepot.setFont(new Font("Basic",Font.BOLD,14));
		pnlSourceDepot.add(cmbSourceDepot);

		lblSourceDepotContactPersonInfo = new JLabel("-------------");
		lblSourceDepotContactPersonInfo.setBounds(10,y1,480,height);
		lblSourceDepotContactPersonInfo.setFont(new Font("Basic",Font.BOLD,14));
		pnlSourceDepot.add(lblSourceDepotContactPersonInfo);

		y1= y1 + height ;

		lblSourceDepotContactInfo = new JLabel("-------------");
		lblSourceDepotContactInfo.setBounds(10,y1,480,height);
		lblSourceDepotContactInfo.setFont(new Font("Basic",Font.BOLD,14));
		pnlSourceDepot.add(lblSourceDepotContactInfo);

		y1= y1 + height ;

		lblSourceDepotEmailInfo = new JLabel("-------------");
		lblSourceDepotEmailInfo.setBounds(10,y1,480,height);
		lblSourceDepotEmailInfo.setFont(new Font("Basic",Font.BOLD,14));
		pnlSourceDepot.add(lblSourceDepotEmailInfo);

		y1= y1 + height ;

		lblSourceDepotAddressInfo = new JLabel("-------------");
		lblSourceDepotAddressInfo.setBounds(10,y1,480,height);
		lblSourceDepotAddressInfo.setFont(new Font("Basic",Font.BOLD,14));
		pnlSourceDepot.add(lblSourceDepotAddressInfo);

		y1= y1 + height ;

		btnGoToDestinationDepot = new JButton("Next ...");
		btnGoToDestinationDepot.setBounds(363,y1+27,80,height);
		btnGoToDestinationDepot.setFont(new Font("Basic",Font.BOLD,14));
		btnGoToDestinationDepot.addActionListener(this);
		pnlSourceDepot.add(btnGoToDestinationDepot);

		btnBackToClient  = new JButton("Back...");
		btnBackToClient.setBounds(10,y1+27,80,height);
		btnBackToClient.setFont(new Font("Basic",Font.BOLD,14));
		btnBackToClient.addActionListener(this);
		pnlSourceDepot.add(btnBackToClient);


		pnlDestinationDepot = new JPanel();
		pnlDestinationDepot.setBounds(200,10,450,220);
		pnlDestinationDepot.setLayout(null);
		pnlUI.add(pnlDestinationDepot);

		lblDestinationDepot = new JLabel("Destination Depot");
		lblDestinationDepot.setBounds(10,10,100,height);
		lblDestinationDepot.setFont(new Font("Basic",Font.BOLD,14));
		pnlDestinationDepot.add(lblDestinationDepot);

		cmbDestinationDepot = new JComboBox();
		cmbDestinationDepot.setBounds(120,10,200,height);
		cmbDestinationDepot.setFont(new Font("Basic",Font.BOLD,14));
		pnlDestinationDepot.add(cmbDestinationDepot);

		y1= 40 ;

		lblDestinationDepotContactPersonInfo = new JLabel("-------------");
		lblDestinationDepotContactPersonInfo.setBounds(10,y1,480,height);
		lblDestinationDepotContactPersonInfo.setFont(new Font("Basic",Font.BOLD,14));
		pnlDestinationDepot.add(lblDestinationDepotContactPersonInfo);

		y1= y1 + height ;

		lblDestinationDepotContactInfo = new JLabel("-------------");
		lblDestinationDepotContactInfo.setBounds(10,y1,480,height);
		lblDestinationDepotContactInfo.setFont(new Font("Basic",Font.BOLD,14));
		pnlDestinationDepot.add(lblDestinationDepotContactInfo);

		y1= y1 + height ;

		lblDestinationDepotEmailInfo = new JLabel("-------------");
		lblDestinationDepotEmailInfo.setBounds(10,y1,480,height);
		lblDestinationDepotEmailInfo.setFont(new Font("Basic",Font.BOLD,14));
		pnlDestinationDepot.add(lblDestinationDepotEmailInfo);

		y1= y1 + height ;

		lblDestinationDepotAddressInfo = new JLabel("-------------");
		lblDestinationDepotAddressInfo.setBounds(10,y1,480,height);
		lblDestinationDepotAddressInfo.setFont(new Font("Basic",Font.BOLD,14));
		pnlDestinationDepot.add(lblDestinationDepotAddressInfo);

		y1= y1 + height ;

		btnGoToSelectVehicle = new JButton("Next ...");
		btnGoToSelectVehicle.setBounds(363,y1+27,80,height);
		btnGoToSelectVehicle.setFont(new Font("Basic",Font.BOLD,14));
		btnGoToSelectVehicle.addActionListener(this);
		pnlDestinationDepot.add(btnGoToSelectVehicle);

		btnBackToSourceDepot = new JButton("Back ...");
		btnBackToSourceDepot.setBounds(10,y1+27,80,height);
		btnBackToSourceDepot.setFont(new Font("Basic",Font.BOLD,14));
		btnBackToSourceDepot.addActionListener(this);
		pnlDestinationDepot.add(btnBackToSourceDepot);

		y = y+200+gap ;

		pnlVehicleType =new JPanel();
		pnlVehicleType.setBounds(200,10,450,220);
		pnlVehicleType.setLayout(null);
		pnlUI.add(pnlVehicleType);

		lblVehicleType = new JLabel("VehicleType");
		lblVehicleType.setBounds(10,10,100,30);
		lblVehicleType.setFont(new Font("Basic",Font.BOLD,14));
		pnlVehicleType.add(lblVehicleType);

		cmbVehicleType = new JComboBox();
		cmbVehicleType.setBounds(130,10,200,30);
		cmbVehicleType.setFont(new Font("Basic",Font.BOLD,14));
		pnlVehicleType.add(cmbVehicleType);

		lblVehicle = new JLabel("Vehicle");
		lblVehicle.setBounds(10,50,70,30);
		lblVehicle.setFont(new Font("Basic",Font.BOLD,14));
		pnlVehicleType.add(lblVehicle);

		cmbVehicle = new JComboBox();
		cmbVehicle.setBounds(130,50,200,30);
		cmbVehicle.setFont(new Font("Basic",Font.BOLD,14));
		pnlVehicleType.add(cmbVehicle);

		btnNewDocVehicle = new JButton(new ImageIcon("image1.png"));
		btnNewDocVehicle .setBounds(340,50,30,30);
		btnNewDocVehicle .setVisible(true);
		btnNewDocVehicle .addActionListener(this);
		pnlVehicleType.add(btnNewDocVehicle );

		btnRefreshDocVehicle = new JButton(new ImageIcon("RefreshImg1.png"));
		btnRefreshDocVehicle.setBounds(340,50,30,30);
		btnRefreshDocVehicle.setVisible(false);
		btnRefreshDocVehicle.addActionListener(this);
		pnlVehicleType.add(btnRefreshDocVehicle);

		y1= 50 ;
		int h3 = 24;
		y1= y1 + h2 ;

		lblVehicleNameInfo = new JLabel("-------------");
		lblVehicleNameInfo.setBounds(10,y1,480,h3);
		lblVehicleNameInfo.setFont(new Font("Basic",Font.BOLD,14));
		pnlVehicleType.add(lblVehicleNameInfo);

		y1= y1 + h3 ;

		lblVehicleContactPersonInfo = new JLabel("-------------");
		lblVehicleContactPersonInfo.setBounds(10,y1,480,h3);
		lblVehicleContactPersonInfo.setFont(new Font("Basic",Font.BOLD,14));
		pnlVehicleType.add(lblVehicleContactPersonInfo);

		y1= y1 + h3 ;

		lblVehicleDriverNameInfo = new JLabel("-------------");
		lblVehicleDriverNameInfo.setBounds(10,y1,480,h3);
		lblVehicleDriverNameInfo.setFont(new Font("Basic",Font.BOLD,14));
		pnlVehicleType.add(lblVehicleDriverNameInfo);

		y1= y1 + h3 ;

		lblVehicleLicenceNoInfo = new JLabel("-------------");
		lblVehicleLicenceNoInfo.setBounds(10,y1,480,h3);
		lblVehicleLicenceNoInfo.setFont(new Font("Basic",Font.BOLD,14));
		pnlVehicleType.add(lblVehicleLicenceNoInfo);

		btnGoToAddParty = new JButton("Next ...");
		btnGoToAddParty.setBounds(363,y1+25,80,30);
		btnGoToAddParty.setFont(new Font("Basic",Font.BOLD,14));
		btnGoToAddParty.addActionListener(this);
		pnlVehicleType.add(btnGoToAddParty);

		btnBackToDestinationDepot = new JButton("Back ...");
		btnBackToDestinationDepot.setBounds(10,y1+25,80,30);
		btnBackToDestinationDepot.setFont(new Font("Basic",Font.BOLD,14));
		btnBackToDestinationDepot.addActionListener(this);
		pnlVehicleType.add(btnBackToDestinationDepot);

		y1 = 10 ;

		pnlParty = new JPanel();
		pnlParty.setBounds(200,10,450,220);
		pnlParty.setLayout(null);
		pnlUI.add(pnlParty);

		lblDeliveryParty = new JLabel("Deliever Party");
		lblDeliveryParty.setBounds(10,y1,150,30);
		lblDeliveryParty.setFont(new Font("Basic",Font.BOLD,14));
		pnlParty.add(lblDeliveryParty);

		txtDeliveryParty = new JTextField();
		txtDeliveryParty.setBounds(150,y1,220,30);
		txtDeliveryParty.setFont(new Font("Basic",Font.BOLD,14));
		pnlParty.add(txtDeliveryParty);

		y1 = y1+height+gap ;

		lblContactNo = new JLabel("Contact no");
		lblContactNo.setBounds(10,y1,150,30);
		lblContactNo.setFont(new Font("Basic",Font.BOLD,14));
		pnlParty.add(lblContactNo);

		txtContactNo = new JTextField();
		txtContactNo.setBounds(150,y1,220,30);
		txtContactNo.setFont(new Font("Basic",Font.BOLD,14));
		pnlParty.add(txtContactNo);

		y1 = y1+height+gap ;

		lblEmailID = new JLabel("Email ID");
		lblEmailID.setBounds(10,y1,150,30);
		lblEmailID.setFont(new Font("Basic",Font.BOLD,14));
		pnlParty.add(lblEmailID);

		txtEmailID = new JTextField();
		txtEmailID.setBounds(150,y1,280,30);
		txtEmailID.setFont(new Font("Basic",Font.BOLD,14));
		pnlParty.add(txtEmailID);

		y1 = y1+height+gap ;

		lblAddress = new JLabel("Address");
		lblAddress.setBounds(10,y1,150,30);
		lblAddress.setFont(new Font("Basic",Font.BOLD,14));
		pnlParty.add(lblAddress);

		txtAddress = new JTextField();
		txtAddress.setBounds(150,y1,280,40);
		txtAddress.setFont(new Font("Basic",Font.BOLD,14));
		pnlParty.add(txtAddress);

		btnPressToConfirm = new JButton("Press Confirm Only When Sure !!!");
		btnPressToConfirm.setBounds(210,y1+57,230,30);
		btnPressToConfirm.setForeground(Color.RED);
		btnPressToConfirm.addActionListener(this);
		pnlParty.add(btnPressToConfirm);

		btnBackToSelectVehicle = new JButton("Back...");
		btnBackToSelectVehicle.setBounds(10,y1+57,80,30);
		btnBackToSelectVehicle.setFont(new Font("Basic",Font.BOLD,14));
		btnBackToSelectVehicle.addActionListener(this);
		pnlParty.add(btnBackToSelectVehicle);

		pnlMessageDisplay = new JPanel();
		pnlMessageDisplay.setBounds(200,10,450,220);
		pnlMessageDisplay.setLayout(null);
		pnlUI.add(pnlMessageDisplay);

		y1 = 10 ;
		h2 = 14 ;

		lblGoodsDocketNo= new JLabel("Docket No");//workingHere
		lblGoodsDocketNo.setBounds(10,y1,240,h2);
		pnlMessageDisplay.add(lblGoodsDocketNo);

		lblGoodsBookingDate = new JLabel("Booking Date");
		lblGoodsBookingDate.setBounds(260,y1,400,h2);
		pnlMessageDisplay.add(lblGoodsBookingDate);

		y1 = y1 + 30 ;

		lblClientName = new JLabel("Client Name ");
		lblClientName.setBounds(10,y1,400,h2);
		pnlMessageDisplay.add(lblClientName);

		y1 = y1 + 30 ;

		lblGoodsSourceDepot = new JLabel("Source Depot");
		lblGoodsSourceDepot.setBounds(10,y1,400,h2);
		pnlMessageDisplay.add(lblGoodsSourceDepot);

		y1 = y1 + 30 ;

		lblGoodsDestinationDepot = new JLabel("Destination Depot ");
		lblGoodsDestinationDepot.setBounds(10,y1,400,h2);
		pnlMessageDisplay.add(lblGoodsDestinationDepot);

		y1 = y1 + 30 ;

		lblGoodsPartyName = new JLabel("Party Name : ");
		lblGoodsPartyName.setBounds(10,y1,400,h2);
		pnlMessageDisplay.add(lblGoodsPartyName);

		y1 = y1 + 30 ;

		lblGoodsPartyAddress = new JLabel("Party Address : ");
		lblGoodsPartyAddress.setBounds(10,y1,400,h2);
		pnlMessageDisplay.add(lblGoodsPartyAddress);

		y1 = y1 + 30 ;

		lblGoodsPartyContactNo = new JLabel("Party Contact No : ");
		lblGoodsPartyContactNo.setBounds(10,y1,400,h2);
		pnlMessageDisplay.add(lblGoodsPartyContactNo);

		pnlGoods = new JPanel();
		pnlGoods.setBounds(200,240,990,350);
		pnlGoods.setLayout(null);
		pnlUI.add(pnlGoods);

		y1 = 5  ; h2 = 30 ;
		lblGoodsSrNo = new JLabel("Sr_No");
		lblGoodsSrNo.setBounds(5,y1,40,h2);
		pnlGoods.add(lblGoodsSrNo);

		y1 = y1 + h2 ;

		lblGoodsReportDocketNo = new JLabel("Trans-Doc-");
		lblGoodsReportDocketNo.setBounds(5,y1,200,h2);
		pnlGoods.add(lblGoodsReportDocketNo);

		y1 = y1 + h2 ;

		lblSelectGoods = new JLabel("Select Goods :");
		lblSelectGoods.setBounds(5,y1,200,30);
		pnlGoods.add(lblSelectGoods);

		y1 = y1 + h2 ;

		cmbGoods = new JComboBox();
		cmbGoods.setBounds(5,y1,200,30);
		cmbGoods.setFont(new Font("Basic",Font.BOLD,14));
		pnlGoods.add(cmbGoods);

		btnNewDocGoods = new JButton(new ImageIcon("image1.png"));
		btnNewDocGoods.setBounds(210,y1,30,30);
		btnNewDocGoods.setVisible(true);
		btnNewDocGoods.addActionListener(this);
		pnlGoods.add(btnNewDocGoods);

		btnRefreshDocGoods = new JButton(new ImageIcon("RefreshImg1.png"));
		btnRefreshDocGoods.setBounds(210,y1,30,30);
		btnRefreshDocGoods.setVisible(false);
		btnRefreshDocGoods.addActionListener(this);
		pnlGoods.add(btnRefreshDocGoods);

		gap = 10 ;
		y1 = y1 + h2 + gap;

		lblDetails = new JLabel("Details :");
		lblDetails.setBounds(5,y1,200,30);
		lblDetails.setFont(new Font("Basic",Font.BOLD,14));
		pnlGoods.add(lblDetails);

		y1 = y1 + h2;

		txtDetails = new JTextField();
		txtDetails.setBounds(5,y1,200,30);
		txtDetails.setFont(new Font("Basic",Font.BOLD,14));
		pnlGoods.add(txtDetails);

		y1 = y1 + h2 + gap;

		lblCharges = new JLabel("Charges");
		lblCharges.setBounds(5,y1,150,30);
		lblCharges.setFont(new Font("Basic",Font.BOLD,14));
		pnlGoods.add(lblCharges);

		y1 = y1 + h2;

		txtCharges = new JTextField();
		txtCharges.setBounds(5,y1,150,30);
		txtCharges.setFont(new Font("Basic",Font.BOLD,14));
		pnlGoods.add(txtCharges);

		y1 = y1 + h2 + gap;

		pnlbtnSaveGoodsRecords = new JPanel();
		pnlbtnSaveGoodsRecords.setBounds(5,y1+10,240,45);
		pnlbtnSaveGoodsRecords.setLayout(null);
		pnlGoods.add(pnlbtnSaveGoodsRecords);

		btnSaveGoodsRecord = new JButton("Save Goods");
		btnSaveGoodsRecord.setBounds(0,0,240,40);
		btnSaveGoodsRecord.addActionListener(this);
		pnlbtnSaveGoodsRecords.add(btnSaveGoodsRecord);


		pnlbtnDeleteGoodsRecords = new JPanel();
		pnlbtnDeleteGoodsRecords.setBounds(530,y1+10,250,45);
		pnlbtnDeleteGoodsRecords.setLayout(null);
		pnlGoods.add(pnlbtnDeleteGoodsRecords);

		btnDeleteGoodsRecord = new JButton("Delete Goods");
		btnDeleteGoodsRecord.setBounds(0,0,250,40);
		btnDeleteGoodsRecord.addActionListener(this);
		pnlbtnDeleteGoodsRecords.add(btnDeleteGoodsRecord);

		pnlGoodsReport = new JPanel();
		pnlGoodsReport.setBounds(250,5,730,275);
		pnlGoodsReport.setLayout(new BorderLayout());
		pnlGoodsReport.setBackground(Color.GRAY);
		pnlGoods.add(pnlGoodsReport);

		int padding = 5;
		pnlGoodsReport.setBorder(new EmptyBorder(padding, padding, padding, padding));

		GoodsReportTool = new ReportTool(700,275);
		GoodsReportTool.setBounds(0,0,500,400);
		pnlGoodsReport.add(GoodsReportTool, BorderLayout.CENTER);

		MyTable=GoodsReportTool.getTable();

		lblProgramHeading = myUI.getlblProgramHeading();
		new BlinkLabel(lblProgramHeading,1000);


		setDefaultOperation();
		initUI();

		createReport();

		addClientRecords(cmbClient);
		addDepotRecords(cmbSourceDepot);
		addDepotRecords(cmbDestinationDepot);
		addVehicleTypeRecords(cmbVehicleType);
		addGoodsRecord(cmbGoods);

		setVisible(true);
	}

	void setDefaultOperation()
	{
		PanelState.enabledComponents(pnlNew);
		PanelState.enabledComponents(pnlView);
		PanelState.enabledComponents(pnlReport);
		PanelState.disabledComponents(pnlUI);

	}
	public void setApplyPanelState()
	{
		PanelState.visibleComponents(pnlDocket);
		PanelState.enabledComponents(pnlDocket);
		PanelState.enabledComponents(pnlClient);
		PanelState.enabledComponents(pnlSourceDepot);
		PanelState.enabledComponents(pnlDestinationDepot);
		PanelState.enabledComponents(pnlVehicleType);
		PanelState.enabledComponents(pnlParty);

	}

	public void setUIPanelState()
	{
		PanelState.hideComponents(pnlDocket);
		PanelState.hideComponents(pnlClient);
		PanelState.hideComponents(pnlSourceDepot);
		PanelState.hideComponents(pnlParty);
		PanelState.hideComponents(pnlDestinationDepot);
		PanelState.hideComponents(pnlVehicleType);
		PanelState.hideComponents(pnlMessageDisplay);
		PanelState.disabledComponents(pnlGoods);

	}
	public void initUI()
	{
		setUIPanelState();

		txtBookingID.setText("");
		txtBookingDate.setText("");
		txtDocketNo.setText("");
		txtDetails.setText("");
		txtCharges.setText("");
		txtDeliveryParty.setText("");
		txtContactNo.setText("");
		txtEmailID.setText("");
		txtAddress.setText("");
		txtDocketNoUpdate.setText("");

		vGoodsID = 0;
		vClientID = 0;
		vSourceDepotID = 0;
		vDestinationDepotID = 0;
		vVehicleID = 0;
		vVehicleTypeID = 0;
		vDay = 0;
		vMonth = 0;
		vYear = 0;
		vGenerateDocketID = 0;
		vBookingID = 0;

		PrintBookingDate = "";
		PrintDocketNo = "";
		PrintClientName = "";
		PrintSourceDepotName = "";
		PrintDestinationDepotName = "";
		PrintVehicleNumber = "";
		PrintVehicleTypeName = "";

		lblAddressInfo.setText("-------------");
		lblEmailInfo.setText("-------------");
		lblContactInfo.setText("-------------");

		lblSourceDepotAddressInfo.setText("-------------");
		lblSourceDepotEmailInfo.setText("-------------");
		lblSourceDepotContactInfo.setText("-------------");
		lblSourceDepotContactPersonInfo.setText("-------------");

		lblDestinationDepotAddressInfo.setText("-------------");
		lblDestinationDepotEmailInfo.setText("-------------");
		lblDestinationDepotContactInfo.setText("-------------");
		lblDestinationDepotContactPersonInfo.setText("-------------");

		lblVehicleNameInfo.setText("-------------");
		lblVehicleContactPersonInfo.setText("-------------");
		lblVehicleDriverNameInfo.setText("-------------");
 	    lblVehicleLicenceNoInfo.setText("-------------");

 	    lblGoodsDocketNo.setText("Docket No");
		lblGoodsBookingDate.setText("Booking Date");
		lblClientName.setText("Client Name ");
		lblGoodsSourceDepot.setText("Source Depot");
		lblGoodsDestinationDepot.setText("Destination Depot ");
		lblGoodsPartyName.setText("Party Name : ");
		lblGoodsPartyAddress.setText("Party Address : ");
    	lblGoodsPartyContactNo.setText("Party Contact No : ");
	}

	public clsBooking readUI()
	{
		DateManager a = DateManager.convertToDate(txtBookingDate.getText());
		vDay = a.getDay();
		vMonth = a.getMonth();
		vYear = a.getYear();


		clsBooking temp = new clsBooking();
		temp.setBookingID(1);
		temp.setBookingDayNo(vDay);
		temp.setBookingMonthNo(vMonth);
		temp.setBookingYearNo(vYear);
		temp.setClientID(vClientID);
		temp.setSourceDepotID(vSourceDepotID);
		temp.setGenerateDocketID(vGenerateDocketID);
		temp.setVehicleID(vVehicleID);
		temp.setDestinationDepotID(vDestinationDepotID);
		temp.setDeliveryParty(txtDeliveryParty.getText());
		temp.setContactNo(txtContactNo.getText());
		temp.setEmailID(txtEmailID.getText());
		temp.setAddress(txtAddress.getText());

		return temp;
	}

	void loadBookingDetails(clsBookingReport temp)
	{

		PanelState.enabledComponents(pnlbtnNewConsignment);

		vBookingID = temp.getBookingID();

		txtBookingID.setText(String.valueOf(temp.getBookingID()));
		vDay = temp.getBookingDayNo();
		vMonth = temp.getBookingMonthNo();
		vYear = temp.getBookingYearNo();
		PrintBookingDate = temp.getBookingDate();
		PrintDocketNo = temp.getGenerateDocketName();
		vGenerateDocketID = temp.getGenerateDocketID();
		txtBookingDate.setText(PrintBookingDate);
		txtDocketNo.setText(PrintDocketNo);

		vClientID = temp.getClientID();
		PrintClientName = temp.getClientName();
		cmbClient.setSelectedItem(PrintClientName);

		vSourceDepotID = temp.getSourceDepotID();
		PrintSourceDepotName = temp.getSourceDepotName();
		cmbSourceDepot.setSelectedItem(PrintSourceDepotName);

		vDestinationDepotID = temp.getDestinationDepotID ();
		PrintDestinationDepotName = temp.getDestinationDepotName();
		cmbDestinationDepot.setSelectedItem(PrintDestinationDepotName);

		vVehicleTypeID = temp.getVehicleTypeID();
		PrintVehicleTypeName = temp.getVehicleTypeName();
		cmbVehicleType.setSelectedItem(PrintVehicleTypeName);

		vVehicleID = temp.getVehicleID();
		PrintVehicleNumber = temp.getVehicleNumber();
		cmbVehicle.setSelectedItem(PrintVehicleNumber);

		txtDeliveryParty.setText(temp.getDeliveryParty());
		txtContactNo.setText(temp.getContactNo());
		txtEmailID.setText(temp.getEmailID());
		txtAddress.setText(temp.getAddress());

	}
	public clsGenerateDocket readUI2()
	{
		clsGenerateDocket d = new clsGenerateDocket();
		d.setGenerateDocketID(0);
		d.setGenerateDocketName(PrintDocketNo);
		vGenerateDocketID = clsGenerateDocket.getHighDocet()+1;
		d.setDocketCounter(vGenerateDocketID);

		return d ;
	}
	public clsBookingDetail readUI3()
	{
		clsBookingDetail temp = new clsBookingDetail();
		temp.setBookingDetailID(0);
		//JOptionPane.showMessageDialog(null, "Booking ID : " + vBookingID);

		temp.setBookingID(vBookingID);
		temp.setGoodsID(vGoodsID);
		temp.setDetails(txtDetails.getText());
		temp.setCharges(txtCharges.getText());

		return temp;
	}
	public void writeUI3(clsBookingDetailReport temp)
	{
		cmbGoods.setSelectedItem(temp.getGoodsName());
		txtDetails.setText(temp.getDetails());
		txtCharges.setText(temp.getCharges());

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
		Rcols+=tool.addNewColumn("CountryID");
		Rcols+=tool.addNewColumn("CountryName");

		Rcols1=0;
		Rcols1+=GoodsReportTool.addNewColumn("Sr_No");
		Rcols1+=GoodsReportTool.addNewColumn("Goods");
		Rcols1+=GoodsReportTool.addNewColumn("Details");
		Rcols1+=GoodsReportTool.addNewColumn("Charges");


	}

	void setColumnsAlignment()
	{

		tool.setColumnAlignment(0,ReportTool.ALIGN_CENTER);
		tool.setColumnAlignment(1,ReportTool.ALIGN_CENTER);

		GoodsReportTool.setColumnAlignment(0,ReportTool.ALIGN_CENTER);
		GoodsReportTool.setColumnAlignment(1,ReportTool.ALIGN_CENTER);
		GoodsReportTool.setColumnAlignment(2,ReportTool.ALIGN_CENTER);
		GoodsReportTool.setColumnAlignment(3,ReportTool.ALIGN_CENTER);

	}

	void setColumnsWidth()
	{

		tool.setColumnWidth("CountryID",80);
		tool.setColumnWidth("CountryName",200);

		GoodsReportTool.setColumnWidth("Sr_No",80);
		GoodsReportTool.setColumnWidth("Goods",200);
		GoodsReportTool.setColumnWidth("Details",200);
		GoodsReportTool.setColumnWidth("Charges",200);

	}

	void setGoodsData()
	{
		GoodsReportTool.removeAllRows();

		clsBookingDetailReport Data[] = clsBookingDetailReport.getBookingDetailReportInformation(vBookingID);

		for(int i=0;i<Data.length;i++)
		{
			Object Objectdata[]=new Object[Rcols1];

			Objectdata[0]=Data[i].getBookingDetailID();
			Objectdata[1]=Data[i].getGoodsName();
			Objectdata[2]=Data[i].getDetails();
			Objectdata[3]=Data[i].getCharges();

			GoodsReportTool.addNewRow(Objectdata);
		}
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
		if(ae.getSource()==btnNew)
		{

			initUI();
			PrintDocketNo = clsGenerateDocket.getNewDocketNo();
			PanelState.enabledComponents(pnlUI);
			PanelState.disabledComponents(pnlbtnConfirm);
			PanelState.disabledComponents(pnlbtnAddGoods);
			PanelState.disabledComponents(pnlbtnFinish);

			ConsignmentStatus = 1 ;

		}
		else if(ae.getSource()==btnView)
		{

			PanelState.enabledComponents(pnlApply);
			PanelState.enabledComponents(pnlCombo1);

			txtDocketNoUpdate.requestFocus();
			initUI();

		}
		else if(ae.getSource()== btnCancel)
		{


		}
		else if(ae.getSource()==btnReport)
		{

		}
		else if(ae.getSource()==btnClose)
		{

		}

		else if(ae.getSource()==btnSave)
		{

		}

		else if(ae.getSource()==btnApply)
		{
			if( ! txtDocketNoUpdate.getText().isEmpty())
			{
				setApplyPanelState();
				PanelState.disabledComponents(pnlApply);
				PanelState.disabledComponents(pnlCombo1);


				String mdocketNo = "Trans-Doc-";

				mdocketNo = mdocketNo + txtDocketNoUpdate.getText();
				int mGenerateDocketID = clsGenerateDocket.getIDFromName(mdocketNo);
				System.out.println(mGenerateDocketID);

				int mBookingID = clsBooking.getBookingID(mGenerateDocketID);
				System.out.println(mBookingID);

				clsBookingReport temp = clsBookingReport.getBookingReportInformation(mBookingID);
				clsBookingReport.showBooking(temp);

				initUI();

				loadBookingDetails(temp);
				ConsignmentStatus = 2 ;

				PanelState.enabledComponents(pnlbtnAddClient);
				PanelState.enabledComponents(pnlbtnSourceDepot);
				PanelState.enabledComponents(pnlbtnDestinationDepot);
				PanelState.enabledComponents(pnlbtnSelectVehicle);
				PanelState.enabledComponents(pnlbtnAddParty);
			}

		}
		else if(ae.getSource()==btnEdit)
		{


		}
		else if(ae.getSource()==btnUpdate)
		{
			initUI();
		}
		else if(ae.getSource()==btnDelete)
		{
			initUI();
		}
		else if(ae.getSource() == cmbClient)
		{

			if(cmbClient.getSelectedIndex() == 0)
			{
				//JOptionPane.showMessageDialog(null,"Select the Client...");
			}
			else
			{
				String mClientName = (String)cmbClient.getSelectedItem();
				vClientID = clsClient.getIDFromName(mClientName);
				clsClient temp = clsClient.getClientInformation(vClientID);
				PrintClientName = mClientName;
				lblAddressInfo.setText("<html><div style='width:320px;'><b>Address:</b> " + temp.getAddress() + "</div></html>");
				lblEmailInfo.setText("Email ID : "+temp.getEmailID());
				lblContactInfo.setText("Contact No : "+temp.getContactNo());

			}
		}
		else if(ae.getSource() == cmbSourceDepot)
		{
			if(cmbSourceDepot.getSelectedIndex() == 0)
			{
				//JOptionPane.showMessageDialog(null,"Select the Source Depot...");
			}
			else
			{
				String mDepotName = (String)cmbSourceDepot.getSelectedItem();
				vSourceDepotID = clsDepot.getIDFromName(mDepotName);
				clsDepot temp = clsDepot.getDepotInformation(vSourceDepotID);
				PrintSourceDepotName = mDepotName;

				lblSourceDepotAddressInfo.setText("<html><div style='width:320px;'><b>Address:</b> " + temp.getAddress() + "</div></html>");
				lblSourceDepotEmailInfo.setText("Email ID : "+temp.getEmailID());
				lblSourceDepotContactInfo.setText("Contact No : "+temp.getContactNo());
				lblSourceDepotContactPersonInfo.setText("Contact Person : "+temp.getContactPerson());

			}
		}

		else if(ae.getSource() == cmbDestinationDepot)
		{
			if(cmbDestinationDepot.getSelectedIndex() == 0)
			{
				//JOptionPane.showMessageDialog(null,"Select the Destination Depot...");
			}
			else
			{
				String mDepotName = (String)cmbDestinationDepot.getSelectedItem();
				vDestinationDepotID = clsDepot.getIDFromName(mDepotName);
				clsDepot temp = clsDepot.getDepotInformation(vDestinationDepotID);
				PrintDestinationDepotName = mDepotName;

				lblDestinationDepotAddressInfo.setText("<html><div style='width:320px;'><b>Address:</b> " + temp.getAddress() + "</div></html>");
				lblDestinationDepotEmailInfo.setText("Email ID : "+temp.getEmailID());
				lblDestinationDepotContactInfo.setText("Contact No : "+temp.getContactNo());
				lblDestinationDepotContactPersonInfo.setText("Contact Person : "+temp.getContactPerson());

				if( vDestinationDepotID == vSourceDepotID)
				{
					btnGoToSelectVehicle.setEnabled(false);
					JOptionPane.showMessageDialog(null,"Source and Destination are same...");
				}
				if( vDestinationDepotID != vSourceDepotID)
				{
					btnGoToSelectVehicle.setEnabled(true);
				}
			}
		}
		else if(ae.getSource() == cmbVehicleType)
		{
			if(cmbVehicleType.getSelectedIndex() == 0)
			{
				//JOptionPane.showMessageDialog(null,"Select the Vehicle Type...");
				cmbVehicle.setSelectedIndex(0);
			}
			else
			{
				String mVehicleTypeName = (String)cmbVehicleType.getSelectedItem();
				int mVehicleTypeID = clsVehicleType.getIDFromName(mVehicleTypeName);

				vVehicleTypeID = mVehicleTypeID ;
				PrintVehicleTypeName = mVehicleTypeName ;

				addVehicleRecordsByDepotID(cmbVehicle,vSourceDepotID,mVehicleTypeID);
			}
		}
		else if(ae.getSource() == cmbVehicle)
		{
			if(cmbVehicleType.getSelectedIndex() == 0)
			{
				//JOptionPane.showMessageDialog(null,"Select the Vehicle...");
			}
			else
			{
				String mVehicleNumber = (String)cmbVehicle.getSelectedItem();
				vVehicleID = clsVehicle.getIDFromName(mVehicleNumber);
				PrintVehicleNumber = mVehicleNumber;
				clsVehicle temp =  clsVehicle.getVehicleInformation(vVehicleID);

				lblVehicleNameInfo.setText("Vehicle Number : "+temp.getVehicleNumber())	;
				lblVehicleContactPersonInfo.setText("Contact Person : "+temp.getContactPerson()) ;
				lblVehicleDriverNameInfo.setText("Driver Name : "+temp.getDriverName()) ;
				lblVehicleLicenceNoInfo.setText("Licence No : "+temp.getLicenceNo()) ;

			}
		}
		else if(ae.getSource() == btnLoadConsignment)
		{
			PanelState.visibleComponents(pnlDocket);
			PanelState.hideComponents(pnlClient);
			PanelState.hideComponents(pnlSourceDepot);
			PanelState.hideComponents(pnlParty);
			PanelState.hideComponents(pnlDestinationDepot);
			PanelState.hideComponents(pnlVehicleType);

			//JOptionPane.showMessageDialog(null, "LOAD : " + vBookingID);

			if(ConsignmentStatus == 1)
			{
				PrintBookingDate = DateUtil.getTodayDate();
				txtBookingDate.setText(PrintBookingDate);

				txtDocketNo.setText(PrintDocketNo);
				txtBookingID.setText("0");

				disableElementsOfNewConsignment();
			}

		}
		else if(ae.getSource() == btnAddClient)
		{
			PanelState.hideComponents(pnlDocket);
			PanelState.visibleComponents(pnlClient);
			PanelState.hideComponents(pnlSourceDepot);
			PanelState.hideComponents(pnlParty);
			PanelState.hideComponents(pnlDestinationDepot);
			PanelState.hideComponents(pnlVehicleType);

			//JOptionPane.showMessageDialog(null, "CLIENT: " + vBookingID);

		}
		else if(ae.getSource() == btnSourceDepot)
		{
			PanelState.hideComponents(pnlDocket);
			PanelState.hideComponents(pnlClient);
			PanelState.visibleComponents(pnlSourceDepot);
			PanelState.hideComponents(pnlParty);
			PanelState.hideComponents(pnlDestinationDepot);
			PanelState.hideComponents(pnlVehicleType);

			//JOptionPane.showMessageDialog(null, "SOURCE: " + vBookingID);

		}
		else if(ae.getSource() == btnDestinationDepot)
		{
			PanelState.hideComponents(pnlDocket);
			PanelState.hideComponents(pnlClient);
			PanelState.hideComponents(pnlSourceDepot);
			PanelState.hideComponents(pnlParty);
			PanelState.visibleComponents(pnlDestinationDepot);
			PanelState.hideComponents(pnlVehicleType);

			//JOptionPane.showMessageDialog(null, "DESTINATION: " + vBookingID);

		}
		else if(ae.getSource() == btnSelectVehicle)
		{
			PanelState.hideComponents(pnlDocket);
			PanelState.hideComponents(pnlClient);
			PanelState.hideComponents(pnlSourceDepot);
			PanelState.hideComponents(pnlParty);
			PanelState.hideComponents(pnlDestinationDepot);
			PanelState.visibleComponents(pnlVehicleType);

			//JOptionPane.showMessageDialog(null, "SELECT VEHICLE: " + vBookingID);

		}
		else if(ae.getSource() == btnAddParty)
		{
			PanelState.hideComponents(pnlDocket);
			PanelState.hideComponents(pnlClient);
			PanelState.hideComponents(pnlSourceDepot);
			PanelState.visibleComponents(pnlParty);
			PanelState.hideComponents(pnlDestinationDepot);
			PanelState.hideComponents(pnlVehicleType);

			//JOptionPane.showMessageDialog(null, "ADDpARTY: " + vBookingID);

		}
		else if(ae.getSource()==btnConfirm)
		{
			PanelState.disabledComponents(pnlbtnNewConsignment);
			PanelState.disabledComponents(pnlbtnAddClient);
			PanelState.disabledComponents(pnlbtnSourceDepot);
			PanelState.disabledComponents(pnlbtnDestinationDepot);
			PanelState.disabledComponents(pnlbtnAddParty);
			PanelState.disabledComponents(pnlbtnSelectVehicle);
			PanelState.enabledComponents(pnlbtnAddGoods);
			PanelState.enabledComponents(pnlbtnFinish);
			PanelState.disabledComponents(pnlbtnConfirm);
			PanelState.disabledComponents(pnlCancelConsignment);

			PanelState.hideComponents(pnlParty);
			PanelState.visibleComponents(pnlMessageDisplay);

			lblGoodsDocketNo.setText(lblGoodsDocketNo.getText() + " : " + PrintDocketNo);
			lblClientName.setText(lblClientName.getText() + " : " +PrintClientName );
			lblGoodsBookingDate.setText(lblGoodsBookingDate.getText() + " : " + PrintBookingDate );
			lblGoodsSourceDepot.setText(lblGoodsSourceDepot.getText() + " : " + PrintSourceDepotName );
			lblGoodsDestinationDepot.setText(lblGoodsDestinationDepot.getText() + " : " + PrintDestinationDepotName);
			txtDeliveryParty.getText();

			lblGoodsPartyName.setText(lblGoodsPartyName.getText() + " " +txtDeliveryParty.getText());
			lblGoodsPartyAddress.setText(lblGoodsPartyAddress.getText()+ " " +txtAddress.getText());
			lblGoodsPartyContactNo.setText(lblGoodsPartyContactNo.getText()+ " " +txtContactNo.getText());

			//JOptionPane.showMessageDialog(null, "cONFIRM: " + vBookingID);

			if(ConsignmentStatus == 1 )
			{
				clsGenerateDocket temp1 = readUI2() ;
				clsGenerateDocket.addNewGenerateDocket(temp1);

				vBookingID = vGenerateDocketID;

				clsBooking temp2 = readUI();
				clsBooking.showBooking(temp2);
				clsBooking.addNewBooking(temp2);
			}
			else
			{
				setGoodsData();
			}

		}
		else if(ae.getSource() == btnAddGoods)
		{
			PanelState.hideComponents(pnlDocket);
			PanelState.hideComponents(pnlClient);
			PanelState.hideComponents(pnlSourceDepot);
			PanelState.hideComponents(pnlParty);
			PanelState.hideComponents(pnlDestinationDepot);
			PanelState.hideComponents(pnlVehicleType);
			PanelState.enabledComponents(pnlGoods);

			//JOptionPane.showMessageDialog(null, "addGoods: " + vBookingID);

			setGoodsData();

		}
		else if(ae.getSource() == btnFinish)
		{
			PanelState.disabledComponents(pnlbtnAddGoods);
			setUIPanelState();
			PanelState.disabledComponents(pnlGoods);

			if (cmbClient.getSelectedIndex() != 0 && cmbSourceDepot.getSelectedIndex() != 0 &&
			    cmbDestinationDepot.getSelectedIndex() != 0 &&cmbVehicleType.getSelectedIndex() != 0 &&
			    cmbVehicle.getSelectedIndex() != 0 && cmbGoods.getSelectedIndex() != 0)
			{
			    cmbClient.setSelectedIndex(0);
			    cmbSourceDepot.setSelectedIndex(0);
			    cmbDestinationDepot.setSelectedIndex(0);
			    cmbVehicleType.setSelectedIndex(0);
			    cmbVehicle.setSelectedIndex(0);
			    cmbGoods.setSelectedIndex(0);
			}
		}
		else if(ae.getSource() == btnCancelConsignment)
		{

		}

		else if(ae.getSource() == cmbGoods)
		{
			String mGoods= (String)cmbGoods.getSelectedItem();
			vGoodsID= clsGoods.getIDFromName(mGoods);

		}
		else if(ae.getSource()==btnSaveGoodsRecord)
		{
			clsBookingDetail temp = readUI3();

			clsBookingDetail.addNewBookingDetail(temp);
			lblGoodsReportDocketNo.setText(PrintDocketNo);

			setGoodsData();

		}
		else if(ae.getSource()==btnNewDocGoods)
		{

			btnNewDocGoods.setVisible(false);
			btnRefreshDocGoods.setVisible(true);
			frmGoods A = new frmGoods();
		}
		else if(ae.getSource()==btnRefreshDocGoods)
		{

			btnNewDocGoods.setVisible(true);
			btnRefreshDocGoods.setVisible(false);
			addGoodsRecord(cmbGoods);
		}
		else if(ae.getSource()==btnNewDocClient)
		{

			btnNewDocClient.setVisible(false);
			btnRefreshDocClient.setVisible(true);
			frmClient A = new frmClient();
		}
		else if(ae.getSource()==btnRefreshDocClient)
		{

			btnNewDocClient.setVisible(true);
			btnRefreshDocClient.setVisible(false);
			addClientRecords(cmbClient);
		}
		else if(ae.getSource()==btnNewDocVehicle)
		{

			btnNewDocVehicle.setVisible(false);
			btnRefreshDocVehicle.setVisible(true);
			frmVehicle A = new frmVehicle();
		}
		else if(ae.getSource()==btnRefreshDocVehicle)
		{

			btnNewDocVehicle.setVisible(true);
			btnRefreshDocVehicle.setVisible(false);
			addVehicleRecords(cmbVehicle);
		}
		else if(ae.getSource()==btnBackToConsignment)
		{
			PanelState.hideComponents(pnlClient);
			PanelState.visibleComponents(pnlDocket);

		}
		else if(ae.getSource()==btnGoToClient)
		{
			PanelState.enabledComponents(pnlbtnAddClient);
			PanelState.hideComponents(pnlDocket);
			PanelState.visibleComponents(pnlClient);

		}
		else if(ae.getSource()==btnGoToSourceDepot)
		{
			PanelState.enabledComponents(pnlbtnSourceDepot);
			PanelState.hideComponents(pnlClient);
			PanelState.visibleComponents(pnlSourceDepot);

		}
		else if(ae.getSource()==btnBackToClient)
		{
			PanelState.hideComponents(pnlSourceDepot);
			PanelState.visibleComponents(pnlClient);
		}
		else if(ae.getSource()==btnGoToDestinationDepot)
		{
			PanelState.enabledComponents(pnlbtnDestinationDepot);
			PanelState.hideComponents(pnlSourceDepot);
			PanelState.visibleComponents(pnlDestinationDepot);

		}
		else if(ae.getSource()==btnBackToSourceDepot)
		{
			PanelState.hideComponents(pnlDestinationDepot);
			PanelState.visibleComponents(pnlSourceDepot);
		}
		else if(ae.getSource()==btnGoToSelectVehicle)
		{
			PanelState.enabledComponents(pnlbtnSelectVehicle);
			PanelState.hideComponents(pnlDestinationDepot);
			PanelState.visibleComponents(pnlVehicleType);

		}
		else if(ae.getSource()==btnBackToDestinationDepot)
		{
			PanelState.hideComponents(pnlVehicleType);
			PanelState.visibleComponents(pnlDestinationDepot);

		}
		else if(ae.getSource()==btnGoToAddParty)
		{
			PanelState.enabledComponents(pnlbtnAddParty);
			PanelState.hideComponents(pnlVehicleType);
			PanelState.visibleComponents(pnlParty);
		}
		else if(ae.getSource()==btnBackToSelectVehicle)
		{
			PanelState.hideComponents(pnlParty);
			PanelState.visibleComponents(pnlVehicleType);
		}
		else if(ae.getSource()==btnPressToConfirm)
		{
			if (txtDeliveryParty.getText().isEmpty() || txtContactNo.getText().isEmpty() ||
			    txtEmailID.getText().isEmpty() || txtAddress.getText().isEmpty())
			{
			    JOptionPane.showMessageDialog(null , "Fill Out Party Information First !");
		   	}
		   	if((txtDeliveryParty.getText().isEmpty() || txtContactNo.getText().isEmpty() ||
			    txtEmailID.getText().isEmpty() || txtAddress.getText().isEmpty()) == false)
			{
				PanelState.enabledComponents(pnlbtnConfirm);
			}

		}
		else if(ae.getSource()==btnDeleteGoodsRecord)
		{
			int selectedRow = MyTable.getSelectedRow();
			int selectedColumn = MyTable.getSelectedColumn();

			if (selectedRow != -1 && selectedColumn != -1)
			{
				Object selectedValue = MyTable.getValueAt(selectedRow, 0);
				int mBookingDetailID = (int)selectedValue;
				//JOptionPane.showMessageDialog(null, "Selected Value: " + selectedValue);
				clsBookingDetail temp1 = clsBookingDetail.getBookingDetailInformation(mBookingDetailID);
				clsBookingDetail.deleteBookingDetail(temp1);

				setGoodsData();

			}
			else
			{
				JOptionPane.showMessageDialog(null, "No cell selected.");
			}
		}

	}
	void addClientRecords(JComboBox temp)
	{
		temp.removeActionListener(this);
		clsClient.addClientRecords(temp);
		temp.addActionListener(this);

	}

	void addDepotRecords(JComboBox temp)
	{
		temp.removeActionListener(this);
		clsDepot.addDepotRecords(temp);
		temp.addActionListener(this);

	}

	void addVehicleTypeRecords(JComboBox temp)
	{
		temp.removeActionListener(this);
		clsVehicleType.addVehicleTypeRecords(temp);
		temp.addActionListener(this);

	}
	void addGoodsRecord(JComboBox temp)
	{
		temp.removeActionListener(this);
		clsGoods.addGoodsRecords(temp);
		temp.addActionListener(this);
	}
	void addVehicleRecords(JComboBox temp,int mVehicleTypeID)
	{
		temp.removeActionListener(this);
		clsVehicle.addVehicleRecords(temp,mVehicleTypeID);
		temp.addActionListener(this);

	}
	void addVehicleRecordsByDepotID(JComboBox temp,int mDepotID,int mVehicleTypeID)
	{
		temp.removeActionListener(this);
		clsVehicle.addVehicleRecordsByDepotID(temp,mDepotID,mVehicleTypeID);
		temp.addActionListener(this);

	}

	void addVehicleRecords(JComboBox temp)
	{

		temp.removeActionListener(this);
		clsVehicle.addVehicleRecords(temp);
		temp.addActionListener(this);

	}
	void disableElementsOfNewConsignment()
	{
		txtBookingDate.setEnabled(false);
		txtDocketNo.setEnabled(false);
		txtBookingID.setEnabled(false);
	}
	public static void main(String args[])
	{
		frmBooking f = new frmBooking();
	}
}