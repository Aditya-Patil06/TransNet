package screensetting;
import javax.swing.*;
import java.awt.*;
import appsetting.*;
import myUtility.*;

public class ScreenDesign3 extends JPanel {
    private JPanel pnlMain;
    private JPanel pnlTop;
    private JPanel pnlGodLogo;
    private JPanel pnlProjectLogo;
    private JPanel pnlBottomRight;
    private JPanel pnlBottomLeft;
    private JPanel pnlLeft;
    private JPanel pnlRight;
    private JPanel pnlProgramHeading;
    private JPanel pnlCenter;
    private JPanel pnlButton;
    private JPanel pnlLeftUp;
    private JPanel pnlLeftDown;
    private JPanel pnlApply;
    private JPanel pnlUI;
    private JPanel pnlUIReport;
    private JPanel pnlSave;
    private JPanel pnlDelete;
    private JPanel pnlUpdate;
    private JPanel pnlNew;
    private JPanel pnlView;
    private JPanel pnlEdit;
    private JPanel pnlCancel;
    private JPanel pnlReport;
    private JPanel pnlCombo1;
    private JPanel pnlCombo2;
    private JPanel pnlCombo3;
    private JPanel pnlClose;
    private JPanel pnlMovingGif; // Added

    private JButton btnSave;
    private JButton btnDelete;
    private JButton btnUpdate;
    private JButton btnNew;
    private JButton btnView;
    private JButton btnEdit;
    private JButton btnCancel;
    private JButton btnReport;
    private JButton btnClose;
    private JButton btnApply;

    private JLabel lblProject;
    private JLabel lblProgramHeading;
    private JLabel lblDevelopedBy;
    private JLabel lblmember1;
    private JLabel lblmember2;
    private JLabel lblmember3;
    private JLabel lblShip1;
    private JLabel lblTruck1;
    private JLabel lblCombo1;
    private JLabel lblCombo2;
    private JLabel lblCombo3;
    private JLabel lblGalaxy;
    private JLabel lblGodImage;
    private JLabel lblCenterImage;
    private JLabel lblProjectLogo;
    private JLabel lblImageScroll; // Added

    private ImageIcon imgShip1;
    private ImageIcon imgTruck1;

    private JComboBox<String> cmbCombo1;
    private JComboBox<String> cmbCombo2;
    private JComboBox<String> cmbCombo3;

