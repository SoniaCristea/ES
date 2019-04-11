package gui_functionality;

import javax.swing.JButton;
import javax.swing.JTable;

import gui_swing.ResultsDialog;

public class ResultsDialogFunc {
	
	private ResultsDialog rd;
	private JTable table = new JTable();
	private JButton btnRun = new JButton();
	private JButton modifyTagsBtn = new JButton();
	private JButton clearBtn = new JButton();
	
	public ResultsDialogFunc(ResultsDialog rd){
		
		this.rd = rd;
		
		table = rd.getTable();
		btnRun = rd.getBtnRun();
		modifyTagsBtn = rd.getModifyTagsBtn();
		clearBtn = rd.getClearBtn();
		
		//TODO
	}

}
