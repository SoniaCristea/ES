package gui_functionality;

import javax.swing.JButton;
import javax.swing.JTable;

import gui_swing.TagDialog;

public class TagDialogFunc {
	
	private TagDialog td;
	private JButton addTagBtn = new JButton();
	private JTable table = new JTable();
	
	public TagDialogFunc(TagDialog td){
		
		this.td = td;
		addTagBtn = td.getAddTagBtn();
		table = td.getTagDialogTable();
		
		//TODO add functionality to them
		
	}

}