    public ScreenDesign3() {
        setVisible(true);
        setSize(1920, 1080);
        setLayout(null);

        pnlMain = new JPanel();
        pnlMain.setLayout(null);
        pnlMain.setSize(1920, 1080);
        pnlMain.setBackground(Color.RED);
        add(pnlMain);

        pnlTop = createPanel(170, 0, 1580, 100, Color.BLACK);
        pnlGodLogo = createPanel(0, 0, 165, 100, Color.BLACK);
        pnlProjectLogo = createPanel(1755, 0, 165, 100, Color.RED);
        pnlBottomRight = createPanel(445, 900, 1475, 100, Color.BLACK);
        pnlBottomLeft = createPanel(0, 900, 440, 100, Color.RED);
        pnlLeft = createPanel(0, 105, 290, 790, Color.GRAY);
        pnlRight = createPanel(1630, 105, 290, 790, Color.BLACK);
        pnlCenter = createPanel(295, 160, 1330, 670, Color.YELLOW);
        pnlProgramHeading = createPanel(295, 105, 1330, 50, Color.GREEN);
        pnlButton = createPanel(295, 835, 1330, 60, Color.GREEN);
        pnlMovingGif = createPanel(0, 930, 1920, 60, Color.RED); // Added
        pnlMovingGif.setOpaque(false); // Added

        pnlLeftUp = createPanel(5, 5, 280, 315, Color.WHITE);
        pnlCombo1 = createPanel(5, 5, 270, 80, Color.LIGHT_GRAY);
        pnlCombo2 = createPanel(5, 90, 270, 80, Color.LIGHT_GRAY);
        pnlCombo3 = createPanel(5, 175, 270, 80, Color.LIGHT_GRAY);
        pnlApply = createPanel(5, 260, 270, 50, Color.LIGHT_GRAY);
        pnlLeftDown = createPanel(2, 325, 290, 460, Color.BLACK);

        pnlUI = createPanel(5, 5, 1320, 660, Color.BLACK);
        pnlUIReport = createPanel(5, 5, 1320, 660, Color.YELLOW);

        pnlSave = createPanel(180, 5, 120, 50, Color.BLACK);
        pnlDelete = createPanel(820, 5, 120, 50, Color.BLACK);
        pnlUpdate = createPanel(660, 5, 120, 50, Color.BLACK);
        pnlNew = createPanel(30, 5, 120, 50, Color.BLACK);
        pnlView = createPanel(340, 5, 120, 50, Color.BLACK);
        pnlEdit = createPanel(495, 5, 120, 50, Color.BLACK);
        pnlCancel = createPanel(980, 5, 120, 50, Color.BLACK);
        pnlReport = createPanel(1170, 5, 120, 50, Color.BLACK);
        pnlClose = createPanel(1170, 5, 120, 50, Color.BLACK);

        // Add panels to main panel
        pnlMain.add(pnlMovingGif); // Added
        pnlMain.add(pnlTop);
        pnlMain.add(pnlGodLogo);
        pnlMain.add(pnlProjectLogo);
        pnlMain.add(pnlBottomRight);
        pnlMain.add(pnlBottomLeft);
        pnlMain.add(pnlLeft);
        pnlMain.add(pnlRight);
        pnlMain.add(pnlCenter);
        pnlMain.add(pnlProgramHeading);
        pnlMain.add(pnlButton);

        // Moving GIF label setup
        lblImageScroll = new JLabel(new ImageIcon("D:/Aditya_Project_TransNet/Truck/project_Logo_image.gif")); // Added
        lblImageScroll.setFont(new Font("Arial", Font.BOLD, 22)); // Added
        lblImageScroll.setBounds(0, 1, 100, 60); // Added
        pnlMovingGif.add(lblImageScroll); // Added
        new ScrollLabelLeft(lblImageScroll, 5, pnlMovingGif); // Added (assuming ScrollLabelLeft exists)

        pnlLeft.add(pnlLeftUp);
        pnlLeftUp.add(pnlCombo1);
        pnlLeftUp.add(pnlCombo2);
        pnlLeftUp.add(pnlCombo3);
        pnlLeftUp.add(pnlApply);
        pnlLeft.add(pnlLeftDown);

        pnlCenter.add(pnlUI);
        pnlCenter.add(pnlUIReport);

        pnlButton.add(pnlSave);
        pnlButton.add(pnlDelete);
        pnlButton.add(pnlUpdate);
        pnlButton.add(pnlNew);
        pnlButton.add(pnlView);
        pnlButton.add(pnlEdit);
        pnlButton.add(pnlCancel);
        pnlButton.add(pnlReport);
        pnlButton.add(pnlClose);

        lblGodImage = new JLabel(new ImageIcon("D:/Aditya_Project_TransNet/Truck/God_image_1.png"));
        lblGodImage.setBounds(0, 0, 165, 100);
        pnlGodLogo.add(lblGodImage);

        lblProjectLogo = new JLabel(new ImageIcon("D:/Aditya_Project_TransNet/Truck/project_Logo_image.gif"));
        lblProjectLogo.setBounds(0, 0, 165, 100);
        pnlProjectLogo.add(lblProjectLogo);

        lblGalaxy = new JLabel("Our Talent Spins The World ...");
        lblGalaxy.setFont(new Font("Arial", Font.BOLD, 20));
        lblGalaxy.setForeground(Color.WHITE);
        lblGalaxy.setBounds(50, 30, 300, 25);
        pnlBottomLeft.add(lblGalaxy);

        lblDevelopedBy = new JLabel("Developed By,");
        lblDevelopedBy.setFont(new Font("Arial", Font.BOLD, 20));
        lblDevelopedBy.setForeground(Color.WHITE);
        lblDevelopedBy.setBounds(700, 10, 300, 25);
        pnlBottomRight.add(lblDevelopedBy);

        lblmember1 = new JLabel("1. Mayur Chaudhari");
        lblmember1.setFont(new Font("Arial", Font.BOLD, 16));
        lblmember1.setForeground(Color.WHITE);
        lblmember1.setBounds(420, 50, 200, 20);
        pnlBottomRight.add(lblmember1);

        lblmember2 = new JLabel("2. Aditya Patil");
        lblmember2.setFont(new Font("Arial", Font.BOLD, 16));
        lblmember2.setForeground(Color.WHITE);
        lblmember2.setBounds(620, 50, 200, 20);
        pnlBottomRight.add(lblmember2);

        lblmember3 = new JLabel("3. Tejas Kankhare");
        lblmember3.setFont(new Font("Arial", Font.BOLD, 16));
        lblmember3.setForeground(Color.WHITE);
        lblmember3.setBounds(820, 50, 200, 20);
        pnlBottomRight.add(lblmember3);

        lblProject = new JLabel("My Project Here...");
        lblProject.setFont(new Font("Arial", Font.BOLD, 26));
        lblProject.setForeground(Color.WHITE);
        lblProject.setBounds(700, 30, 250, 30);
        pnlTop.add(lblProject);

        lblCombo1 = new JLabel("Label is not set");
        lblCombo1.setBounds(5, 5, 260, 30);
        pnlCombo1.add(lblCombo1);

        lblCombo2 = new JLabel("Label is not set");
        lblCombo2.setBounds(5, 5, 260, 30);
        pnlCombo2.add(lblCombo2);

        lblCombo3 = new JLabel("Label is not set");
        lblCombo3.setBounds(5, 5, 260, 30);
        pnlCombo3.add(lblCombo3);

        lblCenterImage = new JLabel(new ImageIcon("D:/Aditya_Project_TransNet/Truck/image_Center_1.png"));
        lblCenterImage.setBounds(0, 0, 1330, 670);
        pnlCenter.add(lblCenterImage);

        lblProgramHeading = new JLabel("...Transportation Management System...");
        lblProgramHeading.setFont(new Font("Arial", Font.BOLD, 22));
        lblProgramHeading.setBounds(470, 10, 800, 30);
        pnlProgramHeading.add(lblProgramHeading);
		new ScrollLabel(lblProgramHeading,5 , pnlProgramHeading);

        btnApply = new JButton("Apply");
        btnApply.setBounds(5, 5, 260, 40);
        pnlApply.add(btnApply);

        btnSave = new JButton("Save");
        btnSave.setBounds(5, 5, 110, 40);
        pnlSave.add(btnSave);

        btnDelete = new JButton("Delete");
        btnDelete.setBounds(5, 5, 110, 40);
        pnlDelete.add(btnDelete);

        btnUpdate = new JButton("Update");
        btnUpdate.setBounds(5, 5, 110, 40);
        pnlUpdate.add(btnUpdate);

        btnNew = new JButton("New");
        btnNew.setBounds(5, 5, 110, 40);
        pnlNew.add(btnNew);

        btnView = new JButton("View");
        btnView.setBounds(5, 5, 110, 40);
        pnlView.add(btnView);

        btnEdit = new JButton("Edit");
        btnEdit.setBounds(5, 5, 110, 40);
        pnlEdit.add(btnEdit);

        btnCancel = new JButton("Cancel");
        btnCancel.setBounds(5, 5, 110, 40);
        pnlCancel.add(btnCancel);

        btnReport = new JButton("Report");
        btnReport.setBounds(5, 5, 110, 40);
        pnlReport.add(btnReport);

        btnClose = new JButton("Close");
        btnClose.setBounds(5, 5, 110, 40);
        pnlClose.add(btnClose);

        cmbCombo1 = new JComboBox<>();
        cmbCombo1.addItem("No Records....");
        cmbCombo1.setBounds(5, 40, 260, 30);
        pnlCombo1.add(cmbCombo1);

        cmbCombo2 = new JComboBox<>();
        cmbCombo2.addItem("No Records....");
        cmbCombo2.setBounds(5, 40, 260, 30);
        pnlCombo2.add(cmbCombo2);

        cmbCombo3 = new JComboBox<>();
        cmbCombo3.addItem("No Records....");
        cmbCombo3.setBounds(5, 40, 260, 30);
        pnlCombo3.add(cmbCombo3);

        imgShip1 = new ImageIcon("D:/Aditya_Project_TransNet/Truck/image_Left.jpg");
        lblShip1 = new JLabel(imgShip1);
        lblShip1.setBounds(3, 3, 280, 633);
        pnlLeftDown.add(lblShip1);

        imgTruck1 = new ImageIcon("D:/Aditya_Project_TransNet/Truck/image_Right.jpg");
        lblTruck1 = new JLabel(imgTruck1);
        lblTruck1.setBounds(3, 3, 285, 783);
        pnlRight.add(lblTruck1);

        setColors();
        setDefaultSetting();
		increaseButtonFontSize(16);

    }

