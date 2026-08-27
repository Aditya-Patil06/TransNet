import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import appsetting.*;
import screensetting.*;
import myUtility.*;
import ReportUtility.*;

class frmGeneralBookingReport extends JFrame
{
    ReportTool tool;
    JButton btnClose;
    String reportType;
    String input;
    int Rcols;

    frmGeneralBookingReport(String reportType, String input)
    {
        this.reportType = reportType;
        this.input = input;

        String title;
        switch (reportType) {
            case "Date":
                title = "Booking Report for Date: " + input;
                break;
            case "Month":
                title = "Booking Report for Month: " + input;
                break;
            case "Year":
                title = "Booking Report for Year: " + input;
                break;
            case "Overall":
                title = "Overall Booking Report";
                break;
            default:
                title = "Booking Report";
                break;
        }

        setTitle(title);
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

        createReport();
        setColumnsData();

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

        clsGeneralBookingReport[] data;
        switch (reportType) {
            case "Date":
                data = clsGeneralBookingReport.getDateBookingReportInformation(input);
                break;
            case "Month":
                data = clsGeneralBookingReport.getMonthBookingReportInformation(input);
                break;
            case "Year":
                data = clsGeneralBookingReport.getYearBookingReportInformation(input);
                break;
            case "Overall":
                data = clsGeneralBookingReport.getOverallBookingReportInformation();
                break;
            default:
                data = new clsGeneralBookingReport[0];
                break;
        }

        if (data != null && data.length > 0)
        {
            for (int i = 0; i < data.length; i++)
            {
                Object[] Objectdata = new Object[Rcols];
                Objectdata[0] = i + 1;
                Objectdata[1] = data[i].getBookingDate();
                Objectdata[2] = data[i].getGenerateDocketName();
                Objectdata[3] = data[i].getClientName();
                Objectdata[4] = data[i].getSourceDepotName();
                Objectdata[5] = data[i].getDestinationDepotName();
                Objectdata[6] = data[i].getDiliverParty();
                tool.addNewRow(Objectdata);
            }
        }
        else
        {
            String message;
            switch (reportType) {
                case "Date":
                    message = "No booking records found for date: " + input;
                    break;
                case "Month":
                    message = "No booking records found for month: " + input;
                    break;
                case "Year":
                    message = "No booking records found for year: " + input;
                    break;
                case "Overall":
                    message = "No booking records found.";
                    break;
                default:
                    message = "No data available.";
                    break;
            }
            JOptionPane.showMessageDialog(this, message, "Info", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void main(String[] args)
    {
        new frmGeneralBookingReport("Overall", null);
    }
}