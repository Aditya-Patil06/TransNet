import screensetting.*;
import myUtility.*;
import appsetting.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class frmMenuProject extends JFrame implements ActionListener
{
	MenuDesign MyMenu;

	JPanel pnlMain;
	JPanel pnlTop;
	JPanel pnlLeft;
	JPanel pnlBottomLeft;
	JPanel pnlBottomRight;
	JPanel pnlOptionMenu;
	JPanel pnlCenterImage;
	JPanel pnlProgramHeading;
	JPanel pnlMenuButton;

	JPanel pnlMenu[];
	JLabel lblMenu[];
	JButton btnMenu[];

	JPanel pnlSubMenu[];
	JLabel lblSubMenu[];
	JButton btnSubMenu[];

	JPanel pnlOption[];
	JLabel lblOption[];
	JButton btnOption[];

	Icon OptionImages[];

	String btnMenuNames[] = {
			"Master", "BCA", "BSC", "Arts", "Reports", "LogOut"
	};

	String btnSubMenuNames[] = {
			"Country", "State", "District", "Taluka", "Village",
			"Area", "---", "---", "---", "---"
	};

	String Master[] = {"Location"};

	String BCA[] = {
			"Devendra", "Bhushan", "Mitesh", "Gajanan"
	};

	String BSC[] = {
			"Raj", "Ram", "Manish", "Ketan", "Sanjay",
			"Anil", "Sham", "Dipesh", "Vipul", "Niraj"
	};

	String Arts[] = {
			"Sunil", "Mahesh"
	};

	String Reports[] = {
			"Sahil", "Yash", "Rajat", "Piyush"
	};

	String LogOut[] = {
			"Durgesh"
	};

	String Location[] = {
			"Country", "State", "District", "Taluka", "Village", "Area"
	};

	Icon imagemsdhoni;
	Icon noimageSubMenu;
	Icon imageOptionIcon;

	String OptionImagesNames[] = {
			"D:\\Aditya_Project_TransNet\\screensetting\\Country.jpeg",
			"D:\\Aditya_Project_TransNet\\screensetting\\State.jpeg",
			"D:\\Aditya_Project_TransNet\\screensetting\\District.jpeg",
			"D:\\Aditya_Project_TransNet\\screensetting\\Taluka.jpeg",
			"D:\\Aditya_Project_TransNet\\screensetting\\Village.jpeg",
			"D:\\Aditya_Project_TransNet\\screensetting\\Area.jpeg"
	};


	public frmMenuProject()
	{
		setTitle("Form Design");
		setSize(1920, 1080);
		setLocation(0, 0);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		MyMenu = new MenuDesign();

		/*
		 * MenuDesign already creates the main UI.
		 * We use only the getters that actually exist in MenuDesign.
		 */
		add(MyMenu);

		pnlMain = MyMenu.getMainPanel();
		pnlTop = MyMenu.getTopPanel();
		JPanel pnlBaseBottom = MyMenu.getBottomPanel();

		/*
		 * Create the menu UI ourselves because MenuDesign.java
		 * does not contain the old menu getter methods.
		 */
		createMenuUI();

		/*
		 * Register listeners.
		 */
		for (int i = 0; i < btnMenu.length; i++)
		{
			btnMenu[i].addActionListener(this);
		}

		for (int i = 0; i < btnSubMenu.length; i++)
		{
			btnSubMenu[i].addActionListener(this);
		}

		for (int i = 0; i < btnOption.length; i++)
		{
			btnOption[i].addActionListener(this);
		}

		setVisible(true);
	}


	private void createMenuUI()
	{
		/*
		 * -------------------------
		 * LEFT PANEL
		 * -------------------------
		 */
		pnlLeft = new JPanel();
		pnlLeft.setBounds(20, 120, 380, 760);
		pnlLeft.setLayout(null);
		pnlLeft.setBackground(MenuColorSetting.getBackColorLeftPanel());
		pnlTop.add(pnlLeft);


		/*
		 * -------------------------
		 * MENU BUTTON PANEL
		 * -------------------------
		 */
		pnlMenuButton = new JPanel();
		pnlMenuButton.setBounds(10, 10, 360, 330);
		pnlMenuButton.setLayout(null);
		pnlMenuButton.setBackground(
				MenuColorSetting.getBackColorMenuButtonPanel()
		);
		pnlLeft.add(pnlMenuButton);


		/*
		 * -------------------------
		 * MENU ARRAYS
		 * -------------------------
		 */
		int menuCount = btnMenuNames.length;

		pnlMenu = new JPanel[menuCount];
		lblMenu = new JLabel[menuCount];
		btnMenu = new JButton[menuCount];

		for (int i = 0; i < menuCount; i++)
		{
			pnlMenu[i] = new JPanel();
			pnlMenu[i].setLayout(null);
			pnlMenu[i].setBounds(10, 10 + (i * 50), 340, 45);
			pnlMenu[i].setBackground(
					MenuColorSetting.getBackColorMenuButtons()
			);

			lblMenu[i] = new JLabel();
			lblMenu[i].setBounds(5, 5, 60, 35);
			lblMenu[i].setHorizontalAlignment(JLabel.CENTER);

			btnMenu[i] = new JButton(btnMenuNames[i]);
			btnMenu[i].setBounds(70, 5, 255, 35);
			btnMenu[i].setFocusPainted(false);
			btnMenu[i].setBackground(
					MenuColorSetting.getBackColorMenuButtons()
			);
			btnMenu[i].setForeground(
					MenuColorSetting.getForeColorMenuButtons()
			);

			pnlMenu[i].add(lblMenu[i]);
			pnlMenu[i].add(btnMenu[i]);

			pnlMenuButton.add(pnlMenu[i]);
		}


		/*
		 * -------------------------
		 * SUB MENU PANEL
		 * -------------------------
		 */
		pnlBottomLeft = new JPanel();
		pnlBottomLeft.setBounds(10, 350, 360, 380);
		pnlBottomLeft.setLayout(null);
		pnlBottomLeft.setBackground(
				MenuColorSetting.getBackColorBottomLeftPanel()
		);
		pnlLeft.add(pnlBottomLeft);


		int subMenuCount = btnSubMenuNames.length;

		pnlSubMenu = new JPanel[subMenuCount];
		lblSubMenu = new JLabel[subMenuCount];
		btnSubMenu = new JButton[subMenuCount];

		for (int i = 0; i < subMenuCount; i++)
		{
			pnlSubMenu[i] = new JPanel();
			pnlSubMenu[i].setLayout(null);
			pnlSubMenu[i].setBounds(
					5,
					5 + (i * 36),
					350,
					32
			);

			pnlSubMenu[i].setBackground(
					MenuColorSetting.getBackColorSubMenuButtons()
			);

			lblSubMenu[i] = new JLabel();
			lblSubMenu[i].setBounds(5, 2, 50, 28);
			lblSubMenu[i].setHorizontalAlignment(JLabel.CENTER);

			btnSubMenu[i] = new JButton(btnSubMenuNames[i]);
			btnSubMenu[i].setBounds(60, 2, 280, 28);
			btnSubMenu[i].setFocusPainted(false);
			btnSubMenu[i].setBackground(
					MenuColorSetting.getBackColorSubMenuButtons()
			);
			btnSubMenu[i].setForeground(
					MenuColorSetting.getForeColorSubMenuButtons()
			);

			pnlSubMenu[i].add(lblSubMenu[i]);
			pnlSubMenu[i].add(btnSubMenu[i]);

			pnlBottomLeft.add(pnlSubMenu[i]);

			/*
			 * Initially disable unused submenu items.
			 */
			if (i >= 1)
			{
				PanelState.disabledComponents(pnlSubMenu[i]);
			}
		}


		/*
		 * -------------------------
		 * RIGHT PANEL
		 * -------------------------
		 */
		pnlBottomRight = new JPanel();
		pnlBottomRight.setBounds(420, 120, 1450, 760);
		pnlBottomRight.setLayout(null);
		pnlBottomRight.setBackground(
				MenuColorSetting.getBackColorBottomRightPanel()
		);
		pnlTop.add(pnlBottomRight);


		/*
		 * -------------------------
		 * PROGRAM HEADING
		 * -------------------------
		 */
		pnlProgramHeading = new JPanel();
		pnlProgramHeading.setBounds(20, 20, 1410, 70);
		pnlProgramHeading.setLayout(null);
		pnlProgramHeading.setBackground(
				MenuColorSetting.getBackColorTopPanel()
		);

		JLabel lblHeading = new JLabel("TRANSNET MENU", JLabel.CENTER);
		lblHeading.setBounds(0, 0, 1410, 70);
		lblHeading.setFont(
				new Font("Times New Roman", Font.BOLD, 32)
		);
		lblHeading.setForeground(Color.WHITE);

		pnlProgramHeading.add(lblHeading);
		pnlBottomRight.add(pnlProgramHeading);


		/*
		 * -------------------------
		 * OPTION MENU
		 * -------------------------
		 */
		pnlOptionMenu = new JPanel();
		pnlOptionMenu.setBounds(20, 105, 1410, 400);
		pnlOptionMenu.setLayout(null);
		pnlOptionMenu.setBackground(
				MenuColorSetting.getDefaultBackColorOptionMenuPanel()
		);
		pnlBottomRight.add(pnlOptionMenu);


		/*
		 * -------------------------
		 * OPTION ARRAYS
		 * -------------------------
		 */
		int optionCount = 6;

		pnlOption = new JPanel[optionCount];
		lblOption = new JLabel[optionCount];
		btnOption = new JButton[optionCount];

		OptionImages = new Icon[optionCount];

		for (int i = 0; i < optionCount; i++)
		{
			int row = i / 3;
			int col = i % 3;

			pnlOption[i] = new JPanel();
			pnlOption[i].setLayout(null);
			pnlOption[i].setBounds(
					20 + (col * 460),
					20 + (row * 180),
					430,
					150
			);

			pnlOption[i].setBackground(
					MenuColorSetting.getBackColorOptionButtons()
			);

			lblOption[i] = new JLabel();
			lblOption[i].setBounds(10, 10, 110, 90);
			lblOption[i].setHorizontalAlignment(JLabel.CENTER);

			btnOption[i] = new JButton("---");
			btnOption[i].setBounds(130, 35, 280, 50);
			btnOption[i].setFocusPainted(false);
			btnOption[i].setBackground(
					MenuColorSetting.getBackColorOptionButtons()
			);
			btnOption[i].setForeground(
					MenuColorSetting.getForeColorOptionButtons()
			);

			pnlOption[i].add(lblOption[i]);
			pnlOption[i].add(btnOption[i]);

			pnlOptionMenu.add(pnlOption[i]);

			PanelState.hideComponents(pnlOption[i]);
		}


		/*
		 * -------------------------
		 * CENTER IMAGE PANEL
		 * -------------------------
		 */
		pnlCenterImage = new JPanel();
		pnlCenterImage.setBounds(20, 525, 1410, 200);
		pnlCenterImage.setLayout(null);
		pnlCenterImage.setBackground(
				MenuColorSetting.getBackColorCenterImagePanel()
		);

		JLabel lblInfo = new JLabel(
				"Select a menu and submenu option",
				JLabel.CENTER
		);

		lblInfo.setBounds(0, 0, 1410, 200);
		lblInfo.setFont(
				new Font("Arial", Font.BOLD, 24)
		);
		lblInfo.setForeground(Color.WHITE);

		pnlCenterImage.add(lblInfo);
		pnlBottomRight.add(pnlCenterImage);
	}


	private Icon createIcon(String path, int width, int height)
	{
		ImageIcon icon = new ImageIcon(path);

		if (icon.getIconWidth() <= 0)
		{
			return new ImageIcon();
		}

		Image image = icon.getImage();

		Image scaled = image.getScaledInstance(
				width,
				height,
				Image.SCALE_SMOOTH
		);

		return new ImageIcon(scaled);
	}


	private void setSubMenu(String data[])
	{
		for (int j = 0; j < btnSubMenu.length; j++)
		{
			if (j < data.length)
			{
				btnSubMenu[j].setText(data[j]);

				/*
				 * Use a simple existing icon.
				 * This avoids depending on external image files.
				 */
				lblSubMenu[j].setIcon(
						createIcon(
								"D:\\Aditya_Project_TransNet\\screensetting\\msdhoni.jpeg",
								45,
								28
						)
				);

				PanelState.enabledComponents(
						pnlSubMenu[j]
				);
			}
			else
			{
				btnSubMenu[j].setText("---");

				lblSubMenu[j].setIcon(
						new ImageIcon()
				);

				PanelState.disabledComponents(
						pnlSubMenu[j]
				);
			}
		}
	}


	private void hideAllOptions()
	{
		pnlOptionMenu.setBackground(
				MenuColorSetting.getDefaultBackColorOptionMenuPanel()
		);

		for (int i = 0; i < pnlOption.length; i++)
		{
			PanelState.hideComponents(pnlOption[i]);
		}
	}


	private void showLocationOptions()
	{
		OptionImages = new Icon[OptionImagesNames.length];

		for (int j = 0; j < pnlOption.length; j++)
		{
			if (j < Location.length)
			{
				btnOption[j].setText(Location[j]);

				OptionImages[j] = createIcon(
						OptionImagesNames[j],
						100,
						80
				);

				lblOption[j].setIcon(
						OptionImages[j]
				);

				pnlOptionMenu.setBackground(
						MenuColorSetting.getActionBackColorOptionMenuPanel()
				);

				PanelState.visibleComponents(
						pnlOption[j]
				);

				PanelState.enabledComponents(
						pnlOption[j]
				);
			}
			else
			{
				btnOption[j].setText("---");

				PanelState.hideComponents(
						pnlOption[j]
				);
			}
		}
	}


	@Override
	public void actionPerformed(ActionEvent ae)
	{
		String x = "";


		/*
		 * ==========================================
		 * MAIN MENU BUTTONS
		 * ==========================================
		 */
		for (int i = 0; i < btnMenu.length; i++)
		{
			if (ae.getSource() == btnMenu[i])
			{
				x = btnMenu[i].getText();

				if (x.equals("Master"))
				{
					hideAllOptions();
					setSubMenu(Master);
				}

				if (x.equals("BCA"))
				{
					hideAllOptions();
					setSubMenu(BCA);
				}

				if (x.equals("BSC"))
				{
					hideAllOptions();
					setSubMenu(BSC);
				}

				if (x.equals("Arts"))
				{
					hideAllOptions();
					setSubMenu(Arts);
				}

				if (x.equals("Reports"))
				{
					hideAllOptions();
					setSubMenu(Reports);
				}

				if (x.equals("LogOut"))
				{
					hideAllOptions();
					setSubMenu(LogOut);
				}

				return;
			}
		}


		/*
		 * ==========================================
		 * SUB MENU BUTTONS
		 * ==========================================
		 */
		for (int i = 0; i < btnSubMenu.length; i++)
		{
			if (ae.getSource() == btnSubMenu[i])
			{
				x = btnSubMenu[i].getText();

				if (x.equals("Location"))
				{
					showLocationOptions();
				}

				return;
			}
		}


		/*
		 * ==========================================
		 * OPTION BUTTONS
		 * ==========================================
		 */
		for (int i = 0; i < btnOption.length; i++)
		{
			if (ae.getSource() == btnOption[i])
			{
				x = btnOption[i].getText();

				if (x.equals("Country"))
				{
					frmCountry frm = new frmCountry();
				}

				if (x.equals("State"))
				{
					frmState frm = new frmState();
				}

				if (x.equals("District"))
				{
					frmDistrict frm = new frmDistrict();
				}

				if (x.equals("Taluka"))
				{
					frmTaluka frm = new frmTaluka();
				}

				if (x.equals("Village"))
				{
					frmVillage frm = new frmVillage();
				}

				/*
				 * Area was commented out in the original program.
				 *
				 * if (x.equals("Area"))
				 * {
				 *     frmArea frm = new frmArea();
				 * }
				 */

				return;
			}
		}
	}

	public static void main(String args[])
	{
		SwingUtilities.invokeLater(() ->
		{
			new frmMenuProject();
		});
	}
}