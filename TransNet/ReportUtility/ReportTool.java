package ReportUtility;
import java.awt.*;
import javax.swing.table.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;
//import ProjectSetting.*;
public class ReportTool extends JPanel
{
	JTable tblreport;
	JScrollPane tablepane;
	int ReportColumns;
	boolean tableVerticalLine;
	boolean tableHorizontalLine;
	boolean ColumnSelection;
    boolean RowSelection;
    int tableheight;
    public static int ALIGN_LEFT=1;
    public static int ALIGN_RIGHT=2;
    public static int ALIGN_CENTER=3;
	public String selectiondata;

	DefaultTableModel model;


	public JTable getTable()
	{
		return(tblreport);
	}

	public void setColumnAlignment(int index, int align)
	{

		if(align==ALIGN_LEFT)
		{
			tblreport.getColumnModel().getColumn(index).setCellRenderer(TableAlignments.alignLeft());
		}
		else if(align==ALIGN_RIGHT)
		{
			tblreport.getColumnModel().getColumn(index).setCellRenderer(TableAlignments.alignRight());
		}
		else
		{
			tblreport.getColumnModel().getColumn(index).setCellRenderer(TableAlignments.alignCenter());
		}

	}
	public int addNewColumn(String cname)
	{
		model.addColumn(cname);
		return(1);
	}

	public void setColumnWidth(String cname,int width)
	{
		tblreport.getColumn(cname).setPreferredWidth(width);
	}


	public void addNewRow(Object value[])
	{
		model.addRow(value);
	}
	public void removeAllRows()
	{
		while(model.getRowCount()>=1)
		{
			model.removeRow(0);
		}
	}


	public ReportTool(int screenWidth, int screenHeight)
	{
        setPreferredSize(new Dimension(screenWidth, screenHeight));
        setLayout(new BorderLayout()); // Set BorderLayout for the ReportTool

        tableheight = 30;
        ReportColumns = 6;
        tableVerticalLine = false;
        tableHorizontalLine = false;
        ColumnSelection = false;
        RowSelection = true;
        tblreport = new JTable();
        tblreport.setRowHeight(tableheight);
        setBackground(Color.yellow);

        model = new DefaultTableModel();
        tblreport.setModel(model);

        tablepane = new JScrollPane(tblreport);

        tablepane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        tablepane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        tablepane.setVisible(true);

        tablepane.setBackground(Color.black);
        add(tablepane, BorderLayout.CENTER); // Add the scroll pane to the center
    }
	public void setTablePreferredWidth()
	{
        if (tblreport == null)
        {
            return;
        }

        int totalWidth = 0;
        for (int i = 0; i < tblreport.getColumnCount(); i++)
        {
            TableColumn column = tblreport.getColumnModel().getColumn(i);
            if (column != null)
            {
                totalWidth += column.getWidth();
            }
        }
        totalWidth += 20; // Buffer

        tblreport.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        // Key Changes: Set preferred and minimum size of the SCROLL PANE
        tablepane.setPreferredSize(new Dimension(totalWidth, tablepane.getPreferredSize().height));
        tablepane.setMinimumSize(new Dimension(totalWidth, 0)); // Minimum width = totalWidth

        tblreport.setPreferredScrollableViewportSize(new Dimension(totalWidth, tblreport.getPreferredSize().height));

        setPreferredSize(new Dimension(totalWidth, getPreferredSize().height)); // For the ReportTool panel
        setMinimumSize(new Dimension(totalWidth, getMinimumSize().height)); // Minimum width for the panel too.

        revalidate();
    }

}


class TableAlignments
{

	static DefaultTableCellRenderer alignLeft()
	{
			DefaultTableCellRenderer leftRenderer = new DefaultTableCellRenderer();
			leftRenderer.setHorizontalAlignment(SwingConstants.LEFT);
			return(leftRenderer);
	}

	static DefaultTableCellRenderer alignRight()
	{
			DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
			rightRenderer.setHorizontalAlignment(SwingConstants.RIGHT);
			return(rightRenderer);
	}

	static DefaultTableCellRenderer alignCenter()
	{
			DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
			centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
			return(centerRenderer);
	}

}
