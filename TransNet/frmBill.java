import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import appsetting.*;
import screensetting.*;
import myUtility.*;
import ReportUtility.*;

class frmBill extends JFrame
{
    JPanel pnlBill;
    JPanel pnlReport;
    JPanel pnlInformation;
    int Rcols;
    ReportTool tool;
    JButton btnClose;
    String docketNumber;
    int vBookingID;
    int vAmount;

    frmBill(String docketNumber)
    {
        this.docketNumber = docketNumber;

        setSize(800, 800);
        setLocation(650, 200);
        setLayout(null);
        setBackground(Color.BLACK);
        getContentPane().setBackground(new Color(255,253,208));

        pnlBill = new JPanel();
        pnlBill.setLayout(null);
        pnlBill.setBackground(new Color(255,253,208).darker());
		pnlBill.setBounds(0, 0, 800, 770);
        add(pnlBill);

        pnlInformation = new JPanel();
        pnlInformation.setLayout(null);
        pnlInformation.setBounds(7, 10, 770, 460);
        pnlInformation.setBackground(new Color(255,253,208));
        pnlBill.add(pnlInformation);

        pnlReport = new JPanel();
        pnlReport.setLayout(null);
        pnlReport.setBounds(7, 475, 770, 200);
        pnlBill.add(pnlReport);

        tool = new ReportTool(100, 100);
        tool.setBounds(0, 0, 770, 200);
        pnlReport.add(tool);

        btnClose = new JButton();
        btnClose.setOpaque(true);
        btnClose.setContentAreaFilled(true);
        btnClose.setBorderPainted(false);
        btnClose.setBackground(ColorSetting.getBackColorPnlUI().darker());
        btnClose.setBounds(0, 700, 800, 30);
        btnClose.addActionListener(e -> dispose());
        pnlBill.add(btnClose);

        int mGenerateDocketID = clsGenerateDocket.getIDFromName(docketNumber);
        vBookingID = clsBooking.getBookingID(mGenerateDocketID);

        if (vBookingID > 0)
        {
            createReport();
            setColumnsData();
            displayBookingInformation();
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Invalid docket number or no booking found.", "Error", JOptionPane.ERROR_MESSAGE);
            dispose();
        }

        setVisible(true);
    }

    void createReport()
    {
        setColumnsHeading();
        setColumnsAlignment();
        setColumnsWidth();
    }

    void setColumnsHeading()
    {
        Rcols = 0;
        Rcols += tool.addNewColumn("Sr_No");
        Rcols += tool.addNewColumn("Goods");
        Rcols += tool.addNewColumn("Details");
        Rcols += tool.addNewColumn("Charges");
    }

    void setColumnsAlignment()
    {
        tool.setColumnAlignment(0, ReportTool.ALIGN_CENTER);
        tool.setColumnAlignment(1, ReportTool.ALIGN_CENTER);
        tool.setColumnAlignment(2, ReportTool.ALIGN_CENTER);
        tool.setColumnAlignment(3, ReportTool.ALIGN_CENTER);
    }

    void setColumnsWidth()
    {
        tool.setColumnWidth("Sr_No", 40);
        tool.setColumnWidth("Goods", 100);
        tool.setColumnWidth("Details", 200);
        tool.setColumnWidth("Charges", 250);
    }

    void setColumnsData()
    {
        tool.removeAllRows();

        clsBookingDetailReport[] Data = clsBookingDetailReport.getBookingDetailReportInformation(vBookingID);

        for (int i = 0; i < Data.length; i++)
        {
            Object[] Objectdata = new Object[Rcols];
            Objectdata[0] = Data[i].getBookingDetailID();
            Objectdata[1] = Data[i].getGoodsName();
            Objectdata[2] = Data[i].getDetails();
            Objectdata[3] = Data[i].getCharges();
            tool.addNewRow(Objectdata);

            vAmount = vAmount + Integer.parseInt(Data[i].getCharges());
        }
    }

