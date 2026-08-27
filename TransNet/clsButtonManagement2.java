import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import myUtility.*;


public class clsButtonManagement2
{
	JPanel pnlNew		;
	JPanel pnlSave		;
	JPanel pnlView		;
	JPanel pnlEdit		;
	JPanel pnlDelete	;
	JPanel pnlCancel	;
	JPanel pnlReport	;
	JPanel pnlApply		;
	JPanel pnlUpdate	;
	JPanel pnlUI		;
	JPanel pnlEntry		;
	JPanel pnlUIReport	;
	JPanel pnlClose		;//new


	ButtonState bst		;

	JComboBox cmbCombo1	;
	JPanel pnlCombo1	;
	JLabel lblCombo1	;

	JComboBox cmbCombo2	;
	JPanel pnlCombo2	;
	JLabel lblCombo2	;


	void manageCombo1(JComboBox cmbCombo1)
	{
		this.cmbCombo1=cmbCombo1;
	}
	void manageCombo1Panel(JPanel pnlCombo1)
	{
		this.pnlCombo1=pnlCombo1;
	}

	void manageCombo2(JComboBox cmbCombo2)
	{
		this.cmbCombo2=cmbCombo2;
	}
	void manageCombo2Panel(JPanel pnlCombo2)
	{
		this.pnlCombo2=pnlCombo2;
	}
	void manageNewPanel(JPanel pnlNew)
	{
		this.pnlNew=pnlNew;
	}
	void manageDataPanel(JPanel pnlUI)
	{
		this.pnlUI=pnlUI;
	}
	void manageEntryPanel(JPanel pnlEntry)
	{
		this.pnlEntry=pnlEntry;
	}
	void manageSavePanel(JPanel pnlSave)
	{
		this.pnlSave=pnlSave;
	}
	void manageViewPanel(JPanel pnlView)
	{
		this.pnlView=pnlView;
	}
	void manageEditPanel(JPanel pnlEdit)
	{
		this.pnlEdit=pnlEdit;
	}
	void manageUpdatePanel(JPanel pnlUpdate)
	{
		this.pnlUpdate=pnlUpdate;
	}
	void manageDeletePanel(JPanel pnlDelete)
	{
		this.pnlDelete=pnlDelete;
	}
	void manageCancelPanel(JPanel pnlCancel)
	{
		this.pnlCancel=pnlCancel;
	}
	void manageReportPanel(JPanel pnlReport)
	{
		this.pnlReport=pnlReport;
	}
	void manageClosePanel(JPanel pnlClose)
	{
		this.pnlClose=pnlClose;
	}
	void manageDataReportPanel(JPanel pnlUIReport)
	{
		this.pnlUIReport=pnlUIReport;
	}
	void manageReportUIPanel(JPanel pnlUIReport)
	{
		this.pnlUIReport=pnlUIReport;
	}

	void manageApplyPanel(JPanel pnlApply)
	{
		this.pnlApply=pnlApply;
	}

