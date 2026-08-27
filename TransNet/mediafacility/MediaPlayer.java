package mediafacility;
import appsetting.*;
import myUtility.*;
import java.awt.*;
import javax.swing.*;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaView;
import java.io.File;

public class MediaPlayer extends JPanel
{
	JPanel    pnlMain ;

	JPanel   pnlTop ;
	JPanel   pnlLeft ;
	JPanel   pnlRight ;
	JPanel   pnlBottom ;
	JPanel   pnlCenter ;

	JPanel   pnlProgramHeading ;

	JPanel   pnlButton ;

	JPanel   pnlLeftTop ;
	JPanel   pnlLeftBottom ;

	JPanel   pnlLeftImage1 ;
	JPanel   pnlLeftImage2 ;

	JPanel   pnlRightImage1 ;
	JPanel   pnlRightImage2 ;
	JPanel   pnlRightImage3 ;

	JLabel lblLeftImage1 ;
	JLabel lblLeftImage2 ;

	JLabel lblRightImage1 ;
	JLabel lblRightImage2 ;
	JLabel lblRightImage3 ;

	JLabel lblTop ;

	JLabel lblProgramHeading ;

	JLabel lblDevelopedBy ;
	JLabel lblMembers ;

	JPanel pnlNew ;
	JButton btnNew ;

	JPanel pnlView ;
	JButton btnView ;

	JPanel pnlReport ;
	JButton btnReport ;

	JPanel pnlClose ;
	JButton btnClose ;

	JPanel pnlSave ;
	JButton btnSave ;

	JPanel pnlCancel ;
	JButton btnCancel ;

	JPanel pnlApply ;
	JButton btnApply ;

	JPanel pnlDelete ;
	JButton btnDelete ;

	JPanel pnlEdit ;
	JButton btnEdit ;

	JPanel pnlUpdate ;
	JButton btnUpdate ;

	JPanel pnlCombo1 ;
	JComboBox cmbCombo1;
	JLabel lblCombo1;

	JPanel pnlUI ;
	JPanel pnlUIReport ;

	JPanel pnlGodImage;
	JLabel lblGodImage;

	JPanel pnlProjectLogo;
	JLabel lblProjectLogo;

	JPanel   pnlBottomLeft ;
	JPanel   pnlBottomRight ;

	JLabel lblQuote;
	// JLabel lblDevelopedBy;

	//JPanel pnlGodImage;
	//JLabel lblGodImage;


	//JPanel pnlProjectLogo;
	//JLabel lblProjectLogo;