    void displayBookingInformation()
    {
        clsBookingReport temp = clsBookingReport.getBookingReportInformation(vBookingID);

        int y = 10;
        int x = 10;
        int height = 30;
        int width = 650;

        JLabel bookingDateLabel = new JLabel("Booking Date: " + temp.getBookingDate());
        bookingDateLabel.setForeground(Color.BLACK);
        bookingDateLabel.setFont(new Font("Basic", Font.PLAIN, 18));
        bookingDateLabel.setBounds(x, y, 200, height);
        pnlInformation.add(bookingDateLabel);

        JLabel docketNameLabel = new JLabel("Docket Number: " + temp.getGenerateDocketName());
        docketNameLabel.setForeground(Color.BLACK);
        docketNameLabel.setFont(new Font("Basic", Font.PLAIN, 18));
        docketNameLabel.setBounds(x + 300 + 20, y, 330, height);
        pnlInformation.add(docketNameLabel);

        y += height + 10;

        JLabel clientNameLabel = new JLabel("Name: " + temp.getClientName());
        clientNameLabel.setForeground(Color.BLACK);
        clientNameLabel.setFont(new Font("Basic", Font.PLAIN, 18));
        clientNameLabel.setBounds(x, y, width, height);
        pnlInformation.add(clientNameLabel);

        y += height + 10;

        JLabel sourceDepotNameLabel = new JLabel("Source: " + temp.getSourceDepotName());
        sourceDepotNameLabel.setForeground(Color.BLACK);
        sourceDepotNameLabel.setFont(new Font("Basic", Font.PLAIN, 18));
        sourceDepotNameLabel.setBounds(x, y, width, height);
        pnlInformation.add(sourceDepotNameLabel);

        y += height + 10;

        JLabel destinationDepotNameLabel = new JLabel("Destination : " + temp.getDestinationDepotName());
        destinationDepotNameLabel.setForeground(Color.BLACK);
        destinationDepotNameLabel.setFont(new Font("Basic", Font.PLAIN, 18));
        destinationDepotNameLabel.setBounds(x, y, width, height);
        pnlInformation.add(destinationDepotNameLabel);

        y += height + 10;

        JLabel vehicleNumberLabel = new JLabel("Vehicle Number: " + temp.getVehicleNumber());
        vehicleNumberLabel.setForeground(Color.BLACK);
        vehicleNumberLabel.setFont(new Font("Basic", Font.PLAIN, 18));
        vehicleNumberLabel.setBounds(x, y, width, height);
        pnlInformation.add(vehicleNumberLabel);

        y += height + 10;

        JLabel deliveryPartyLabel = new JLabel("Delivery Party: " + temp.getDeliveryParty());
        deliveryPartyLabel.setForeground(Color.BLACK);
        deliveryPartyLabel.setFont(new Font("Basic", Font.PLAIN, 18));
        deliveryPartyLabel.setBounds(x, y, width, height);
        pnlInformation.add(deliveryPartyLabel);

        y += height + 10;

        JLabel contactNumberLabel = new JLabel("Contact Number: " + temp.getContactNo());
        contactNumberLabel.setForeground(Color.BLACK);
        contactNumberLabel.setFont(new Font("Basic", Font.PLAIN, 18));
        contactNumberLabel.setBounds(x, y, width, height);
        pnlInformation.add(contactNumberLabel);

        y += height + 10;

        JLabel emailIDLabel = new JLabel("Email ID: " + temp.getEmailID());
        emailIDLabel.setForeground(Color.BLACK);
        emailIDLabel.setFont(new Font("Basic", Font.PLAIN, 18));
        emailIDLabel.setBounds(x, y, width, height);
        pnlInformation.add(emailIDLabel);

        y += height + 10;

        JLabel addressLabel = new JLabel("Address: " + temp.getAddress());
        addressLabel.setForeground(Color.BLACK);
        addressLabel.setFont(new Font("Basic", Font.PLAIN, 18));
        addressLabel.setBounds(x, y, width, height);
        pnlInformation.add(addressLabel);

        y += height + 10;

        JLabel TotalAmount = new JLabel("Total Amount : " + vAmount + "  + /tax ");
        TotalAmount.setForeground(Color.BLACK);
        TotalAmount.setFont(new Font("Basic", Font.PLAIN, 18));
        TotalAmount.setBounds(x, y, width, height);
        pnlInformation.add(TotalAmount);
    }

    public static void main(String[] args)
    {
        new frmBill("Trans-Doc-0003-24-25");
    }
}