import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import appsetting.*;
import screensetting.*;
import myUtility.*;
import ReportUtility.*;

class frmVehicleRecord extends JFrame
{
    JPanel pnlVehicleDetails;
    JPanel pnlReport;
    int Rcols;
    ReportTool tool;
    JButton btnClose;
    String vehicleNumber;
    int vVehicleID;

    frmVehicleRecord(String vehicleNumber)
    {
        this.vehicleNumber = vehicleNumber;

		setTitle("Vehicle Records");
        setSize(800, 800);
        setLocation(650, 100);
        setLayout(null);
        setBackground(Color.BLACK);
        getContentPane().setBackground(new Color(255,253,208));

        pnlVehicleDetails = new JPanel();
        pnlVehicleDetails.setLayout(null);
        pnlVehicleDetails.setBackground(new Color(255,253,208).darker());
        pnlVehicleDetails.setBounds(0, 0, 800, 770);
        add(pnlVehicleDetails);

        pnlReport = new JPanel();
        pnlReport.setLayout(null);
        pnlReport.setBounds(7, 10, 770, 720);
        pnlVehicleDetails.add(pnlReport);

        tool = new ReportTool(100, 100);
        tool.setBounds(0, 0, 770, 720);
        pnlReport.add(tool);

        btnClose = new JButton();
        btnClose.setOpaque(true);
        btnClose.setContentAreaFilled(true);
        btnClose.setBorderPainted(false);
        btnClose.setBackground(ColorSetting.getBackColorPnlUI().darker());
        btnClose.setBounds(0, 730, 800, 30);
        btnClose.addActionListener(e -> dispose());
        pnlVehicleDetails.add(btnClose);

        vVehicleID = clsVehicle.getIDFromName(vehicleNumber);

        if (vVehicleID > 0)
        {
            createReport();
            setColumnsData();
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Invalid vehicle number or no vehicle found.", "Error", JOptionPane.ERROR_MESSAGE);
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
        Rcols += tool.addNewColumn("Booking_Date");
        Rcols += tool.addNewColumn("Vehicle_Number");
        Rcols += tool.addNewColumn("Source_Depot");
        Rcols += tool.addNewColumn("Destination_Depot");
    }

    void setColumnsAlignment()
    {
        tool.setColumnAlignment(0, ReportTool.ALIGN_CENTER);
        tool.setColumnAlignment(1, ReportTool.ALIGN_CENTER);
        tool.setColumnAlignment(2, ReportTool.ALIGN_CENTER);
        tool.setColumnAlignment(3, ReportTool.ALIGN_CENTER);
        tool.setColumnAlignment(4, ReportTool.ALIGN_CENTER);
    }

    void setColumnsWidth()
    {
        tool.setColumnWidth("Sr_No", 50);
        tool.setColumnWidth("Booking_Date", 150);
        tool.setColumnWidth("Vehicle_Number", 150);
        tool.setColumnWidth("Source_Depot", 250);
        tool.setColumnWidth("Destination_Depot", 250);
    }

    void setColumnsData()
    {
        tool.removeAllRows();

        clsVehicleBookingReport[] Data = clsVehicleBookingReport.getVehicleBookingReportInformation(vVehicleID);

        if (Data != null && Data.length > 0)
        {
            for (int i = 0; i < Data.length; i++)
            {
                Object[] Objectdata = new Object[Rcols];
                Objectdata[0] = i + 1;
                Objectdata[1] = Data[i].getBookingDate();
                Objectdata[2] = Data[i].getVehicleName();
                Objectdata[3] = Data[i].getSourceDepotName();
                Objectdata[4] = Data[i].getDestinationDepotName();
                tool.addNewRow(Objectdata);
            }
        }
        else
        {
            JOptionPane.showMessageDialog(this, "No booking records found for vehicle: " + vehicleNumber, "Info", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void main(String[] args)
    {
        new frmVehicleRecord("MH-01 CV-3542");
    }
}