	public void increaseButtonFontSize(int fontSize) {
        Font currentFont = btnSave.getFont();
        Font newFont = new Font(currentFont.getName(), currentFont.getStyle(), fontSize);

        btnSave.setFont(newFont);
        btnDelete.setFont(newFont);
        btnUpdate.setFont(newFont);
        btnNew.setFont(newFont);
        btnView.setFont(newFont);
        btnEdit.setFont(newFont);
        btnCancel.setFont(newFont);
        btnReport.setFont(newFont);
        btnClose.setFont(newFont);
        btnApply.setFont(newFont);
    }

    private JPanel createPanel(int x, int y, int width, int height, Color color) {
        JPanel panel = new JPanel();
        panel.setBounds(x, y, width, height);
        panel.setBackground(color);
        panel.setLayout(null);
        return panel;
    }

    private void setColors() {
        pnlTop.setBackground(ColorSetting.getBackColorTopPnl());
        pnlGodLogo.setBackground(ColorSetting.getBackColorTopPnl());
        pnlProjectLogo.setBackground(ColorSetting.getBackColorTopPnl());
        pnlBottomRight.setBackground(ColorSetting.getBackColorBottomPnl());
        pnlBottomLeft.setBackground(ColorSetting.getBackColorBottomPnl());
        pnlCenter.setBackground(ColorSetting.getBackColorCenterPnl());
        pnlProgramHeading.setBackground(ColorSetting.getBackColorHeadPnl());
        pnlButton.setBackground(ColorSetting.getBackColorButtonPnl());
        pnlMain.setBackground(ColorSetting.getBackColorMainPnl());
        pnlLeft.setBackground(ColorSetting.getBackColorLeftPnl());
        pnlRight.setBackground(ColorSetting.getBackColorRightPnl());
        pnlLeftDown.setBackground(ColorSetting.getBackColorLeftDownPnl());
        pnlCombo1.setBackground(ColorSetting.getBackColorCombo1Pnl());
        pnlCombo2.setBackground(ColorSetting.getBackColorCombo1Pnl());
        pnlCombo3.setBackground(ColorSetting.getBackColorCombo1Pnl());
        pnlApply.setBackground(ColorSetting.getBackColorApplyPnl());
        pnlUI.setBackground(ColorSetting.getBackColorPnlUI());
        pnlLeftUp.setBackground(ColorSetting.getBackColorHeadPnl());
        pnlMovingGif.setBackground(ColorSetting.getBackColorMainPnl()); // Added (optional, since it�s non-opaque)

        btnApply.setBackground(ColorSetting.getBackColorButton());
        btnSave.setBackground(ColorSetting.getBackColorButton());
        btnUpdate.setBackground(ColorSetting.getBackColorButton());
        btnDelete.setBackground(ColorSetting.getBackColorButton());
        btnReport.setBackground(ColorSetting.getBackColorButton());
        btnNew.setBackground(ColorSetting.getBackColorButton());
        btnEdit.setBackground(ColorSetting.getBackColorButton());
        btnView.setBackground(ColorSetting.getBackColorButton());
        btnCancel.setBackground(ColorSetting.getBackColorButton());
        btnClose.setBackground(ColorSetting.getBackColorButton());

        lblProgramHeading.setText(ProjectSetting.getProjectTitle());
        lblProgramHeading.setForeground((ColorSetting.getTextColor()));
        lblProject.setText(ProjectSetting.getProject());
        lblProject.setForeground((ColorSetting.getTextColor()));
    }