	void showButtonsOnUI(ButtonState bst)
	 {
		 this.bst=bst;
		if(bst.getButtonUniqueState()==ButtonState.CancelState)
		{
			bst.setButtonUniqueState(ButtonState.ResetState);
			rejectAction();
		}

		else if(bst.getButtonState()==ButtonState.NewState)
		{
			PanelState.enabledComponents(pnlSave);
			PanelState.disabledComponents(pnlNew);
			PanelState.disabledComponents(pnlView);
			//PanelState.enabledComponents(pnlEntry);
			PanelState.enabledComponents(pnlUI);
			//PanelState.disabledComponents(pnlUIReport);

		}
		else if(bst.getButtonState()==ButtonState.SaveState)
		{
			//PanelState.disabledComponents(pnlUIReport);
			PanelState.enabledComponents(pnlView);
			PanelState.enabledComponents(pnlNew);
			PanelState.disabledComponents(pnlSave);
			PanelState.disabledComponents(pnlUI);

		}
		else if(bst.getButtonState()==ButtonState.UpdateState)
		{
			PanelState.disabledComponents(pnlCombo1);
			PanelState.disabledComponents(pnlCombo2);
			PanelState.disabledComponents(pnlApply);
			PanelState.disabledComponents(pnlSave);
			PanelState.disabledComponents(pnlUpdate);
			PanelState.disabledComponents(pnlDelete);
			PanelState.disabledComponents(pnlUI);
			PanelState.enabledComponents(pnlNew);
			PanelState.enabledComponents(pnlView);

			resetAllCombo();
		}
		else if(bst.getButtonState()==ButtonState.ViewState)
		{
			PanelState.disabledComponents(pnlEdit);
			PanelState.disabledComponents(pnlDelete);
			PanelState.disabledComponents(pnlView);
			PanelState.disabledComponents(pnlNew);

			PanelState.enabledComponents(pnlCombo1);
			PanelState.enabledComponents(pnlCombo2);
			PanelState.enabledComponents(pnlApply);
		}
		else if(bst.getButtonState()==ButtonState.ApplyState)
		{
			PanelState.enabledComponents(pnlEdit);
			PanelState.enabledComponents(pnlDelete);
			PanelState.disabledComponents(pnlUpdate);
			PanelState.disabledComponents(pnlView);
			PanelState.disabledComponents(pnlNew);
			PanelState.disabledComponents(pnlSave);
			PanelState.disabledComponents(pnlCombo1);
			PanelState.disabledComponents(pnlCombo2);
			PanelState.disabledComponents(pnlApply);
			PanelState.disabledComponents(pnlUI);

		}
		else if(bst.getButtonState()==ButtonState.EditState)
		{
			PanelState.disabledComponents(pnlEdit);
			PanelState.enabledComponents(pnlUI);
			PanelState.enabledComponents(pnlUpdate);
			PanelState.disabledComponents(pnlDelete);


		}
		else if(bst.getButtonState()==ButtonState.DeleteState)
		{
			PanelState.disabledComponents(pnlSave);
			PanelState.disabledComponents(pnlEdit);
			PanelState.disabledComponents(pnlDelete);
			PanelState.enabledComponents(pnlView);
			PanelState.enabledComponents(pnlNew);
			PanelState.disabledComponents(pnlUI);

			resetAllCombo();

		}
		else if(bst.getButtonState()==ButtonState.InitialState)
		{

			PanelState.enabledComponents(pnlNew);
			PanelState.enabledComponents(pnlView);
			PanelState.enabledComponents(pnlCancel);
			PanelState.enabledComponents(pnlReport);
			PanelState.disabledComponents(pnlUpdate);
			PanelState.disabledComponents(pnlEdit);
			PanelState.disabledComponents(pnlDelete);
			PanelState.disabledComponents(pnlSave);
			PanelState.disabledComponents(pnlUI);
			PanelState.disabledComponents(pnlApply);

			PanelState.disabledComponents(pnlCombo1);
			PanelState.disabledComponents(pnlCombo2);

		}

		if(bst.getButtonCommonState()==ButtonState.ReportState)
		{
			PanelState.visibleComponents(pnlUIReport);
			PanelState.visibleComponents(pnlClose);    			//new
			//PanelState.disabledComponents(pnlEntry);
			PanelState.hideComponents(pnlUI);
			PanelState.hideComponents(pnlReport);

		}
		else if(bst.getButtonCommonState()==ButtonState.CloseReportState)
		{
			PanelState.visibleComponents(pnlUI);
			PanelState.hideComponents(pnlUIReport);
			PanelState.visibleComponents(pnlReport);
			PanelState.hideComponents(pnlClose);
			bst.setButtonCommonState(ButtonState.ResetState);
		}
	 }

	void rejectAction()
	 {
		if(bst.getButtonCommonState()==ButtonState.ReportState)
		{
			bst.setButtonCommonState(ButtonState.CloseReportState);
			showButtonsOnUI(bst);
		}
		else if(bst.getButtonState()==ButtonState.NewState)
		{
			bst.setButtonState(ButtonState.InitialState);
			showButtonsOnUI(bst);
		}
		else if(bst.getButtonState()==ButtonState.ViewState)
		{
			bst.setButtonState(ButtonState.InitialState);
			showButtonsOnUI(bst);
			resetAllCombo();
		}
		else if(bst.getButtonState()==ButtonState.ApplyState)
		{
			bst.setButtonState(ButtonState.ViewState);
			showButtonsOnUI(bst);

		}
		else if(bst.getButtonState()==ButtonState.EditState)
		{
			bst.setButtonState(ButtonState.ApplyState);
			showButtonsOnUI(bst);
		}
	 }
	void resetAllCombo()
	{
		cmbCombo1.removeAllItems();
		cmbCombo2.removeAllItems();

		cmbCombo1.addItem("No Records...");
		cmbCombo2.addItem("No Records...");

		lblCombo1=new JLabel("-----------------");
		lblCombo2=new JLabel("-----------------");

		PanelState.disabledComponents(pnlCombo1);
		PanelState.disabledComponents(pnlCombo2);

	}

}