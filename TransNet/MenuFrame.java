import roundcomponents.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import myUtility.*;
import animation.*;
import org.jdesktop.swingx.JXMonthView;
import java.util.Calendar;

public class MenuFrame extends JFrame implements ActionListener
{
    JPanel pnlBottom;
    JPanel pnlTop;
    JPanel pnlSlider;
    JPanel pnlLeftSlider;
    JPanel pnlLeftOption;
    JPanel pnlCalendar;
    JPanel pnlAboutUsDisplay;

    JPanel pnlMenuOption1;
    JPanel pnlClientOption;
    JPanel pnlDepotOption;
    JPanel pnlVehicleOption;
    JPanel pnlBookingOption;
    JPanel pnlInvoiceOption;
    JPanel pnlVehicleRecords;
    JPanel pnlMenuOption8;
    JPanel pnlAboutUs;
    JPanel pnlCalenderOption;
    JPanel pnlMonthChange;

    JButton btnMenuOption1;
    JButton btnClientOption;
    JButton btnDepotOption;
    JButton btnVehicleOption;
    JButton btnBookingOption;
    JButton btnInvoiceOption;
    JButton btnlVehicleRecords;
    JButton btnMenuOption8;
    JButton btnAboutUs;
    JButton btnCalenderOption;
    JButton btnLeftOption;
    JButton btnNextMonth;
    JButton btnPreviousMonth;

    JPanel[] pnlMenuArray;
    JButton[] btnMenuArray;
    JPanel[] subPanel;
    JButton[] btnSubPanel;

    JPanel[] subPanelInput = new JPanel[5];
    JTextField[] txtSubPanelInput = new JTextField[3];
    JComboBox<String>[] cmbSubPanelInput = new JComboBox[2];
    JButton[] btnSubmitSubPanel = new JButton[5];
    private boolean[] isSubPanelInputVisible = {false, false, false, false, false};

    JPanel pnlInvoiceInput;
    JTextField txtInvoiceInput;
    JButton btnGetInvoice;

    Color PanelActiveColor;
    Color PanelDeactiveColor;

    JPanel pnlVehicleRecordsInput;
    JTextField txtVehicleRecordsInput;
    JButton btnGetVehicleRecords;

    private JXMonthView miniCalendar;

    private boolean isCalendarVisible = false;
    private boolean isLeftSliderVisible = false;
    private boolean isSliderVisible = false; // Added for pnlSlider
    private boolean isInvoiceInputVisible = false; // Added for pnlInvoiceInput
    private boolean isVehicleRecordsInputVisible = false; // Added for pnlVehicleRecordsInput
    private boolean isAboutUsDisplayVisible = false; // Added for pnlAboutUsDisplay

    private IconTextPanelButton aboutButton1;
    private IconTextPanelButton aboutButton2;
    private IconTextPanelButton aboutButton3;