    private void setDefaultSetting() {
        PanelState.disabledComponents(pnlSave);
        PanelState.disabledComponents(pnlDelete);
        PanelState.disabledComponents(pnlUpdate);
        PanelState.disabledComponents(pnlNew);
        PanelState.disabledComponents(pnlView);
        PanelState.disabledComponents(pnlEdit);
        PanelState.disabledComponents(pnlCancel);
        PanelState.disabledComponents(pnlReport);
        PanelState.disabledComponents(pnlCombo1);
        PanelState.disabledComponents(pnlCombo2);
        PanelState.disabledComponents(pnlCombo3);
        PanelState.disabledComponents(pnlApply);
        PanelState.hideComponents(pnlUIReport);
        PanelState.hideComponents(pnlClose);
    }

    // Existing getter methods remain unchanged
    public JLabel getlblCombo1() {
        return lblCombo1;
    }

    public JLabel getlblProgramHeading() {
        return lblProgramHeading;
    }

    public JPanel getpnlUIReport() {
        return pnlUIReport;
    }

    public JPanel getpnlUI() {
        return pnlUI;
    }

    public JPanel getNewPanel() {
        return pnlNew;
    }

    public JButton getNewButton() {
        return btnNew;
    }

    public JPanel getSavePanel() {
        return pnlSave;
    }