	public MediaPlayer()
	{
		setSize(1920,1080);
		setLocation(0,0);
		setLayout(null);


		pnlMain = new JPanel();
		pnlMain.setBounds(0,0,1920,1080);
		pnlMain.setLayout(null);
		pnlMain.setBackground(ColorSetting.getBackColorMainPnl());
		add(pnlMain);

       /*pnlTop = new JPanel();
       pnlTop.setBounds(130,5,1655,100);
       pnlTop.setLayout(null);
       pnlTop.setBackground(ColorSetting.getBackColorTopPnl());*/

		pnlTop = new JPanel();
		pnlTop.setBounds(130,5,1655,100);
		pnlTop.setLayout(null);
		pnlTop.setBackground(ColorSetting.getBackColorTopPnl());

		lblTop=new JLabel(ProjectMenuSetting.getTopLabel(),JLabel.CENTER);
		lblTop.setFont(new Font("Times New Roman",Font.PLAIN,40));
		lblTop.setForeground(Color.BLACK);
		lblTop.setBounds(0,0,1655,100);
		pnlTop.add(lblTop);

		pnlGodImage=new JPanel();
		pnlGodImage.setBounds(5,5,120,100);
		pnlGodImage.setLayout(null);
		pnlGodImage.setBackground(Color.BLACK);
		pnlMain.add(pnlGodImage);

		ImageIcon imggod = new ImageIcon("\"D:/Aditya_Project_TransNet/Images/godimage.jpg");
		Image imagegod = imggod.getImage();
		Image newimagegod= imagegod.getScaledInstance(120,100,java.awt.Image.SCALE_SMOOTH);
		Icon godicon = new ImageIcon(newimagegod);

		lblGodImage=new JLabel(godicon);
		lblGodImage.setFont(new Font("Times New Roman",Font.PLAIN,40));
		lblGodImage.setBounds(0,0,120,100);
		pnlGodImage.add(lblGodImage);

		pnlProjectLogo=new JPanel();
		pnlProjectLogo.setBounds(1790,5,124,100);
		pnlProjectLogo.setLayout(null);
		pnlProjectLogo.setBackground(Color.BLACK);
		pnlMain.add(pnlProjectLogo);

		ImageIcon imglogo = new ImageIcon("\"D:/Aditya_Project_TransNet/Images/projectlogo.jpg");
		Image logo = imglogo.getImage();
		Image newlogo= logo.getScaledInstance(124,100,java.awt.Image.SCALE_SMOOTH);
		Icon ProjectLogo = new ImageIcon(newlogo);

		lblProjectLogo=new JLabel(ProjectLogo);
		lblProjectLogo.setBounds(0,0,124,100);
		pnlProjectLogo.add(lblProjectLogo);

		pnlLeft = new JPanel();
		pnlLeft.setBounds(5,110,400,770);
		pnlLeft.setLayout(null);
		pnlLeft.setBackground(ColorSetting.getBackColorLeftPnl());

		pnlRight = new JPanel();
		pnlRight.setBounds(1515,110,400,770);
		pnlRight.setLayout(null);
		pnlRight.setBackground(ColorSetting.getBackColorRightPnl());


		pnlBottom = new JPanel();
		pnlBottom.setBounds(5,885,1910,100);
		pnlBottom.setLayout(null);
		pnlBottom.setBackground(ColorSetting.getBackColorBottomPnl());

		pnlBottomLeft = new JPanel();
		pnlBottomLeft.setBounds(5,885,550,100);
		pnlBottomLeft.setLayout(null);
		pnlBottomLeft.setBackground(ColorSetting.getBackColorBottomPnl());

		pnlBottomRight = new JPanel();
		pnlBottomRight.setBounds(560,885,1354,100);
		pnlBottomRight.setLayout(null);
		pnlBottomRight.setBackground(MenuColorSetting.getBackColorBottomRightPanel());

		pnlProgramHeading=new JPanel();
		pnlProgramHeading.setBounds(410,110,1100,70);
		pnlProgramHeading.setLayout(null);
		pnlProgramHeading.setBackground(ColorSetting.getBackColorHeadPnl());

		pnlButton=new JPanel();
		pnlButton.setBounds(410,810,1100,70);
		pnlButton.setLayout(null);
		pnlButton.setBackground(ColorSetting.getBackColorButtonPnl());

		pnlCenter = new JPanel();
		pnlCenter.setBounds(410,185,1100,620);
		pnlCenter.setLayout(null);
		pnlCenter.setBackground(ColorSetting.getBackColorCenterPnl());

       /*JLayeredPane layeredPane = new JLayeredPane();
       layeredPane.setBounds(0,0,1100,620);
       pnlCenter.add(layeredPane);8*/


		lblQuote=new JLabel("Our Talent Spins the World...!",JLabel.CENTER);
		lblQuote.setBounds(0,25,550,50);
		lblQuote.setFont(new Font("Tahoma",Font.PLAIN,20));
		lblQuote.setForeground(Color.BLACK);
		pnlBottomLeft.add(lblQuote);


		lblDevelopedBy=new JLabel("Developed By",JLabel.CENTER);
		lblDevelopedBy.setBounds(0,0,1354,50);
		lblDevelopedBy.setForeground(Color.BLACK);
		pnlBottomRight.add(lblDevelopedBy);

		lblMembers=new JLabel("Members",JLabel.CENTER);
		lblMembers.setBounds(0,60,1354,50);
		lblMembers.setForeground(Color.BLACK);
		pnlBottomRight.add(lblMembers);


       /*lblDevelopedBy=new JLabel("Developed By",JLabel.CENTER);
       lblDevelopedBy.setBounds(0,0,1354,50);
       lblDevelopedBy.setForeground(Color.BLACK);
       pnlBottomRight.add(lblDevelopedBy);*/

		pnlUI = new JPanel();
		pnlUI.setBounds(0,0,1200,700);
		pnlUI.setLayout(null);
		pnlUI.setBackground(ColorSetting.getBackColorPnlUI());
		pnlCenter.add(pnlUI);

       /* pnlUI = new JPanel() {
          @Override
          protected void paintComponent(Graphics g) {
             super.paintComponent(g);
             ImageIcon backgroundIcon = new ImageIcon("D:\Aditya_Project_TransNet\Images\pnlUI2.jpg");
             Image backgroundImage = backgroundIcon.getImage();
             g.drawImage(backgroundImage, 0, 0, 400,150, this);
          }
        };
       pnlUI.setBounds(0,0,400,150);
       pnlUI.setOpaque(false);
       pnlUI.setLayout(null);
       pnlUI.setBackground(ColorSetting.getBackColorPnlUI());
       pnlCenter.add(pnlUI);*/
		// JavaFX Panel for Video Background

		JFXPanel jfxPanel = new JFXPanel();
		jfxPanel.setBounds(0,0,700,700);
		pnlUI.add(jfxPanel, JLayeredPane.DEFAULT_LAYER);

		Platform.runLater(() -> {
			File videoFile = new File("\"D:/Aditya_Project_TransNet/Images/WhatsApp Video 2025-02-21 at 5.13.05 PM.mp4");
			Media media = new Media(videoFile.toURI().toString());

			javafx.scene.media.MediaPlayer mediaPlayer =
					new javafx.scene.media.MediaPlayer(media);

			MediaView mediaView = new MediaView(mediaPlayer);
			mediaView.setFitWidth(700);
			mediaView.setFitHeight(550);

			Scene scene = new Scene(new javafx.scene.Group(mediaView));
			jfxPanel.setScene(scene);

			mediaPlayer.setCycleCount(javafx.scene.media.MediaPlayer.INDEFINITE);
			mediaPlayer.play();
		});




		pnlUIReport = new JPanel();
		pnlUIReport.setBounds(0,0,50,50);
		pnlUIReport.setLayout(null);
		pnlUIReport.setBackground(Color.YELLOW);
		pnlCenter.add(pnlUIReport);



		pnlMain.add(pnlTop);
		pnlMain.add(pnlLeft);
		pnlMain.add(pnlRight);
		pnlMain.add(pnlBottomLeft);
		pnlMain.add(pnlBottomRight);
		pnlMain.add(pnlProgramHeading);
		pnlMain.add(pnlButton);
		pnlMain.add(pnlCenter);

		pnlLeftTop = new JPanel();
		pnlLeftTop.setBounds(5,5,390,445);
		pnlLeftTop.setLayout(null);
		pnlLeftTop.setBackground(ColorSetting.getBackColorLeftUpPnl());

		pnlLeftBottom = new JPanel();
		pnlLeftBottom.setBounds(5,455,390,310);
		pnlLeftBottom.setLayout(null);
		pnlLeftBottom.setBackground(ColorSetting.getBackColorLeftDownPnl());

		pnlLeft.add(pnlLeftTop);
		pnlLeft.add(pnlLeftBottom);

		pnlCombo1 = new JPanel();
		pnlCombo1.setBounds(5,5,380,80);
		pnlCombo1.setLayout(null);
		pnlCombo1.setBackground(ColorSetting.getBackColorCombo1Pnl());
		pnlLeftTop.add(pnlCombo1);

		pnlApply= new JPanel();
		pnlApply.setBounds(5,90,380,80);
		pnlApply.setLayout(null);
		pnlApply.setBackground(ColorSetting.getBackColorApplyPnl());
		pnlLeftTop.add(pnlApply);

		lblCombo1=new JLabel("Combobox1");
		lblCombo1.setBounds(40,5,100,20);
		lblCombo1.setForeground(Color.BLACK);
		pnlCombo1.add(lblCombo1);

		cmbCombo1=new JComboBox();
		cmbCombo1.setBounds(40,35,300,40);
		pnlCombo1.add(cmbCombo1);

		btnApply=new JButton("Apply");
		btnApply.setBounds(5,5,370,70);
		btnApply.setLayout(null);
		pnlApply.add(btnApply);

		pnlLeftImage1 = new JPanel();
		pnlLeftImage1.setBounds(5,175,380,265);
		pnlLeftImage1.setLayout(null);
		pnlLeftImage1.setBackground(ColorSetting.getBackColorLeftPnl());
		pnlLeftTop.add(pnlLeftImage1);

		pnlLeftImage2 = new JPanel();
		pnlLeftImage2.setBounds(5,5,380,300);
		pnlLeftImage2.setLayout(null);
		pnlLeftImage2.setBackground(ColorSetting.getBackColorLeftPnl());
		pnlLeftBottom.add(pnlLeftImage2);

		pnlRightImage1 = new JPanel();
		pnlRightImage1.setBounds(5,5,390,250);
		pnlRightImage1.setLayout(null);
		pnlRightImage1.setBackground(ColorSetting.getBackColorRightPnl());
		pnlRight.add(pnlRightImage1);

		pnlRightImage2 = new JPanel();
		pnlRightImage2.setBounds(5,260,390,250);
		pnlRightImage2.setLayout(null);
		pnlRightImage2.setBackground(ColorSetting.getBackColorRightPnl());
		pnlRight.add(pnlRightImage2);

		pnlRightImage3 = new JPanel();
		pnlRightImage3.setBounds(5,515,390,250);
		pnlRightImage3.setLayout(null);
		pnlRightImage3.setBackground(ColorSetting.getBackColorRightPnl());
		pnlRight.add(pnlRightImage3);

		lblLeftImage1=new JLabel(new ImageIcon("LeftImage1.png"));
		lblLeftImage1.setBounds(0,0,380,265);
		pnlLeftImage1.add(lblLeftImage1);

		lblLeftImage2=new JLabel(new ImageIcon("LeftImage2.png"));
		lblLeftImage2.setBounds(0,0,380,300);
		pnlLeftImage2.add(lblLeftImage2);

		lblRightImage1=new JLabel(new ImageIcon("RightImage1.jpg"));
		lblRightImage1.setBounds(0,0,390,250);
		pnlRightImage1.add(lblRightImage1);

		lblRightImage2=new JLabel(new ImageIcon("RightImage2.png"));
		lblRightImage2.setBounds(0,0,390,250);
		pnlRightImage2.add(lblRightImage2);

		lblRightImage3=new JLabel(new ImageIcon("RightImage3.jpg"));
		lblRightImage3.setBounds(0,0,390,250);
		pnlRightImage3.add(lblRightImage3);

		int x1=115,w1=100,g1=10;

		pnlNew=new JPanel();
		pnlNew.setBounds(x1,15,w1,40);
		pnlNew.setLayout(null);
		pnlNew.setBackground(ColorSetting.getBackColorButtonPnl());
		pnlButton.add(pnlNew);

		x1=x1+w1+g1;

		pnlSave=new JPanel();
		pnlSave.setBounds(x1,15,w1,40);
		pnlSave.setLayout(null);
		pnlSave.setBackground(ColorSetting.getBackColorButtonPnl());
		pnlButton.add(pnlSave);

		x1=x1+w1+g1;

		pnlView=new JPanel();
		pnlView.setBounds(x1,15,w1,40);
		pnlView.setLayout(null);
		pnlView.setBackground(ColorSetting.getBackColorButtonPnl());
		pnlButton.add(pnlView);

		x1=x1+w1+g1;

		pnlEdit=new JPanel();
		pnlEdit.setBounds(x1,15,w1,40);
		pnlEdit.setLayout(null);
		pnlEdit.setBackground(ColorSetting.getBackColorButtonPnl());
		pnlButton.add(pnlEdit);

		x1=x1+w1+g1;

		pnlUpdate=new JPanel();
		pnlUpdate.setBounds(x1,15,w1,40);
		pnlUpdate.setLayout(null);
		pnlUpdate.setBackground(ColorSetting.getBackColorButtonPnl());
		pnlButton.add(pnlUpdate);

		x1=x1+w1+g1;

		pnlDelete=new JPanel();
		pnlDelete.setBounds(x1,15,w1,40);
		pnlDelete.setBackground(ColorSetting.getBackColorButtonPnl());
		pnlDelete.setLayout(null);
		pnlButton.add(pnlDelete);

		x1=x1+w1+g1;

		pnlCancel=new JPanel();
		pnlCancel.setBounds(x1,15,w1,40);
		pnlCancel.setBackground(ColorSetting.getBackColorButtonPnl());
		pnlCancel.setLayout(null);
		pnlButton.add(pnlCancel);

		x1=x1+w1+g1;

		pnlReport=new JPanel();
		pnlReport.setBounds(x1,15,w1,40);
		pnlReport.setBackground(ColorSetting.getBackColorButtonPnl());
		pnlReport.setLayout(null);
		pnlButton.add(pnlReport);

		pnlClose=new JPanel();
		pnlClose.setBounds(x1,15,w1,40);
		pnlClose.setBackground(ColorSetting.getBackColorButtonPnl());
		pnlClose.setLayout(null);
		pnlButton.add(pnlClose);

		btnNew=new JButton("New");
		btnNew.setBounds(5,5,90,30);
		btnNew.setForeground(new Color(0,0,0));
		pnlNew.add(btnNew);


		btnSave=new JButton("Save");
		btnSave.setBounds(5,5,90,30);
		btnSave.setForeground(new Color(0,0,0));
		pnlSave.add(btnSave);


		btnView=new JButton("View");
		btnView.setBounds(5,5,90,30);
		btnView.setForeground(new Color(0,0,0));
		pnlView.add(btnView);


		btnEdit=new JButton("Edit");
		btnEdit.setBounds(5,5,90,30);
		btnEdit.setForeground(new Color(0,0,0));
		pnlEdit.add(btnEdit);


		btnUpdate=new JButton("Update");
		btnUpdate.setBounds(5,5,90,30);
		btnUpdate.setForeground(new Color(0,0,0));
		pnlUpdate.add(btnUpdate);


		btnDelete=new JButton("Delete");
		btnDelete.setBounds(5,5,90,30);
		btnDelete.setForeground(new Color(0,0,0));
		pnlDelete.add(btnDelete);


		btnCancel=new JButton("Cancel");
		btnCancel.setBounds(5,5,90,30);
		btnCancel.setForeground(new Color(0,0,0));
		pnlCancel.add(btnCancel);


		btnReport=new JButton("Report");
		btnReport.setBounds(5,5,90,30);
		btnReport.setForeground(new Color(0,0,0));
		pnlReport.add(btnReport);

		btnClose=new JButton("Close");
		btnClose.setBounds(5,5,90,30);
		btnClose.setForeground(new Color(0,0,0));
		pnlClose.add(btnClose);

       /*lblTop=new JLabel(ProjectSetting.getTopLabel(),JLabel.CENTER);
       lblTop.setFont(new Font("Times New Roman",Font.BOLD,45));
       lblTop.setForeground(Color.BLACK);
       lblTop.setBounds(0,0,1910,100);
       pnlTop.add(lblTop);*/

		lblProgramHeading=new JLabel("S A L E S    E X P O S U R E",JLabel.CENTER);
		lblProgramHeading.setBounds(0,0,1100,70);
		lblProgramHeading.setFont(new Font("Tahoma",Font.BOLD,25));
		lblProgramHeading.setForeground(Color.BLACK);
		pnlProgramHeading.add(lblProgramHeading);

		lblDevelopedBy=new JLabel("Developed By",JLabel.CENTER);
		lblDevelopedBy.setBounds(0,0,1910,50);
		lblDevelopedBy.setFont(new Font("Times New Roman",Font.BOLD,25));
		lblDevelopedBy.setForeground(Color.BLACK);
		pnlBottom.add(lblDevelopedBy);

		lblMembers=new JLabel("Members",JLabel.CENTER);
		lblMembers.setBounds(0,50,1910,50);
		lblMembers.setFont(new Font("Times New Roman",Font.BOLD,25));
		lblMembers.setForeground(Color.BLACK);
		pnlBottom.add(lblMembers);


		setDefaultSettings();
	}

