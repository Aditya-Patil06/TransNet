import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import appsetting.*;
import screensetting.*;
import myUtility.*;
import ReportUtility.*;

class frmClientBookingReport extends JFrame
{
    ReportTool tool;
    JButton btnClose;
    String clientName;
    int vClientID;
    int Rcols;

    frmClientBookingReport(int clientID, String clientName)
    {
        this.clientName = clientName;
        this.vClientID = clientID;

        setTitle("Booking Report for Client: " + clientName);
        setSize(1000, 600);
        setLocation(700, 100);
        setLayout(null);
        getContentPane().setBackground(new Color(255, 253, 208));

        tool = new ReportTool(100, 100);
        tool.setBounds(7, 10, 970, 520);
        add(tool);

        btnClose = new JButton("Close");
        btnClose.setOpaque(true);
        btnClose.setContentAreaFilled(true);
        btnClose.setBorderPainted(false);
        btnClose.setBackground(ColorSetting.getBackColorPnlUI().darker());
        btnClose.setBounds(0, 530, 1000, 30);
        btnClose.addActionListener(e -> dispose());
        add(btnClose);

        if (vClientID > 0)
        {
            createReport();
            setColumnsData();
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Invalid client ID.", "Error", JOptionPane.ERROR_MESSAGE);
            dispose();
        }

        setVisible(true);
    }

    void createReport()
    {
        setColumnsHeading();
        setColumnsAlignment();
        setColumnsWidth();
        tool.setTablePreferredWidth();
    }

    void setColumnsHeading()
    {
        Rcols = 0;
        Rcols += tool.addNewColumn("Sr_No");
        Rcols += tool.addNewColumn("Booking_Date");
        Rcols += tool.addNewColumn("Docket_Number");
        Rcols += tool.addNewColumn("Client_Name");
        Rcols += tool.addNewColumn("Source_Depot");
        Rcols += tool.addNewColumn("Destination_Depot");
        Rcols += tool.addNewColumn("Delivery_Party");
    }

    void setColumnsAlignment()
    {
        tool.setColumnAlignment(0, ReportTool.ALIGN_CENTER);
        tool.setColumnAlignment(1, ReportTool.ALIGN_CENTER);
        tool.setColumnAlignment(2, ReportTool.ALIGN_CENTER);
        tool.setColumnAlignment(3, ReportTool.ALIGN_CENTER);
        tool.setColumnAlignment(4, ReportTool.ALIGN_CENTER);
        tool.setColumnAlignment(5, ReportTool.ALIGN_CENTER);
        tool.setColumnAlignment(6, ReportTool.ALIGN_CENTER);
    }

    void setColumnsWidth()
    {
        tool.setColumnWidth("Sr_No", 50);
        tool.setColumnWidth("Booking_Date", 100);
        tool.setColumnWidth("Docket_Number", 150);
        tool.setColumnWidth("Client_Name", 250);
        tool.setColumnWidth("Source_Depot", 250);
        tool.setColumnWidth("Destination_Depot", 250);
        tool.setColumnWidth("Delivery_Party", 200);
    }

    void setColumnsData()
    {
        tool.removeAllRows();

        clsGeneralBookingReport[] Data = clsGeneralBookingReport.getClientBookingReportInformation(vClientID);

        if (Data != null && Data.length > 0)
        {
            for (int i = 0; i < Data.length; i++)
            {
                Object[] Objectdata = new Object[Rcols];
                Objectdata[0] = i + 1;
                Objectdata[1] = Data[i].getBookingDate();
                Objectdata[2] = Data[i].getGenerateDocketName();
                Objectdata[3] = Data[i].getClientName();
                Objectdata[4] = Data[i].getSourceDepotName();
                Objectdata[5] = Data[i].getDestinationDepotName();
                Objectdata[6] = Data[i].getDiliverParty();
                tool.addNewRow(Objectdata);
            }
        }
        else
        {
            JOptionPane.showMessageDialog(this, "No booking records found for client: " + clientName, "Info", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void main(String[] args)
    {
        new frmClientBookingReport(6, "Test Client");
    }
}