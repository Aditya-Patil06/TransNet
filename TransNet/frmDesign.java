import myUtility.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import screensetting.ScreenDesign;

class frmDesign extends JFrame implements ActionListener
{

	JLabel lblProjectName;
	JPanel pnlUI;

	JPanel  pnlSave , pnlDelete , pnlUpdate , pnlNew , pnlView , pnlEdit , pnlCancel , pnlReport , pnlApply , pnlcombo1 ;
	JButton btnSave , btnDelete , btnUpdate , btnNew , btnView , btnEdit , btnCancel , btnReport ,btnApply;

	ScreenDesign myUI;
    frmDesign()
    {
		setTitle("New Project");
		setSize(1920,1080);
		setLayout(null);
		setLocation(0,0);

		myUI = new ScreenDesign();
		add(myUI);
		setExtendedState(getExtendedState()|JFrame.MAXIMIZED_BOTH);

		pnlUI = myUI.getUIPanel();

		pnlNew = myUI.getNewPanel();
		pnlView = myUI.getViewPanel();
		pnlSave = myUI.getSavePanel();
		pnlReport = myUI.getReportPanel();
		pnlCancel = myUI.getCancelPanel();
		pnlDelete = myUI.getDeletePanel();
		pnlUpdate = myUI.getUpdatePanel();
		pnlEdit = myUI.getEditPanel();
		pnlcombo1 = myUI.getCombo1Panel();
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
		btnReport.addActionListener(this);

		lblProjectName = myUI.getlblProgramHeading();
		new BlinkLabel(lblProjectName,500);
		UISetting.setArea(pnlUI,300,300);

		setVisible(true);

		setDefaultOperation();
	}

	void setDefaultOperation()
	{
		PanelState.enabledComponents(pnlNew);
		PanelState.enabledComponents(pnlView);
		PanelState.enabledComponents(pnlReport);
	}

	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==btnNew)
		{
			PanelState.disabledComponents(pnlNew);
			PanelState.disabledComponents(pnlView);
			PanelState.disabledComponents(pnlReport);
			PanelState.enabledComponents(pnlSave);
			PanelState.enabledComponents(pnlCancel);
		}
		else if(ae.getSource()==btnView)
		{
			PanelState.disabledComponents(pnlNew);
			PanelState.disabledComponents(pnlView);
			PanelState.disabledComponents(pnlReport);
			PanelState.enabledComponents(pnlCancel);
			PanelState.enabledComponents(pnlcombo1);
			PanelState.enabledComponents(pnlApply);
		}
		else if(ae.getSource()== btnCancel)
		{

		}
		else if(ae.getSource()==btnReport)
		{

		}
		else if(ae.getSource()==btnSave)
		{
			PanelState.disabledComponents(pnlSave);
			PanelState.disabledComponents(pnlCancel);
			PanelState.enabledComponents(pnlNew);
			PanelState.enabledComponents(pnlView);
			PanelState.enabledComponents(pnlReport);
		}
		else if(ae.getSource()==btnApply)
		{
			PanelState.disabledComponents(pnlCancel);
			PanelState.disabledComponents(pnlcombo1);
			PanelState.disabledComponents(pnlApply);
			PanelState.enabledComponents(pnlEdit);
			PanelState.enabledComponents(pnlDelete);
		}
		else if(ae.getSource()==btnEdit)
		{
			PanelState.disabledComponents(pnlEdit);
			PanelState.disabledComponents(pnlDelete);
			PanelState.enabledComponents(pnlUpdate);
		}
		else if(ae.getSource()==btnUpdate)
		{
			PanelState.enabledComponents(pnlNew);
			PanelState.enabledComponents(pnlView);
			PanelState.enabledComponents(pnlReport);
			PanelState.disabledComponents(pnlUpdate);
		}
		else if(ae.getSource()==btnDelete)
		{
			PanelState.enabledComponents(pnlNew);
			PanelState.enabledComponents(pnlView);
			PanelState.enabledComponents(pnlReport);
			PanelState.disabledComponents(pnlDelete);
			PanelState.disabledComponents(pnlEdit);
		}
	}
	public static void main(String args[])
	{
		frmDesign f=new frmDesign();
	}
}