	void setDefaultSettings()
	{
		PanelState.disabledComponents(pnlNew);
		PanelState.disabledComponents(pnlSave);
		PanelState.disabledComponents(pnlView);
		PanelState.disabledComponents(pnlEdit);
		PanelState.disabledComponents(pnlUpdate);
		PanelState.disabledComponents(pnlDelete);
		PanelState.disabledComponents(pnlCancel);
		PanelState.disabledComponents(pnlReport);


		PanelState.disabledComponents(pnlCombo1);

		PanelState.disabledComponents(pnlApply);
		PanelState.hideComponents(pnlUIReport);
		PanelState.hideComponents(pnlClose);


	}

	public JLabel getlblProgramHeading()
	{
		return(lblProgramHeading);
	}

	public JPanel getNewPanel()
	{
		return(pnlNew);
	}
	public JPanel getMainPanel()
	{
		return(pnlMain);
	}

	public JButton getNewButton()
	{
		return(btnNew);
	}

	public JPanel getViewPanel()
	{
		return(pnlView);
	}

	public JButton getViewButton()
	{
		return(btnView);
	}

	public JPanel getReportPanel()
	{
		return(pnlReport);
	}



	public JButton getReportButton()
	{
		return(btnReport);
	}
	public JPanel getClosePanel()
	{
		return(pnlClose);
	}