    public MenuFrame()
    {
        setTitle("Menu Frame");
        setSize(1920, 1080);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        PanelActiveColor = new Color(50, 50, 50).brighter().brighter();
        PanelDeactiveColor = new Color(50, 50, 50);

        pnlTop = ImagePanel.getPanel("D:/Aditya_Project_TransNet/Truck/Top_Image_1.jpg");
        pnlTop.setBounds(0, 0, getContentPane().getWidth(), getContentPane().getHeight() - 60);
        pnlTop.setLayout(null);
        pnlTop.setBackground(new Color(40, 40, 40));
        pnlTop.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                resetPanelsToInitialPosition();
            }
        });
        add(pnlTop);

        pnlLeftSlider = new JPanel();
        pnlLeftSlider.setBounds(-500, 0, 500, 930);
        pnlLeftSlider.setBackground(PanelDeactiveColor.darker());
        pnlLeftSlider.setLayout(null);
        pnlTop.add(pnlLeftSlider);
        RoundedPanel.createRoundedPanel(pnlLeftSlider, 30);

        pnlBottom = new JPanel();
        pnlBottom.setBounds(0, getContentPane().getHeight() - 60, getContentPane().getWidth(), 60);
        pnlBottom.setBackground(Color.BLACK);
        pnlBottom.setLayout(null);
        add(pnlBottom);

        pnlLeftOption = new JPanel();
        pnlLeftOption.setBounds(20, 5, 50, 50);
        pnlLeftOption.setLayout(null);
        pnlLeftOption.setBackground(PanelDeactiveColor.darker());
        pnlBottom.add(pnlLeftOption);
        RoundedPanel.createRoundedPanel(pnlLeftOption, 100);

        btnLeftOption = new JButton(new ImageIcon("D:/Aditya_Project_TransNet/Truck/Report_Panel_image_1.png"));
        btnLeftOption.setBounds(5, 5, 40, 40);
        btnLeftOption.addActionListener(this);
        pnlLeftOption.add(btnLeftOption);
        btnLeftOption.setToolTipText("Left Panel Info");
        RoundedPanel.createRoundedButton(btnLeftOption, 100);

        pnlSlider = new JPanel(new GridLayout(3, 3, 10, 10));
        pnlSlider.setBounds(550, 1000, 820, 600);
        pnlSlider.setBackground(new Color(50, 50, 50).darker());
        RoundedPanel.createRoundedPanel(pnlSlider, 50);
        pnlSlider.setVisible(false);
        pnlTop.add(pnlSlider);

        pnlCalendar = new JPanel();
        pnlCalendar.setBounds(1920, 650, 300, 250);
        pnlCalendar.setBackground(new Color(40, 40, 40));
        pnlCalendar.setLayout(new BorderLayout());
        RoundedPanel.createRoundedPanel(pnlCalendar, 20);
        pnlTop.add(pnlCalendar);

        miniCalendar = new JXMonthView();
        miniCalendar.setPreferredSize(new Dimension(250, 200));
        miniCalendar.setBackground(new Color(40, 40, 40));
        miniCalendar.setForeground(Color.WHITE);
        miniCalendar.setTodayBackground(Color.YELLOW);
        miniCalendar.setSelectionBackground(Color.GREEN);
        pnlCalendar.add(miniCalendar, BorderLayout.CENTER);

        pnlMonthChange = new JPanel();
        pnlMonthChange.setLayout(null);
        pnlMonthChange.setPreferredSize(new Dimension(250, 20));
        pnlMonthChange.setBackground(new Color(40, 40, 40));
        pnlCalendar.add(pnlMonthChange, BorderLayout.SOUTH);

        btnNextMonth = new JButton("N");
        btnNextMonth.setBounds(260, 1, 18, 18);
        btnNextMonth.addActionListener(this);
        pnlMonthChange.add(btnNextMonth);

        btnPreviousMonth = new JButton("B");
        btnPreviousMonth.setBounds(40, 1, 18, 18);
        btnPreviousMonth.addActionListener(this);
        pnlMonthChange.add(btnPreviousMonth);

        pnlAboutUsDisplay = new JPanel();
        pnlAboutUsDisplay.setBounds(1580, 1000, 300, 10);
        pnlAboutUsDisplay.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        pnlAboutUsDisplay.setBackground(new Color(50, 50, 50).darker());
        pnlTop.add(pnlAboutUsDisplay);
        RoundedPanel.createRoundedPanel(pnlAboutUsDisplay, 50);

        ImageIcon icon1 = new ImageIcon("D:/Aditya_Project_TransNet/Truck/About_us_Aditya.png");
        aboutButton1 = new IconTextPanelButton(icon1, "  Aditya Patil");
        aboutButton1.addActionListener(this);

        ImageIcon icon2 = new ImageIcon("D:/Aditya_Project_TransNet/Truck/About_us_Tejas.png");
        aboutButton2 = new IconTextPanelButton(icon2, "  Tejas Kankhare");
        aboutButton2.addActionListener(this);

        ImageIcon icon3 = new ImageIcon("D:/Aditya_Project_TransNet/Truck/About_us_Mayur.png");
        aboutButton3 = new IconTextPanelButton(icon3, "  Mayur Chaudhari");
        aboutButton3.addActionListener(this);

        pnlAboutUsDisplay.add(aboutButton1);
        pnlAboutUsDisplay.add(aboutButton2);
        pnlAboutUsDisplay.add(aboutButton3);

        int x = 560;
        int y = 5;
        int w = 50;
        int h = 50;
        int gap = 70;

        int x1 = 5;
        int y1 = 5;
        int w1 = 40;
        int h1 = 40;

        ImageIcon icon = new ImageIcon("D:/Aditya_Project_TransNet/Truck/Standalone_image_1.png");

        Color currentColor = new Color(50, 50, 50).darker();
        pnlMenuOption1 = new JPanel();
        pnlMenuOption1.setBounds(x, y, w, h);
        pnlMenuOption1.setLayout(null);
        pnlMenuOption1.setBackground(currentColor);
        pnlMenuOption1.addMouseListener(new MouseEffect1(pnlMenuOption1, pnlSlider));
        pnlBottom.add(pnlMenuOption1);
        RoundedPanel.createRoundedPanel(pnlMenuOption1, 100);

        btnMenuOption1 = new JButton(icon);
        btnMenuOption1.setBounds(x1, y1, w1, h1);
        btnMenuOption1.addActionListener(this);
        btnMenuOption1.setBorderPainted(false);
        btnMenuOption1.setFocusPainted(false);
        btnMenuOption1.setContentAreaFilled(false);
        btnMenuOption1.setToolTipText("Open Menu");
        pnlMenuOption1.add(btnMenuOption1);
        RoundedPanel.createRoundedButton(btnMenuOption1, 100);

        x = x + gap;

        pnlClientOption = new JPanel();
        pnlClientOption.setBounds(x, y, w, h);
        pnlClientOption.setLayout(null);
        pnlClientOption.setBackground(currentColor);
        pnlClientOption.addMouseListener(new MouseEffect(pnlClientOption, PanelActiveColor, PanelDeactiveColor));
        pnlBottom.add(pnlClientOption);
        RoundedPanel.createRoundedPanel(pnlClientOption, 100);

        btnClientOption = new JButton(new ImageIcon("D:/Aditya_Project_TransNet/Truck/client_image_1.png"));
        btnClientOption.setBounds(x1, y1, w1, h1);
        btnClientOption.addActionListener(this);
        pnlClientOption.add(btnClientOption);
        RoundedPanel.createRoundedButton(btnClientOption, 100);
        btnClientOption.setToolTipText("New Client");

        x = x + gap;

        pnlDepotOption = new JPanel();
        pnlDepotOption.setBounds(x, y, w, h);
        pnlDepotOption.setLayout(null);
        pnlDepotOption.setBackground(currentColor);
        pnlDepotOption.addMouseListener(new MouseEffect(pnlDepotOption, PanelActiveColor, PanelDeactiveColor));
        pnlBottom.add(pnlDepotOption);
        RoundedPanel.createRoundedPanel(pnlDepotOption, 100);

        btnDepotOption = new JButton(new ImageIcon("D:/Aditya_Project_TransNet/Truck/Depot_image_1.png"));
        btnDepotOption.setBounds(x1, y1, w1, h1);
        btnDepotOption.addActionListener(this);
        pnlDepotOption.add(btnDepotOption);
        RoundedPanel.createRoundedButton(btnDepotOption, 100);
        btnDepotOption.setToolTipText("New Depot");

        x = x + gap;

        pnlVehicleOption = new JPanel();
        pnlVehicleOption.setBounds(x, y, w, h);
        pnlVehicleOption.setLayout(null);
        pnlVehicleOption.setBackground(currentColor);
        pnlVehicleOption.addMouseListener(new MouseEffect(pnlVehicleOption, PanelActiveColor, PanelDeactiveColor));
        pnlBottom.add(pnlVehicleOption);
        RoundedPanel.createRoundedPanel(pnlVehicleOption, 100);

        btnVehicleOption = new JButton(new ImageIcon("D:/Aditya_Project_TransNet/Truck/Vehicle_image_1.png"));
        btnVehicleOption.setBounds(x1, y1, w1, h1);
        btnVehicleOption.addActionListener(this);
        pnlVehicleOption.add(btnVehicleOption);
        RoundedPanel.createRoundedButton(btnVehicleOption, 100);
        btnVehicleOption.setToolTipText("New Vehicle");

        x = x + gap;

        pnlBookingOption = new JPanel();
        pnlBookingOption.setBounds(x, y, w, h);
        pnlBookingOption.setLayout(null);
        pnlBookingOption.setBackground(currentColor);
        pnlBookingOption.addMouseListener(new MouseEffect(pnlBookingOption, PanelActiveColor, PanelDeactiveColor));
        pnlBottom.add(pnlBookingOption);
        RoundedPanel.createRoundedPanel(pnlBookingOption, 100);

        btnBookingOption = new JButton(new ImageIcon("D:/Aditya_Project_TransNet/Truck/bookin_image_1.png"));
        btnBookingOption.setBounds(x1, y1, w1, h1);
        btnBookingOption.addActionListener(this);
        pnlBookingOption.add(btnBookingOption);
        RoundedPanel.createRoundedButton(btnBookingOption, 100);
        btnBookingOption.setToolTipText("New Booking");

        x = x + gap;

        pnlInvoiceOption = new JPanel();
        pnlInvoiceOption.setBounds(x, y, w, h);
        pnlInvoiceOption.setLayout(null);
        pnlInvoiceOption.setBackground(currentColor);
        pnlInvoiceOption.addMouseListener(new MouseEffect(pnlInvoiceOption, PanelActiveColor, PanelDeactiveColor));
        pnlBottom.add(pnlInvoiceOption);
        RoundedPanel.createRoundedPanel(pnlInvoiceOption, 100);

        btnInvoiceOption = new JButton(new ImageIcon("D:/Aditya_Project_TransNet/Truck/Bill_image_1.png"));
        btnInvoiceOption.setBounds(x1, y1, w1, h1);
        btnInvoiceOption.addActionListener(this);
        pnlInvoiceOption.add(btnInvoiceOption);
        btnInvoiceOption.setToolTipText("Display Bill");
        RoundedPanel.createRoundedButton(btnInvoiceOption, 100);

        pnlInvoiceInput = new JPanel();
        pnlInvoiceInput.setLayout(null);
        pnlInvoiceInput.setBounds(700, 1000, 400, 80);
        pnlInvoiceInput.setBackground(PanelDeactiveColor.darker());
        pnlTop.add(pnlInvoiceInput);
        RoundedPanel.createRoundedPanel(pnlInvoiceInput, 30);

        txtInvoiceInput = new JTextField("Enter Docket Number");
        txtInvoiceInput.setBounds(20, 20, 300, 40);
        txtInvoiceInput.setForeground(Color.GRAY);
        pnlInvoiceInput.add(txtInvoiceInput);
        RoundedPanel.createRoundedTextField(txtInvoiceInput, 15);

        txtInvoiceInput.addFocusListener(new FocusListener()
        {
            private final String placeholder = "Enter Docket Number";

            public void focusGained(FocusEvent e) {
                txtInvoiceInput.setForeground(Color.BLACK);
                if (txtInvoiceInput.getText().equals(placeholder)) {
                    txtInvoiceInput.setText("");
                }
            }

            public void focusLost(FocusEvent e) {
                if (txtInvoiceInput.getText().isEmpty()) {
                    txtInvoiceInput.setText(placeholder);
                    txtInvoiceInput.setForeground(Color.GRAY);
                }
            }
        });
        btnGetInvoice = new JButton(new ImageIcon("D:/Aditya_Project_TransNet/Truck/Go_image_1.png"));
        btnGetInvoice.setBounds(340, 20, 40, 40);
        btnGetInvoice.addActionListener(this);
        pnlInvoiceInput.add(btnGetInvoice);
        RoundedPanel.createRoundedButton(btnGetInvoice, 100);

        x = x + gap;

        pnlVehicleRecords = new JPanel();
        pnlVehicleRecords.setBounds(x, y, w, h);
        pnlVehicleRecords.setLayout(null);
        pnlVehicleRecords.setBackground(currentColor);
        pnlVehicleRecords.addMouseListener(new MouseEffect(pnlVehicleRecords, PanelActiveColor, PanelDeactiveColor));
        pnlBottom.add(pnlVehicleRecords);
        RoundedPanel.createRoundedPanel(pnlVehicleRecords, 100);

        btnlVehicleRecords = new JButton(new ImageIcon("D:/Aditya_Project_TransNet/Truck/Vehicle_Record_Image_1_1.png"));
        btnlVehicleRecords.setBounds(x1, y1, w1, h1);
        btnlVehicleRecords.addActionListener(this);
        pnlVehicleRecords.add(btnlVehicleRecords);
        btnlVehicleRecords.setToolTipText("Vehicle Records");
        RoundedPanel.createRoundedButton(btnlVehicleRecords, 100);

        pnlVehicleRecordsInput = new JPanel();
        pnlVehicleRecordsInput.setLayout(null);
        pnlVehicleRecordsInput.setBounds(700, 1000, 400, 80);
        pnlVehicleRecordsInput.setBackground(PanelDeactiveColor.darker());
        pnlTop.add(pnlVehicleRecordsInput);
        RoundedPanel.createRoundedPanel(pnlVehicleRecordsInput, 30);

        txtVehicleRecordsInput = new JTextField("Enter Vehicle Number eg :- XX-12 YY-1234");
        txtVehicleRecordsInput.setBounds(20, 20, 300, 40);
        txtVehicleRecordsInput.setForeground(Color.GRAY);
        pnlVehicleRecordsInput.add(txtVehicleRecordsInput);
        RoundedPanel.createRoundedTextField(txtVehicleRecordsInput, 15);

        txtVehicleRecordsInput.addFocusListener(new FocusListener()
        {
            private final String placeholder = "Enter Vehicle Number eg :- XX-12 YY-1234";

            public void focusGained(FocusEvent e) {
                txtVehicleRecordsInput.setForeground(Color.BLACK);
                if (txtVehicleRecordsInput.getText().equals(placeholder)) {
                    txtVehicleRecordsInput.setText("");
                }
            }

            public void focusLost(FocusEvent e) {
                if (txtVehicleRecordsInput.getText().isEmpty()) {
                    txtVehicleRecordsInput.setText(placeholder);
                    txtVehicleRecordsInput.setForeground(Color.GRAY);
                }
            }
        });

        btnGetVehicleRecords = new JButton(new ImageIcon("D:/Aditya_Project_TransNet/Truck/Go_image_1.png"));
        btnGetVehicleRecords.setBounds(340, 20, 40, 40);
        btnGetVehicleRecords.addActionListener(this);
        pnlVehicleRecordsInput.add(btnGetVehicleRecords);
        RoundedPanel.createRoundedButton(btnGetVehicleRecords, 100);

        x = x + gap;

        pnlMenuOption8 = new JPanel();
        pnlMenuOption8.setBounds(x, y, w, h);
        pnlMenuOption8.setLayout(null);
        pnlMenuOption8.setBackground(currentColor);
        pnlMenuOption8.addMouseListener(new MouseEffect(pnlMenuOption8, PanelActiveColor, PanelDeactiveColor));
        pnlBottom.add(pnlMenuOption8);
        RoundedPanel.createRoundedPanel(pnlMenuOption8, 100);

        btnMenuOption8 = new JButton(icon);
        btnMenuOption8.setBounds(x1, y1, w1, h1);
        btnMenuOption8.addActionListener(this);
        pnlMenuOption8.add(btnMenuOption8);
        RoundedPanel.createRoundedButton(btnMenuOption8, 100);

        x = x + gap;

        pnlAboutUs = new JPanel();
        pnlAboutUs.setBounds(1640, y, 200, h);
        pnlAboutUs.setLayout(null);
        pnlAboutUs.setBackground(currentColor);
        pnlAboutUs.addMouseListener(new MouseEffect(pnlAboutUs, PanelActiveColor, PanelDeactiveColor));
        pnlBottom.add(pnlAboutUs);
        RoundedPanel.createRoundedPanel(pnlAboutUs, 30);

        btnAboutUs = new JButton("About Us");
        btnAboutUs.setBounds(x1, y1, 190, h1);
        btnAboutUs.addActionListener(this);
        pnlAboutUs.add(btnAboutUs);
        RoundedPanel.createRoundedButton(btnAboutUs, 30);
        btnAboutUs.setToolTipText("About Us");

        x = x + gap;

        pnlCalenderOption = new JPanel();
        pnlCalenderOption.setBounds(1850, y, w, h);
        pnlCalenderOption.setLayout(null);
        pnlCalenderOption.setBackground(currentColor);
        pnlCalenderOption.addMouseListener(new MouseEffect(pnlCalenderOption, PanelActiveColor, PanelDeactiveColor));
        pnlBottom.add(pnlCalenderOption);
        RoundedPanel.createRoundedPanel(pnlCalenderOption, 100);

        btnCalenderOption = new JButton(new ImageIcon("D:/Aditya_Project_TransNet/Truck/Calender1.png"));
        btnCalenderOption.setBounds(x1, y1, w1, h1);
        btnCalenderOption.addActionListener(this);
        pnlCalenderOption.add(btnCalenderOption);
        RoundedPanel.createRoundedButton(btnCalenderOption, 100);
        btnCalenderOption.setToolTipText("Calender");
        btnCalenderOption.setOpaque(false);
        btnCalenderOption.setContentAreaFilled(false);
        btnCalenderOption.setBorderPainted(false);

        pnlMenuArray = new JPanel[9];
        btnMenuArray = new JButton[9];
        String MenuArrayNames[] = {"Country", "State", "District", "Taluka", "Village", "Area", "Industry", "Vehicle Type", "Goods"};
        String imgpath = "D:/Aditya_Project_TransNet/Truck/butterflyImg.png";

        for (int i = 0; i < pnlMenuArray.length; i++)
        {
            pnlMenuArray[i] = new JPanel();
            pnlMenuArray[i].setLayout(new BorderLayout());
            pnlMenuArray[i].setPreferredSize(new Dimension(180, 180));
            pnlMenuArray[i].setBackground(PanelDeactiveColor);

            JLabel pic = new JLabel(new ImageIcon(imgpath));
            pnlMenuArray[i].add(pic, BorderLayout.CENTER);

            btnMenuArray[i] = new JButton(MenuArrayNames[i]);
            btnMenuArray[i].addActionListener(this);
            btnMenuArray[i].setToolTipText("Country Info");
            RoundedPanel.createRoundedButton(btnMenuArray[i], 20);

            btnMenuArray[i].setOpaque(false);
            btnMenuArray[i].setContentAreaFilled(false);
            btnMenuArray[i].setBorderPainted(false);

            pnlMenuArray[i].addMouseListener(new MouseEffect(pnlMenuArray[i], PanelActiveColor, PanelDeactiveColor));
            pnlMenuArray[i].add(btnMenuArray[i], BorderLayout.SOUTH);

            RoundedPanel.createRoundedPanel(pnlMenuArray[i], 50);
            pnlSlider.add(pnlMenuArray[i]);
        }

        x1 = -500;
        y1 = 10;
        w1 = 480;
        h1 = 105;
        gap = 10;

        subPanel = new JPanel[6];
        btnSubPanel = new JButton[6];

        String[] subPanelLabels = {"Overall Report", "Report Of Date", "Report Of Month", "Report Of Year", "Report Of Depot", "Report Of Client"};
        for (int i = 0; i < subPanel.length; i++)
        {
            subPanel[i] = new JPanel();
            subPanel[i].setBackground(new Color(50, 50, 50));
            subPanel[i].setBounds(x1, y1, w1, h1);
            subPanel[i].setLayout(null);
            pnlLeftSlider.add(subPanel[i]);
            subPanel[i].addMouseListener(new MouseEffect(subPanel[i], PanelActiveColor, PanelDeactiveColor));
            RoundedPanel.createRoundedPanel(subPanel[i], 30);

            btnSubPanel[i] = new JButton(subPanelLabels[i]);
            btnSubPanel[i].setBounds(5, 5, w1-10, h1-10);
            btnSubPanel[i].addMouseListener(new MouseEffect(subPanel[i], PanelActiveColor, PanelDeactiveColor));
            btnSubPanel[i].addActionListener(this);
            btnSubPanel[i].setContentAreaFilled(false);
            btnSubPanel[i].setBorderPainted(false);

            btnSubPanel[i].setFont(new Font("Times New Roman", Font.PLAIN, 20));
            subPanel[i].add(btnSubPanel[i]);
            btnSubPanel[i].setToolTipText(subPanelLabels[i]);
            RoundedPanel.createRoundedButton(btnSubPanel[i], 30);

            y1 = y1 + h1 + gap;
        }

        int x2 = -550;
        int y2 = 125;
        int w2 = 380;
        int h2 = 85;
        int gap2 = 32;

        String[] subPanelPlaceholders = {"Enter Date Of Report in DD/MM/YYYY format","Enter Month Of Report in MM/YYYY format",
                "Enter Year Of Report in YYYY format"};

        String[] depotOptions = {"Depot A", "Depot B", "Depot C"};
        String[] clientOptions = {"Client X", "Client Y", "Client Z"};

        for (int i = 0; i < subPanelInput.length; i++)
        {
            subPanelInput[i] = new JPanel();
            subPanelInput[i].setBackground(new Color(60, 60, 60));
            subPanelInput[i].setBounds(x2, y2, w2, h2);
            subPanelInput[i].setLayout(null);
            pnlTop.add(subPanelInput[i]);
            RoundedPanel.createRoundedPanel(subPanelInput[i], 30);

            if (i < 3)
            {
                txtSubPanelInput[i] = new JTextField(subPanelPlaceholders[i]);
                txtSubPanelInput[i].setBounds(10, 20, 260, 40);
                txtSubPanelInput[i].setForeground(Color.GRAY);
                subPanelInput[i].add(txtSubPanelInput[i]);
                RoundedPanel.createRoundedTextField(txtSubPanelInput[i], 15);

                final String placeholder = subPanelPlaceholders[i];
                txtSubPanelInput[i].addFocusListener(new FocusListener()
                {
                    public void focusGained(FocusEvent e)
                    {
                        JTextField source = (JTextField)e.getSource();
                        source.setForeground(Color.BLACK);
                        if (source.getText().equals(placeholder))
                        {
                            source.setText("");
                        }
                    }
                    public void focusLost(FocusEvent e)
                    {
                        JTextField source = (JTextField)e.getSource();
                        if (source.getText().isEmpty())
                        {
                            source.setText(placeholder);
                            source.setForeground(Color.GRAY);
                        }
                    }
                });
            }
            else
            {
                if (i == 3)
                {
                    cmbSubPanelInput[0] = new JComboBox<>(depotOptions);
                    addDepotRecords(cmbSubPanelInput[0]);
                    RoundedPanel.createRoundedComboBox(cmbSubPanelInput[0],30);
                }
                else
                {
                    cmbSubPanelInput[1] = new JComboBox<>(clientOptions);
                    addClientRecords(cmbSubPanelInput[1]);
                    RoundedPanel.createRoundedComboBox(cmbSubPanelInput[1],30);
                }
                cmbSubPanelInput[i-3].setBounds(10, 20, 260, 40);
                subPanelInput[i].add(cmbSubPanelInput[i-3]);
            }

            btnSubmitSubPanel[i] = new JButton("Submit");
            btnSubmitSubPanel[i].setBounds(280, 20, 90, 40);
            btnSubmitSubPanel[i].addActionListener(this);
            subPanelInput[i].add(btnSubmitSubPanel[i]);
            RoundedPanel.createRoundedButton(btnSubmitSubPanel[i], 20);

            y2 = y2 + h2 + gap2;
        }

        setVisible(true);

        addComponentListener(new ComponentAdapter()
        {
            @Override
            public void componentResized(ComponentEvent e)
            {
                int width = getContentPane().getWidth();
                int height = getContentPane().getHeight();

                pnlTop.setBounds(0, 0, width, height - 60);
                pnlBottom.setBounds(0, height - 60, width, 60);
            }
        });
    }

    private void resetPanelsToInitialPosition()
    {
        ScrollDown.scrollDownside(pnlSlider, 1000, 1);
        SequentialSlideIn.slideInPanels(subPanel, -500, 1, 2);
        ScrollInFromRight.scrollInFromRight(pnlLeftSlider, -500, 1);
        ScrollInFromLeft.scrollInFromLeft(pnlCalendar, 1920, 1);
        ScrollDown.scrollDownside(pnlInvoiceInput, 1000, 1);
        ScrollDown.scrollDownside(pnlAboutUsDisplay, 1000, 1);
        ScrollDown.scrollDownside(pnlVehicleRecordsInput, 1000, 1);

        for (int i = 0; i < subPanelInput.length; i++)
        {
            ScrollInFromLeft.scrollInFromLeft(subPanelInput[i], -550, 1);
            isSubPanelInputVisible[i] = false;
        }

        isCalendarVisible = false;
        isLeftSliderVisible = false;
        isSliderVisible = false;
        isInvoiceInputVisible = false;
        isVehicleRecordsInputVisible = false;
        isAboutUsDisplayVisible = false;
    }

    private void resetInputsToInitialState()
    {
        String[] placeholders = {"Enter Date Of Report in DD/MM/YYYY format","Enter Month Of Report in MM/YYYY format",
                "Enter Year Of Report in YYYY format"};

        for (int i = 0; i < txtSubPanelInput.length; i++)
        {
            txtSubPanelInput[i].setText(placeholders[i]);
            txtSubPanelInput[i].setForeground(Color.GRAY);
        }

        for (int i = 0; i < cmbSubPanelInput.length; i++)
        {
            if (cmbSubPanelInput[i].getItemCount() > 0)
            {
                cmbSubPanelInput[i].setSelectedIndex(0);
                cmbSubPanelInput[i].setForeground(Color.BLACK);
            }
        }
        for (int i = 0; i < subPanelInput.length; i++)
        {
            ScrollInFromRight.scrollInFromRight(subPanelInput[i], -550, 1);
            isSubPanelInputVisible[i] = false;
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

    public void actionPerformed(ActionEvent ae)
    {
        if (ae.getSource() == btnMenuOption1)
        {
            if (!isSliderVisible)
            {
                pnlSlider.setVisible(true);
                ScrollUp.scrollUpside(pnlSlider, 100, 1);
                isSliderVisible = true;
            }
            else
            {
                ScrollDown.scrollDownside(pnlSlider, 1000, 1);
                isSliderVisible = false;
            }
        }
        else if (ae.getSource() == btnMenuArray[0])
        {
            new frmCountry();
        }
        else if (ae.getSource() == btnMenuArray[1])
        {
            new frmState();
        }
        else if (ae.getSource() == btnMenuArray[2])
        {
            new frmDistrict();
        }
        else if (ae.getSource() == btnMenuArray[3])
        {
            new frmTaluka();
        }
        else if (ae.getSource() == btnMenuArray[4])
        {
            new frmVillage();
        }
        else if (ae.getSource() == btnMenuArray[5])
        {
            new frmArea();
        }
        else if (ae.getSource() == btnMenuArray[6])
        {
            new frmIndustry();
        }
        else if (ae.getSource() == btnMenuArray[7])
        {
            new frmVehicleType();
        }
        else if (ae.getSource() == btnMenuArray[8])
        {
            new frmGoods();
        }
        else if (ae.getSource() == btnClientOption)
        {
            new frmClient();
        }
        else if (ae.getSource() == btnVehicleOption)
        {
            new frmVehicle();
        }
        else if (ae.getSource() == btnDepotOption)
        {
            new frmDepot();
        }
        else if (ae.getSource() == btnBookingOption)
        {
            new frmBooking();
        }
        else if (ae.getSource() == btnLeftOption)
        {
            if (!isLeftSliderVisible)
            {
                ScrollInFromLeft.scrollInFromLeft(pnlLeftSlider, 0, 1);
                SequentialSlideIn.slideInPanels(subPanel, 10, 1, 150);
                isLeftSliderVisible = true;
            }
            else
            {
                SequentialSlideIn.slideInPanels(subPanel, -500, 1, 200);
                ScrollInFromRight.scrollInFromRight(pnlLeftSlider, -500, 1);
                isLeftSliderVisible = false;
            }
        }
        else if (ae.getSource() == btnCalenderOption)
        {
            if (!isCalendarVisible)
            {
                ScrollInFromLeft.scrollInFromLeft(pnlCalendar, 1640, 1);
                isCalendarVisible = true;
            }
            else
            {
                ScrollInFromLeft.scrollInFromLeft(pnlCalendar, 1920, 1);
                isCalendarVisible = false;
            }
        }
        else if (ae.getSource() == btnNextMonth)
        {
            Calendar cal = Calendar.getInstance();
            cal.setTime(miniCalendar.getFirstDisplayedDay());
            cal.add(Calendar.MONTH, 1);
            miniCalendar.setFirstDisplayedDay(cal.getTime());
        }
        else if (ae.getSource() == btnPreviousMonth)
        {
            Calendar cal = Calendar.getInstance();
            cal.setTime(miniCalendar.getFirstDisplayedDay());
            cal.add(Calendar.MONTH, -1);
            miniCalendar.setFirstDisplayedDay(cal.getTime());
        }
        else if (ae.getSource() == btnInvoiceOption)
        {
            if (!isInvoiceInputVisible)
            {
                resetPanelsToInitialPosition();
                ScrollUp.scrollUpside(pnlInvoiceInput, 850, 1);
                isInvoiceInputVisible = true;
            }
            else
            {
                ScrollDown.scrollDownside(pnlInvoiceInput, 930, 1);
                isInvoiceInputVisible = false;
            }
        }
        else if (ae.getSource() == btnGetInvoice)
        {
            String docketNumber = txtInvoiceInput.getText().trim();
            if (!docketNumber.equals("Enter Docket Number") && !docketNumber.isEmpty())
            {
                int mGenerateDocketID = clsGenerateDocket.getIDFromName(docketNumber);
                int vBookingID = clsBooking.getBookingID(mGenerateDocketID);

                if (vBookingID > 0)
                {
                    new frmBill(docketNumber);
                    resetPanelsToInitialPosition();
                }
                else
                {
                    txtInvoiceInput.setForeground(Color.RED);
                }
            }
            else
            {
                txtInvoiceInput.setForeground(Color.RED);
            }
        }
        else if (ae.getSource() == btnAboutUs)
        {
            if (!isAboutUsDisplayVisible)
            {
                ScrollUp.scrollUpside(pnlAboutUsDisplay, 700, 1);
                isAboutUsDisplayVisible = true;
            }
            else
            {
                ScrollDown.scrollDownside(pnlAboutUsDisplay, 930, 1);
                isAboutUsDisplayVisible = false;
            }
        }
        else if (ae.getSource() == btnlVehicleRecords)
        {
            if (!isVehicleRecordsInputVisible)
            {
                resetPanelsToInitialPosition();
                ScrollUp.scrollUpside(pnlVehicleRecordsInput, 850, 1);
                isVehicleRecordsInputVisible = true;
            }
            else
            {
                ScrollDown.scrollDownside(pnlVehicleRecordsInput, 930, 1);
                isVehicleRecordsInputVisible = false;
            }
        }
        else if (ae.getSource() == btnGetVehicleRecords)
        {
            String vehicleNumber = txtVehicleRecordsInput.getText().trim();
            int mVehicleID = clsVehicle.getIDFromName(vehicleNumber);
            if (!vehicleNumber.equals("Enter Vehicle Number eg :- XX-12 YY-1234") && !vehicleNumber.isEmpty())
            {
                if (mVehicleID > 0)
                {
                    new frmVehicleRecord(vehicleNumber);
                    resetPanelsToInitialPosition();
                }
                else
                {
                    txtVehicleRecordsInput.setForeground(Color.RED);
                }
            }
            else
            {
                txtVehicleRecordsInput.setForeground(Color.RED);
            }
        }
        else if (ae.getSource() == btnSubPanel[0])
        {
            new frmGeneralBookingReport("Overall", null);
        }
        else if (ae.getSource() == btnSubPanel[1])
        {
            if (!isSubPanelInputVisible[0])
            {
                ScrollInFromLeft.scrollInFromLeft(subPanelInput[0], 500, 1);
                isSubPanelInputVisible[0] = true;
            }
            else
            {
                ScrollInFromLeft.scrollInFromLeft(subPanelInput[0], -550, 1);
                isSubPanelInputVisible[0] = false;
            }
        }
        else if (ae.getSource() == btnSubPanel[2])
        {
            if (!isSubPanelInputVisible[1])
            {
                ScrollInFromLeft.scrollInFromLeft(subPanelInput[1], 500, 1);
                isSubPanelInputVisible[1] = true;
            }
            else
            {
                ScrollInFromLeft.scrollInFromLeft(subPanelInput[1], -550, 1);
                isSubPanelInputVisible[1] = false;
            }
        }
        else if (ae.getSource() == btnSubPanel[3])
        {
            if (!isSubPanelInputVisible[2])
            {
                ScrollInFromLeft.scrollInFromLeft(subPanelInput[2], 500, 1);
                isSubPanelInputVisible[2] = true;
            }
            else
            {
                ScrollInFromLeft.scrollInFromLeft(subPanelInput[2], -550, 1);
                isSubPanelInputVisible[2] = false;
            }
        }
        else if (ae.getSource() == btnSubPanel[4])
        {
            if (!isSubPanelInputVisible[3])
            {
                ScrollInFromLeft.scrollInFromLeft(subPanelInput[3], 500, 1);
                isSubPanelInputVisible[3] = true;
            }
            else
            {
                ScrollInFromLeft.scrollInFromLeft(subPanelInput[3], -550, 1);
                isSubPanelInputVisible[3] = false;
            }
        }
        else if (ae.getSource() == btnSubPanel[5])
        {
            if (!isSubPanelInputVisible[4])
            {
                ScrollInFromLeft.scrollInFromLeft(subPanelInput[4], 500, 1);
                isSubPanelInputVisible[4] = true;
            }
            else
            {
                ScrollInFromLeft.scrollInFromLeft(subPanelInput[4], -550, 1);
                isSubPanelInputVisible[4] = false;
            }
        }
        else if (ae.getSource() == btnSubmitSubPanel[0])
        {
            String dateInput = txtSubPanelInput[0].getText().trim();
            if (!dateInput.equals("Enter Date Of Report in DD/MM/YYYY format") && !dateInput.isEmpty())
            {
                if (dateInput.matches("\\d{2}/\\d{2}/\\d{4}"))
                {
                    new frmGeneralBookingReport("Date", dateInput);
                    ScrollInFromLeft.scrollInFromLeft(subPanelInput[0], -550, 1);
                    isSubPanelInputVisible[0] = false;
                }
                else
                {
                    txtSubPanelInput[0].setForeground(Color.RED);
                }
            }
            resetInputsToInitialState();
        }
        else if (ae.getSource() == btnSubmitSubPanel[1])
        {
            String monthInput = txtSubPanelInput[1].getText().trim();
            if (!monthInput.equals("Enter Month Of Report in MM/YYYY format") && !monthInput.isEmpty())
            {
                if (monthInput.matches("\\d{2}/\\d{4}"))
                {
                    new frmGeneralBookingReport("Month", monthInput);
                    ScrollInFromLeft.scrollInFromLeft(subPanelInput[1], -550, 1);
                    isSubPanelInputVisible[1] = false;
                }
                else
                {
                    txtSubPanelInput[1].setForeground(Color.RED);
                }
            }
            resetInputsToInitialState();
        }
        else if (ae.getSource() == btnSubmitSubPanel[2])
        {
            String yearInput = txtSubPanelInput[2].getText().trim();
            if (!yearInput.equals("Enter Year Of Report in YYYY format") && !yearInput.isEmpty())
            {
                if (yearInput.matches("\\d{4}"))
                {
                    new frmGeneralBookingReport("Year", yearInput);
                    ScrollInFromLeft.scrollInFromLeft(subPanelInput[2], -550, 1);
                    isSubPanelInputVisible[2] = false;
                }
                else
                {
                    txtSubPanelInput[2].setForeground(Color.RED);
                }
            }
            resetInputsToInitialState();
        }
        else if (ae.getSource() == btnSubmitSubPanel[3])
        {
            String selectedDepot = (String) cmbSubPanelInput[0].getSelectedItem();
            if (selectedDepot != null && !selectedDepot.isEmpty())
            {
                int depotID = clsDepot.getIDFromName(selectedDepot);
                if (depotID > 0)
                {
                    clsGeneralBookingReport[] depotBookings = clsGeneralBookingReport.getDepotBookingReportInformation(depotID);
                    if (depotBookings != null && depotBookings.length > 0)
                    {
                        new frmDepotBookingReport(depotID, selectedDepot);
                        ScrollInFromLeft.scrollInFromLeft(subPanelInput[3], -550, 1);
                        isSubPanelInputVisible[3] = false;
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(this, "No booking records found for depot: " + selectedDepot, "Info", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
                else
                {
                    cmbSubPanelInput[0].setForeground(Color.RED);
                }
            }
            resetInputsToInitialState();
        }
        else if (ae.getSource() == btnSubmitSubPanel[4])
        {
            String selectedClient = (String) cmbSubPanelInput[1].getSelectedItem();
            if (selectedClient != null && !selectedClient.isEmpty())
            {
                int clientID = clsClient.getIDFromName(selectedClient);
                if (clientID > 0)
                {
                    clsGeneralBookingReport[] clientBookings = clsGeneralBookingReport.getClientBookingReportInformation(clientID);
                    if (clientBookings != null && clientBookings.length > 0)
                    {
                        new frmClientBookingReport(clientID, selectedClient);
                        ScrollInFromLeft.scrollInFromLeft(subPanelInput[4], -550, 1);
                        isSubPanelInputVisible[4] = false;
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(this, "No booking records found for client: " + selectedClient, "Info", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
                else
                {
                    cmbSubPanelInput[1].setForeground(Color.RED);
                }
            }
            resetInputsToInitialState();
        }
        else if (ae.getSource() == aboutButton1)
        {
            OpenWebSite.openPage("https://adityaportfolio069.tiiny.site");
        }
        else if (ae.getSource() == aboutButton2)
        {
            OpenWebSite.openPage("https://tejasportfolio1.tiiny.site");
        }
        else if (ae.getSource() == aboutButton3)
        {
            OpenWebSite.openPage("https://mayurportfolio1.tiiny.site");
        }
    }

    public static void main(String[] args)
    {
        MenuFrame a = new MenuFrame();
    }
}

class MouseEffect extends MouseAdapter
{
    JPanel buttonPanel;
    Color secondEffect = new Color(50, 50, 50).darker();
    Color firstEffect = new Color(50, 50, 50).brighter();
    Color PanelActiveColor, PanelDeactiveColor;

    MouseEffect(JPanel buttonPanel, Color PanelActiveColor, Color PanelDeactiveColor)
    {
        this.buttonPanel = buttonPanel;
        this.PanelActiveColor = PanelActiveColor;
        this.PanelDeactiveColor = PanelDeactiveColor;
    }

    public void mouseEntered(MouseEvent me)
    {
        buttonPanel.setBackground(PanelActiveColor);
    }

    public void mouseExited(MouseEvent me)
    {
        buttonPanel.setBackground(PanelDeactiveColor);
    }
}

class MouseEffect1 extends MouseAdapter
{
    JPanel buttonPanel;
    JPanel sliderPanel;

    Color secondEffect = new Color(50, 50, 50).darker();
    Color firstEffect = new Color(50, 50, 50).brighter();

    MouseEffect1(JPanel buttonPanel, JPanel sliderPanel)
    {
        this.buttonPanel = buttonPanel;
        this.sliderPanel = sliderPanel;
    }

    public void mouseEntered(MouseEvent me)
    {
        buttonPanel.setBackground(firstEffect);
    }

    public void mouseExited(MouseEvent me)
    {
        buttonPanel.setBackground(secondEffect);
    }
}