    public JButton getSaveButton() {
        return btnSave;
    }

    public JPanel getReportPanel() {
        return pnlReport;
    }

    public JButton getReportButton() {
        return btnReport;
    }

    public JPanel getViewPanel() {
        return pnlView;
    }

    public JButton getViewButton() {
        return btnView;
    }

    public JPanel getUpdatePanel() {
        return pnlUpdate;
    }

    public JButton getUpdateButton() {
        return btnUpdate;
    }

    public JPanel getDeletePanel() {
        return pnlDelete;
    }

    public JButton getDeleteButton() {
        return btnDelete;
    }

    public JPanel getEditPanel() {
        return pnlEdit;
    }

    public JButton getEditButton() {
        return btnEdit;
    }

    public JPanel getCancelPanel() {
        return pnlCancel;
    }

    public JButton getCancelButton() {
        return btnCancel;
    }

    public JPanel getCombo1Panel() {
        return pnlCombo1;
    }

    public JPanel getCombo2Panel() {
        return pnlCombo2;
    }

    public JPanel getCombo3Panel() {
        return pnlCombo3;
    }

    public JComboBox getcmbCombo1() {
        return cmbCombo1;
    }

    public JComboBox getcmbCombo2() {
        return cmbCombo2;
    }

    public JComboBox getcmbCombo3() {
        return cmbCombo3;
    }

    public JLabel getCombo1() {
        return lblCombo1;
    }

    public JLabel getCombo2() {
        return lblCombo2;
    }

    public JLabel getlblCombo3() {
        return lblCombo3;
    }

    public JPanel getApplyPanel() {
        return pnlApply;
    }

    public JButton getApplyButton() {
        return btnApply;
    }

    public JButton getCloseButton() {
        return btnClose;
    }

    public JPanel getClosePanel() {
        return pnlClose;
    }
}