	public JButton getCloseButton()
	{
		return(btnClose);
	}

	public JPanel getUiPanel()
	{
		return(pnlUI);
	}

	public JPanel getSavePanel()
	{
		return(pnlSave);
	}

	public JButton getSaveButton()
	{
		return(btnSave);
	}
	public JPanel getCancelPanel()
	{
		return(pnlCancel);
	}
	public JButton getCancelButton()
	{
		return(btnCancel);
	}

	public JPanel getCombo1Panel()
	{
		return(pnlCombo1);
	}

	public JLabel getFirstComboLabel()
	{
		return(lblCombo1);
	}
	public JComboBox getFirstCombo()
	{
		return(cmbCombo1);
	}


	public JPanel getApplyPanel()
	{
		return(pnlApply);
	}

	public JButton getApplyButton()
	{
		return(btnApply);
	}

	public JPanel getDeletePanel()
	{
		return(pnlDelete);
	}

	public JButton getDeleteButton()
	{
		return(btnDelete);
	}

	public JPanel getEditPanel()
	{
		return(pnlEdit);
	}

	public JButton getEditButton()
	{
		return(btnEdit);
	}

	public JPanel getUpdatePanel()
	{
		return(pnlUpdate);
	}

	public JButton getUpdateButton()
	{
		return(btnUpdate);
	}

	public JPanel getUIPanel()
	{
		return(pnlUI);
	}
	public JPanel getUIReportPanel()
	{
		return(pnlUIReport);
	}

}